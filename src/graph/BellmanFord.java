package graph;

import java.util.List;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=0vVofAhAYjc&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=41
 * 
 * https://takeuforward.org/data-structure/bellman-ford-algorithm-g-41/
 */
public class BellmanFord {
	// Given a weighted, directed and connected graph of V vertices and E edges,
	// Find the shortest distance of all the vertex's from the source vertex S.
	// Note: If the Graph contains a negative cycle then return an array consisting
	// of only -1.
	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int v = 3;
		List<List<Integer>> edges = List.of(List.of(0, 1, 5), List.of(1, 0, 3), List.of(1, 2, -1), List.of(2, 0, 1));
		int s = 2;
		
		int inf = (int) (1e8);
		int[] dis = new int[v];
		for (int i = 0; i < v; i++)
			dis[i] = inf;
		dis[s] = 0;

		// we will relax all the edges n-1 times
		// because if all the vertices are in straight line
		// then only they have at max n-1 edges
		for (int i = 0; i < v - 1; i++) {
			for (List<Integer> edge : edges) {
				int source = edge.get(0);
				int destination = edge.get(1);
				int distance = edge.get(2);
				// dis[source] is Integer.MAX_VALUE means source node itself is not relaxed
				if (dis[source] != inf && (dis[source] + distance < dis[destination])) {
					dis[destination] = dis[source] + distance;
				}
			}
		}

		// if there is any negative cycle then some edge will relax again
		// so we will try to relax one more time
		for (List<Integer> edge : edges) {
			int source = edge.get(0);
			int destination = edge.get(1);
			int distance = edge.get(2);
			// dis[source] is Integer.MAX_VALUE means source node itself is not relaxed
			if (dis[source] != inf && (dis[source] + distance < dis[destination])) {
				dis = new int[] { -1 };
				break;
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
