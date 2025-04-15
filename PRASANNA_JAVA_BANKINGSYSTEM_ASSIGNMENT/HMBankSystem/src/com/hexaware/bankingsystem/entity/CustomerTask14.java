package com.hexaware.bankingsystem.entity;

import java.sql.Date;

public class CustomerTask14 { private int customerId; private String firstName; private String lastName; private Date dob; private String email; private String phoneNumber; private String address;

public CustomerTask14() {}

public CustomerTask14(int customerId, String firstName, String lastName, Date dob, String email, String phoneNumber, String address) {
    this.customerId = customerId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.dob = dob;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.address = address;
}

// Getters and Setters
public int getCustomerId() { return customerId; }
public void setCustomerId(int customerId) { this.customerId = customerId; }

public String getFirstName() { return firstName; }
public void setFirstName(String firstName) { this.firstName = firstName; }

public String getLastName() { return lastName; }
public void setLastName(String lastName) { this.lastName = lastName; }

public Date getDob() { return dob; }
public void setDob(Date dob) { this.dob = dob; }

public String getEmail() { return email; }
public void setEmail(String email) { this.email = email; }

public String getPhoneNumber() { return phoneNumber; }
public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

public String getAddress() { return address; }
public void setAddress(String address) { this.address = address; }
}