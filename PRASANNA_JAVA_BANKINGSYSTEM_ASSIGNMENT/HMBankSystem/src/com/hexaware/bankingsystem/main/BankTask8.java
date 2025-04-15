package com.hexaware.bankingsystem.main;

import com.hexaware.bankingsystem.entity.AccountTask8; 
import com.hexaware.bankingsystem.entity.SavingsAccountTask8; 
import com.hexaware.bankingsystem.entity.CurrentAccountTask8;

import java.util.Scanner;

public class BankTask8 { public static void main(String[] args) { 
	Scanner sc = new Scanner(System.in); 
	AccountTask8 account = null;


    System.out.println("Choose Account Type:");
    System.out.println("1. Savings Account");
    System.out.println("2. Current Account");
    int option = sc.nextInt();

    System.out.print("Enter Account Number: ");
    int accNo = sc.nextInt();

    System.out.print("Enter Initial Balance: ₹");
    double balance = sc.nextDouble();

    switch (option) {
        case 1:
            account = new SavingsAccountTask8(accNo, balance);
            break;
        case 2:
            account = new CurrentAccountTask8(accNo, balance);
            break;
        default:
            System.out.println("Invalid Option!");
            System.exit(0);
    }

    int choice;
    do {
        System.out.println("\nMenu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Calculate Interest");
        System.out.println("4. Show Account Info");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter amount to deposit: ₹");
                double dAmount = sc.nextDouble();
                account.deposit(dAmount);
                break;
            case 2:
                System.out.print("Enter amount to withdraw: ₹");
                double wAmount = sc.nextDouble();
                account.withdraw(wAmount);
                break;
            case 3:
                account.calculateInterest();
                break;
            case 4:
                account.showAccountDetails();
                break;
            case 5:
                System.out.println("Thank you for using HexaBank!");
                break;
            default:
                System.out.println("Invalid choice.");
        }

    } while (choice != 5);

    sc.close();
}
}