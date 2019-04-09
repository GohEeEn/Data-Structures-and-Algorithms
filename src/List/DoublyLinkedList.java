package List;
import java.util.Iterator;

// import comp20010_practical2.SinglyLinkedList.Node;

public class DoublyLinkedList<E> implements Iterable<E> {

	private static class Node<T> {
		// TODO
		
		/** The element stored at this node */
		private T element;	// reference to the element stored at this node
		
		/** A reference to the preceding node in the list */
		private Node<T> prev; // reference to the previous node in the list
		
		/**  A reference to the subsequent node in the list */
		private Node<T> next; // reference to the subsequent node in the list
		
		// Constructor of class Node
		/**
		 *  Overloaded constructor
		 * @param e
		 * 			Data stored in the generic type
		 * @param p
		 * 			The reference points to the previous node
		 * @param n
		 * 			The reference points to the next node
		 */
		public Node(T e, Node<T> p, Node<T> n) {
			
			element = e;
			prev = p;
			next = n;
		}
		
		// Public accessor / getter Method
		/**
		 * Returns the element stored at the node.
		 * 
		 * @return the element stored at the node
		 */
		public T getElement() throws IllegalStateException{ return this.element; }
		
		/**
		 * Returns the node that follows this one (or null if no such node).
		 * @return the following node
		 */
		public Node<T> getNext() { return this.next; }

		/**
		 * Returns the previous node of this one (or null if no such node).
		 * @return the previous node
		 */
		public Node<T> getPrev(){ return this.prev; }
		
		// Public mutator / setter method
		
		public void setElement(T e) { this.element = e; }
		
		/**
		 * Sets the node's next reference to point to Node n.
		 * @param n
		 *            the node that should follow this one
		 */
		public void setNext(Node<T> n) { next = n; }
		
		/**
		 * Sets the node's previous reference to point to Node n
		 * @param n
		 * 			the node that should be the previous of this one
		 */
		public void setPrev(Node<T> n) { prev = n; }
		
	} // --------------- end of nested Node class -------------------
		
	/** Sentinel node at the beginning of the list */
	private Node<E> header; // header sentinel
		
	/** Sentinel node at the end of the list */
	private Node<E> trailer; // trailer sentinel
		
	/** Number of elements in the list (not including sentinels) */
	private int size = 0; // number of elements in the list
		
	/** Constructs a new empty list */
	public DoublyLinkedList() {
		header = new Node<E>(null, null, null); 	// create header
		trailer = new Node<E>(null, header, null); 	// trailer is preceded by header
		header.setNext(trailer);					// header is followed by trailer
	}
	
	// Public Accessor methods
	
	/**
	 * Search for a specific node by given index (node index)
	 * @param index
	 * 			Integer , the given index of linked list
	 * @return
	 * 			The node value at the given index
	 */
	private Node<E> getNode(int index){
		//TODO
		Node<E> current = header; // Start the reading of nodes from the head node
		
		// Search for the index, for more specific is to search for the index-th of node
		// Case while the specific node hasn't reach
		for(int i = 0 ; i < index ; ++i) {
			current = current.next;
		}
		
		return current; 
	}
	
	/**
	 * Returns the number of elements in the linked list
	 * @return
	 * 		The size of linked list
	 */
	public int size() { return this.size; }
	
	/**
	 * Tests whether the linked list is empty
	 * @return true if the linked list is empty, false otherwise
	 */
	public boolean isEmpty() { return size == 0; }
	
	/** 
	 * Returns (without removing) the first element of the list
	 * @return element at the front of the list (or null if empty)
	 */
	public E first() {
		
		if(isEmpty())
			return null;
		
		return header.getNext().getElement();
	}
	
	/**
	 * Returns (but does not remove) the last element of the list
	 * @return element at the end of the list (null if the list is empty)
	 */
	public E last() {
		
		if(isEmpty())
			return null;
		return trailer.getPrev().getElement();
	}
	
	/**
	 * Method that used to find the middle node of the linked list 
	 * @return
	 * 		The middle node linked list
	 */
	public E middleNode() {
		
		if(isEmpty())
			System.out.println("The linked list is empty");
		else if(size % 2 == 0)
			System.out.println("As the list has an even size, thus NO middle node");
		
		// else case : an ODD size of list length
		
		Node<E> fromStart = this.header;
		Node<E> fromEnd = this.trailer;
		
		// Traverse through the list
		while( fromStart != fromEnd ) {
			
			fromStart = fromStart.getNext();
			fromEnd = fromEnd.getPrev();
		}
	
		return fromEnd.getElement(); // Length of list is ODD, if fromStart == fromEnd
	}
	
