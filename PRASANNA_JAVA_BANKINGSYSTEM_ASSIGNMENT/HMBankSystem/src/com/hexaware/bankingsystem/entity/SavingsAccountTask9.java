package com.hexaware.bankingsystem.entity;

public class SavingsAccountTask9 extends BankAccountTask9 { 
	private double interestRate = 4.5; // fixed interest
	public SavingsAccountTask9(int accountNumber, String customerName, double balance) {
	    super(accountNumber, customerName, balance);
	}

	@Override
	public void deposit(float amount) {
	    if (amount > 0) {
	        balance += amount;
	        System.out.println("✅ Deposited ₹" + amount + " into Savings Account");
	    } else {
	        System.out.println("❌ Invalid deposit amount.");
	    }
	}

	@Override
	public void withdraw(float amount) {
	    if (amount <= balance) {
	        balance -= amount;
	        System.out.println("✅ Withdrawn ₹" + amount + " from Savings Account");
	    } else {
	        System.out.println("❌ Insufficient balance in Savings Account.");
	    }
	}

	@Override
	public void calculateInterest() {
	    double interest = (balance * interestRate) / 100;
	    balance += interest;
	    System.out.println("✅ Interest ₹" + interest + " added to Savings Account");
	}


}