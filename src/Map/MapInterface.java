package Map;

import java.util.Collection;
import java.util.Set;

/**
 * @author Ee En Goh
 * Data Structure : Map
 * 		The data structure that maps unique keys to values
 * 		A key is an object that you use to retrieve a value at a later date
 * @param <E>
 */
@SuppressWarnings("hiding")
public interface MapInterface{
	
	/**
	 * The public method that removes all key / value pairs from the invoking map
	 */
	public void clear();
	
	/**
	 * Returns true if the invoking map contains k as a key, otherwise return false
	 * @param k	The given key value (Unsure the object type of key, thus use general Object class)
	 * @return	True if the given key is found in the Map
	 */
	public boolean containsKey(Object k);
	
	/**
	 * Returns true if the map contains a value v, otherwise returns false
	 * @param v The given value 
	 * @return	True if the entry with this associate value exist
	 */
	public boolean containsValue(Object v);
	
	/**
	 * The public method that provides a set-view of the invoking map
	 * @return a Set that contains the entries in the map
	 */
	public Set<MapEntry> entrySet();
	
	/**
	 * Public method that return boolean value if obj is a map and contains the same entries 
	 * @param obj	The given map with entries
	 * @return	boolean value if this map has the same entries with the given map
	 */
	public boolean equals(Object obj);
	
	/**
	 * Public method to provide the associated value with the key k
	 * @param k	The entry key in this map
	 * @return	The associated value with the key k in that entry
	 */
	public Object get(Object k);
	
	/**
	 * Public method to return the hash code of the invoking map
	 * @return	The hash code for the invoking map
	 */
	public int hashCode();
	
	/**
	 * Public method to return the boolean value if the map is empty
	 * @return	true if the invoking map is empty, else return false
	 */
	public boolean isEmpty();
	
	/**
	 * Public method that provides a set-view of the keys in the invoking map
	 * @return a set that contains the keys in the invoking map
	 */
	public Set keySet();
	
	/**
	 * The public method that puts an entry in the invoking map, overwriting any precious value associated with the key
	 * @param k	The key of the target entry
	 * @param v The new associated value to the target entry (overwrite)
	 * @return null if the key didn't exist, else the previous value linked to the key is returned
	 */
	public Object put(Object k, Object v);
	
	/**
	 * Puts all the entries from m into this map
	 * @param m	The map with entries to insert into this map
	 */
	public void putAll(Map<?, ?> m);
	
	/**
	 * Public method that removes the entry whose key equals k
	 * @param k	The given key k leads us to the target entry
	 * @return	The associated value of the removed entry, return null if there is no entry with key k
	 */
	public Object remove(Object k);
	
	/**
	 * Public method that return the size of the map 
	 * @return	The size of the map in integer
	 */
	public int size();
	
	/**
	 * Public method that provides a collection-view of the values in the map
	 * @return	A collection contains the values in the map
	 */
	public Collection<?> values();
}