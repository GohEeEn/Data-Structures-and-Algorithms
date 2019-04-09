package List;

import java.util.Iterator;

/**
 * Generic version of the SinglyLinkedList with implementation of ADT
 * @author Ee En Goh
 * @param <E> Generic version , enable us to use this data structure with any Object / Class
 */
public class SinglyLinkedList<E> implements Iterable<E>{
	
	/** First node in the list */
    private Node<E> head = null;
    
    /** Last node in the list */
    private Node<E> tail = null;
    
    /** Size of the list : the number of nodes in the list */
    private int size = 0;			
    
    /** Default constructor */
    public SinglyLinkedList() {}
    
    /**
     * Return the specific node by given node index (like array index but on list) 
     * @param index
     * 		int, the node index of the list
     * @return
     * 		The node found
     */
    public Node<E> getNode(int index){
    	
    	Node<E> current = this.head;
    	
    	for(int i = 0 ; i < index ; ++i) {
    		current = current.getNext();
    	}
    	
    	return current; 
    }
    
    /**
     * Add a new node after the key node
     * @param key
     * 		The reference to the key node
     * @param data
     * 		The object value that has to store in the new node
     */
    public void addAfter(Node<E> key, E data) {
    	Node<E> newNode = new Node<E>(data,key.getNext());
    	key.setNext(newNode);
    	++size;	// new node, increase the size of the linkedlist
    }
    
    /**
     * Get the size of current list
     * @return
     * 		int , the size of current list
     */
    public int size() { return this.size; }
     
    /**
     * Boolean method that check if the current list is empty
     * @return
     * 		True if the list is empty , else false
     */
    public boolean isEmpty() { return this.size() == 0; }
    
    /**
     * Get the first node in the list
     * @return
     * 		First node in the list 
     */
    public Node<E> first() {
        
    	// TODO
    	if(isEmpty()) {
    		return null;
    	}
    	else 
    		return this.head;
    }
    
    /**
     * Get the last node in the list
     * @return
     * 		Last node in the list 
     */
    public Node<E> last() {
        
    	// TODO
    	if(this.size == 0) {
    		return null;
    	}
    	else 
    		return this.tail;
    }
    
    
    public void addFirst(E data) {
        // TODO
    	head = new Node<E>( data , this.head );
		
		if(isEmpty())
			tail = head;
    	++size;
    }

    public void addLast(E data) {
        // TODO
    	if(isEmpty())
    		addFirst(data);
    	else {
    		Node<E> newLast = new Node<E>(data, null); // DEBUG
    		tail.setNext(newLast);
			tail = newLast;
			++size;
    	}
    }
    
    /**
     * Insert the given value after the node which has the value key 
     * @param key
     * 		The value of target node
     * @param value
     * 		The new node value that inserted after the key node
     */
    public void insertAfter(E key, E value) {
    	
    	Node<E> tmp = head;
    	
    	// traverse through the list when the key hasn't been found
    	while(tmp != null && !tmp.getData().equals(key)) {
    		tmp = tmp.getNext();
    	}
    	
    	if(tmp != null){
    		tmp.setNext(new Node<E>(value, tmp.getNext()));
			++size;
		}
    }
    
    /**
     * Insert the value before the key node
     * @param key
     * 		The value that the key node has store
     * @param value
     * 		The value that has to assign to the new node
     */
    public void insertBefore(E key, E value) {
    	
    	// Case if it is an empty list
    	if(head == null) {
    		return;
    	}
    	
    	// Case if the key node is the head node
    	if(head.getData().equals(key))
    	{
    		addFirst(value);
    		return;
    	}
    		
    	Node<E> previous = null ;
    	Node<E> current = head; 
    	
    	// Traverse in the list to find the key node 
    	while(current != null && !current.getData().equals(key)) {
    		
    		previous = current;
    		current = current.getNext();
    	}
    	
    	// Case when the key node found
    	if(current != null) {
    		previous.setNext(new Node<E>(value,current));
			size++;
    	}
    	else 
			System.out.println("The given key NOT FOUND in list");
    }
    
    /**
     * Remove the node with given key ( Key node )
     * @param key
     * 		The value of the key node 
     */
    public void remove(Node<E> key) {
    	
    	// Empty list
    	if(head == null) {
    		throw new RuntimeException("Nothing to delete");
    	}
    	
    	// Key node is head node
    	if(head.getData().equals(key)){ removeFirst(); }
    	
    	Node<E> curr = head;
    	Node<E> prev = null;
    	
    	// traverse through the list to search for the key node
    	while( curr != null && !curr.getData().equals(key) ) {
    		prev = curr;
    		curr = curr.getNext();
    	}
    	
    	if( curr == tail) {
    		throw new RuntimeException("Key not found");
    	}
    	
    	// record the key node and remove it
    	prev.setNext(curr.getNext());
    	size--;
    }
    
