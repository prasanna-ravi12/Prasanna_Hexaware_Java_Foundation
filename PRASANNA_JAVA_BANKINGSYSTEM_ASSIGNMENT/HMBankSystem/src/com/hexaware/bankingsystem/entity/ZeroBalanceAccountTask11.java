package com.hexaware.bankingsystem.entity;

public class ZeroBalanceAccountTask11 extends AccountTask11 {
    public ZeroBalanceAccountTask11(CustomerTask11 customer) {
        super("ZeroBalance", 0, customer);
    }
}
