package com.hexaware.bankingsystem.entity;

public class CurrentAccountTask9 extends BankAccountTask9 { 
	private final double overdraftLimit = 10000.0;
	public CurrentAccountTask9(int accountNumber, String customerName, double balance) {
	    super(accountNumber, customerName, balance);
	}

	@Override
	public void deposit(float amount) {
	    if (amount > 0) {
	        balance += amount;
	        System.out.println("✅ Deposited ₹" + amount + " into Current Account");
	    } else {
	        System.out.println("❌ Invalid deposit amount.");
	    }
	}

	@Override
	public void withdraw(float amount) {
	    if (balance + overdraftLimit >= amount) {
	        balance -= amount;
	        System.out.println("✅ Withdrawn ₹" + amount + " from Current Account (including overdraft)");
	    } else {
	        System.out.println("❌ Overdraft limit exceeded in Current Account.");
	    }
	}

	@Override
	public void calculateInterest() {
	    System.out.println("ℹ️ No interest for Current Account.");
	}
	}

