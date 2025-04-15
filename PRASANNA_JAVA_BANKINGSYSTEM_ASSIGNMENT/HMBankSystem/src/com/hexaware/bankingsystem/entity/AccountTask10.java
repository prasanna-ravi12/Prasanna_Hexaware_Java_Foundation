package com.hexaware.bankingsystem.entity;

public class AccountTask10 {
    private static long accountNumberGenerator = 1000;

    private long accountNumber;
    private String accountType;
    private float balance;
    private CustomerTask10 customer;

    public AccountTask10() {
        this.accountNumber = ++accountNumberGenerator;
    }

    public AccountTask10(String accountType, float balance, CustomerTask10 customer) {
        this.accountNumber = ++accountNumberGenerator;
        this.accountType = accountType;
        this.balance = balance;
        this.customer = customer;
    }

    public long getAccountNumber() { return accountNumber; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public float getBalance() { return balance; }
    public void setBalance(float balance) { this.balance = balance; }

    public CustomerTask10 getCustomer() { return customer; }
    public void setCustomer(CustomerTask10 customer) { this.customer = customer; }

    public void deposit(float amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(float amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void printAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
        customer.printCustomerDetails();
    }
}
