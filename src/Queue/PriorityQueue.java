package Queue;

import java.util.Comparator;

import List.Node;
import List.SinglyLinkedList;

public class PriorityQueue<E extends Comparable<E>> implements PriorityQueueInterface<E>, Comparator<E>{
	
	private SinglyLinkedList<E> queue = new SinglyLinkedList<>() ;

	@Override
	public int size() { return queue.size(); }

	@Override
	public boolean isEmpty() { return ( queue.size() == 0 ); }

	/**
	 * Compare the entry value of 2 different entries , then return an integer value to determine the comparing result
	 * @param entry1 The first entry
	 * @param entry2 The second entry
	 * @return
	 * 		1 , If the associative value of entry1 is bigger than entry2 <br/>
	 * 	   -1 , If the associative value of entry1 is lower than entry2<br/>
	 * 		0 , If the associative value of both entries are equal
	 */
	@Override
	public int compare(E entry1, E entry2) { return entry1.compareTo(entry2); }
	
	/**
	 * Inserts a new value that will be stored in the entry
	 * @param e The associated value of the new entry
	 * @return The new value
	 * @throws IllegalArgumentException If the key is unacceptable for this queue
	 */
	public E insert(E e) throws IllegalArgumentException {
		
		if(isEmpty())			// If the queue is empty
			queue.addFirst(e); 
		else {
			
			// Traverse through the queue
			Node<E> prev = null;
			Node<E> curr = queue.first();
			
			// Finding the right position to insert the node to make the entry in order
			while( compare(e , curr.getData()) > 0 && curr.getNext() != null) {
				prev = curr;
				curr = curr.getNext();
			}
			
			if(curr == queue.first()) 		// if the entry value of this entry is the lowest, insert the new node at the front of queue
				queue.addFirst(e);
			else if(curr == queue.last()) 	// if the entry value of this entry is the highest, insert the new node at the rear of queue
				queue.addLast(e); 
			else 							// if the entry value is none of the case above, insert the new node after the last node that has the relatively lower gpa 
				queue.addAfter(prev, e);
			
			// System.out.println("\nCurrent Queue : " + queue +  "\n"); DEBUG
		}
		return e;
	}
	
	/**
	 * Return the first element in the queue
	 */
	public E min() { return queue.first().getData(); }

	/**
	 * Return and remove the first entry in the queue
	 */
	public E removeMin() { return queue.removeFirst(); }
	
	public String toString() { return queue.toString(); }
	
	/**
	 * Test case
	 */
	public static void test() {
		
		// create a priority queue.
		PriorityQueue<Entry<Integer, String>> pq = new PriorityQueue<Entry<Integer,String>>();
		
		// Insert entries with value to the queue
		pq.insert(new Entry<Integer, String>(23,"Michael Jordan"));
		pq.insert(new Entry<Integer, String>(24,"Kobe Bryant"));
		pq.insert(new Entry<Integer, String>(23,"LeBron James"));
		pq.insert(new Entry<Integer, String>(3,"Dwyane Wade"));
		pq.insert(new Entry<Integer, String>(77,"Luka Doncic"));
		pq.insert(new Entry<Integer, String>(1,"Derrick Rose"));
		pq.insert(new Entry<Integer, String>(34,"Shaq"));
		
		// Output 
		System.out.println("Before removal : \n" + pq);						// Before remove
		System.out.println("\nMinimum in comparing of String : "+ pq.min());	// Access to the minimum entry
		pq.removeMin();														// Remove the minimum entry
		System.out.println("After removal : \n" + pq);						// After remove
	}
	
	public static void main(String[] args) {
		test();
	}
}