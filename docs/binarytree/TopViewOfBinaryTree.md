# TopViewOfBinaryTree

**Topic:** `binarytree`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1)
- [📄 Coding Ninjas](https://www.codingninjas.com/codestudio/problems/799401)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/top-view-of-binary-tree_799401)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=Et9OCDNvJ78&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=23)
- [📄 takeUforward](https://takeuforward.org/data-structure/top-view-of-a-binary-tree/)

## 📝 Problem Statement

You are given the root of a binary tree, and your task is to return its top view. The top view of a binary tree is the set of nodes visible when the tree is viewed from the top.
Note:

Return the nodes from the leftmost node to the rightmost node.
If

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

Same as type2 just we are using the level wise separation of the traversal. Using iteration using bfs or level wise traversal as we are doing the level wise, so we are sure that the top most level is traversed first if the axis is not present, then only we will add that as we are going, level wise top nodes will come before the bottom nodes.

so if the axis is already present in the map, then we do not need to add the node again find the min axis and add the answer from the axis

```java
	private static void type3() {
		TNode root = TNode.withCount(15);
		List<Integer> answer = new ArrayList<>();
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(root, 0));
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Pair pair = queue.poll();
				int axis = pair.axis;
				TNode node = pair.node;
				// if the axis is not present, then only we will add that
				// as we are going, level wise
				// top nodes will come before the bottom nodes.
				// so if the axis is already present in the map, then we do not need to add the node again
				if (!map.containsKey(axis)) map.put(axis, node.data);
				if (node.left != null) queue.add(new Pair(node.left, axis - 1));
				if (node.right != null) queue.add(new Pair(node.right, axis + 1));
			}
		}
		// find the min axis and add the answer from the axis
		int minAxis = Integer.MAX_VALUE;
		for (int axis : map.keySet())
			if (minAxis > axis) minAxis = axis;

		while (map.containsKey(minAxis))
			answer.add(map.get(minAxis++));
		System.out.println(answer);
	}
```

### Approach 2

Using iteration using bfs or level wise traversal as we are doing the level wise, so we are sure that the top most level is traversed first we will go level wise if the axis is not present, then only we will add that as we are going, level wise top nodes will come before the bottom nodes.

so if the axis is already present in the map, then we do not need to add the node again find the min axis and add the answer from the axis

```java
	private static void type2() {
		TNode root = TNode.withCount(15);
		List<Integer> answer = new ArrayList<>();
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(root, 0));
		// we will go level wise
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			int axis = pair.axis;
			TNode node = pair.node;
			// if the axis is not present, then only we will add that
			// as we are going, level wise
			// top nodes will come before the bottom nodes.
			// so if the axis is already present in the map, then we do not need to add the node again
			if (!map.containsKey(axis)) map.put(axis, node.data);
			if (node.left != null) queue.add(new Pair(node.left, axis - 1));
			if (node.right != null) queue.add(new Pair(node.right, axis + 1));
		}
		// find the min axis and add the answer from the axis
		int minAxis = Integer.MAX_VALUE;
		for (int axis : map.keySet())
			if (minAxis > axis) minAxis = axis;

		while (map.containsKey(minAxis))
			answer.add(map.get(minAxis++));
		System.out.println(answer);
	}

	public static class Pair {
		public int axis;
		public TNode node;

		public Pair(TNode node, int axis) {
			this.axis = axis;
			this.node = node;
		}
	}
```

### Approach 1: 🔨 Brute Force

Using recursion Using DFS traversal find the min axis and add the answer from the axis if axis is not present then we can directly store the value else we have checked that at which level the node was stored

```java
	private static void type1() {
		TNode root = TNode.withCount(15);
		Map<Integer, Pair2> map = new HashMap<>();
		traverse(root, map, 0, 0);
		List<Integer> answer = new ArrayList<>();

		// find the min axis and add the answer from the axis
		int minAxis = Integer.MAX_VALUE;
		for (int axis : map.keySet())
			if (minAxis > axis) minAxis = axis;
		while (map.containsKey(minAxis))
			answer.add(map.get(minAxis++).val);
		System.out.println(answer);

	}

	private static void traverse(TNode root, Map<Integer, Pair2> map, int axis, int level) {
		if (null == root) return;
		// if axis is not present then we can directly store the value else we have
		// checked that at which level the node was stored
		if (!map.containsKey(axis) || (map.containsKey(axis) && map.get(axis).level > level))
			map.put(axis, new Pair2(root.data, level));
		traverse(root.left, map, axis - 1, level + 1);
		traverse(root.right, map, axis + 1, level + 1);
	}

	public static class Pair2 {
		public int level;
		public int val;

		public Pair2(int val, int level) {
			this.level = level;
			this.val = val;
		}
	}
}
```
