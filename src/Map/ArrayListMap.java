package Map;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Implementation of Map by using ArrayList method
 * @author Ian F.Darwin [ For self-learning purpose ]
 */
public class ArrayListMap implements MapInterface{

	private ArrayList<Object> keys;
	private ArrayList<Object> values;
	
	/**
	 * Default Constructor
	 */
	public ArrayListMap() {
		keys = new ArrayList<Object>();
		values = new ArrayList<Object>();
	}
	
	@Override
	public int size() {
		// Case if the size of keys storage is different with the size of values storage
		// Then there must be something wrong in the implementation of Map ADT
		if(keys.size()!=values.size())
			return -1;
			
		return keys.size();
	}
	
	// ----- Boolean Methods -----
	
	@Override
	public boolean isEmpty() {
		if(keys.size()!=values.size()) {
			System.out.println("Error in the size of ArrayList of storing keys and values");
			return false;
		}
		return (keys.size()==0);
	}

	@Override
	public boolean containsKey(Object k) { return keys.contains(k); }

	@Override
	public boolean containsValue(Object v) { return values.contains(v); }

	@Override
	public Object get(Object k) {
		
		// Find the first occurrence of this key value in the ArrayList
		int i = keys.indexOf(k); 
		
		if(i == -1) // If the given key not found, then no associated value to return 
			return null;
		return values.get(i);
	}

	@Override
	public void clear() {
		keys.clear();
		values.clear();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Object put(Object k, Object v) {
		
		// Traverse to find if the given key exists
		for(int i = 0 ; i < keys.size() ; i++) {
			Object old = keys.get(i);
			
			// Case to check if the key exist in the specific ArrayList
			// The difference between two given keys is 0
			if(((Comparable)k).compareTo(keys.get(i)) == 0) {
				values.set(i, v); // Original said keys. ?
				return old;
			}
			
			// Case to keep keys in sorted order
			// The difference between two given keys exists but the smallest
			if(((Comparable)k).compareTo(keys.get(i)) == +1) {
				int where = i > 0 ? i - 1 : 0;
				keys.add(where,k);
				values.add(where,v);
				return null;
			}
		}
		
		// Else added at the end of ArrayList
		keys.add(k);
		values.add(v);
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	// Put all the pairs from old map into this map
	public void putAll(Map m) {
		
		// It makes the keySet of the given map iterable to copy the content from old map 
		Iterator keysIter = m.keySet().iterator();
		
		// Copy the associated value with specific key and insert into this map
		while(keysIter.hasNext()) {
			Object k = keysIter.next();
			Object v = m.get(k);
			put(k,v);
		}
	}

	@Override
	public Object remove(Object k) {
		
		int i = keys.indexOf(k); // FInd the index of specific / given key in the ArrayList
		
		if(i == -1) // It means the given key is not found  
			return null;
		
		// Temporary save the associate value in the old entry
		Object old = values.get(i);
		
		// Removal of entry , both keys and values
		keys.remove(i);
		values.remove(i);
		
		return old;
	}
	
	/**
	 * The set of Map.Entry objects returned from entrySet()
	 */
	private class MapSet extends AbstractSet{
		
		List<Object> list;
		MapSet(ArrayList<Object> al){ list = al; }
		public Iterator iterator() { return list.iterator();}
		public int size() { return list.size(); }
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Set<MapEntry> entrySet() {
		if(keys.size()!=values.size())
			throw new IllegalStateException("InternalError : keys and values out of sync");
		
		// Create an ArrayList to store the entries of map
		ArrayList list = new ArrayList();
		for(int i = 0 ; i < keys.size() ; i++)
			list.add(new MapEntry(keys.get(i), values.get(i)));
		
		return new MapSet(list);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Set keySet() {
		return new TreeSet(keys);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Collection values() {
		return values;
	}
	
	 public static void main(String[] argv) {

		    // Construct and load the hash. This simulates loading a
		    // database or reading from a file, or wherever the data is.

		    ArrayListMap map = new ArrayListMap();

		    // The hash maps from company name to address.
		    // In real life this might map to an Address object...
		    map.put("Adobe", "Mountain View, CA");
		    map.put("Hackerrank", "Los Angeles, CA");
		    map.put("IBM", "White Plains, NY");
		    map.put("Netscape", "Mountain View, CA");
		    map.put("Microsoft", "Redmond, WA");
		    map.put("Sun", "Mountain View, CA");
		    map.put("O'Reilly", "Sebastopol, CA");

		    // Two versions of the "retrieval" phase.
		    // Version 1: get one pair's value given its key
		    // (presumably the key would really come from user input):
		    String queryString = "Sun";
		    System.out.println("You asked about " + queryString + ".");
		    String resultString = (String)map.get(queryString);
		    System.out.println("They are located in: " + resultString);
		    System.out.println();

		    // Version 2: get ALL the keys and pairs 
		    // (maybe to print a report, or to save to disk)
		    Iterator k = map.keySet().iterator();
		    while (k.hasNext()) {
		      String key = (String) k.next();
		      System.out.println(String.format("Key : %s ; %4s\t Value : %s",key,"",(String) map.get(key)));
		    }

		    // Step 3 - try out the entrySet() method.
		    Set es = map.entrySet();
		    System.out.println("\nentrySet() returns " + es.size() + " of Map.Entry's");
		  }
}