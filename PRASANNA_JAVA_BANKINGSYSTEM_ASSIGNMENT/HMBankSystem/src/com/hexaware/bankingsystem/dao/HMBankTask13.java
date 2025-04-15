//package com.hexaware.bankingsystem.dao;
//
//import com.hexaware.bankingsystem.entity.AccountTask13;
//import com.hexaware.bankingsystem.exception.*;
//
//import java.util.*;
//
//// HMBank class for Task 13
//public class HMBankTask13 {
//
//    // Using List of Accounts
//    private List<AccountTask13> accounts = new ArrayList<>();
//
//    // Using Set of Accounts (to avoid duplicates)
//    // private Set<AccountTask13> accounts = new HashSet<>();
//
//    // Using HashMap of Accounts (mapping account number to account object)
//    // private Map<String, AccountTask13> accounts = new HashMap<>();
//
//    public void addAccount(AccountTask13 acc) {
//        // If using Set:
//        // accounts.add(acc); // This will automatically prevent duplicates
//
//        // If using List:
//        accounts.add(acc);
//
//        // If using HashMap:
//        // accounts.put(acc.getAccountNumber(), acc);
//    }
//
//    public void deposit(String accNo, double amount) throws InvalidAccountException {
//        AccountTask13 acc = findAccount(accNo);
//        acc.deposit(amount);
//    }
//
//    public void withdraw(String accNo, double amount) throws InvalidAccountException, InsufficientFundException, OverDraftLimitExceededException {
//        AccountTask13 acc = findAccount(accNo);
//        double currentBalance = acc.getBalance();
//
//        if (currentBalance >= amount) {
//            acc.setBalance(currentBalance - amount);
//        } else if (acc.isCurrentAccount() && currentBalance + 1000 >= amount) {
//            acc.setBalance(currentBalance - amount); // overdraft allowed
//        } else if (acc.isCurrentAccount()) {
//            throw new OverDraftLimitExceededException("Overdraft limit exceeded.");
//        } else {
//            throw new InsufficientFundException("Insufficient funds.");
//        }
//    }
//
//    public void transfer(String fromAcc, String toAcc, double amount) throws InvalidAccountException, InsufficientFundException, OverDraftLimitExceededException {
//        AccountTask13 from = findAccount(fromAcc);
//        AccountTask13 to = findAccount(toAcc);
//
//        withdraw(fromAcc, amount);  // may throw exception
//        deposit(toAcc, amount);
//    }
//
//    public void display(String accNo) throws InvalidAccountException {
//        AccountTask13 acc = findAccount(accNo);
//        acc.display();
//    }
//
//    private AccountTask13 findAccount(String accNo) throws InvalidAccountException {
//        // If using List:
//        for (AccountTask13 acc : accounts) {
//            if (acc.getAccountNumber().equals(accNo)) {
//                return acc;
//            }
//        }
//        // If using HashMap:
//        // if (accounts.containsKey(accNo)) {
//        //     return accounts.get(accNo);
//        // }
//
//        throw new InvalidAccountException("Invalid account number.");
//    }
//
//    // For List:
//    public List<AccountTask13> getAccounts() {
//        return accounts;
//    }
//
//    // Comparator to sort accounts by customer name
//    public static Comparator<AccountTask13> NameComparator = new Comparator<AccountTask13>() {
//        @Override
//        public int compare(AccountTask13 acc1, AccountTask13 acc2) {
//            return acc1.getHolderName().compareTo(acc2.getHolderName());
//        }
//    };
//
//    // Sort the accounts by customer name using the Comparator
//    public void sortAccountsByName() {
//        Collections.sort(accounts, NameComparator);
//    }
//}
package com.hexaware.bankingsystem.dao;

import com.hexaware.bankingsystem.entity.AccountTask13;
import com.hexaware.bankingsystem.exception.*;

import java.util.*;

public class HMBankTask13 {
    // Use a HashMap to prevent duplicate account numbers
    private Map<String, AccountTask13> accounts = new HashMap<>();

    public void addAccount(AccountTask13 acc) {
        accounts.put(acc.getAccountNumber(), acc); // overwrite if already exists
    }

    public void deposit(String accNo, double amount) throws InvalidAccountException {
        AccountTask13 acc = findAccount(accNo);
        acc.deposit(amount);
    }

    public void withdraw(String accNo, double amount) throws InvalidAccountException, InsufficientFundException, OverDraftLimitExceededException {
        AccountTask13 acc = findAccount(accNo);
        double currentBalance = acc.getBalance();

        if (currentBalance >= amount) {
            acc.setBalance(currentBalance - amount);
        } else if (acc.isCurrentAccount() && currentBalance + 1000 >= amount) {
            acc.setBalance(currentBalance - amount);
        } else if (acc.isCurrentAccount()) {
            throw new OverDraftLimitExceededException("Overdraft limit exceeded.");
        } else {
            throw new InsufficientFundException("Insufficient funds.");
        }
    }

    public void transfer(String fromAcc, String toAcc, double amount)
            throws InvalidAccountException, InsufficientFundException, OverDraftLimitExceededException {
        withdraw(fromAcc, amount);
        deposit(toAcc, amount);
    }

    public void display(String accNo) throws InvalidAccountException {
        AccountTask13 acc = findAccount(accNo);
        acc.display();
    }

    private AccountTask13 findAccount(String accNo) throws InvalidAccountException {
        AccountTask13 acc = accounts.get(accNo);
        if (acc == null) {
            throw new InvalidAccountException("Invalid account number.");
        }
        return acc;
    }

    public List<AccountTask13> getSortedAccountsByName() {
        List<AccountTask13> sortedList = new ArrayList<>(accounts.values());
        sortedList.sort(NameComparator);
        return sortedList;
    }

    public static Comparator<AccountTask13> NameComparator = Comparator.comparing(AccountTask13::getHolderName);
}
