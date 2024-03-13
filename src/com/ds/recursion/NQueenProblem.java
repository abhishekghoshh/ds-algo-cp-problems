package com.ds.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Problem link :
 * https://leetcode.com/problems/n-queens/
 * https://www.codingninjas.com/codestudio/problems/759332
 * https://www.codingninjas.com/studio/problems/n-queens_696453
 *
 * Solution link:
 * https://www.youtube.com/watch?v=i05Ju7AftcM
 * 
 * https://takeuforward.org/data-structure/n-queen-problem-return-all-distinct-solutions-to-the-n-queens-puzzle/
 * */
public class NQueenProblem {

	private static final char QUEEN = 'Q';
	private static final char SEPARATOR = '=';

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		int n = 4;
		List<List<String>> ans = new ArrayList<>();
		char[][] board = new char[n][n];
		constructBoard(n, board);
		// these arrays will be used to validate if there is any queen present in row
		// to check the intuition behind it check the striver solution
		// this will act as cache
		int[] left_row = new int[n];
		int[] lower_diagonal = new int[2 * n - 1];
		int[] upper_diagonal = new int[2 * n - 1];

		solve(0, board, ans, left_row, lower_diagonal, upper_diagonal);
		print(ans);
	}

	// FUNCTION to enter Q in a board
	public static void solve(int col, char[][] board, List<List<String>> ans, int[] left_row, int[] lower_diagonal,
			int[] upper_diagonal) {
		int n = board.length;
		if (col == board.length) {
			ans.add(construct(board));
			return;
		}
		for (int row = 0; row < board.length; row++) {
			if (isSafeToPlace(col, left_row, lower_diagonal, upper_diagonal, n, row)) {
				board[row][col] = QUEEN;
				left_row[row] = 1;
				lower_diagonal[row + col] = 1;
				upper_diagonal[n - 1 + col - row] = 1;
				solve(col + 1, board, ans, left_row, lower_diagonal, upper_diagonal);
				board[row][col] = SEPARATOR;
				left_row[row] = 0;
				lower_diagonal[row + col] = 0;
				upper_diagonal[n - 1 + col - row] = 0;
			}
		}
	}

	// O(1) time to check if there is any queen in the same row or left upper
	// diagonal and left lower diagonal
	private static boolean isSafeToPlace(int col, int[] left_row, int[] lower_diagonal,
										 int[] upper_diagonal, int n, int row) {
		return (left_row[row] == 0)
				&& (lower_diagonal[row + col] == 0)
				&& (upper_diagonal[n - 1 + col - row] == 0);
	}

	// normal solution
	private static void type1() {
		int n = 4;
		List<List<String>> boards = new ArrayList<>();
		char[][] board = new char[n][n];
		constructBoard(n, board);
		// we will start from 0th column
		solve(0, board, boards);
		print(boards);
	}

	private static void solve(int column, char[][] board, List<List<String>> boards) {
		// if column is n then queen is placed
		if (column == board.length) {
			boards.add(construct(board));
		}
		// in each column we will try to place it in every row
		for (int row = 0; row < board.length; row++) {
			// before placing any queen we are checking that on that row and diagonally
			// backwards if there is any other queen placed or not
			if (isSafeToPlace(board, row, column)) {
				board[row][column] = QUEEN;
				solve(column + 1, board, boards);
				board[row][column] = SEPARATOR;
			}
		}
	}

	// time complexity is O(3n)
	private static boolean isSafeToPlace(char[][] board, int row, int column) {
		int n = board.length, r, c;
		// checking the row
		for (int i = 0; i < column; i++) {
			if (board[row][i] == QUEEN) {
				return false;
			}
		}
		r = row;
		c = column;
		// checking left diagonally upwards
		while (r > -1 && c > -1) {
			if (board[r][c] == QUEEN) {
				return false;
			}
			r--;
			c--;
		}
		r = row;
		c = column;
		// checking left diagonally downwards
		while (r < n && c > -1) {
			if (board[r][c] == QUEEN) {
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

	private static void print(List<List<String>> answer) {
		for (List<String> board : answer) {
			for (String row : board) {
				System.out.println(row);
			}
			System.out.println();
		}
		System.out.println("-------------------------");
	}

	private static void constructBoard(int n, char[][] board) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = SEPARATOR;
			}
		}
	}

}
