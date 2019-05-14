
# Data-Structures-and-Algorithms

Implementation of common data structures and algorithms in Java

## Data Structures

### 1. [Stack](https://github.com/GohEeEn/Data-Structures-and-Algorithms/tree/master/Java/Stack)

> A container of values / objects which do the insertion and removal of elements based on **Last-In-First-Out (LIFO)** principle

* Insertion of elements can be done in any time while only the ***most recent 'pushed' (added)*** element can be removed
* An essential reference variable : **top**

![Stack](https://proxy.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.studytonight.com%2Fdata-structures%2Fimages%2Fstack-data-structure.png&f=1)

Abstract Data Type (ADT)  |   Description
--------------------|-----------------
<span style="color:blue;">void</span> push(<span style="color:blue;">Obj</span> obj) | Insert a new element (object) to the top of stack
<span style="color:blue;">Obj</span> pop() | Remove the top (most recently inserted) element from the stack, and return the value of it
<span style="color:blue;">Obj</span> top() | Return the value of top element in stack without removing it
<span style="color:blue;">int</span> size()| Return the size (total number of elements) of stack
<span style="color:blue;">bool</span> isEmpty()| Return the boolean value of if the given stack is empty

#### Comparing Different Implementations :

Base | [Array-Based](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/Java/Stack/ArrayStack.java)    | [Linked-Based](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/Java/Stack/LinkedStack.java)
---------|---------------|--------------
Capacity | Finite   | Infinite
Storing Method | Hold the objects pushed into stack | Objects stored in special 'nodes' that link to the next object
Reference to ***top*** element | Stack size (-1 if empty) | Trace the reference of new inserted or removed [node](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/Java/Stack/Node.java) (element)
Runtime | O(1)  | O(1)

### 2. [Queue](https://github.com/GohEeEn/Data-Structures-and-Algorithms/tree/master/Java/Queue)

> A container of values / objects which does the insertion and removal of elements based on **First-In-First-Out (FIFO)** principle

* Insertion of elements can be done in any time while only the element that ***stays in the structure for the longest time*** can be removed
* 2 essential reference variables : **front** and **rear**
    * front : The reference where the next item to be *dequeued (removed)*
    * rear  : The reference where the last item was *enqueued (inserted)*

![Standard Queue](/Images/Queue.jpg)

Abstract Data Type (ADT) | Description
---|---
<span style="color:blue;">void</span> enqueue(<span style="color:blue;">Obj</span> obj) | Insert objects obj onto the rear of queue
<span style="color:blue;">Obj</span> dequeue() |Removes the object at the front of the queue and return the value of it
<span style="color:blue;">Obj</span> front() | Return the front object in the queue without removing it
<span style="color:blue;">int</span> size() | Return the size (total number of elements) of given stack
<span style="color:blue;">boolean</span> isEmpty() | Return a boolean indicating if the queue is empty

#### Comparing different implementaion :

Base | [Array-Based](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/Java/Queue/ArrayQueue.java) | [Linked-Based](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/Java/Queue/LinkedListQueue.java)
--|--|--
Capacity | Finite | Infinite
Elements Order | Insertion begins at index *0* , while requires auxiliary values to keep track the index of *front* and *rear* of queue | Nodes maintain the ordering information, while it also need auxiliary references for *front* and *rear* nodes
Runtime | O(1) | O(1)

