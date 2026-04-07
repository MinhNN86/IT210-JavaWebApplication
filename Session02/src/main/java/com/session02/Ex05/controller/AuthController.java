package com.session02.Ex05.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() { return "login"; }

    @PostMapping("/login")
    public String login(String username, String password,
                        HttpSession session, Model model) {

        if ((username.equals("hr_manager") && password.equals("hr123")) ||
                (username.equals("hr_staff") && password.equals("staff456"))) {

            session.setAttribute("loggedUser", username);
            session.setAttribute("role", username);
            return "redirect:/employees";
        }

        model.addAttribute("errorMessage", "Sai tài khoản");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession s) {
        s.invalidate();
        return "redirect:/login";
    }
}
