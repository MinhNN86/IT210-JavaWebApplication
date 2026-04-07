package com.session02.Ex03.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @GetMapping("/loginEx03")
    public String showLogin() {
        return "loginEx03";
    }

    @PostMapping("/loginEx03")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        if ((username.equals("admin") && password.equals("admin123")) ||
                (username.equals("staff") && password.equals("staff123"))) {

            session.setAttribute("loggedUser", username);
            session.setAttribute("role", username.equals("admin") ? "ADMIN" : "STAFF");

            return "redirect:/ordersEx03";
        }

        // ❗ request scope (không dùng session)
        model.addAttribute("error", "Sai tài khoản hoặc mật khẩu");
        return "loginEx03";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/loginEx03";
    }
}