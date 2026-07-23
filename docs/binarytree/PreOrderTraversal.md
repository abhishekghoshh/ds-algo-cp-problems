# PreOrderTraversal

**Topic:** `binarytree`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/binary-tree-preorder-traversal/description/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/preorder-binary-tree_5948)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=RlUu72JrOCQ&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=6)
- [▶ YouTube](https://www.youtube.com/watch?v=Bfqd8BsPVuw&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=10)
- [▶ YouTube](https://www.youtube.com/watch?v=afTpieEZXck)
- [📄 takeUforward](https://takeuforward.org/data-structure/preorder-traversal-of-binary-tree/)

## 📝 Problem Statement

Return the preorder traversal of a binary tree.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

it is quite simple because we have to print root -> left -> right using iteration we will add the root here, then traverse its left and right We are pushing the right first then left because on the next iteration left will be popped first

```java
	private static void type2() {
		TNode root = TNode.withCount(7);
		List<Integer> preOrder = preOrder(root);
		print(root);
		print(preOrder);
	}

	private static List<Integer> preOrder(TNode root) {
		List<Integer> preOrder = new ArrayList<>();
		Stack<TNode> stack = new Stack<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TNode node = stack.pop();
			// we will add the root here, then traverse its left and right
			preOrder.add(node.data);
			// We are pushing the right first then left because
			// on the next iteration left will be popped first
			if (null != node.right) stack.push(node.right);
			if (null != node.left) stack.push(node.left);
		}
		return preOrder;
	}
```

### Approach 1: 🔨 Brute Force

With recursion

```java
	private static void type1() {
		TNode root = TNode.withCount(7);
		List<Integer> preOrder = new ArrayList<>();
		preOrder(root, preOrder);
		print(root);
		print(preOrder);
	}

	private static void preOrder(TNode root, List<Integer> preOrder) {
		if (null == root) return;
		preOrder.add(root.data);
		preOrder(root.left, preOrder);
		preOrder(root.right, preOrder);
	}
}
```
