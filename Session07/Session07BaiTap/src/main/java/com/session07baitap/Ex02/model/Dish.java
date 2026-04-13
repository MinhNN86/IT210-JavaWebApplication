package com.session07baitap.Ex02.model;

public class Dish {
    private String name;
    private String category;

    public Dish(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Dish() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
