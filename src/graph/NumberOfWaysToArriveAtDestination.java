package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

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
		int[][] roads = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 }, { 3, 5, 1 }, { 6, 5, 1 },
				{ 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } };
		int pivot = (int) 1e9 + 7;

		List<List<int[]>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
		for (int[] road : roads) {
			adj.get(road[0]).add(new int[] { road[1], road[2] });
			adj.get(road[1]).add(new int[] { road[0], road[2] });
		}

		long[] dist = new long[n];
		for (int i = 0; i < n; i++)
			dist[i] = Long.MAX_VALUE;
		// distance from 0 to 0 is zero
		dist[0] = 0;

		int[] ways = new int[n];
		// we are in 0 so there is only 1 way to go to 0
		ways[0] = 1;

		// we will apply simple djkastra algorithm
		PriorityQueue<long[]> minHeap = new PriorityQueue<>((p1, p2) -> Long.compare(p1[1], p2[1]));
		minHeap.offer(new long[] { 0, 0 });

		while (!minHeap.isEmpty()) {
			long[] pair = minHeap.poll();
			int src = (int) pair[0];
			long prevDistance = pair[1];
			for (int[] edge : adj.get(src)) {
				int destination = edge[0];
				long distance = edge[1];
				// if prevDistance + distance < dist[destination]
				// that means the edge will be now relaxed
				// lets say by x ways src of the node can be visit
				// and there is one path from src to destination
				// so destination will also be visited by x ways
				if (prevDistance + distance < dist[destination]) {
					dist[destination] = prevDistance + distance;
					ways[destination] = ways[src];
					minHeap.offer(new long[] { destination, prevDistance + distance });
				} else if (prevDistance + distance == dist[destination]) {
					// prevDistance + distance == dist[destination] means
					// the edge will not be relaxed
					// there was some path already discovered to this node
					// which has the same distance overall
					// so we will add the ways of the current source of the destination node
					ways[destination] = (ways[destination] + ways[src]) % pivot;
				}
			}
		}
		System.out.println(ways[n - 1]);
	}

}
