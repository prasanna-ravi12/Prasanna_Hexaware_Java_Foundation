package com.hexaware.bankingsystem.main;

import java.util.Scanner;

public class ATMTransactionSimulator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double balance = 10000.0; // starting balance
        boolean running = true;

        while (running) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.println("Your current balance is: $" + balance);
            } 
            else if (choice == 2) {
                System.out.print("Enter amount to deposit: ");
                double amount = input.nextDouble();
                if (amount > 0) {
                    balance += amount;
                    System.out.println("Deposited $" + amount + ". New balance is $" + balance);
                } else {
                    System.out.println("Invalid deposit amount.");
                }
            } 
            else if (choice == 3) {
                System.out.print("Enter amount to withdraw: ");
                double amount = input.nextDouble();

                if (amount > balance) {
                    System.out.println("Insufficient balance.");
                } else if (amount % 100 != 0 && amount % 500 != 0) {
                    System.out.println("Amount must be in multiples of 100 or 500.");
                } else {
                    balance -= amount;
                    System.out.println("Withdrawn $" + amount + ". Remaining balance: $" + balance);
                }
            } 
            else if (choice == 4) {
                System.out.println("Thank you for using the ATM. Goodbye!");
                running = false;
            } 
            else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        input.close();
    }
}
