package com.hexaware.bankingsystem.dao;

import com.hexaware.bankingsystem.entity.*; import java.sql.Date; import java.util.List;

public interface ICustomerServiceProviderTask14 { double getAccountBalance(long accountNumber); double deposit(long accountNumber, double amount); double withdraw(long accountNumber, double amount); boolean transfer(long fromAccountNumber, long toAccountNumber, double amount); AccountTask14 getAccountDetails(long accountNumber); List<TransactionTask14> getTransactions(long accountNumber, Date fromDate, Date toDate); }