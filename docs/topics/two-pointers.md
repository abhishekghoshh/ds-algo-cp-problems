# Two Pointers

## Overview

Two-pointer techniques are used across multiple topics (arrays, strings, linked lists). This technique involves maintaining two indices/pointers that move through data structure(s) to solve problems efficiently, often reducing O(n²) to O(n).

## Core Patterns

### Pattern 1: Opposite Direction (Converging)
```java
// Array sorted, find pair with sum = target
int l = 0, r = n - 1;
while (l < r) {
    int sum = arr[l] + arr[r];
    if (sum == target) return true;
    else if (sum < target) l++;
    else r--;
}
```

### Pattern 2: Same Direction (Sliding)
```java
// Remove duplicates from sorted array
int i = 0;  // position for next unique element
for (int j = 1; j < n; j++)
    if (arr[j] != arr[i])
        arr[++i] = arr[j];
return i + 1;
```

### Pattern 3: Two Different Arrays
```java
// Merge two sorted arrays
int i = 0, j = 0, k = 0;
while (i < n1 && j < n2)
    result[k++] = arr1[i] <= arr2[j] ? arr1[i++] : arr2[j++];
while (i < n1) result[k++] = arr1[i++];
while (j < n2) result[k++] = arr2[j++];
```

## Problems Using Two Pointers

| Problem | Pattern |
|---------|---------|
| Two Sum (Sorted Input) | Opposite converging |
| Two Sum | After sorting, opposite converging |
| Three Sum | Outer loop + two-pointer on rest |
| Four Sum | Two nested loops + two-pointer |
| Valid Palindrome | Opposite converging |
| Valid Palindrome II | Opposite with skip option |
| Move Zeros to End | Same direction |
| Sort Array by Parity | Opposite converging |
| Remove Duplicates (Sorted) | Same direction |
| Remove Duplicates II | Same direction with count |
| Container With Most Water | Opposite converging |
| Boats to Save People | Opposite converging (sort first) |
| Trapping Rain Water | Opposite with max tracking |
| Merge Two Sorted Arrays | Two different arrays |
| Intersection of Two Arrays | Two sorted arrays |
| Partition Labels | Same direction with map |
| Rearrange by Sign | Same direction + auxiliary |
