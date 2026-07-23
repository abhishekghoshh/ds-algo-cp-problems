# Heap Sort

## Problem Link
- [GeeksforGeeks - Heap Sort](https://practice.geeksforgeeks.org/problems/heap-sort/1)

## Solution Link
- [GeeksforGeeks](https://www.geeksforgeeks.org/heap-sort/)

## Approach

Uses a MinHeap data structure. Insert all elements into the heap, then extract them one by one in sorted order.

## Complexity
- **Time**: O(n log n)
- **Space**: O(n) for the heap (can be O(1) if done in-place with max-heap)
- **Not Stable**

## Code

```java
package com.algo.sort;

public class HeapSort {
    public static void main(String[] args) {
        type1();
    }

    private static void type1() {
        int[] arr = {10, 9, 8, 7, 2, 5, 1, -1};
        MinHeap minHeap = new MinHeap(arr);
        // Extract minimum elements one by one
        for (int i = 0; i < arr.length; i++)
            arr[i++] = minHeap.extractMin();
        print(arr);
    }
}
```

## How It Works

```
Initial array: [10, 9, 8, 7, 2, 5, 1, -1]

Step 1: Build min heap from array → [-1, 2, 1, 7, 9, 5, 8, 10]
Step 2: Repeatedly extract min → -1, 1, 2, 5, 7, 8, 9, 10
```

## Note

This implementation uses a separate `MinHeap` data structure from `com.ds.heap.MinHeap`. In-place heap sort would build a max-heap directly in the array and swap the root (max) with the last element repeatedly.
