package com.session07baitap.Ex01.controller;

import com.session07baitap.Ex01.model.RestaurantProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("restaurant", new RestaurantProfile());
        return "form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("restaurant") RestaurantProfile restaurant) {
        System.out.println("Name: " + restaurant.getRestaurantName());
        System.out.println("Phone: " + restaurant.getPhoneNumber());
        System.out.println("Active: " + restaurant.isActive());

        return "form"; // quay lại form
    }
}
