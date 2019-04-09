package Vector;

/**
 * Doubly-linked node implementation 
 * @author Ee En Goh
 * @param <T>	Any class / data type of stored value 
 */
public class Node<T>{
	
	private T data;
	private Node<T> next;
	private Node<T> prev;
	
	Node(){
		this.data = null;
		this.next = null;
		this.prev = null;
	}
	
	/**
	 * Overloaded constructor with initialization
	 * @param e	Initialized element value
	 * @param n	Initialized reference to the next node
	 */
	Node(T e, Node<T> p, Node<T> n){
		this.data = e;
		this.prev = p;
		this.next = n;
	}	
	
	// ----- Accessor Methods -----
    /**
    * Get the data stored in the current node
    * @return
    * 		The data 
    */
    public T getData(){ return this.data; }
    
    /**
     * Get the reference of the previous node
     * @return
     * 		The reference to the previous node in the list
     */
    public Node<T> getPrev() { return this.prev; }
    
    /**
    * Get the reference of the next node
    * @return
    * 		The reference to the next node in the list
    */
    public Node<T> getNext() { return this.next; }
       
    // ----- Mutator Methods -----
    /**
    * Set the value stored in the current node
    * @param value
    * 		The given value to store in the current node
    */
    public void setData(T value) { this.data = value; }
     
    /**
     * Set the new reference to the previous node saved in the current node
     * @param prevNode
     * 		The given new node reference
     */
    public void setPrev(Node<T> prevNode) { this.prev = prevNode;}
    
    /**
     * Set the new reference to the next node saved in the current node
     * @param nextNode
     * 		The given new node reference
     */
    public void setNext(Node<T> nextNode) { this.next = nextNode;}
}