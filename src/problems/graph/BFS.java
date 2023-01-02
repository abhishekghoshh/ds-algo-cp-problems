package problems.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=-tgVpUgsQ5k&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=5
 * 
 * https://takeuforward.org/graph/breadth-first-search-bfs-level-order-traversal/
 */
public class BFS {
	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		adjList.add(new ArrayList<>(List.of(2, 3, 1)));
		adjList.add(new ArrayList<>(List.of(0)));
		adjList.add(new ArrayList<>(List.of(0, 4)));
		adjList.add(new ArrayList<>(List.of(0)));
		adjList.add(new ArrayList<>(List.of(2)));
		int v = 5;

		ArrayList<Integer> bfsOfGraph = new ArrayList<>();
		boolean[] visited = new boolean[v];
		Queue<Integer> queue = new LinkedList<>();

		visited[0] = true;
		queue.offer(0);
		bfsOfGraph.add(0);

		while (!queue.isEmpty()) {
			int pt = queue.poll();
			for (int end : adjList.get(pt)) {
				if (!visited[end]) {
					visited[end] = true;
					queue.offer(end);
					bfsOfGraph.add(end);
				}
			}
		}
		System.out.println(bfsOfGraph);
	}
}
