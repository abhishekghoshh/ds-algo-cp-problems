# BridgesInGraph

**Topic:** `graph`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/bridge-edge-in-graph/1)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=qrAub5z8FeA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=55)
- [📄 takeUforward](https://takeuforward.org/graph/bridges-in-graph-using-tarjans-algorithm-of-time-in-and-low-time-g-55/)

## 📝 Problem Statement

Given a Graph of V vertices and E edges and another edge(c - d), the task is

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

using the Tarjan's Algorithm other than a visited array, we will use two arrays more timeIn and low array. timeOfInsertion array is the first time when then we come to any node low is the lowest time of insertion we will always update the low[node] which indicates from which path we have come to this node if there are more than one way then low[end] will be minimized else it will have the same value as time+1 at first, we will initialize everything we will only check for the bridge if the node is not visited, after the dfs call we will check if the start and end can be a bridge we will check it with the low[end], after the dfs call, we will take the lowest value among start and end if the insertion time of the start is greater than the lowest of the end, then start--end is a bridge.

which means from the start, there is no other way that can minimize the low[end] if the node is visited, then there is another way to go from start to end, it can never be a bridge we will just take the lowest value among the start and the end

```java
	private static void type1() {
		int n = 5;
		List<List<Integer>> adj = List.of(
				List.of(1, 2, 3),
				List.of(0, 2),
				List.of(0, 1),
				List.of(0, 4),
				List.of(3)
		);
		// other than a visited array, we will use two arrays more
		boolean[] visited = new boolean[n];
		// timeIn and low array.
		// timeOfInsertion array is the first time when then we come to any node
		// low is the lowest time of insertion
		int[] timeOfInsertion = new int[n], low = new int[n];
		List<List<Integer>> bridges = new ArrayList<>();
		dfs(0, -1, visited, adj, timeOfInsertion, low, bridges);
		System.out.println(bridges);
	}

	private static int timer = 1;

	// we will always update the low[node]
	// which indicates from which path we have come to this node
	// if there are more than one way then low[end] will be minimized else it will have the same value as time+1
	private static void dfs(int start, int parent, boolean[] visited, List<List<Integer>> adj,
							int[] timeOfInsertion, int[] low, List<List<Integer>> bridges) {
		visited[start] = true;
		// at first, we will initialize everything
		timeOfInsertion[start] = low[start] = timer;
		timer++;
		for (int end : adj.get(start)) {
			if (end == parent) continue;
			// we will only check for the bridge if the node is not visited,
			// after the dfs call we will check if the start and end can be a bridge
			// we will check it with the low[end],
			if (!visited[end]) {
				dfs(end, start, visited, adj, timeOfInsertion, low, bridges);
				// after the dfs call, we will take the lowest value among start and end
				low[start] = Math.min(low[start], low[end]);
				// if the insertion time of the start is greater than the lowest of the end, then start--end is a bridge.
				// which means from the start, there is no other way that can minimize the low[end]
				if (timeOfInsertion[start] < low[end]) {
					bridges.add(List.of(end, start));
				}
			} else {
				// if the node is visited, then there is another way to go from start to end,
				// it can never be a bridge
				// we will just take the lowest value among the start and the end
				low[start] = Math.min(low[start], low[end]);
			}
		}
	}
}
```
