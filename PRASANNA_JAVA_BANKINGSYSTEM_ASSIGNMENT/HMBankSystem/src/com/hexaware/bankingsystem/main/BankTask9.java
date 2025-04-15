package com.hexaware.bankingsystem.main;

import com.hexaware.bankingsystem.entity.*;

import java.util.Scanner;

public class BankTask9 { 
	public static void main(String[] args) { 
	Scanner sc = new Scanner(System.in); 
	BankAccountTask9 account = null;

    System.out.println("🏦 Welcome to HMBank Task 9 - Abstraction Demo");

    System.out.println("\nChoose Account Type:");
    System.out.println("1. Savings Account");
    System.out.println("2. Current Account");
    System.out.print("Enter option: ");
    int option = sc.nextInt();

    System.out.print("Enter Account Number: ");
    int accNo = sc.nextInt();
    sc.nextLine(); // consume newline

    System.out.print("Enter Customer Name: ");
    String name = sc.nextLine();

    System.out.print("Enter Initial Balance: ₹");
    double balance = sc.nextDouble();

    switch (option) {
        case 1:
            account = new SavingsAccountTask9(accNo, name, balance);
            break;
        case 2:
            account = new CurrentAccountTask9(accNo, name, balance);
            break;
        default:
            System.out.println("❌ Invalid option. Exiting...");
            System.exit(0);
    }

    int choice;
    do {
        System.out.println("\n📋 Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Calculate Interest");
        System.out.println("4. Show Account Info");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter deposit amount: ₹");
                float depositAmt = sc.nextFloat();
                account.deposit(depositAmt);
                break;
            case 2:
                System.out.print("Enter withdraw amount: ₹");
                float withdrawAmt = sc.nextFloat();
                account.withdraw(withdrawAmt);
                break;
            case 3:
                account.calculateInterest();
                break;
            case 4:
                account.printAccountDetails();
                break;
            case 5:
                System.out.println("✅ Thank you for banking with us!");
                break;
            default:
                System.out.println("❌ Invalid option.");
        }
    } while (choice != 5);

    sc.close();
}
}