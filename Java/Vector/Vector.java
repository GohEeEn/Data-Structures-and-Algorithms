package Vector;

/**
 * An array-like data structure that supports insertion, removal and accessing of objects based on rank
 * Rank : The rank of an object e is an integer value that specifies the number of objects that come before e in vector
 * Differences with arrays 
 * - No fixed capacity
 * - Object ranks change 
 * @author Ee En Goh 
 */
public interface Vector<T> {
	
	// ----- Support Operations -----
	
	/**
	 * @return The number of elements in the vector
	 */
    int size();
    
    /**
     * @return True if the vector is empty, or false otherwise
     */
    boolean isEmpty();
    
    // ----- Core Operations -----
    /**
     * Return the object with rank r, while an error condition occurs if the vector is empty or r < 0 or r > size()-1
     * @param rank	The rank of the target object
     * @return Object with rank r
     */
    T elemAtRank(int rank);
    
    /**
     * Replace the object at rank r with e, while an error condition occurs if the vector is empty or r < 0 or r > size()-1
     * @param rank	The rank of the target object
     * @param element	The new given element value to replace the original value
     * @return	The original object value at that rank, null if none of element was on given rank
     */
    T replaceAtRank(int rank, T element);
    
    /**
     * Insert an object element into the vector with rank r, while  an error condition occurs if the vector is empty or r < 0 or r > size()-1 
     * @param rank	The rank given to the new element to the vector
     * @param element	The given element value assigned
     */
    void insertAtRank(int rank, T element);
    
    /**
     * Remove the object at rank r, while an error condition occurs if the vector is empty or r < 0 or r > size()-1
     * @param rank	The rank of the target object
     * @return The value of removed object
     */
    T removeAtRank(int rank);
}
