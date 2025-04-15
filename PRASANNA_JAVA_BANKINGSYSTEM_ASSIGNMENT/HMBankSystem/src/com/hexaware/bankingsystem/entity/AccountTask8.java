package com.hexaware.bankingsystem.entity;

public class AccountTask8 { 
	protected int accountNumber; 
	protected String accountType; 
	protected double balance;
	
	public AccountTask8() {}

	public AccountTask8(int accountNumber, String accountType, double balance) {
	    this.accountNumber = accountNumber;
	    this.accountType = accountType;
	    this.balance = balance;
	}

	// Deposit Overloading
	public void deposit(float amount) {
	    balance += amount;
	    System.out.println("Deposited: ₹" + amount);
	}

	public void deposit(int amount) {
	    balance += amount;
	    System.out.println("Deposited: ₹" + amount);
	}

	public void deposit(double amount) {
	    balance += amount;
	    System.out.println("Deposited: ₹" + amount);
	}

	// Withdraw Overloading
	public void withdraw(float amount) {
	    if (balance >= amount) {
	        balance -= amount;
	        System.out.println("Withdrawn: ₹" + amount);
	    } else {
	        System.out.println("Insufficient balance.");
	    }
	}

	public void withdraw(int amount) {
	    if (balance >= amount) {
	        balance -= amount;
	        System.out.println("Withdrawn: ₹" + amount);
	    } else {
	        System.out.println("Insufficient balance.");
	    }
	}

	public void withdraw(double amount) {
	    if (balance >= amount) {
	        balance -= amount;
	        System.out.println("Withdrawn: ₹" + amount);
	    } else {
	        System.out.println("Insufficient balance.");
	    }
	}

	public void calculateInterest() {
	    System.out.println("No interest calculated in base Account.");
	}

	public void showAccountDetails() {
	    System.out.println("Account No: " + accountNumber);
	    System.out.println("Type: " + accountType);
	    System.out.println("Balance: ₹" + balance);
	}
	}

