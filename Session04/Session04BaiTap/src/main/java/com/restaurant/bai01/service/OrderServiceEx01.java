package com.restaurant.bai01.service;

import com.restaurant.bai01.repository.OrderRepositoryEx01;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceEx01 {

    private final OrderRepositoryEx01 orderRepositoryEx01;

    // Constructor Injection
    public OrderServiceEx01(OrderRepositoryEx01 orderRepositoryEx01) {
        this.orderRepositoryEx01 = orderRepositoryEx01;
    }

    public String getAllOrders() {
        return orderRepositoryEx01.getAllOrders();
    }

    public String getOrderById(Long id) {
        return orderRepositoryEx01.getOrderById(id);
    }
}
