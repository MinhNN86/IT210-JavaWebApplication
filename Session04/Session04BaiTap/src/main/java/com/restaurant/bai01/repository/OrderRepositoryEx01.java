package com.restaurant.bai01.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryEx01 {

    public String getAllOrders() {
        return "Danh sach toan bo don hang";
    }

    public String getOrderById(Long id) {
        return "Thong tin don hang voi ID: " + id;
    }
}
