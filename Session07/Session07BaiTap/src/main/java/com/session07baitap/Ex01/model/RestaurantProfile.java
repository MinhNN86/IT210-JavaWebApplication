package com.session07baitap.Ex01.model;

public class RestaurantProfile {
    private String restaurantName;
    private String phoneNumber;
    private boolean active;

    public RestaurantProfile(String restaurantName, String phoneNumber, boolean active) {
        this.restaurantName = restaurantName;
        this.phoneNumber = phoneNumber;
        this.active = active;
    }

    public RestaurantProfile() {
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
