package com.eclipse.EduardoZavala;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This program reads names of file into a String array. Then using the
 * Quicksort algorithm it sorts the names in ascending order (A to Z). Then it
 * allows the user to search for a name in the array with the binary search
 * algorithm.
 *
 * @author Eduardo Zavala
 *
 */
public class NameSearchDemo {

	public static void main(String[] args) throws IOException {
		// Instance of Scanner class
		Scanner keyboard = new Scanner(System.in);

		// Call the Open file method
		String unsortedNames[] = openFile();

		// Call the quickSort method and store input in newly sorted array
		String sortedNames[] = QuicksortClass.quickSort(unsortedNames);

		// Code used to verify that names were being sorted correctly.
		/*
		 * System.out.println("Sorted Names are"); for (int i = 0; i <
		 * sortedNames.length; i++) System.out.println(sortedNames[i]);
		 */
		// variable used in do while loop
		String choice;
		do {
			// Prompt user to enter a name to search
			System.out.println("Enter a female first name you think was popular in the 90's");

			// Store input
			String inputName = keyboard.nextLine();

			// Call binarySearch method passing the sortedNames array,
			// user input, and index as arguments.
			// Then store result of search in boolean data type.
			int index = 0;
			boolean result = BinarySearchClass.binarySearchMethod(sortedNames, inputName, index);

			// Display message stating whether or not input name was found.
			if (result == false)
				System.out.println("Sorry the name " + inputName + " was NOT popular in the 90's");
			else
				System.out.println("The name " + inputName + " was a popular female name in the 90s.");

			// Search again?
			System.out.println("Try again? " + "(Y or N): ");
			choice = keyboard.nextLine();
		}

		while (choice.charAt(0) == 'y' || choice.charAt(0) == 'Y');
		if (choice.charAt(0) != 'Y') {
			System.out.println("Closing NameSearchDemo...Goodbye");
			// Close scanner
			keyboard.close();
		}
	}

	/**
	 * The openFile method opens the names.txt file containing 65 popular female
	 * names in the 90's
	 * 
	 * @return unosortedNamesArray after the content of file is transfered into
	 *         an array.
	 * @throws IOException
	 */
	public static String[] openFile() throws IOException {
		// Read streams of characters from file
		FileReader file = new FileReader("names.txt");

		BufferedReader bufferedReader = new BufferedReader(file);
		List<String> lines = new ArrayList<String>();
		String flag = null;

		while ((flag = bufferedReader.readLine()) != null) {
			lines.add(flag);
		}

		bufferedReader.close();

		// Store input into an array
		String unosortedNamesArray[] = lines.toArray(new String[lines.size()]);

		return unosortedNamesArray;

	}

}
