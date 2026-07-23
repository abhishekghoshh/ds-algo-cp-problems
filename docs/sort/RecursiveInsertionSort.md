# Recursive Insertion Sort

## Problem Link
- [GeeksforGeeks - Insertion Sort](https://www.geeksforgeeks.org/problems/insertion-sort/1)

## Solution Link
- [Blog - takeUforward](https://takeuforward.org/arrays/recursive-insertion-sort-algorithm/)

## Approach

Two methods work together:
1. `insertionSort(arr, n)` — iterates through the array, calling `insert()` for each element
2. `insert(arr, i)` — inserts the i-th element into its correct position in the sorted prefix [0..i-1]

## Complexity
- **Time**: O(n²)
- **Space**: O(1) + recursion stack for `insert()` if implemented recursively
- **Stable**: Yes

## Code

```java
package com.algo.sort;

public class RecursiveInsertionSort {
    public static void main(String[] args) {
        type1();
    }

    private static void type1() {
        int[] arr = {24, 18, 38, 43, 14, 40, 1, 54};
        insertionSort(arr, arr.length);
        PrintUtl.print(arr);
    }

    // insert all the elements one by one
    static void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++)
            insert(arr, i);
    }

    // it will insert the ith element in the sorted list
    static void insert(int[] arr, int i) {
        int pivot = arr[i];  // element to insert
        int j = i;
        // shift larger elements right until correct position found
        while (j > 0 && pivot < arr[j - 1]) {
            arr[j] = arr[j - 1];
            j--;
        }
        arr[j] = pivot;  // place element
    }
}
```

## Design Note

This implementation uses an iterative `insert()` even though the class is named "RecursiveInsertionSort". A truly recursive version would make `insert()` recursive: either insert at head or recurse deeper.
