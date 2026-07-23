# LargestBinarySearchTreeInBinaryTree

**Topic:** `binarysearchtree` | **File:** `com/problems/binarysearchtree/LargestBinarySearchTreeInBinaryTree.java`

## Problem Links

- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/largest-bst/1)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=X0oXMdtUDwo&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=54)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Check this approach one more time later and check striver's video

```java
private static void type2() {
		TNode root = TNode.makeBST(35);
		Node node = largestBSTSubtree2(root);
		System.out.println(node.n);
	}
	private static Node largestBSTSubtree2(TNode root) {
		// An empty tree is a BST of size 0.
		if (root == null) return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		// Get values from the left and right subtree of the current tree.
		Node left = largestBSTSubtree2(root.left);
		Node right = largestBSTSubtree2(root.right);
		// The Current node is greater than max in the left and smaller than min in the right it is a BST.
		// It is a BST.
		if (left.max < root.data && root.data < right.min)
			return new Node(Math.min(root.data, left.min), Math.max(root.data, right.max), left.n + right.n + 1);
		// Otherwise, return [-inf, inf] so that parent can't be valid BST
		return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.n, right.n));
	}
```

### Approach 1 — Brute Force

Check this method one more time Brute force approach [It is also pretty efficient] for every node in Tree, find if starting from that node if it is BST or not. if it is BST find the count of nodes in that else go left and right

```java
private static void type1() {
		TNode root = TNode.makeBST(35);
		Map<TNode, Integer> count = new HashMap<>();
		count(root, count);
		int n = largestBSTSubtree1(root, count);
		System.out.println(n);
	}
	private static int count(TNode root, Map<TNode, Integer> count) {
		if (root == null) return 0;
		int total = 1 + count(root.left, count) + count(root.right, count);
		count.put(root, total);
		return total;
	}
	private static int largestBSTSubtree1(TNode root, Map<TNode, Integer> count) {
		if (root == null) return 0;
		// we have optimized a little by counting the nodes earlier and saved that to a hashmap
		if (isValidBst(root, Long.MIN_VALUE, Long.MAX_VALUE)) return count.get(root);
		return Math.max(largestBSTSubtree1(root.left, count), largestBSTSubtree1(root.right, count));
	}
	private static boolean isValidBst(TNode root, long min, long max) {
		if (null == root) return true;
		if (root.data <= min || root.data >= max) return false;
		return isValidBst(root.left, min, root.data)
				&& isValidBst(root.right, root.data, max);
	}
```
