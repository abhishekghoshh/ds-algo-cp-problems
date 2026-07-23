# Meet in the Middle

## Overview

**6 files** covering the meet-in-the-middle technique for problems where brute force over the full input is infeasible. Split the input into two halves, compute all possibilities for each half, then combine.

## Core Idea

For input size **n** and each element having **k** choices:
- Brute force: O(k^n) - infeasible for large n
- Meet in middle: O(k^(n/2) × log(k^(n/2))) - feasible for n ≤ 40

## Problem Solutions

| Problem | Split Strategy |
|---------|---------------|
| Zero Sum Quadruple | Split into two pairs, find complementary sums |
| Strictly Increasing Triplets | Split, precompute increasing pairs |
| Four Sum | Split array into two halves |
| Subset Sum (Knapsack) | Split into first half and second half subsets |
| Closest Subsequence Sum | All subset sums for both halves, two-pointer search |
| Partition Array to Minimize Sum Diff | All subset sums per half, binary search closest |

```java
// Subset Sum with Meet in Middle:
// 1. Split array into [0..n/2) and [n/2..n)
// 2. Generate all subset sums for first half → list1 (size 2^(n/2))
// 3. Generate all subset sums for second half → list2 (size 2^(n/2))
// 4. Sort list2
// 5. For each sum in list1, binary search target - sum in list2

// For Closest Subsequence Sum:
int minDiff = Integer.MAX_VALUE;
for (int s1 : sums1) {
    // Find closest value to (target - s1) in sums2
    int idx = Collections.binarySearch(sums2, target - s1);
    if (idx >= 0) return 0;  // exact match
    idx = -idx - 1;
    if (idx < sums2.size()) minDiff = Math.min(minDiff, Math.abs(target - s1 - sums2.get(idx)));
    if (idx > 0) minDiff = Math.min(minDiff, Math.abs(target - s1 - sums2.get(idx-1)));
}
```

### Complexity
- Generating subset sums: O(2^(n/2)) for each half
- Sorting: O(2^(n/2) × n)
- Combining: O(2^(n/2) × log(2^(n/2))) = O(2^(n/2) × n)
