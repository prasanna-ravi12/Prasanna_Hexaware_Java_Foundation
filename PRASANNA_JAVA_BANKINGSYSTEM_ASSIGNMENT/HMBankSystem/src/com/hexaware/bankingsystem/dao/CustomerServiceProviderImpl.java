package com.hexaware.bankingsystem.dao;

import com.hexaware.bankingsystem.entity.*;

public class CustomerServiceProviderImpl implements ICustomerServiceProvider {
    protected AccountTask11[] accounts = new AccountTask11[100];
    protected int count = 0;

    protected AccountTask11 findAccount(long accNo) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accNo) {
                return accounts[i];
            }
        }
        return null;
    }

    public float getAccountBalance(long accountNumber) {
        AccountTask11 acc = findAccount(accountNumber);
        if (acc != null) return acc.balance;
        System.out.println("Account not found.");
        return -1;
    }

    public float deposit(long accountNumber, float amount) {
        AccountTask11 acc = findAccount(accountNumber);
        if (acc != null) {
            acc.balance += amount;
            return acc.balance;
        }
        System.out.println("Account not found.");
        return -1;
    }

    public float withdraw(long accountNumber, float amount) {
        AccountTask11 acc = findAccount(accountNumber);
        if (acc instanceof SavingsAccountTask11) {
            if (acc.balance - amount >= 500) {
                acc.balance -= amount;
                return acc.balance;
            } else {
                System.out.println("Minimum balance required in Savings Account.");
            }
        } else if (acc instanceof CurrentAccountTask11) {
            if (((CurrentAccountTask11) acc).withdraw(amount)) {
                return acc.balance;
            } else {
                System.out.println("Overdraft limit exceeded.");
            }
        } else if (acc instanceof ZeroBalanceAccountTask11) {
            if (acc.balance >= amount) {
                acc.balance -= amount;
                return acc.balance;
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
        return -1;
    }

    public void transfer(long fromAcc, long toAcc, float amount) {
        float w = withdraw(fromAcc, amount);
        if (w != -1) {
            deposit(toAcc, amount);
        }
    }

    public void getAccountDetails(long accountNumber) {
        AccountTask11 acc = findAccount(accountNumber);
        if (acc != null) {
            acc.printAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }
}
