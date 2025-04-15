package com.hexaware.bankingsystem.entity;

public class SavingsAccountTask14 extends AccountTask14 { private final double interestRate = 4.5;

public SavingsAccountTask14(int accountId, int customerId, double balance) {
    super(accountId, customerId, "savings", balance >= 500 ? balance : 500);
}

public double calculateInterest() {
    return balance * (interestRate / 100);
}

public double getInterestRate() {
    return interestRate;
}
}