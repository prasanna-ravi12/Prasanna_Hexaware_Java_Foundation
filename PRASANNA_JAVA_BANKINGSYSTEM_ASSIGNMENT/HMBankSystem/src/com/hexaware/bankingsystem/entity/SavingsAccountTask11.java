package com.hexaware.bankingsystem.entity;

public class SavingsAccountTask11 extends AccountTask11 {
    private float interestRate = 4.5f;

    public SavingsAccountTask11(float balance, CustomerTask11 customer) {
        super("Savings", balance >= 500 ? balance : 500, customer);
    }

    public float calculateInterest() {
        return balance * (interestRate / 100);
    }
}
