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
    	
    	// Process to find the position that satisfies BST definition and | insert the new node (if internal) |
        Position<T> current = find(tree.root(), value);
        
        // Else expand External() method 
        if (tree.isExternal(current)) {
            tree.expandExternal(current);
            tree.replace(current, value);
            size++;
            return value;
        }
        return current.element();
    }

    public T locate(T value) {
        Position<T> current = find(tree.root(), value);
        return current.element();
    }

    public T remove(T value) {
        Position<T> current = find(tree.root(), value);
        
        if (tree.isExternal(current)) {
        	System.out.println("External");
            return null;
            
        } // Case if both children nodes are internal nodes 
        else if (tree.isInternal(tree.left(current)) && tree.isInternal(tree.right(current))) {
        	
            // Step 1 : Find next node in in-order traversal
        	// Firstly we need to find an external node that has smaller value than right-child
        	// while larger than left-child of current node
        	// Step 1a : To find such node which is larger than left-child -> Go right
            Position<T> next = tree.right(current);
            
            // Step 1b : Finding the external node which has smaller value than target node's right child
            // Thus searching for the left-descendant
            while (!tree.isExternal(next)) next = tree.left(next);

            // Step 2: copy the value of next into current to replace the value of removed node
            T temp = tree.replace(current, tree.parent(next).element());

            // Step 3: remove next - The external node used to replace the target node
            // Hence it is transferred in value to the position of target node
            tree.remove(tree.parent(next));

            return temp;
            
        } else {
            return tree.remove(current);
        }
    }

    protected Position<T> find(Position<T> current, T value) {
    	
    	// It should returns null in general binary tree, 
    	// However here we also use it to find the empty slot for insertion, thus return the position
        if (tree.isExternal(current)) {	
            return current;
            
        } else if (current.element().compareTo(value) > 0) {
            return find(tree.left(current), value);
            
        } else if (current.element().compareTo(value) < 0) {
            return find(tree.right(current), value);
            
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
