package com.hexaware.bankingsystem.dao;

public interface IBankServiceProvider {
    void createAccount(int type, String firstName, String lastName, String email, String phone, String address, float balance);
    void listAccounts();
    void calculateInterest();
}
