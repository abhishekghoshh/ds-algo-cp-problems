# Insertion Sort

## Problem Link
- [GeeksforGeeks - Insertion Sort](https://practice.geeksforgeeks.org/problems/insertion-sort/1)

## Solution Link
- [YouTube - takeUforward](https://www.youtube.com/watch?v=HGk_ypEuS24&t=1900s)
- [Blog - takeUforward](https://takeuforward.org/data-structure/insertion-sort-algorithm/)

## Approach

Build the sorted portion from the left. For each element, shift larger elements to the right and insert the current element in its correct position. Analogous to sorting playing cards in your hand.

## Complexity
- **Time**: O(n²) worst/average, O(n) best (already sorted)
- **Space**: O(1) in-place
- **Stable**: Yes

## Code

```java
package com.algo.sort;

public class InsertionSort {
    public static void main(String[] args) {
        type1();
    }

    private static void type1() {
        int[] arr = {24, 18, 38, 43, 14, 40, 1, 54};
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int pivot = arr[i];  // element to insert
            int j = i;
            // Shift larger elements to the right
            while (j > 0 && pivot < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = pivot;  // insert at correct position
        }
        print(arr);
    }
}
```

## How It Works

```
Initial: [24, 18, 38, 43, 14, 40, 1, 54]

i=1: pivot=18, shift 24 → [18, 24, 38, 43, 14, 40, 1, 54]
i=2: pivot=38, no shift    → [18, 24, 38, 43, 14, 40, 1, 54]
i=3: pivot=43, no shift    → [18, 24, 38, 43, 14, 40, 1, 54]
i=4: pivot=14, shift 43,38,24,18 → [14, 18, 24, 38, 43, 40, 1, 54]
i=5: pivot=40, shift 43    → [14, 18, 24, 38, 40, 43, 1, 54]
i=6: pivot=1,  shift all   → [1, 14, 18, 24, 38, 40, 43, 54]
i=7: pivot=54, no shift    → [1, 14, 18, 24, 38, 40, 43, 54]
```

## Key Insight

Best for nearly sorted data and small arrays. Used as a subroutine in Hybrid sorts (Timsort, Introsort) because of its O(n) best case and low overhead.
