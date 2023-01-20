package graph;

import java.util.*;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/topological-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=topological-sort
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=5lZ0iJMrUMk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=21
 * 
 * https://takeuforward.org/data-structure/topological-sort-algorithm-dfs-g-21/
 */
public class TopologicalSort {
	// Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any
	// Topological Sorting of that Graph.
	// in a graph if there is any edge from 1 to 2 and from 2 to 3
	/// then in topological sort the answer will be 1 -> 2 -> 3
	// and it will always be acyclic graph
	public static void main(String[] args) {
		type1();
	}

	// so we will call dfs
	// and dfs will make sure that it will go to the last node
	// and while backtracking we are storing the nodes in a stack
	// so the last node from which, there is no outgoing edge
	// will be put in the stack first
	// so if the edge is 1 -> 4 -> 3
	// and we are going from 1, then the stack will be like
	// 1|4|3, now if we just pop and store in the array then
	// we will find our simple topo sort
	private static void type1() {
		int v = 6;
		ArrayList<ArrayList<Integer>> adjacencyList = adjacencyList(v);

		boolean[] visited = new boolean[v];
		Stack<Integer> stack = new Stack<>();
		int[] answer = new int[v];
		for (int i = 0; i < v; i++)
			if (!visited[i])
				dfs(i, visited, adjacencyList, stack);
		int i = 0;
		while (!stack.isEmpty())
			answer[i++] = stack.pop();
		print(answer);
	}

	private static void dfs(int start, boolean[] visited, ArrayList<ArrayList<Integer>> adjacencyList,
			Stack<Integer> stack) {
		visited[start] = true;
		for (int node : adjacencyList.get(start))
			// calling the dfs if the adjacent node is not visited
			if (!visited[node])
				dfs(node, visited, adjacencyList, stack);
		// for start node either there is not any unvisited adjacent node or simply
		// there is no adjacent node
		// so we can add it to the stack
		stack.add(start);

	}

	private static ArrayList<ArrayList<Integer>> adjacencyList(int v) {
		ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
		for (int i = 0; i < v; i++)
			adjacencyList.add(new ArrayList<>());
		edgeBetween(0, adjacencyList);
		edgeBetween(1, adjacencyList);
		edgeBetween(2, adjacencyList, 3);
		edgeBetween(3, adjacencyList, 1);
		edgeBetween(4, adjacencyList, 0, 1);
		edgeBetween(5, adjacencyList, 0, 2);
		return adjacencyList;
	}

	private static void edgeBetween(int start, ArrayList<ArrayList<Integer>> adjacencyList, int... nodes) {
		for (int node : nodes)
			adjacencyList.get(start).add(node);
	}

	private static void print(int[] answer) {
		for (int node : answer)
			System.out.print(node + " ");
		System.out.println();
	}
}
