# Recursive Bubble Sort

## Problem Link
- [GeeksforGeeks - Bubble Sort](https://www.geeksforgeeks.org/problems/bubble-sort/1)

## Solution Link
- [Blog - takeUforward](https://takeuforward.org/arrays/recursive-bubble-sort-algorithm/)
- [Blog - GeeksforGeeks](https://www.geeksforgeeks.org/recursive-bubble-sort/)

## Approach

Recursive implementation of bubble sort. Base case: array of size 1 (n==0). Each recursive call bubbles the largest element of the current subarray to the end, then recurses on the remaining n-1 elements.

## Complexity
- **Time**: O(n²)
- **Space**: O(n) recursion stack
- **Stable**: Yes

## Code

```java
package com.algo.sort;

public class RecursiveBubbleSort {
    public static void main(String[] args) {
        type1();
    }

    private static void type1() {
        int[] arr = {2, 5, 7, 5, 9, 15, 13, 2, 7, 8};
        bubbleSort(arr, arr.length);
        print(arr);
    }

    private static void bubbleSort(int[] arr, int n) {
        if (n == 0) return;  // base case
        // iteratively place the highest element in last place
        for (int i = 0; i < n - 1; i++)
            if (arr[i] > arr[i + 1])
                swap(arr, i, i + 1);
        bubbleSort(arr, n - 1);  // recurse on remaining
    }
}
```

## Key Difference from Iterative

The iterative version uses two nested loops. The recursive version replaces the outer loop with recursion. Each level of recursion corresponds to one pass of the outer loop.
