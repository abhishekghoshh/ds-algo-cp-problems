package graph;

import static util.OnlineJudgeInit.scanner;
import static util.OnlineJudgeInit.set;

import java.util.HashSet;
import java.util.Set;

/*
 * Problem link :
 * https://leetcode.com/problems/making-a-large-island/
 * https://practice.geeksforgeeks.org/problems/maximum-connected-group/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=lgiz0Oup6gM&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=52
 * 
 * https://takeuforward.org/data-structure/making-a-large-island-dsu-g-52/
 */
public class MakeALargeIsland {

	public static void main(String[] args) {
		set();
		type1();
		type2();
	}

	// we will use union by size this time
	// in previous type we have used set
	// but we know the size
	// so we can use visited array
	// and one stack to remove the visited position
	private static void type2() {
		int n = scanner.nextInt();
		int[][] grid = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = scanner.nextInt();

		int N = n * n;
		int[] parent = new int[N];
		int[] size = new int[N];
		for (int i = 0; i < N; i++) {
			size[i] = 1;
			parent[i] = i;
		}
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		// by this union find we have gathered size of the individual components
		int noOfOnes = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0)
					continue;
				noOfOnes++;
				int nodeId = i * n + j;
				for (int[] dir : dirs) {
					int x = i + dir[0];
					int y = j + dir[1];
					if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
						int adjacentNodeId = x * n + y;
						if (find(parent, nodeId) != find(parent, adjacentNodeId)) {
							union(parent, size, nodeId, adjacentNodeId);
						}
					}
				}
			}
		}
		// if noOfOnes == n*n that means there is no 0
		// we can not place any 1 in place of 0
		if (noOfOnes == N) {
			System.out.println(noOfOnes);
			return;
		}

		int[] stack = new int[N];
		int top = -1;
		boolean[] set = new boolean[N];

		int largestIsland = 0;
		// now we will loop through the grid and find 0
		// and check if we can find unique surrounding component or not
		// then the size will be 1+all surrounding unique component
		// we have used the set to
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1)
					continue;
				int localIsland = 1;
				for (int[] dir : dirs) {
					int x = i + dir[0];
					int y = j + dir[1];
					if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
						int adjacentNodeId = x * n + y;
						int adjacentNodeParent = find(parent, adjacentNodeId);
						if (!set[adjacentNodeParent]) {
							set[adjacentNodeParent] = true;
							// adding node to stack so that we don't have to
							// create visited array all time
							// which will save some memory
							stack[++top] = adjacentNodeParent;
							localIsland += size[adjacentNodeParent];
						}
					}
				}
				// clearing the visited array
				while (top != -1)
					set[stack[top--]] = false;
				largestIsland = Math.max(largestIsland, localIsland);
			}
		}
		System.out.println(largestIsland);
	}

	// we will use union by size this time
	private static void type1() {
		int n = scanner.nextInt();
		int[][] grid = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = scanner.nextInt();

		int N = n * n;
		int[] parent = new int[N];
		int[] size = new int[N];
		for (int i = 0; i < N; i++) {
			size[i] = 1;
			parent[i] = i;
		}
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		// by this union find we have gathered size of the individual components
		int noOfOnes = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0)
					continue;
				noOfOnes++;
				int nodeId = i * n + j;
				for (int[] dir : dirs) {
					int x = i + dir[0];
					int y = j + dir[1];
					if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
						int adjacentNodeId = x * n + y;
						if (find(parent, nodeId) != find(parent, adjacentNodeId)) {
							union(parent, size, nodeId, adjacentNodeId);
						}
					}
				}
			}
		}
		// if noOfOnes == n*n that means there is no 0
		// we can not place any 1 in place of 0
		if (noOfOnes == N) {
			System.out.println(noOfOnes);
			return;
		}
		int largestIsland = 0;
		// now we will loop through the grid and find 0
		// and check if we can find unique surrounding component or not
		// then the size will be 1+all surrounding unique component
		// we have used the set to
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1)
					continue;
				Set<Integer> set = new HashSet<>();
				int localIsland = 1;
				for (int[] dir : dirs) {
					int x = i + dir[0];
					int y = j + dir[1];
					if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
						int adjacentNodeId = x * n + y;
						int adjacentNodeParent = find(parent, adjacentNodeId);
						if (!set.contains(adjacentNodeParent)) {
							set.add(adjacentNodeParent);
							localIsland += size[adjacentNodeParent];
						}
					}
				}
				largestIsland = Math.max(largestIsland, localIsland);
			}
		}
		System.out.println(largestIsland);
	}

	public static void union(int[] parent, int[] size, int u, int v) {
		int baseParentU = find(parent, u);
		int baseParentV = find(parent, v);
		if (size[baseParentU] < size[baseParentV]) {
			parent[baseParentU] = baseParentV;
			size[baseParentV] += size[baseParentU];
		} else {
			parent[baseParentV] = baseParentU;
			size[baseParentU] += size[baseParentV];
		}
	}

	public static int find(int[] parent, int node) {
		// src == parent[src] means parent of the node
		if (node == parent[node])
			return node;
		int baseParent = find(parent, parent[node]);
		parent[node] = baseParent;
		return baseParent;
	}
}
