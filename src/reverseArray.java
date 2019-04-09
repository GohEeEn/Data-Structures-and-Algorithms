// Reverse Array by using Recursion : Linear Recursion

/*
	Pseudocode :
	Input 	: An array A and non-negative integer indices i and j 
	Output 	: Reversal of elements in A starting at i and ending at j
	function REVERSEARRAY( A , i , j )
		
		if i < j then 
			swap A[i] and A[j]
			ReverseArray( A , i + 1 , j - 1 );
		end if 
		return 
	end function
	
	Base Cases : i = j && i > j
	Recursive Step : 
		If the length of array is 
		> Odd => i = j case
		> Even => i > j case
		
	Benefits :
	-> Allow us to take advantage of the repetitive structure present in problem
	-> Avoid complex case analyses and nested loop
	
	DEBUG :
	> Works of swapElement method useless as it doesn't modify the original array
	> Swap process done in recursion method
*/
import java.util.Arrays;

public class reverseArray{
	
	/**
	*	Reverse the array by using recursion method<br/>
	*	> Recursive, tail recursion<br/>
	*	> Growth Factor : O(n)<br/>
	*	> Memory Required : O(n) , stack of recursive method call<br/>
	*/
	public static void recursion( int[] A, int i , int j ){
		
		// Index checker
		if( i < 0 || j < 0 )
			// System.out.println("Invalid Indices");
			return;
		
		// Recursive Case : Only condition to check if the recursion continue
		if( i < j ) {
			// swap the array elements 
			int tmp = 0;
			tmp = A[i];
			A[i]= A[j];
			A[j]= tmp;
				
			recursion( A , i+1 , j-1 ); // recursion call to swap inner array elements
		}
		
		// Else case : [ Terminal Case / Base Case ]
		// i = j , odd number of length
		// i > j , even number of length 
	}
	
	/**
	*	Reverse the array by using iteration method<br/>
	*	> Non-recursive<br/>
	*	> Growth Factor : O(n)<br/>
	*	> Memory Required : O(1), only required single stack method call<br/>
	*/
	public static void iteration( int[] A, int i , int j ){
		
		// Index checker
		if( i < 0 || j < 0 )
			// System.out.println("Invalid Indices");
			return;
		
		// Recursive Case 
		while( i < j ){
			int tmp = 0;
			
			// swap the array elements 
			tmp = A[i];
			A[i]= A[j];
			A[j]= tmp;
			
			++i;
			--j;
		}
	}
	


	public static void main(String[] args){
		
		int[] arrayOdd = { 0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 };
		int[] arrayEven = { 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 };
		
		// Reversing by using recursive method
		recursion(arrayOdd , 0 , arrayOdd.length - 1 );
		recursion(arrayEven , 0 , arrayEven.length - 1 );
		
		System.out.println(Arrays.toString(arrayOdd));
		System.out.println(Arrays.toString(arrayEven));
		
		// Reversing by using iterative method [ Double reversed : back to original ]
		iteration(arrayOdd , 0 , arrayOdd.length - 1 );
		iteration(arrayEven , 0 , arrayEven.length - 1 );
		
		System.out.println(Arrays.toString(arrayOdd));
		System.out.println(Arrays.toString(arrayEven));
	}
}