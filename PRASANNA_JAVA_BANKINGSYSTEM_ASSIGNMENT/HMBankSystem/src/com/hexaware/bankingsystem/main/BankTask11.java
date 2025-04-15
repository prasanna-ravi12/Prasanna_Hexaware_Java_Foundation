package com.hexaware.bankingsystem.main;

import java.util.Scanner;
import com.hexaware.bankingsystem.dao.BankServiceProviderImpl;

public class BankTask11 {
    public static void main(String[] args) {
        BankServiceProviderImpl bank = new BankServiceProviderImpl();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n1. Create Account\n2. Deposit\n3. Withdraw\n4. Get Balance\n5. Transfer\n6. Get Account Details\n7. List Accounts\n8. Calculate Interest\n9. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("1. Savings\n2. Current\n3. Zero Balance");
                    int type = sc.nextInt();
                    System.out.print("First Name: "); String fn = sc.next();
                    System.out.print("Last Name: "); String ln = sc.next();
                    System.out.print("Email: "); String em = sc.next();
                    System.out.print("Phone: "); String ph = sc.next();
                    System.out.print("Address: "); String addr = sc.next();
                    System.out.print("Initial Balance: "); sc.nextLine(); float bal = sc.nextFloat();
                    bank.createAccount(type, fn, ln, em, ph, addr, bal);
                    break;
                case 2:
                    System.out.print("Account Number: "); long accNoD = sc.nextLong();
                    System.out.print("Amount: "); float amtD = sc.nextFloat();
                    bank.deposit(accNoD, amtD);
                    break;
                case 3:
                    System.out.print("Account Number: "); long accNoW = sc.nextLong();
                    System.out.print("Amount: "); float amtW = sc.nextFloat();
                    bank.withdraw(accNoW, amtW);
                    break;
                case 4:
                    System.out.print("Account Number: "); long accNoB = sc.nextLong();
                    System.out.println("Balance: " + bank.getAccountBalance(accNoB));
                    break;
                case 5:
                    System.out.print("From Account: "); long from = sc.nextLong();
                    System.out.print("To Account: "); long to = sc.nextLong();
                    System.out.print("Amount: "); float amtT = sc.nextFloat();
                    bank.transfer(from, to, amtT);
                    break;
                case 6:
                    System.out.print("Account Number: "); long accNoDets = sc.nextLong();
                    bank.getAccountDetails(accNoDets);
                    break;
                case 7:
                    bank.listAccounts();
                    break;
                case 8:
                    bank.calculateInterest();
                    break;
                case 9:
                    exit = true;
                    break;
            }
        }

        sc.close();
    }
}
