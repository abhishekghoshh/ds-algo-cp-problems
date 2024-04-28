package com.problems.graph;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem link :
 * https://leetcode.com/problems/number-of-islands/
 * https://www.codingninjas.com/studio/problems/distinct-islands_630460
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=muncqlKJrH0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=9
 *
 * https://takeuforward.org/data-structure/number-of-islands/
 */
public class NumberOfIslands {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}


	// using dfs
	// we are not using the visited array here,
	// we will mark the visited cells in the existing array
	// we will change the input data, which is not appreciated
	private static void type3() {
		char[][] grid = {
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}
		};
		int n = grid.length, m = grid[0].length;
		int noOfIsland = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// if the cell is 1 then we can start our dfs traversal from here
				if (grid[i][j] == '1') {
					noOfIsland++;
					dfs(grid, i, j);
				}
			}
		}
		System.out.println(noOfIsland);
	}

	private static void dfs(char[][] grid, int i, int j) {
		// either out of bound or that place is not land
		if (isOutOfBounds(grid, i, j) || grid[i][j] == '0') return;
		// we are not using the visited array,so we will change the cell value to 0
		// to mark the cell is visited
		grid[i][j] = '0';
		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
	}

	private static boolean isOutOfBounds(char[][] grid, int i, int j) {
		return i < 0 || j < 0 || i >= grid.length || j >= grid[i].length;
	}

	// using the bfs
	// we are not using the visited array here,
	// we will mark the visited cells in the existing array
	// we will change the input data, which is not appreciated
	private static void type2() {
		char[][] grid = {
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}
		};
		int n = grid.length, m = grid[0].length;
		int noOfIsland = 0;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1') {
					bfs(i, j, grid, dx, dy);
					noOfIsland++;
				}
			}
		}
		System.out.println(noOfIsland);
	}

	private static void bfs(int i, int j, char[][] grid, int[] dx, int[] dy) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{i, j});
		// marking the cell as visited
		grid[i][j] = '0';
		while (!queue.isEmpty()) {
			int[] coordinate = queue.poll();
			for (int d = 0; d < 4; d++) {
				int x = coordinate[0] + dx[d];
				int y = coordinate[1] + dy[d];
				if (isInOfBounds(grid, x, y) && grid[x][y] == '1') {
					// marking the cell as visited
					grid[x][y] = '0';
					queue.offer(new int[]{x, y});
				}
			}
		}
	}


	// using the bfs
	// without changing the input
	private static void type1() {
		char[][] grid = {
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}
		};
		int n = grid.length, m = grid[0].length;
		boolean[][] visited = new boolean[n][m];
		int noOfIsland = 0;
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && grid[i][j] == '1') {
					bfs(i, j, visited, grid, dx, dy);
					noOfIsland++;
				}
			}
		}
		System.out.println(noOfIsland);
	}

	private static void bfs(int i, int j, boolean[][] visited, char[][] grid, int[] dx, int[] dy) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { i, j });
		// marking the cell as visited
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int[] coordinate = queue.poll();
			for (int d = 0; d < 4; d++) {
				int x = coordinate[0] + dx[d];
				int y = coordinate[1] + dy[d];
				if (isInOfBounds(grid, x, y) && !visited[x][y] && grid[x][y] == '1') {
					// marking the cell as visited
					visited[x][y] = true;
					queue.offer(new int[] { x, y });
				}
			}
		}
	}

	private static boolean isInOfBounds(char[][] grid, int x, int y) {
		return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
	}

}
