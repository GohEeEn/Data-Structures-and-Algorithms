package Tree;

import Common.Position;

/**
 * A single unit in Tree structure
 * @author Ee En Goh
 */
public class TreeNode<T> implements Position<T> {
        
	/** Value stored in node(s) */
	private T element; 
		
	/** Node reference to the parent node */
    private TreeNode<T> parent;
        
    /** Node reference to the left-child node */
    private TreeNode<T> left;
        
    /** Node reference to the right-child node */
    private TreeNode<T> right;

    public TreeNode(T element, TreeNode<T> parent, TreeNode<T> left, TreeNode<T> right) {
    	this.element = element;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    @Override
    public T element() { return element;}    
    public TreeNode<T> left(){ return this.left; }
    public TreeNode<T> right(){ return this.right; }
    public TreeNode<T> parent(){ return this.parent; }
    
    public void setElement(T element) { this.element = element; }
    public void setLeft(TreeNode<T> left) { this.left = left; };
    public void setRight(TreeNode<T> right) { this.right = right; };
    public void setParent(TreeNode<T> parent) { this.parent = parent; };
}
