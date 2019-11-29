# Pattern Matching Algorithms

## 1. Brute-Force Matching Algorithm

> A pattern-searching algorithm that compares a pattern P with length m and a text T with length n (n >= m), with each possible shift in text T until either :
> * A match of P is found in T, or
> * All posible shift have been tried while pattern P not found

```
    Algorithm BruteForceMatch(P, T){

        i <- 0 , counter for char index for T

        // Search for character(s) match in T, O(n)
        while i <- n-m
            do
                j <- 0, counter for pattern characters match

                // When pattern char matches, O(m)
                while T[i+j] = P[j] and j < m do
                    j <- j + 1

                if j = m return i, pattern found at index i -> j

        // Runtime -> O(nm)
        return -1 , which means pattern P not found 
    }
```