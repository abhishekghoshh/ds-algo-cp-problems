package problems.graph;
/*
 * Problem link :
 * https://leetcode.com/problems/surrounded-regions/
 * https://practice.geeksforgeeks.org/problems/replace-os-with-xs0052/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=replace-os-with-xs
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=BtdgAys4yMk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=14
 * 
 * https://takeuforward.org/graph/surrounded-regions-replace-os-with-xs/
 * 
 */

public class SurroundedRegions {

	public static void main(String[] args) {
		type1();
	}

	// one intuition that we have found, that is
	// if the 'O' is in boundary then it can never be surrounded
	// so first we will mark all the regions which has any boundary cell
	private static void type1() {
		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		int row = board.length;
		int column = board[0].length;
		boolean[][] visited = new boolean[row][column];

		// it will visit all the region from boundary
		for (int r = 0; r < row; r++) {
			dfs(r, 0, visited, board);
			dfs(r, column - 1, visited, board);
		}
		for (int c = 0; c < column; c++) {
			dfs(0, c, visited, board);
			dfs(row - 1, c, visited, board);
		}

		// visit from all the cells which is not in boundary and cell is not yet visited
		// we will replace that with X
		for (int r = 1; r < row - 1; r++) {
			for (int c = 1; c < column - 1; c++) {
				if (board[r][c] == 'O' && !visited[r][c])
					board[r][c] = 'X';
			}
		}
		print(board);
	}

	private static void dfs(int r, int c, boolean[][] visited, char[][] board) {
		if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 'O' && !visited[r][c]) {
			visited[r][c] = true;
			dfs(r + 1, c, visited, board);
			dfs(r - 1, c, visited, board);
			dfs(r, c + 1, visited, board);
			dfs(r, c - 1, visited, board);
		}
	}

	public static void print(char[][] board) {
		for (char[] row : board) {
			for (char item : row) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}

	public static void print(boolean[][] board) {
		for (boolean[] row : board) {
			for (boolean item : row) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}
}
