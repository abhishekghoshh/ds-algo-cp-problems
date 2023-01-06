package problems.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import util.Graph;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
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
		ArrayList<ArrayList<Integer>> adjacencyList = Graph
				.adjacencyList(new int[][] { { 1 }, { 0, 2, 4 }, { 1, 3 }, { 2, 4 }, { 1, 3 } });
		int v = 5;

		boolean[] visited = new boolean[v];
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				if (hasCycle(new int[] { i, -1 }, adjacencyList, visited)) {
					System.out.println("has cycle");
				}
			}
		}
		// System.out.println("No cycle");
	}

	// Time Complexity: O(N + 2E) + O(N), Where N = Nodes, 2E is for total degrees
	// as we traverse all adjacent nodes. In the case of connected components of a
	// graph, it will take another O(N) time.
	// Space Complexity: O(N) + O(N) ~ O(N), Space for recursive stack space and
	// visited array.
	private static boolean hasCycle(int[] point, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited) {
		int start = point[0];
		int parent = point[1];
		visited[start] = true;
		for (int vt : adjacencyList.get(start)) {
			if (!visited[vt])
				return hasCycle(new int[] { vt, start }, adjacencyList, visited);
			else if (vt != parent) {
				// it means vertex is visited but it is not the parent
				// and we are going in depth wise
				// so there can be only one possibility that we encountered one previously
				// visited node
				// is same
				// that means it make a loop
				return true;
			}
		}
		return false;
	}

	// using DFS
	private static void type2() {
		ArrayList<ArrayList<Integer>> adjacencyList = Graph
				.adjacencyList(new int[][] { { 1 }, { 0, 2, 4 }, { 1, 3 }, { 2, 4 }, { 1, 3 } });
		int v = 5;

		boolean[] visited = new boolean[v];
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				if (hasCycleUsingDfs(i, adjacencyList, visited)) {
					System.out.println("has cycle");
				}
			}
		}
		// System.out.println("No cycle");
	}

	// Time Complexity: O(N + 2E) + O(N), Where N = Nodes, 2E is for total degrees
	// as we traverse all adjacent nodes. In the case of connected components of a
	// graph, it will take another O(N) time.
	// Space Complexity: O(N) + O(N) ~ O(N), Space for recursive stack space and
	// visited array.
	private static boolean hasCycleUsingDfs(int i, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited) {
		Stack<int[]> stack = new Stack<>();

		stack.add(new int[] { i, -1 });

		while (!stack.isEmpty()) {
			int[] pair = stack.pop();
			int start = pair[0];
			int parent = pair[1];
			visited[start] = true;

			ArrayList<Integer> vertices = adjacencyList.get(start);
			// as we are using dfs we will be adding the vertices in the reverse order
			for (int id = vertices.size() - 1; id >= 0; id--) {
				int vt = vertices.get(id);
				if (!visited[vt]) {
					stack.push(new int[] { vt, start });
				} else if (vt != parent) {
					// it means vertex is visited but it is not the parent
					// and we are going in depth wise
					// so there can be only one possibility that we encountered one previously
					// visited node
					// is same
					// that means it make a loop
					return true;
				}
			}
		}
		return false;
	}

	// using BFS
	private static void type1() {
		ArrayList<ArrayList<Integer>> adjacencyList = Graph
				.adjacencyList(new int[][] { { 1 }, { 0, 2, 4 }, { 1, 3 }, { 2, 4 }, { 1, 3 } });
		int v = 5;

		boolean[] visited = new boolean[v];
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				if (hasCycleUsingBfs(i, adjacencyList, visited)) {
					System.out.println("has cycle");
				}
			}
		}
		// System.out.println("No cycle");
	}

	// Time Complexity: O(N + 2E) + O(N), Where N = Nodes, 2E is for total degrees
	// as we traverse all adjacent nodes. In the case of connected components of a
	// graph, it will take another O(N) time.
	// Space Complexity: O(N) + O(N) ~ O(N), Space for queue data structure and
	// visited array.
	private static boolean hasCycleUsingBfs(int i, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited) {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { i, -1 });
		visited[i] = true;

		while (!queue.isEmpty()) {
			int[] pair = queue.poll();
			int start = pair[0];
			int parent = pair[1];
			for (int vt : adjacencyList.get(start)) {
				// for bfs
				// if the adjacent point is not visited then we are adding it the queue and also
				// we are setting that vertex to visited
				if (!visited[vt]) {
					queue.offer(new int[] { vt, start });
					visited[vt] = true;
				} else if (vt != parent) {
					// it means vertex is visited but it is not the parent
					// and we are spreading evenly
					// so there can be only one possibility for more than one vertex the next vertex
					// is same
					// that means it make a loop
					return true;
				}
			}
		}
		return false;
	}

}
