package com.session07baitap.Ex04.controller;

import com.session07baitap.Ex04.model.Food;
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

@Controller("ex04FoodController")
@RequestMapping("/ex04/food")
public class FoodController {

    // 🔥 In-memory list
    private static List<Food> foodList = new ArrayList<>();

    // ===== HOME =====
    @GetMapping
    public String showFoodHome() {
        return "redirect:/ex04/food/add";
    }

    // ===== SHOW ADD FORM =====
    @GetMapping("/add")
    public String showForm() {
        return "Ex04/add";
    }

    // ===== ADD FOOD =====
    @PostMapping("/add")
    public String addFood(
            @RequestParam String name,
            @RequestParam String category,
            @RequestParam double price,
            @RequestParam("image") MultipartFile file,
            Model model,
            HttpServletRequest request
    ) {
        // ❌ validate file empty
        if (file.isEmpty()) {
            model.addAttribute("error", "Chưa chọn ảnh!");
            return "Ex04/add";
        }

        // ❌ validate extension
        String originalFileName = file.getOriginalFilename();
        if (originalFileName == null ||
                !(originalFileName.endsWith(".jpg") || originalFileName.endsWith(".png") || originalFileName.endsWith(".jpeg"))) {
            model.addAttribute("error", "File phải là ảnh (jpg, png, jpeg)!");
            return "Ex04/add";
        }

        // ❌ validate price
        if (price < 0) {
            model.addAttribute("error", "Giá phải >= 0!");
            return "Ex04/add";
        }

        try {
            // ✅ tính đường dẫn project root từ deployed WAR path
            // realPath = .../Session07BaiTap/build/libs/exploded/Session07BaiTap-1.0-SNAPSHOT.war/
            String realPath = request.getServletContext().getRealPath("/");
            File warDir = new File(realPath);
            // Navigate up: war -> exploded -> libs -> build -> projectRoot
            File projectRoot = warDir.getParentFile().getParentFile().getParentFile().getParentFile();

            // ✅ đổi tên file theo quy tắc: [timestamp]_[tên gốc] để tránh ghi đè
            String timestamp = String.valueOf(System.currentTimeMillis());
            String newFileName = timestamp + "_" + originalFileName;

            // ✅ lưu vào thư mục source (src/main/webapp/uploads/)
            String sourceUploadDir = projectRoot.getAbsolutePath() + "/src/main/webapp/uploads/";
            File sourceDir = new File(sourceUploadDir);
            if (!sourceDir.exists()) {
                sourceDir.mkdirs();
            }
            File sourceDest = new File(sourceDir, newFileName);
            file.transferTo(sourceDest);

            // ✅ cũng lưu vào deployed WAR để hiển thị ảnh qua web
            String deployedUploadDir = realPath + "uploads/";
            File deployedDir = new File(deployedUploadDir);
            if (!deployedDir.exists()) {
                deployedDir.mkdirs();
            }
            File deployedDest = new File(deployedDir, newFileName);
            Files.copy(sourceDest.toPath(), deployedDest.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // ✅ tạo object
            Food food = new Food();
            food.setName(name);
            food.setCategory(category);
            food.setPrice(price);
            food.setImagePath(sourceDest.getAbsolutePath());

            // ✅ add vào list
            foodList.add(food);

            // ✅ truyền sang trang chi tiết (bao gồm URL ảnh)
            model.addAttribute("food", food);
            model.addAttribute("imageUrl", "/uploads/" + newFileName);
            return "Ex04/detail";

        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi lưu file: " + e.getMessage());
            return "Ex04/add";
        }
    }
}
