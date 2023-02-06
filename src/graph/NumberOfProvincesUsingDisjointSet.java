package graph;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/number-of-provinces/1
 * https://leetcode.com/problems/number-of-provinces/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=ZGr5nX-Gi6Y&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=48
 * 
 */
public class NumberOfProvincesUsingDisjointSet {

	public static void main(String[] args) {
		type0();
		type1();
	}

	private static void type1() {
		int v = 3;
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		matrix.add(new ArrayList<>(List.of(1, 0, 1)));
		matrix.add(new ArrayList<>(List.of(0, 1, 0)));
		matrix.add(new ArrayList<>(List.of(1, 0, 1)));

		int[] rank = new int[v];
		int[] parent = new int[v];
		for (int i = 0; i < v; i++) {
			rank[i] = 0;
			parent[i] = i;
		}
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				if (i == j)
					continue;
				if (matrix.get(i).get(j) == 0)
					continue;
				if (find(parent, i) != find(parent, j)) {
					union(parent, rank, i, j);
				}
			}
		}

		int numberOfProvinces = 0;
		// number of provinces equals to number of unique parent
		for (int i = 0; i < v; i++)
			if (i == parent[i])
				numberOfProvinces++;
		System.out.println(numberOfProvinces);
	}

	private static void union(int[] parent, int[] rank, int u, int v) {
		int baseParentU = find(parent, u);
		int baseParentV = find(parent, v);
		if (rank[baseParentU] < rank[baseParentV]) {
			parent[baseParentU] = baseParentV;
			rank[baseParentV]++;
		} else {
			parent[baseParentV] = baseParentU;
			rank[baseParentU]++;
		}
	}

	private static int find(int[] parent, int node) {
		// src == parent[src] means parent of the node
		if (node == parent[node])
			return node;
		int baseParent = find(parent, parent[node]);
		parent[node] = baseParent;
		return baseParent;
	}

	private static void type0() {
		int v = 3;
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		matrix.add(new ArrayList<>(List.of(1, 0, 1)));
		matrix.add(new ArrayList<>(List.of(0, 1, 0)));
		matrix.add(new ArrayList<>(List.of(1, 0, 1)));

		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < v; i++)
			adj.add(new ArrayList<>());
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				if (i == j)
					continue;
				if (matrix.get(i).get(j) == 1)
					adj.get(i).add(j);
			}
		}

		boolean[] visited = new boolean[v];
		int component = 0;
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				dfs(i, visited, adj);
				component++;
			}
		}
		System.out.println(component);
	}

	private static void dfs(int pt, boolean[] visited, List<List<Integer>> adj) {
		// we will set the visited true when operating on it
		visited[pt] = true;
		for (int end : adj.get(pt)) {
			if (!visited[end])
				dfs(end, visited, adj);
		}
	}
}
