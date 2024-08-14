package com.problems.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=R6uoSjZ2imo&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=54
 * 
 * https://takeuforward.org/graph/strongly-connected-components-kosarajus-algorithm-g-54/
 */
public class KosarajusAlgorithm {
	// Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges,
	// Find the number of strongly connected components in the graph.
	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int v = 5;
		for (int i = 0; i < v; i++) adj.add(new ArrayList<>());
		adj.get(0).addAll(List.of(2, 3));
		adj.get(1).addAll(List.of(0));
		adj.get(2).addAll(List.of(1));
		adj.get(3).addAll(List.of(4));
		adj.get(4).addAll(List.of());

		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[v];

		for (int i = 0; i < v; i++) {
			if (!visited[i]) dfs(i, adj, stack, visited);
		}

		ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
		for (int i = 0; i < v; i++) revAdj.add(new ArrayList<>());
		for (int i = 0; i < v; i++)
			for (int node : adj.get(i))
				revAdj.get(node).add(i);
		// unsetting the visited array, otherwise we have to create another array
		for (int i = 0; i < v; i++) visited[i] = false;

		List<List<Integer>> ans = new ArrayList<>();
		// if we also want the components, then we can just pass one arraylist to store
		// all the components
		while (!stack.isEmpty()) {
			int node = stack.pop();
			if (!visited[node]) {
				ans.add(new ArrayList<>());
				dfs(node, visited, revAdj, ans);
			}
		}
		System.out.println(ans);
	}

	private static void dfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> revAdj, List<List<Integer>> ans) {
		visited[i] = true;
		ans.get(ans.size() - 1).add(i);
		for (int node : revAdj.get(i))
			if (!visited[node])
				dfs(node, visited, revAdj, ans);

	}

	// in a strongly connected component from one node all other nodes can be
	// reached, suppose in a graph there is 4 strongly connected component and
	// sc1 -> sc2 -> sc3 -> sc4
	// if we reverse all the edges then in one sc it will not change anything
	// sc1 <- sc2 <- sc3 <- sc4
	// so by somehow if we store the dfs traversal for the first graph it will store
	// the node time when it was visited
	// again on the second time we will apply same dfs but with some simple tweak
	private static void type1() {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int v = 5;
		for (int i = 0; i < v; i++)
			adj.add(new ArrayList<>());
		adj.get(0).addAll(List.of(2, 3));
		adj.get(1).addAll(List.of(0));
		adj.get(2).addAll(List.of(1));
		adj.get(3).addAll(List.of(4));
		adj.get(4).addAll(List.of());

		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[v];

		for (int i = 0; i < v; i++) {
			if (!visited[i])
				dfs(i, adj, stack, visited);
		}
		ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
		for (int i = 0; i < v; i++)
			revAdj.add(new ArrayList<>());
		for (int i = 0; i < v; i++)
			for (int node : adj.get(i))
				revAdj.get(node).add(i);
		// unsetting the visited array, otherwise we have to create another array
		for (int i = 0; i < v; i++)
			visited[i] = false;

		int count = 0;
		// if we also want the components, then we can just pass one arraylist to store
		// all the components
		while (!stack.isEmpty()) {
			int node = stack.pop();
			if (!visited[node]) {
				count++;
				dfs(node, visited, revAdj);
			}
		}
		System.out.println(count);
	}

	private static void dfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> revAdj) {
		visited[i] = true;
		for (int node : revAdj.get(i))
			if (!visited[node])
				dfs(node, visited, revAdj);
	}

	private static void dfs(int i, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] visited) {
		visited[i] = true;
		for (int node : adj.get(i))
			if (!visited[node])
				dfs(node, adj, stack, visited);
		stack.add(i);
	}

}
