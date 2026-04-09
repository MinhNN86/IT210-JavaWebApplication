package com.restaurant.bai05.service;

import com.restaurant.bai05.repository.OrderRepositoryEx05;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceEx05 {

    private final OrderRepositoryEx05 orderRepository;

    public OrderServiceEx05(OrderRepositoryEx05 orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String getOrder(Long id) {
        return orderRepository.findById(id);
    }

    public String createOrder() {
        return orderRepository.save();
    }

    public String deleteOrder(Long id) {
        return orderRepository.deleteById(id);
    }
}
