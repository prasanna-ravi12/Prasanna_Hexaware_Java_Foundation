package com.hexaware.bankingsystem.dao;

import com.hexaware.bankingsystem.entity.AccountTask12;
import com.hexaware.bankingsystem.exception.*;

import java.util.HashMap;
import java.util.Map;

public class HMBank {
    private Map<String, AccountTask12> accounts = new HashMap<>();

    public void addAccount(AccountTask12 acc) {
        accounts.put(acc.accountNumber, acc);
    }

    public void deposit(String accNo, double amount) throws InvalidAccountException {
        AccountTask12 acc = accounts.get(accNo);
        if (acc == null) throw new InvalidAccountException("Invalid account number.");
        acc.deposit(amount);
    }

    public void withdraw(String accNo, double amount)
            throws InvalidAccountException, InsufficientFundException, OverDraftLimitExceededException {

        AccountTask12 acc = accounts.get(accNo);
        if (acc == null) throw new InvalidAccountException("Invalid account number.");

        double currentBalance = acc.getBalance();

        if (currentBalance >= amount) {
            acc.setBalance(currentBalance - amount);
        } else if (acc.isCurrentAccount() && currentBalance + 1000 >= amount) {
            acc.setBalance(currentBalance - amount); // overdraft allowed
        } else if (acc.isCurrentAccount()) {
            throw new OverDraftLimitExceededException("Overdraft limit exceeded.");
        } else {
            throw new InsufficientFundException("Insufficient funds.");
        }
    }

    public void transfer(String fromAcc, String toAcc, double amount)
            throws InvalidAccountException, InsufficientFundException, OverDraftLimitExceededException {

        AccountTask12 from = accounts.get(fromAcc);
        AccountTask12 to = accounts.get(toAcc);

        if (from == null || to == null) throw new InvalidAccountException("Invalid account(s).");

        withdraw(fromAcc, amount);  // may throw exception
        deposit(toAcc, amount);
    }

    public void display(String accNo) throws InvalidAccountException {
        AccountTask12 acc = accounts.get(accNo);
        if (acc == null) throw new InvalidAccountException("Invalid account number.");
        acc.display();
    }
}
