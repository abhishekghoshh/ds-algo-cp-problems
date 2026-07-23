# Merge Sort

## Problem Link
- [LeetCode - Sort an Array](https://leetcode.com/problems/sort-an-array/)
- [GeeksforGeeks - Merge Sort](https://www.geeksforgeeks.org/problems/merge-sort/1)

## Solution Link
- [YouTube](https://www.youtube.com/watch?v=ogjf7ORKfd8)
- [Blog - takeUforward](https://takeuforward.org/data-structure/merge-sort-algorithm/)
- [Blog - GeeksforGeeks](https://www.geeksforgeeks.org/merge-sort/)

## Approaches

### Type 1: Recursive Merge Sort (Standard)

**Complexity:** Time O(n log n), Space O(n)

The classic divide-and-conquer approach. Split array into halves, recursively sort each half, then merge the two sorted halves.

```java
private static void type1() {
    int[] arr = {2, 5, 7, 5, 9, 15, 13, 2, 7, 8};
    mergeSort(arr, 0, arr.length - 1);
    print(arr);
}

static void mergeSort(int[] nums, int low, int high) {
    if (low < high) {
        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid);        // sort left half
        mergeSort(nums, mid + 1, high);   // sort right half
        merge(nums, low, mid, high);      // merge sorted halves
    }
}

static void merge(int[] nums, int low, int mid, int high) {
    int n = high - low + 1;
    int[] copy = new int[n];
    int left = low;
    int right = mid + 1;
    int i = 0;
    // merge two sorted arrays into copy array
    while (left <= mid && right <= high) {
        if (nums[left] < nums[right])
            copy[i++] = nums[left++];
        else
            copy[i++] = nums[right++];
    }
    // if anything remains in the left array
    while (left <= mid) copy[i++] = nums[left++];
    // if anything remains in the right array
    while (right <= high) copy[i++] = nums[right++];
    // copy back to original array
    for (i = 0; i < n; i++) nums[low + i] = copy[i];
}
```

### Type 2: Stack-Based Iterative Merge Sort

**Note:** `// todo not for interview just for fun` — Experimental implementation using two stacks to simulate the recursion tree. Mimics the call stack behavior.

```java
private static void type2() {
    int[] arr = {9, 7, 5, 3, 15, 13, 2, 8, 1};
    int n = arr.length;

    Stack<Pair> unsorted = new Stack<>();
    Stack<Pair> sorted = new Stack<>();
    unsorted.push(new Pair(0, n - 1, 0));

    while (!unsorted.isEmpty()) {
        // Push subarrays onto unsorted stack (like recursion calls)
        while (unsorted.peek().start < unsorted.peek().end) {
            Pair pair = unsorted.pop();
            int mid = pair.start + ((pair.end - pair.start) >> 1);
            unsorted.push(new Pair(mid + 1, pair.end, pair.level + 1));
            unsorted.push(new Pair(pair.start, mid, pair.level + 1));
        }
        Pair pair = unsorted.pop();
        if (pair.start == pair.end) sorted.push(pair);
        // Merge when two subarrays at same level are ready
        while (sorted.size() > 1) {
            Pair secondPair = sorted.pop();
            Pair firstPair = sorted.pop();
            if (firstPair.level == secondPair.level) {
                merge(arr, firstPair.start, firstPair.end, secondPair.end);
                sorted.push(new Pair(firstPair.start, secondPair.end, firstPair.level - 1));
            } else {
                sorted.push(firstPair);
                sorted.push(secondPair);
                break;
            }
        }
    }
    print(arr);
}

static class Pair {
    int start, end, level;
    Pair(int start, int end, int level) {
        this.start = start; this.end = end; this.level = level;
    }
}
```

## Key Properties
- **Stable**: Yes (equal elements preserve order)
- **Divide & Conquer**: Splits problem into smaller identical subproblems
- **Not in-place**: Requires O(n) auxiliary space for merge
- **Linked List**: Works well for linked lists (no extra space needed for merging)