	/**
	 * The method that add the value between the node predecessor and successor
	 * @param e
	 * 			The value inserted
	 * @param predecessor
	 * 			The previous node of the inserting node
	 * @param successor
	 * 			The next node of the inserting node
	 */
	public void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		
		// create and link a new node
		Node<E> newest = new Node<E>(e, predecessor, successor);	// Declare a new Node with value e that inserted between the predecessor and successor nodes
		predecessor.setNext(newest);								
		successor.setPrev(newest);
		size++;
	}
	
	// update methods
	/**
	 * Adds an element to the front of the list.
	 * 
	 * @param e
	 *            the new element to add
	 */
	public void addFirst(E e) { // adds element e to the front of the list
		addBetween(e , header , header.getNext());
	}


	/**
	 * Adds an element to the end of the list.
	 * 
	 * @param e
	 *            the new element to add
	 */
	public void addLast(E e) { // adds element e to the end of the list
		// TODO
		if(size == 0)
			addBetween(e , header , header.getNext());
		else
			addBetween(e, trailer.getPrev() , trailer);
	}	
	
	/**
	 * Method to insert a new element before the node with value key
	 * @param key	
	 * 			The node we are looking for 
	 * @param s		
	 * 			The String object that are inserted after the node 'key'
	 */
	public void insertBefore(E key, E s) {
		
		// Case 1 : If it is an empty list, then return nothing as there is no key found
		if(first() == null) { 
			return;
		}
		// Case 2 : If the key located in Node head, then insert the String s in head 
		if(first().equals(key)) {
			addFirst(s);	// Replace value key in Node head with String s	
			return;
		}
		
		Node<E> curr = header.getNext(); 	// Declare a temporary Node to save the current Node address
		
		// Case 3 : If the key located within the LinkedList, then find it out 
		// Traverse through the list
		while(curr != null && !curr.getElement().equals(key)){ curr = curr.getNext(); }
		
		// Key found , then insert the String object s between curr and prev
		if(curr != null) {
			addBetween(s,curr.getPrev(),curr);
			// System.out.println("After this operation[insertBefore], size : " + size()); DEBUG	
		} 
		else 
			System.out.println("The given key NOT FOUND in list");
			
	}
	
	/**
	 * The method that remove the value between the node predecessor and successor
	 * @param node
	 * 			The node reference to the removed node
	 * @return
	 * 			The node value that has been removed
	 */
	public E remove(Node<E> node) {
		
		// Declare nodes that get the previous and the next node of this node
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		
		// Assume this element has been removed, then the next and previous of node will be they each other
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		
		size--;	// decrease in size
		
		return node.getElement();
	}
	
	/**
	 * Removes and returns the first element of the list.
	 * 
	 * @return 
	 * 			The node value that has been removed (or null if empty)
	 */
	public E removeFirst() { // removes and returns the first element
		// TODO
		
		if(header == null) 					// Case if it is an empty list
			return null;
		
		return remove(header.getNext()); 	// First element is beyond header
	}
	
	
	public E removeLast() {
		
		if(header == null)					// Case if the list is empty list
			return null;
		
		return remove(trailer.getPrev());	// Last element is before trailer
	}
	
	/**
	 * Remove the node by specify the node value (object , eg. String)
	 * Overloaded Method 
	 * @param key
	 * 			The node value of the target removed node
	 */
	public E remove(E key) {
	
		// Case 1 : Empty list , nothing to delete
		if(first() == null) {
			// throw new RuntimeException("Empty list, nothing to delete"); 
			return null;
		}
		
		// Case 2 :Key node found at the first node (first())
		if(first().equals(key)) {return removeFirst();}
		
		Node<E> curr = header.getNext(); // Declare a new node for saving the node current
		Node<E> prev = null; // Declare a new node for saving the previous node
		
		// traverse to find the key through the linked list
		while(curr != trailer && !curr.getElement().equals(key)) {
			prev = curr;
			curr = curr.getNext();
		}
		
		// Case 3 : Key node NOT FOUND when the whole list has been searched through
		if (curr == trailer) {
			// System.out.println("Key NOT FOUND"); DEBUG 
			return null;
		} 
		
		// Case 4 : Key found in the list which neither head nor tail node, then delete current node by replacing the previous node next node with itself
		E removed = curr.getElement();	// Save the removed node value for returning value 
		prev.setNext(curr.getNext());	// Replace the next node reference of key node to the next node of original current node
		size--;							// Decrease the size of the linked list
		// System.out.println("After this operation[remove1], size : " + size()); 
		
		return removed;
	}
	
	// Override Methods
	public E get(int pos) {
		return getNode(pos).getElement();
	}
	
	public void add(int i, E e) {
		Node<E> n = getNode(i);
		addBetween(e, n.getPrev(), n);
	}
	
	public E remove(int i) {
		Node<E> n = getNode(i);
		E res = n.getElement();
		remove(n);
		return res;
	}
	
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<E> {
		// TODO
		Node<E> curr ;
		
		public ListIterator() {
			curr = header;
		}
		
		public boolean hasNext() {
			return curr != null;
		}
		
		@Override
		public E next() {
			
			E res = (E)curr.getElement();
			curr = curr.getNext();
			return res;
		}
	}

	/**
	 * Produces a string representation of the contents of the list. This exists for
	 * debugging purposes only.
	 */
	public String toString() {
		// TODO
		String output = new String();
		output += "@size : " + size() + "\n";
		
		for(E tmp : this) {
			output += "> " + tmp + " ";
		}
		output += "\n";
		
		return output;
	}
	
	public static void main(String[] args) {
		DoublyLinkedList<String> dl = new DoublyLinkedList<String>();
		
		dl.addLast("Java");
		dl.addLast("C++");
		dl.addBetween("Python", dl.header, dl.header.getNext()); // In another word => addFirst()
		dl.addLast("Lisp");
		
		System.out.println(dl);	// toString() method 
		
		dl.addLast("Scala");
		
		System.out.println("@new size \t: " + dl.size());
		
		System.out.println("@middle node \t: " + dl.middleNode() + "\n");
	/*	
		for (String s: dl) {
			System.out.println("String: " + s);
		} */
		System.out.println(dl);
	}
}
