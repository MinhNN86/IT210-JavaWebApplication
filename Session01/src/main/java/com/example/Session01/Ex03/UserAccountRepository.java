package com.example.Session01.Ex03;

public interface UserAccountRepository {
    double getBalance(String username);
    void deductBalance(String username, double amount);
}
