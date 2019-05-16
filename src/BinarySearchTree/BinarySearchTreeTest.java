package BinarySearchTree;

public class BinarySearchTreeTest {
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
        BinarySearchTree<Integer> tree = basicTree();
        Integer value = tree.find(15);
        if (value != null) {
            System.out.println("testNoFindValue(): FAILURE");
            System.out.println("method was meant to return null, but it returned: " + value);
        } else {
            System.out.println("testNoFindValue(): SUCCESS");
        }
    }

    private static void testFindValue() {
        BinarySearchTree<Integer> tree = basicTree();
        Integer value = tree.find(2);
        if (value != 2) {
            System.out.println("testNoFindValue(): FAILURE");
            System.out.println("method was meant to return 2, but it returned: " + value);
        } else {
            System.out.println("testFindValue(): SUCCESS");
        }
    }

    private static BinarySearchTree<Integer> basicTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(7);
        tree.insert(5);
        tree.insert(2);
        tree.insert(9);
        tree.insert(12);
        tree.insert(6);
        tree.insert(3);
        tree.insert(1);
        tree.insert(4);
        return tree;
    }
    /**
     * tests that calling the push() method on a stack puts the item into the stack
     */
    public static void testInsertion() {
        BinarySearchTree<Integer> tree = basicTree();
        if (tree.size() != 5) {
            System.out.println("testInsertion(): FAILURE");
            System.out.println("Expected tree to contain 5 values, but it contains: "+ tree.size());
        } else {
            System.out.println("testInsertion(): SUCCESS");
        }
    }

    public static void testExternalChildrenRemoval() {
        BinarySearchTree<Integer> tree = basicTree();
        do_remove(tree, 2, "testExternalChildrenRemoval");
    }

    public static void testExternalRightChildRemoval() {
        BinarySearchTree<Integer> tree = basicTree();
        do_remove(tree, 5, "testExternalRightChildRemoval");
    }

    public static void testExternalLeftChildRemoval() {
        BinarySearchTree<Integer> tree = basicTree();
        do_remove(tree, 9, "testExternalLeftChildRemoval");
    }

    public static void testInternalChildrenRemoval() {
        BinarySearchTree<Integer> tree = basicTree();
        do_remove(tree, 7, "testInternalChildrenRemoval");
    }

    private static void do_remove(BinarySearchTree<Integer> tree, Integer value, String method) {
        Integer result = tree.remove(value);
        if (!value.equals(result)) {
            System.out.println(method+"(): FAILURE");
            System.out.println("method did not return "+value+" but: " + result);
        } else {
            System.out.println(method+"(): SUCCESS");
        }
    }
}
