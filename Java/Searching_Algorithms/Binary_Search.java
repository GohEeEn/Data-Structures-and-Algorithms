package Searching_Algorithms;

/* Recursive Binary Search */

/*
	Divide-and-conquer algorithm :
	
	Problem : 
		find a key k in an array z[ 0 , 1 , ... , n-1 ] in sorted order
		
	Steps :
	1. Compare key k with z[n/2]
	2. Depending on the result 
		a. Recurse either on the first half of array, z[ 0 , ... , n/2 - 1 ]
		b. Recurse on the second half of array, z[ n/2 , ... , n - 1 ]
	
	Recurrence Relation :
	>> Called on subarray of length approximately n / 2
	>> There are c comparisons in the worst case before a recursive call is needed again
	>> T(n) = T(n/2) + c

		T(n)	The worst-case time of the algorithm needed
		n		The array length
		c		Number of comparison needed in the worst case before a recursive call is needed again
*/

public class Binary_Search{
	 
	/**
	*	Searching algorithm of a recursive binary search
	* 	@param A
	*		
	*/
	public int search(int[] A, int key, int low, int high){
		
		if( high < low )
			return high;
		
		int mid = ( low + high )/2;
		
		if( A[mid] > key )
			return search( A , key , low , mid - 1 );
		else if( A[mid] < key )
			return search( A , key , mid + 1 , high );
		else
			return mid;
	}
}