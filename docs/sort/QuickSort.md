# Quick Sort

## Problem Link
- [LeetCode - Sort an Array](https://leetcode.com/problems/sort-an-array/)
- [GeeksforGeeks - Quick Sort](https://www.geeksforgeeks.org/problems/quick-sort/1)

## Solution Link
- [YouTube](https://www.youtube.com/watch?v=WIrA4YexLRQ&t=1s)
- [Blog - takeUforward](https://takeuforward.org/data-structure/quick-sort-algorithm/)
- [Blog - GeeksforGeeks](https://www.geeksforgeeks.org/quick-sort/)

## Approaches

### Type 1: First Element as Pivot

```java
private static void type1() {
    int[] arr = {12, 10, 11, 13, 21, 24, 25, 20, 9};
    int n = arr.length;
    quicksort1(arr, 0, n - 1);
    PrintUtl.print(arr);
}

private static void quicksort1(int[] arr, int low, int high) {
    if (low < high) {
        // after each partition, one item is placed in its actual position
        // on its left: every item is smaller
        // on its right: every item is greater
        int partitionIndex = partition1(arr, low, high);
        quicksort1(arr, low, partitionIndex - 1);
        quicksort1(arr, partitionIndex + 1, high);
    }
}

private static int partition1(int[] arr, int low, int high) {
    int pivot = arr[low];  // first item as pivot
    int start = low;
    int end = high;
    while (start < end) {
        // break once there is item greater than pivot
        while (arr[start] <= pivot && start <= high - 1) start++;
        // break once there is item lesser than pivot
        while (arr[end] > pivot && end >= low) end--;
        // once we found two indices, swap two items
        // start > end means partitions are already made
        if (start < end) swap(arr, start, end);
    }
    // after iteration, low+1 to end is lesser than pivot
    swap(arr, end, low);
    return end;
}
```

### Type 2: Last Element as Pivot

```java
private static void type2() {
    int[] arr = {10, 7, 8, 9, 1, 5};
    int n = arr.length;
    quickSort2(arr, 0, n - 1);
}

static void quickSort2(int[] arr, int low, int high) {
    if (low < high) {
        int partitionIndex = partition2(arr, low, high);
        quickSort2(arr, low, partitionIndex - 1);
        quickSort2(arr, partitionIndex + 1, high);
    }
}

/**
 * This function takes last element as pivot, places the pivot element
 * at its correct position in sorted array, and places all smaller
 * to left of pivot and all greater elements to right of pivot.
 */
static int partition2(int[] arr, int low, int high) {
    int pivot = arr[high];  // last item as pivot
    int i = low - 1;  // Index of smaller element
    for (int j = low; j <= high - 1; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, high);
    return (i + 1);
}
```

## Complexity
- **Average**: O(n log n)
- **Worst**: O(n²) when array is already sorted or reverse sorted (bad pivot choices)
- **Space**: O(log n) recursion stack
- **Not Stable** (in typical implementations)

## Pivot Selection Strategies
- First element (Type 1)
- Last element (Type 2)
- Random element (mitigates worst case)
- Median-of-three (low, mid, high)
