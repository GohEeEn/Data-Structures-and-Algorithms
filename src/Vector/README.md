
# [Vector](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/src/Vector/Vector.java)

> It is a sequence ADT that supports the insertion, removal and accessing of objects based on **rank**

* Rank : The rank of an object e is an **integer** value that specifies the *number of objects that come before e* in vector
* It is pretty similar to arrays, while vector has **no fixed capacity** and **object ranks are changed according to the insertion and removal of elements**

### Abstract Data Type
ADT | Description
--|--
<span style="color:blue;">Obj</span> elemAtRank(<span style="color:blue;">int</span> r) | Return the value of object with integer rank r, or an error occurs if the vector is either *empty or out of rank*
<span style="color:blue;">Obj</span> replaceAtRank(<span style="color:blue;">int</span> r, <span style="color:blue;">Obj</span> e) | Replace the object at rank r with new obj value e and return the Obj value of replaced element, or an error condition occurs if the vector is *empty or out of rank*
<span style="color:blue;">void</span> insertAtRank(<span style="color:blue;">int</span> r, <span style="color:blue;">Obj</span> e) | Insert an object e into the vector with rank r, or an error condition occurred if the vector is *empty or out of rank*  
<span style="color:blue;">Obj</span> removeAtRank(<span style="color:blue;">int</span> r | Remove the object at rank r and return that object's value, or an error condition occurs if the vector is *empty or out of rank*
<span style="color:blue;">boolean</span> isEmpty() | Return true if the vector is empty, else false
<span style="color:blue;">int</span> size() | Return the number of elements in the given vector

### Comparing Different Implementations :
Base | [Array-Based](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/src/Vector/ArrayVector.java) | [Linked-Based](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/src/Vector/LinkedVector.java)
--|--|--
 Storing Method | In array and referenced with the object index corresponding to the rank | In two-way linked *nodes*
Capacity | Finite (Unless using **expendable** array) | Infinite
Elements order | By *array index* | Link to the *previous* and *next* objects in Vector, thus need auxiliary references for *front* and *rear* nodes
Element Access Speed | Instant by using *array index* | Traverse through list needed, relatively slower (**O(n/2) time complexity in minimum**)
### ADT Runtime :
Runtime  | [Array-Based](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/src/Vector/ArrayVector.java) | [Linked-Based](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/src/Vector/LinkedVector.java)
--|--|--
<span style="color:blue;">Obj</span> elemAtRank(<span style="color:blue;">int</span> r) | O(1) | O(n) [Traverse]
<span style="color:blue;">Obj</span> replaceAtRank(<span style="color:blue;">int</span> r, <span style="color:blue;">Obj</span> e) | O(1) | O(n) [Traverse]
<span style="color:blue;">void</span> insertAtRank(<span style="color:blue;">int</span> r, <span style="color:blue;">Obj</span> e) | O(n) [Shift] | O(n) [Traverse]
<span style="color:blue;">Obj</span> removeAtRank(<span style="color:blue;">int</span> r | O(n) [Shift] | O(n) [Traverse]
<span style="color:blue;">boolean</span> isEmpty() | O(1) | O(1)
<span style="color:blue;">int</span> size() | O(1) | O(1)

Return to [main page](https://github.com/GohEeEn/Data-Structures-and-Algorithms)