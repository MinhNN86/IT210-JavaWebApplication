package com.session05baitap.bai5.repository.impl;


import com.session05baitap.bai2.common.model.Dish;
import com.session05baitap.bai5.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public List<Dish> findAll() {
        return Arrays.asList(
                new Dish(1L, "Phở bò", 50000, true),
                new Dish(2L, "Bún chả", 45000, true),
                new Dish(3L, "Cơm tấm", 40000, false)
        );
    }
}