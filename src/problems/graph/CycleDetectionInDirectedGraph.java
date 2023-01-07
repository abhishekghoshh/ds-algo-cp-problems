package problems.graph;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
 * https://leetcode.com/problems/course-schedule-ii/solutions/293048/detecting-cycle-in-directed-graph-problem/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=9twcmtQj4DU&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=19
 * 
 */

public class CycleDetectionInDirectedGraph {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		ArrayList<ArrayList<Integer>> directedAdjacencyList = new ArrayList<>();
		int v = 10;
		directedAdjacencyList.add(new ArrayList<>(List.of(1)));
		directedAdjacencyList.add(new ArrayList<>(List.of(2)));
		directedAdjacencyList.add(new ArrayList<>(List.of(3, 6)));
		directedAdjacencyList.add(new ArrayList<>(List.of(4)));
		directedAdjacencyList.add(new ArrayList<>(List.of(5)));
		directedAdjacencyList.add(new ArrayList<>(List.of()));
		directedAdjacencyList.add(new ArrayList<>(List.of(4)));
		directedAdjacencyList.add(new ArrayList<>(List.of(8)));
		directedAdjacencyList.add(new ArrayList<>(List.of(9)));
		directedAdjacencyList.add(new ArrayList<>(List.of(7)));

		boolean[] visited = new boolean[v];
		// path visited is to track the nodes in a single path
		// because visited array will not be suffice
		// if 1 points to 2 and 3
		// 2 and 3 both points to 4
		// so 1 to 4 will from a cycle if we consider the visited array only
		// and we will choose dfs here because we want to as deep as possible and in
		// this path if we come to any of previous visited point then that will form a
		// cycle,
		boolean[] pathVisited = new boolean[v];

		boolean hasCycle = false;
		for (int i = 0; i < v; i++) {
			// check for all the component
			if (!visited[i] && hasCycleWithDfs(i, visited, pathVisited, directedAdjacencyList)) {
				hasCycle = true;
				break;
			}
		}
		System.out.println(hasCycle);
	}

	private static boolean hasCycleWithDfs(int node, boolean[] visited, boolean[] pathVisited,
			ArrayList<ArrayList<Integer>> directedAdjacencyList) {
		// at the start we set visited and path visited to true
		visited[node] = true;
		pathVisited[node] = true;

		// traverse for adjacent nodes
		for (int pt : directedAdjacencyList.get(node)) {
			// when the node is not visited
			// then we call dfs from that node
			if (!visited[pt]) {
				if (hasCycleWithDfs(pt, visited, pathVisited, directedAdjacencyList))
					return true;
			}
			// if the node has been previously visited
			// but it has to be visited on the same path
			else if (pathVisited[pt]) {
				return true;
			}
		}
		// before returning false we are setting path visited to false as dfs call is
		// completed so path from this node is traversed and no cycle found
		pathVisited[node] = false;
		return false;
	}

}
