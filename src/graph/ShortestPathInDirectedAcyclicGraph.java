package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=ZUFQfFaU-8U&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=28
 * 
 * 
 * https://takeuforward.org/data-structure/shortest-path-in-directed-acyclic-graph-topological-sort-g-27/
 */

//with path weight
public class ShortestPathInDirectedAcyclicGraph {

	// Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer
	// array(or vector) edges[ ][ ] of length M, where there is a directed edge from
	// edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i, 0<=i

	// Find the shortest path from src(0) vertex to all the vertices and if it is
	// impossible to reach any vertex, then return -1 for that vertex.
	public static void main(String[] args) {
		type1();
	}

	// we are given edges and nodes
	// first we have to transform it to adjacency list
	// we will find shortest path in a directed acyclic graph
	// so we will use topo sort using dfs
	// so in stack the ordered vertex will be stored
	// now our task is simple
	// use a distance array and set all the node value to infinity
	// and src node value to 0
	// pop from the stack until we find the source
	// so once we find the source node in stack then we will start popping one by
	// one go to it's adjacent nodes update the distance value
	private static void type1() {
		int n = 6;
		int m = 7;
		int[][] edges = { { 0, 1, 2 }, { 0, 4, 1 }, { 4, 5, 4 }, { 4, 2, 2 }, { 1, 2, 3 }, { 2, 3, 6 }, { 5, 3, 1 } };

		// transforming the edges to adjaceny list
		List<List<int[]>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());
		for (int[] edge : edges)
			adjList.get(edge[0]).add(new int[] { edge[1], edge[2] });

		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[n];
		// doing the topo sort
		for (int i = 0; i < n; i++)
			if (!visited[i])
				dfs(i, visited, stack, adjList);
		// at this point stack is prepared

		// while we find the source node which is 0
		// we will pop
		while (stack.peek() != 0)
			stack.pop();

		// initializing the distance array to infinity
		int[] distance = new int[n];
		for (int i = 1; i < n; i++)
			distance[i] = Integer.MAX_VALUE;

		// now we will pop from the stack one by one
		while (!stack.isEmpty()) {
			int point = stack.pop();
			// prevDistance is the minimum distance from src
			int prevDistance = distance[point];

			// now we will check all its adjacent node
			for (int[] nodeAndWight : adjList.get(point)) {
				int node = nodeAndWight[0];
				int wt = nodeAndWight[1];
				// it means distance[node] is greater than current point distance + edge weight
				// so we will update the distance value and add it to queue
				if (distance[node] > prevDistance + wt) {
					distance[node] = prevDistance + wt;
					stack.push(node);
				}
			}
		}
		// replacing the infinity value to -1
		for (int i = 0; i < n; i++)
			if (distance[i] == Integer.MAX_VALUE)
				distance[i] = -1;

		print(distance);
	}

	private static void dfs(int start, boolean[] visited, Stack<Integer> stack, List<List<int[]>> adjList) {
		visited[start] = true;
		for (int[] node : adjList.get(start))
			if (!visited[node[0]])
				dfs(node[0], visited, stack, adjList);
		stack.push(start);
	}

	private static void print(int[] distance) {
		for (int item : distance)
			System.out.print(item + " ");
		System.out.println();
	}

}
