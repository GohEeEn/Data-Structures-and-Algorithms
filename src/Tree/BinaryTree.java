package Tree;

import Common.Position;

public interface BinaryTree<T> extends Tree<T> {
	
	/**
	 * @param p	Target node with the value-reference given
	 * @return	The Position of p's left child
	 */
    public Position<T> left(Position<T> p);
    
    /**
     * @param p Target node with the value-reference given
     * @return 	The Position of p's right child
     */
    public Position<T> right(Position<T> p);
    
    /**
     * @param p	Target node with the value-reference given
     * @return	True if node p has a left child, else false
     */
    public boolean hasLeft(Position<T> p);
    
    /**
     * @param p	Target node with the value-reference given
     * @return	True if node p has a right child, else false
     */
    public boolean hasRight(Position<T> p);
}
