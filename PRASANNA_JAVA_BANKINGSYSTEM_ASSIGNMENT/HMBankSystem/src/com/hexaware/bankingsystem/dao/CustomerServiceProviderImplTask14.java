package com.hexaware.bankingsystem.dao;

import com.hexaware.bankingsystem.entity.*; import java.sql.Date; import java.util.List;

public class CustomerServiceProviderImplTask14 implements ICustomerServiceProviderTask14 {


// DAO to interact with DB
IBankRepositoryTask14 repo = new BankRepositoryImplTask14();

@Override
public double getAccountBalance(long accountNumber) {
    return repo.getAccountBalance(accountNumber);
}

@Override
public double deposit(long accountNumber, double amount) {
    return repo.deposit(accountNumber, amount);
}

@Override
public double withdraw(long accountNumber, double amount) {
    return repo.withdraw(accountNumber, amount);
}

@Override
public boolean transfer(long fromAccountNumber, long toAccountNumber, double amount) {
    return repo.transfer(fromAccountNumber, toAccountNumber, amount);
}

@Override
public AccountTask14 getAccountDetails(long accountNumber) {
    return repo.getAccountDetails(accountNumber);
}

@Override
public List<TransactionTask14> getTransactions(long accountNumber, Date fromDate, Date toDate) {
    return repo.getTransactions(accountNumber, fromDate, toDate);
}
}