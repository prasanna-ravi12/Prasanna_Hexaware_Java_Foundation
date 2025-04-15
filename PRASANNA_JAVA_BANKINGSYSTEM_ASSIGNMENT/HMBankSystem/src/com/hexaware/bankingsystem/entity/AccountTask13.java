package com.hexaware.bankingsystem.entity;

public class AccountTask13 {
    protected String accountNumber;
    protected String holderName;
    protected double balance;
    protected boolean isCurrentAccount;

    public AccountTask13(String accountNumber, String holderName, double balance, boolean isCurrentAccount) {
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

    // Getters and Setters
    public String getHolderName() {
        return holderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // Override equals and hashCode for comparing Account objects in Set
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AccountTask13 account = (AccountTask13) obj;
        return accountNumber.equals(account.accountNumber);
    }

    @Override
    public int hashCode() {
        return accountNumber.hashCode();
    }
}
