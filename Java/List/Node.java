package List;

	/**
	* The definition of Node class that used for SinglyLinkedList 
	*/
	public class Node<T> {
		
		private T data;
	    private Node<T> next;
	    
	    /**
	     * Default node definition
	     */
	    public Node() {
	        this.data = null;
	        this.next = null;
	    }
	    
	    /**
	    * Definition of a node in a linked list
	    * @param e
	    * 		The data / value stored in a node
	    * @param n
	    * 		The node reference to the next node
	    */
	    public Node(T e, Node<T> n) {
	        this.data = e;
	        this.next = n;
	    }
	        
	    // Accessor Methods
	    /**
	    * Get the data stored in the current node
	    * @return
	    * 		The data 
	    */
	    public T getData(){ return this.data; }
	        
	    /**
	    * Get the reference of the next node
	    * @return
	    * 		The reference to the next node in the list
	    */
	    public Node<T> getNext() { return this.next; }
	       
	    // Mutator Methods
	    /**
	    * Set the value stored in the current node
	    * @param value
	    * 		The given value to store in the current node
	    */
	    public void setData(T value) { this.data = value; }
	        
	    /**
	     * Set the new reference to the next node in the current node
	     * @param nextNode
	     * 		The given new node reference
	     */
	    public void setNext(Node<T> nextNode) { this.next = nextNode;}
	}