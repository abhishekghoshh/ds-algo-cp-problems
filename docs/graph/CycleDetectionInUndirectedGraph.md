# CycleDetectionInUndirectedGraph

**Topic:** `graph`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/detect-cycle-in-an-undirected-graph-_758967)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1)
- [📄 LeetCode](https://leetcode.com/problems/course-schedule/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=BPlrALf1LDU&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=11)
- [📄 takeUforward](https://takeuforward.org/data-structure/detect-cycle-in-an-undirected-graph-using-bfs/)
- [▶ YouTube](https://www.youtube.com/watch?v=zQ3zgFypzX4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=12)
- [📄 takeUforward](https://takeuforward.org/data-structure/detect-cycle-in-an-undirected-graph-using-dfs/)

## 📝 Problem Statement

we just have to make a graph of courses before hand

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

using dfs but recursion stack for every node we will start the hasCycle method if it is not visited if hasCycle is true then we will return true as we traverse all adjacent nodes. In the case of connected components of a graph, it will take another O(N) time.

It means the vertex is visited. However, it's not the parent of the current node. [the parent node was visited in the previous recursion], so it means it is visited by some other node, but again we are trying to visit this node that makes this a loop if the adjacent point is not visited, then we will start dfs from this node


```java
	private static void type3() {
		List<List<Integer>> adjacencyList = adjacencyList(
				new int[][]{
						{1},
						{0, 2, 4},
						{1, 3},
						{2, 4},
						{1, 3}
				}
		);
		int v = 5;
		boolean hasCycle = detectCycle3(v, adjacencyList);
		System.out.println(hasCycle);
	}

	private static boolean detectCycle3(int v, List<List<Integer>> adjacencyList) {
		boolean[] visited = new boolean[v];
		// for every node we will start the hasCycle method if it is not visited
		// if hasCycle is true then we will return true
		for (int node = 0; node < v; node++)
			if (!visited[node] && hasCycle3(node, -1, adjacencyList, visited))
				return true;
		return false;
	}

	// Time Complexity: O(N + 2E) + O(N), Where N = Nodes, 2E is for total degrees
	// as we traverse all adjacent nodes. In the case of connected components of a
	// graph, it will take another O(N) time.
	// Space Complexity: O(N) + O(N) ~ O(N), Space for recursive stack space and visit the array.
	private static boolean hasCycle3(int start, int parent, List<List<Integer>> adjacencyList, boolean[] visited) {
		visited[start] = true;
		for (int end : adjacencyList.get(start)) {
			// It means the vertex is visited.
			// However, it's not the parent of the current node.
			// [the parent node was visited in the previous recursion],
			// so it means it is visited by some other node,
			// but again we are trying to visit this node that makes this a loop
			if (end != parent && visited[end]) return true;
			// if the adjacent point is not visited, then we will start dfs from this node
			if (!visited[end]) return hasCycle3(end, start, adjacencyList, visited);
		}
		return false;
	}
```

### Approach 2

using DFS for every node we will start the hasCycle method if it is not visited if hasCycle is true then we will return true as we traverse all adjacent nodes. In the case of connected components of a graph, it will take another O(N) time. we will store the pair of current node and its parent node as we are using dfs, we will be adding the vertices in the reverse order It means the vertex is visited.

However, it's not the parent of the current node. [the parent node was visited in the previous loop], so it means it is visited by some other node, but again we are trying to visit this node that makes this a loop if the adjacent point is not visited, then we are push it the stack, and setting visited to true


```java
	private static void type2() {
		List<List<Integer>> adjacencyList = adjacencyList(
				new int[][]{
						{1},
						{0, 2, 4},
						{1, 3},
						{2, 4},
						{1, 3}
				}
		);
		int v = 5;
		boolean hasCycle = detectCycle2(v, adjacencyList);
		System.out.println(hasCycle);
	}

	private static boolean detectCycle2(int v, List<List<Integer>> adjacencyList) {
		boolean[] visited = new boolean[v];
		// for every node we will start the hasCycle method if it is not visited
		// if hasCycle is true then we will return true
		for (int node = 0; node < v; node++)
			if (!visited[node] && hasCycle2(node, adjacencyList, visited))
				return true;
		return false;
	}

	// Time Complexity: O(N + 2E) + O(N), Where N = Nodes, 2E is for total degrees
	// as we traverse all adjacent nodes. In the case of connected components of a
	// graph, it will take another O(N) time.
	// Space Complexity: O(N) + O(N) ~ O(N), Space for recursive stack space and visit the array.
	private static boolean hasCycle2(int node, List<List<Integer>> adjacencyList, boolean[] visited) {
		Stack<int[]> stack = new Stack<>();
		// we will store the pair of current node and its parent node
		stack.add(new int[]{node, -1});

		while (!stack.isEmpty()) {
			int[] pair = stack.pop();
			int start = pair[0];
			int parent = pair[1];
			visited[start] = true;

			List<Integer> vertices = adjacencyList.get(start);
			// as we are using dfs, we will be adding the vertices in the reverse order
			for (int i = vertices.size() - 1; i >= 0; i--) {
				int end = vertices.get(i);
				// It means the vertex is visited.
				// However, it's not the parent of the current node.
				// [the parent node was visited in the previous loop],
				// so it means it is visited by some other node,
				// but again we are trying to visit this node that makes this a loop
				if (end != parent && visited[end]) return true;
				// if the adjacent point is not visited, then we are push it the stack, and setting visited to true
				if (!visited[end]) stack.push(new int[]{end, start});
			}
		}
		return false;
	}
```

### Approach 1: 🔨 Brute Force

using BFS for every node we will start the hasCycle method if it is not visited if hasCycle is true then we will return true as we traverse all adjacent nodes. In the case of connected components of a graph, it will take another O(N) time. we will store the pair of current node and its parent node we will start BFS traversal It means the vertex is visited.

However, it's not the parent of the current node. [the parent node was visited in the previous loop], so it means it is visited by some other node, but again we are trying to visit this node that makes this a loop if the adjacent point is not visited, then we are adding it the queue, and setting visited to true


```java
	private static void type1() {
		List<List<Integer>> adjacencyList = adjacencyList(
				new int[][]{
						{1},
						{0, 2, 4},
						{1, 3},
						{2, 4},
						{1, 3}
				}
		);
		int v = 5;
		boolean hasCycle = detectCycle1(v, adjacencyList);
		System.out.println(hasCycle);
	}

	static boolean detectCycle1(int v, List<List<Integer>> adjacencyList) {
		boolean[] visited = new boolean[v];
		// for every node we will start the hasCycle method if it is not visited
		// if hasCycle is true then we will return true
		for (int node = 0; node < v; node++)
			if (!visited[node] && hasCycle1(node, adjacencyList, visited))
				return true;
		return false;
	}

	// Time Complexity: O(N + 2E) + O(N), Where N = Nodes, 2E is for total degrees
	// as we traverse all adjacent nodes.
	// In the case of connected components of a graph, it will take another O(N) time.
	// Space Complexity: O(N) + O(N) ~ O(N), Space for queue data structure and visit the array.
	private static boolean hasCycle1(int node, List<List<Integer>> adjacencyList, boolean[] visited) {
		Queue<int[]> queue = new LinkedList<>();
		// we will store the pair of current node and its parent node
		queue.add(new int[]{node, -1});
		visited[node] = true;
		// we will start BFS traversal
		while (!queue.isEmpty()) {
			int[] pair = queue.poll();
			int start = pair[0];
			int parent = pair[1];
			for (int end : adjacencyList.get(start)) {
				// It means the vertex is visited.
				// However, it's not the parent of the current node.
				// [the parent node was visited in the previous loop],
				// so it means it is visited by some other node,
				// but again we are trying to visit this node that makes this a loop
				if (end != parent && visited[end]) return true;
				// if the adjacent point is not visited, then we are adding it the queue, and setting visited to true
				if (!visited[end]) {
					visited[end] = true;
					queue.offer(new int[]{end, start});
				}
			}
		}
		return false;
	}

}
```
