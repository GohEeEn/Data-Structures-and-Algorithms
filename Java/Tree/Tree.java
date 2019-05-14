package Tree;

import Common.Position;

import java.util.Iterator;

public interface Tree<T> extends Iterable<T> {
	
	/**
	 * @return Returns the Position for the root
	 */
    public Position<T> root();
    
    /**
     * @param p Target node with the value-reference given
     * @return The Position of p's parent
     */
    public Position<T> parent(Position<T> p);
    
    /**
     * @param p	Target node with the value-reference given
     * @return	An iterator of the Position of p's children 
     */
    public Iterator<Position<T>> children(Position<T> p);
    
    /**
     * @param p Target node with the value-reference given
     * @return	True if the target node is an internal element, else false
     */
    public boolean isInternal(Position<T> p);
    
    /**
     * @param p Target node with the value-reference given
     * @return	True if the target node is an external element, else false
     */
    public boolean isExternal(Position<T> p);
    
    /**
     * Method to check if the current node is a root node
     * @param p	Target node with the value-reference given
     * @return	True if the current node is a root node, else false
     */
    public boolean isRoot(Position<T> p);
    
    /**
     * @return The total size of the binary tree
     */
    public int size();
    
    /**
     * Method to check if the tree is empty 
     * @return	True if the tree is empty, else false
     */
    public boolean isEmpty();
    
    /**
     * @return	Returns an iterator of every Position in the tree
     */
    public Iterator<Position<T>> positions();
    
    /**
     * 	Method to replace the element at Position p with value t
     * @param p	Target node with the value-reference given
     * @param t	The new value stored at Position p
     * @return	The old value stored at Position p
     */
    public T replace(Position<T> p, T t);
}
