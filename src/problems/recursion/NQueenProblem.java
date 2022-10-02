package problems.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Problem link : 
 * https://www.codingninjas.com/codestudio/problems/759332?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/n-queens/
 * 
 * Solution link:
 * https://www.youtube.com/watch?v=i05Ju7AftcM&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=58
 * 
 * https://takeuforward.org/data-structure/n-queen-problem-return-all-distinct-solutions-to-the-n-queens-puzzle/
 * */
public class NQueenProblem {

	private static final char SEPARATOR = '=';

	public static void main(String[] args) {
		type1();
		type2();
	}

	// TODO study later
	private static void type2() {
		int n = 4;
		List<List<String>> ans = new ArrayList<>();
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		// column,broad & ans pass here
		int[] left_row = new int[n];
		int[] lower_diagonal = new int[2 * n - 1];
		int[] upper_diagonal = new int[2 * n - 1];

		dfs(0, board, ans, left_row, lower_diagonal, upper_diagonal);
		System.out.println(ans);
	}

	// FUNCTION to enter Q in a board
	public static void dfs(int col, char[][] board, List<List<String>> ans, int[] left_row, int[] lower_diagonal,
			int[] upper_diagonal) {
		int n = board.length;
		if (col == board.length) {
			ans.add(construct(board));
			return;
		}
		for (int row = 0; row < board.length; row++) {
			if ((left_row[row] == 0) && (lower_diagonal[row + col] == 0) && (upper_diagonal[n - 1 + col - row] == 0)) {
				board[row][col] = 'Q';
				left_row[row] = 1;
				lower_diagonal[row + col] = 1;
				upper_diagonal[n - 1 + col - row] = 1;
				dfs(col + 1, board, ans, left_row, lower_diagonal, upper_diagonal);
				board[row][col] = '.';
				left_row[row] = 0;
				lower_diagonal[row + col] = 0;
				upper_diagonal[n - 1 + col - row] = 0;
			}
		}
	}

	private static void type1() {
		int n = 4;
		List<List<String>> answer = new ArrayList<>();
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = SEPARATOR;
			}
		}
		// we will start from 0th column
		solve(0, n, board, answer);
		System.out.println(answer);
	}

	private static void solve(int column, int n, char[][] board, List<List<String>> answer) {
		// if column is n then queen is placed
		if (column == n) {
			answer.add(construct(board));
		}
		// in each column we will try to place it in every row
		for (int row = 0; row < n; row++) {
			// before placing any queen we are checking that on that row and diagonally
			// backwords if there is any other queen placed or not
			if (validate(board, row, column, n)) {
				board[row][column] = 'Q';
				solve(column + 1, n, board, answer);
				board[row][column] = SEPARATOR;
			}
		}
	}

	private static boolean validate(char[][] board, int row, int column, int n) {
		// checking the row
		for (int i = 0; i < column; i++) {
			if (board[row][i] == 'Q') {
				return false;
			}
		}
		int r, c;
		r = row;
		c = column;
		// checking left diagonally upwards
		while (r > -1 && c > -1) {
			if (board[r][c] == 'Q') {
				return false;
			}
			r--;
			c--;
		}
		r = row;
		c = column;
		// checking left diagonally downwards
		while (r < n && c > -1) {
			if (board[r][c] == 'Q') {
				return false;
			}
			r++;
			c--;
		}
		return true;
	}

	private static List<String> construct(char[][] board) {
		return Arrays.stream(board).map(String::new).collect(Collectors.toList());
	}

}
