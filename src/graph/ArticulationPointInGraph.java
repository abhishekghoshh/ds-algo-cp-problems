package graph;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/articulation-point-1/1
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=j1QDfU21iZk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=56
 * 
 * https://takeuforward.org/data-structure/articulation-point-in-graph-g-56/
 */
public class ArticulationPointInGraph {

	// Given an undirected connected graph with V vertices and adjacency list adj.
	// You are required to find all the vertices removing which (and edges through
	// it) disconnects the graph into 2 or more components.
	// Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might
	// be loops present in the graph.
	public static void main(String[] args) {
		type1();
	}

	// TODO study one more
	private static void type1() {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int n = 5;
		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<>());
		adj.get(0).addAll(List.of(1));
		adj.get(1).addAll(List.of(0, 4));
		adj.get(2).addAll(List.of(3, 4));
		adj.get(3).addAll(List.of(2, 4));
		adj.get(4).addAll(List.of(1, 2, 3));

		boolean[] visited = new boolean[n];
		int[] timeIn = new int[n];
		int[] low = new int[n];
		int[] mark = new int[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(i, -1, visited, timeIn, low, mark, adj, new Step());
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (mark[i] == 1) {
				ans.add(i);
			}
		}
		if (ans.size() == 0) {
			ans.add(-1);
		}
		System.out.println(ans);
	}

	private static class Step {
		private int step = 1;
	}

	private static void dfs(int source, int parent, boolean[] visited, int timeIn[], int low[], int[] mark,
			ArrayList<ArrayList<Integer>> adj, Step step) {
		visited[source] = true;
		timeIn[source] = low[source] = step.step;
		step.step++;
		int child = 0;
		for (Integer adjacent : adj.get(source)) {
			if (adjacent == parent)
				continue;
			if (!visited[adjacent]) {
				dfs(adjacent, source, visited, timeIn, low, mark, adj, step);
				low[source] = Math.min(low[source], low[adjacent]);
				// node --- it
				if (low[adjacent] >= timeIn[source] && parent != -1) {
					mark[source] = 1;
				}
				child++;
			} else {
				low[source] = Math.min(low[source], timeIn[adjacent]);
			}
		}
		if (child > 1 && parent == -1) {
			mark[source] = 1;
		}
	}
}
