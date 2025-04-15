package com.hexaware.bankingsystem.entity;

public class SavingsAccountTask8 extends AccountTask8 { 
	private double interestRate = 4.5;
	
	public SavingsAccountTask8(int accountNumber, double balance) {
	    super(accountNumber, "Savings", balance);
	}

	@Override
	public void calculateInterest() {
	    double interest = (balance * interestRate) / 100;
	    balance += interest;
	    System.out.println("Interest ₹" + interest + " added to savings account.");
	}
	}


