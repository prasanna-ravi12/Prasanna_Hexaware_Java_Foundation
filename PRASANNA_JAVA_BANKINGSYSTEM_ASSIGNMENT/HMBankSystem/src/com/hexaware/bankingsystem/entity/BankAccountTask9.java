package com.hexaware.bankingsystem.entity;

public abstract class BankAccountTask9 { 
	protected int accountNumber; protected String customerName; 
	protected double balance;

	// Default constructor
	public BankAccountTask9() {
	    System.out.println("Default BankAccount constructor called");
	}

	// Parameterized constructor
	public BankAccountTask9(int accountNumber, String customerName, double balance) {
	    this.accountNumber = accountNumber;
	    this.customerName = customerName;
	    this.balance = balance;
	}

	// Getters and Setters
	public int getAccountNumber() { return accountNumber; }
	public void setAccountNumber(int accountNumber) { this.accountNumber = accountNumber; }

	public String getCustomerName() { return customerName; }
	public void setCustomerName(String customerName) { this.customerName = customerName; }

	public double getBalance() { return balance; }
	public void setBalance(double balance) { this.balance = balance; }

	public void printAccountDetails() {
	    System.out.println("Account Number: " + accountNumber);
	    System.out.println("Customer Name: " + customerName);
	    System.out.println("Balance: ₹" + balance);
	}

	// Abstract methods
	public abstract void deposit(float amount);
	public abstract void withdraw(float amount);
	public abstract void calculateInterest();
	}
