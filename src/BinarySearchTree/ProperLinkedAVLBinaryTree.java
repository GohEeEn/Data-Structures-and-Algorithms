package BinarySearchTree;

import Common.Position;
import Tree.TreeNode;

public class ProperLinkedAVLBinaryTree<T> extends ProperLinkedBSTBinaryTree<T> {
    
	public Position<T> singleLeft(Position<T> _a, Position<T> _b, Position<T> _c) {
        TreeNode<T> b = toTreeNode(_b);
        TreeNode<T> c = toTreeNode(_c);
        TreeNode<T> b_right = b.right;
        updateParent(c, b);
        b.right = c;
        c.parent = b;
        c.left = b_right;
        b_right.parent = c;
        return b;
    }

    public Position<T> singleRight(Position<T> _a, Position<T> _b, Position<T> _c) {
        TreeNode<T> a = toTreeNode(_a);
        TreeNode<T> b = toTreeNode(_b);
        TreeNode<T> b_left = b.left;
        updateParent(a, b);
        b.left = a;
        a.parent = b;
        a.right = b_left;
        b_left.parent = a;
        return b;
    }

    public Position<T> doubleLeftRight(Position<T> a, Position<T> b, Position<T> c) {
        return doubleRotation(toTreeNode(a), toTreeNode(b), toTreeNode(c), toTreeNode(a));
    }

    public Position<T> doubleRightLeft(Position<T> a, Position<T> b, Position<T> c) {
        return doubleRotation(toTreeNode(a), toTreeNode(b), toTreeNode(c), toTreeNode(c));
    }

    private Position<T> doubleRotation(TreeNode<T> a, TreeNode<T> b, TreeNode<T> c, TreeNode<T> root) {
        TreeNode<T> b_left = b.left;
        TreeNode<T> b_right = b.right;

        updateParent(root, b);

        b.left = a;
        a.parent = b;
        a.right = b_left;
        b_left.parent = a;
        b.right = c;
        c.parent = b;
        c.left = b_right;
        b_right.parent = c;
        return b;
    }

    private void updateParent(TreeNode<T> c, TreeNode<T> b) {
        if (!isRoot(c)) {
            TreeNode<T> parent = toTreeNode(parent(c));
            b.parent = parent;
            if (left(parent) == c) parent.left = b;
            else parent.right = b;
        } else {
            b.parent = null;
            root = b;
        }
    }
}
