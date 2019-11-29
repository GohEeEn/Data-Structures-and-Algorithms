package Searching_Algorithms;

import java.util.List;

/**
 * The simplest searching algorithm that relies on the technique of traversing a list
 * from start to end by exploring properties of all the elements that are found on the way
 * 
 * Let n be the length of the list, 
 * Time Complexity : O(n), since each element in a list only compared once
 * Space Complexity : O(n)
 * 
 * @author Ee En Goh
 *
 * @param <T> Data type of searching target
 */
public class LinearSearch<T> {

	/** Any value that need to be found */
	private T target;
	private List<T> searchList;
	

	// Expect user to enter the target and searchList when initialize it
	LinearSearch(T target, List<T> searchList){
		this.target = target;
		this.searchList = searchList;
	}
	
	public boolean isFound() {
		if(!(search(this.target) < 0)) return true;
		return false;
	}
	
	public boolean isFound(T target) {
		if(!(search(target) < 0)) return true;
		return false;
	}
	
	public T getTarget() {
		return target;
	}

	public void setTarget(T target) {
		this.target = target;
	}
	
	public int atIndex() {
		return search(this.target);
	}
	
	private int search() {
		
		if(this.searchList.isEmpty()) return -1;
		
		for(int i = 0 ; i < this.searchList.size() ; i++)
			if(this.searchList.get(i).equals(this.target)) return i;
		
		return -1;
	}
	
	private int search(T target) {
		
		if(this.searchList.isEmpty()) return -1;
		
		for(int i = 0 ; i < this.searchList.size() ; i++)
			if(this.searchList.get(i).equals(target)) return i;
		
		return -1;
	}
	

	private int search(List<T> list) {
		
		if(list.isEmpty()) return -1;
		
		for(int i = 0 ; i < list.size() ; i++)
			if(list.get(i).equals(target)) return i;
		
		return -1;
	}
	
	private int reverseSearch(List<T> list) {
		
		if(list.isEmpty()) return -1;
		
		for(int i = list.size() - 1 ; i <  0 ; i--) 
			return i;
		
		return -1;
	}
}
