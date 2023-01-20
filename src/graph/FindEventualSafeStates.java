package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Problem link :
 * https://leetcode.com/problems/find-eventual-safe-states/
 * https://practice.geeksforgeeks.org/problems/eventual-safe-states/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=eventual-safe-states
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=uRbJ1OF9aYM&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=20
 * https://www.youtube.com/watch?v=2gtg3VsDGyc&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=26
 * 
 * https://takeuforward.org/data-structure/find-eventual-safe-states-dfs-g-20/
 * https://takeuforward.org/data-structure/find-eventual-safe-states-bfs-topological-sort-g-25/
 */
public class FindEventualSafeStates {

	// A directed graph of V vertices and E edges is given in the form of an
	// adjacency list adj. Each node of the graph is labelled with a distinct
	// integer in the range 0 to V - 1.

	// A node is a terminal node if there are no outgoing edges. A node is a safe
	// node if every possible path starting from that node leads to a terminal node.

	// You have to return an array containing all the safe nodes of the graph. The
	// answer should be sorted in ascending order.
	public static void main(String[] args) {
		type1();
		type1_();
		type1__();
		type2();
	}

	// using bfs or topo sort
	private static void type2() {
		ArrayList<ArrayList<Integer>> adjacencyList = adjacencyList();
		int v = 7;
		// so we know the terminal nodes are safe always
		// so we will backtrack from terminal nodes
		// terminal nodes will have no out degree
		// as we will use topo sort so we have to use indegree
		// so we will reverse the graph

		ArrayList<ArrayList<Integer>> reverseAdjacencyList = new ArrayList<>();
		int[] indegree = new int[v];
		Queue<Integer> queue = new LinkedList<>();
		// we will do the reverse and calculate the indegree in the same loop
		for (int i = 0; i < v; i++)
			reverseAdjacencyList.add(new ArrayList<>());
		for (int i = 0; i < v; i++)
			for (int node : adjacencyList.get(i)) {
				reverseAdjacencyList.get(node).add(i);
				indegree[i]++;
			}
		for (int i = 0; i < v; i++)
			if (indegree[i] == 0)
				queue.offer(i);

		List<Integer> answer = new ArrayList<>();

		while (!queue.isEmpty()) {
			int point = queue.poll();
			answer.add(point);
			for (int node : reverseAdjacencyList.get(point)) {
				indegree[node]--;
				if (indegree[node] == 0)
					queue.offer(node);
			}
		}
		Collections.sort(answer);
		System.out.println(answer);
	}

	// using dfs
	// with adjacency matrix
	// an single visited matrix
	// same as type1_
	private static void type1__() {
		int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
		int v = graph.length;
		int nodeCount = graph.length;
		int[] color = new int[nodeCount];
		List<Integer> safenodes = new ArrayList<>();
		for (int i = 0; i < v; i++)
			if (dfs(graph, i, color))
				safenodes.add(i);
		System.out.println(safenodes);
	}

	public static boolean dfs(int[][] graph, int start, int[] color) {
		if (color[start] != 0)
			return color[start] == 1;
		color[start] = 2;
		for (int newNode : graph[start]) {
			if (!dfs(graph, newNode, color))
				return false;
		}
		color[start] = 1;
		return true;
	}

	// using dfs
	// with adjacency matrix
	// an single visited matrix
	private static void type1_() {
		int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
		int v = graph.length;
		int[] visited = new int[v];
		for (int i = 0; i < v; i++) {
			if (visited[i] == 0)
				hasCycleInPath(i, visited, graph);
		}
		List<Integer> safenodes = new ArrayList<>();
		// for those nodes which has path visited to true
		// that is either in cycle or leading to cycle
		for (int i = 0; i < v; i++)
			if (visited[i] != 2)
				safenodes.add(i);
		System.out.println(safenodes);
	}

	private static boolean hasCycleInPath(int start, int[] visited, int[][] adjacencyList) {
		visited[start] = 2;
		// we are setting visited flag to 2 at first
		// if there is any cycle in the path then in subsequent dfs call will return
		// true or if the start itself is in cycle then visited[node]=2 then also we
		// will return true
		// in both case visted[start] will not set to 1
		for (int node : adjacencyList[start]) {
			if (visited[node] == 0) {
				if (hasCycleInPath(node, visited, adjacencyList))
					return true;
			} else if (visited[node] == 2)
				return true;
		}
		visited[start] = 1;
		return false;
	}

	// using dfs
	private static void type1() {
		ArrayList<ArrayList<Integer>> adjacencyList = adjacencyList();
		int v = 7;
		// so intuitions are
		// every node has no out degree will be safe nodes
		// every node that only going to terminal nodes will be safe nodes
		// every node is part of cycle or leading to a cycle is not a safe nodes

		boolean[] visited = new boolean[v];
		boolean[] pathVisited = new boolean[v];
		for (int i = 0; i < v; i++) {
			if (!visited[i])
				hasCycleInPath(i, visited, pathVisited, adjacencyList);
		}
		List<Integer> safenodes = new ArrayList<>();
		// for those nodes which has path visited to true
		// that is either in cycle or leading to cycle
		for (int i = 0; i < v; i++)
			if (!pathVisited[i])
				safenodes.add(i);
		System.out.println(safenodes);
	}

	private static boolean hasCycleInPath(int start, boolean[] visited, boolean[] pathVisited,
			ArrayList<ArrayList<Integer>> adjacencyList) {
		visited[start] = true;
		// we are setting pathvisited flag to true at first
		// if there is any cycle in the path then in subsequent dfs call will return
		// true or if the start itself is in cycle then pathVisited[node] then also we
		// will return true
		// in both case pathVisited[start] will not set to false
		pathVisited[start] = true;
		for (int node : adjacencyList.get(start)) {
			if (!visited[node]) {
				if (hasCycleInPath(node, visited, pathVisited, adjacencyList))
					return true;
			} else if (pathVisited[node])
				return true;
		}
		pathVisited[start] = false;
		return false;
	}

	private static ArrayList<ArrayList<Integer>> adjacencyList() {
		ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
		adjacencyList.add(new ArrayList<>(List.of(1, 2)));
		adjacencyList.add(new ArrayList<>(List.of(2, 3)));
		adjacencyList.add(new ArrayList<>(List.of(5)));
		adjacencyList.add(new ArrayList<>(List.of(0)));
		adjacencyList.add(new ArrayList<>(List.of(5)));
		adjacencyList.add(new ArrayList<>(List.of()));
		adjacencyList.add(new ArrayList<>(List.of()));
		return adjacencyList;
	}
}
