package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/topological-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=topological-sort
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=73sneFXuTEg&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=22
 * 
 * https://takeuforward.org/data-structure/kahns-algorithm-topological-sort-algorithm-bfs-g-22/
 */
public class KahnAlgorithm {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int v = 6;
		ArrayList<ArrayList<Integer>> adjacencyList = adjacencyList(v);

		// first we will calculate indegree of all the nodes
		// if any nodes node has no indegree then it is the starting nodes
		// and we can assume that from these nodes there are edges to other nodes
		int[] indegree = new int[v];
		for (List<Integer> nodes : adjacencyList)
			for (int node : nodes)
				indegree[node]++;

		int[] answer = new int[v];
		int j = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < v; i++)
			if (indegree[i] == 0)
				queue.offer(i);
		// everytime we will decrease the indegree of the adjacent node
		// lets say node 5 has edge from 2 and 4
		// so indegree[5]=2
		// indegree[5] will 0 when we have discovered 2 and 4 successfully
		while (!queue.isEmpty()) {
			int start = queue.poll();
			answer[j++] = start;
			for (int node : adjacencyList.get(start)) {
				indegree[node]--;
				// we will add them in queue when the indegree of the specific node become 0
				// that means we have already discovered all is previous nodes
				if (indegree[node] == 0)
					queue.offer(node);
			}
		}
		print(answer);
	}

	private static ArrayList<ArrayList<Integer>> adjacencyList(int v) {
		ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
		for (int i = 0; i < v; i++)
			adjacencyList.add(new ArrayList<>());
		edgeBetween(0, adjacencyList);
		edgeBetween(1, adjacencyList);
		edgeBetween(2, adjacencyList, 3);
		edgeBetween(3, adjacencyList, 1);
		edgeBetween(4, adjacencyList, 0, 1);
		edgeBetween(5, adjacencyList, 0, 2);
		return adjacencyList;
	}

	private static void edgeBetween(int start, ArrayList<ArrayList<Integer>> adjacencyList, int... nodes) {
		for (int node : nodes)
			adjacencyList.get(start).add(node);
	}

	private static void print(int[] answer) {
		for (int node : answer)
			System.out.print(node + " ");
		System.out.println();
	}
}
