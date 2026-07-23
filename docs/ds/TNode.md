# TreeNode (TNode)

## Description

Utility TreeNode class with factory methods for building binary trees and BSTs from arrays. Used across all binary tree and BST problem solutions.

## Code

```java
package com.ds.binarytree;

public class TNode {
    public static final int NULL = Integer.MIN_VALUE;  // sentinel for null nodes
    public int data;
    public int val;           // alias for data (compatibility)
    public TNode left, right, next;  // next for level connections

    public TNode(int data) { this.data = this.val = data; }
    public TNode(int val, TNode left, TNode right) {
        this.data = this.val = val; this.left = left; this.right = right;
    }

    // Fluent setters
    public TNode data(int data) { this.data = this.val = data; return this; }
    public TNode left(TNode left) { this.left = left; return this; }
    public TNode right(TNode right) { this.right = right; return this; }

    // DFS search in any tree
    public TNode search(int val) {
        if (val == this.data) return this;
        if (null != this.left) {
            TNode left = this.left.search(val);
            if (null != left) return left;
        }
        if (null != this.right) return this.right.search(val);
        return null;
    }

    // Build tree from level-order array (NULL = missing node)
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

    // Create balanced BST from 1..n
    public static TNode makeBST(int n) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) nums[i - 1] = i;
        return makeBST(nums, 0, n - 1);
    }

    private static TNode makeBST(int[] nums, int l, int r) {
        if (l > r) return null;
        if (l == r) return new TNode(nums[l]);
        int mid = (l + r) / 2;
        return new TNode(nums[mid], makeBST(nums, l, mid - 1), makeBST(nums, mid + 1, r));
    }

    // Create a random (imbalanced) BST
    public static TNode imbalancedBST(int n) { ... }

    // BST search (O(log n) on balanced tree)
    public TNode searchBST(int root) { return searchBST(this, root); }
    public static TNode searchBST(TNode root, int data) {
        if (null == root || root.data == data) return root;
        return data < root.data ? searchBST(root.left, data) : searchBST(root.right, data);
    }

    // Build tree from Integer[] (with nulls)
    public static TNode withObjectNodes(Integer... nums) { ... }
    public static TNode withCount(int n) { ... }  // build 1..n in level order
}
```

## Factory Method Reference

| Method | Input | Output |
|--------|-------|--------|
| `withNodes(int...)` | Level order array (NULL for missing) | Binary tree |
| `withObjectNodes(Integer...)` | Level order array with nulls | Binary tree |
| `withCount(n)` | Integer n | Tree with values 1..n |
| `makeBST(n)` | Integer n | Balanced BST 1..n |
| `makeBST(int...)` | Sorted array | Balanced BST |
| `imbalancedBST(n)` | Integer n | Random unbalanced BST |

## Usage Pattern

```java
TNode root = TNode.withNodes(1, 2, 3, TNode.NULL, 5);
// Creates:    1
//            / \
//           2   3
//            \
//             5
```
