package Vector;

import java.util.Iterator;

/**
 * Linked-implementation of data structure vector
 * - Objects stored in special nodes
 * - Nodes maintain the ordering information
 * 		Link to the next and previous objects in the Vector (Doubly Linked Node)
 * 		Need auxiliary references for 'front' and 'rear' nodes
 * - Runtime Performance :
 * 		size()				O(1)	
 * 		isEmpty()			O(1)
 * 		elemAtRank(r)		O(n)	Traversal operation required
 * 		replaceAtRank(r,e)	O(n)	Traversal operation required
 * 		insertAtRank(r,e)	O(n)	Traversal operation required
 * 		removeAtRank(r)		O(n)	Traversal operation required
 * - Insertion on an existing node makes the original rank element moves to the next rank
 * @author Ee En Goh
 * @param <T>	Any object class that determines the stored value
 */
public class LinkedVector<T> implements Vector<T>{
	
	/** Reference to the first node */
	private Node<T> front;
	
	/** Reference to the last node */
	private Node<T> rear;
	
	/** The size of the vector */
	private int size;
	
	LinkedVector(){
		this.front = null;
		this.rear = null;
		this.size = 0;
	}
	
	public T getFront() {
		return this.front.getData();
	}
	
	public T getRear() {
		return this.rear.getData();
	}
	
	@Override
	public String toString() {
		
		Node<T> temp = this.front;
		// Node<T> temp = this.rear;
		String output = (String) temp.getData();
		
	/* 
	 	Output method for debugging, to prevent reference set-up error
	 
		for(int i = 1 ; i < size(); i++) {
			temp = temp.getNext();
			output += " " + temp.getData();
		}
		
	*/
		
		while(temp.getNext() != null) {
			temp = temp.getNext();
			output += " " + temp.getData();
		} 
		
	/*	
		Output method to ensure the Node class reference to previous Node is correct
		while(temp.getPrev() != null) {
			temp = temp.getPrev();
			output += " " + temp.getData();
		}
	*/
		return output;
	}

	// ----- Support Operations -----
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}
	
	/**
	 * Traverse through the linked node with the given rank
	 * @param rank	The given rank
	 * @return	The reference to the element at the given rank  
	 */
	private Node<T> atRank(int rank){
		
		Node<T> temp;
		
		// To reach the rank more efficiently
		if(rank <= size()/2) {
			temp = this.front;
			for(int i = 0 ; i < rank ; i++) 
				temp = temp.getNext();
		}else{
			temp = this.rear;
			for(int i = 0 ; i < size() - rank - 1 ; i++) 
				temp = temp.getPrev();
		}
		
		return temp;
	}
	
	// ----- Core Operations -----
	
	@Override
	public T elemAtRank(int rank) {

		if(isEmpty()) {
			System.out.println("Message : This vector is empty");
			return null;
		}
		// -1 needed? 
		if(rank < 0 || rank > size()-1 ) throw new RankOutOfBoundsException();
	
		return atRank(rank).getData();
	}

	@Override
	public T replaceAtRank(int rank, T element) {
		
		if(isEmpty()) {
			System.out.println("Message : This vector is empty");
			return null;
		}
		// -1 needed? 
		if(rank < 0 || rank > size()-1) throw new RankOutOfBoundsException();
		
		Node<T> removed = atRank(rank); 	// get the reference of the target node with given rank
		T rm = removed.getData();		  	// get the original value stored in the target node
		removed.setData(element);			// replace it with new assigned value 
		
		return rm;
	}

	@Override
	public void insertAtRank(int rank, T element) {
		
		if(rank < 0 || rank > size()) throw new RankOutOfBoundsException();
		
		Node<T> newNode = new Node<T>(element,null,null);
		
		if(isEmpty()) {								// Insert at the front of vector
			
			this.front = newNode;
			this.rear = this.front;
			
		}else {
			
			Node<T> temp = atRank(rank - 1);
			newNode.setPrev(temp);
						
			if(rank == size()) {					// Case if the new node is inserted at the rear of vector
				
				temp.setNext(newNode);
				this.rear = newNode;
				
			} else if(rank == 0) {					// Case to insert the new node at the front of vector
				
				front.setPrev(newNode);
				newNode.setNext(front);
				front = newNode;
				
			} else {
			//	Debug : order of Node reference was wrong
				temp = temp.getNext();				// move to the original next node
				temp.getPrev().setNext(newNode);
				temp.setPrev(newNode);
				newNode.setNext(temp);
			}
		}
		this.size++;
	}	

	@Override
	public T removeAtRank(int rank) { // Disconnect any reference to the target node
		
		if(rank < 0 || rank > size()) throw new RankOutOfBoundsException();
		
		if(isEmpty()) { // Case if the vector is empty
			System.out.println("Message : This vector is empty");
			return null;
		}
		
		T removed;
		
		if(rank == 0) { // Case to remove the front element
			
			removed = front.getData();
			
			if(size() == 1)
				front = null;
			else {
				front = front.getNext();
				front.setPrev(null);
			}
		}
		else {
			// System.out.println("WTF");
			Node<T> temp = atRank(rank - 1);
			removed = temp.getNext().getData();
		
			// Case to remove the rear element 
			if(rank == size() - 1) { // Debug : rank starts from 0, while size() starts from 1
				this.rear = temp;
				temp.setNext(null);
			}
			else { // Case to remove element in the middle
				temp.setNext(temp.getNext().getNext()); 
				temp.getNext().setPrev(temp);			
			}
		}
		this.size--;
		
		return removed;
	}

	 @Override
	    public Iterator<T> iterator() {
	        return new Iterator<T>() {
	            private Node<T> current;

	            @Override
	            public boolean hasNext() {
	                if (isEmpty()) return false;
	                if (current == null) return true;
	                return !current.equals(rear);
	            }

	            @Override
	            public T next() {
	                if (current == null) {
	                    current = front;
	                } else {
	                    current = current.getNext();
	                }
	                return current.getData();

	            }
	        };
	    }
}
