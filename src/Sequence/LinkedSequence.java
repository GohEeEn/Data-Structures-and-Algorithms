package Sequence;

import java.util.Iterator;

import Common.Position;
import List.LinkedList;
import List.LinkedList.Node;

public class LinkedSequence<T> implements Sequence<T> {

	public static class Node<T> implements Position<T> {
        
    	private T element;
        private Node<T> prev;
        private Node<T> next;

        public Node(T element, Node<T> prev, Node<T> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public T element() {
            return element;
        }
        
        public Node<T> getPrev(){ return this.prev; }
        public Node<T> getNext(){ return this.next; }
        public void setPrev(Node<T> prev){ this.prev = prev ; }
        public void setNext(Node<T> next){ this.next = next ; }
        public void setElement(T element){ this.element = element; }
    }

	private int size;
	private Node<T> first;
	private Node<T> last;
	
	LinkedSequence(){
		this.size = 0;
		this.first = null;
		this.last = null;
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

	public boolean checkRank(int rank) {
		if(rank > size()) return false;
		return true;
	}
	
	@Override
	public T elemAtRank(int rank) {
		// TODO Auto-generated method stub
		return atRank(rank).element();
	}

	@Override
	public T replaceAtRank(int rank, T element) {
		// TODO Auto-generated method stub
		return this.replace(atRank(rank), element);
	}

	@Override
	public void insertAtRank(int rank, T element) {
		// TODO Auto-generated method stub
		// Insert before rank so the new element will in at given rank position
		if(this.isEmpty()) insertFirst(element); 
		else if(rank == size()) insertLast(element);
		else insertAfter(atRank(rank), element); 
	}

	@Override
	public T removeAtRank(int rank) {
		// TODO Auto-generated method stub
		return remove(atRank(rank));
	}
//
//	public String toString() {
//        StringBuffer buf = new StringBuffer();
//        Node<T> current = first;
//        while (current.getNext() != null) {
//            buf.append("[" + current.element.toString() + "] -> ");
//            current = current.next;
//        }
//        buf.append("[" + current.element.toString() + "]");
//        
//        return buf.toString();
//    }
//	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>() {

			private Position<T> current;
			
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				if(isEmpty()) return false;
				if(current == null) return true; // To indicate the entering of first element 
				return !current.equals(last);	 // True when it is not the last element 
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				if(current == null) current = first();				// Instantiate with the reference to first element
				else current = LinkedSequence.this.next(current);	// Else to go the next element
				return current.element();
			}
			
		};
	}

	public String toString() {
		
		Iterator<T> itr = this.iterator(); 
		
		String str = "first -> ";	// Indicate the pointer to the first element in this seq
		
		while(itr.hasNext()) {
			str += "["+ itr.next() +"] -> ";
		}
		
		str += " last"; // Indicate the pointer to the last element in this sequence
		
		return str;
	}
	
	private Node<T> toNode(Position<T> position) {
        return (Node<T>) position;
    }
	
	@Override
	public Position<T> first() {
		// TODO Auto-generated method stub
		return this.first;
	}

	@Override
	public Position<T> last() {
		// TODO Auto-generated method stub
		return this.last;
	}

	@Override
	public Position<T> prev(Position<T> p) {
		// TODO Auto-generated method stub
		return (Position<T>) toNode(p).getPrev() ;
	}

	@Override
	public Position<T> next(Position<T> p) {
		// TODO Auto-generated method stub
		return (Position<T>) toNode(p).getNext() ;
	}

	@Override
	public Position<T> insertFirst(T e) {
		// TODO Auto-generated method stub
		Node<T> node = new Node<T>(e, null, toNode(first()));
		
		// Case if it is an empty sequence
		if(first() == null) 
			this.last = node;
		else 
			this.first.setPrev(node);
		
		this.first = node;
		this.size++;
		
		return first();
	}

	@Override
	public Position<T> insertLast(T e) {
		// TODO Auto-generated method stub
		Node<T> node = new Node<T>(e, toNode(last()) , null);
		if(last() == null)
			this.first = node;
		else
			this.last.setNext(node);
		
		this.last = node;
		this.size++;
		
		return last();
	}

	@Override
	public Position<T> insertBefore(Position<T> p, T e) {
		// TODO Auto-generated method stub		
		Node<T> temp = toNode(p);
		
		if(temp.equals(first())) return insertFirst(e);
		
		Node<T> node = new Node<T>(e, temp.getPrev(), temp);
		
		temp.getPrev().setNext(node);
		temp.setPrev(node);

		this.size++;
		return node;
	}

	@Override
	public Position<T> insertAfter(Position<T> p, T e) {
		// TODO Auto-generated method stub
		Node<T> temp = toNode(p);
		Node<T> node = new Node<T>(e, temp, temp.getNext());
		
		if(temp.equals(last())) return insertLast(e);
		
		temp.getNext().setPrev(node);
		temp.setNext(node);
		this.size++;
		
		return node;
	}

	@Override
	public T replace(Position<T> p, T e) {
		// TODO Auto-generated method stub
		T temp = p.element();
		toNode(p).setElement(e);
		return temp;
	}

	@Override
	public T remove(Position<T> p) {
		// TODO Auto-generated method stub
		Node<T> target = toNode(p);
		T temp 	= target.element();
		
		// If the given position is head element
		if(first().equals(target))
			this.first = target.getNext();
		else
			target.getPrev().setNext(target.getNext());
		
		// If the given position is head element
		if(last().equals(target))
			this.last = target.getPrev();
		else			
			target.getNext().setPrev(target.getPrev());
		
		target.setElement(null);
		target.setNext(null);
		target.setPrev(null);
		this.size--;
		
		return temp;
	}

	@Override
	public Position<T> atRank(int rank) {
		// TODO Auto-generated method stub
		
		Position<T> current = first();
		
		System.out.println(rank);
		// Implementation to decline runtime from O(n) to O(n/2)
		if(rank < size()/2) {
			current = first();
			for(int i = 0 ; i < rank ; i++)
				current = next(current);	
		}else {
			current = last();
			for(int i = size() ; i > rank ; i--)
				current = prev(current);
		}
		return current;
	}

	@Override
	public int rankOf(Position<T> p) {
		// TODO Auto-generated method stub
		Position<T> current = first();
		
		int i = 0;
		while(current != p) {
			current = next(current);
			i++;
		}
		
		return i;
	}

}
