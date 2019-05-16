package Queue;
public interface PriorityQueueV1<K,V>{
	
	/**
	 * The definition of an entry in the queue
	 * @param <K>	Key value that stored in this entry
	 * @param <V>	The entry value 
	 */
	public interface Entry<K,V>{
		
		/**
		 * Returns the key stored in this entry
		 * @return The entry's key
		 */
		K getKey();
		
		/**
		 * Returns the value stored in this entry
		 * @return The entry's value
		 */
		V getValue();
	}
	
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
	 * Inserts a key-value pair and returns the entry created
	 * @param key	The key of the new entry
	 * @param value	The associated value of the new entry
	 * @return	The entry that stores the new key-value pair
	 * @throws IllegalArgumentException	If the key is unacceptable for this queue
	 */
	Entry<K,V> insert(K key , V value) throws IllegalArgumentException;
	
	/**
	 * Removes and returns an entry with minimal key
	 * @return	Entry that have a minimal key for null if empty
	 */
	Entry<K,V> min();
	
	/**
	 * Removes and returns an entry with minimal key
	 * @return	The removed entry ( or null if empty )
	 */
	Entry<K,V> removeMin();
}