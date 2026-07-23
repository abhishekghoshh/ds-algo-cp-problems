# Segment Tree

## Overview

**11 files** covering range minimum/maximum/sum segment trees, lazy propagation for range updates, and advanced segment tree problems.

## Core Implementation

```java
// Sum Segment Tree
public class SegmentTree {
    int n;          // tree array size (4 * arrSize + 1)
    int arrSize;
    int[] tree;

    // Build: O(n)
    void build(int[] arr, int[] tree, int left, int right, int idx) {
        if (left == right) {
            tree[idx] = arr[left];
        } else {
            int mid = (left + right) / 2;
            build(arr, tree, left, mid, 2*idx+1);
            build(arr, tree, mid+1, right, 2*idx+2);
            tree[idx] = tree[2*idx+1] + tree[2*idx+2];
        }
    }

    // Query: O(log n)
    int query(int ql, int qr, int left, int right, int idx) {
        if (qr < left || right < ql) return 0;           // no overlap
        if (ql <= left && right <= qr) return tree[idx]; // full overlap
        int mid = (left + right) / 2;                    // partial overlap
        return query(ql, qr, left, mid, 2*idx+1)
             + query(ql, qr, mid+1, right, 2*idx+2);
    }

    // Update: O(log n)
    void update(int pos, int val, int left, int right, int idx) {
        if (left == right) {
            tree[idx] = val;
        } else {
            int mid = (left + right) / 2;
            if (pos <= mid) update(pos, val, left, mid, 2*idx+1);
            else update(pos, val, mid+1, right, 2*idx+2);
            tree[idx] = tree[2*idx+1] + tree[2*idx+2];
        }
    }
}
```

## Problem Categories

### Standard Segment Trees

| Problem | Operation |
|---------|-----------|
| Range Minimum | Min segment tree |
| Range Maximum | Max segment tree |
| Range Sum | Sum segment tree |

### Lazy Propagation

When we need range updates (not just single-point updates):

```java
// Lazy propagation for range updates on sum tree
int[] lazy;  // stores pending updates

void updateRange(int ul, int ur, int val, int left, int right, int idx) {
    // Apply pending updates
    if (lazy[idx] != 0) {
        tree[idx] += (right - left + 1) * lazy[idx];
        if (left != right) {
            lazy[2*idx+1] += lazy[idx];
            lazy[2*idx+2] += lazy[idx];
        }
        lazy[idx] = 0;
    }
    if (ur < left || right < ul) return;
    if (ul <= left && right <= ur) {
        tree[idx] += (right - left + 1) * val;
        if (left != right) {
            lazy[2*idx+1] += val;
            lazy[2*idx+2] += val;
        }
        return;
    }
    int mid = (left + right) / 2;
    updateRange(ul, ur, val, left, mid, 2*idx+1);
    updateRange(ul, ur, val, mid+1, right, 2*idx+2);
    tree[idx] = tree[2*idx+1] + tree[2*idx+2];
}
```

| Problem | Lazy Operation |
|---------|---------------|
| Range Sum + Range Update | Add value to range |
| Range Min + Range Update | Set min in range |
| Flip Coins in Range | Toggle bits in range |

### Advanced Problems

| Problem | Technique |
|---------|-----------|
| Inversion Count | Segment tree or BIT on value range |
| Inversion Count with Negatives | Coordinate compression + segment tree |
| Xenia and Bit Operations | Alternating OR/XOR segment tree |
| Sereja and Brackets | Segment tree tracking balanced brackets |
| Find X Value of Array II | Segment tree with custom queries |
