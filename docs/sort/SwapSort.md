# Swap Sort / Cycle Sort

## Problem Link
- (No problem link in source — utility/pattern file)

## Approach

Swap sort (a variant of cycle sort) works when the array contains numbers from 1 to n (possibly with duplicates or missing numbers). Each element is placed at its correct index position `arr[i] == i+1` by continuously swapping misplaced elements.

## Complexity
- **Time**: O(n) — each element is swapped at most once to its correct position
- **Space**: O(1) in-place
- **Not a comparison sort** — relies on value-to-index mapping

## Code

```java
package com.algo.sort;

public class SwapSort {
    public static void main(String[] args) {
        type1();
    }

    private static void type1() {
        int[] nums = {7, 3, 9, 4, 8, 5, 1, 6, 2};
        int n = nums.length;
        int i = 0;
        while (i < n) {
            // if element is already at correct position (i+1), move on
            if (nums[i] == i + 1) {
                i++;
            } else {
                // place arr[i] at its actual position (item-1)
                int item = nums[i];
                swap(nums, i, item - 1);
            }
        }
        print(nums);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
```

## How It Works

```
Initial: [7, 3, 9, 4, 8, 5, 1, 6, 2]

i=0: 7 should be at index 6 → swap(0,6): [1, 3, 9, 4, 8, 5, 7, 6, 2]
     now arr[0]=1, correct → i++

i=1: 3 should be at index 2 → swap(1,2): [1, 9, 3, 4, 8, 5, 7, 6, 2]
     9 should be at index 8 → swap(1,8): [1, 2, 3, 4, 8, 5, 7, 6, 9]
     now arr[1]=2, correct → i++

Continue until sorted: [1, 2, 3, 4, 5, 6, 7, 8, 9]
```

## Applications

Swap sort is commonly used in problems where the array contains numbers from 1 to n:
- Find the Duplicate Number
- Find All Duplicates in an Array
- Find the Missing Number
- First Missing Positive
- Find Repeating and Missing Numbers
