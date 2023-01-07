package problems.graph;
/*
 * Problem link :
 * https://leetcode.com/problems/number-of-enclaves/
 * https://practice.geeksforgeeks.org/problems/number-of-enclaves/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-enclaves
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=rxKcepXQgU4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=15
 * 
 * https://takeuforward.org/graph/number-of-enclaves/
 */

public class NumberOfEnclave {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// changing the input data
	private static void type2() {
		int[][] grid = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
		int row = grid.length, column = grid[0].length;

		// visit the boundaries and
		for (int r = 0; r < row; r++) {
			dfs(grid, r, 0);
			dfs(grid, r, column - 1);
		}
		for (int c = 0; c < column; c++) {
			dfs(grid, 0, c);
			dfs(grid, row - 1, c);
		}

		int cellCount = 0;
		for (int[] rows : grid) {
			for (int item : rows)
				cellCount += item;
		}
		System.out.println(cellCount);
	}

	// once any cell is visited we are changing the cell to 1
	private static void dfs(int[][] grid, int r, int c) {
		if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
			grid[r][c] = 0;
			dfs(grid, r + 1, c);
			dfs(grid, r - 1, c);
			dfs(grid, r, c + 1);
			dfs(grid, r, c - 1);
		}
	}

	// one intuition we have found that if in boundary then we can escape
	// so boundary can never be our answer
	// any any cell touched with boundary cell with value 1 can not be answer as
	// well
	// without changing the input data
	private static void type1() {
		int[][] grid = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
		int row = grid.length;
		int column = grid[0].length;

		boolean[][] visited = new boolean[row][column];

		// visit the boundaries
		for (int r = 0; r < row; r++) {
			dfs(r, 0, visited, grid);
			dfs(r, column - 1, visited, grid);
		}
		for (int c = 0; c < column; c++) {
			dfs(0, c, visited, grid);
			dfs(row - 1, c, visited, grid);
		}

		// if the cell is not visited and having one then we can not go outside from
		// that cell
		int cellCount = 0;
		for (int r = 1; r < row - 1; r++) {
			for (int c = 1; c < column - 1; c++) {
				if (grid[r][c] == 1 && !visited[r][c]) {
					cellCount++;
				}
			}
		}
		System.out.println(cellCount);
	}

	private static void dfs(int r, int c, boolean[][] visited, int[][] grid) {
		if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1 && !visited[r][c]) {
			visited[r][c] = true;
			dfs(r + 1, c, visited, grid);
			dfs(r - 1, c, visited, grid);
			dfs(r, c + 1, visited, grid);
			dfs(r, c - 1, visited, grid);
		}
	}

}
