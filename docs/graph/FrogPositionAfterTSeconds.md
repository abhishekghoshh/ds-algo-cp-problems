# FrogPositionAfterTSeconds

**Topic:** `graph`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/frog-position-after-t-seconds/)

## 📝 Problem Statement

Find the probability that a frog is at a given vertex after t seconds.

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

```java
	private static void type1() {
		int n = 7;
		int[][] edges = {{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}};
		int t = 2;
		int target = 4;

		List<Integer>[] graph = new List[n + 1];
		for (int[] edge : edges) {
			int start = edge[0], end = edge[1];
			if (graph[start] == null) graph[start] = new ArrayList<>();
			graph[start].add(end);
			if (graph[end] == null) graph[end] = new ArrayList<>();
			graph[end].add(start);
		}
		for (List<Integer> edge : graph) System.out.println(edge);
		boolean[] visited = new boolean[n + 1];
		double answer = traverse(1, t, target, graph, visited);
		System.out.println(answer);
	}

	private static double traverse(int curr, int t, int target, List<Integer>[] graph, boolean[] visited) {
		if (t < 0) return 0;
		if (curr == target) return 1;
		if (visited[curr] || graph[curr] == null) return 0;
		System.out.println("started " + curr);
		visited[curr] = true;
		double probability = ((double) 1) / graph[curr].size();
		double minProbability = 2;
		for (int end : graph[curr]) {
			double totalProbability = traverse(end, t - 1, target, graph, visited);
			if (totalProbability > 0)
				minProbability = Math.min(minProbability, totalProbability);
		}
		visited[curr] = false;
		System.out.println("ended " + curr );
		if (minProbability != 2) return minProbability * probability;
		return 0;
	}

}
```
