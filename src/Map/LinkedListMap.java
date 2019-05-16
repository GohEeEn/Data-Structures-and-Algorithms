package Map;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import List.Node;
import List.SinglyLinkedList;

public class LinkedListMap<K,V> implements Map<K,V>{
	
	private SinglyLinkedList<MapEntry<K,V>> sll = new SinglyLinkedList<MapEntry<K,V>>();   
	
	// ----- Accessor Method -----
	@Override
	public int size() { return sll.size(); }
		
	public boolean isEmpty() { return (sll.size()==0); }
		
	// O(n) in time-complexity in the worst case
	@SuppressWarnings("unchecked")
	public V get(K key){ 	
		// Case if map is empty
		if(sll.isEmpty())
			return null;
		
		Node<MapEntry<K, V>> curr = sll.first();
		
		// Case if the head node is the entry with key k 
		if(curr.getData().getKey().equals(key))
			return (V) curr.getData().getValue();
		
		// Traverse through the map to find the specific entry
		while(curr.getNext()!= null){
			
			curr = curr.getNext(); // Traverse to the next entry
			 // Case if key found
			if(curr.getData().getKey().equals(key)) 
				return (V) curr.getData().getValue();
		}
		 
		return null; // Else no entry with key k 
	}
	
	// ----- Operation Method ------
	// O(n) in time-complexity since we can insert the new item at the beginning or end of the sequence
	public V put(K key, V value) {
		
		Node<MapEntry<K, V>> curr = sll.first();	
		
		while(curr != null) {
			// System.out.println(key + " " + value);
			// If the entry with the given key is found 
			if(curr.getData().getKey().equals(key)) {
				
				// Get the previous value in the specific entry with key k
				@SuppressWarnings("unchecked")
				V tempValue = (V)curr.getData().getValue();
				
				// Set this entry with new associated value
				// sll.getNode(index).getData().setValue(value);
				curr.getData().setValue(value);
				
				return tempValue;
			}
			
			// Traverse to the next node
			curr = curr.getNext();
		}
		
		// Case if the entry with given key is not exist in this map
		sll.addLast(new MapEntry<K,V>(key,value));
		System.out.println(sll.toString());
		
		return null; // no previous value to return 
	}
	
	// O(n) in time-complexity in the worst case
	public V remove(K key){
		
		if(sll.isEmpty()) 
			return null;	// nothing to remove
		
		Node<MapEntry<K, V>> curr = sll.first();
		
		int index = 0;
		
		while(curr != null) {
			// If the entry with the given key is found 
			if(curr.getData().getKey().equals(key)) {
				
				// Get the previous value in the specific entry with key k
				@SuppressWarnings("unchecked")
				V tempValue = (V)curr.getData().getValue();
				
				// System.out.println(curr.getNext().getData()); DEBUG unsuccessful
				// Remove the current entry that has the given key 
				// sll.remove(curr); // Fail
				sll.remove(index);	 // Success by using remove(int)
				
				return tempValue;
			}
			
			// Traverse to the next node
			else if(curr.getNext()!=null) { 
				curr = curr.getNext();
				index++;
			}
		}
		System.out.println("The entry doesn't exist");
		return null; // no entry with key k found
	}
		
	// ----- Display Set Method -----
	public Set<MapEntry<K, V>> entrySet(){
		
		SinglyLinkedList<MapEntry<K, V>> entries = new SinglyLinkedList<MapEntry<K, V>>();
		Node<MapEntry<K,V>> curr = sll.first();
		
		for(int i = 0 ; i < sll.size() ; i++) {
			entries.addLast(curr.getData());
			curr = curr.getNext();
		}
		
		// Create an empty set
		Set<MapEntry<K,V>> entrySet = new HashSet<MapEntry<K,V>>();
		
		// Add each element of list into the set
		for(MapEntry<K,V> t : entries) {
			entrySet.add(t);
		}
		
		return entrySet;
	} 
		
	@SuppressWarnings("unchecked")
	public Set<K> keySet(){
		
		SinglyLinkedList<K> keys = new SinglyLinkedList<K>();
		Node<MapEntry<K,V>> curr = sll.first();
		
		for(int i = 0 ; i < sll.size() ; i++) {
			keys.addLast((K)curr.getData().getKey());
			curr = curr.getNext();
		}
		
		// Create an empty set
		Set<K> keySet = new HashSet<K>();
		
		// Add each element of list into the set
		for(K t : keys) {
			keySet.add(t);
		}
		
		return keySet;
	}
		
