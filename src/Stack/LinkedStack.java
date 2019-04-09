package Stack;

/**
 * Linked-based Stack<br/>
 * -> The objects are stored in linked-nodes <br/> 
 * -> Each node maintains a reference to the next node<br/>
 * 	>> Node, a reference to the object being stored in the stack<br/> 
 * 	>> A link to the next node in the stack <br/>
 * 	>> 2 special references : head and tail nodes<br/>
 * 		-> The tail node in the list is set to null<br/>
 * 		-> Infinite capacity<br/>
 * 	>> Run-time : O(1)<br/>
 * @author Ee En Goh
 * @version 31 Jan 2019
 */

public class LinkedStack<T> implements Stack<T>{
	
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	/** 
	 * Default constructor :<br>
	 * >> Declare a new linked-stack<br> 
	 */
	LinkedStack(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	};
	
	/**
	 * Overloaded constructor : <br>
	 * >> Declare a new linked-stack with the initialization of the head node;
	 * @param data		The initialized value of the first element that pushed onto the stack
	 */
	LinkedStack(T data){
		this.head.setData(data);
		this.tail = head;
		this.size = 1;
	};
	
	// ----- Accessor Methods -----
	/** Accessor method that returns the number of elements in the stack */
	public int getSize() { return this.size; }
	
	/** Method that indicates if the stack is empty */
	public boolean isEmpty() { return (this.size == 0); }
	
	/** Accessor method that returns the element at the top of the stack without removal */
	public T top() { return tail.getData(); };
	
	// ----- Stack operations -----
	/** Core method that inserts an element at the top of the stack 
	 *	@param	element		The initialized value of data that stored in the new node
	 */
	public void push(T element) { 
		
		Node<T> newNode = new Node<T>(element,null,null);
		
		if(isEmpty()) {
			this.head = newNode;
			this.tail = head;
			this.size = 1;
		}else {

			if(this.tail == this.head) {
				head.setNext(newNode);
				newNode.setPrev(this.head);
				tail = newNode;
			}else {
				tail.setNext(newNode);
				newNode.setPrev(tail);
				tail = newNode;
			}
			
			this.size++; // increment of size as new node pushed onto the stack
		}
	}
	
	/** Core method that removes and returns the top element from the stack */
	public T pop() { 
		
		if(isEmpty()){
			System.out.println("Message : This stack is currently empty");	// Empty stack : nothing to be removed
			return null;
		}
		else {
			T removed = tail.getData();
			
			tail.getPrev().setNext(null);
			tail = tail.getPrev();
			
			this.size--;
			return removed;
		}
	}
	
	// ----- Display Operation -----
	public String toString() {
		
		if(isEmpty()) {
			System.out.println("Message : This stack is currently empty");	// Empty stack : nothing to be removed
			return null;
		}
		
		String output = "Stack\n";
		
		Node<T> tmp = this.tail;
		
		output += "\t[ TOP ]\n";
		
		// Traverse and output the data stored from head node to the node before tail node
		for(int i = 0 ; i < getSize() - 1 ; i++) {
			output += "\t< " + tmp.getData() + " >\n";
			tmp = tmp.getPrev();
		}

		output += "\t< " + tmp.getData() + " >\n\t[BOTTOM]\n"; // Output the data stored in head node
		
		return output;
	}
}