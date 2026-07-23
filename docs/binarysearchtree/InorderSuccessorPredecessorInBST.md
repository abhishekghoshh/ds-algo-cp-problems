# InorderSuccessorPredecessorInBST

**Topic:** `binarysearchtree` | **File:** `com/problems/binarysearchtree/InorderSuccessorPredecessorInBST.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/inorder-successor-in-bst/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/predecessor-and-successor-in-bst_893049)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/predecessor-and-successor/1)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=SXKAD2svfmI&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=50)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Inorder predecessor

```java
private static void type3() {
		TNode root = TNode.makeBST(31);
		int key = 7;

		TNode node = root, ans = null;
		while (node != null) {
			// if key is lesser than node, so we need to go to the left subtree
			// if key is the equal to node, then also we need to go to the left subtree
			if (key <= node.data) {
				node = node.left;
			} else {
				// key > node
				// it means key is higher than node so node can be key's predecessor
				ans = node;
				node = node.right;
			}
		}
		System.out.println(ans);
	}
```

### Approach 2

Inorder successor

```java
private static void type2() {
		TNode root = TNode.makeBST(31);
		int key = 7;

		TNode node = root, ans = null;
		while (node != null) {
			// if key is greater than node, so we need to go to the right subtree
			// if key is equal to node, then also we need to go to the right subtree
			if (node.data <= key) {
				node = node.right;
			} else {
				// key < node
				// it means key is less than node so node can be key's successor
				ans = node;
				node = node.left;
			}
		}
		System.out.println(ans);
	}
```

### Approach 1 — Brute Force

Brute force approach finds the inorder traversal store it in a list get the predecessor and successor

```java
private static void type1() {
		TNode root = TNode.makeBST(31);
		int key = 7;
		List<Integer> inorder = new ArrayList<>();
		inorder(root, inorder);
		//find the position of the key either by linear search or by binary search
	}
	private static void inorder(TNode root, List<Integer> inorder) {
		if (null == root) return;
		inorder(root, inorder);
		inorder.add(root.data);
		inorder(root.right, inorder);
	}
```
