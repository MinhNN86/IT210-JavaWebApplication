package com.session05baitap.bai3.controller;


import com.session05baitap.bai2.common.model.Dish;
import com.session05baitap.bai3.service.AdminDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai3")
public class AdminDishController {

    @Autowired
    private AdminDishService service;

    // 👉 Trang edit
    @GetMapping("/edit/{id}")
    public String editDish(@PathVariable Long id, Model model) {
        Dish dish = service.findById(id);

        if (dish == null) {
            model.addAttribute("error", "Không tìm thấy món ăn yêu cầu!");
            return "redirect:/bai2/dishes";
        }

        model.addAttribute("dish", dish);
        return "edit-dish";
    }

    @PostMapping("/update")
    public String updateDish(@ModelAttribute Dish dish) {
        // giả lập update
        System.out.println("Updated: " + dish.getName());

        return "redirect:/bai2/dishes";
    }
}