	@SuppressWarnings("unchecked")
	public Set<V> valueSet(){
		
		SinglyLinkedList<V> values = new SinglyLinkedList<V>();
		Node<MapEntry<K,V>> curr = sll.first();
		
		for(int i = 0 ; i < sll.size() ; i++) {
			values.addLast((V) curr.getData().getValue());
			curr = curr.getNext();
		}
		
		// Create an empty set : HashSet will automatically eliminate duplicate values
		Set<V> valueSet = new HashSet<V>();
		
		// Add each element of list into the set
		for(V t : values) {
			valueSet.add(t);
		}
		
		return valueSet;
	}	

	public static void main(String[] argv) {

	    // Construct and load the hash. This simulates loading a
	    // database or reading from a file, or wherever the data is.

	    LinkedListMap<String,String> map = new LinkedListMap<String, String>();
	    System.out.println("\n");
	    
	    // The hash maps from company name to address.
	    // In real life this might map to an Address object...
	    map.put("Gwei Lun Mei", "Secret");
	    map.put("Giddens Ko", "You are the apple in my eye");
	    map.put("Tom Cruise", "Mission Impossible");
	    map.put("The Rock", "San Andreas");
	    map.put("Vin Diesel", "XXX Agents");
	    map.put("Paul Walker", "Fast & Furious");
	    map.put("Jay Chou", "Secret");
	    
	    // Version 1 : Values Search according to the given key 
	    // Should be user input
	    System.out.println();
	    String queryString = "Jay Chou";
	    System.out.println("You asked about " + queryString + ".");
	    String resultString = (String)map.get(queryString);
	    System.out.println("They are located in: " + resultString);
	    System.out.println();

	    // Version 2: get all the keys and pairs ,  
	    Iterator<String> k = map.keySet().iterator();
	    while (k.hasNext()) {
	      String key = (String) k.next();
	      System.out.println(String.format("Key : %s ; %7s\t Value : %s",key,"",(String) map.get(key)));
	    }
	    System.out.println();
	    
	    // Step 3 - try out the entrySet() method.
	    Set<MapEntry<String, String>> es = map.entrySet();
	    System.out.println("There are " + es.size() + " Map.Entry's in this map");
	    System.out.println("Entry Set of this map : \n" + es);
	    
	    // Step 4 - try out the keySet() method
	    System.out.println("\nKeys Set of this map : \n" + map.keySet());
	    
	    // Step 5 - try out the valueSet() method
	    System.out.println("\nValues Set of this map : \n" + map.valueSet());
	    
	    // Step 6 - try remove() method
	    System.out.println("\nAfter Removal :");
	    
	    map.remove("Paul Walker");
	    System.out.println("\nKeys Set of this map : \n" + map.keySet());
	    System.out.println("\nValues Set of this map : \n" + map.valueSet());
	    
	    map.remove("Vin Diesel");
	    System.out.println("\nKeys Set of this map : \n" + map.keySet());
	    System.out.println("\nValues Set of this map : \n" + map.valueSet());
	    
	    // ----- Bug : The removal of entries with same value (different keys) removes the last entries of the map -----
	    map.remove("Tom Cruise");
	    System.out.println("\nKeys Set of this map : \n" + map.keySet());
	    System.out.println("\nValues Set of this map : \n" + map.valueSet());
	    
	    System.out.println(map.remove("Gwei Lun Mei"));
	    // map.remove("Gwei Lun Mei");
	    System.out.println("\nKeys Set of this map : \n" + map.keySet());
	    System.out.println("\nValues Set of this map : \n" + map.valueSet());
	    
	    map.remove("Jay Chou");
	    System.out.println("\nKeys Set of this map : \n" + map.keySet());
	    System.out.println("\nValues Set of this map : \n" + map.valueSet());

	    map.remove("Giddens Ko");
	    System.out.println("\nKeys Set of this map : \n" + map.keySet());
	    System.out.println("\nValues Set of this map : \n" + map.valueSet());
	    
	    map.remove("Paul Walker");
	    System.out.println("\nKeys Set of this map : \n" + map.keySet());
	    System.out.println("\nValues Set of this map : \n" + map.valueSet());
	  }
}