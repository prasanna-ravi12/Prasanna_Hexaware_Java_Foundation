package com.hexaware.bankingsystem.dao;

import com.hexaware.bankingsystem.entity.*;

import java.util.List;

public class BankServiceProviderImplTask14 extends CustomerServiceProviderImplTask14 implements IBankServiceProviderTask14 {


private IBankRepositoryTask14 repo = new BankRepositoryImplTask14();

@Override
public boolean createAccount(CustomerTask14 customer, long accNo, String accType, double balance) {
    return repo.createAccount(customer, accNo, accType, balance);
}

@Override
public List<AccountTask14> listAccounts() {
    return repo.listAccounts();
}

@Override
public AccountTask14 getAccountDetails(long accountNumber) {
    return repo.getAccountDetails(accountNumber);
}

@Override
public void calculateInterest() {
    repo.calculateInterest();
}
}