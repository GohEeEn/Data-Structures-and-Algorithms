package Map;

public class MapEntry<K,V> implements Comparable<Object>{
	
	private K key ; 
	private V value ;
	
	// ------------ Constructor -----------------------
	/**
	 * General Constructor
	 */
	public MapEntry() {
		this.key = null;
		this.value = null;
	}
	
	/**
	 * Overloaded Constructor of map entry
	 * @param k	The initialized value of entry key 
	 * @param v The initialized value of entry value
	 */
	public MapEntry(K k, V v) {
		this.key = k;
		this.value = v;
	}
	
	// ------------ Getter Methods --------------------
	/**
	 * @return the entry key
	 */
	public Object getKey() {
		return key;
	}
	
	/**
	 * @return the associated value of the entry
	 */
	public Object getValue() {
		return value;
	}
	
	// ------------ Setter Methods --------------------
	/**
	 * @param Assign new entry key to a specific entry
	 */
	public void setKey(K k) {
		this.key = k;
	}
	
	/**
	 * @param Assign new entry associated value to a specific entry
	 */
	public void setValue(V v) {
		this.value = v;
	}
	
	public String toString() {
		return ("[Key : " + getKey() + " ; Value : " + getValue() + "]");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int compareTo(Object o) {
		if(!(o instanceof MapEntry))
			throw new IllegalArgumentException("Different  Class Format");
		
		Object otherKey = ((MapEntry)o).getKey();
		return ((Comparable)key).compareTo((Comparable)otherKey);
	}
}