package com.session05baitap.bai5.service;

import com.session05baitap.bai2.common.model.Dish;

import java.util.List;

public interface OrderService {
    List<Dish> getMenu();
    double calculateTotal(List<Dish> dishes);
}
