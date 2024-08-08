package com.problems.graph;

import java.util.*;

/*
 * Problem link :
 * https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
 * https://practice.geeksforgeeks.org/problems/number-of-ways-to-arrive-at-destination/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=_-0mx0SmYxA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=40
 * 
 * https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
 */
public class NumberOfWaysToArriveAtDestination {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		// check out other solutions
	}

	private static void type1() {
		int n = 7;
		int[][] roads = {
				{0, 6, 7},
				{0, 1, 2},
				{1, 2, 3},
				{1, 3, 3},
				{6, 3, 3},
				{3, 5, 1},
				{6, 5, 1},
				{2, 5, 1},
				{0, 4, 5},
				{4, 6, 2}
		};
		int ans = countPaths1(n, roads);
		System.out.println(ans);
	}

	public static int countPaths1(int n, int[][] roads) {
		int pivot = (int) 1e9 + 7;

		List<List<int[]>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

		for (int[] road : roads) {
			adj.get(road[0]).add(new int[]{road[1], road[2]});
			adj.get(road[1]).add(new int[]{road[0], road[2]});
		}

		long[] dist = new long[n];
		Arrays.fill(dist, Long.MAX_VALUE);
		// the distance from 0 to 0 is zero
		dist[0] = 0;

		int[] ways = new int[n];
		// we are in 0 so there is only 1 way to go to 0
		ways[0] = 1;

		// we will apply a simple dijkstra algorithm
		PriorityQueue<long[]> minHeap = new PriorityQueue<>(Comparator.comparingLong(p -> p[1]));
		minHeap.offer(new long[]{0, 0});

		while (!minHeap.isEmpty()) {
			long[] pair = minHeap.poll();
			int src = (int) pair[0];
			long prevDistance = pair[1];
			for (int[] edge : adj.get(src)) {
				int destination = edge[0];
				long distance = edge[1];
				// if prevDistance + distance < dist[destination] that means the edge will be now relaxed.
				// let's say by x ways src of the node can be visited and there is one path from src to destination
				// so destination will also be visited by x ways
				if (prevDistance + distance < dist[destination]) {
					dist[destination] = prevDistance + distance;
					ways[destination] = ways[src];
					minHeap.offer(new long[]{destination, prevDistance + distance});
				} else if (prevDistance + distance == dist[destination]) {
					// prevDistance + distance == dist[destination] means the edge will not be relaxed.
					// there was some path already discovered to this node which has the same distance overall,
					// so we will add the ways of the current source of the destination node
					ways[destination] = (ways[destination] + ways[src]) % pivot;
				}
			}
		}
		return ways[n - 1];
	}

}
