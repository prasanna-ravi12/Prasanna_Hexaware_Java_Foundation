package com.hexaware.bankingsystem.entity;

public class CurrentAccountTask8 extends AccountTask8 { 
	private final double overdraftLimit = 10000.0;
	
	public CurrentAccountTask8(int accountNumber, double balance) {
	    super(accountNumber, "Current", balance);
	}

	@Override
	public void withdraw(double amount) {
	    if (balance + overdraftLimit >= amount) {
	        balance -= amount;
	        System.out.println("Withdrawn: ₹" + amount);
	    } else {
	        System.out.println("Cannot withdraw ₹" + amount + ". Overdraft limit exceeded.");
	    }
	}

	@Override
	public void calculateInterest() {
	    System.out.println("No interest for current account.");
	}
	}
	
	
	


