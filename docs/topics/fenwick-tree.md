# Fenwick Tree / Binary Indexed Tree

## Overview

**6 files** covering Fenwick Tree implementation, inversion count, and offline query problems.

## Core Implementation

```java
public class FenwickTree {
    int[] bit;
    int n;
    
    FenwickTree(int size) {
        n = size + 1;
        bit = new int[n];
    }
    
    // Add value at index (1-based)
    void add(int idx, int val) {
        while (idx < n) {
            bit[idx] += val;
            idx += idx & -idx;  // add LSB
        }
    }
    
    // Prefix sum [1..idx]
    int sum(int idx) {
        int result = 0;
        while (idx > 0) {
            result += bit[idx];
            idx -= idx & -idx;  // remove LSB
        }
        return result;
    }
    
    // Range sum [l, r]
    int rangeSum(int l, int r) {
        return sum(r) - sum(l - 1);
    }
}
```

## Key Properties

- **Space**: O(n)
- **Point update**: O(log n)
- **Prefix sum query**: O(log n)
- `idx & -idx` extracts the lowest set bit (LSB)
- Build: O(n log n) naive, or O(n) by propagating values

## Problem Solutions

| Problem | Technique |
|---------|-----------|
| Fenwick Tree Prerequisites | Theory & explanation |
| Fenwick Tree Implementation | Range sum with point updates |
| Inversion Count | Process array, query count of greater values |
| Count Smaller Numbers After Self | Process from right, query count of smaller |
| Distribute Elements Into Two Arrays II | Coordinate compression + BIT |
| Block Placement Queries | BIT with custom coordinate mapping |
| Find Subarray with OR Closest to K | BIT + sliding window |
| Peaks in Array | Track peaks using BIT |
