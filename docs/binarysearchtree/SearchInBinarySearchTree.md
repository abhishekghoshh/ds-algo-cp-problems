# SearchInBinarySearchTree

**Topic:** `binarysearchtree` | **File:** `com/problems/binarysearchtree/SearchInBinarySearchTree.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/search-in-a-binary-search-tree/)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/search-a-node-in-bst/1)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=KcNt6v_56cc&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=41)
- [📄 takeUforward](https://takeuforward.org/data-structure/search-in-a-binary-search-tree-2/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Iterative way

```java
private static void type2() {
		TNode root = TNode.makeBST(15);
		System.out.println(root.searchBST(2));

		TNode node = searchBST2(root, 2);
		System.out.println(node);
	}
	private static TNode searchBST2(TNode root, int target) {
		while (null != root) {
			if (target == root.data) return root;
			else if (target < root.data) root = root.left;
			else root = root.right;
		}
		return null;
	}
```

### Approach 1 — Brute Force

Recursive way

```java
private static void type1() {
		TNode root = TNode.makeBST(15);
		System.out.println(root.searchBST(2));

		TNode node = searchBST1(root, 2);
		System.out.println(node);
	}
	public static TNode searchBST1(TNode root, int val) {
		if (null == root || root.data == val) return root;
		return val < root.data ?
				searchBST1(root.left, val) :
				searchBST1(root.right, val);
	}
```
