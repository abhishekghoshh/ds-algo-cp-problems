# Selection Sort

## Problem Link
- [GeeksforGeeks - Selection Sort](https://www.geeksforgeeks.org/problems/selection-sort/1)

## Solution Link
- [YouTube - takeUforward](https://www.youtube.com/watch?v=HGk_ypEuS24)
- [Blog - takeUforward](https://takeuforward.org/sorting/selection-sort-algorithm/)

## Approach

The inner loop selects the minimum element in the unsorted array and places it at the beginning. Each pass finds the smallest remaining element and swaps it into position.

## Complexity
- **Time**: O(n²) in all cases
- **Space**: O(1) in-place
- **Stable**: No (swapping can change relative order)

## Code

```java
package com.algo.sort;

public class SelectionSort {
    public static void main(String[] args) {
        type1();
    }

    // The inner loop selects the minimum element in the unsorted array
    private static void type1() {
        int[] arr = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            // Find the minimum element in the unsorted array
            // and swap it with the element at the beginning
            for (int j = i + 1; j < n; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            // if minIndex is not i then we need to swap
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
        print(arr);
    }
}
```

## How It Works

```
Initial: [13, 46, 24, 52, 20, 9]

Pass 0:  Find min=9 at index 5, swap with index 0 → [9, 46, 24, 52, 20, 13]
Pass 1:  Find min=13 at index 5, swap with index 1 → [9, 13, 24, 52, 20, 46]
Pass 2:  Find min=20 at index 4, swap with index 2 → [9, 13, 20, 52, 24, 46]
Pass 3:  Find min=24 at index 4, swap with index 3 → [9, 13, 20, 24, 52, 46]
Pass 4:  Find min=46 at index 5, swap with index 4 → [9, 13, 20, 24, 46, 52]
Pass 5:  Last element already in place → [9, 13, 20, 24, 46, 52]
```
