package Sequence;

import Vector.Vector;

/**
 * An iterator for any Vector object
 * @author Ee En Goh
 * @param <T>
 */
public class VectorIterator<T> implements Iterator<T> {

	private int rank;
	private Vector<T> vector;
	
	public VectorIterator(Vector<T> vector){
		this.rank = 0;
		this.vector = vector;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return (rank > 0 && rank < vector.size());
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		return vector.elemAtRank(rank+1);
	}

}
