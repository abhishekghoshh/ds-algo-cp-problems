package com.ds.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
 * https://www.codingninjas.com/studio/problems/dfs-traversal_630462
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=Qzf1a--rhp8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=6
 * 
 * https://takeuforward.org/data-structure/depth-first-search-dfs/
 * 
 */
public class DepthFirstSearchOfGraph {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// using recursion stack
	private static void type3() {
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

	private static void dfs(int start, ArrayList<Integer> dfsOfGraph, boolean[] visited,
			ArrayList<ArrayList<Integer>> adjList) {
		dfsOfGraph.add(start);
		// we will set the visited true when operating on it
		visited[start] = true;
		for (int end : adjList.get(start)) {
			if (start == end || visited[end]) continue;
			dfs(end, dfsOfGraph, visited, adjList);
		}
	}

	// using stack data structure
	private static void type2() {
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
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
			int start = stack.pop();
			// we will set the visited true when operating on it
			visited[start] = true;
			dfsOfGraph.add(start);

			List<Integer> adjacentVertices = adjList.get(start);
			// traverse in reverse as we are adding it to the stack,
			// though it does not matter much.
			// the idea is we will go as deep as possible
			for (int i = adjacentVertices.size() - 1; i >= 0; i--) {
				int end = adjacentVertices.get(i);
				if (start == end || visited[end]) continue;
				stack.add(end);
			}
		}
		System.out.println(dfsOfGraph);
	}

	// for adjacency matrix
	// using stack data structure
	private static void type1() {
		int v = 5;
		int[][] graph = {
				{0, 1, 1, 1, 0},
				{1, 0, 0, 0, 0},
				{1, 0, 0, 0, 1},
				{1, 0, 0, 0, 0},
				{0, 0, 1, 0, 0}
		};

		ArrayList<Integer> dfsOfGraph = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[v];

		stack.add(0);

		while (!stack.isEmpty()) {
			int start = stack.pop();
			// we will set the visited true when operating on it
			visited[start] = true;
			dfsOfGraph.add(start);

			for (int end = v - 1; end >= 0; end--) {
				if (start == end || graph[start][end] == 0 || visited[end]) continue;
				stack.add(end);
			}
		}
		System.out.println(dfsOfGraph);
	}

}
