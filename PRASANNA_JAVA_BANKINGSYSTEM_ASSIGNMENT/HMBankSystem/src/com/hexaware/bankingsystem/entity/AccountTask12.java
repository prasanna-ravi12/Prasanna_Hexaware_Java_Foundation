package com.hexaware.bankingsystem.entity;

public class AccountTask12 {
    public String accountNumber;
    protected String holderName;
    protected double balance;
    protected boolean isCurrentAccount;

    public AccountTask12(String accountNumber, String holderName, double balance, boolean isCurrentAccount) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.isCurrentAccount = isCurrentAccount;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void display() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
        System.out.println("Account Type: " + (isCurrentAccount ? "Current" : "Savings"));
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public boolean isCurrentAccount() {
        return isCurrentAccount;
    }
}
