# InOrderTraversal

**Topic:** `binarytree` | **File:** `com/problems/binarytree/InOrderTraversal.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/binary-tree-inorder-traversal/description/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/inorder-traversal_3839605)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=Z_NEgBgbRVI&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=7)
- [▶ YouTube](https://www.youtube.com/watch?v=lxTGsVXjwvM&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=11)
- [▶ YouTube](https://www.youtube.com/watch?v=g_S5WuasWUE)
- [📄 takeUforward](https://takeuforward.org/data-structure/inorder-traversal-of-binary-tree/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Check it one more time properly here the first we need to go left, then we need to print root then the right subtree with iteration using stack

```java
private static void type2() {
		TNode root = TNode.withCount(7);
		List<Integer> inOrder = inOrder(root);
		print(root);
		print(inOrder);
	}
	private static List<Integer> inOrder(TNode root) {
		Stack<TNode> stack = new Stack<>();
		List<Integer> inOrder = new ArrayList<>();
		TNode node = root;
		// observation: if the node is null that might be the ending of a leaf node and parent nodes might be in the stack
		while (null != node || !stack.isEmpty()) {
			// we are going as left side as possible
			// because in the recursion also we went as left side as possible
			while (null != node) {
				stack.push(node);
				node = node.left;
			}
			// at this point, the node is null; now we backtrack from the stack.
			// current stack[top] will have the left node, so for this node null will be it's left child
			// it will be the root, and if it is having any right child, then we will explore that also
			node = stack.pop();
			// we will store the left most node
			inOrder.add(node.data);
			// the left node may or may not have any right node
			node = node.right;
			// if it has any right node, then in the next iteration it will again go till its
			// left furthest node
		}
		return inOrder;
	}
```

### Approach 1 — Brute Force

With recursion

```java
private static void type1() {
		TNode root = TNode.withCount(7);
		List<Integer> inOrder = new ArrayList<>();
		inOrder(root, inOrder);
		print(root);
		print(inOrder);
	}
	private static void inOrder(TNode root, List<Integer> answer) {
		if (null == root) return;
		inOrder(root.left, answer);
		answer.add(root.data);
		inOrder(root.right, answer);
	}
```
