package com.ds.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	private static final char SEPARATOR = '.';

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		int n = 4;
		List<List<String>> boards = solveNQueens2(n);
		print(boards);
	}

	public static List<List<String>> solveNQueens2(int n) {
		List<List<String>> boards = new ArrayList<>();
		char[][] board = new char[n][n];
		for (char[] row : board) Arrays.fill(row, SEPARATOR);
		// these arrays will be used to validate if there is any queen present in row
		// to check the intuition behind it check the striver solution
		// this will act as cache
		int[] leftRow = new int[n];
		int[] lowerDiagonal = new int[2 * n - 1];
		int[] upperDiagonal = new int[2 * n - 1];

		solve(0, board, boards, leftRow, lowerDiagonal, upperDiagonal);
		return boards;
	}

	// function to enter Q in a board
	public static void solve(int c, char[][] board, List<List<String>> boards,
							 int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {
		int n = board.length;
		if (c == n) {
			boards.add(construct(board));
			return;
		}
		for (int r = 0; r < n; r++) {
			if (isSafeToPlace2(r, c, n, leftRow, lowerDiagonal, upperDiagonal)) {
				board[r][c] = QUEEN;
				leftRow[r] = 1;
				lowerDiagonal[r + c] = 1;
				upperDiagonal[n - 1 + c - r] = 1;
				solve(c + 1, board, boards, leftRow, lowerDiagonal, upperDiagonal);
				board[r][c] = SEPARATOR;
				leftRow[r] = 0;
				lowerDiagonal[r + c] = 0;
				upperDiagonal[n - 1 + c - r] = 0;
			}
		}
	}

	// O(1) time to check if there is any queen in the same row or left upper
	// diagonal and left lower diagonal
	private static boolean isSafeToPlace2(int r, int c, int n,
										  int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {
		return (leftRow[r] == 0)
				&& (lowerDiagonal[r + c] == 0)
				&& (upperDiagonal[n - 1 + c - r] == 0);
	}

	// normal solution
	private static void type1() {
		int n = 4;
		List<List<String>> boards = solveNQueens1(n);
		print(boards);
	}

	public static List<List<String>> solveNQueens1(int n) {
		List<List<String>> boards = new ArrayList<>();

		char[][] board = new char[n][n];
		for (char[] row : board) Arrays.fill(row, SEPARATOR);
		// we will start from 0th column
		placeQueen1(0, board, boards);
		return boards;
	}

	private static void placeQueen1(int c, char[][] board, List<List<String>> boards) {
		// if column is n then queen is placed
		if (c == board.length) boards.add(construct(board));
		// in each column we will try to place it in every row
		for (int r = 0; r < board.length; r++) {
			// before placing any queen, we are checking that on that row and diagonally
			// backwards if there is any other queen placed or not
			if (isSafeToPlace(board, r, c)) {
				board[r][c] = QUEEN;
				placeQueen1(c + 1, board, boards);
				board[r][c] = SEPARATOR;
			}
		}
	}

	private static boolean isSafeToPlace(char[][] board, int row, int column) {
		int n = board.length, r, c;
		// checking the row
		for (int i = 0; i < column; i++)
			if (board[row][i] == QUEEN) return false;
		r = row;
		c = column;
		// checking left diagonally upwards
		while (r > -1 && c > -1) {
			if (board[r][c] == QUEEN) return false;
			r--;
			c--;
		}
		r = row;
		c = column;
		// checking left diagonally downwards
		while (r < n && c > -1) {
			if (board[r][c] == QUEEN) return false;
			r++;
			c--;
		}
		return true;
	}

	private static List<String> construct(char[][] board) {
		List<String> list = new ArrayList<>();
		for (char[] row : board) list.add(new String(row));
		return list;
	}


	private static void constructBoard(int n, char[][] board) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = SEPARATOR;
			}
		}
	}

	private static void print(List<List<String>> answer) {
		for (List<String> board : answer) {
			for (String row : board) System.out.println(row);
			System.out.println();
		}
		System.out.println("-------------------------");
	}

}
