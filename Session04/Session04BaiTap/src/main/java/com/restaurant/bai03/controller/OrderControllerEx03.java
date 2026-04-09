package com.restaurant.bai03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai3/orders")
public class OrderControllerEx03 {
    @GetMapping("/{id}")
    @ResponseBody
    public String getOrderById(@PathVariable Long id) {
        return "Chi tiet don hang so " + id;
    }
}
