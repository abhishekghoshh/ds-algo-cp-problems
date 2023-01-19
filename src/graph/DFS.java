package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Problem link :
 *  https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1?
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=Qzf1a--rhp8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=6
 * 
 * https://takeuforward.org/data-structure/depth-first-search-dfs/
 * 
 */
public class DFS {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// using recursion stack
	private static void type2() {
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		adjList.add(new ArrayList<>(List.of(2, 3, 1)));
		adjList.add(new ArrayList<>(List.of(0)));
		adjList.add(new ArrayList<>(List.of(0, 4)));
		adjList.add(new ArrayList<>(List.of(0)));
		adjList.add(new ArrayList<>(List.of(2)));
		int v = 5;

		ArrayList<Integer> dfsOfGraph = new ArrayList<>();
		boolean[] visited = new boolean[v];
		dfs(0, dfsOfGraph, visited, adjList);
		System.out.println(dfsOfGraph);
	}

	private static void dfs(int pt, ArrayList<Integer> dfsOfGraph, boolean[] visited,
			ArrayList<ArrayList<Integer>> adjList) {
		dfsOfGraph.add(pt);
		// we will set the visited true when operating on it
		visited[pt] = true;
		for (int end : adjList.get(pt)) {
			if (!visited[end])
				dfs(end, dfsOfGraph, visited, adjList);
		}
	}

	// using stack data structure
	private static void type1() {
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
//		adjList.add(new ArrayList<>(List.of(1, 4)));
//		adjList.add(new ArrayList<>(List.of(0, 2, 3, 4)));
//		adjList.add(new ArrayList<>(List.of(1, 3)));
//		adjList.add(new ArrayList<>(List.of(1, 2, 4)));
//		adjList.add(new ArrayList<>(List.of(0, 1, 3)));

		adjList.add(new ArrayList<>(List.of(2, 3, 1)));
		adjList.add(new ArrayList<>(List.of(0)));
		adjList.add(new ArrayList<>(List.of(0, 4)));
		adjList.add(new ArrayList<>(List.of(0)));
		adjList.add(new ArrayList<>(List.of(2)));

		int v = 5;

		ArrayList<Integer> dfsOfGraph = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[v];

		stack.add(0);

		while (!stack.isEmpty()) {
			int pt = stack.pop();
			// we will set the visited true when operating on it
			visited[pt] = true;
			dfsOfGraph.add(pt);

			List<Integer> adjacentVertices = adjList.get(pt);
			// traverse in reverse as we are adding it to the stack
			for (int i = adjacentVertices.size() - 1; i >= 0; i--) {
				Integer vt = adjacentVertices.get(i);
				if (!visited[vt]) {
					stack.add(vt);
				}
			}
		}
		System.out.println(dfsOfGraph);
	}

}
