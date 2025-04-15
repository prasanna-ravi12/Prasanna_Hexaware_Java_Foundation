package com.hexaware.bankingsystem.dao;

import com.hexaware.bankingsystem.entity.*; import java.util.List;

public interface IBankServiceProviderTask14 { boolean createAccount(CustomerTask14 customer, long accNo, String accType, double balance); List<AccountTask14> listAccounts(); AccountTask14 getAccountDetails(long accountNumber); void calculateInterest(); }