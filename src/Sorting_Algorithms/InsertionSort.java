package Sorting_Algorithms;

import java.util.Random;

public class InsertionSort{
	
	/**
	 * Insertion Sorting Algorithm
	 * @param arr	Given Array 
	 */
	void sort(int arr[]) 
	{ 
	   int i, key, j; 
	   for (i = 1; i < arr.length ; i++) 
	   { 
	       key = arr[i]; 
	       j = i-1; 
	  
	       /* Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position */
	       while (j >= 0 && arr[j] > key) 
	       { 
	           arr[j+1] = arr[j]; 
	           j = j-1; 
	       } 
	       arr[j+1] = key; 
	   } 
	} 
	
	// Main Method
	public static void main(String args[]) {
		
		// Random Generating Value
		Random random = new Random(20010);
	
		InsertionSort ob = new InsertionSort();
		
		// Header 
		System.out.println("Input\t\tTime(ms)\tTime(s)");
		
		// Insertion Algorithm Analysis Method ( 1000 <= x <= 100000000 )
		for(int n = 1000; n < 10000000; ) {
			int[] arr = new int[n];
			
			// Create random input to 
			for(int i = 0; i < n; ++i) {
				arr[i] = random.nextInt();
			}
			final long startTime = System.currentTimeMillis(); 				 // Save the sorting algorithm start time
			ob.sort(arr);													 // Insertion Sort
			final long elapsedTime = System.currentTimeMillis() - startTime; // Calculate the total time required for the complete time for sorting algorithm,  
			System.out.println("" + n + "\t\t" + elapsedTime + "\t\t" + elapsedTime/1000);
			n = (int) (n * 1.5);											 // Increase the size of the next parameter	
		}
	}
}