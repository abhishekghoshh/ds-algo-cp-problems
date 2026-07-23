# KthSmallestLargestElementInBinaryTree

**Topic:** `binarysearchtree` | **File:** `com/problems/binarysearchtree/KthSmallestLargestElementInBinaryTree.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)
- [📄 NeetCode](https://neetcode.io/problems/kth-smallest-integer-in-bst)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/kth-smallest-node-in-bst_920441)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/kth-largest-element-in-bst/1)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=9TJYWh0adfk&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=46)
- [▶ YouTube](https://www.youtube.com/watch?v=5LUXSvjmGCw)
- [📄 takeUforward](https://takeuforward.org/data-structure/kth-largest-smallest-element-in-binary-search-tree/)

## Approaches

This problem has **4** approaches, progressing from brute force to optimal:

### Approach 4 — Optimal

All the approaches are exactly same with very mild difference TODO kth largest we will visit the nodes from right to left then we can skip the counting operation

```java
private static void type4() {
		TNode root = TNode.makeBST(15);
		int k = 6;
		Data data = new Data();
		inOrder2(root, k, data);
		System.out.println(data.data);
	}
	private static void inOrder2(TNode root, int k, Data data) {
		// if the count has already reached k then will go no more
		// we will return from here
		if (null == root || data.count >= k) return;
		inOrder2(root.right, k, data);
		// every time we visit a non-null node we will increment the counter
		data.count++;
		// if the count is k then we will set the answer
		if (data.count == k) {
			data.data = root.data;
			return;
		}
		inOrder2(root.left, k, data);
	}
```

### Approach 3

Kth largest kth largest means n-k+1 th smallest

```java
private static void type3() {
		TNode root = TNode.makeBST(15);
		int k = 6;
		Data data = new Data();
		int n = count(root);
		inOrder1(root, n - k + 1, data);
		System.out.println(data.data);
	}
	private static int count(TNode root) {
		if (null == root) return 0;
		return 1 + count(root.left) + count(root.right);
	}
```

### Approach 2

Similar to the previous type, but here we will use two class level variables only

```java
private static void type2() {
		TNode root = TNode.makeBST(15);
		int k = 6;
		kthSmallest2(k, root);
		System.out.println(ans);
	}
	private static void kthSmallest2(int k, TNode root) {
		KthSmallestLargestElementInBinaryTree.k = k;
		inOrder2(root);
	}
	private static void inOrder2(TNode root) {
		/// if root is null or k < 0 then we will return else we will do inorder
		if (null == root || k < 0) return;
		inOrder2(root.left);
		// we will decrement k and check if it is 0 or not
		if (--k == 0) ans = root.val;
		inOrder2(root.right);
	}
```

### Approach 1 — Brute Force

Kth smallest we know the inorder of bst will give us the sorted list we will keep a counter, and when the counter is k then we will store the value time complexity is O(k)

```java
private static void type1() {
		TNode root = TNode.makeBST(15);
		int k = 6;
		Data data = new Data();
		inOrder1(root, k, data);
		System.out.println(data.data);
	}
	private static void inOrder1(TNode root, int k, Data data) {
		// if the count has already reached k then will go no more
		// we will return from here
		if (null == root || data.count >= k) return;
		inOrder1(root.left, k, data);
		// every time we visit a non-null node we will increment the counter
		data.count++;
		// if the count is k then we will set the answer
		if (data.count == k) {
			data.data = root.data;
			return;
		}
		inOrder1(root.right, k, data);
	}
```
