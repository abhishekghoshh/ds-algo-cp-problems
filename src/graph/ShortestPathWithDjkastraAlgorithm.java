package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=rp1SMw7HSO8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=35
 * 
 * https://takeuforward.org/data-structure/g-35-print-shortest-path-dijkstras-algorithm/
 */
public class ShortestPathWithDjkastraAlgorithm {

	// You are given a weighted undirected graph having n+1 vertices numbered from 0
	// to n and m edges describing there are edges between a to b with some weight,
	// find the shortest path between the vertex 1 and the vertex n and if path does
	// not exist then return a list consisting of only -1.
	public static void main(String[] args) {
		type1();
	}

	// using Djkstra algorithm and priority queue
	// all indexes are 1 based
	private static void type1() {
		int n = 5;
		int m = 6;
		int edges[][] = { { 1, 2, 2 }, { 2, 5, 5 }, { 2, 3, 4 }, { 1, 4, 1 }, { 4, 3, 3 }, { 3, 5, 1 } };
		// edges are 1 based index
		// transforming from edges to adjacency list
		List<List<int[]>> adj = new ArrayList<>();
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<>());
		for (int[] edge : edges) {
			int source = edge[0];
			int destination = edge[1];
			int distance = edge[2];
			adj.get(source).add(new int[] { destination, distance });
			adj.get(destination).add(new int[] { source, distance });
		}

//		for (List<int[]> nodes : adj) {
//			for (int[] node : nodes) {
//				System.out.print(node[0] + " " + node[1] + ", ");
//			}
//			System.out.println();
//		}

		// initializing the distance array
		int[] dis = new int[n + 1];
		for (int i = 0; i <= n; i++)
			dis[i] = Integer.MAX_VALUE;
		dis[1] = 0;

		// initializing the parent array
		int[] parent = new int[n + 1];
		for (int i = 0; i <= n; i++)
			parent[i] = -1;

		PriorityQueue<int[]> minHeap = new PriorityQueue<>((pair1, pair2) -> Integer.compare(pair1[1], pair2[1]));
		minHeap.offer(new int[] { 1, 0 });

		while (!minHeap.isEmpty()) {
			int[] pair = minHeap.poll();
			int source = pair[0];
			int prevDistance = pair[1];

			for (int[] node : adj.get(source)) {
				int destination = node[0];
				int distance = node[1];
				if (prevDistance + distance < dis[destination]) {
					dis[destination] = prevDistance + distance;
					parent[destination] = source;
					minHeap.offer(new int[] { destination, prevDistance + distance });
				}
			}
		}
		print(dis);
		print(parent);
		List<Integer> answer = new ArrayList<>();
		int source = n;
		if (parent[source] == -1) {
			answer.add(-1);
			System.out.println(answer);
			return;
		}
		while (source != -1) {
			answer.add(source);
			source = parent[source];
		}
		Collections.reverse(answer);
		System.out.println(answer);
	}

	private static void print(int[] dis) {
		for (int d : dis)
			System.out.print(d + " ");
		System.out.println();
	}

}
