# SearchInBinarySearchTree

**Topic:** `binarysearchtree`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/search-in-a-binary-search-tree/)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/search-a-node-in-bst/1)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=KcNt6v_56cc&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=41)
- [📄 takeUforward](https://takeuforward.org/data-structure/search-in-a-binary-search-tree-2/)

## 📝 Problem Statement

Given the root of a Binary Search Tree and a node value key, return true if the node with value key is present in the BST; otherwise, return false.
Examples:
Input: root = [6, 2, 8, N, N, 7, 9], key = 8    Output: true
Explanation: 8 is present in th

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

iterative way

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

### Approach 1: 🔨 Brute Force

recursive way

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
}
```