    public E removeFirst() {
        // TODO
    	if(size == 0) {
    		return null;
    	} // empty list case
    	
    	E removed = head.getData();
    	head = head.getNext();
    	size--;
    	
    	return removed;
    }

    public E removeLast() {
        // TODO
    	E removed = null;
		
		if(isEmpty()) { return null; }
		else if(head == tail){
			removed = head.getData();
			removeFirst();
		}
    	else{
			removed = tail.getData();
			tail = getNode(size - 2);
			tail.setNext(null);
			--size;
    	}
    	return removed;
    }
    
    /**
     *  Method to generate and return the list node in String form
     *  @return
     *  	String form of list value 
     */
    public String toString() {
    	
    	String output = "";
    	output += "Size : " + size() + "\n";
    	
    	Node<E> current = this.head;
    	output += current.getData();
    	
    	while(current.getNext() != null) {
    		current = current.getNext();
    		output += " > " + current.getData();
    	}
    	System.out.println("");
    	
    	return output;
    }
    
    public void add(int index, E data) {
    	if(index == size)
    		addLast(data);
    	else if(index == 0)
    		addFirst(data);
    	else
    		addAfter(getNode(index - 1),data);
    }
    
    /**
     * Access the list node by using the node index
     * @param index The accessing node index
     * @return The associative data stored in the node
     */
    public E get(int index) { return getNode(index).getData(); }
    
    /**
     * Set the value of data in the given node
     * @param index The node index of the given node
     * @param data	The stored data to the node
     * @return The original data in the given node, else return null
     */
    public E set(int index, E data) {
    	
    	Node<E> n = getNode(index);
    	E original = n.getData();
    	n.setData(data);
   
    	return original;
    }
    
    /**
     * Remove the node in given node index
     * @param i	Node index
     * @return The associative value in the removed node
     */
    public E remove(int i) {
    	
    	if(isEmpty()) return null;	// Case if the list is empty
    	
    	if(i == 0) { removeFirst(); } // Case if the first node is removed
    	
    	// Else case
    	Node<E> prev = getNode(i - 1);
    	Node<E> curr = prev.getNext(); // Node at index i
    	
    	E removed = null; // used to store the target node value
    	
    	// In case if the required node data not found
    	try {	 
    		removed = curr.getData();
    		if(curr == tail)
    			removeLast();
    		else {
    			prev.setNext(curr.getNext()); // Reset a new next node to the next node of the removed node
    			--size;
    		}
    	}catch(NullPointerException e) {
    		System.out.println("SIGNAL : Required Key Not Found");
    	}
    	
    	return removed;
    }
    
    /**
     * LinkedList cloning method
     * @return	The clone of current linked list
     */
    public SinglyLinkedList<E> copy() {
    	
    	SinglyLinkedList<E> twin = new SinglyLinkedList<E>();
    	
    	Node<E> tmp = this.head;
    	
    	// Cloning the SinglyLinkedList by traverse through the whole linked list
    	while(tmp!=null) {
    		
    		twin.addLast(tmp.getData());
    		tmp = tmp.getNext();
    	}
    	
    	return twin;
    }
	
    /**
     * Method to reverse the position of nodes in the linked list
     */
    public void reverse() {
		
		Node<E> prev = null;
		Node<E> curr = head; 
		Node<E> next;
		
		while(curr != null){
			next = curr.getNext();	// Node next : move to the next node 
			curr.setNext(prev);		// Reverse reference ;
			prev = curr;
			curr = next;
		}
		 
		head = prev;
	}
    
    @Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<E> {
		// TODO
		Node<E> curr ;
		
		public ListIterator() {
			curr = head;
		}
		
		public boolean hasNext() {
			return curr != null;
		}
		
		@Override
		public E next() {
			
			E res = (E)curr.getData();
			curr = curr.getNext();
			return res;
		}
	}
    
    public static void main(String [] args) {
        SinglyLinkedList<String> ll = new SinglyLinkedList<String>();
        
        // Testing addLast method
        ll.addLast("Java");
        ll.addLast("C++");
        ll.addLast("Python");
        ll.addLast("Scala");
        System.out.println(ll);
        
        // Testing addFirst method
        ll.addFirst("C#");
        System.out.println(ll);
        
        // Testing removeFIrst method
        ll.removeFirst();
        System.out.println(ll);
        
        // Testing removeLast method
        ll.removeLast();
        System.out.println(ll);
        
        // Testing addAfter method
        ll.addAfter(ll.getNode(1), "PHP");
        System.out.println(ll);
        
        System.out.println("Copied : \n" + ll.copy());
        
        ll.reverse();
        System.out.println("Reversed : \n" + ll);
    }
}