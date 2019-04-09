package Stack;

import List.SinglyLinkedList;

/**
 * List-based Stack<br/>
 * -> The objects are stored in nodes in a linked list 
 * -> Each node maintains a reference to the next node in the list (link)
 * 	>> Node, a reference to the object being stored in the stack 
 * 	>> A link to the next node in the stack 
 * 	>> 2 special references : head and tail nodes
 * -> The tail node in the list is set to null
 * -> Infinite capacity
 * 	>> Run-time : O(1)
 * @author Ee En Goh
 *
 */

public class LinkedListStack<E> implements Stack<E>{
	
	/** The primary storage for elements of the stack */
	private SinglyLinkedList<E> list = new SinglyLinkedList<>();

	/** Constructs an initially empty stack */
	public LinkedListStack() {}; // new stack relies on the initially empty list
	
	// ----- Accessor Methods -----
	/** Returns the number of elements in the stack */
	public int getSize() { return list.size(); }
	
	/** Test whether the stack is empty */
	public boolean isEmpty() { return list.isEmpty(); }
	
	/** Returns the element at the top of the stack without removal */
	public E top() { return list.first().getData(); };
	
	// ----- Stack operations -----
	/** Inserts an element at the top of the stack */
	public void push(E element) { list.addFirst(element); }
	
	/** Removes and returns the top element from the stack */
	public E pop() { return list.removeFirst(); }
	
	// ----- Display Operation -----
	public String toString() {
		
		if(isEmpty()) {
			System.out.println("The stack is empty");
			return null;
		}
		
		String output = "Stack ";
		
		output += list.toString(); 
		
		return output;
	}
	
	/**
	 * Test case for the ListStack
	 */
	public static void main(String[] args) {
		
		LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
		
		System.out.println("Original Stack BEFORE initialization :\n" + stack);
		// Initialize the stack elements
		for(int i = 0 ; i < 10 ; i++)
			stack.push(i);
		
		System.out.println("Original Stack AFTER initialization :\n" + stack);
		System.out.println("The top element of current stack : " + stack.top());
		
		System.out.println("First pop remove [" + stack.pop() + "] , then " + stack);
		System.out.println("Top element of current stack : " + stack.top());
		
	}
}