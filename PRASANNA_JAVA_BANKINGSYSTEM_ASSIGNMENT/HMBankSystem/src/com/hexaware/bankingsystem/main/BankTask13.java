//package com.hexaware.bankingsystem.main;
//
//import com.hexaware.bankingsystem.dao.HMBankTask13;
//import com.hexaware.bankingsystem.entity.AccountTask13;
//import com.hexaware.bankingsystem.exception.*;
//
//import java.util.*;
//
//public class BankTask13 {
//    public static void main(String[] args) {
//        HMBankTask13 bank = new HMBankTask13();
//
//        AccountTask13 a1 = new AccountTask13("A101", "Alice", 2000, false); // Savings
//        AccountTask13 a2 = new AccountTask13("A102", "Bob", 1500, true);    // Current
//        AccountTask13 a3 = new AccountTask13("A103", "Charlie", 1000, false); // Savings
//
//        // Adding accounts to the bank
//        bank.addAccount(a1);
//        bank.addAccount(a2);
//        bank.addAccount(a3);
//
//        // Sorting the accounts based on customer name
//        List<AccountTask13> accounts = bank.getAccounts();
//        accounts.sort(HMBankTask13.NameComparator);
//
//        System.out.println("Accounts sorted by customer name:");
//        for (AccountTask13 acc : accounts) {
//            acc.display();
//        }
//
//        // Now let's work with Set<Account> to avoid duplicates
//        // Uncomment the next line to switch to Set instead of List
//        // Set<AccountTask13> accountSet = new HashSet<>(accounts);
//
//        try {
//            // Testing Withdraw and Deposit
//            bank.deposit("A101", 500);
//            bank.withdraw("A102", 200);
//
//            // Performing Transfer
//            bank.transfer("A101", "A102", 100);
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//
//        // Display account details
//        try {
//            bank.display("A101");
//        } catch (InvalidAccountException e) {
//            System.out.println("Display Error: " + e.getMessage());
//        }
//    }
//}
package com.hexaware.bankingsystem.main;

import com.hexaware.bankingsystem.dao.HMBankTask13;
import com.hexaware.bankingsystem.entity.AccountTask13;
import com.hexaware.bankingsystem.exception.*;

import java.util.List;

public class BankTask13 {
    public static void main(String[] args) {
        HMBankTask13 bank = new HMBankTask13();

        AccountTask13 a1 = new AccountTask13("A101", "Alice", 2000, false);
        AccountTask13 a2 = new AccountTask13("A102", "Bob", 1500, true);
        AccountTask13 a3 = new AccountTask13("A103", "Charlie", 1000, false);

        bank.addAccount(a1);
        bank.addAccount(a2);
        bank.addAccount(a3);

        System.out.println("Accounts sorted by customer name:");
        List<AccountTask13> sortedAccounts = bank.getSortedAccountsByName();
        for (AccountTask13 acc : sortedAccounts) {
            acc.display();
        }

        try {
            bank.deposit("A101", 500);
            bank.withdraw("A102", 200);
            bank.transfer("A101", "A102", 100);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("\nUpdated Account A101:");
            bank.display("A101");
        } catch (InvalidAccountException e) {
            System.out.println("Display Error: " + e.getMessage());
        }
    }
}
