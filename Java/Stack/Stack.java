package Stack;

/**
 * Interface of Stack 
 * @author Ee En Goh
 * @version 31 Jan 2019
 */
public interface Stack<E> {
	
	/** 
	 * Accessor method that returns the number of elements in the stack 
	 */
	int getSize();
	
	/** 
	 * Method that indicates whether the stack is empty 
	 */
	boolean isEmpty();
	
	/** 
	 * Method that returns the top element of the stack without removal
	 */
	E top();
	
	/** 
	 * Core method that inserts new element onto the top of the stack
	 * @param e		The value stored to the new node that will be inserted onto the stack 
	 */
	void push(E e);
	
	/** 
	 * Core method that removes and returns the top element from the stack 
	 */
	E pop();
}