# [Stack](https://github.com/GohEeEn/Data-Structures-and-Algorithms/tree/master/Java/Stack/Stack.java)

> A container of values / objects which do the insertion and removal of elements based on **Last-In-First-Out (LIFO)** principle

* Insertion of elements can be done in any time while only the ***most recent 'pushed' (added)*** element can be removed
* An essential reference variable : **top**

![Stack](https://proxy.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.studytonight.com%2Fdata-structures%2Fimages%2Fstack-data-structure.png&f=1)

### Abstract Data Type :
ADT  |   Description
--------------------|-----------------
<span style="color:blue;">void</span> push(<span style="color:blue;">Obj</span> obj) | Insert a new element (object) to the top of stack
<span style="color:blue;">Obj</span> pop() | Remove the top (most recently inserted) element from the stack, and return the value of it
<span style="color:blue;">Obj</span> top() | Return the value of top element in stack without removing it
<span style="color:blue;">int</span> size()| Return the size (total number of elements) of stack
<span style="color:blue;">bool</span> isEmpty()| Return the boolean value of if the given stack is empty

### Comparing Different Implementations :

Base | [Array-Based](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/Java/Stack/ArrayStack.java)    | [Linked-Based](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/Java/Stack/LinkedStack.java)
---------|---------------|--------------
Capacity | Finite   | Infinite
Storing Method | Hold the objects pushed into stack | Objects stored in special 'nodes' that link to the next object
Reference to ***top*** element | Stack size (-1 if empty) | Trace the reference of new inserted or removed [node](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/Java/Stack/Node.java) (element)
Runtime (*all ADT*) | O(1)  | O(1)

Return to [main page](https://github.com/GohEeEn/Data-Structures-and-Algorithms)