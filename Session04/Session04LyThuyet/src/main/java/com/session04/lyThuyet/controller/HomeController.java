package com.session04.lyThuyet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller // Tạo bean và chỉ định đây là tầng controller
public class HomeController {
    @RequestMapping("/home") // tiếp nhận và xử lý request theo method GET với đường dẫn
    public String homeView(){
        return "home-page"; // trả về giao diện home-page.jsp
    }

    // Phương thức xủ lý theo get
    @GetMapping("/list-products") // lấy danh sách sản phẩm
    public String listProducts(){
        return "list-product";
    }

    // phương thức xử lý theo post
    @PostMapping(value = "/form")
    public String formProduct(
            // Nhận tham số
    ){
        return "redirect:/list-products";
    }

    // Lấy dữ liệu thông qua get
    @GetMapping("/search")
    public String search(@RequestParam("key") String name){
        // nếu truy cập url: /search?key=Nam
        // name = Nam
        return "search";
    }

    @GetMapping("/path/{key}")
    public String path(@PathVariable("key") String name){
        // nếu truy cập url: /path/Nam
        // name = Nam
        return "search";
    }


    @GetMapping("/model")
    public String viewModel(Model model){
        model.addAttribute("name", "Nguyen Van A");
        model.addAttribute("age", 18);

        return "result";
    }

    @GetMapping("/model-map")
    public String viewModelMap(ModelMap modelMap){
        modelMap.put("name", "Nguyen Van A");
        modelMap.put("age", 18);
        return "result";
    }

    @GetMapping("/model-and-view")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("result"); // tương tự return của model

        modelAndView.addObject("name", "Nguyen Van A");
        modelAndView.addObject("age", 18);
        return modelAndView;

    }
}
