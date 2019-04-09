package Queue;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDeque<Item> implements Iterable<Item>{

	private static final int MIN_ARRAY_SIZE = 2;
	private Item[] items;
	private int itemCount, firstPosition, lastPosition;
	
	/**
	 * Default constructor
	 */
	public ArrayDeque() {
		
		itemCount = 0;
		items = (Item[]) new Object[MIN_ARRAY_SIZE];
		firstPosition = 0;
		lastPosition = 1;
	}
	
	public int size(){ return itemCount; }
	public boolean isEmpty() { return size() == 0; }
	
	public void addFirst(Item item) {
		if(item == null) {
			throw new NullPointerException("You cannot add Null to deque");
		}
		if(firstPosition < 0)
			resize(items.length + itemCount, Side.FRONT);
		items[firstPosition--] = item;
		itemCount++;
	}
	
	public void addLast(Item item) {
		if(item == null)
			throw new NullPointerException("Youcannot add Null to deque!");
		
		if(lastPosition == items.length)
			resize(items.length + items.length, Side.END);
			
		items[lastPosition++] = item;
		itemCount++;
	}
	
	public Item removeLast() {
		
		if(isEmpty()) {
			throw new NoSuchElementException("Deque is already empty");
		}
		Item item = items[--lastPosition];
		items[lastPosition] = null;
		itemCount--;
		if(itemCount > 0 && firstPosition + items.length - lastPosition >= itemCount << 2 ) {
			resize(itemCount << 1, Side.BOTH);
		}
		return item;
	}
	
	/**
	 * Enum representing sides of the {@code Deque}
	 */
	private enum Side{
		
		/** Front side */
		FRONT,
		/** End side */
		END,
		/** Both sides */
		BOTH
	}
	
	/**
	 * Increases or decerases the size of the array with items by given capacity from given side
	 * This method does nothing if capacity is less than the number of items in {@code Deque}
	 * @param capacity
	 * @param side
	 */
	private void resize(int capacity, Side side) {
		
		if(capacity < itemCount)
			return;
		Item[] tmpArr = (Item[]) new Object[capacity];
		int destinationPosition = 0;
		int length = lastPosition;
		int start = 0;
		switch(side) {
			
			case BOTH : 
				start = firstPosition + 1;
				destinationPosition = (capacity - itemCount) >> 1 ;
				firstPosition = destinationPosition - 1;
				length = itemCount;
				lastPosition = destinationPosition - 1;
				length = itemCount;
				lastPosition = destinationPosition + length;
				break;
				
			case FRONT :
				if(capacity < items.length) {
					
					start = firstPosition;
					int difference = items.length - capacity;
					firstPosition -= difference;
					lastPosition -= difference;
					destinationPosition = length = itemCount;
				}
				break;
				
			default : // no action required if side is END
				break;
		}	
		
		System.arraycopy(items, start, tmpArr, destinationPosition, length);
		items = tmpArr;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}