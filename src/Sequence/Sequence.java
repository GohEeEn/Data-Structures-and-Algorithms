package Sequence;

import Vector.Vector;
import Common.Position;
import List.List;

public interface Sequence<T> extends Vector<T>, List<T>{

	/**
	 * Method that returns the position at the given rank in this sequence
	 * @param rank 
	 * @return The position at the given rank
	 */
	public Position<T> atRank(int rank); 
	
	/**
	 * Method that returns the rank associated with position p
	 * @param p	The given position of an object in this sequence
	 * @return The rank associated with position p
	 */
	public int rankOf(Position<T> p);
}
