package com.problems.graph;

import java.util.*;

import static com.util.PrintUtl.print;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=V6H1qAeB-l4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=32
 * https://www.youtube.com/watch?v=PATgNiuTP20&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=33
 * https://www.youtube.com/watch?v=3dINsjyfooY&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=34
 * 
 * https://takeuforward.org/data-structure/dijkstras-algorithm-using-priority-queue-g-32/
 * https://takeuforward.org/data-structure/dijkstras-algorithm-using-set-g-33/
 * 
 */
public class DijkstraAlgorithm {
	// Given a weighted, undirected and connected graph of V vertices and an adjacency list adj.
	// In that the adj[i] is a list of lists containing two integers where the first integer
	// of each list j denotes there is edge between 'i' and 'j'
	// and second integers corresponds to the weight of that edge.
	// You are given the source vertex S and You to Find the shortest distance of all the vertex's
	// from the source vertex S. You have to return a list of integers denoting
	// the shortest distance between each node and Source vertex S.
	// Note: The Graph doesn't contain any negative weight cycle.
	public static void main(String[] args) {
		type1();
		type2();
	}

	// similar to the previous type, but here we will use a priority queue or a min heap.
	// queue will introduce multiple unnecessary edges, so we can use priority queue
	private static void type2() {
		int v = 3;
		int s = 2;
		List<List<List<Integer>>> adj = List.of(
				List.of(
						List.of(1, 1),
						List.of(2, 6)
				),
				List.of(
						List.of(2, 3),
						List.of(0, 1)
				),
				List.of(
						List.of(1, 3),
						List.of(0, 6)
				)
		);
		int[] distance = new int[v];
		// setting all the values to infinity
		Arrays.fill(distance, Integer.MAX_VALUE);
		// distance from source to source is 0
		distance[s] = 0;

		// in the heap, we will store the next point and distance to source.
		// the only difference from the previous is that we will use a priority queue
		PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(pair -> pair[1]));
		minHeap.offer(new int[] { s, 0 });

		while (!minHeap.isEmpty()) {
			int[] pair = minHeap.poll();
			int start = pair[0];
			int prevDis = pair[1];
			for (List<Integer> node : adj.get(start)) {
				int end = node.get(0), dis = node.get(1);
				if (prevDis + dis < distance[end]) {
					distance[end] = prevDis + dis;
					minHeap.offer(new int[]{end, prevDis + dis});
				}
			}
		}

		print(distance);
	}

	// We will use a queue for storing the edges and current distance from the source,
	// and we will relax the edges everytime
	private static void type1() {
		int v = 3;
		int s = 2;
		List<List<List<Integer>>> adj = List.of(
				List.of(
						List.of(1, 1),
						List.of(2, 6)
				),
				List.of(
						List.of(2, 3),
						List.of(0, 1)
				),
				List.of(
						List.of(1, 3),
						List.of(0, 6)
				)
		);
		int[] distance = new int[v];
		// setting all the values to infinity
		Arrays.fill(distance, Integer.MAX_VALUE);
		// distance from source to source is 0
		distance[s] = 0;

		// in the queue, we will store the next point and distance to source
		Queue<int[]> minHeap = new LinkedList<>();
		minHeap.offer(new int[] { s, 0 });

		// we will start from the source node and explore all it's neighbor nodes and try to relax the edges.
		while (!minHeap.isEmpty()) {
			int[] pair = minHeap.poll();
			int start = pair[0];
			int prevDis = pair[1];
			for (List<Integer> node : adj.get(start)) {
				int dis = node.get(1);
				int end = node.get(0);
				if (prevDis + dis < distance[end]) {
					distance[end] = prevDis + dis;
					minHeap.offer(new int[]{end, prevDis + dis});
				}
			}
		}

		print(distance);
	}


}
