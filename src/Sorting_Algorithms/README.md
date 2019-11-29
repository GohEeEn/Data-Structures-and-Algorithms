# Sorting Algorithms :

> Algorithms which is used to rearrange a list or series of data into certain order

## 1. Divide and Conquer :

> A general design paradigm which based on multi-branches recursion

* There are 3 processes in a divide-and-conquer implementation strategy :

    Process | Description
    --|--
    Divide       | A process that divides the input data S into *2 disjoint subsets S<sub>1</sub> and S<sub>2</sub>*
    Recur       | A process that solve the *subproblem* (minimized problem which is similar to the main problem) associated with S<sub>1</sub> and S<sub>2</sub> 
    Conquer    | A process that *rejoin the recurred subsets  S<sub>1</sub> and S<sub>2</sub> back into a solution for S*

    ### 1. [Merge Sort](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/src/Sorting_Algorithms/MergeSort.java)
    
    > A *comparison* divide-and-conquer sorting algorithm, that divides an input sequence into halves and merge them after sorting

    Assume an input sequence S with n elements :
    Process | Description | Runtime 
    --|--|--
    Divide  | Partition an input sequence into *2 halved subset subsets S<sub>1</sub> and S<sub>2</sub>*, which has n/2 elements each | O(n)
    Recur   | Recursively sort the elements in subsets S<sub>1</sub> and S<sub>2</sub> | O(log n)
    Conquer | Merge the sorted subsets S<sub>1</sub> and S<sub>2</sub> to form a unique sorted sequence <br> Or insert all the data in both subsets into S while foinf comparisons | O(n)

    ```
        Algorithm mergeSort(S, C){

            // S - A sequence of data in any type
            // C - A defined Comparator to sort the data in given sequence S

            if S.size > 1 
                
                // Step 1 : Divide the given sequence S into halves, until size of given sequence S < 1 
                // 1 element is not able to do comparison
                (S1, S2) <- Partition(S, n/2) 

                // Step 2 : Recursively sort the given partitioned sequence
                S1 <- mergeSort(S1, C)
                S2 <- mergeSort(S2, C)

                // Step 3 : Sort and merge subsets S1 and S2 in certain order defined by comparator 
                S <- merge(C, S1, S2)

            return S
        }
    ```
    ### Analysis of Merge Sort :
    * The height h of the merge-sort tree is O(log n), since the *sequence is divided into halves at each recursive call*
    * The overall amount of work done at the nodes of *depth i is O(n)*
        * Partition and merge 2<sup>i</sup> sequences of size n/2<sup>i</sup> 
        * 2<sup>i+1</sup> recursive calls are made
    * Thus, the total ***running time of merge-sort is O(n log n)***

    ## 2. [Quick Sort](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/src/Sorting_Algorithms/QuickSort.java)

    > A *comparison* randomized sorting algorithm that based on divide-and-conquer

    Assume a random sequence S with n elements :
    Process | Description | Runtime
    --|--|--
    Divide  | Pick a random element (pivot) x from the sequence S and divides the sequence into 3 partitions :<br>a. Partition L which contains elements that have value **less than x**<br>b. Partition E which contains elements that have the **same value as x**<br>c. Partition G which contains elements that have the **greater value than x** | O(n)
    Recur | Recursively sorting partition L and G
    Conquer | Rejoin the partition L, E and G, that produces a sorted solution

    ```
        Algorithm quickSort(S){

            // S - a random sequence of elements 
            L, E, G <- 3 empty lists to store different category of elements

            // Randomly pick a pivot value from S
            x <- S.remove(rand)
            i <- 0 
            
            // Step 1 : Divide sequence S into 3 partitions, O(n) = O(1) * n
            while S is not empty
                y <- S.remove(i)                // Removal   : O(1)
                if y < x then L.add(y)          // Insertion : O(1)
                else if y > x then G.add(y)
                else E.add(y)
            
            // Step 2 : Recur
            L <- quickSort(L)
            G <- quickSOrt(G)

            // Step 3 : Conquer
            S <- join(L, S, G)

            return S
        }
    ```
 
    ### Analysis of Quick Sort
    * Worst Case : When the pivot is the unique *minimum or maximum of elements*
        * Hence L or G has *size n-1 (excluding pivot)* and the other partition has size 0
        * Space Complexity : O(n), as n-1 max size per partition 
        * Time Complexity  : O(n), since size n-1, recursive call should be n-1 times too
        * Worst-case Runtime : ***O(n<sup>2</sup>)***


## 2. Ranged Partition 

> Similar to Divide-and-Conquer while no recur process and non-comparative sorting  paradigm

### [Bucket Sort](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/src/Sorting_Algorithms/RadixSort.java)

> A stable sorting algorithm that create buckets which individually responsible for an equal portion range of keys in sequence. 
><br> *Useful when the sequence elements is in certain range*

Assume a sequence S with n elements which they are in a certain range that can be partitioned into m type
Process | Description | Runtime
--|--|--
1.| Set up m buckets where each bucket is responsible for an equal portion of range key in S | O(1)
2.| Place each element in appropriate bucket | O(n)
3.| Sort items in each non-empty bucket using insertion sort | O(n<sup>2</sup>)
4.| Concatenate sorted lists of items from buckets to get the final sorted solution

```
    Algorithm bucketSort(S){
        n <- S.length
        
        // Step 1, O(1)
        bucket <- [m] // Individual range of data

        // Step 2, O(n)
        for i <- 1 to n
            do insert S[i] into list bucket[n*S[i]]

        // Step 3, O(n*n/m)
        for i <- 0 to m
            do insertion sort on list bucket[i]

        // Step 4, O(m)
        Concatenate bucket[0], ..., bucket[m] together in order
    }
```

Analysis of Bucket Sort :
* Buckets are created based on **range of elements** in the sequence -> O(1)
* Each element is placed in its corresponding bucket -> *O(n)*
* Insertion sort on a list -> O(n<sup>2</sup>) , while m buckets -> *O(n<sup>2</sup>/m)*
* Concatenate sorted lists takes a linear time -> *O(m)*
* Thus runtime -> ***O(n + n<sup>2</sup>/m + m)***

### [Radix Sort](https://github.com/GohEeEn/Data-Structures-and-Algorithms/blob/master/src/Sorting_Algorithms/RadixSort.java)

> A multiple pass distribution sorting algorithm, which contains a stable sorting algorithm (bucket sort here)

* It *distributes each item to a bucket* according to part of the item's key
* Items are collected from the buckets, keeping items in order, then resdistributed according to the *next most significant part of the key*
* For numbers, it sorts keys digit-by-digit, for strings character-by-character

```
    Algorithm radixSort(S, d){
        
        for i <- 1 to d
            do stable sort to sort sequence S on component i on significant key
            (For number - digit i, for string - char i)
    }
```
Analysis of Radix Sort 
* Runtime : ***O(d(n+k))***, where :
    * n, number of elements that need to be sorted
    * k, number of buckets can be generated
    * d, length of keys
* Radix sort is efficient when there is a *large number of records with short length of keys*

Pros and Cons of (2) :
* Advantages 
    * Stable sorting algorithm, preserving existing order of equal key
    * Linear runtime, unlike traditional sort algorithms, they are not slowing down when the are large number of items to sort
* Disadvantages
    * Not efficient when the *key length is long*, as the total runtime is proportional to key length and number of items to be sorted
    * Space consuming, which uses more working space than traditional sorting algorithm