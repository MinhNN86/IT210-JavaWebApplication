package com.example.Session01.Ex03;

public interface InventoryRepository {
    int getStock(String foodName);
    void decreaseStock(String foodName, int quantity);
}