# [Tree](https://github.com/GohEeEn/Data-Structures-and-Algorithms/tree/master/src/Tree.java)

> A hierarchical ADT that the elements (*node*) stored are related in terms of **parent-child relationship** 

* Each node in the tree has *at most 1 parent* and *0 or more children* 
* There is *exactly 1 node in every tree with no parent* called **root**, as the center of it 

![Tree](https://www.tutorialspoint.com/data_structures_algorithms/images/binary_tree.jpg)

### Terms definition in Tree :
Term | Description | Example 
--|--|--
Root (tree) | The only node which has no parent node, the start of this tree | A
Parent (c,..) | A node which has *one-level higher than a single/group of node(s)*, with a reference to it | Parent(D, E) = B
Children(p) | Node(s) which has *one-level lower than a specific node p (parent)*, with the reference the same parent node | Children(A) = (B, C)
Sibling(n) | Node(s) that *share the same parent* with given node n | Sibling(D) = E
Edge | Any *(parent, child)* pair in this tree | (C, F) 
*Internal* Node | Any node that has ***no children*** | F, G, H, I, J
*External* Node | Any node that has ***children*** | A, B, C, D, E
Ancestor (n) | Every *lower-level node (consecutive) that follow the path connected to the given node n* | Ancestor(I) = D, B, A
Descendent (n) | Every *higher-level node that follow the path connected to the given node n* | Descendent(B) = D, E, H, I, J
Path | Consecutive nodes in the same edge | (A, C, G), (B, E, J)
Depth(n) | The *number of ancestor of node n, excluding itself* (called **level** too, counting :arrow_up:) | Depth(B) = 1<br/>Depth(J) = 3
Degree(n) | The *number of children node* of node n | Degree(D) = 2<br/>  Degree(F) = 0
Height(T) | The *maximum depth to an external node* of tree T | Height = 3
Height(n) | The *maximum depth from given node n to an external node* (counting :arrow_down:)| Height(external) = 0<br/>Height(internal) = 1 + **max**(Height(child))

### Abstract Data type :
ADT | Definition
--|--
<span style="color:blue;">Position<T\></span> root() | Return the Position of root node in this tree
<span style="color:blue;">Position<T\></span> parent(<span style="color:blue">Position<T\></span> p) | Return the Position of **parent node** of given node p 
<span style="color:blue;">Position<T\></span> children(<span style="color:blue">Position<T\></span> p) | Return an **Iterator** that consists of all the *child nodes* of node p
<span style="color:blue;">boolean</span> isInternal(<span style="color:blue">Position<T\></span> p) | Return a boolean that indicates if the given node p has *at least 1 child node*
<span style="color:blue;">boolean</span> isExternal(<span style="color:blue">Position<T\></span> p) | Return a boolean that indicates if the given node p has *no child node*
<span style="color:blue;">boolean</span> isRoot(<span style="color:blue">Position<T\></span> p) | Return a boolean that indicates if the given node p is *root node*
<span style="color:blue;">Iterator<T\></span> iterator() | Return an *iterator that consists of all the element's value* in this tree
<span style="color:blue;">Iterator<Position<T\>\></span> positions() | Return an *iterator of all position of elements* in this tree
<span style="color:blue;">boolean</span> isEmpty() | Return a boolean that indicates if the tree is empty
<span style="color:blue;">int</span> size() | Return the number of elements in this tree
<span style="color:blue;">T</span> replace(<span style="color:blue">Position<T\></span> p, <span style="color:blue;">T</span> e) | Replace the value of node at position p with value e, and return the *replaced value*

## [Binary Tree](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/src/Tree/BinaryTree.java)

> A **binary tree** is a tree with following properties :
> * Each [node](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/src/Tree/TreeNode.java) has at most 2 children nodes
> * A parent node n has 2 references to their children nodes, which is either a *left-child* or *right-child* of node n
> * A *left-child is precedes to a right-child* in ordering of children node in a tree
> * ![tree node](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/img/tree_node.jpg)

* A binary tree is either empty or combines of :
    * A **root node** r, which is the center of any binary tree
    * A **left-subtree** L, which is a subtree of root node r on its left hand side
    * A **right-subtree** R, which is a subtree of root node r on its right hand side

* Level Properties : 
    * Level n of a binary tree is a set of elements with the *same depth n*, which has *at most **2<sup>n</sup>** of elements*

* There are *4 extra operations* in binary tree besides of tree ADT

### Abstract Data Type :

ADT | Description
--|--
<span style="color:blue;">Position<T\></span> left(<span style="color:blue;">Position<T\></span> p) | Return the position of *left-child* of the given parent node p 
<span style="color:blue;">Position<T\></span> right(<span style="color:blue;">Position<T\></span> p) | Return the position of *right-child* of the given parent node p 
<span style="color:blue;">boolean</span> hasLeft(<span style="color:blue;">Position<T\></span> p) | Return a boolean that indicates if there is a *left-child* of given node p 
<span style="color:blue;">boolean</span> hasRight(<span style="color:blue;">Position<T\></span> p) | Return a boolean that indicates if there is a *right-child* of given node p

* There are 3 different type of binary trees in total, which is [standard binary tree](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/src/Tree/StandardLinkedBinaryTree.java) , [proper binary tree](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/src/Tree/ProperLinkedBinaryTree.java) and complete binary tree

Base | [Standard](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/src/Tree/StandardLinkedBinaryTree.java) | [Proper](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/src/Tree/ProperLinkedBinaryTree.java) | Complete
--|--|--|--
Definition | Standard form of binary tree, which allows the insertion and removal of elements in single-element form | A binary tree which is built by expanding an *external node (0 child)* to an *internal node (2 child)*, in other word every node here has either *degree 0 or 2* | A binary tree which has *at least all level set filled, except the last level that has all the internal node(s) on the left hand side*, and *at most 1 node has only a left-child*
Insertion | Insert an *initialized single child node* in each operation | Insertion done by *expanding 2 empty node on both left and right child*, then value is assigned by using *replace()* operation | Insertion is done in single child node (left/right) and return an *external node as the last node reference for the next insertion point*
Removal | Node removal is done by giving the position of target node, return the removed node value, and replaced by its *only child* (return error if there are *2 children nodes*) if it is an *internal node* | Node removal of a proper binary tree has 2 cases : <br/> 1. Given node v has *1 internal child*, then v and its external child will be removed and the position is replaced by the internal child <br/> 2. Remove both external child and remain node v when there are <br/> 3. Else error will be returned | Remove the **last node** of tree (pointed by reference) and return its value
* Each removal methods mentioned above is to *maintain the defined tree structure* , regardless what value stored in removed node(s) , thus the users have to be caution to define the way of using them

Return to [main page](https://github.com/GohEeEn/Data-Structures-and-Algorithms)