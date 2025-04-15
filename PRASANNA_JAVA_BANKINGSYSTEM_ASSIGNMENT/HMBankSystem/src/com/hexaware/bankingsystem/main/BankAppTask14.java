package com.hexaware.bankingsystem.main;

import com.hexaware.bankingsystem.dao.BankServiceProviderImplTask14; import com.hexaware.bankingsystem.entity.CustomerTask14; import com.hexaware.bankingsystem.entity.AccountTask14; import com.hexaware.bankingsystem.entity.TransactionTask14;

import java.sql.Date; import java.util.List; import java.util.Scanner;

public class BankAppTask14 { public static void main(String[] args) { Scanner sc = new Scanner(System.in); BankServiceProviderImplTask14 bank = new BankServiceProviderImplTask14();

    while (true) {
        System.out.println("\n========= HMBank Menu =========");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Get Balance");
        System.out.println("6. Get Account Details");
        System.out.println("7. List All Accounts");
        System.out.println("8. Get Transactions (Between Dates)");
        System.out.println("9. Calculate Interest");
        System.out.println("10. Exit");
        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();

        switch (ch) {
            case 1:
                sc.nextLine();
                System.out.println("Enter First Name:");
                String fname = sc.nextLine();
                System.out.println("Enter Last Name:");
                String lname = sc.nextLine();
                System.out.println("Enter DOB (yyyy-mm-dd):");
                Date dob = Date.valueOf(sc.nextLine());
                System.out.println("Enter Email:");
                String email = sc.nextLine();
                System.out.println("Enter Phone:");
                String phone = sc.nextLine();
                System.out.println("Enter Address:");
                String address = sc.nextLine();
                System.out.println("Enter Account Type (savings/current/zero_balance):");
                String accType = sc.nextLine();
                System.out.println("Enter Initial Balance:");
                double balance = sc.nextDouble();

                CustomerTask14 cust = new CustomerTask14(0, fname, lname, dob, email, phone, address);
                boolean created = bank.createAccount(cust, 0, accType, balance);
                System.out.println(created ? "✅ Account Created" : "❌ Failed to Create");
                break;

            case 2:
                System.out.print("Enter Account No: ");
                long accDep = sc.nextLong();
                System.out.print("Enter Amount: ");
                double amtDep = sc.nextDouble();
                System.out.println("New Balance: ₹" + bank.deposit(accDep, amtDep));
                break;

            case 3:
                System.out.print("Enter Account No: ");
                long accW = sc.nextLong();
                System.out.print("Enter Amount: ");
                double amtW = sc.nextDouble();
                System.out.println("New Balance: ₹" + bank.withdraw(accW, amtW));
                break;

            case 4:
                System.out.print("From Account: ");
                long from = sc.nextLong();
                System.out.print("To Account: ");
                long to = sc.nextLong();
                System.out.print("Amount: ");
                double amtT = sc.nextDouble();
                System.out.println(bank.transfer(from, to, amtT) ? "✅ Transfer Successful" : "❌ Transfer Failed");
                break;

            case 5:
                System.out.print("Enter Account No: ");
                long accB = sc.nextLong();
                System.out.println("Current Balance: ₹" + bank.getAccountBalance(accB));
                break;

            case 6:
                System.out.print("Enter Account No: ");
                long accD = sc.nextLong();
                AccountTask14 a = bank.getAccountDetails(accD);
                if (a != null) {
                    System.out.println("Account ID: " + a.getAccountId());
                    System.out.println("Customer ID: " + a.getCustomerId());
                    System.out.println("Type: " + a.getAccountType());
                    System.out.println("Balance: ₹" + a.getBalance());
                } else {
                    System.out.println("❌ Account not found.");
                }
                break;

            case 7:
                List<AccountTask14> accList = bank.listAccounts();
                System.out.println("===== All Accounts =====");
                for (AccountTask14 acc : accList) {
                    System.out.println("ID: " + acc.getAccountId() + ", Type: " + acc.getAccountType() +
                            ", Balance: ₹" + acc.getBalance());
                }
                break;

            case 8:
                System.out.print("Enter Account No: ");
                long accTrans = sc.nextLong();
                sc.nextLine();
                System.out.print("From Date (yyyy-mm-dd): ");
                Date fromDate = Date.valueOf(sc.nextLine());
                System.out.print("To Date (yyyy-mm-dd): ");
                Date toDate = Date.valueOf(sc.nextLine());

                List<TransactionTask14> txns = bank.getTransactions(accTrans, fromDate, toDate);
                for (TransactionTask14 txn : txns) {
                    System.out.println("ID: " + txn.getTransactionId() + ", Type: " + txn.getTransactionType() +
                            ", Amt: ₹" + txn.getAmount() + ", Date: " + txn.getTransactionDate());
                }
                break;

            case 9:
                bank.calculateInterest();
                System.out.println("✅ Interest Added for all Savings Accounts.");
                break;

            case 10:
                System.out.println("Thank you for using HMBank 💰");
                System.exit(0);

            default:
                System.out.println("❌ Invalid choice. Try again.");
        }
    }
}
}