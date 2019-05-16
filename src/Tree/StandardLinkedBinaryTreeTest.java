package Tree;

import Common.Position;

public class StandardLinkedBinaryTreeTest {
    
	public static void main(String[] args) {
		
        StandardLinkedBinaryTree<String> tree = new StandardLinkedBinaryTree<>();
        
        System.out.println(tree);
        Position<String> p0 = tree.addRoot("ron");
        System.out.println(tree);
        Position<String> p1 = tree.insertRight(p0, "rem");
        System.out.println(tree);
        tree.insertLeft(p1, "coral");
        System.out.println(tree);
        tree.insertRight(p1, "tanya");
        System.out.println(tree);
        tree.insertLeft(p0, "niki");
        System.out.println(tree);

    }
}
