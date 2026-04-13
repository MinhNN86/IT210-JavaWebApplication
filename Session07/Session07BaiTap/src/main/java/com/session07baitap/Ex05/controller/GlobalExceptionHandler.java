package com.session07baitap.Ex05.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global Exception Handler - Bắt các ngoại lệ toàn cục của ứng dụng.
 * Sử dụng @ControllerAdvice để xử lý lỗi hệ thống tập trung.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Bắt IllegalStateException khi upload file vượt quá dung lượng cho phép.
     * Tomcat ném IllegalStateException khi file size vượt maxFileSize hoặc maxRequestSize.
     */
    @ExceptionHandler(IllegalStateException.class)
    public String handleFileSizeExceeded(IllegalStateException ex, Model model) {
        String message = ex.getMessage();
        if (message != null && message.contains("exceeds maximum size")) {
            model.addAttribute("error", "File quá lớn! Vui lòng upload file có dung lượng không vượt quá 10MB.");
        } else {
            model.addAttribute("error", "Lỗi hệ thống: " + message);
        }
        return "Ex05/error";
    }

    /**
     * Bắt tất cả các ngoại lệ khác chưa được xử lý.
     */
    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception ex, Model model) {
        model.addAttribute("error", "Lỗi hệ thống: " + ex.getMessage());
        return "Ex05/error";
    }
}
