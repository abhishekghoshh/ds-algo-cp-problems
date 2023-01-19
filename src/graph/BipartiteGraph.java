package graph;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem link :
 * https://leetcode.com/problems/is-graph-bipartite/
 * https://practice.geeksforgeeks.org/problems/bipartite-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bipartite-graph
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=7zmgQSJghpo&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=17
 * https://www.youtube.com/watch?v=-vu34sct1g8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=17
 * 
 * https://takeuforward.org/graph/bipartite-graph-dfs-implementation/
 */

public class BipartiteGraph {
	// A graph is bipartite if the nodes can be partitioned into two independent
	// sets A and B such that every edge in the graph connects a node in set A and a
	// node in set B.

	// it is also an graph coloring problem
	// the problem is here if we can color the graph with 2 color only such that
	// no 2 adjacent vertex has the same color
	public static void main(String[] args) {
		type1();
		type2();
	}

	// using DFS
	private static void type2() {
		int[][] adjacencyList = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
		int v = adjacencyList.length;
		int[] colors = new int[v];
		boolean isBipatite = true;
		// start from all components
		for (int i = 0; i < v; i++) {
			if (colors[i] == 0 && !dfs(adjacencyList, colors, i, 1)) {
				isBipatite = false;
				break;
			}
		}
		System.out.println(isBipatite);
	}

	private static boolean dfs(int[][] adjacencyList, int[] colors, int i, int color) {
		colors[i] = color;
		// adjacent node
		for (int k : adjacencyList[i]) {
			// adjacent node color is opposite so we don't have to do anything
			if (colors[k] == -color)
				continue;
			// if the adjacent color is same then we will directly return false
			// else we will start dfs from the adjacent node with the opposite color
			if (colors[k] == color || !dfs(adjacencyList, colors, k, -color))
				return false;
		}
		return true;
	}

	// using BFS
	private static void type1() {
		int[][] adjacencyList = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
		int v = adjacencyList.length;

		int[] color = new int[v];
		boolean isBipatite = true;
		// start from all components
		for (int i = 0; i < v; i++) {
			if (color[i] == 0 && !isBipatite(i, adjacencyList, color)) {
				isBipatite = false;
				break;
			}
		}
		System.out.println(isBipatite);
	}

	private static boolean isBipatite(int i, int[][] adjacencyList, int[] color) {
		color[i] = 1;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);

		while (!queue.isEmpty()) {
			int pt = queue.poll();
			int cpt = color[pt];
			for (int vertex : adjacencyList[pt]) {
				// if adjacent node is not colored
				// then we will add opposite color to the adjacent node
				// and add that to queue
				if (color[vertex] == -1) {
					queue.offer(vertex);
					color[vertex] = -cpt;
				} else if (color[vertex] == cpt) {
					// if the color is same in adjacent node then we will return false
					return false;
				}
			}
		}
		return true;
	}

}
