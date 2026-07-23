# BinarySearchTreeIterator

**Topic:** `binarysearchtree`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/binary-search-tree-iterator/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=D2jMcmxU4bs&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=51)
- [▶ YouTube](https://www.youtube.com/watch?v=RXy5RzGF5wo)

## 📝 Problem Statement

Implement an iterator for BST in-order traversal.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

this is also very optimized approach this takes advantage of the iterative inorder traversal of a binary search tree. unlike the previous approach we we will explore the nodes while calling next here we are not storing the whole inorder traversal we are just storing the left most child in a sense we are storing only one full recursion depth into the stack on every next call we're just returning the stack top element because it is the most left element and in inorder we have to return the left mode element, and also we are checking if the node has any right node this approach goes to the left most node or the smallest node if you remember in the iterative inorder we stored the node in the answer list.

then we explored the nodes right subtree

**Space Complexity:** `O(log(n)`

```java
	private static void type2() {
		TNode root = TNode.makeBST(31);
		BstIterator2 bstIterator = new BstIterator2(root);
		while (bstIterator.hasNext()) {
			System.out.print(bstIterator.next() + " ");
		}
		System.out.println();
	}

	public static class BstIterator2 {
		Stack<TNode> stack;

		public BstIterator2(TNode root) {
			stack = new Stack<>();
			pushAllLeft(root);
		}

		// this approach goes to the left most node or the smallest node
		private void pushAllLeft(TNode root) {
			while (null != root) {
				stack.push(root);
				root = root.left;
			}
		}


		public int next() {
			TNode node = stack.pop();
			int data = node.val; // here we add the item to the inorder list
			// if you remember in the iterative inorder we stored the node in the answer list.
			// then we explored the nodes right subtree
			pushAllLeft(node.right);
			return data;
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}
	}
```

### Approach 1: 🔨 Brute Force

this is the simplest approach, explain this in the interview first save the inorder traversal of the tree in list then iterate over the list

**Space Complexity:** `O(n)`

```java
	private static void type1() {
		TNode root = TNode.makeBST(31);
		BstIterator1 bstIterator = new BstIterator1(root);
		while (bstIterator.hasNext()) {
			System.out.print(bstIterator.next() + " ");
		}
		System.out.println();
	}

	public static class BstIterator1 {
		private final List<Integer> inorder = new ArrayList<>();
		private int i = 0;
		private final int n;

		public BstIterator1(TNode root) {
			inorder(root);
			n = inorder.size();
		}

		private void inorder(TNode node) {
			if (node == null) return;
			inorder(node.left);
			inorder.add(node.data);
			inorder(node.right);
		}

		public int next() {
			return hasNext() ? inorder.get(i++) : -1;
		}

		public boolean hasNext() {
			return i < n;
		}
	}
}
```
