package com.ds.fenwicktree;

public class FenwickTree {
    // The size of the array holding the Fenwick tree values
    final int N;

    // This array contains the Fenwick tree ranges
    private final long[] tree;

    // Create an empty Fenwick Tree with 'sz' parameter zero based.
    public FenwickTree(int sz) {
        tree = new long[(N = sz + 1)];
    }

    // Construct a Fenwick tree with an initial set of values.
    // The 'values' array MUST BE ONE BASED meaning values[0] does not get used, O(n) construction.
    public FenwickTree(long[] values) {
        if (values == null) throw new IllegalArgumentException("Values array cannot be null!");
        N = values.length;
        values[0] = 0L;
        // Make a clone of the value array since we manipulate the array in place, destroying all its original content.
        tree = values.clone();
        for (int i = 1; i < N; i++) {
            int parent = i + lsb(i);
            if (parent < N) tree[parent] += tree[i];
        }
    }

    // Returns the value of the least significant bit (LSB)
    private static int lsb(int i) {
        return i & -i;
    }

    // Computes the prefix sum from [1, i], O(log(n))
    private long prefixSum(int i) {
        long sum = 0L;
        while (i != 0) {
            sum += tree[i];
            i -= lsb(i);
        }
        return sum;
    }

    // Returns the sum of the interval [left, right], O(log(n))
    public long sum(int left, int right) {
        if (right < left) throw new IllegalArgumentException("Make sure right >= left");
        return prefixSum(right) - prefixSum(left - 1);
    }

    // Get the value at index i
    public long get(int i) {
        return sum(i, i);
    }

    // Add 'v' to index 'i', O(log(n))
    public void add(int i, long v) {
        while (i < N) {
            tree[i] += v;
            i += lsb(i);
        }
    }

    // Set index i to be equal to v, O(log(n))
    public void set(int i, long v) {
        add(i, v - sum(i, i));
    }

    @Override
    public String toString() {
        return java.util.Arrays.toString(tree);
    }
}