package com.session05baitap.bai5.service.impl;



import com.session05baitap.bai2.common.model.Dish;
import com.session05baitap.bai5.repository.OrderRepository;
import com.session05baitap.bai5.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public List<Dish> getMenu() {
        return repository.findAll();
    }

    @Override
    public double calculateTotal(List<Dish> dishes) {
        return dishes.stream()
                .mapToDouble(Dish::getPrice)
                .sum();
    }
}
