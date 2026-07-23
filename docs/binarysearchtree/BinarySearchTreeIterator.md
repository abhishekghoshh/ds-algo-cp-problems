# BinarySearchTreeIterator

**Topic:** `binarysearchtree` | **File:** `com/problems/binarysearchtree/BinarySearchTreeIterator.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/binary-search-tree-iterator/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=D2jMcmxU4bs&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=51)
- [▶ YouTube](https://www.youtube.com/watch?v=RXy5RzGF5wo)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

This is also very optimized approach this takes advantage of the iterative inorder traversal of a binary search tree. unlike the previous approach we we will explore the nodes while calling next time complexity of next function in O(1) space complexity O(log(n)) here we are not storing the whole inorder traversal we are just storing the left most child in a sense we are storing only one full recursion depth into the stack on every next call we're just returning the stack top element because it is the most left element and in inorder we have to return the left mode element, and also we are checking if the node has any right node

**Complexity:** Space: o(log(n)

```java
private static void type2() {
		TNode root = TNode.makeBST(31);
		BstIterator2 bstIterator = new BstIterator2(root);
		while (bstIterator.hasNext()) {
			System.out.print(bstIterator.next() + " ");
		}
		System.out.println();
	}
```

### Approach 1 — Brute Force

This approach goes to the left most node or the smallest node if you remember in the iterative inorder we stored the node in the answer list. then we explored the nodes right subtree TODO this is the simplest approach, explain this in the interview first save the inorder traversal of the tree in list then iterate over the list time complexity of next function in O(1) space complexity O(n)

**Complexity:** Space: o(n)

```java
private static void type1() {
		TNode root = TNode.makeBST(31);
		BstIterator1 bstIterator = new BstIterator1(root);
		while (bstIterator.hasNext()) {
			System.out.print(bstIterator.next() + " ");
		}
		System.out.println();
	}
```
