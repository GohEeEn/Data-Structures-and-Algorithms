package List;
import java.util.Iterator;

public class CircularlyLinkedList<E> implements Iterable<E>{
	
	private static class Node<T>{
		
		/** The data stored at this node */ 
		private T data;
		
		/** A reference to the subsequent node in the list */
		private Node<T> next;
		
		/**
		 * Default Constructor
		 * @param e
		 * 		The data stored in this new node
		 * @param n
		 * 		The reference that links to the next node
		 */
		public Node(T e , Node<T> n) {
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
        
        public String toString() { return this.data.toString(); }
    }
	
	// Instance variables of the CIrcularlyLinkedList
	
	/** The designated cursor in the list */
	private Node<E> tail = null;
	
	/** Size of the list : The total number of node in the linked list */
	private int size = 0;
	
	/** Constructors to initialize an empty list */
	public CircularlyLinkedList() {}
	
	// Access Methods
	/**
	 * Returns the number of elements in the linked list
	 * @return number of elements in the linked list
	 */
	public int size() { return size; }
	
	public boolean isEmpty() {return (size == 0); }
	
	/**
	 * Method to get the specific node
	 * @param index
	 * 		The list index of the specific node , start from 0
	 * @return
	 * 		The specific node
	 */
	public Node<E> getNode(int index){
		
		Node<E> current = tail.getNext(); // head node
		
		for( int i = 0 ; i < index ; ++i ) 
			current = current.next;
		
		return current;
	}
	
	/**
	 * Returns the first element of the list 
	 * @return Element at the front of the list or null if the list is empty
	 */
	public E first() {
		if(isEmpty()) return null;			// returns the first element
		return tail.getNext().getData();	// The head is after the tail in CircularlyLinkedList definition 
	}
	
	// Update Methods
	/**
	 * Rotate the first element to the back of the list 
	 */
	public void rotate() {	// Rotate the first element to the back of the list
		if(tail != null)			// If empty, do nothing
			tail = tail.getNext();	// The old head becomes the new tail
	}
	
	/**
	 * Adds an element to the end of the list
	 * @param e
	 * 		The new element to add
	 */
	public void addFirst(E e) {
		
		Node<E> newHead = new Node<E>( e , null ); // new head node
		
		if(isEmpty()) { 
			tail = newHead;			// As the list is empty , tail node is empty as well , thus we can't directly using setNext() method on tail node
			tail.setNext(newHead);	// Link to itself circularly , in this situation tail node is both tail and head node
		}
		else { 
			newHead.setNext(tail.getNext());
			tail.setNext(newHead);
		}
		size++;
	}
	
	/**
	 * Adds an element to the end of the list
	 * @param e The new element to add
	 */
	public void addLast(E e) {						
		// Adds element e to the end of the list
		addFirst(e);								// Insert new element at front of list
		this.rotate();								// Now new element becomes the tail
		// tail = tail.getNext();	Same Operation
	}
	
	/**
	 * Add a new node after specific node
	 * @param node
	 * 		The node that the new node will link after
	 * @param newData
	 * 		The value will be assigned to the new node
	 */
	public void addAfter(Node<E> node, E newData) {
		
		// Declare a new node to the next of specific node
		Node<E> newNode = new Node<E>(newData, node.getNext()); 
		node.setNext(newNode);
		++size;
	}
	
	/**
	 * Method to remove the first / head node in the list
	 * @return
	 * 		The value of the removed head node
	 */
	public E removeFirst() {		// removes and returns the first element
		
		if(isEmpty()) return null;			// nothing to remove
		Node<E> head = tail.getNext();
		if(head == tail) tail = null;		// must be the only node left
		else tail.setNext(head.getNext());	// Remove the reference to head from the list
		size--;
		
		return  head.getData(); 			// removed data
	}
	
	/**
	 * Method to return the display of data in String
	 */
	public String toString() {
		
		String output = "Size : " + size() + "\n";
		output += "[head] > ";
		
		// Enhanced for-loop
		for(E tmp : this) {
			output += tmp + " > " ;
		}
		
		output += "[tail]";
		
		return output;
	}
	
	// Method that imply the Iterable interface
		public Iterator<E> iterator() {
			return new ListIterator<E>();
		}
		
		private class ListIterator<T> implements Iterator<T> {
			
			@SuppressWarnings("unchecked")
			Node<T> curr = (Node<T>) tail.getNext(); // reference starts from head
			int index = 0;
			
			@Override
			public boolean hasNext() { return (index != size) ;}
			
			@Override
			public T next() {
				
				T value = curr.getData();
				curr = curr.getNext();
				index++;
				return value;
			}
		}
	
	/** The test case of the CircularlyLinkedList */
	public static void testList() {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<Integer>();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		ll.addLast(4);
		System.out.println(ll); // should be [1, 2, 3, 4]

		ll.addFirst(1);
		ll.addFirst(2);
		ll.addFirst(3);
		ll.addFirst(4);
		System.out.println(ll); // should be [4, 3, 2, 1, 1, 2, 3, 4]
			
		ll.rotate();
		System.out.println(ll); // should be [3, 2, 1, 1, 2, 3, 4]
		
		// ll.reverse();
		// System.out.println(ll); // should be [4 ,3 ,2 ,1 ,1 ,2 , 3]
	}

	public static void main(String[] args) {
		testList();
	}	
}