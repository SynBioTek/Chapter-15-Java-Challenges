package com.eclipse.EduardoZavala;

import java.util.Scanner;

/**
 * This program has a class with a method that accepts a charge account number
 * as its argument. The method compares argument to a list of numbers. The
 * numbers are stored in an array and located using sequential search. The
 * method returns true or false depending on the search.
 * 
 * @author Eduaro Zavala
 *
 */
public class ChargeAccountDemo {
	public static void main(String[] args) {
		// Instance of Scanner class
		Scanner keyboard = new Scanner(System.in);

		// Prompt user to enter a charge account number.
		System.out.println("Enter account number");

		// Validate user input for numerical input
		while (!keyboard.hasNextDouble()) {
			System.out.print("Please enter a number ");
			keyboard.next();
		}
		// Store input as a string
		int input = keyboard.nextInt();

		// Call account method and pass array as argument
		boolean result = AccountClass.account(input);

		// Display message stating whether number is valid or invalid
		if (result) {
			System.out.println("The account number " + input + " is valid:");
		} else {
			System.out.println("The account number " + input + " is NOT valid: ");
		}

		// Close Scanner
		keyboard.close();
	}

}
