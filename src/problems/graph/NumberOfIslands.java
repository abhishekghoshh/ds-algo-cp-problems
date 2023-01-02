package problems.graph;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem link :
 * https://leetcode.com/problems/number-of-islands/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=muncqlKJrH0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=9
 * 
 */
public class NumberOfIslands {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// changing the input
	// we are not using the visited array here
	// using dfs
	private static void type2() {
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);
				}
			}
		}
		System.out.println(count);
	}

	private static void dfs(char[][] grid, int i, int j) {
		// either out of bound or that place is not land
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0')
			return;
		// we are not using the visited array
		// we are just changing the input array here
		grid[i][j] = '0';
		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
		return;
	}

	// without changing the input
	// using the bfs
	private static void type1() {
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		int n = grid.length;
		int m = grid[0].length;
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
		int n = grid.length;
		int m = grid[0].length;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { i, j });
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			for (int d = 0; d < 4; d++) {
				int x = p[0] + dx[d];
				int y = p[1] + dy[d];
				if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y] && grid[x][y] == '1') {
					visited[x][y] = true;
					queue.offer(new int[] { x, y });
				}
			}
		}
	}

	public static class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
