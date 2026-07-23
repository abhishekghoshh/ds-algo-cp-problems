# FlattenBinaryTreeToLinkedList

**Topic:** `binarytree` | **File:** `com/problems/binarytree/FlattenBinaryTreeToLinkedList.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/flatten-binary-tree-to-linked-list/1)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/flatten-binary-tree-to-linked-list_1112615)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=sWf7k1x9XR4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=39)
- [📄 takeUforward](https://takeuforward.org/data-structure/flatten-binary-tree-to-linked-list/)

## Approaches

This problem has **5** approaches, progressing from brute force to optimal:

### Approach 5 — Optimal

Morris traversal

```java
private static void type5() {
		TNode root = withCount(15);
		flatten3(root);
		preOrder(root);
	}
	private static void flatten3(TNode root) {
		while (root != null) {
			if (root.left != null) {
				// we are going to the last node of the left subtree
				TNode last = root.left;
				while (last.right != null) last = last.right;
				// now we will manipulate the pointers, attaching the left node to the root right
				// and attaching the last node of the left subtree to the right node of the root
				last.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			root = root.right;
		}
	}
```

### Approach 4

This is inspired by the previous one, but here we will not use a global variable

```java
private static void type4() {
		TNode root = withCount(15);
		reversePreOrder2(root);
		preOrder(root);
	}
	public static void reversePreOrder2(TNode root) {
		if (root == null) return;
		reversePreOrder2(root.right);
		reversePreOrder2(root.left);
		TNode last = root.right;
		root.right = root.left;
		root.left = null;
		while (root.right != null)
			root = root.right;
		root.right = last;
	}
```

### Approach 3

This is a very optimized solution, but it is not intuitive type2 solution is best though it is using the stack check a striver solution using reverse pre-order

```java
private static void type3() {
		TNode root = withCount(15);
		flatten1(root);
		preOrder(root);
	}
	public static void flatten1(TNode root) {
		if (root == null) return;
		reversePreOrder(root);
	}
	private static void reversePreOrder(TNode root) {
		if (root == null) return;
		reversePreOrder(root.right);
		reversePreOrder(root.left);
		// this is exactly the previous solution
		// here we are doing the right first then left, then changing the pointers of root.
		// because first the right subtree will be flattened, then the left subtree, so pointer changing will be like
		// left subtree -> right subtree.
		// one the left subtree is completed then it will come to the root, the pointer changing will be like
		// root -> left subtree
		root.right = next;
		root.left = null;
		next = root;
	}
```

### Approach 2

We will use a global variable for same as a previous iterative preorder check striver solution

```java
private static void type2() {
		TNode root = withCount(15);
		flatten2(root);
		preOrder(root);
	}
	private static void flatten2(TNode root) {
		if (root == null) return;
		Stack<TNode> stack = new Stack<>();
		// pushing the root node
		stack.push(root);
		while (!stack.isEmpty()) {
			TNode node = stack.pop();
			// pushing the right node first, then the left node
			if (node.right != null) stack.push(node.right);
			if (node.left != null) stack.push(node.left);
			// now we are manipulation the pointer
			// stack will have the left node, so we will set the node's right to the stack top
			if (!stack.isEmpty()) node.right = stack.peek();
			// and we will set the left child to null
			node.left = null;
		}
	}
```

### Approach 1 — Brute Force

This is a very efficient solution TODO explain this in the interview our work is to put the left node to the right node and set the left node to null and the right node will be attached to the next node of the last node of root's left node so we will use a stack, and first add right node then left node, so the left key will be peeked/popped first so the the nodes will be stacked one by one, and if we think closely then we will understand that, only after completion of the entire left subtree tree the right node will be popped This is not most optimized, but it is also efficient do not try to explain this in the interview it returns a tuple of start and end node for a particular subtree

```java
private static void type1() {
		TNode root = withCount(15);
		flatten5(root);
		preOrder(root);
	}
	public static TNode[] flatten5(TNode root) {
		if (null == root) return null;
		TNode last = root;
		TNode[] left = flatten5(root.left);
		TNode[] right = flatten5(root.right);
		if (null != left) {
			root.left = null;
			root.right = left[0];
			last = left[1];
		}
		if (null != right) {
			last.right = right[0];
			last = right[1];
		}
		return new TNode[]{root, last};
	}
```
