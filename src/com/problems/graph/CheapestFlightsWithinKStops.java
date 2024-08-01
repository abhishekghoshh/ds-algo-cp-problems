package com.problems.graph;

import java.util.*;

/*
 * Problem link :
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 * https://practice.geeksforgeeks.org/problems/cheapest-flights-within-k-stops/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=9XybHVqTHcQ&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=38
 * 
 * https://takeuforward.org/data-structure/g-38-cheapest-flights-within-k-stops/
 * 
 */
public class CheapestFlightsWithinKStops {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// same as type1, we will not store the stops in the queue
	// we will apply bfs traverse all the flights in same stop
	private static void type2() {
		int n = 4;
		int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
		int src = 0, dst = 3, k = 1;

		List<List<int[]>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<>());

		for (int[] edge : flights)
			adj.get(edge[0]).add(new int[] { edge[1], edge[2] });

		int[] costs = new int[n];
		Arrays.fill(costs, Integer.MAX_VALUE);
		costs[src] = 0;
	}

	// study it one more time
	private static void type1() {
		int n = 4;
		int[][] flights = {
				{0, 1, 100},
				{1, 2, 100},
				{2, 0, 100},
				{1, 3, 600},
				{2, 3, 200}
		};
		int src = 0, dst = 3, k = 1;
		int ans = findCheapestPrice1(n, flights, src, dst, k);
		System.out.println(ans);
	}

	public static int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
		List<List<int[]>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

		for (int[] edge : flights)
			adj.get(edge[0]).add(new int[]{edge[1], edge[2]});

		int[] costs = new int[n];
		Arrays.fill(costs, Integer.MAX_VALUE);
		costs[src] = 0;

		// we don't need to store it in the priority queue
		// as we are operating on stops, and it is increasing by one in every iteration
		Queue<int[]> queue = new LinkedList<>();
		// Create a queue which stores the node and their distances from the
		// source in the form of {stops, node, dist} with �stops� indicating
		// the no of nodes between src and current node.
		queue.offer(new int[]{0, src, 0});
		while (!queue.isEmpty()) {
			int[] pair = queue.poll();
			int stops = pair[0];
			int node = pair[1];
			int prevCost = pair[2];

			// We stop the process as soon as the limit for the stops reaches.
			if (stops > k) continue;
			for (int[] flight : adj.get(node)) {
				int distance = flight[0];
				int cost = flight[1];

				// We only update the queue if the new calculated dist is
				// less than the previous and the stops are also within limits.
				if (prevCost + cost < costs[distance] && stops <= k) {
					costs[distance] = prevCost + cost;
					queue.add(new int[]{stops + 1, distance, prevCost + cost});
				}
			}
		}
		return costs[dst] != Integer.MAX_VALUE ? costs[dst] : -1;
	}

}
