package com.restaurant.bai05.controller;

import com.restaurant.bai05.service.OrderServiceEx05;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai5/orders")
public class OrderControllerEx05 {

    private final OrderServiceEx05 orderService;

    public OrderControllerEx05(OrderServiceEx05 orderService) {
        this.orderService = orderService;
    }

    // GET - xem đơn hàng
    @GetMapping("/{id}")
    @ResponseBody
    public String getOrder(@PathVariable String id) {
        try {
            Long orderId = Long.parseLong(id);
            return orderService.getOrder(orderId);
        } catch (Exception e) {
            return "ID don hang phai la so";
        }
    }

    // POST - tạo đơn
    @PostMapping
    @ResponseBody
    public String createOrder() {
        return orderService.createOrder();
    }

    // DELETE - hủy đơn
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }
}
