package com.session05baitap.bai5.repository;

import com.session05baitap.bai2.common.model.Dish;

import java.util.List;

public interface OrderRepository {
    List<Dish> findAll();
}
