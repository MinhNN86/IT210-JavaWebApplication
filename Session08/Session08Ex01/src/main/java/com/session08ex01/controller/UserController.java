package com.session08ex01.controller;

import com.session08ex01.dto.AddressDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class UserController {

    @PostMapping("/update")
    public ResponseEntity<String> updateAddress(@Valid @RequestBody AddressDto addressDto) {
        // Logic lưu database ở đây...
        // Nếu validation thất bại, Spring sẽ tự động throw MethodArgumentNotValidException
        // và trả về HTTP 400 Bad Request trước khi chạy tới dòng này.

        return ResponseEntity.ok("Cập nhật địa chỉ thành công!");
    }
}