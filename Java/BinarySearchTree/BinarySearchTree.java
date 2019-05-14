package BinarySearchTree;

import Common.Position;

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> {
    
	protected ProperLinkedBSTBinaryTree<T> tree;
    protected int size;

    public BinarySearchTree() {
        tree = new ProperLinkedBSTBinaryTree<T>();
        size = 0;
    }

    public T insert(T value) {
        Position<T> current = locate(tree.root(), value);
        if (tree.isExternal(current)) {
            tree.expandExternal(current);
            tree.replace(current, value);
            size++;
            return value;
        }
        return current.element();
    }

    public T find(T value) {
        Position<T> current = locate(tree.root(), value);
        return current.element();
    }

    public T remove(T value) {
        Position<T> current = locate(tree.root(), value);
        if (tree.isExternal(current)) {
            return null;
        } else if (tree.isInternal(tree.left(current)) && tree.isInternal(tree.right(current))) {
            // Step 1 : Find next node in in-order traversal
            Position<T> next = tree.right(current);
            while (!tree.isExternal(next)) next = tree.left(next);

            // Step 2: copy the value of next into current
            T temp = tree.replace(current, tree.parent(next).element());

            // Step 3: remove next
            tree.remove(tree.parent(next));

            return temp;
        } else {
            return tree.remove(current);
        }
    }

    protected Position<T> locate(Position<T> current, T value) {
        if (tree.isExternal(current)) {
            return current;
        } else if (current.element().compareTo(value) > 0) {
            return locate(tree.left(current), value);
        } else if (current.element().compareTo(value) < 0) {
            return locate(tree.right(current), value);
        } else {
            return current;
        }
    }

    public String toString() {
        return tree.toString();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<T> iterator() {
        return tree.iterator();
    }
}
