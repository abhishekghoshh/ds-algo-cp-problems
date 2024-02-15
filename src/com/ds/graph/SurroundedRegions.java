package com.ds.graph;
/*
 * Problem link :
 * https://leetcode.com/problems/surrounded-regions/
 * https://practice.geeksforgeeks.org/problems/replace-os-with-xs0052/1
 * https://www.codingninjas.com/studio/problems/replace-%E2%80%98o%E2%80%99-with-%E2%80%98x%E2%80%99_630517
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=BtdgAys4yMk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=14
 * 
 * https://takeuforward.org/graph/surrounded-regions-replace-os-with-xs/
 * 
 */

import static com.util.PrintUtl.print;

public class SurroundedRegions {

	public static void main(String[] args) {
		type1();
	}

	// the intuition is
	// if the 'O' is in boundary then it can never be surrounded,
	// so first we will mark all the regions which has any boundary cell
	private static void type1() {
		char[][] board = {
				{'X', 'X', 'X', 'X'},
				{'X', 'O', 'O', 'X'},
				{'X', 'X', 'O', 'X'},
				{'X', 'O', 'X', 'X'}
		};
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];

		// it will visit all the region from boundary
		for (int i = 0; i < m; i++) {
			dfs(i, 0, visited, board);
			dfs(i, n - 1, visited, board);
		}
		for (int j = 0; j < n; j++) {
			dfs(0, j, visited, board);
			dfs(m - 1, j, visited, board);
		}

		// visit from all the cells which is not in boundary and cell is not yet visited
		// we will replace that with X
		for (int r = 1; r < m - 1; r++) {
			for (int c = 1; c < n - 1; c++) {
				if (board[r][c] == 'O' && !visited[r][c])
					board[r][c] = 'X';
			}
		}
		print(board);
	}

	private static void dfs(int i, int j, boolean[][] visited, char[][] board) {
		if (isInBoundary(i, j, board) && board[i][j] == 'O' && !visited[i][j]) {
			visited[i][j] = true;
			dfs(i + 1, j, visited, board);
			dfs(i - 1, j, visited, board);
			dfs(i, j + 1, visited, board);
			dfs(i, j - 1, visited, board);
		}
	}

	private static boolean isInBoundary(int i, int j, char[][] board) {
		return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
	}
}
