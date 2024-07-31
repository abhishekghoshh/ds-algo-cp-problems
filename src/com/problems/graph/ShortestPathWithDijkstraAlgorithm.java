package com.problems.graph;

import java.util.*;

import static com.util.PrintUtl.print;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=rp1SMw7HSO8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=35
 * 
 * https://takeuforward.org/data-structure/g-35-print-shortest-path-dijkstras-algorithm/
 */
public class ShortestPathWithDijkstraAlgorithm {

	// You are given a weighted undirected graph having n+1 vertices numbered from 0 to n
	// and m edges describing there are edges between a to b with some weight.
	// Find the shortest path between vertex 1 and the vertex n and if a path does
	// not exist, then return a list consisting of only -1.
	public static void main(String[] args) {
		type1();
	}

	// using Dijkstra algorithm and priority queue
	// all indexes are 1 based
	private static void type1() {
		int n = 5;
		int m = 6;
		int edges[][] = {
				{1, 2, 2},
				{2, 5, 5},
				{2, 3, 4},
				{1, 4, 1},
				{4, 3, 3},
				{3, 5, 1}
		};
		List<Integer> answer = shortestPath(n, m, edges);
		System.out.println(answer);
	}

	public static List<Integer> shortestPath(int n, int m, int edges[][]) {
		// edges are 1 based index
		// transforming from edges to adjacency list
		List<List<int[]>> adj = new ArrayList<>();
		for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
		for (int[] edge : edges) {
			int start = edge[0];
			int end = edge[1];
			int dis = edge[2];
			adj.get(start).add(new int[]{end, dis});
			adj.get(end).add(new int[]{start, dis});
		}

		// initializing the distance array
		int[] distance = new int[n + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		int src = 1;
		distance[src] = 0;

		// initializing the parent array
		int[] parent = new int[n + 1];
		Arrays.fill(parent, -1);
		// we will directly use the priority queue here as min heap
		PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(pair -> pair[1]));
		minHeap.offer(new int[]{src, 0});

		while (!minHeap.isEmpty()) {
			int[] pair = minHeap.poll();
			int start = pair[0];
			int prevDis = pair[1];

			for (int[] node : adj.get(start)) {
				int end = node[0];
				int dis = node[1];
				int newDis = prevDis + dis;
				if (newDis < distance[end]) {
					distance[end] = newDis;
					parent[end] = start;
					minHeap.offer(new int[]{end, newDis});
				}
			}
		}
		// as this point distance array and parent array are calculated
		print(distance);
		print(parent);
		if (parent[n] == -1) return List.of(-1);

		List<Integer> answer = new ArrayList<>();
		int start = n;
		while (start != -1) {
			answer.add(start);
			start = parent[start];
		}
		Collections.reverse(answer);
		return answer;
	}

}
