package Map;

import java.util.Set;

public interface Map<K,V>{
		
	// ----- Accessor Method -----
	/**
	 * The number of elements in the map
	 * @return Number of entries in the map
	 */
	int size();
	
	/**
	 * Return the boolean value if the map is empty
	 * @return True if the map us empty, false otherwise
	 */
	boolean isEmpty();
	
	/**
	 * Accessor method to return the associative value in the entry with key k
	 * @param key	The key of the entry
	 * @return	The associative value of the entry 
	 */
	V get(K key);
	
	// ----- Operation Method ------
	/**
	 * Insert entry(k,v) into the map M
	 * @param key	The entry key
	 * @param value	The associative value in the entry
	 * @return	null if the key k is not already in M<br/>return old value associated with key k 
	 */
	V put(K key, V value);
	
	/**
	 * Remove the entry with key k from the map M
	 * @param key The entry key
	 * @return The associative value of the entry with key k<br/>null if there is no entry with key k
	 */
	V remove(K key);
	
	// ----- Display Set Method -----
	/**
	 * @return An iterable collection of entries in map M
	 */
	Set<MapEntry<K,V>> entrySet(); 
	
	/**
	 * @return An iterable collection of the keys in map M
	 */
	Set<K> keySet();
	
	/**
	 * @return An iterable collection of the keys in map M
	 */
	Set<V> valueSet();
}