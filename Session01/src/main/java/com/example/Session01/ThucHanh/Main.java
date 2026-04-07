package com.example.Session01.ThucHanh;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        PlaySessionService service = context.getBean(PlaySessionService.class);

        // test
        service.checkBalance("minh", 3000);
        service.checkBalance("minh", 10000);
        service.checkBalance("", 3000);
        service.checkBalance("minh", -100);

        context.close();
    }
}
