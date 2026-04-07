package com.example.Session01.ThucHanh;

import org.springframework.stereotype.Component;

@Component("sound")
public class SoundAlertService implements AlertService {

    @Override
    public void alert(String username, double balance) {
        System.out.println("[SOUND] Cảnh báo qua tai nghe cho " + username + ": " + balance);
    }
}