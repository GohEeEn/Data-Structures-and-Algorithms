package Tree;

import Common.Position;

public class ProperLinkedBinaryTreeTest {
	
	// TODO
    public static void main(String[] args) {
    	
        ProperLinkedBinaryTree<String> tree = new ProperLinkedBinaryTree<>();
        
        // Initially PBT starts with an empty root node
        System.out.println(tree);
        
        // The tree is built up by expanding any external node with 2 empty element
        tree.expandExternal(tree.root());
        
        // Value assigned to any empty node by using replace() method with the reference to given position
        tree.replace(tree.root(), "ron");
        
        System.out.println(tree.toTreeNode(tree.root()).left());
    }
}
