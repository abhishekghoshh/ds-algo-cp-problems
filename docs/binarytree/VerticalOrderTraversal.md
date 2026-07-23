# VerticalOrderTraversal

**Topic:** `binarytree` | **File:** `com/problems/binarytree/VerticalOrderTraversal.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/vertical-order-traversal_920533)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/vertical-order-traversal_3622711)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=q_a6lpbKJdw&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=22)
- [📄 takeUforward](https://takeuforward.org/data-structure/vertical-order-traversal-of-binary-tree/)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

This approach is also optimized it is using priority queue to store and retrieve level wise and column wise nodes

```java
private static void type3() {
		TNode root = TNode.withNodes(1, 2, 3, 4, 6, 5, 7);
		List<List<Integer>> result = new ArrayList<>();
		PriorityQueue<Point> pq = new PriorityQueue<>();
		dfs(root, pq, 0, 0);
		while (!pq.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			Point top = pq.poll();
			list.add(top.data);
			while (!pq.isEmpty() && pq.peek().col == top.col)
				list.add(pq.poll().data);
			result.add(list);
		}
		System.out.println(result);
	}
```

### Approach 2

Improved approach

```java
private static void type2() {
		TNode root = TNode.withNodes(1, 2, 3, 4, 6, 5, 7);
		Map<Integer, List<Pair>> map = new HashMap<>();
		verticalTraversal2(root, map, 0, 0);
		List<List<Integer>> answer = new ArrayList<>();
		// we have to add this condition as per the question
		for (int axis = min; axis <= max; axis++) {
			List<Pair> pairs = map.get(axis);
			Collections.sort(pairs);
			List<Integer> list = new ArrayList<>();
			for (Pair p : pairs) list.add(p.val);
			answer.add(list);
		}
		System.out.println(answer);
	}
	private static void verticalTraversal2(TNode root, Map<Integer, List<Pair>> map, int axis, int level) {
		if (null == root) return;
		if (axis > max) max = axis;
		if (axis < min) min = axis;
		if (!map.containsKey(axis)) map.put(axis, new ArrayList<>());
		map.get(axis).add(new Pair(level, root.data));
		verticalTraversal2(root.left, map, axis - 1, level + 1);
		verticalTraversal2(root.right, map, axis + 1, level + 1);
	}
```

### Approach 1 — Brute Force

We will do any dfs traversal and also keep track of the level and axis. And based on that, we will store it in a map, and at last we will sort it and store it in the final answer

```java
private static void type1() {
		TNode root = TNode.withNodes(1, 2, 3, 4, 6, 5, 7);
		Map<Integer, List<Pair>> map = new HashMap<>();
		verticalTraversal1(root, map, 0, 0);
		int min = Integer.MAX_VALUE;
		for (int key : map.keySet())
			if (min > key) min = key;
		List<List<Integer>> answer = new ArrayList<>();
		while (map.containsKey(min)) {
			List<Pair> pairs = map.get(min);
			Collections.sort(pairs);
			List<Integer> list = new ArrayList<>();
			for (Pair p : pairs) list.add(p.val);
			answer.add(list);
			min++;
		}
		System.out.println(answer);
	}
	private static void verticalTraversal1(TNode root, Map<Integer, List<Pair>> map, int axis, int level) {
		if (null == root) return;
		if (!map.containsKey(axis)) map.put(axis, new ArrayList<>());
		map.get(axis).add(new Pair(level, root.data));
		verticalTraversal1(root.left, map, axis - 1, level + 1);
		verticalTraversal1(root.right, map, axis + 1, level + 1);
	}
```
