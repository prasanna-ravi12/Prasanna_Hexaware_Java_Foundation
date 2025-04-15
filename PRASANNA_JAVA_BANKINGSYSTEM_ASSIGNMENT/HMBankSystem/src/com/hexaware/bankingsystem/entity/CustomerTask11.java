package com.hexaware.bankingsystem.entity;

public class CustomerTask11 {
    private long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    public CustomerTask11() {}

    public CustomerTask11(long customerId, String firstName, String lastName, String email, String phone, String address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    // Getters and Setters

    public void printCustomerDetails() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
    }

    public long getCustomerId() { return customerId; }
}
