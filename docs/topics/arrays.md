# Arrays

## Overview

**122 files** covering array operations, subarray problems, prefix sums, two-pointer techniques, matrix operations, and more.

## Prerequisite Data Structures

### Dynamic Array (`com/ds/array/Array.java`)

A generic dynamic array with automatic resizing (doubles capacity when full), binary search, iterator support, and O(1) amortized add, O(n) remove.

```java
// Key operations:
public void add(T elem)     // O(1) amortized - doubles capacity when needed
public T get(int index)      // O(1)
public void removeAt(int index) // O(n) - shifts elements
public int binarySearch(int key) // O(log n) - requires sorted array
public void reverse()        // O(n)
```

## Pattern: Progressive Disclosure

Every solution follows the `type1()` → `typeN()` progressive approach from brute force to optimal:

### Two Sum - Example Pattern

```java
// Tags: Array, Hashing, Two-pointer

// type1() - Brute force: O(n²) time, O(1) space
// Double nested loop checking all pairs
private static int[] twoSum1(int[] nums, int target) {
    int n = nums.length;
    for (int i = 0; i < n - 1; i++)
        for (int j = i + 1; j < n; j++)
            if (nums[i] + nums[j] == target)
                return new int[]{i, j};
    return new int[2];
}

// type2() - HashMap: O(n) time, O(n) space
// Store visited numbers, check for complement
private static int[] twoSum2(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement))
            return new int[]{map.get(complement), i};
        map.put(nums[i], i);
    }
    return new int[2];
}
```

## Problem Categories

### Subarray / Subsequence Problems

| Problem | Approaches | Complexity |
|---------|-----------|------------|
| **Two Sum** | Brute force → HashMap | O(n²) → O(n) |
| **Three Sum** | Brute force → Two-pointer (sorted) | O(n³) → O(n²) |
| **Three Sum Closest** | Two-pointer with closest diff tracking | O(n²) |
| **Four Sum** | Two-pointer with optimization | O(n³) |
| **Valid Triangle Number** | Sorting + two-pointer | O(n²) |
| **Maximum Subarray Sum (Kadane)** | DP / Kadane's algorithm | O(n) |
| **Maximum Product Subarray** | Track min and max simultaneously | O(n) |

### Kadane's Algorithm Pattern

```java
// Maximum sum for consecutive elements
// Maintain running sum, reset to 0 when negative
int maxSum = Integer.MIN_VALUE, sum = 0;
for (int num : nums) {
    sum += num;
    maxSum = Math.max(maxSum, sum);
    if (sum < 0) sum = 0;  // Reset negative window
}
```

### Prefix Sum Pattern

| Problem | Technique |
|---------|-----------|
| **Find Pivot Index** | Prefix sum array |
| **Range Sum Query (1D & 2D)** | Precomputed prefix sums for O(1) queries |
| **Product of Array Except Self** | Left & right prefix product arrays |
| **Longest Subarray Sum = K** | HashMap storing prefix sum → index |
| **Count Subarray Sum = K** | HashMap storing prefix sum → frequency |
| **Longest Subarray XOR = K** | HashMap storing prefix XOR → index |
| **Contiguous Array** | Replace 0 with -1, find longest subarray sum = 0 |
| **Brick Wall** | Count edge positions, find minimum crossed bricks |

### Two Pointer Pattern

```java
// Remove Duplicates from Sorted Array
int i = 0;  // Position for next unique element
for (int j = 1; j < nums.length; j++)
    if (nums[j] != nums[i])
        nums[++i] = nums[j];
return i + 1;
```

Problem list:
- Move Zeros to End
- Sort Array By Parity
- Remove Duplicates from Sorted Array (I & II)
- Boats to Save People (two-pointer on sorted)
- Rearrange Array by Sign
- Trapping Rain Water (two-pointer from both ends)

### Trapping Rain Water - Multiple Approaches

```java
// type1() - Brute force: For each index, find max left and right, O(n²)
// type2() - Prefix max arrays: Precompute leftMax[] and rightMax[], O(n), O(n)
// type3() - Stack-based: Monotonic decreasing stack, O(n), O(n)
// type4() - Two-pointer: left/right pointers tracking max so far, O(n), O(1)

// Two-pointer approach:
int left = 0, right = n - 1, leftMax = 0, rightMax = 0, water = 0;
while (left < right) {
    if (height[left] < height[right]) {
        leftMax = Math.max(leftMax, height[left]);
        water += leftMax - height[left++];
    } else {
        rightMax = Math.max(rightMax, height[right]);
        water += rightMax - height[right--];
    }
}
```

### Matrix Operations

| Problem | Approach |
|---------|----------|
| **Set Matrix Zero** | First row/col markers, O(1) space |
| **Rotate Matrix** | Transpose + reverse rows |
| **Spiral Traversal** | Four direction boundaries |
| **Search 2D Matrix** | Binary search on flattened indices |
| **Range Sum Query 2D** | 2D prefix sum matrix |

### Swap Sort / Cycle Sort Pattern

Used when array contains numbers from 1 to n:

```java
// Place each element at its correct position
for (int i = 0; i < n; i++)
    while (nums[i] != nums[nums[i] - 1])
        swap(nums, i, nums[i] - 1);
```

Applications:
- Find the Duplicate Number
- Find All Duplicates
- Find Repeating and Missing Numbers
- First Missing Positive

### Monotonic / Miscellaneous

| Problem | Technique |
|---------|-----------|
| **Majority Element (> n/2)** | Moore's Voting Algorithm |
| **Majority Element (> n/3)** | Extended Moore's Voting (2 candidates) |
| **Next Permutation** | Find first dip, swap with next greater, reverse suffix |
| **Merge Overlapping Intervals** | Sort by start, merge overlapping |
| **Car Fleet** | Sort by position, compute arrival times |
| **Longest Consecutive Sequence** | HashSet + check sequence starts |
| **Valid Sudoku** | HashSets for rows, cols, and 3×3 boxes |

### Others

- Gas Station (circular array pattern)
- Count Inversions (merge sort modification)
- Reverse Pairs (merge sort or BIT)
- Minimum Pair Removal to Sort Array
- Count Special Triplets
- Equal Sum Grid Partition
