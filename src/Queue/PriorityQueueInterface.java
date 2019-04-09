package Queue;
/**
 * Interface of Priority Queue, ADT
 * @author Ee En Goh 
 * @param <E> Generic Form of Queue Interface
 */
public interface PriorityQueueInterface<E>{
	
	/**
	 * Returns the number of items in the priority queue
	 * @return The number of items
	 */
	int size();
	
	/**
	 * Tests whether the priority queue is empty
	 * @return True if the priority queue is empty, false otherwise
	 */
	boolean isEmpty();
	
	/**
	 * Inserts a new value that will be stored in the entry
	 * @param e The associated value of the new entry
	 * @return The new value
	 * @throws IllegalArgumentException If the key is unacceptable for this queue
	 */
	E insert(E e) throws IllegalArgumentException;
	
	/**
	 * Removes and returns the value of entry which has the lowest value
	 * @return	The lowest value in the queue
	 */
	E min();
	
	/**
	 * Removes and returns an entry with minimal key
	 * @return	The removed entry ( or null if empty )
	 */
	E removeMin();
}