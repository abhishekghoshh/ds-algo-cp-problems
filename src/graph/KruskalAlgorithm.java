package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static util.OnlineJudgeInit.scanner;
import static util.OnlineJudgeInit.set;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=DMnDM_sxVig&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=47
 * 
 * https://takeuforward.org/data-structure/kruskals-algorithm-minimum-spanning-tree-g-47/
 */
public class KruskalAlgorithm {

	public static void main(String[] args) {
		set();
		type1();
		type2();
	}

	private static void type2() {
		int v = scanner.nextInt();
		int e = scanner.nextInt();
		int[][] edges = new int[e][3];
		for (int i = 0; i < e; i++) {
			edges[i][0] = scanner.nextInt();
			edges[i][1] = scanner.nextInt();
			edges[i][2] = scanner.nextInt();
		}

		// sorting the edges by weight
		Arrays.sort(edges, (e1, e2) -> Integer.compare(e1[2], e2[2]));

		int[] rank = new int[v];
		int[] parent = new int[v];
		for (int i = 0; i < v; i++) {
			rank[i] = 0;
			parent[i] = i;
		}
		List<int[]> mst = new ArrayList<>();
		// now we will iterate through edges from least to highest weight
		for (int[] edge : edges) {
			int src = edge[0];
			int dest = edge[1];
			// if the parent of both the src and dest node is same then
			// by adding this edge it will create a loop
			if (find(parent, src) != find(parent, dest)) {
				union(parent, rank, src, dest);
				mst.add(edge);
			}
		}
		System.out.println("mst ->>");
		print(mst);

	}

	private static void type1() {
		int v = 3;
		int e = 3;
		int[][] edges = { { 0, 1, 5 }, { 1, 2, 3 }, { 0, 2, 1 } };

		// sorting the edges by weight
		Arrays.sort(edges, (e1, e2) -> Integer.compare(e1[2], e2[2]));

		int[] rank = new int[v];
		int[] parent = new int[v];
		for (int i = 0; i < v; i++) {
			rank[i] = 0;
			parent[i] = i;
		}
		int minimumPathSum = 0;
		// now we will iterate through edges from least to highest weight
		for (int[] edge : edges) {
			int src = edge[0];
			int dest = edge[1];
			int wt = edge[2];
			// if the parent of both the src and dest node is same then
			// by adding this edge it will create a loop
			if (find(parent, src) != find(parent, dest)) {
				union(parent, rank, src, dest);
				minimumPathSum += wt;
			}
		}
		System.out.println(minimumPathSum);
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

	private static void print(List<int[]> mst) {
		for (int[] edge : mst) {
			System.out.println(edge[0] + ", " + edge[1] + ", " + edge[2]);
		}
		System.out.println();
	}
}
