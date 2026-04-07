package com.example.Session01.Ex02;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@ComponentScan
@Scope("prototype")
public class PlaySession {
    private double playTime = 0;

    public void addTime(double time) {
        this.playTime += time;
    }
}