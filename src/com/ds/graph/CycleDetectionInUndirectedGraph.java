package com.ds.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import static com.algo.graph.Graph.adjacencyList;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
 * https://www.codingninjas.com/studio/problems/detect-cycle-in-an-undirected-graph-_758967
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=BPlrALf1LDU&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=11
 * https://www.youtube.com/watch?v=zQ3zgFypzX4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=12
 * 
 * https://takeuforward.org/data-structure/detect-cycle-in-an-undirected-graph-using-bfs/
 * https://takeuforward.org/data-structure/detect-cycle-in-an-undirected-graph-using-dfs/
 * 
 */
public class CycleDetectionInUndirectedGraph {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// using dfs but recursion stack
	private static void type3() {
		List<List<Integer>> adjacencyList = adjacencyList(
				new int[][]{{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}}
		);
		int v = 5;
		boolean hasCycle = detectCycle3(v, adjacencyList);
		System.out.println(hasCycle);
	}

	private static boolean detectCycle3(int v, List<List<Integer>> adjacencyList) {
		boolean[] visited = new boolean[v];
		for (int i = 0; i < v; i++)
			if (!visited[i] && hasCycle(new int[]{i, -1}, adjacencyList, visited))
				return true;
		return false;
	}

	// Time Complexity: O(N + 2E) + O(N), Where N = Nodes, 2E is for total degrees
	// as we traverse all adjacent nodes. In the case of connected components of a
	// graph, it will take another O(N) time.
	// Space Complexity: O(N) + O(N) ~ O(N), Space for recursive stack space and visit the array.
	private static boolean hasCycle(int[] point, List<List<Integer>> adjacencyList, boolean[] visited) {
		int start = point[0];
		int parent = point[1];
		visited[start] = true;
		for (int vt : adjacencyList.get(start)) {
			if (!visited[vt])
				return hasCycle(new int[] { vt, start }, adjacencyList, visited);
			else if (vt != parent)
				// It means vertex is visited.
				// However, it is not the parent, and we are going in depth wise,
				// so there can be only one possibility that we encountered one previously
				// visited node is same that means it makes a loop
				return true;
		}
		return false;
	}

	// using DFS
	private static void type2() {
		List<List<Integer>> adjacencyList = adjacencyList(
				new int[][]{{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}}
		);
		int v = 5;
		boolean hasCycle = detectCycle2(v, adjacencyList);
		System.out.println(hasCycle);
	}

	private static boolean detectCycle2(int v, List<List<Integer>> adjacencyList) {
		boolean[] visited = new boolean[v];
		for (int i = 0; i < v; i++)
			if (!visited[i] && hasCycleUsingDfs(i, adjacencyList, visited))
				return true;
		return false;
	}

	// Time Complexity: O(N + 2E) + O(N), Where N = Nodes, 2E is for total degrees
	// as we traverse all adjacent nodes. In the case of connected components of a
	// graph, it will take another O(N) time.
	// Space Complexity: O(N) + O(N) ~ O(N), Space for recursive stack space and visit the array.
	private static boolean hasCycleUsingDfs(int i, List<List<Integer>> adjacencyList, boolean[] visited) {
		Stack<int[]> stack = new Stack<>();

		stack.add(new int[] { i, -1 });

		while (!stack.isEmpty()) {
			int[] pair = stack.pop();
			int start = pair[0];
			int parent = pair[1];
			visited[start] = true;

			List<Integer> vertices = adjacencyList.get(start);
			// as we are using dfs, we will be adding the vertices in the reverse order
			for (int id = vertices.size() - 1; id >= 0; id--) {
				int vt = vertices.get(id);
				if (!visited[vt]) {
					stack.push(new int[] { vt, start });
				} else if (vt != parent) {
					// It means vertex is visited.
					// However, it is not the parent, and we are going in depth wise,
					// so there can be only one possibility that we encountered one previously
					// visited node is same that means it makes a loop
					return true;
				}
			}
		}
		return false;
	}

	// using BFS
	private static void type1() {
		List<List<Integer>> adjacencyList = adjacencyList(
				new int[][]{{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}}
		);
		int v = 5;
		boolean hasCycle = detectCycle1(v, adjacencyList);
		System.out.println(hasCycle);
	}

	static boolean detectCycle1(int v, List<List<Integer>> adjacencyList) {
		// Write your code here.
		boolean[] visited = new boolean[v];
		for (int start = 0; start < v; start++)
			if (!visited[start] && hasCycleUsingBfs(start, adjacencyList, visited))
				return true;
		return false;
	}

	// Time Complexity: O(N + 2E) + O(N), Where N = Nodes, 2E is for total degrees
	// as we traverse all adjacent nodes.
	// In the case of connected components of a graph, it will take another O(N) time.
	// Space Complexity: O(N) + O(N) ~ O(N), Space for queue data structure and visit the array.
	private static boolean hasCycleUsingBfs(int i, List<List<Integer>> adjacencyList, boolean[] visited) {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { i, -1 });
		visited[i] = true;

		while (!queue.isEmpty()) {
			int[] pair = queue.poll();
			int start = pair[0];
			int parent = pair[1];
			for (int end : adjacencyList.get(start)) {
				// for bfs
				// if the adjacent point is not visited, then we are adding it the queue, and also
				// we are setting that vertex to visit
				if (!visited[end]) {
					queue.offer(new int[]{end, start});
					visited[end] = true;
				} else if (end != parent)
					// it means vertex is visited, but it is not the parent,
					// and we are spreading evenly,
					// so there can be only one possibility for more than one vertex the next vertex
					// is same that means it makes a loop
					return true;
			}
		}
		return false;
	}

}
