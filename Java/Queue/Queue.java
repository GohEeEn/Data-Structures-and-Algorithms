package Queue;
/**
 * Interface of general implementation of data structure Queues<br>
 * It provides of the default methods that the data structure queue should at least has<br>
 * Queues :<br>
 * >> Data structure where we add elements at the back and remove elements from the front<br>
 * >> Waiting in line : The first one to be added to the queue will be the first one to be removed<br>
 * >> FIFO ( First In First Out ) data structure<br>
 * >> Elements enter the queue at the rear and are removed from the front<br> 
 * @author Ee En Goh
 * @version 31 Jan 2019
 */
public interface Queue<T>{
	
	/**
	 * Accessor method that returns the number of elements in the queue
	 * @return The size of the queue in integer
	 */
	public int size();
	
	/**
	 * Method that indicate if the queue is empty
	 * @return True if the queue is empty, false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * Method that return the value of the first element / the earliest inserted element to the queue without the removal 
	 * @return The first element of the queue ( or null if the queue is empty )
	 */
	public T front();
	
	/**
	 * Method that return the value of the last element / the latest inserted element to the queue without the removal 
	 * @return The last element of the queue ( or null if the queue is empty )
	 */
	public T rear();
	
	/**
	 * Core method that inserts an element to the end of the queue
	 * @param data The value of the new element to be inserted in the queue
	 */
	public void enqueue(T data);
	
	/**
	 * COre method that removes and returns the value of the earliest element in the queue
	 * @return The earliest element that will be removed ( or null if the queue is empty )
	 */
	public T dequeue();
}