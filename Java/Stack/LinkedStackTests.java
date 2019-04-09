package Stack;

/**
 * Class created to test the self-defined LinkedStack 
 * @author Ee En Goh
 * @version 31 Jan 2019
 */
public class LinkedStackTests{
	
	public static void main(String[] args) {
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		
		// Initialize the stack elements
		for(int i = 0 ; i < 10 ; i++)
			stack.push(i);
		
		System.out.println("Original Stack AFTER initialization :\n" + stack);
		System.out.println("The top element of current stack : " + stack.top());
		System.out.println();
		
		System.out.println("First pop remove [" + stack.pop() + "] , then\n " + stack);
		System.out.println("Top element of current stack : " + stack.top());
		System.out.println("Is this stack empty ? " + stack.isEmpty() + " , size = " + stack.getSize());
	}
}