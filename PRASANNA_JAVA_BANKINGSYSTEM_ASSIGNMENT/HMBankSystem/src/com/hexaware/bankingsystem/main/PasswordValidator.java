package com.hexaware.bankingsystem.main;

import java.util.Scanner;

public class PasswordValidator { 
	
	 public static void main(String[] args) { 
		 
		 Scanner scanner = new Scanner(System.in);
		    System.out.println("🛡️ Welcome to Bank Password Setup 🛡️");

		    System.out.print("Create your password: ");
		    String password = scanner.nextLine();

		    boolean isValid = true;

		    // Check 1: Length at least 8 characters
		    if (password.length() < 8) {
		        System.out.println("❌ Password must be at least 8 characters long.");
		        isValid = false;
		    }

		    // Check 2: At least one uppercase letter
		    boolean hasUppercase = false;
		    for (int i = 0; i < password.length(); i++) {
		        if (Character.isUpperCase(password.charAt(i))) {
		            hasUppercase = true;
		            break;
		        }
		    }
		    if (!hasUppercase) {
		        System.out.println("❌ Password must contain at least one uppercase letter.");
		        isValid = false;
		    }

		    // Check 3: At least one digit
		    boolean hasDigit = false;
		    for (int i = 0; i < password.length(); i++) {
		        if (Character.isDigit(password.charAt(i))) {
		            hasDigit = true;
		            break;
		        }
		    }
		    if (!hasDigit) {
		        System.out.println("❌ Password must contain at least one digit.");
		        isValid = false;
		    }

		    // Final output
		    if (isValid) {
		        System.out.println("✅ Your password is valid. You may proceed.");
		    } else {
		        System.out.println("⚠️ Please try again with a valid password.");
		    }

		    scanner.close();
		}	                 
}