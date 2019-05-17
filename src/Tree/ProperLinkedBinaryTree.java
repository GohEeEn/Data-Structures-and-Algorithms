package Tree;

import Common.Position;

/**
 * A kind of binary tree which has degree 0 (external) or 2 (internal node) in every node<br>
 * - It is built by expanding external nodes to become internal nodes, 
 * 	 with a starting external node - root node<br>
 * - Every external node is expected to be a null node, except root node
 */
public class ProperLinkedBinaryTree<T> extends AbstractLinkedBinaryTree<T> {
    
	public ProperLinkedBinaryTree() {
        root = new TreeNode<T>(null, null, null, null);
        size = 1;
    }

	/**
	 * Create 2 new null nodes and add them the left and right node of node at Position p, 
	 * an error occurs if v is not external
	 * @param p
	 */
    public void expandExternal(Position<T> p) {
    	
        if (!isExternal(p)) throw new InvalidPositionException("Attempt to expand Internal node");
        TreeNode<T> node = toTreeNode(p);
        node.setLeft(new TreeNode<T>(null, node, null, null));
        node.setRight(new TreeNode<T>(null, node, null, null));
        size += 2;
    }
    
    /**
     * Removal of child-node(s) of p , if p is an internal node (2 child)
     * @param p	Position reference to the target node 
     */
    public void collapseInternal(Position<T> p) {
    	
    	// Throws error when the target node is a external -> nothing to remove
        if (isExternal(p)) throw new InvalidPositionException("Attempt to collapse external node");
        TreeNode<T> node = toTreeNode(p);

        if (isInternal(node.left()))
            throw new InvalidPositionException("Attempt to collapse internal node with internal left child");

        if (isInternal(node.right()))
            throw new InvalidPositionException("Attempt to collapse internal node with internal right child");
        
//        // Throw error when the target node has both internal child nodes 
//        if(isInternal(node.left()) && isInternal(node.right()))
//        		throw new InvalidPositionException("Attempt to collapse internal node with 2 internal child");
//        
//        // Case 1 - Only 1 internal children node
//        // Case 1a - If it is left-child
//        if(isInternal(node.left())) {
//
//        	if(node.parent().left().equals(node))
//        		node.parent().setLeft(node.left());
//        	else
//        		node.parent().setRight(node.left());
//        	node.setParent(null);
//        }
//        // Case 1b - If it is right-child
//        else if(isInternal(node.right())){
//        	
//        	if(node.parent().left().equals(node))
//        		node.parent().setLeft(node.right());
//        	else
//        		node.parent().setRight(node.right());
//        	node.setParent(null);
//        } 
//        // Case 2 - Both children nodes are external
//        else {
        	node.left().setParent(null);
            node.setLeft(null);
            node.right().setParent(null);
            node.setRight(null);
//        }
        
        size -= 2;
    }
}
