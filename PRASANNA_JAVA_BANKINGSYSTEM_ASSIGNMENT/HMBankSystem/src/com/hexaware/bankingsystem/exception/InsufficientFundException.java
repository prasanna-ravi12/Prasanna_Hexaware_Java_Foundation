package com.hexaware.bankingsystem.exception;

public class InsufficientFundException extends Exception {
    public InsufficientFundException(String message) {
        super(message);
    }
}
