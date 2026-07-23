# Sorting Algorithms

## Overview

**12 files** covering comparison-based sorts (O(n²) and O(n log n)) and linear sorts (O(n)). Located in `com/algo/sort/`.

## Algorithm Implementations

### Comparison-Based Sorts

#### Bubble Sort (O(n²))
```java
// Repeatedly swap adjacent inverted elements
// Best case O(n) when already sorted (with optimization)
for (int i = 0; i < n - 1; i++)
    for (int j = 0; j < n - i - 1; j++)
        if (arr[j] > arr[j + 1])
            swap(arr, j, j + 1);
```

**Recursive Bubble Sort:** Base case when array size = 1, largest bubbles to end.

#### Selection Sort (O(n²))
```java
// Find minimum element, place at beginning
for (int i = 0; i < n - 1; i++) {
    int minIdx = i;
    for (int j = i + 1; j < n; j++)
        if (arr[j] < arr[minIdx])
            minIdx = j;
    swap(arr, i, minIdx);
}
```

#### Insertion Sort (O(n²))
```java
// Build sorted portion from left, insert each element into position
for (int i = 1; i < n; i++) {
    int key = arr[i];
    int j = i - 1;
    while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
    }
    arr[j + 1] = key;
}
// Best case O(n) when nearly sorted
```

**Recursive Insertion Sort:** Recursively sort first n-1, insert last element.

#### Merge Sort (O(n log n))
```java
// Divide and conquer: split, sort recursively, merge
static void mergeSort(int[] nums, int low, int high) {
    if (low < high) {
        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }
}

static void merge(int[] nums, int low, int mid, int high) {
    int n = high - low + 1;
    int[] copy = new int[n];
    int left = low, right = mid + 1, i = 0;
    while (left <= mid && right <= high)
        copy[i++] = nums[left] < nums[right] ? nums[left++] : nums[right++];
    while (left <= mid) copy[i++] = nums[left++];
    while (right <= high) copy[i++] = nums[right++];
    for (i = 0; i < n; i++) nums[low + i] = copy[i];
}
```

**Type 2 (Stack-based iterative):** Simulates recursion using two stacks (experimental, not for interviews).

#### Quick Sort (O(n log n) avg, O(n²) worst)
```java
// Two partitioning strategies:

// Type 1: First element as pivot
static int partition1(int[] arr, int low, int high) {
    int pivot = arr[low];
    int start = low, end = high;
    while (start < end) {
        while (arr[start] <= pivot && start <= high - 1) start++;
        while (arr[end] > pivot && end >= low) end--;
        if (start < end) swap(arr, start, end);
    }
    swap(arr, end, low);
    return end;
}

// Type 2: Last element as pivot
static int partition2(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j <= high - 1; j++)
        if (arr[j] < pivot) swap(arr, ++i, j);
    swap(arr, i + 1, high);
    return i + 1;
}
```

#### Heap Sort (O(n log n))
```java
// Uses MinHeap data structure
MinHeap minHeap = new MinHeap(arr);
for (int i = 0; i < arr.length; i++)
    arr[i] = minHeap.extractMin();
```

### Non-Comparison Sorts

#### Counting Sort (O(n + k))
```java
// For integers in range [0, k]
int[] count = new int[maxVal + 1];
for (int num : arr) count[num]++;
int idx = 0;
for (int i = 0; i <= maxVal; i++)
    while (count[i]-- > 0) arr[idx++] = i;
```

#### Radix Sort (O(d × (n + k)))
```java
// Sort by each digit (least significant first)
// Uses counting sort as subroutine per digit
// d = number of digits, k = base (10 for decimal)
```

#### Swap Sort / Cycle Sort (O(n))
```java
// Works when array contains numbers from 1 to n
for (int i = 0; i < n; i++)
    while (arr[i] != arr[arr[i] - 1])
        swap(arr, i, arr[i] - 1);
// Used for finding duplicates, missing numbers
```

## Comparison Table

| Algorithm | Best | Average | Worst | Space | Stable |
|-----------|------|---------|-------|-------|--------|
| Bubble | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Selection | O(n²) | O(n²) | O(n²) | O(1) | No |
| Insertion | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Merge | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes |
| Quick | O(n log n) | O(n log n) | O(n²) | O(log n) | No |
| Heap | O(n log n) | O(n log n) | O(n log n) | O(1) | No |
| Counting | O(n+k) | O(n+k) | O(n+k) | O(k) | Yes |
| Radix | O(d(n+k)) | O(d(n+k)) | O(d(n+k)) | O(n+k) | Yes |
| Swap | O(n) | O(n) | O(n) | O(1) | N/A |
