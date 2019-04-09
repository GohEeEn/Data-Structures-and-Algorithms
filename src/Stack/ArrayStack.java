package Stack;
/**
* Array-based Stack<br/>
* -> Stack with the maximum size of 100<br/>
* -> Consists of :<br/>
* 	>> N-element array data<br/>
* 	>> An integer variable top, the index of the top element in array S<br/>
* -> Finite Capacity
* 	>> Memory management issues
* 	>> Application logic issues
* 	>> Running time : O(n) for both pop and push running times  
*  @author Ee En Goh
*/
public class ArrayStack<E> implements Stack<E>{
		
	/** The default maximum size of the stack */
	private static int size = 10; 					
		
	/** The index of the top element in the array stack, and also indicate the size of stack used */
	private int top = -1;							
		
	/** The array-based stack */
	private E[] data ; 
	
	/* Constructor : constructs stack with given capacity */
	/** Default Constructor */
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		data = (E[]) new Object[size]; 
	}
	
	/** Overloaded Constructor */
	@SuppressWarnings({"unchecked"})
	public ArrayStack(int capacity) {
		data = (E[]) new Object[capacity];
		// size = capacity;
	}
		
	// ----- Accessor Method -----
	/**
	 * The accessor method to access the size of stack used (memory location) 
	 * @return
	 * 		int, that indicate the size of stack used
	 */
	@Override
	public int getSize(){ return (this.top + 1) ; }
		
	/**
	 * Boolean method that check if the array is empty or used
	 * @return
	 * 		true if there is no data in the stack<br/>
	 *  	false if there is data in the stack<br/>
	 */
	@Override
	public boolean isEmpty() {
		if(top < 0)
			return true;
		return false;
	}
		
	/**
	 * The accessor method that return the value of the top stack without removing it
	 * @return
	 * 		The String value of the top stack
	 */
	@Override
	public E top() {
			
		if(isEmpty()) {
			System.out.println("Error : This stack is empty");
			return null;
		}
		else 
			return data[top];
	}
		
	// ----- Operating Method ----- 
	/**
	 * One of the two major methods in the stack structure<br/>
	 * >> Pushing 
	 * >> It push a new data set into the stack and placed on top  
	 * @param input
	 * 		The data assigned to the new stack element
	 */
	@Override
	public void push( E input ) throws IllegalStateException{
		// Case if the stack is full
		if(getSize() == size) { 
			System.out.println("Error : The stack has full [Array] ");
			throw new IllegalStateException("Stack is full");
		}
		
		// Else 
		top++; 				// increment the top counter / add in a new data to stack
		data[top] = input;	// Assign data to the new stack
	}
		
	/**
	 * Popping
	 * >> It remove the top stack element from the stack and return the removed value
	 * @return
	 * 		The data that has been removed
	 */
	@Override
	public E pop() {
			
		if(isEmpty())
			return null;
		else {			
			E removed = data[top];
			top--;
			return removed;
		}		
	}
	
	/**
	 * Modify the stack value to become a String value for display
	 */
	public String toString() {
		
		if(isEmpty()) {
			System.out.println("The stack is empty");
			return null;
		}
		
		String output = "\nStack size : " + getSize() + "\n" ;
		
		for(int i = top ; i >= 0 ; i--) {	// Debug : Top is the integer that shows the stack size
			
			output += "=================\n";
			output += "[\t" + data[i] + "\t]\n";
		}
		output += "=================\n";
		
		return output;
	}
	
	/**
	 * Test Case of this ArrayStack
	 */
	public static void main(String[] agrs) {
		
		// Declare a new ArrayStack object 
		ArrayStack<Integer> stack = new ArrayStack<Integer>(20);
		
		System.out.println("Original Stack BEFORE initialization : " + stack + "\n");
		
		// Initialize the value stored in the array stack
		for(int i = 0 ; i < ArrayStack.size ; i++)
			stack.push(i);							// Create and push the element into the stack
		
		System.out.print("Original Stack AFTER initialization : " + stack);
		System.out.print("Top element of current stack : " + stack.top());
		
		System.out.println("\n");
		System.out.println("First pop remove [" + stack.pop() + "] , then " + stack);
		System.out.println("Top element of current stack : " + stack.top());
		
		System.out.println("\nSecond pop remove [" + stack.pop() + "] , then " + stack);
		System.out.println("Top element of current stack : " + stack.top());
	}
}
