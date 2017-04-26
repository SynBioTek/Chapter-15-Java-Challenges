package com.eclipse.EduardoZavala;

/**
 * The Account Class provides a method for comparing input values to an existing
 * array or numbers.
 * 
 * @author Eduardo Zavala
 * 
 *
 */
public class AccountClass {

	/**
	 * The account method searches an array for a value.
	 * 
	 * @param input
	 *            the input number
	 * @return found as true or false depending on search
	 */
	public static boolean account(int input) {
		// account array
		int accounts[] = { 5658845, 4520125, 7895122, 8777541, 8451277, 1302850, 8080152, 4562555, 5552012, 5050552,
				7825877, 1250255, 1005231, 6545231, 3852085, 7576651, 7881200, 4581002 };

		// Loop control variable
		int index = 0;

		// Search results
		boolean found = false;

		// Search the array.
		while (index < accounts.length) {
			if (accounts[index] == input) {
				found = true;
			}
			// Increment index
			index++;
		}

		// Return result of search
		return found;

	}

}
