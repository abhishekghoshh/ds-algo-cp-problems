package problems.graph;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem link :
 * https://leetcode.com/problems/number-of-provinces/
 * https://practice.geeksforgeeks.org/problems/number-of-provinces/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=ACzkVtewUYA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=7
 * 
 * https://takeuforward.org/graph/connected-components-in-graphs/
 * https://takeuforward.org/data-structure/number-of-provinces/
 * 
 */
public class ConnectedComponents {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		adjList.add(new ArrayList<>(List.of(2, 3, 1)));
		adjList.add(new ArrayList<>(List.of(0)));
		adjList.add(new ArrayList<>(List.of(0, 4)));
		adjList.add(new ArrayList<>(List.of(0)));
		adjList.add(new ArrayList<>(List.of(2)));
		int v = 5;

		boolean[] visited = new boolean[v];
		int component = 0;
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				dfs(i, visited, adjList);
				component++;
			}
		}
		System.out.println(component);
	}

	private static void dfs(int pt, boolean[] visited, ArrayList<ArrayList<Integer>> adjList) {
		// we will set the visited true when operating on it
		visited[pt] = true;
		for (int end : adjList.get(pt)) {
			if (!visited[end])
				dfs(end, visited, adjList);
		}
	}

	private static void type1() {
		int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

		int v = isConnected.length;
		boolean[] visited = new boolean[v];
		int component = 0;
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				dfs(i, visited, v, isConnected);
				component++;
			}
		}
		System.out.println(component);
	}

	private static void dfs(int i, boolean[] visited, int v, int[][] isConnected) {
		visited[i] = true;
		for (int vt = 0; vt < v; vt++) {
			if (isConnected[i][vt] == 1 && !visited[vt]) {
				dfs(vt, visited, v, isConnected);
			}
		}
	}

}
