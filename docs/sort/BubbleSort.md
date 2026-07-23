# Bubble Sort

## Problem Link
- [GeeksforGeeks - Bubble Sort](https://www.geeksforgeeks.org/problems/bubble-sort/1)

## Solution Link
- [YouTube - takeUforward](https://www.youtube.com/watch?v=HGk_ypEuS24&t=1061s)
- [Blog - takeUforward](https://takeuforward.org/data-structure/bubble-sort-algorithm/)

## Approach

Bubble Sort repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The largest element "bubbles" to the end in each pass.

## Complexity
- **Time**: O(n²) worst/average, O(n) best (with early termination optimization)
- **Space**: O(1) in-place
- **Stable**: Yes

## Code

```java
package com.algo.sort;

public class BubbleSort {
    public static void main(String[] args) {
        type1();
    }

    private static void type1() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int n = arr.length;
        // Outer loop: number of passes
        for (int i = 0; i < n; i++)
            // Inner loop: compare adjacent elements
            // n-i-1 because last i elements are already sorted
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
        print(arr);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
```

## How It Works

```
Initial: [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]

Pass 0:  [9, 8, 7, 6, 5, 4, 3, 2, 1, 10]  (10 bubbled to end)
Pass 1:  [8, 7, 6, 5, 4, 3, 2, 1, 9, 10]  (9 bubbled to end)
...
Pass 8:  [2, 1, 3, 4, 5, 6, 7, 8, 9, 10]
Pass 9:  [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]  (Sorted!)
```
