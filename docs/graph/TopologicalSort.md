# TopologicalSort

**Topic:** `graph`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/topological-sort/1)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/topological-sorting_973003)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=5lZ0iJMrUMk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=21)
- [📄 takeUforward](https://takeuforward.org/data-structure/topological-sort-algorithm-dfs-g-21/)

## 📝 Problem Statement

Given a Directed Acyclic Graph (DAG) with V vertices and E edges, find any topological sorting of the graph.

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

check one more time if it still confuses you so we will call dfs and dfs will make sure that it will go to the last node, and while backtracking we are storing the nodes in a stack so the last node from which, there is no outgoing edge will be put in the stack first so if the edge is 1 -> 4 -> 3, and we are going from 1, then the stack will be like 1|4|3, now if we just pop and store in the array then we will find our simple Topo sort if the node is not visited, yet then we will start the dfs from the node at this point the starting nodes are in the top fo the stack intuition is if are doing dfs for a node n1 then all its adjacent nodes will be traversed first, then it will come to n1 the dfs call will go to the deepest node, it will only add node to the stack when there is no adjacent unvisited nodes calling the dfs if the adjacent node is not visited for start node either there is not any unvisited adjacent node or simply there is no adjacent node, so we can add it to the stack

```java
	private static void type1() {
		int v = 6;
		List<List<Integer>> adjacencyList = graphBuilder()
				.nodes(v)
				.start(0).end()
				.start(1).end()
				.start(2).end(3)
				.start(3).end(1)
				.start(4).end(0, 1)
				.start(5).end(0, 2)
				.buildList();
		GraphUtil.print(adjacencyList);

		boolean[] visited = new boolean[v];
		Stack<Integer> stack = new Stack<>();
		int[] answer = new int[v];

		// if the node is not visited, yet then we will start the dfs from the node
		for (int i = 0; i < v; i++)
			if (!visited[i]) dfs(i, visited, adjacencyList, stack);

		// at this point the starting nodes are in the top fo the stack
		int i = 0;
		while (!stack.isEmpty()) answer[i++] = stack.pop();
		print(answer);
	}

	// TODO intuition is if are doing dfs for a node n1 then all its adjacent
	//  nodes will be traversed first, then it will come to n1
	//  the dfs call will go to the deepest node, it will only add node to the stack when there is no
	//  adjacent unvisited nodes
	private static void dfs(int start, boolean[] visited,
							List<List<Integer>> adjacencyList, Stack<Integer> stack) {
		visited[start] = true;
		// calling the dfs if the adjacent node is not visited
		for (int node : adjacencyList.get(start))
			if (!visited[node]) dfs(node, visited, adjacencyList, stack);
		// for start node either there is not any unvisited adjacent node or simply
		// there is no adjacent node, so we can add it to the stack
		stack.add(start);
	}
}
```
