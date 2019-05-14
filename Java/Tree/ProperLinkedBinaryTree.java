package Tree;

import Common.Position;

/**
 * A kind of binary tree which has degree 0 (external) or 2 (internal node) in every node<br>
 * - It is built by expanding external nodes to become internal nodes, 
 * 	 with a starting external node - root node<br>
 */
public class ProperLinkedBinaryTree<T> extends AbstractLinkedBinaryTree<T> {
    
	public ProperLinkedBinaryTree() {
        root = new TreeNode(null, null, null, null);
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
        node.left = new TreeNode(null, node, null, null);
        node.right = new TreeNode(null, node, null, null);
        size += 2;
    }

    /**
     * Removal of child-node(s) of p , if p is an internal node (2 child)
     * @param p	Position reference to the target node 
     */
    public void collapseInternal(Position<T> p) {
    	
        if (isExternal(p)) throw new InvalidPositionException("Attempt to collapse external node");
        TreeNode<T> node = toTreeNode(p);

        if (isInternal(node.left))
            throw new InvalidPositionException("Attempt to collapse internal node with internal left child");

        if (isInternal(node.right))
            throw new InvalidPositionException("Attempt to collapse internal node with internal right child");

        node.left.parent = null;
        node.left = null;
        node.right.parent = null;
        node.right = null;
        size -= 2;
    }
}
