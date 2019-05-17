# [Binary Search Tree](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/src/BinarySearchTree/BinarySearchTree.java)

> A binary tree which has following properties :
> * Each node stores a unique value
> * A total-order relation is defined as below (let k<sub>i</sub> be any node value in BST) :
>   * Reflexive : k ~ k
>   * Antisymmetric : If *k<sub>i</sub> ~ k<sub>j</sub> and k<sub>j</sub> ~ k<sub>i</sub>*, then *k<sub>i</sub> = k<sub>j</sub>*
>   * Transitivity : If *k<sub>i</sub> ~ k<sub>j</sub> and k<sub>j</sub> ~ k<sub>k</sub>*, then *k<sub>i</sub> ~ k<sub>k</sub>*
> * Let any *parent node v* and *2 children nodes vl (left-child) and vr (right-child)* , the relationship among them is defined as ***vl ~ v ~ vr***
>   * Example : *left-child <= parent <= right-child* for integer value

### Abstract Data Type :

ADT | Description
--|--
<font color="blue">T</font> insert(<font color="blue">T</font> e) | Insert a new node with value e to the position that follow the total-order relation rules 
<font color="blue">Position<T\></font> find(<font color="blue">T</font> e) | Find the position of specific node with value e stored in the tree
<font color="blue">T</font> remove(<font color="blue">T</font> e) | Remove the specific node with value e in the tree

### Operations Algorithm [[Proper/Full Binary Tree](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/src/Tree/ProperLinkedBinaryTree.java)]
1. <font color="blue">Position<T\></font> find(<font color="blue">T</font> e)
    ``` 
        Algorithm find(T k, Position<T> v){
            
            // k - target node value
            // v - position to start searching

            if v is an external node 
                return v (should be null, however v to find the appropriate external node for new insertion as parent node)
            
            else if v.element < k 
                return find(k, v.left) (smaller value always stored in left-child in BST)

            else if v.element > k
                return find(k, v.right) (larger value always stored in right-child in BST)

            else if v.element = k
                return v (Target node found)
        }
    ```

2. <font color="blue">Position<T\></font> insert(<font color="blue">T</font> e)

    ```
        Algorithm insert(T k){

            // k - value to be stored in new node
            // Step 1 : Find the appropriate external node to do insertion
            p <- find(k, root())

            // Step 2 : Check if the position found is external
            // In proper binary tree external nodes are uninitialized, 
            // which equivalent as an empty node
            if p is an external node 
                
                expand empty children-nodes at node p (degree(p) 0 -> 2, internal node p)
                replace value of node p (null -> k)

                // Increment size of tree only if a new node created
                // Or a node with value k is found
                size <- size + 1    

            return p
        }
    ```

3. <font color="blue">Position<T\></T></font> remove(<font color="blue">T</font> e)
    ```
        Algorithm remove(T k){

            // k - value of the target node
            // Step 1 : Find the target node
            p <- find(k, root())

            // Step 2 : Check the parent-child relationship of target node
            // Case 1 : If it is an external node -> Simply remove the reference from parent node
            if p is external node
                if p is its parent's left-child
                        p.parent.left <- null
                if p is its parent's right-child
                        p.parent.right <- null
            
            // Case 2 : If the target node has 2 internal children
            // Recursively to find the appropriate value in its external descendant to replace the value
            else if p.left and p.right != null

                // The target external descendant should be larger than new left-child and smaller than new right-child

                // Step 2.1 : Find the approapriate external descendent
                // Larger than new left-child 
                // -> Start searching from p's right-child's
                r <- p.right

                // Smaller than new right-child 
                // -> Find the external left-descendant of r
                while !r.isExternal do r <- r.left

                // Step 2.2 : Copy the value of r and replace the target node (removed)
                p.element <- r.element

                // Step 2.3 : Remove r
                r.parent.left <- null

            // Case 3 : If there is only one internal node 
            // -> Reference parent to child of removed node (in same side)
            else if p.left != null
                p.parent.left <- p.left
                p.left.parent <- p.parent

            else if p.right != null
                p.parent.right <- p.right
                p.right.parent <- p.parent 
        }
    ```

Return to [main page](https://github.com/GohEeEn/Data-Structures-and-Algorithms)