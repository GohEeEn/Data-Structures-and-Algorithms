package Tree;

import Common.Position;
import Stack.ArrayStack;
import Stack.LinkedStack;
import Stack.Stack;
import Vector.ArrayVector;
import Vector.Vector;

import java.util.Iterator;

/**
 * Basic implementation of a link-based binary tree
 */
public abstract class AbstractLinkedBinaryTree<T> implements BinaryTree<T> {

	/** TreeNode reference to the root TreeNode */
    protected TreeNode<T> root;
    
    /** The total size of the binary tree */
    protected int size;

    /**
     * The constructor is declared protected so that it cannot be called from outside
     * the class (it can only be called in this class or in sub-classes of this class.
     *
     * This is an extra mechanism that ensures that we do not create instances of this
     * class, but only create instances of its subclasses.
     */
    protected AbstractLinkedBinaryTree() {
        root = null;
        size = 0;
    }

    /**
     * Method to return the TreeNode in any position with the value-reference
     * @param p	The value-reference to the TreeNode
     * @return TreeNode reference to the target TreeNode	
     */
    protected TreeNode<T> toTreeNode(Position<T> p) {
        return (TreeNode<T>) p;
    }

    @Override
    public Position<T> left(Position<T> p) {
        TreeNode<T> TreeNode = toTreeNode(p);
        if (TreeNode.left() == null) throw new InvalidPositionException("There is no left child");
        return TreeNode.left();
    }

    @Override
    public Position<T> right(Position<T> p) {
        TreeNode<T> TreeNode = toTreeNode(p);
        if (TreeNode.right() == null) throw new InvalidPositionException("There is no right child");
        return TreeNode.right();
    }

    @Override
    public boolean hasLeft(Position<T> p) {
        return toTreeNode(p).left() != null;
    }

    @Override
    public boolean hasRight(Position<T> p) {
        return toTreeNode(p).right() != null;
    }

    @Override
    public Position<T> root() {
        if (root == null) throw new InvalidPositionException("There is no root TreeNode");
        return root;
    }

    @Override
    public Position<T> parent(Position<T> p) {
        TreeNode<T> TreeNode = toTreeNode(p);
        if (TreeNode.parent() == null) throw new InvalidPositionException("There is no parent");
        return TreeNode.parent();
    }

    @Override
    public Iterator<Position<T>> children(Position<T> p) {
        TreeNode<T> TreeNode = toTreeNode(p);
        Vector<Position<T>> vector = new ArrayVector<Position<T>>();
        if (TreeNode.left() != null) vector.insertAtRank(0, TreeNode.left());
        if (TreeNode.right() != null) vector.insertAtRank(0, TreeNode.right());
        return vector.iterator();
    }

    @Override
    public boolean isInternal(Position<T> p) {
        TreeNode<T> TreeNode = toTreeNode(p);
        return TreeNode.left() != null || TreeNode.right() != null;
    }

    @Override
    public boolean isExternal(Position<T> p) {
        TreeNode<T> TreeNode = toTreeNode(p);
        return TreeNode.left() == null && TreeNode.right() == null;
    }

    @Override
    public boolean isRoot(Position<T> p) {
        return p == root;
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
    public T replace(Position<T> p, T t) { // TODO
        TreeNode<T> TreeNode = toTreeNode(p);
        T temp = TreeNode.element();
        TreeNode.setElement(t);;
        return temp;
    }

    /**
     * Implements an in-order traversal of the tree using a stack to control the recursive
     * steps.
     *
     * GO-LEFT
     * PROCESS TreeNode
     * GO-RIGHT
     */
    @Override
    public Iterator<Position<T>> positions() {
        
    	return new Iterator<Position<T>>() {
        	
            Stack<TreeNode<T>> stack;
            TreeNode<T> current = root;

            // The code below is an initialisation block. It is something
            // like a constructor, but not the same. Initialisation blocks
            // cannot be parameterised, and are called no matter which
            // constructor you use. They are called BEFORE the constructor
            // is invoked.
            //
            // This means that they should be used to implement common pieces
            // of initialisation code.
            {
            	stack = new LinkedStack<TreeNode<T>>();
                
                // Start by traversing to the left most
                // TreeNode in the tree.
                while (current != null) {
                    stack.push(current);
                    current = current.left();
                }
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public Position<T> next() {
                TreeNode<T> TreeNode = stack.pop();

                // Now find the next TreeNode:
                // - go right (if a right child exists), then
                // - keep going left until you cannot go further
                if (TreeNode.right() != null) {
                    current = TreeNode.right();
                    while (current != null) {
                        stack.push(current);
                        current = current.left();
                    }
                }
                return TreeNode;
            }
        };
    }

    /**
     * The value iterator simply reuses the position iterator
     * but returns the element at the position instead of the
     * position...
     *
     * @return	The iterator of elements in those TreeNode
     */
    @Override
    public Iterator<T> iterator() {
       
    	return new Iterator<T>() {
        	
            Iterator<Position<T>> iterator = positions();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T next() {
                return iterator.next().element();
            }
        };
    }

    /**
     * 
     * @param buf
     * @param TreeNode
     * @param tabs
     */
    private void append(StringBuffer buf, TreeNode<T> TreeNode, String tabs) {
        buf.append(tabs);
        buf.append(TreeNode.element());
        buf.append("\n");
        if (TreeNode.left() != null) append(buf, TreeNode.left(), tabs+"\t");
        if (TreeNode.right() != null) append(buf, TreeNode.right(), tabs+"\t");
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        if (root == null) buf.append("TREE IS EMPTY");
        else append(buf, root, "");
        return buf.toString();
    }
    
    public String TreeNodeToString(Position<T> TreeNode) {    	
    	return "This TreeNode has parent " + parent(TreeNode) + " ; LeftChild : " + left(TreeNode) + " ; RightChild : " + right(TreeNode);
    }
}
