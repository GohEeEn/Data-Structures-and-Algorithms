package Queue;

import List.SinglyLinkedList;

/**
 * Implement data structure Queue by using SinglyLinkedlist and own implementation method
 * @author Ee En Goh
 * @version 30 Nov 2018
 */
public class LinkedListQueue<E> implements Queue<E>{
	
	SinglyLinkedList<E> ll = new List.SinglyLinkedList<E>();
	
	public int size() { return ll.size(); };

	public boolean isEmpty() { return (size() == 0); };
	
	public E front() { return ll.first().getData(); };
	
	public E rear() { return ll.last().getData(); };
	
	public void enqueue(E data) { ll.addLast(data); };
	
	public E dequeue() { return ll.removeFirst(); };
	
	public String toString() { return ll.toString(); }
	
	/**
	 * Test case
	 */
	public static void main(String[] agrs) {
		
		// ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
		LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
		
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
