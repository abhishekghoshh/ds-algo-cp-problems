package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=mJcZjjKzeqk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=45
 * 
 * https://takeuforward.org/data-structure/prims-algorithm-minimum-spanning-tree-c-and-java-g-45/
 */
public class PrimsAlgorithm {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		int v = 3;
		int e = 3;
		int[][] edges = { { 0, 1, 5 }, { 1, 2, 3 }, { 0, 2, 1 } };

		List<List<int[]>> adj = new ArrayList<>();
		for (int i = 0; i < v; i++)
			adj.add(new ArrayList<>());
		for (int[] edge : edges) {
			adj.get(edge[0]).add(new int[] { edge[1], edge[2] });
			adj.get(edge[1]).add(new int[] { edge[0], edge[2] });
		}
		boolean[] visited = new boolean[v];
		int minimumPathWt = 0;

		PriorityQueue<int[]> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1[0], p2[0]));
		minHeap.offer(new int[] { 0, 0, -1 });

		while (!minHeap.isEmpty()) {
			int[] pair = minHeap.poll();
			int edgeWt = pair[0];
			int src = pair[1];
			int parent = pair[2];
			if (visited[src])
				continue;
			visited[src] = true;
			if (parent != -1)
				minimumPathWt += edgeWt;
			for (int[] edge : adj.get(src)) {
				if (visited[edge[0]])
					continue;
				minHeap.offer(new int[] { edge[1], edge[0], src });
			}
		}
		System.out.println(minimumPathWt);
	}

	private static void type1() {
		int v = 3;
		int e = 3;
		int[][] edges = { { 0, 1, 5 }, { 1, 2, 3 }, { 0, 2, 1 } };

		List<List<int[]>> adj = new ArrayList<>();
		for (int i = 0; i < v; i++)
			adj.add(new ArrayList<>());
		for (int[] edge : edges) {
			adj.get(edge[0]).add(new int[] { edge[1], edge[2] });
			adj.get(edge[1]).add(new int[] { edge[0], edge[2] });
		}
		boolean[] visited = new boolean[v];
		List<int[]> mst = new ArrayList<>();

		PriorityQueue<int[]> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1[0], p2[0]));
		minHeap.offer(new int[] { 0, 0, -1 });

		// we will not add the node to visited array while traversing
		// we will only add when we are polling from the heap
		while (!minHeap.isEmpty()) {
			int[] pair = minHeap.poll();
			int edgeWt = pair[0];
			int src = pair[1];
			int parent = pair[2];
			if (visited[src])
				continue;
			visited[src] = true;
			// parent = -1 means we it is the starting node or 0
			if (parent != -1)
				mst.add(new int[] { parent, src, edgeWt });
			for (int[] edge : adj.get(src)) {
				// if visited[adjacentNode] is true then if we add the edge then it will create
				// a loop
				if (visited[edge[0]])
					continue;
				minHeap.offer(new int[] { edge[1], edge[0], src });
			}
		}
		print(mst);
	}

	private static void print(List<int[]> mst) {
		for (int[] edge : mst) {
			System.out.println(edge[0] + ", " + edge[1] + ", " + edge[2]);
		}
		System.out.println();
	}

}
