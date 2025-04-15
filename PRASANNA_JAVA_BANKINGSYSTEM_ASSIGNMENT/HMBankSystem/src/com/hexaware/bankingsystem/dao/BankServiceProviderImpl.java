package com.hexaware.bankingsystem.dao;

import com.hexaware.bankingsystem.entity.*;

public class BankServiceProviderImpl extends CustomerServiceProviderImpl implements IBankServiceProvider {
    private String branchName = "Hexaware Branch";
    private String branchAddress = "Mumbai";

    public void createAccount(int type, String firstName, String lastName, String email, String phone, String address, float balance) {
        CustomerTask11 customer = new CustomerTask11(count + 1, firstName, lastName, email, phone, address);
        AccountTask11 acc = null;

        switch (type) {
            case 1: acc = new SavingsAccountTask11(balance, customer); break;
            case 2: acc = new CurrentAccountTask11(balance, customer); break;
            case 3: acc = new ZeroBalanceAccountTask11(customer); break;
            default: System.out.println("Invalid Account Type"); return;
        }

        accounts[count++] = acc;
        System.out.println("Account Created Successfully. Account No: " + acc.getAccountNumber());
    }

    public void listAccounts() {
        for (int i = 0; i < count; i++) {
            accounts[i].printAccountDetails();
            System.out.println("----------------------------");
        }
    }

    public void calculateInterest() {
        for (int i = 0; i < count; i++) {
            if (accounts[i] instanceof SavingsAccountTask11) {
                float interest = ((SavingsAccountTask11) accounts[i]).calculateInterest();
                accounts[i].balance += interest;
                System.out.println("Interest of " + interest + " added to Account " + accounts[i].getAccountNumber());
            }
        }
    }
}
