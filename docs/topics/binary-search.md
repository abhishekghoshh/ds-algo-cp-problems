# Binary Search

## Overview

**42 files** covering standard binary search, rotated arrays, 2D matrix search, capacity/shipping problems, and monotonic function optimization.

## The Core Pattern

```java
// Standard binary search template
int low = 0, high = n - 1;
while (low <= high) {
    int mid = low + (high - low) / 2;  // overflow-safe
    if (arr[mid] == target) return mid;
    else if (arr[mid] < target) low = mid + 1;
    else high = mid - 1;
}
return -1;
```

## Problem Categories

### Foundation

| Problem | Key Insight |
|---------|------------|
| **Binary Search** | Standard sorted array search |
| **Reverse Sorted Array** | Flip comparison operators |
| **Order Not Known** | First determine ascending/descending |
| **Lower Bound** | First position where `arr[i] >= x` |
| **Upper Bound** | First position where `arr[i] > x` |
| **Floor & Ceil** | Return both floor and ceil values |
| **Search Insert Position** | Lower bound variant |
| **Next Alphabetical Element** | Ceil on character array |
| **Closest Element** | Track minimum difference while binary searching |
| **First/Last Occurrence** | Binary search then expand left/right |

### Rotated Sorted Arrays

```java
// Search in Rotated Sorted Array
// Key insight: At least one half is always sorted
int low = 0, high = n - 1;
while (low <= high) {
    int mid = low + (high - low) / 2;
    if (arr[mid] == target) return mid;
    // Left half is sorted
    if (arr[low] <= arr[mid]) {
        if (arr[low] <= target && target < arr[mid]) high = mid - 1;
        else low = mid + 1;
    }
    // Right half is sorted
    else {
        if (arr[mid] < target && target <= arr[high]) low = mid + 1;
        else high = mid - 1;
    }
}
```

Variants:
- Search in Rotated Sorted Array I (no duplicates)
- Search in Rotated Sorted Array II (with duplicates)
- Find Minimum in Rotated Sorted Array
- Find Number of Rotations (index of minimum)

### Peak & Bitonic Arrays

| Problem | Approach |
|---------|----------|
| **Find Peak Element** | Binary search comparing `mid` with `mid+1` |
| **Find in Bitonic Array** | Find peak, then binary search both sides |
| **Find Maximum in Bitonic Array** | Peak element is the maximum |
| **Find Peak Element II (2D)** | Binary search on columns, find max in row |

### Monotonic Function Optimization (Capacity Problems)

**Common template:** Binary search on answer space [min_possible, max_possible]

```java
// Pattern: Find minimum capacity/time that satisfies condition
int low = min_possible, high = max_possible, answer = -1;
while (low <= high) {
    int mid = low + (high - low) / 2;
    if (isPossible(mid)) {
        answer = mid;
        high = mid - 1;   // Try smaller
    } else {
        low = mid + 1;     // Need larger
    }
}
```

Problems:
- Koko Eating Bananas (min eating speed)
- Minimum Days for M Bouquets (min waiting days)
- Smallest Divisor Given Threshold
- Capacity to Ship Packages Within D Days (min ship capacity)
- Split Array Largest Sum (minimize max subarray sum)
- Painter's Partition Problem
- Allocate Minimum Pages
- Aggressive Cows (maximize minimum distance)

### Aggressive Cows - Detailed Example

```java
// Problem: Place C cows in N stalls to maximize minimum distance
// Approach: Binary search on the distance

boolean canPlace(int[] stalls, int cows, int minDist) {
    int placed = 1, lastPos = stalls[0];
    for (int i = 1; i < stalls.length; i++) {
        if (stalls[i] - lastPos >= minDist) {
            placed++;
            lastPos = stalls[i];
            if (placed == cows) return true;
        }
    }
    return false;
}

// Binary search on answer: maximize min distance
int low = 1, high = stalls[n-1] - stalls[0], answer = 0;
while (low <= high) {
    int mid = low + (high - low) / 2;
    if (canPlace(stalls, cows, mid)) {
        answer = mid;
        low = mid + 1;  // try larger distance
    } else {
        high = mid - 1;
    }
}
```

### Two Sorted Arrays

| Problem | Approach | Complexity |
|---------|----------|------------|
| **Median of Two Sorted Arrays** | Binary search on partition of smaller array | O(log(min(n₁,n₂))) |
| **K-th Element of Two Sorted Arrays** | Similar partition approach | O(log(min(n₁,n₂))) |

```java
// Median of Two Sorted Arrays - Core logic:
// Partition arrays such that left half has (n1+n2+1)/2 elements
int low = 0, high = n1, left = (n1 + n2 + 1) / 2;
while (low <= high) {
    int cut1 = (low + high) / 2;
    int cut2 = left - cut1;
    int l1 = (cut1 == 0) ? MIN : nums1[cut1-1];
    int l2 = (cut2 == 0) ? MIN : nums2[cut2-1];
    int r1 = (cut1 == n1) ? MAX : nums1[cut1];
    int r2 = (cut2 == n2) ? MAX : nums2[cut2];
    if (l1 <= r2 && l2 <= r1)
        return (even) ? (max(l1,l2)+min(r1,r2))/2.0 : max(l1,l2);
    else if (l1 > r2) high = cut1 - 1;
    else low = cut1 + 1;
}
```

### 2D Matrix Search

| Problem | Approach |
|---------|----------|
| **Search 2D Sorted Matrix** | Binary search treating as 1D array |
| **Search 2D Matrix II** | Start from top-right corner |
| **Median of Row-Wise Sorted Matrix** | Binary search on answer space, count <= mid per row |
| **Find Row with Max 1s** | Binary search for first 1 in each row |
| **Count Negatives in Sorted Matrix** | Binary search per row or start from bottom-left |

### Square Roots & Powers

- Integer square root (binary search)
- Fractional square root (binary search with precision)
- Nth root of a number
- Pow(x, n) (binary exponentiation)

### Special Binary Search Techniques

| Problem | Technique |
|---------|-----------|
| **Infinite Sorted Array** | Exponential search to find bounds |
| **Infinite Binary Array** | Find first `1` using exponential search |
| **Nearly Sorted Array** | Check mid, mid-1, mid+1 |
| **Single Element in Sorted Array** | Compare mid with neighbor to determine which half |
