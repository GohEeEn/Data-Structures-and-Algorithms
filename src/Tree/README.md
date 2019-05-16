# [Tree](https://github.com/GohEeEn/Data-Structures-and-Algorithms/tree/master/Java/Tree.java)

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





