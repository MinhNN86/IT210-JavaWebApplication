package com.session05baitap.bai3.service.impl;


import com.session05baitap.bai2.common.model.Dish;
import com.session05baitap.bai3.service.AdminDishService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminDishServiceImpl implements AdminDishService {

    private static final List<Dish> dishes = new ArrayList<>();

    static {
        dishes.add(new Dish(1L, "Phở bò", 50000, true));
        dishes.add(new Dish(2L, "Bún chả", 45000, false));
        dishes.add(new Dish(3L, "Cơm tấm", 40000, true));
    }

    @Override
    public Dish findById(Long id) {
        return dishes.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
