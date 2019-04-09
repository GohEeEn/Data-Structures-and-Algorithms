package Sorting_Algorithms;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Random;

import List.LinkedList;
import List.List;

public class MergeSort {
   
	/**
     * A simple test method.
     * @param args
     */
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new LinkedList<Integer>();
        while (list.size() < 100) {
            list.insertLast(random.nextInt(100));
        }
        
        System.out.println("Original Sequence\t: " + list);		// Before Sorting
        
        mergeSort(list);								
        System.out.println("Ascendingly Sort\t: " + list);  // After Normal Sorting 
        
        mergeSortX(list, new Comparator<Integer>() {
        	@Override
        	public int compare(Integer o1, Integer o2) {
        		return -o1.compareTo(o2); 					// return negative : Sort in descending order
        	}
        });
        System.out.println("Descendingly Sort\t: " + list); // After Comparator Sorting X
    }

    /**
     * The main Merge Sort algorithm
     * @param S the list to be sorted
     * @param <T> the type of value stored in the list
     */
    public static <T extends Comparable<T>> void mergeSort(List<T> S) {
        
    	if (S.size() > 1) {
            List<T>[] sublists = partition(S, S.size()/2);
            mergeSort(sublists[0]);
            mergeSort(sublists[1]);
            merge(S, sublists[0], sublists[1]);
        }
    }

    /**
     * The partitioning algorithm
     * @param S the list to be partitioned
     * @param n the approximate size of each partititon +/-1
     * @param <T> the type of value stored in the list
     * @return to sublists S0, S1 respectively
     */
    private static <T> List<T>[] partition(List<T> S, int n) {
        @SuppressWarnings("unchecked")
		List<T>[] sublists = (List<T>[]) Array.newInstance(List.class,2);
        sublists[0] = new LinkedList<T>();
        sublists[1] = new LinkedList<T>();

        while (S.size() > n) { // Insert the first half of elements as the LEFT part 
            sublists[0].insertLast(S.remove(S.first()));
        }
        while (!S.isEmpty()) { // Insert remaining elements as the RIGHT part
            sublists[1].insertLast(S.remove(S.first()));
        }
        return sublists;
    }

    /**
     * The merge algorithm :<br>
     * @brief Output expected : sorted sequence of S1 U S2
     * @param S the empty list that S1 and S2 will be merged into
     * @param S1 the first sorted sublist , assume sorted beforehand
     * @param S2 the second sorted sublist , assume sorted beforehand
     * @param <T> the type of value stored in the list
     */
    private static <T extends Comparable<T>> void merge(List<T> S, List<T> S1, List<T> S2) {
    	
    	if(!S.isEmpty()) {
    		System.out.println("Error : List S is NOT EMPTY");
    		return;
    	}
    	
    	// CASE 1 : When there are data in both sorted lists (Comparing and do insertion)
    	while(!S1.isEmpty() && !S2.isEmpty()) {
    		
    		// Insert the smaller value to the list 
    		if(S1.first().element().compareTo(S2.first().element()) < 0) 
    			S.insertLast(S1.remove(S1.first()));
    		else
    			S.insertLast(S2.remove(S2.first()));
    	}
    	// END of CASE 1
    	
    	// CASE 2 : When there are at least 1 list have no element left for comparing
    	while(!S1.isEmpty())
    		S.insertLast(S1.remove(S1.first()));
    	
    	while(!S2.isEmpty())
    		S.insertLast(S2.remove(S2.first()));
    	// END of CASE 2
    }
    
    /**
     * A version of mergeSort() that takes an instance of the java.util.Comparator interface
     * Create a modified merge(..) method that takes an instance of the Comparator as a parameter 
     * and uses the comparator to compare values
     */
    public static <T extends Comparable<T>> void mergeSortX(List<T> S, Comparator<T> comparator) {
    	
    	if (S.size() > 1) {
            List<T>[] sublists = partition(S, S.size()/2);
            mergeSortX(sublists[0], comparator);
            mergeSortX(sublists[1], comparator);
            mergeX(S, sublists[0], sublists[1], comparator);
        }
    }
    
    private static <T extends Comparable<T>> void mergeX(List<T> S, List<T> S1, List<T> S2, Comparator<T> comparator) {
    	
    	if(!S.isEmpty()) {
    		System.out.println("Error : List S is NOT EMPTY");
    		return;
    	}
    	
    	// CASE 1 : When there are data in both sorted lists (Comparing and do insertion)
    	while(!S1.isEmpty() && !S2.isEmpty()) {
    		
    		// Insert the smaller value to the list  
    		if(comparator.compare(S1.first().element(),S2.first().element()) < 0) 
    			S.insertLast(S1.remove(S1.first()));
    		else
    			S.insertLast(S2.remove(S2.first()));
    	}
    	// END of CASE 1
    	
    	// CASE 2 : When there are at least 1 list have no element left for comparing
    	while(!S1.isEmpty())
    		S.insertLast(S1.remove(S1.first()));
    	
    	while(!S2.isEmpty())
    		S.insertLast(S2.remove(S2.first()));
    	// END of CASE 2
    }
}
