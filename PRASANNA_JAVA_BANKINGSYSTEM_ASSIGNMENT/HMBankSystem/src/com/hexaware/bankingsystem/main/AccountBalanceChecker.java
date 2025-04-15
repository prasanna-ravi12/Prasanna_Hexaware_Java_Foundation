package com.hexaware.bankingsystem.main;

import java.util.Scanner;

public class AccountBalanceChecker {

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);

        // Arrays to store account numbers and balances
        int[] accountNumbers = {101, 102, 103, 104};
        double[] balances = {15000.0, 25000.5, 10000.75, 5000.0};

        System.out.println("=== Welcome to  HMBank ===");

        while (true) {
            System.out.print("\nEnter your account number (0 to exit): ");
            int accNum = scanner.nextInt();

            if (accNum == 0) {
                System.out.println("Thank you! Visit again.");
                break;
            }

            boolean found = false;

            // Loop to check if account number exists
            for (int i = 0; i < accountNumbers.length; i++) {
                if (accountNumbers[i] == accNum) {
                    System.out.println("✅ Account found! Your balance is ₹" + balances[i]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("❌ Account number not found. Please try again.");
            }
        }

        scanner.close();
    }
}
