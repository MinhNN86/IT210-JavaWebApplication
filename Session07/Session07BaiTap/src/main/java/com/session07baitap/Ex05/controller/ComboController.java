package com.session07baitap.Ex05.controller;

import com.session07baitap.Ex05.model.Combo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Controller("ex05ComboController")
@RequestMapping("/ex05/combo")
public class ComboController {

    // 🔥 Static list lưu dữ liệu Combo
    private static final List<Combo> comboList = new ArrayList<>();

    // ===== HOME =====
    @GetMapping
    public String showComboHome() {
        return "redirect:/ex05/combo/add";
    }

    // ===== SHOW ADD FORM =====
    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("comboList", comboList);
        return "Ex05/add";
    }

    // ===== ADD COMBO =====
    @PostMapping("/add")
    public String addCombo(
            @RequestParam String name,
            @RequestParam("items") List<String> itemList,
            @RequestParam("banner") MultipartFile banner,
            Model model,
            HttpServletRequest request
    ) {
        // ❌ Validate: Combo phải có ít nhất 2 món
        if (itemList == null || itemList.size() < 2) {
            model.addAttribute("error", "Combo phải có ít nhất 2 món!");
            model.addAttribute("comboList", comboList);
            return "Ex05/add";
        }

        // ❌ Validate: Banner không được để trống
        if (banner.isEmpty()) {
            model.addAttribute("error", "Vui lòng chọn banner cho combo!");
            model.addAttribute("comboList", comboList);
            return "Ex05/add";
        }

        try {
            // ✅ Xử lý upload banner
            String originalFileName = banner.getOriginalFilename();
            String realPath = request.getServletContext().getRealPath("/");
            File warDir = new File(realPath);
            File projectRoot = warDir.getParentFile().getParentFile().getParentFile().getParentFile();

            String timestamp = String.valueOf(System.currentTimeMillis());
            String newFileName = timestamp + "_" + originalFileName;

            // Lưu vào source directory
            String sourceUploadDir = projectRoot.getAbsolutePath() + "/src/main/webapp/uploads/";
            File sourceDir = new File(sourceUploadDir);
            if (!sourceDir.exists()) {
                sourceDir.mkdirs();
            }
            File sourceDest = new File(sourceDir, newFileName);
            banner.transferTo(sourceDest);

            // Copy vào deployed WAR
            String deployedUploadDir = realPath + "uploads/";
            File deployedDir = new File(deployedUploadDir);
            if (!deployedDir.exists()) {
                deployedDir.mkdirs();
            }
            File deployedDest = new File(deployedDir, newFileName);
            Files.copy(sourceDest.toPath(), deployedDest.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // ✅ Tạo Combo object
            Combo combo = new Combo();
            combo.setName(name);
            combo.setItemList(itemList);
            combo.setBannerPath("/uploads/" + newFileName);

            // ✅ Thêm vào static list
            comboList.add(combo);

            // ✅ In kết quả combo ra console dạng JSON
            System.out.println("===== COMBO CREATED (JSON) =====");
            System.out.println(combo.toJson());
            System.out.println("================================");

            model.addAttribute("message", "Tạo combo thành công!");
            model.addAttribute("combo", combo);
            model.addAttribute("comboList", comboList);
            return "Ex05/add";

        } catch (IOException e) {
            model.addAttribute("error", "Lỗi khi lưu file: " + e.getMessage());
            model.addAttribute("comboList", comboList);
            return "Ex05/add";
        }
    }
}
