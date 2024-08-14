package com.problems.graph;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/bridge-edge-in-graph/1
 * https://leetcode.com/problems/critical-connections-in-a-network/solutions/382385/find-bridges-in-a-graph/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=qrAub5z8FeA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=55
 * 
 * https://takeuforward.org/graph/bridges-in-graph-using-tarjans-algorithm-of-time-in-and-low-time-g-55/
 */
public class BridgesInGraph {

	// Given a Graph of V vertices and E edges and another edge(c - d), the task is
	// to find if the given edge is a Bridge. i.e., removing the edge disconnects
	// the graph.
	public static void main(String[] args) {
		type1();
	}

	// TODO study one more
	private static void type1() {
		int n = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<>());
		adj.get(0).addAll(List.of(1, 2, 3));
		adj.get(1).addAll(List.of(0, 2));
		adj.get(2).addAll(List.of(0, 1));
		adj.get(3).addAll(List.of(0, 4));
		adj.get(4).addAll(List.of(3));

		boolean[] visited = new boolean[n];
		int[] timeIn = new int[n];
		int[] low = new int[n];
		List<List<Integer>> bridges = new ArrayList<>();
		dfs(0, -1, visited, adj, timeIn, low, bridges, new Step());
		System.out.println(bridges);
	}

	private static class Step {
		private int step = 1;
	}

	private static void dfs(int source, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj, int timeIn[],
			int low[], List<List<Integer>> bridges, Step step) {
		visited[source] = true;
		timeIn[source] = low[source] = step.step;
		step.step++;
		for (int adjacent : adj.get(source)) {
			if (adjacent == parent)
				continue;
			if (!visited[adjacent]) {
				dfs(adjacent, source, visited, adj, timeIn, low, bridges, step);
				low[source] = Math.min(low[source], low[adjacent]);
				if (low[adjacent] > timeIn[source]) {
					bridges.add(List.of(adjacent, source));
				}
			} else {
				low[source] = Math.min(low[source], low[adjacent]);
			}
		}
	}
}
