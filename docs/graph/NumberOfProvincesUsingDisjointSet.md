# NumberOfProvincesUsingDisjointSet

**Topic:** `graph` | **File:** `com/problems/graph/NumberOfProvincesUsingDisjointSet.java`

## Problem Links

- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/number-of-provinces/1)
- [📄 LeetCode](https://leetcode.com/problems/number-of-provinces/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=ZGr5nX-Gi6Y&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=48)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 1 — Brute Force

We have already solved this problem using BFS/DFS it is the same problem as find the number of components we will do it using the DisjointSet here we can also use a Disjoint set for this

```java
private static void type1() {
		int v = 3;
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		matrix.add(new ArrayList<>(List.of(1, 0, 1)));
		matrix.add(new ArrayList<>(List.of(0, 1, 0)));
		matrix.add(new ArrayList<>(List.of(1, 0, 1)));

		int[] rank = new int[v];
		int[] parent = new int[v];
		for (int i = 0; i < v; i++) {
			rank[i] = 0;
			parent[i] = i;
		}
		// we will traverse the entire matrix if [i,j] is 1 then i and j is connected.
		// if i and j is connected and if they are currently in the different component, then
		// we will put them into the same component
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				// if i and j same that means it is the same node
				if (i == j || matrix.get(i).get(j) == 0) continue;
				// if both are in different component, then we will unify them
				if (find(parent, i) != find(parent, j)) {
					union(parent, rank, i, j);
				}
			}
		}

		int numberOfProvinces = 0;
		// number of provinces equals to number of unique parents
		for (int i = 0; i < v; i++)
			if (i == parent[i]) numberOfProvinces++;

		System.out.println(numberOfProvinces);
	}
	private static void union(int[] parent, int[] rank, int u, int v) {
		int baseParentU = find(parent, u);
		int baseParentV = find(parent, v);
		if (rank[baseParentU] < rank[baseParentV]) {
			parent[baseParentU] = baseParentV;
			rank[baseParentV]++;
		} else {
			parent[baseParentV] = baseParentU;
			rank[baseParentU]++;
		}
	}
	private static int find(int[] parent, int node) {
		// src == parent[src] means parent of the node
		if (node == parent[node]) return node;
		int baseParent = find(parent, parent[node]);
		parent[node] = baseParent;
		return baseParent;
	}
```

### Approach 0

We will use dfs from every unvisited node

```java
private static void type0() {
		int v = 3;
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		matrix.add(new ArrayList<>(List.of(1, 0, 1)));
		matrix.add(new ArrayList<>(List.of(0, 1, 0)));
		matrix.add(new ArrayList<>(List.of(1, 0, 1)));
		// first, we will convert matrix to the adjacency list
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < v; i++) adj.add(new ArrayList<>());
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				if (i == j) continue;
				if (matrix.get(i).get(j) == 1)
					adj.get(i).add(j);
			}
		}
		// we will also use a visited array to store the visited cells
		boolean[] visited = new boolean[v];
		int component = 0;
		// from every unvisited node will start the DFS
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				dfs(i, visited, adj);
				component++;
			}
		}
		System.out.println(component);
	}
	private static void dfs(int src, boolean[] visited, List<List<Integer>> adj) {
		// we will set the visited true when operating on it
		visited[src] = true;
		for (int end : adj.get(src)) {
			// if the adjacent node of the source is unvisited, then we will start the bfs
			if (!visited[end]) dfs(end, visited, adj);
		}
	}
```
