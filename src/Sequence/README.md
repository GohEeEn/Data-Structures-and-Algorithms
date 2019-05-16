# [Sequence](https://github.com/GohEeEn/Data-Structures-and-Algorithms/tree/master/Java/Sequence/Sequence.java)

> A combination of data structures Vector and List, which combines the *rank* and *position* based approaches for insertion and removal of objects

* A sequence structure supports all the ADT included in both vector and list, and with *2 extra operations*

### Abstract Data Type 
ADT | Description
--|--
<span style="color:blue;">Position<T\></span> atRank(<span style="color:blue;">int</span> rank) | Returns the position at given *rank*
<span style="color:blue;">int</span> rankOf(<span style="color:blue;">Position<T\></span> p) | Returns the rank of given *object position p* 


```Java
    public static interface Sequence<T> extends Vector<T>, List<T>{
        public Position<T> atRank(int rank);
        public int rankOf(Position<T> p);
    }
```

## [Iterator](https://github.com/GohEeEn/Data-Structures-and-Algorithms/tree/master/Java/Sequence/Iterator.java)

> An ADT that encapsulates the *traversal through each element for both accessing or/and modifying* in a given sequence (including vector and list)

* It requires 2 variables :
    1. A **reference to the current position** in the sequence
    2. The **sequence itself**

    ```java
        public Position<T> current;     // 1
        public Sequence<T> sequence;    // 2
    ```

### Abstract Data Type 
ADT | Description
--|--
<span style="color:blue;">boolean</span> hasNext() | Returns a boolean that indicates if there is *next element from current position*
<span style="color:blue;">T</span> next() | Access to the next position from the current position and *return its stored value*

### Difference between Iterator and Iterable :

Base | Iterable | Iterator
--|--|--
Definition | A simple representation that indicates a structure / a series of objects can be *iterated over* | An object that defines how the iteration works on the given structure
Difference | No iteration state (example, current element), while having a function to produce an iterator | It allows the access and modification on each iteration state, which lets you check if there is more element at next (hasNext()) and move to the next element (next(), if there is one)
Interface | ```private Iterator<T> itr; ``` | ``` private boolean hasNext(); private T next(); ```
> Typically, an iterable object can defines any number of iterator objects


Return to [main page](https://github.com/GohEeEn/Data-Structures-and-Algorithms)