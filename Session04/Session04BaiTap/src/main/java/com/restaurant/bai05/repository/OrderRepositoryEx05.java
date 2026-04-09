package com.restaurant.bai05.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryEx05 {

    public String findById(Long id) {
        return "Thong tin don hang: " + id;
    }

    public String save() {
        return "Tao don hang thanh cong";
    }

    public String deleteById(Long id) {
        return "Da huy don hang: " + id;
    }
}
