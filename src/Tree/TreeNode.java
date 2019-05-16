package Tree;

import Common.Position;

/**
 * A single unit in Tree structure
 * @author Ee En Goh
 */
public class TreeNode<T> implements Position<T> {
        
	/** Value stored in node(s) */
	public T element; 
		
	/** Node reference to the parent node */
    public TreeNode<T> parent;
        
    /** Node reference to the left-child node */
    public TreeNode<T> left;
        
    /** Node reference to the right-child node */
    public TreeNode<T> right;

    public TreeNode(T element, TreeNode<T> parent, TreeNode<T> left, TreeNode<T> right) {
    	this.element = element;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    @Override
    public T element() {
       return element;
    }    
}
