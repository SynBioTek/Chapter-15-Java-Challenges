package com.eclipse.EduardoZavala;

import java.util.Scanner;

/**
 * This program demonstrates a recursive boolean method named isMember. The
 * method searches an array for a specified value and returns true if the value
 * is found in the array, or false if the value is not found in the array.
 *
 */

public class IsMemberDemo {
	public static void main(String[] args) {
		// variable used in do while loop
		String choice;

		// Welcome user
		System.out.println("Welcome to: Fajita Recipe pop-quiz!");
		System.out.println("Test your knowledge on making fajitas");

		do {
			// Ask user for input
			System.out.println("Enter an ingredient that may be used to make fajitas! ");

			// Create a Scanner object for keyboard input.
			Scanner keyboard = new Scanner(System.in);

			String input = keyboard.nextLine();
			int index = 0;
			boolean result = recursiveSequencialSearch(input, index);

			// Display the results.
			if (result == false) {
				System.out.println("Sorry " + input + " is not typical ingredient in fajitas .");
			} else {
				System.out.println("CORRECT!, It wouldn't be fajitas without " + input + "!");
			}

			// Does the user want to search again?
			System.out.println("Try again? " + "(Y or N): ");
			choice = keyboard.nextLine();

		} while (choice.charAt(0) == 'y' || choice.charAt(0) == 'Y');

		// Close Scanner
		// keyboard.close();
	}

	private static boolean recursiveSequencialSearch(String input, int index) {

		String ingredients[] = { "beef", "chicken", "tortillas", "tomato", "lettuce", "hot sauce", "avocado", "cheese",
				"onion", "garlic", "cumin", "bell  pepper", "oregano", "canola oil", "lemon juice" };

		if (index == ingredients.length - 1) {
			return false;
		}
		if (ingredients[index].equals(input)) {

			return true;
		} else
			return recursiveSequencialSearch(input, ++index);
	}
}
