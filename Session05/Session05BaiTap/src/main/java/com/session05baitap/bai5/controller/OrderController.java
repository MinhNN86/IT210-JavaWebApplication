package com.session05baitap.bai5.controller;


import com.session05baitap.bai2.common.model.Dish;
import com.session05baitap.bai5.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bai5")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/order")
    public String orderPage(Model model) {
        List<Dish> dishes = service.getMenu();

        model.addAttribute("dishes", dishes);
        model.addAttribute("total", service.calculateTotal(dishes));

        return "order";
    }

    // ❗ xử lý ngoại lệ demo
    @GetMapping("/dish/{id}")
    public String getDish(@PathVariable Long id, Model model) {
        List<Dish> dishes = service.getMenu();

        Dish found = dishes.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (found == null) {
            model.addAttribute("error", "Không tìm thấy món ăn!");
            return "redirect:/bai5/order";
        }

        model.addAttribute("dish", found);
        return "dish-detail";
    }
}