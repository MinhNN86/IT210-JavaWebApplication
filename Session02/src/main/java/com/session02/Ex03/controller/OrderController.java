package com.session02.Ex03.controller;


import com.session02.Ex03.model.Order;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class OrderController {

    @GetMapping("/ordersEx03")
    public String showOrders(HttpSession session,
                             Model model,
                             ServletContext application) {

        // ❗ chưa login → redirect
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/loginEx03";
        }

        // fake data
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("OD01", "Laptop", 15000000, new Date()));
        orders.add(new Order("OD02", "Chuột", 300000, new Date()));
        orders.add(new Order("OD03", "Bàn phím", 700000, new Date()));

        model.addAttribute("orders", orders);

        // ✅ FIX Race Condition
        synchronized (application) {
            Integer count = (Integer) application.getAttribute("totalViewCount");
            if (count == null) count = 0;
            count++;
            application.setAttribute("totalViewCount", count);
        }

        return "ordersEx03";
    }
}