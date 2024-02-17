package graph;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem link :
 * https://leetcode.com/problems/is-graph-bipartite/
 * https://practice.geeksforgeeks.org/problems/bipartite-graph/1
 * https://www.codingninjas.com/studio/problems/check-bipartite-graph-_920551
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=-vu34sct1g8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=17
 * https://www.youtube.com/watch?v=KG5YFfR0j8A&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=18
 * 
 * https://takeuforward.org/graph/bipartite-graph-dfs-implementation/
 * https://takeuforward.org/graph/bipartite-graph-bfs-implementation/
 */

public class BipartiteGraph {

	/*
	 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1.
	 * You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to.
	 * More formally, for each v in graph[u], there is an undirected edge between node u and node v.
	 *
	 * The graph has the following properties:
	 * 1. There are no self-edges (graph[u] does not contain u).
	 * 2. There are no parallel edges (graph[u] does not contain duplicate values).
	 * 3. If v is in graph[u], then u is in graph[v] (the graph is undirected).
	 * 4. The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
	 *
	 * A graph is bipartite if the nodes can be partitioned into two independent sets A and B
	 * such that every edge in the graph connects a node in set A and a node in set B.
	 *
	 * Return true if and only if it is bipartite.
	 * */
	public static void main(String[] args) {
		type1();
		type2();
	}

	// using DFS
	private static void type2() {
		int[][] adjacencyList = {
				{1, 2, 3},
				{0, 2},
				{0, 1, 3},
				{0, 2}
		};
		boolean isBipartite = isBipartite2(adjacencyList);
		System.out.println(isBipartite);
	}

	private static boolean isBipartite2(int[][] adjacencyList) {
		int v = adjacencyList.length;
		int[] colors = new int[v];
		// start from all components
		for (int i = 0; i < v; i++)
			if (colors[i] == 0 && !canColor2(adjacencyList, colors, i, 1))
				return false;
		return true;
	}

	private static boolean canColor2(int[][] adjacencyList, int[] colors, int node, int color) {
		colors[node] = color;
		// adjacent node
		for (int end : adjacencyList[node]) {
			// adjacent node color is opposite, so we don't have to do anything
			if (colors[end] == -color) continue;
			// if the adjacent color is the same, then we will directly return false
			// else we will start dfs from the adjacent node with the opposite color
			if (colors[end] == color || !canColor2(adjacencyList, colors, end, -color))
				return false;
		}
		return true;
	}

	// using BFS
	private static void type1() {
		int[][] adjacencyList = {
				{1, 2, 3},
				{0, 2},
				{0, 1, 3},
				{0, 2}
		};
		boolean isBipartite = isBipartite1(adjacencyList);
		System.out.println(isBipartite);
	}

	private static boolean isBipartite1(int[][] adjacencyList) {
		int v = adjacencyList.length;
		int[] colors = new int[v];
		// start from all components
		for (int i = 0; i < v; i++)
			if (colors[i] == 0 && !canColor1(i, adjacencyList, colors))
				return false;
		return true;
	}

	// this is using BFS
	private static boolean canColor1(int node, int[][] adjacencyList, int[] colors) {
		// we will initialize the node color with 1, and add that node to the queue
		colors[node] = 1;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		// we will start bfs from the node
		while (!queue.isEmpty()) {
			int start = queue.poll();
			//
			int color = colors[start];
			for (int end : adjacencyList[start]) {
				// if the color is same in adjacent node, then we will return false
				if (colors[end] == color) return false;
				// if the adjacent node is not colored, then we will add
				// opposite color to the adjacent node and add that to queue
				if (colors[end] == 0) {
					queue.offer(end);
					colors[end] = -color;
				}
			}
		}
		return true;
	}

}
