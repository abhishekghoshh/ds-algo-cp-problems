package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Problem link :
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=iTBaI90lpDQ&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=23
 * 
 * https://takeuforward.org/data-structure/kahns-algorithm-topological-sort-algorithm-bfs-g-22/
 */
public class CycleDetectionUsingKahnAlgorithm {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int v = 10;
		ArrayList<ArrayList<Integer>> adjacencyList = adjacencyList();

		int[] indegree = new int[v];
		for (List<Integer> nodes : adjacencyList)
			for (int node : nodes)
				indegree[node]++;

		int size = 0;

		// if there is any cycle then there will be scenario that indegree will not be
		// zero for a node
		// it can occur at start like 0->1->2->3->0
		// for this situation all the nodes will have in degree as 1
		// so the bfs will have no starting point
		// similarly it can occur at later point of time
		// like 0->1->2->3->1
		// here 0 has in degree as 0
		// so we will have starting point but after traversing 0 there will not be any
		// other node for which indegree will be 0
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < v; i++)
			if (indegree[i] == 0)
				queue.offer(i);

		while (!queue.isEmpty()) {
			int start = queue.poll();
			size++;
			for (int node : adjacencyList.get(start)) {
				indegree[node]--;
				// we will add them in queue when the indegree of the specific node become 0
				// that means we have already discovered all is previous nodes
				if (indegree[node] == 0)
					queue.offer(node);
			}
		}
		boolean hasCycle = size != v;
		System.out.println("hasCycle " + hasCycle);
	}

	private static ArrayList<ArrayList<Integer>> adjacencyList() {
		ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
		adjacencyList.add(new ArrayList<>(List.of(1)));
		adjacencyList.add(new ArrayList<>(List.of(2)));
		adjacencyList.add(new ArrayList<>(List.of(3, 6)));
		adjacencyList.add(new ArrayList<>(List.of(4)));
		adjacencyList.add(new ArrayList<>(List.of(5)));
		adjacencyList.add(new ArrayList<>(List.of()));
		adjacencyList.add(new ArrayList<>(List.of(4)));
		adjacencyList.add(new ArrayList<>(List.of(8)));
		adjacencyList.add(new ArrayList<>(List.of(9)));
		adjacencyList.add(new ArrayList<>(List.of(7)));
		return adjacencyList;
	}
}
