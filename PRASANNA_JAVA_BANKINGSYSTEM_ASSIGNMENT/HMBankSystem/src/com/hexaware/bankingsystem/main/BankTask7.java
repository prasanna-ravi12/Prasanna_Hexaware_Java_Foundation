package com.hexaware.bankingsystem.main;

import com.hexaware.bankingsystem.entity.AccountTask7;
import com.hexaware.bankingsystem.entity.CustomerTask7;

import java.util.Scanner;

public class BankTask7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create customer using parameterized constructor
        CustomerTask7 customer = new CustomerTask7(1, "Prasu", "Kumar", "prasu@example.com", "9876543210", "Chennai");
        customer.printCustomerInfo();

        // Create account using parameterized constructor
        System.out.println("\nCreating Account...");
        AccountTask7 account = new AccountTask7(1001, "Savings", 5000.0);
        account.printAccountInfo();

        // Simple menu
        int choice;
        do {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Calculate Interest");
            System.out.println("4. Show Account Info");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmt = scanner.nextDouble();
                    account.deposit(depositAmt);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmt = scanner.nextDouble();
                    account.withdraw(withdrawAmt);
                    break;
                case 3:
                    account.calculateInterest();
                    break;
                case 4:
                    account.printAccountInfo();
                    break;
                case 5:
                    System.out.println("Thank you for using HMBank!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}