package com.hexaware.bankingsystem.main;

import com.hexaware.bankingsystem.entity.*;

import java.util.*;

public class BankTask10 {
    private static Map<Long, AccountTask10> accounts = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Get Balance");
            System.out.println("5. Transfer");
            System.out.println("6. Account Details");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: deposit(); break;
                case 3: withdraw(); break;
                case 4: getBalance(); break;
                case 5: transfer(); break;
                case 6: accountDetails(); break;
                case 7: running = false; break;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt(); sc.nextLine();

        System.out.print("First Name: ");
        String fname = sc.nextLine();

        System.out.print("Last Name: ");
        String lname = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Phone: ");
        String phone = sc.nextLine();

        System.out.print("Address: ");
        String address = sc.nextLine();

        CustomerTask10 cust = new CustomerTask10(id, fname, lname, email, phone, address);

        System.out.print("Enter Account Type (Savings/Current): ");
        String accType = sc.nextLine();

        System.out.print("Initial Balance: ");
        float balance = sc.nextFloat(); sc.nextLine();

        AccountTask10 acc = new AccountTask10(accType, balance, cust);
        accounts.put(acc.getAccountNumber(), acc);

        System.out.println("Account Created. Account Number: " + acc.getAccountNumber());
    }

    private static void deposit() {
        System.out.print("Enter Account Number: ");
        long accNo = sc.nextLong();
        System.out.print("Enter Amount: ");
        float amount = sc.nextFloat();
        AccountTask10 acc = accounts.get(accNo);
        if (acc != null) acc.deposit(amount);
        else System.out.println("Account not found.");
    }

    private static void withdraw() {
        System.out.print("Enter Account Number: ");
        long accNo = sc.nextLong();
        System.out.print("Enter Amount: ");
        float amount = sc.nextFloat();
        AccountTask10 acc = accounts.get(accNo);
        if (acc != null) acc.withdraw(amount);
        else System.out.println("Account not found.");
    }

    private static void getBalance() {
        System.out.print("Enter Account Number: ");
        long accNo = sc.nextLong();
        AccountTask10 acc = accounts.get(accNo);
        if (acc != null) System.out.println("Balance: " + acc.getBalance());
        else System.out.println("Account not found.");
    }

    private static void transfer() {
        System.out.print("From Account Number: ");
        long from = sc.nextLong();
        System.out.print("To Account Number: ");
        long to = sc.nextLong();
        System.out.print("Amount: ");
        float amount = sc.nextFloat();

        AccountTask10 fromAcc = accounts.get(from);
        AccountTask10 toAcc = accounts.get(to);

        if (fromAcc != null && toAcc != null) {
            if (fromAcc.getBalance() >= amount) {
                fromAcc.withdraw(amount);
                toAcc.deposit(amount);
                System.out.println("Transfer successful.");
            } else {
                System.out.println("Insufficient balance for transfer.");
            }
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    private static void accountDetails() {
        System.out.print("Enter Account Number: ");
        long accNo = sc.nextLong();
        AccountTask10 acc = accounts.get(accNo);
        if (acc != null) acc.printAccountDetails();
        else System.out.println("Account not found.");
    }
}
