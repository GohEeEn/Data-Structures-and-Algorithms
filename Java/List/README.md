# [List](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/Java/List/List.java)

> A structure that supports the insertion and removal of objects based on their **position** (reference)

* Insertion is carried out relative to a position or a known fixed point
* Example, insert ***Chelsea*** before the position where ***Liverpool*** is stored *or* after the position of ***Stockport***.
![List Example](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/img/List_1.jpg)
* It requires 2 position references at the **first and last position** for list traversal purpose

### Abstract Data Type :
ADT | Description
--|--
<span style="color:blue;">T</span> replace(<span style="color:blue;">Position<T\></span> p, <span style="color:blue;"></span> e) | Replace the element at position p in this list with value e, and return the *element formerly stored at position p*
<span style="color:blue;">Position<T\></span> insertFirst(<span style="color:blue;">T</span> e) | Insert a new element e at the **front of this list** and *return its position*
<span style="color:blue;">Position<T\></span> insertLast(<span style="color:blue;">T</span> e) | Insert a new element with value e at the **end of this list**, and *return its position*
<span style="color:blue;">Position<T\></span> insertBefore(<span style="color:blue;">Position\<T\></span> p, <span style="color:blue;">T</span> e) | Insert a new element e into this list **before position p** and *return its position*
<span style="color:blue;">T</span> insertAfter(<span style="color:blue;">Position\<T\></span> p, <span style="color:blue;">T</span> e) | Insert a new element e into this list **after position p** and *return its position*
<span style="color:blue;">T</span> remove(<span style="color:blue;">Position\<T\></span> p) | Remove the element at given position and return the original value
<span style="color:blue;">boolean</span> isEmpty() | Return a boolean value that indicates *if this list is empty*
<span style="color:blue;">int</span> size() | Return the *number of elements* in this list

### Traverse in List :
Function | Description
--|--
<span style="color:blue;">Position<T\></span> first() | Return the reference to the **first position** in this list
<span style="color:blue;">Position<T\></span> last() | Return the reference to the **last position** in this list
<span style="color:blue;">Position<T\></span> prev(<span style="color:blue;">Position<T\></span> p) | Return the reference to the **previous position** of position p in this list, **null** if it is the first element 
<span style="color:blue;">Position<T\></span> next(<span style="color:blue;">Position<T\></span> p) | Return the reference to the **next position** of position p in this list, **null** if it is the last element

### Comparing different implementations :
Base | Array-Based | [Link-Based](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/Java/List/LinkedList.java)
--|--|--
Storing objects | Stored in an *array of positions* with indexes included | Nodes are the *positions*
Reference elements | By *array index* | Traverse through the list starts with the auxiliary node reference **front** and **rear** nodes (Doubly Linked List)

