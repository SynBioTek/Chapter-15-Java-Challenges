package com.eclipse.EduardoZavala;

/**
 * The QuickSorter class provides a method for performing a QuickSort on a
 * string array in alphabetical order (A-Z)
 */
public class QuicksortClass {

	/**
	 * The quickSort method calls the doQuickSort method to sort string array.
	 * 
	 * @param array
	 *            the array to sort.
	 * @return array the sorted array
	 */

	public static String[] quickSort(String array[]) {
		// Pass the array, starting value of 0 and length of array
		doQuickSort(array, 0, array.length - 1);

		// Return array after sorting is complete
		return array;
	}

	/**
	 * The doQuickSort is a recursive method that sorts a string array.
	 * 
	 * @param array
	 *            unsorted array.
	 * @param start
	 *            The starting subscript of array
	 * @param end
	 *            The ending subscript array
	 */

	private static void doQuickSort(String array[], int start, int end) {
		// Variable to divide the array into two sublists
		int pivot;

		// Begin QuickSort
		if (start < end) {

			// Get the pivot point.
			pivot = partition(array, start, end);

			// RecurviSort the first sub list.
			doQuickSort(array, start, pivot - 1);

			// Sort the second sub list.
			doQuickSort(array, pivot + 1, end);

		}

	}

	/**
	 * The partiton method selects a pivot value in an array and arranges the
	 * array into two sub lists. All the values less than the pivot will be
	 * stored in the left sub list and all the values greater than or equal to
	 * the pivot will be stored in the right sub list.
	 * 
	 * @param array
	 *            The array to partition.
	 * @param start
	 *            The starting subscript of the area to partition.
	 * @param end
	 *            The ending subscript of the area to partition.
	 * @return The subscript of the pivot value.
	 */

	private static int partition(String array[], int start, int end) {
		String pivotValue; // To hold the pivot value
		int endOfLeftList; // Last element in the left sub list.
		int mid; // To hold the mid-point subscript

		// Find the subscript of the middle element.
		// This will be our pivot value.
		mid = (start + end) / 2;

		// Swap the middle element with the first element.
		// This moves the pivot value to the start of
		// the list.
		swap(array, start, mid);

		// Save the pivot value for comparisons.
		pivotValue = array[start];

		// For now, the end of the left sub list is
		// the first element.
		endOfLeftList = start;

		// Scan the entire list and move any values that
		// are less than the pivot value to the left
		// sub list.
		for (int scan = start + 1; scan <= end; scan++) {
			if (array[scan].compareTo(pivotValue) < 0) {
				endOfLeftList++;
				swap(array, endOfLeftList, scan);
			}
		}

		// Move the pivot value to end of the
		// left sub list.
		swap(array, start, endOfLeftList);

		// Return the subscript of the pivot value.
		return endOfLeftList;
	}

	/**
	 * The swap method swaps the contents of two elements in an int array.
	 * 
	 * @param The
	 *            array containing the two elements.
	 * @param a
	 *            The subscript of the first element.
	 * @param b
	 *            The subscript of the second element.
	 */

	private static void swap(String[] array, int a, int b) {
		String temp;

		temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static void display(String b[]) {
		// display(unsortedNames);
		System.out.println("Names are ");

		for (String element : b) {

			System.out.println(element);

		}
	}

}
