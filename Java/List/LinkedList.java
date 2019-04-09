package List;

import java.util.Iterator;

import Common.Position;

public class LinkedList<T> implements List<T> {
	
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
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Position<T> first() {
        if (first == null) throw new ListEmptyException();
        return first;
    }

    @Override
    public Position<T> last() {
        if (last == null) throw new ListEmptyException();
        return last;
    }

    private Node<T> toNode(Position<T> position) {
        return (Node<T>) position;
    }

    @Override
    public Position<T> prev(Position<T> p) {
        return toNode(p).prev;
    }

    @Override
    public Position<T> next(Position<T> p) {
        return toNode(p).next;
    }

    @Override
    public Position<T> insertFirst(T e) {
        Node<T> node = new Node(e, null, first);
        if (first == null) {
            last = node;
        } else {
            first.prev = node;
        }
        first = node;
        size++;
        return first;
    }

    @Override
    public Position<T> insertLast(T e) {
        Node<T> node = new Node(e, last, null);
        if (last == null) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
        size++;
        return first;
    }

    @Override
    public Position<T> insertBefore(Position<T> p, T e) {
        if (p == first) return insertFirst(e);
        Node<T> node = new Node<T>(e, toNode(p).prev, toNode(p));
        node.prev.next = node;
        node.next.prev = node;
        size++;
        return node;
    }

    @Override
    public Position<T> insertAfter(Position<T> p, T e) {
        if (p == last) return insertLast(e);
        Node<T> node = new Node<T>(e, toNode(p), toNode(p).next);
        node.prev.next = node;
        node.next.prev = node;
        size++;
        return node;
    }

    @Override
    public T replace(Position<T> p, T e) {
        Node<T> node = toNode(p);
        T temp = node.element;
        node.element = e;
        return temp;
    }

    @Override
    public T remove(Position<T> p) {
        Node<T> node = toNode(p);
        if (node == first) {
            first = first.next;
        } else {
            node.prev.next = node.next;
        }
        if (node == last) {
            last = last.prev;
        } else {
            node.next.prev = node.prev;
        }
        size--;

        // remove references to other nodes.
        node.next = null;
        node.prev = null;
        return node.element;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        Node<T> current = first;
        while (current != null) {
            buf.append(current.element.toString()+" ");
            current = current.next;
        }
        return buf.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Position<T> current;

            @Override
            public boolean hasNext() {
                if (isEmpty()) return false;
                if (current == null) return true;
                return !current.equals(last());
            }

            @Override
            public T next() {
                if (current == null) {
                    current = first();
                } else {
                    current = LinkedList.this.next(current);
                }
                return current.element();
            }
        };
    }
}
