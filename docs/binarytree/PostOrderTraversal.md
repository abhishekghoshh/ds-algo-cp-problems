# PostOrderTraversal

**Topic:** `binarytree`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/binary-tree-postorder-traversal/description/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/postorder-traversal_2035933)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=COQOU6klsBg&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=8)
- [▶ YouTube](https://www.youtube.com/watch?v=2YBhNLodD8Q&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=12)
- [▶ YouTube](https://www.youtube.com/watch?v=QhszUQhGGlA)
- [📄 takeUforward](https://takeuforward.org/data-structure/post-order-traversal-of-binary-tree/)

## 📝 Problem Statement

Return the postorder traversal of a binary tree.

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

best solution, explain this in the interview with iteration using 1 stack, we can use the final answer list as a stack, and at last we can reverse it if we see, here we are first printing root -> right -> left adding the root as we will first process the right, so we will add the left first so in the next iteration the right child will come first [the tree will be root -> right -> left] the current order is root -> right -> left, so if we just reverse it then, we will get left -> right -> root

```java
	private static void type3() {
		TNode root = TNode.withCount(7);
		List<Integer> postOrder = postOrder3(root);
		print(root);
		print(postOrder);
	}

	private static List<Integer> postOrder3(TNode root) {
		List<Integer> postOrder = new ArrayList<>();
		if (null == root) return postOrder;
		Stack<TNode> stack = new Stack<>();
		stack.push(root);
		// if we see, here we are first printing root -> right -> left
		while (!stack.isEmpty()) {
			TNode node = stack.pop();
			// adding the root
			postOrder.add(node.data);
			// as we will first process the right, so we will add the left first
			// so in the next iteration the right child will come first [the tree will be root -> right -> left]
			if (null != node.left) stack.push(node.left);
			if (null != node.right) stack.push(node.right);
		}
		// the current order is root -> right -> left,
		// so if we just reverse it then, we will get left -> right -> root
		Collections.reverse(postOrder);
		return postOrder;
	}
```

### Approach 2

with iteration using 2 stacks ultimately these nodes will be again added in a stack so here we are add it first left then right

```java
	private static void type2() {
		TNode root = TNode.withCount(7);
		List<Integer> postOrder = postOrder2(root);
		print(root);
		print(postOrder);
	}

	private static List<Integer> postOrder2(TNode root) {
		List<Integer> postOrder = new ArrayList<>();
		if (null == root) return postOrder;
		Stack<TNode> s1 = new Stack<>();
		Stack<TNode> s2 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty()) {
			root = s1.pop();
			s2.push(root);
			// ultimately these nodes will be again added in a stack so here we are add it first left then right
			if (root.left != null) s1.push(root.left);
			if (root.right != null) s1.push(root.right);
		}
		while (!s2.isEmpty()) {
			postOrder.add(s2.pop().data);
		}
		return postOrder;
	}
```

### Approach 1: 🔨 Brute Force

With recursion left -> right -> root

```java
	private static void type1() {
		TNode root = TNode.withCount(7);
		List<Integer> postOrder = new ArrayList<>();
		postOrder1(root, postOrder);
		print(root);
		print(postOrder);
	}

	// left -> right -> root
	private static void postOrder1(TNode root, List<Integer> postOrder) {
		if (null == root) return;
		postOrder1(root.left, postOrder);
		postOrder1(root.right, postOrder);
		postOrder.add(root.data);
	}
}
```
