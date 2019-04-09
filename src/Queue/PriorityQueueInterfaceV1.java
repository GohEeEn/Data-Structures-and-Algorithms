package Queue;
/**
 * A priority queue stores a collection of entries
 * Each entry is a key-value pair < Key k , Value v >
 * @author Ee En Goh
 *
 */
public interface PriorityQueueInterfaceV1<K,V>{
	
	/**
	 * Definition of an Entry in the Priority Queue 
	 * @param <K> The Object class of Entry Key
	 * @param <V> The Object class of Entry Value
	 */
	public class Entry<K,V>{
		
		/** Key : It can be arbitrary objects that enable us to define the order of entries in the queue */
		private K key;
		
		/** The associative value of the entry */
		private V value;
		
		/**
		 * Method that allows us to access the entry key value
		 * @return The entry key value
		 */
		K getKey() { return this.key; };
		
		/**
		 * Method that allows us to access the entry associative value
		 * @return The entry value
		 */
		V getValue() { return this.value; };
	}
	
	/**
	 * Returns the number of items in the priority queue
	 * @return The number of items
	 */
	public int size();
	
	/**
	 * Tests whether the priority queue is empty
	 * @return True if the priority queue is empty, false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * Inserts a new value that will be stored in the entry
	 * @param key The key of the new entry
	 * @param value The value of the new entry 
	 * @return The new entry created
	 * @throws IllegalArgumentException If the key is unacceptable for this queue
	 */
	public Entry<K,V> insert(K key , V value) throws IllegalArgumentException;
	
	/**
	 * Removes and returns the entry which has the lowest value
	 * @return	The entry with lowest value in the queue
	 */
	public Entry<K,V> min();
	
	/**
	 * Removes and returns an entry with minimal key
	 * @return	The removed entry ( or null if empty )
	 */
	public Entry<K,V> removeMin();
}