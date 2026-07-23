# BinaryTreeTraversal

**Topic:** `binarytree` | **File:** `com/problems/binarytree/BinaryTreeTraversal.java`

## Problem Links

- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/preorder-traversal/1)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=jmy0LaGET1I&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=5)
- [📄 takeUforward](https://takeuforward.org/binary-tree/binary-tree-traversal-inorder-preorder-postorder/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 4

Level order traversal

```java
private static void type4() {
		TNode root = TNode.withCount(10);
		List<List<Integer>> answer = levelOrder(root);
		System.out.println(answer);
	}
	public static List<List<Integer>> levelOrder(TNode root) {
		List<List<Integer>> wrapList = new LinkedList<>();
		if (root == null) return wrapList;
		Queue<TNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelNum = queue.size();
			List<Integer> subList = new LinkedList<>();
			for (int i = 0; i < levelNum; i++) {
				if (queue.peek().left != null)
					queue.offer(queue.peek().left);
				if (queue.peek().right != null)
					queue.offer(queue.peek().right);
				subList.add(queue.poll().data);
			}
			wrapList.add(subList);
		}
		return wrapList;
	}
```

### Approach 1 — Brute Force

In order traversal Pre order traversal Post-order traversal

```java
private static void type1() {
		TNode root = TNode.withCount(10);
		List<Integer> inOrder = new ArrayList<>();
		inOrder(root, inOrder);
		List<Integer> preOrder = new ArrayList<>();
		preOrder(root, preOrder);
		List<Integer> postOrder = new ArrayList<>();
		postOrder(root, postOrder);

		PrintUtl.print(root);
		PrintUtl.print(inOrder, preOrder, postOrder);
	}
```
