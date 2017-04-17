package com.eclipse.EduardoZavala;

import java.util.Scanner;

/**
 * This program has a recursive method that accepts a string as its argument and
 * prints the string in reverse order.
 * 
 */

public class StringReverserDemo {

	public static void main(String[] args) {

		// Instance of Scanner Class
		Scanner keyboard = new Scanner(System.in);

		// Print instructions
		System.out.print("Enter a string of letters and I'll reverse the order");

		// Get user input
		String input = keyboard.nextLine();

		// Call toReverse method passing string input along with the length -1
		String reversedString = toReverse(input, input.length() - 1);

		// Display output
		System.out.print("Your string is: " + reversedString);

		// Close scanner
		keyboard.close();

	}

	// Recursive method to reverse the order of input string.
	static String toReverse(String string, int index) {
		if (index == 0) {
			return string.charAt(0) + ""; // Base case
		}
		char letter = string.charAt(index);
		return letter + toReverse(string, index - 1);
	}
}
