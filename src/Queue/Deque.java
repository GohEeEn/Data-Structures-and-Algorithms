package Queue;
/**
 * Double-ended queue / Deque :
 * >> Queue-like data structure that supports insertion and deletion at both the front and the rear of the queue
 * >> Most deque implementations place no fixed limits on the number of elements they may contain
 * >> This interface contains :
 * 	-> Methods to insert, remove and examine the element
 * 	-> Each of them exists in 2 forms : [ Fail Case ]
 * 		> Throws an exception if the operation fails
 * 		> Returns a special value 
 * @author Ee En Goh
 */
public interface Deque<E>{
	
	// ----- Accessor Methods -----
	/**
	 * Return a reference to the front element of the queue without removing it
	 * @return The reference that points to the first element in the queue
	 */
	E front();
	
	/**
	 * Return a reference to the back element of the queue without removing it
	 * @return The reference that points to the last element in the queue
	 */
	E back();
	
	// ----- Examine Methods -----
	/**
	 * Number of elements in the stack
	 * @return The integer that shows the number of elements in the stack
	 */
	int size();
	
	/**
	 * Boolean method that determine if the queue is empty
	 * @return true if the stack is empty, else false
	 */
	boolean isEmpty();
	
	// ----- Operation Methods -----
	/**
	 * Insert the element at front of the queue
	 * @param e Value that assign to the front entry of queue 
	 */
	void insertFront(E e);
	
	/**
	 * Insert the element at back of the queue
	 * @param e Value that assign to the back entry of queue 
	 */
	void insertBack(E e);
	
	/**
	 * Remove element at the front of the queue
	 * @return The removed entry value from the front of the queue
	 */
	E eraseFront();
	
	/**
	 * Remove element at the back of the queue
	 * @return The removed entry value from the back of the queue
	 */
	E eraseBack();
}