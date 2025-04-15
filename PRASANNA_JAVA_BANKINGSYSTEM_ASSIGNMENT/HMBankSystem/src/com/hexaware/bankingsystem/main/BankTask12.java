package com.hexaware.bankingsystem.main;

import com.hexaware.bankingsystem.dao.HMBank;
import com.hexaware.bankingsystem.entity.AccountTask12;
import com.hexaware.bankingsystem.exception.*;

public class BankTask12 {
    public static void main(String[] args) {
        HMBank bank = new HMBank();

        AccountTask12 a1 = new AccountTask12("A101", "Alice", 2000, false); // Savings
        AccountTask12 a2 = new AccountTask12("A102", "Bob", 1500, true);    // Current

        bank.addAccount(a1);
        bank.addAccount(a2);

        try {
            bank.withdraw("A101", 3000);
        } catch (InsufficientFundException | InvalidAccountException | OverDraftLimitExceededException e) {
            System.out.println("Withdraw Error: " + e.getMessage());
        }

        try {
            bank.transfer("A101", "A999", 500);
        } catch (InvalidAccountException | InsufficientFundException | OverDraftLimitExceededException e) {
            System.out.println("Transfer Error: " + e.getMessage());
        }

        try {
            AccountTask12 nullAcc = null;
            nullAcc.deposit(100);  // This line throws NullPointerException
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled: Tried to use a null account.");
        }

        try {
            bank.display("A102");
        } catch (InvalidAccountException e) {
            System.out.println("Display Error: " + e.getMessage());
        }
    }
}
