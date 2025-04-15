package com.hexaware.bankingsystem.entity;

public class AccountTask11 {
    protected static long lastAccNo = 1000;
    protected long accountNumber;
    protected String accountType;
    public float balance;
    protected CustomerTask11 customer;

    public AccountTask11() {}

    public AccountTask11(String accountType, float balance, CustomerTask11 customer) {
        this.accountNumber = ++lastAccNo;
        this.accountType = accountType;
        this.balance = balance;
        this.customer = customer;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void printAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
        customer.printCustomerDetails();
    }
}
