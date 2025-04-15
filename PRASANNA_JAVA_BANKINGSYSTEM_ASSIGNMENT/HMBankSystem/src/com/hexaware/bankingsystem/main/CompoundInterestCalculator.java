package com.hexaware.bankingsystem.main;

import java.util.Scanner;

public class CompoundInterestCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of customers: ");
        int numCustomers = input.nextInt();

        for (int i = 1; i <= numCustomers; i++) {
            System.out.println("\nCustomer " + i + ":");

            System.out.print("Enter initial balance: ");
            double initialBalance = input.nextDouble();

            System.out.print("Enter annual interest rate (in %): ");
            double interestRate = input.nextDouble();

            System.out.print("Enter number of years: ");
            int years = input.nextInt();

            // Compound Interest Formula
            double futureBalance = initialBalance * Math.pow((1 + interestRate / 100), years);

            System.out.printf("Future balance after %d years: ₹%.2f%n", years, futureBalance);
        }

        input.close();

	}

}
