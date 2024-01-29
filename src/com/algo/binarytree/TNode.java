package com.algo.binarytree;

public class TNode {
    public static int NULL = Integer.MIN_VALUE;
    public int data;
    public TNode left, right;

    public TNode(int data) {
        this.data = data;
    }

    public TNode left(TNode left) {
        this.left = left;
        return this;
    }

    public TNode right(TNode right) {
        this.right = right;
        return this;
    }

    public TNode search(int val) {
        if (val == this.data) return this;
        if (null != this.left) {
            TNode left = this.left.search(val);
            if (null != left) return left;
        }
        if (null != this.right) {
            return this.right.search(val);
        }
        return null;
    }

    public static TNode withCount(int n) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++)
            nums[i - 1] = i;
        return withNodes(nums);
    }

    public static TNode withNodes(int... nums) {
        int n = nums.length;
        if (n == 0) return null;
        TNode[] nodes = new TNode[n];
        for (int i = 0; i < n; i++)
            nodes[i] = (nums[i] != NULL) ? new TNode(nums[i]) : null;
        for (int i = 0; i < n; i++) {
            if (null == nodes[i]) continue;
            int left = i * 2 + 1, right = i * 2 + 2;
            nodes[i].left = left < n ? nodes[left] : null;
            nodes[i].right = right < n ? nodes[right] : null;
        }
        return nodes[0];
    }
}