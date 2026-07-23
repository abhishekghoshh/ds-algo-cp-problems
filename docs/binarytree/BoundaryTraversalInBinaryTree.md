# BoundaryTraversalInBinaryTree

**Topic:** `binarytree` | **File:** `com/problems/binarytree/BoundaryTraversalInBinaryTree.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/boundary-of-binary-tree/#)
- [📄 Coding Ninjas](https://www.codingninjas.com/codestudio/problems/boundary-traversal_790725)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/boundary-traversal-of-binary-tree_790725)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=0ca1nvR0be4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=21)
- [📄 takeUforward](https://takeuforward.org/data-structure/boundary-traversal-of-a-binary-tree/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Iterative way

```java
private static void type2() {
		TNode root = TNode.withCount(21);
		List<Integer> boundary = new ArrayList<>();
		if (!isLeaf(root)) boundary.add(root.data);
		addLeftBoundary(root, boundary);
		addLeaves(root, boundary);
		addRightBoundary(root, boundary);
		System.out.println(boundary);
	}
```

### Approach 1 — Brute Force

Recursive approach

```java
private static void type1() {
		TNode root = TNode.withCount(21);
		List<Integer> answer = new ArrayList<>();
		leftView(root, answer);
		bottomView(root, answer);
		// as for right view it will be reversed, so we are creating a stack
		// later we will iterate through it and add the node in the final array
		Stack<Integer> stack = new Stack<>();
		rightView(root, stack);
		// as we don't need the root, we will not iterate till empty
		// we will loop until the size is 1
		while (stack.size() > 1) answer.add(stack.pop());
		System.out.println(answer);
	}
	private static void leftView(TNode root, List<Integer> answer) {
		// we are also not taking the leaf node as it will be added in the bottom view
		if (null == root || isLeaf(root)) return;
		answer.add(root.data);
		if (null != root.left) leftView(root.left, answer);
		else leftView(root.right, answer);
	}
	private static void bottomView(TNode root, List<Integer> answer) {
		if (null == root) return;
		// we are only adding for the leaf node
		if (isLeaf(root)) {
			answer.add(root.data);
			return;
		}
		bottomView(root.left, answer);
		bottomView(root.right, answer);
	}
	private static void rightView(TNode root, Stack<Integer> stack) {
		// we are also not taking the leaf node as it will be added in the bottom view
		if (null == root || isLeaf(root)) return;
		stack.push(root.data);
		if (null != root.right) rightView(root.right, stack);
		else rightView(root.left, stack);
	}
```
