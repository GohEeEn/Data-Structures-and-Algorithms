package Sequence;

import Common.Position;
import List.List;

/**
 * A list iterator for any list class
 * @author Ee En Goh
 * @param <T>
 */
public class ListIterator<T> implements Iterator<T> {

	private Position<T> current;
	private List<T> list; 
	
	public ListIterator(List<T> list) {
//		this.current = list.first(); 
//		For list since we need to access the first element by using next()
//		Thus we only initialize the position of current in next() method with first()
		this.list = list;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(list.isEmpty() || list.size() == 0) return false;
		if(current == null) return true;
		return !current.equals(list.last());
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		if(current == null) current = list.first();
		else current = list.next(current);
		return current.element();
	}

}
