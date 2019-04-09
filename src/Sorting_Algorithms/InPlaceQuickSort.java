package Sorting_Algorithms;

import java.util.Random;
import Vector.ArrayVector;
import Vector.Vector;

public class InPlaceQuickSort {
    private static Random random = new Random();

    /**
     * Simple test method
     *
     * @param args
     */
    public static void main(String[] args) {
        
    	Vector<Integer> vector = new ArrayVector<Integer>();
        
    	while (vector.size() < 8) {

            vector.insertAtRank(vector.size(), random.nextInt(100));
        }
        
        System.out.println("[Before] " + vector); 
        inPlaceQuickSort(vector);
        System.out.println("[After ] " + vector);
    }

    /**
     * The headline method that triggers the in-place quick sort
     * @param V the vector being sorted
     * @param <T> the type of element in the Vector
     */
    public static <T extends Comparable<T>> void inPlaceQuickSort(Vector<T> V) {
        inPlaceQuickSort(V, 0, V.size()-1);
    }

    /**
     * The main in-place quicksort implementation (is called recursively for different ranges of V)
     * @param V the Vector being sorted
     * @param l the lower bound
     * @param r the upper bound
     * @param <T> the type of element in the Vector
     */
    private static <T extends Comparable<T>> void inPlaceQuickSort(Vector<T> V, int l, int r) {
        
    	if (l > r) return; // sorted

        int pivot = l + ((l==r) ? 0 : random.nextInt(r-l)); // Position of random pivot
        int newPivot = inPlacePartition(V, l, r, pivot);
        
        inPlaceQuickSort(V , l , newPivot - 1); // Sort the sublist that contains the elements that SMALLER than pivot
        inPlaceQuickSort(V , newPivot + 1 , r); // Sort the sublist that contains the elements that BIGGER than pivot
    }

    /**
     * Implements the in place partition for the range [l,r] of V using pivot x.
     * @param V the vector
     * @param l the lower bound
     * @param r the upper bound
     * @param x the index of the pivot in the list
     * @param <T> the type of element in the Vector
     * @return an array containing the upper bound for L (index 0) and the lower bound for G (index 1)
     */    
    private static <T extends Comparable<T>> int inPlacePartition(Vector<T> V, int left, int right, int pivot) {   
    	
    	// Value used for comparison
    	T pivotVal = V.elemAtRank(pivot);
    	
    	// Temporarily move the pivot value to the most right position so that it won't touch the pivot value while sorting
    	swapElem(V,pivot,right);
    	
    	/* 	DEBUG
    	 	System.out.println("Pivot at : " + pivot + " ["+ pivotVal + "]" + " ; lowerBound : " + left + " ; upperBound : " + right);
    	 	System.out.println("Before : " + V);
    	*/
    	
    	// Counter that count the number of elements that smaller than pivot 
    	int storeIndex = left; 
    	
    	// Sorting Algorithm : range [ left , right-1 (before pivot) ]
    	for(int i = left ; i <= right - 1 ; i++) {
    		
    		// Element that < than the pivot value goes to the left
    		if(V.elemAtRank(i).compareTo(pivotVal) < 0) {
    			swapElem(V,i,storeIndex);
    			storeIndex++;
    		}
    		// else Element that >= than pivot value remains (Be at the right at last)
    	}
   
    	swapElem( V , storeIndex , right );
    	// System.out.println("After  : " + V); DEBUG
    	
    	return storeIndex;
    }
    
    private static <T> void swapElem(Vector<T> V, int l, int r) {
    	
		T temp = V.elemAtRank(l);
		V.replaceAtRank(l, V.elemAtRank(r));
		V.replaceAtRank(r, temp);
    }

    /**
     * Useful method to to print out part of the Vector
     * @param V the vector being sorted
     * @param l the lower bound
     * @param r the upper bound
     * @param <T> the type of the Vector
     */
    private static <T extends Comparable<T>> void printRange(Vector<T> V, int l, int r) {
        for (int i = l; i <= r; i++) {
            System.out.print(V.elemAtRank(i)+" ");
        }
        System.out.println();
    }

}
