# [Queue](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/Java/Queue/Queue.java)

> A container of values / objects which does the insertion and removal of elements based on **First-In-First-Out (FIFO)** principle

* Insertion of elements can be done in any time while only the element that ***stays in the structure for the longest time*** can be removed
* 2 essential reference variables : **front** and **rear**
    * front : The reference where the next item to be *dequeued (removed)*
    * rear  : The reference where the last item was *enqueued (inserted)*

![Standard Queue](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/Images/Queue.jpg)

## Abstract Data Type :

ADT | Description
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
Runtime (For all *ADT*) | O(1) | O(1)
