package BinarySearchTree;

import Common.Position;

import java.util.HashMap;
import java.util.Map;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    private Map<Position<T>, Integer> heights = new HashMap<Position<T>, Integer>();

    public AVLTree() {
        tree = new ProperLinkedAVLBinaryTree<T>();
        size = 0;
        heights.put(tree.root(), 0);
    }

    @Override
    public T insert(T value) {
        Position<T> current = locate(tree.root(), value);
        if (tree.isExternal(current)) {
            tree.expandExternal(current);
            tree.replace(current, value);
            size++;

            heights.put(tree.left(current), 0);
            heights.put(tree.right(current), 0);
            rebalance(current);
            return value;
        }
        return current.element();
    }

    @Override
    public T remove(T value) {
        Position<T> current = locate(tree.root(), value);
        if (tree.isExternal(current)) {
            return null;
        } else if (tree.isInternal(tree.left(current)) && tree.isInternal(tree.right(current))) {
            // Step 1 : Find next node in in-order traversal
            Position<T> next = tree.right(current);
            while (!tree.isExternal(next)) next = tree.left(next);

            // Step 2: copy the value of next into current
            T temp = tree.replace(current, tree.parent(next).element());

            // Step 3: remove next
            Position<T> position = tree.parent(tree.parent(next));
            tree.remove(tree.parent(next));
            rebalance(position);

            return temp;
        } else {
            return tree.remove(current);
        }
    }

    private void rebalance(Position<T> position) {
        // Check height-balance property
        int left = heights.get(tree.left(position));
        int right = heights.get(tree.right(position));

        if (Math.abs(left-right) > 1) {
            Position<T> z = position;
            Position<T> y;
            Position<T> x;
            Direction yz;
            Direction xy;

            // Start by working out your x, y, and z
            // While you do this, try to understand the relationship between the
            // three nodes
            if (heights.get(tree.left(z)) > heights.get(tree.right(z))) {
                y = tree.left(z);
                yz = Direction.LEFT;
            } else {
                y = tree.right(z);
                yz = Direction.RIGHT;
            }
            if (heights.get(tree.left(y)) > heights.get(tree.right(y))) {
                x = tree.left(y);
                xy = Direction.LEFT;
            } else {
                x = tree.right(y);
                xy = Direction.RIGHT;
            }

            // Now, use the information gleaned above to make the appropriate rotation
            if (xy == Direction.LEFT && yz == Direction.LEFT) {
                position = ((ProperLinkedAVLBinaryTree) tree).singleLeft(x, y, z);
            } else if (xy == Direction.RIGHT && yz == Direction.RIGHT) {
                position = ((ProperLinkedAVLBinaryTree) tree).singleRight(z, y, x);
            } else if (xy == Direction.LEFT && yz == Direction.RIGHT) {
                position = ((ProperLinkedAVLBinaryTree) tree).doubleLeftRight(z, x, y);
            } else { // Must be RIGHT/LEFT
                position = ((ProperLinkedAVLBinaryTree) tree).doubleRightLeft(y, x, z);
            }

            // Recalculate the heights of the children of the restructured tree.
            recalculateHeights(tree.left(position));
            recalculateHeights(tree.right(position));
        }

        // Recalculate the height of the new root and move towards the parent...
        if (recalculateHeights(position) && !tree.isRoot(position))
            rebalance(tree.parent(position));
    }

    private boolean recalculateHeights(Position<T> position) {
        int height = Math.max(heights.get(tree.left(position)), heights.get(tree.right(position)))+1;
        if (heights.get(position) == height) return false;
        heights.put(position, height);
        return true;
    }

    private void generateView(Position<T> position, StringBuffer buf, String offset) {
        buf.append(offset).append(position.element()).append(" [").append(heights.get(position)).append("]\n");
        if (tree.isExternal(position)) return;
        generateView(tree.left(position), buf, offset+"\t");
        generateView(tree.right(position), buf, offset+"\t");
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        generateView(tree.root(), buf, "");
        return buf.toString();
    }
}
