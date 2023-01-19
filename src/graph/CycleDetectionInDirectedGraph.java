package graph;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
 * https://leetcode.com/problems/course-schedule-ii/solutions/293048/detecting-cycle-in-directed-graph-problem/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=9twcmtQj4DU&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=19
 * 
 * https://takeuforward.org/data-structure/detect-cycle-in-a-directed-graph-using-dfs-g-19/ 
 */

public class CycleDetectionInDirectedGraph {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// single visited array instead of two array
	private static void type2() {
		int v = 10;
		ArrayList<ArrayList<Integer>> adjacencyList = adjacencyList();

		// we will use 0 as not visited
		// 1 as visited and 2 as path visited
		int[] visited = new int[v];

		boolean hasCycle = false;
		for (int i = 0; i < v; i++) {
			// check for all the component
			if (visited[i] == 0 && hasCycle(i, visited, adjacencyList)) {
				hasCycle = true;
				break;
			}
		}
		System.out.println(hasCycle);
	}

	private static boolean hasCycle(int start, int[] visited, ArrayList<ArrayList<Integer>> adjacencyList) {
		// visited and path visited
		visited[start] = 2;
		for (int node : adjacencyList.get(start)) {
			if (visited[node] == 0) {
				if (hasCycle(node, visited, adjacencyList)) {
					return true;
				}
			} else if (visited[node] == 2) {
				return true;
			}
		}
		// resetting the path visited
		// setting only visited
		visited[start] = 1;
		return false;
	}

	private static void type1() {
		int v = 10;
		ArrayList<ArrayList<Integer>> adjacencyList = adjacencyList();

		boolean[] visited = new boolean[v];
		// path visited is to track the nodes in a single path
		// because visited array will not be suffice
		// if 1 points to 2 and 3
		// 2 and 3 both points to 4
		// so 1 to 4 will from a cycle if we consider the visited array only
		// and we will choose dfs here because we want to as deep as possible and in
		// this path if we come to any of previous visited point then that will form a
		// cycle,
		boolean[] pathVisited = new boolean[v];

		boolean hasCycle = false;
		for (int i = 0; i < v; i++) {
			// check for all the component
			if (!visited[i] && hasCycle(i, visited, pathVisited, adjacencyList)) {
				hasCycle = true;
				break;
			}
		}
		System.out.println(hasCycle);
	}

	private static ArrayList<ArrayList<Integer>> adjacencyList() {
		ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
		adjacencyList.add(new ArrayList<>(List.of(1)));
		adjacencyList.add(new ArrayList<>(List.of(2)));
		adjacencyList.add(new ArrayList<>(List.of(3, 6)));
		adjacencyList.add(new ArrayList<>(List.of(4)));
		adjacencyList.add(new ArrayList<>(List.of(5)));
		adjacencyList.add(new ArrayList<>(List.of()));
		adjacencyList.add(new ArrayList<>(List.of(4)));
		adjacencyList.add(new ArrayList<>(List.of(8)));
		adjacencyList.add(new ArrayList<>(List.of(9)));
		adjacencyList.add(new ArrayList<>(List.of(7)));
		return adjacencyList;
	}

	private static boolean hasCycle(int start, boolean[] visited, boolean[] pathVisited,
			ArrayList<ArrayList<Integer>> adjacencyList) {
		// at the start we set visited and path visited to true
		visited[start] = true;
		pathVisited[start] = true;

		// traverse for adjacent nodes
		for (int node : adjacencyList.get(start)) {
			// when the node is not visited
			// then we call dfs from that node
			if (!visited[node]) {
				if (hasCycle(node, visited, pathVisited, adjacencyList))
					return true;
			}
			// if the node has been previously visited
			// but it has to be visited on the same path
			else if (pathVisited[node]) {
				return true;
			}
		}
		// before returning false we are setting path visited to false as dfs call is
		// completed so path from this node is traversed and no cycle found
		pathVisited[start] = false;
		return false;
	}

}
