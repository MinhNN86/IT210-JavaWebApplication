package com.restaurant.bai01.controller;

import com.restaurant.bai01.service.OrderServiceEx01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bai1/orders")
public class LegacyControllerEx01 {

    private final OrderServiceEx01 orderServiceEx01;

    // Constructor Injection
    @Autowired
    public LegacyControllerEx01(OrderServiceEx01 orderServiceEx01) {
        this.orderServiceEx01 = orderServiceEx01;
    }

    @GetMapping
    @ResponseBody
    public String getAllOrders() {
        return orderServiceEx01.getAllOrders();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getOrderById(@PathVariable Long id) {
        return orderServiceEx01.getOrderById(id);
    }
}
