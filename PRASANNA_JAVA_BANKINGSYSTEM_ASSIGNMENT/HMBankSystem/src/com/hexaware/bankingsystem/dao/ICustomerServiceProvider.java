package com.hexaware.bankingsystem.dao;

public interface ICustomerServiceProvider {
    float getAccountBalance(long accountNumber);
    float deposit(long accountNumber, float amount);
    float withdraw(long accountNumber, float amount);
    void transfer(long fromAcc, long toAcc, float amount);
    void getAccountDetails(long accountNumber);
}
