package com.hexaware.bankingsystem.entity;

public class CurrentAccountTask14 extends AccountTask14 { private final double overdraftLimit = 1000.0;


public CurrentAccountTask14(int accountId, int customerId, double balance) {
    super(accountId, customerId, "current", balance);
}

public double getOverdraftLimit() {
    return overdraftLimit;
}
}