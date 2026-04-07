package com.example.Session01.ThucHanh;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PlaySessionService {

    private final AlertService alertService;

    // DI bằng constructor
    public PlaySessionService(@Qualifier("popup") AlertService alertService) {
        this.alertService = alertService;
    }

    public void checkBalance(String username, double balance) {

        if (username == null || username.trim().isEmpty()) {
            System.out.println("Username không hợp lệ");
            return;
        }

        if (balance < 0) {
            System.out.println("Balance không hợp lệ");
            return;
        }

        if (balance < 5000) {
            alertService.alert(username, balance);
        } else {
            System.out.println("Tài khoản vẫn đủ tiền");
        }
    }
}
