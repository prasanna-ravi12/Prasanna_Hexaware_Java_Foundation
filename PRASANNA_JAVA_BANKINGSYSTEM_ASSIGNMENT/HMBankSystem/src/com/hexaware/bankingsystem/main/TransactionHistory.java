package com.hexaware.bankingsystem.main;

import java.util.ArrayList; 

import java.util.Scanner;

public class TransactionHistory {
	public static void main(String[] args) { 
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> transactions = new ArrayList<>();
	    int choice = 0;

	    System.out.println("Welcome to HMBank");

	    while (choice != 3) {
	        System.out.println("\n1. Deposit");
	        System.out.println("2. Withdraw");
	        System.out.println("3. Exit and show transaction history");
	        System.out.print("Enter your choice: ");
	        choice = scanner.nextInt();

	        if (choice == 1) {
	            System.out.print("Enter amount to deposit: ");
	            double amount = scanner.nextDouble();
	            transactions.add("Deposited ₹" + amount);
	            System.out.println("Deposit recorded.");
	        } else if (choice == 2) {
	            System.out.print("Enter amount to withdraw: ");
	            double amount = scanner.nextDouble();
	            transactions.add("Withdrew ₹" + amount);
	            System.out.println("Withdrawal recorded.");
	        } else if (choice == 3) {
	            System.out.println("\nTransaction History:");
	            for (int i = 0; i < transactions.size(); i++) {
	                System.out.println((i + 1) + ". " + transactions.get(i));
	            }
	            System.out.println("Thank you!");
	        } else {
	            System.out.println("Invalid choice. Please try again.");
	        }
	    }

	    scanner.close();
	}

}
