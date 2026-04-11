package com.session05baitap.bai2.service.impl;

import com.session05baitap.bai2.common.model.Dish;
import com.session05baitap.bai2.service.DishService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Override
    public List<Dish> getAllDishes() {
        List<Dish> list = new ArrayList<>();

        list.add(new Dish(1L, "Phở bò", 50000, true));
        list.add(new Dish(2L, "Bún chả", 45000, false));
        list.add(new Dish(3L, "Cơm tấm", 40000, true));

        return list;
    }
}
