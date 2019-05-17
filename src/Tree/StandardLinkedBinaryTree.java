package Tree;

import Common.Position;

public class StandardLinkedBinaryTree<T> extends AbstractLinkedBinaryTree<T> {
	
	/**
	 * Create and return a new root node storing element, and an error should occur if the tree is not empty
	 * @param element	Value stored in root node
	 * @return	The Position reference to root node
	 */
    public Position<T> addRoot(T element) {
        if (root != null) throw new InvalidPositionException("A root node already exists for this tree");
        return this.root = new TreeNode<T>(element, null, null, null);
    }

    /**
     * Create a return a new node storing element as the left child of p, and an error should occur if p has a left child
     * @param p			Position reference to target node
     * @param element	Value that is storing into the left-child of target node
     * @return			Position reference to the new created left-child of the target node
     */
    public Position<T> insertLeft(Position<T> p, T element) {
        TreeNode<T> node = toTreeNode(p);
        if (node.left() != null) throw new InvalidPositionException("A left node already exists");
        node.setLeft(new TreeNode<T>(element, node, null, null));
        size++;
        return node.left();
    }

    /**
     * Create a return a new node storing element as the right child of p, and an error should occur if p has a right child
     * @param p			Position reference to the target node
     * @param element	Value that is storing into the right-child of target node
     * @return			Position reference to the new created right-child of the target node
     */
    public Position<T> insertRight(Position<T> p, T element) {
        TreeNode<T> node = toTreeNode(p);
        if (node.right() != null) throw new InvalidPositionException("A right node already exists");
        node.setRight (new TreeNode<T>(element, node, null, null));
        size++;
        return node.right();
    }

    /**
     * For this implementation, the remove method will initially only allow you to remove
     * external nodes.
     * Done by remove the the children reference from the parent of target node
     * @param p		Position reference to the target node
     * @return		The original value stored in the removed node
     */
    public T remove(Position<T> p) {
        if (isInternal(p)) throw new InvalidPositionException("You can only remove external nodes!");

        TreeNode<T> node = toTreeNode(p);
        // Need to work out:
        // - is it the root node (special case)
        // - is it a left child of the parent?
        // - is it a right child of the parent?
        if (isRoot(p)) {
            root = null;
        } else if (node.parent().left() == node) {
            node.parent().setLeft(null);
            node.setParent(null);
        } else { // node.parent.right == node
            node.parent().setRight(null);
            node.setParent(null);
        }
        size--;
        return node.element();
    }
}
