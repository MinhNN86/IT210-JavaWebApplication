package com.session07baitap.Ex02.comtroller;

import com.session07baitap.Ex02.model.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dish")
public class DishController {

    // ✅ CHỈ VIẾT 1 LẦN
    @ModelAttribute("categories")
    public List<String> getCategories() {
        return List.of(
                "Món chính",
                "Đồ uống",
                "Tráng miệng",
                "Topping"
        );
    }

    // ===== HOME =====
    @GetMapping
    public String showDishHome() {
        return "redirect:/dish/add";
    }

    // ===== ADD =====
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("dish", new Dish());
        return "add";
    }

    // ===== EDIT =====
    @GetMapping("/edit")
    public String showEditForm(Model model) {
        Dish dish = new Dish();
        dish.setName("Cà phê");
        dish.setCategory("Đồ uống");

        model.addAttribute("dish", dish);
        return "edit";
    }

    // ===== SEARCH =====
    @GetMapping("/search")
    public String showSearchForm(Model model) {
        model.addAttribute("dish", new Dish());
        return "search";
    }
}
