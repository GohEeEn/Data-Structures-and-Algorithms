package Queue;

import List.DoublyLinkedList;

public class LinkedListDeque<E> implements Deque<E>{

	DoublyLinkedList<E> dll = new DoublyLinkedList<E>();
	
	@Override
	public E front() {
		
		if(isEmpty())
			return null;
		else
			return dll.first();
	}

	@Override
	public E back() {
		if(isEmpty())
			return null;
		else 
			return dll.last();
	}

	@Override
	public int size() { return dll.size(); }

	@Override
	public boolean isEmpty() { return dll.isEmpty(); }

	@Override
	public void insertFront(E e) { dll.addFirst(e); }

	@Override
	public void insertBack(E e) { dll.addLast(e); }

	@Override
	public E eraseFront() { return dll.removeFirst();}

	@Override
	public E eraseBack() { return dll.removeLast(); }
	
	public String toString() { return dll.toString(); }
	
	public static void main(String[] agrs) {
		
		// ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
		LinkedListDeque<Integer> queue = new LinkedListDeque<Integer>();
		
		// Initialize the queue
		for(int i = 0 ; i < 10 ; ++i)
			queue.insertBack(new Integer(i));
		
		// Test cases
		System.out.println();
		System.out.println("Current queue : " + queue); // [ 0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9  ]
		System.out.println();
		
		queue.eraseFront();
		System.out.println("After FRONT DEQUEUE , Current queue : " + queue); // [ 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 ]
		System.out.println();
		
		queue.eraseBack();
		System.out.println("After BACK DEQUEUE , Current queue : " + queue); // [ 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 ]
		System.out.println();
		
		queue.insertFront(-1);
		System.out.println("After FRONT ENQUEUE , Current queue : " + queue); // [ -1 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 ]
		System.out.println();
		
		System.out.println("The value at the front of queue : " + queue.front());
		System.out.println("The value at the rear of queue : " + queue.back());
	}
}