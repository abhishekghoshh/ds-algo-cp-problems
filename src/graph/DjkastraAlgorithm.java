package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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
 */
public class DjkastraAlgorithm {
	// Given a weighted, undirected and connected graph of V vertices and an
	// adjacency list adj where adj[i] is a list of lists containing two integers
	// where the first integer of each list j denotes there is edge between i and j
	// , second integers corresponds to the weight of that edge . You are given the
	// source vertex S and You to Find the shortest distance of all the vertex's
	// from the source vertex S. You have to return a list of integers denoting
	// shortest distance between each node and Source vertex S.
	// Note: The Graph doesn't contain any negative weight cycle.
	public static void main(String[] args) {
		type0();
		type1();
	}

	private static void type1() {
		int v = 3;
		int s = 2;
		List<List<List<Integer>>> adj = List.of(List.of(List.of(1, 1), List.of(2, 6)),
				List.of(List.of(2, 3), List.of(0, 1)), List.of(List.of(1, 3), List.of(0, 6)));
		int[] dis = new int[v];
		// setting all the values to infinity
		for (int i = 0; i < v; i++)
			dis[i] = Integer.MAX_VALUE;
		// distance from source to source is 0
		dis[s] = 0;

		// in queue we will store the next point and distance to source
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((pair1, pair2) -> Integer.compare(pair1[1], pair2[1]));
		minHeap.offer(new int[] { s, 0 });

		while (!minHeap.isEmpty()) {
			int[] pair = minHeap.poll();
			int source = pair[0];
			int prevDistance = pair[1];
			for (List<Integer> node : adj.get(source)) {
				Integer edgeDistance = node.get(1);
				Integer adjacentNode = node.get(0);
				if (prevDistance + edgeDistance < dis[adjacentNode]) {
					dis[adjacentNode] = prevDistance + edgeDistance;
					minHeap.offer(new int[] { adjacentNode, prevDistance + edgeDistance });
				}
			}
		}

		print(dis);
	}

	// queue will also work
	// but it will introduce multiple unnecessary edges
	// so we can use priority queue
	private static void type0() {
		int v = 3;
		int s = 2;
		List<List<List<Integer>>> adj = List.of(List.of(List.of(1, 1), List.of(2, 6)),
				List.of(List.of(2, 3), List.of(0, 1)), List.of(List.of(1, 3), List.of(0, 6)));
		int[] dis = new int[v];
		// setting all the values to infinity
		for (int i = 0; i < v; i++)
			dis[i] = Integer.MAX_VALUE;
		// distance from source to source is 0
		dis[s] = 0;

		// in queue we will store the next point and distance to source
		Queue<int[]> minHeap = new LinkedList<>();
		minHeap.offer(new int[] { s, 0 });

		// we will start from the source node and explore all it's neighour nodes
		// and try to relax the edges
		// and as we are using the priorityQueue or the min heap
		// so we will get the least distance node at the top
		while (!minHeap.isEmpty()) {
			int[] pair = minHeap.poll();
			int source = pair[0];
			int prevDistance = pair[1];
			for (List<Integer> node : adj.get(source)) {
				Integer distance = node.get(1);
				Integer adjacentNode = node.get(0);
				if (prevDistance + distance < dis[adjacentNode]) {
					dis[adjacentNode] = prevDistance + distance;
					minHeap.offer(new int[] { adjacentNode, prevDistance + distance });
				}
			}
		}

		print(dis);
	}

	private static void print(int[] dis) {
		for (int d : dis)
			System.out.print(d + " ");
		System.out.println();
	}

}
