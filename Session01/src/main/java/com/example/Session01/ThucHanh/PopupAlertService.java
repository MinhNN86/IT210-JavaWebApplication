package com.example.Session01.ThucHanh;

import org.springframework.stereotype.Component;

@Component("popup")
public class PopupAlertService implements AlertService{

    @Override
    public void alert(String username, double balance) {
        System.out.println("[POPUP] Tài khoản " + username + " sắp hết tiền: " + balance);
    }
}
