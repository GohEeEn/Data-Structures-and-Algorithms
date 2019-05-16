package Sequence;

public interface Iterator<T> {

	/**
	 * Return a boolean that indicates if there is any object next
	 * @return True if there is at least one element at next, else false
	 */
	public boolean hasNext();
	
	/**
	 * Return the value of the next object
	 * @return value of the next object
	 */
	public T next();
}
