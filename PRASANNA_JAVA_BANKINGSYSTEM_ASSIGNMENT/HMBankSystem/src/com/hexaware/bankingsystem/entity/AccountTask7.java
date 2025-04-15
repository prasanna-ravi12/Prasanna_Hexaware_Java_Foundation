package com.hexaware.bankingsystem.entity;

public class AccountTask7 {
    private int accountNumber;
    private String accountType;
    private double accountBalance;

    // Default constructor
    public AccountTask7() {
        System.out.println("Default AccountTask7 constructor called");
    }

    // Parameterized constructor
    public AccountTask7(int accountNumber, String accountType, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    // Getters and Setters
    public int getAccountNumber() { return accountNumber; }
    public void setAccountNumber(int accountNumber) { this.accountNumber = accountNumber; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public double getAccountBalance() { return accountBalance; }
    public void setAccountBalance(double accountBalance) { this.accountBalance = accountBalance; }

    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("✅ Deposited ₹" + amount + ". New balance: ₹" + accountBalance);
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("✅ Withdrawn ₹" + amount + ". Remaining balance: ₹" + accountBalance);
        } else {
            System.out.println("❌ Insufficient balance.");
        }
    }

    public void calculateInterest() {
        if (accountType.equalsIgnoreCase("Savings")) {
            double interest = (accountBalance * 4.5) / 100;
            accountBalance += interest;
            System.out.println("✅ Interest ₹" + interest + " added. New balance: ₹" + accountBalance);
        } else {
            System.out.println("ℹ️ Interest calculation only for Savings account.");
        }
    }

    public void printAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Balance: ₹" + accountBalance);
    }
}