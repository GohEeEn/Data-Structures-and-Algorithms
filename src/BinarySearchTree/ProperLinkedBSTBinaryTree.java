package BinarySearchTree;

import Common.Position;
import Tree.InvalidPositionException;
import Tree.ProperLinkedBinaryTree;
import Tree.TreeNode;

public class ProperLinkedBSTBinaryTree<T> extends ProperLinkedBinaryTree<T> {
	
    public T remove(Position<T> position) {
    	
        if (isInternal(left(position)) && isInternal(right(position))) {
            throw new InvalidPositionException("Cannot remove a node with 2 internal children)");
        }

        TreeNode<T> toRemove = toTreeNode(position);
        TreeNode<T> replacement;
        if (isInternal(right(position))) {
            replacement = toRemove.right();
        } else {
            replacement = toRemove.left();
        }
        replacement.setParent(toRemove.parent());
        if (toRemove.parent().left() == toRemove) {
            toRemove.parent().setLeft(replacement);
        } else {
            toRemove.parent().setRight(replacement);
        }
        
        toRemove.setParent(null);
        toRemove.right().setParent(null);
        toRemove.setRight(null);
        toRemove.setLeft(null);
        
        size-=2;
        
        return toRemove.element();
    }

}
