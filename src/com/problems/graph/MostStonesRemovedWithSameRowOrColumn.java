package com.problems.graph;

/*
 * Problem link :
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 * https://practice.geeksforgeeks.org/problems/maximum-stone-removal-1662179442/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=OwMNX8SPavM&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=53
 * 
 * https://takeuforward.org/data-structure/most-stones-removed-with-same-row-or-column-dsu-g-53/
 */
public class MostStonesRemovedWithSameRowOrColumn {

	// On a 2D plane, we place n stones at some integer coordinate points. Each
	// coordinate point may have at most one stone.
	// A stone can be removed if it shares either the same row or the same column as
	// another stone that has not been removed.
	// Given an array stones of length n where stones[i] = [xi, yi] represents the
	// location of the i'th stone, return the largest possible number of stones that
	// can be removed.
	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int[][] stones = { { 0, 0 }, { 0, 2 }, { 1, 1 }, { 2, 0 }, { 2, 2 } };
		int n = stones.length;

		int maxRow = -1;
		int maxCol = -1;
		for (int[] stone : stones) {
			maxRow = Math.max(maxRow, stone[0]);
			maxCol = Math.max(maxCol, stone[1]);
		}
		// so we are projecting the 2d coordinates to 1D
		// 0 to maxRow and then remaining will be maxRow+1 to maxRow + maxCol + 1
		int N = maxRow + maxCol + 1;
		int[] parent = new int[N + 1];
		int[] size = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
			size[i] = 1;
		}

		boolean[] stoneNodes = new boolean[N + 1];
		for (int[] stone : stones) {
			int nodeRow = stone[0];
			// projecting to 1D coordinate
			int nodeCol = stone[1] + maxRow + 1;
			// we are doing the union for column and row if there is a stone
			// so the row and column will be connected
			union(parent, size, nodeRow, nodeCol);

			// setting stoneNodes array to true to mark that there is a stone
			stoneNodes[nodeRow] = true;
			stoneNodes[nodeCol] = true;
		}

		int componentCount = 0;
		// out of all row and column we are checking how many individual separate
		// component is present
		for (int i = 0; i <= N; i++) {
			if (stoneNodes[i] && (find(parent, i) == i))
				componentCount++;
		}
		// so for all component there should be atleast one stone present
		// remaining can be removed
		// so if there is x number of components and total n no of stones
		// then n-x can be removed
		int ans = n - componentCount;
		System.out.println(ans);
	}

	private static void union(int[] parent, int[] size, int u, int v) {
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

	private static int find(int[] parent, int node) {
		if (node == parent[node])
			return node;
		int baseParent = find(parent, parent[node]);
		parent[node] = baseParent;
		return baseParent;
	}

}
