package com.session07baitap.Ex03.controller;

import com.session07baitap.Ex03.model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {

    // 🔥 In-memory list
    private static List<Food> foodList = new ArrayList<>();

    // ===== HOME =====
    @GetMapping
    public String showFoodHome() {
        return "redirect:/food/add";
    }

    @GetMapping("/add")
    public String showForm() {
        return "Ex03/add";
    }

    @PostMapping("/add")
    public String addFood(
            @RequestParam String name,
            @RequestParam String category,
            @RequestParam double price,
            @RequestParam("image") MultipartFile file,
            Model model
    ) {
        // ❌ validate file empty
        if (file.isEmpty()) {
            model.addAttribute("error", "Chưa chọn ảnh!");
            return "Ex03/add";
        }

        // ❌ validate extension
        String fileName = file.getOriginalFilename();
        if (fileName == null ||
                !(fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".jpeg"))) {
            model.addAttribute("error", "File phải là ảnh!");
            return "Ex03/add";
        }

        // ❌ validate price
        if (price < 0) {
            model.addAttribute("error", "Giá phải >= 0!");
            return "Ex03/add";
        }

        try {
            // ✅ lưu file vào thư mục uploads/ trong project
            String uploadDir = System.getProperty("user.dir") + "/uploads/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File dest = new File(uploadDir + fileName);
            file.transferTo(dest);

            // ✅ tạo object
            Food food = new Food();
            food.setName(name);
            food.setCategory(category);
            food.setPrice(price);
            food.setImagePath(dest.getAbsolutePath());

            // ✅ add vào list
            foodList.add(food);

            // ✅ log
            System.out.println("Đã thêm: " + food.getName());
            System.out.println("Tổng món: " + foodList.size());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Ex03/add";
    }
}
