# LevelWiseOrderTraversal

**Topic:** `binarytree` | **File:** `com/problems/binarytree/LevelWiseOrderTraversal.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/binary-tree-level-order-traversal/description/)
- [📄 LeetCode](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)
- [📄 NeetCode](https://neetcode.io/problems/level-order-traversal-of-binary-tree)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/zigzag-binary-tree-traversal_920532)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=EoAsWbO7sqg&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=9)
- [▶ YouTube](https://www.youtube.com/watch?v=6ZnyEApgFYg)
- [📄 takeUforward](https://takeuforward.org/data-structure/level-order-traversal-of-a-binary-tree/)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Recursively

```java
private static void type3() {
		TNode root = TNode.withCount(19);
		List<List<Integer>> levelWiseList = levelOrder3(root);
		System.out.println(levelWiseList);
	}
	private static List<List<Integer>> levelOrder3(TNode root) {
		List<List<Integer>> list = new ArrayList<>();
		traverse(root, 0, list);
		return list;
	}
	public static void traverse(TNode root, int level, List<List<Integer>> list) {
		if (root == null) return;
		// as we have used 0 index so if the level is size then we need another level
		if (level == list.size())
			list.add(new ArrayList<>());
		// add the root to its level
		list.get(level).add(root.data);
		// traverse the left and right child with level + 1
		traverse(root.left, level + 1, list);
		traverse(root.right, level + 1, list);
	}
```

### Approach 2

We will also track a third variable to keep track of the current level first it will go to the leftest node and while traversal. It will add the list one by one, and in later part while traversing the right child, it will get the level wise list and add the current node into that iteratively

```java
private static void type2() {
		TNode root = TNode.withCount(19);
		List<List<Integer>> answer = levelOrder2(root);
		System.out.println(answer);
	}
	private static List<List<Integer>> levelOrder2(TNode root) {
		Queue<TNode> queue = new LinkedList<>();
		List<List<Integer>> answer = new ArrayList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			// getting the current level size of the queue
			int size = queue.size();
			List<Integer> level = new ArrayList<>();
			// now add all the level data to list and add next level in the queue
			for (int i = 0; i < size; i++) {
				TNode node = queue.poll();
				level.add(node.data);
				if (null != node.left) queue.offer(node.left);
				if (null != node.right) queue.offer(node.right);
			}
			answer.add(level);
		}
		return answer;
	}
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
		TNode root = TNode.withCount(19);
		List<Integer> answer = levelOrder1(root);
		System.out.println(answer);
	}
	private static List<Integer> levelOrder1(TNode root) {
		Queue<TNode> queue = new LinkedList<>();
		queue.offer(root);
		List<Integer> answer = new ArrayList<>();
		// polling from first every time
		// and will add its left and right child
		// so same level child will be in the there side by side
		while (!queue.isEmpty()) {
			TNode node = queue.poll();
			answer.add(node.data);
			if (null != node.left) queue.offer(node.left);
			if (null != node.right) queue.offer(node.right);
		}
		return answer;
	}
```
