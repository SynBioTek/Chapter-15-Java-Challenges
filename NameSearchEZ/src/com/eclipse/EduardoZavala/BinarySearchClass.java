package com.eclipse.EduardoZavala;

public class BinarySearchClass {

	public static boolean binarySearchMethod(String[] sortedNames, String inputName, int index) {

		// Base case

		if (index == sortedNames.length - 1) {
			return false;
		}
		// compare input and strings in ingredients array ignoring case
		if (sortedNames[index].equalsIgnoreCase(inputName)) {
			return true;
		} else
			// Recursive method
			return binarySearchMethod(sortedNames, inputName, ++index);
	}
}
