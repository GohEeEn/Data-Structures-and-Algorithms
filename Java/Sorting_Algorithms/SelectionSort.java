package Sorting_Algorithms;

/* Selection Sort */

public class SelectionSort{
	
	public int[] sort(int[] A){
		
		int minIndex = 0;
		int minValue = 0;
		
		for(int i = 0 ; i < A.length ; i++){
			
			minIndex = i;
			minValue = A[i];
			
			for(int j = i ; j < minIndex ; j++){
			
				if(A[j] < minValue){
					
					minIndex = j;
					minValue = A[j];
				}
				A[minIndex] = A[i];
				A[i] = minValue ;
			}
		}
		return A;
	}
}