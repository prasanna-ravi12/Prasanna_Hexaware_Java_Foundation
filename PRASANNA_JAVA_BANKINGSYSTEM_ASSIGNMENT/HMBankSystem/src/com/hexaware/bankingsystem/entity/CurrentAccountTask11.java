package com.hexaware.bankingsystem.entity;

public class CurrentAccountTask11 extends AccountTask11 {
    private float overdraftLimit = 1000;

    public CurrentAccountTask11(float balance, CustomerTask11 customer) {
        super("Current", balance, customer);
    }

    public boolean withdraw(float amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}
