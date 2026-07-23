# ConnectedComponents

**Topic:** `graph` | **File:** `com/problems/graph/ConnectedComponents.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/number-of-provinces/)
- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/number-of-provinces/1)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/find-the-number-of-states_1377943)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=lea-Wl_uWXY)
- [▶ YouTube](https://www.youtube.com/watch?v=ACzkVtewUYA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=7)
- [📄 takeUforward](https://takeuforward.org/graph/connected-components-in-graphs/)
- [📄 takeUforward](https://takeuforward.org/data-structure/number-of-provinces/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

We will do bfs/dfs if all the nodes are connected, then after one traversal all the nodes will be visited. so we will start dfs with one node and check all the remaining nodes if any node is not visited means that node is not connected we will increment the counter

```java
private static void type2() {
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		adjList.add(new ArrayList<>(List.of(2, 3, 1)));
		adjList.add(new ArrayList<>(List.of(0)));
		adjList.add(new ArrayList<>(List.of(0, 4)));
		adjList.add(new ArrayList<>(List.of(0)));
		adjList.add(new ArrayList<>(List.of(2)));
		int v = 5;

		boolean[] visited = new boolean[v];
		int component = 0;
		for (int start = 0; start < v; start++) {
			// start the dfs if the node is not visited
			if (!visited[start]) {
				component++;
				dfs(start, visited, adjList);
			}
		}
		System.out.println(component);
	}
	private static void dfs(int start, boolean[] visited,
							ArrayList<ArrayList<Integer>> adjList) {
		// we will set the visited true when operating on it
		visited[start] = true;
		for (int end : adjList.get(start))
			if (!visited[end])
				dfs(end, visited, adjList);
	}
```

### Approach 1 — Brute Force

We will do bfs/dfs if all the nodes are connected, then after one traversal all the nodes will be visited. so we will start dfs with one node and check all the remaining nodes if any node is not visited means that node is not connected we will increment the counter

```java
private static void type1() {
		int[][] isConnected = {
				{1, 1, 0},
				{1, 1, 0},
				{0, 0, 1}
		};

		int v = isConnected.length;
		boolean[] visited = new boolean[v];
		int component = 0;
		for (int start = 0; start < v; start++) {
			// start the dfs if the node is not visited
			if (!visited[start]) {
				component++;
				dfs(start, visited, v, isConnected);
			}
		}
		System.out.println(component);
	}
	private static void dfs(int start, boolean[] visited,
							int v, int[][] isConnected) {
		visited[start] = true;
		for (int end = 0; end < v; end++)
			if (start != end && isConnected[start][end] == 1 && !visited[end])
				dfs(end, visited, v, isConnected);
	}
```
