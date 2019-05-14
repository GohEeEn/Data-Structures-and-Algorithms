package BinarySearchTree;

public class AVLTreeTest {
    public static void main(String[] args) {
        testInsertion();
        testExternalChildrenRemoval();
        testExternalRightChildRemoval();
        testExternalLeftChildRemoval();
        testInternalChildrenRemoval();
        testFindValue();
        testNoFindValue();

        System.out.println(basicTree().toString());
    }

    private static void testNoFindValue() {
        AVLTree<Integer> tree = basicTree();
        Integer value = tree.find(15);
        if (value != null) {
            System.out.println("testNoFindValue(): FAILURE");
            System.out.println("method was meant to return null, but it returned: " + value);
        } else {
            System.out.println("testNoFindValue(): SUCCESS");
        }
    }

    private static void testFindValue() {
        AVLTree<Integer> tree = basicTree();
        Integer value = tree.find(2);
        if (value != 2) {
            System.out.println("testNoFindValue(): FAILURE");
            System.out.println("method was meant to return 2, but it returned: " + value);
        } else {
            System.out.println("testFindValue(): SUCCESS");
        }
    }

    private static AVLTree<Integer> basicTree() {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.insert(7);
        System.out.println(tree);
        tree.insert(5);
        System.out.println(tree);
        tree.insert(2);
        System.out.println(tree);
        tree.insert(9);
        System.out.println(tree);
        tree.insert(12);
        System.out.println(tree);
        tree.insert(6);
        System.out.println(tree);
        tree.insert(3);
        System.out.println(tree);
        tree.insert(1);
        System.out.println(tree);
        tree.insert(4);
        System.out.println(tree);
        System.exit(0);
        return tree;
    }
    /**
     * tests that calling the push() method on a stack puts the item into the stack
     */
    public static void testInsertion() {
        AVLTree<Integer> tree = basicTree();
        if (tree.size() != 9) {
            System.out.println("testInsertion(): FAILURE");
            System.out.println("Expected tree to contain 9 values, but it contains: "+ tree.size());
        } else {
            System.out.println("testInsertion(): SUCCESS");
        }
    }

    public static void testExternalChildrenRemoval() {
        AVLTree<Integer> tree = basicTree();
        do_remove(tree, 2, "testExternalChildrenRemoval");
    }

    public static void testExternalRightChildRemoval() {
        AVLTree<Integer> tree = basicTree();
        do_remove(tree, 5, "testExternalRightChildRemoval");
    }

    public static void testExternalLeftChildRemoval() {
        AVLTree<Integer> tree = basicTree();
        do_remove(tree, 9, "testExternalLeftChildRemoval");
    }

    public static void testInternalChildrenRemoval() {
        AVLTree<Integer> tree = basicTree();
        do_remove(tree, 7, "testInternalChildrenRemoval");
    }

    private static void do_remove(AVLTree<Integer> tree, Integer value, String method) {
        Integer result = tree.remove(value);
        if (!value.equals(result)) {
            System.out.println(method+"(): FAILURE");
            System.out.println("method did not return "+value+" but: " + result);
        } else {
            System.out.println(method+"(): SUCCESS");
        }
    }
}
