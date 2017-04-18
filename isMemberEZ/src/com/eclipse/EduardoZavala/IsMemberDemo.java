package com.eclipse.EduardoZavala;

import java.util.Scanner;

/**
 * This program demonstrates a recursive boolean method named isMember. The
 * method searches an array for a specified value and returns true if the value
 * is found in the array, or false if the value is not found in the array.
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

			// Get user input
			String input = keyboard.nextLine();

			// Initialize index at 0
			int index = 0;
			// Pass input and index as arguments to isMember method and store
			// return in result
			boolean result = isMember(input, index);

			// Display the results.
			if (result == false) {
				System.out.println("Sorry " + input + " is not typical ingredient in fajitas .");
			} else {
				System.out.println("CORRECT!, It wouldn't be fajitas without " + input + "!");
			}

			// Search again?
			System.out.println("Try again? " + "(Y or N): ");
			choice = keyboard.nextLine();

		} while (choice.charAt(0) == 'y' || choice.charAt(0) == 'Y');

	}

	/**
	 * The isMember method uses a recursive sequential search approach to plow
	 * through a string array in search of matching input from the user.
	 * 
	 * @param input
	 *            user input string
	 * @param index
	 *            used to stop recursion and as array marker
	 * @return boolean value of search
	 */
	private static boolean isMember(String input, int index) {
		// Array of strings
		String ingredients[] = { "beef", "chicken", "tortillas", "tomato", "lettuce", "hot sauce", "avocado", "cheese",
				"onion", "garlic", "cumin", "bell  pepper", "oregano", "canola oil", "lemon juice" };
		// Base case
		if (index == ingredients.length - 1) {
			return false;
		}
		// compare input and strings in ingredients array ignoring case
		if (ingredients[index].equalsIgnoreCase(input)) {
			return true;
		} else
			// Recursive method
			return isMember(input, ++index);
	}
}
