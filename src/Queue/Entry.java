package Queue;

/**
 * @author Ee En Goh
 */
public class Entry<K, V extends Comparable<V>> implements Comparable<Entry<K, V>> {
	
	// Private Variables
	
	/** The Entry Key */
	private K key;
	
	/** The associative entry value */
	private V value;

	/**
	 * Default constructor of an entry
	 * @param newKey	The value of a new Key
	 * @param newValue	The associative value
	 */
	public Entry(K newKey, V newValue) {
		this.key = newKey;
		this.value = newValue;
	}

	/**
	 * @return Entry key
	 */
	public K getKey() { return this.key; }

	/**
	 * @return Entry value
	 */
	public V getValue() { return this.value; }

	/**
	 * @param Compare the entry value between this entry and another given entry
	 */
	@Override
	public int compareTo(Entry<K, V> entry2) { return this.getValue().compareTo(entry2.getValue()); }

	/**
	 * @return String representation of key & value
	 */
	@Override
	public String toString() {
		return "[" + key + ", " + value + "]";
	}
}