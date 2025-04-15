package com.hexaware.bankingsystem.main;

import java.util.Scanner;

public class LoanEligibilityChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter your credit score: ");
        int creditScore = scanner.nextInt();

        System.out.print("Enter your annual income: ");
        double annualIncome = scanner.nextDouble();

        // Eligibility check
        if (creditScore > 700 && annualIncome >= 50000) {
            System.out.println("✅ You are eligible for the loan.");
        } else {
            System.out.println("❌ You are NOT eligible for the loan.");
        }

        scanner.close();
    }
}
