package com.hexaware.bankingsystem.entity;

public class AccountTask14 { protected int accountId; protected int customerId; protected String accountType; protected double balance;


public AccountTask14() {}

public AccountTask14(int accountId, int customerId, String accountType, double balance) {
    this.accountId = accountId;
    this.customerId = customerId;
    this.accountType = accountType;
    this.balance = balance;
}

public int getAccountId() { return accountId; }
public void setAccountId(int accountId) { this.accountId = accountId; }

public int getCustomerId() { return customerId; }
public void setCustomerId(int customerId) { this.customerId = customerId; }

public String getAccountType() { return accountType; }
public void setAccountType(String accountType) { this.accountType = accountType; }

public double getBalance() { return balance; }
public void setBalance(double balance) { this.balance = balance; }
}