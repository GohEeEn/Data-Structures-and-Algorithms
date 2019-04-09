package Queue;
/**
 * Implementation of array-based queue
 * @author Ee En Goh
 * @version 31 Jan 2019
 */
public class ArrayQueue<T> implements Queue<T>{
	
	/** The queue itself, which is array-implemented */
	private T[] array;
	
	/** The size of queue */
	private int size;
	
	/** The index to reference to the first element which stay for the longest time in the queue */
	private int front;
	
	/** The index that reference to the last element which is the newest element in the queue */
	private int rear;
	
	/** The size of the declared array */
	private int capacity;
	
	/**
	 * Default constructor :<br>
	 * - Default capacity of the array : 10 memory spaces<br>
	 */
	@SuppressWarnings("unchecked")
	ArrayQueue(){
		this.capacity = 10;		// Default array capacity : 10
		this.size = 0;		 	
		front = 0 ;					// The array index that are always pointed at front of the queue 
		rear = capacity - 1;		// The array index that are always pointed at end of the queue
		array = (T[]) new Object[this.capacity];
	}
	
	/**
	 * Overloaded constructor :<br>
	 * - Customized size of the array : the given capacity of array <br>
	 */
	@SuppressWarnings("unchecked")
	ArrayQueue(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		front = 0; // 0
		rear = capacity - 1;
		array = (T[]) new Object[this.capacity];
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (this.size == 0);
	}

	@Override
	public T front() {
		// TODO Auto-generated method stub
		if(isEmpty()) 
			System.out.println("Message : This stack is currently empty");
		
		return array[this.front];
	}

	@Override
	public T rear() {
		// TODO Auto-generated method stub
		if(isEmpty()) 
			System.out.println("Message : This stack is currently empty");
		
		return array[this.rear];
	}

	
	// ----- Operation Methods ------
	
	@Override
	public void enqueue(T data) {
		// TODO Auto-generated method stub
		if(this.size >= this.capacity) 
			System.out.println("Message : This stack is currently full, removal needed in order to insert new element");
		
		// Reset the rear index to the next of the font element , Circular array method to save memory space
		this.rear = (this.rear + 1) % this.capacity; 
		array[this.rear] = data;
		this.size++;
	}
	
	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		if(isEmpty()) 
			System.out.println("Message : This stack is currently empty");
		T removed = array[this.front];
		// Circular array method 
		this.front = (this.front + 1) % this.capacity;
		this.size--;
		return removed;
	}
	
	// ----- Display Method -----
	public String toString() {
		
		String output = "\n<size> / <capacity> : " + this.size + " / " + this.capacity + "\n[Front] ";
		
		// Display if the data stored sequentially	
		if(front < rear) {
			for(int i = front ; i <= rear ; i++) {
				output += array[i] ;
				if(i != rear)
					output += " < ";
			}
		}else { // Display if there is data stored circularly
			
			for(int i = front ; i < capacity ; i++) {
				output += array[i] ;
				if(i != rear)
					output += " < ";
			}
			
			for(int i = 0 ; i <= rear ; i++) {
				
				output += array[i] ;
				if(i != rear)
					output += " < ";
			} 
		}
		output += " [rear]";
		
		return output;
	}

	
	/**
	 * Test case
	 */
	public static void main(String[] agrs) {
		
		ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
	
		// Initialize the queue
		for(int i = 0 ; i < 10 ; ++i)
			queue.enqueue(new Integer(i));
		
		// Test cases
		System.out.println();
		System.out.println("Current queue : " + queue); // [ 0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9  ]
		System.out.println();
		
		queue.dequeue();
		System.out.println("After DEQUEUE , Current queue : " + queue); // [ 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9  ]
		System.out.println();
		
		queue.dequeue();
		System.out.println("After DEQUEUE , Current queue : " + queue); // [ 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9  ]
		System.out.println();
		
		queue.enqueue(-1);
		System.out.println("After ENQUEUE , Current queue : " + queue); // [ 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , -1 ]
		System.out.println();
		
		System.out.println("The value at the front of queue : " + queue.front());
		System.out.println("The value at the rear of queue : " + queue.rear());
	}
}