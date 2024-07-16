package graph;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem link :
 * https://leetcode.com/problems/number-of-islands-ii/
 *
 * Solution link :
 * https://www.youtube.com/watch?v=Rn6B-Q4SNyA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn
 * 
 */
public class NumberOfIslandOnlineQueries {

	public static void main(String[] args) {
		type1();
	}

	// so this is a n x m size matrix,
	// and we will be adding one point at time
	// our answer will be number of island present on that specific time
	private static void type1() {
		int n = 4, m = 5;
		int[][] queries = {
				{0, 0},
				{0, 0},
				{1, 1},
				{1, 0},
				{0, 1},
				{0, 3},
				{1, 3},
				{0, 4},
				{3, 2},
				{2, 2},
				{1, 2},
				{0, 2}
		};

		int[][] matrix = new int[n][m];
		int N = m * n;

		int[] rank = new int[N];
		int[] parent = new int[N];
		for (int i = 0; i < N; i++) {
			rank[i] = 0;
			parent[i] = i;
		}
		int numberOfIsland = 0;
		int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		List<Integer> answer = new ArrayList<>();
		for (int[] point : queries) {
			int r = point[0];
			int c = point[1];
			int nodeNo = r * m + c;
			if (matrix[r][c] == 0) {
				matrix[r][c] = 1;
				numberOfIsland++;
				for (int i = 0; i < 4; i++) {
					int x = r + dir[i][0];
					int y = c + dir[i][1];
					if (x >= 0 && x < n && y >= 0 && y < m && matrix[x][y] == 1) {
						int neighourNodeNo = x * m + y;
						if (find(parent, nodeNo) != find(parent, neighourNodeNo)) {
							numberOfIsland--;
							union(parent, rank, nodeNo, neighourNodeNo);
						}
					}
				}
			}
			answer.add(numberOfIsland);
		}
		System.out.println(answer);
	}

	private static void union(int[] parent, int[] rank, int u, int v) {
		int baseParentU = find(parent, u);
		int baseParentV = find(parent, v);
		if (rank[baseParentU] < rank[baseParentV]) {
			parent[baseParentU] = baseParentV;
			rank[baseParentV]++;
		} else {
			parent[baseParentV] = baseParentU;
			rank[baseParentU]++;
		}
	}

	private static int find(int[] parent, int node) {
		// src == parent[src] means parent of the node
		if (node == parent[node])
			return node;
		int baseParent = find(parent, parent[node]);
		parent[node] = baseParent;
		return baseParent;
	}

}
