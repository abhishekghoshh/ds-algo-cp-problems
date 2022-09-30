package problems.recursion;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {

	private static final int GRID_SIZE = 9;

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	private static void type3() {
		// TODO study https://leetcode.com/submissions/detail/811257299/
		// top answers
	}

	private static void type2() {
		int[][] board = { { 7, 0, 2, 0, 5, 0, 6, 0, 0 }, { 0, 0, 0, 0, 0, 3, 0, 0, 0 }, { 1, 0, 0, 0, 0, 9, 5, 0, 0 },
				{ 8, 0, 0, 0, 0, 0, 0, 9, 0 }, { 0, 4, 3, 0, 0, 0, 7, 5, 0 }, { 0, 9, 0, 0, 0, 0, 0, 0, 8 },
				{ 0, 0, 9, 7, 0, 0, 0, 0, 5 }, { 0, 0, 0, 2, 0, 0, 0, 0, 0 }, { 0, 0, 7, 0, 4, 0, 2, 0, 3 } };
		printBoard(board);
		SudokuCache sudokuCache = new SudokuCache(board);
		if (solveBoard(board, sudokuCache)) {
			System.out.println("Solved successfully!");
		} else {
			System.out.println("Unsolvable board :(");
		}
		printBoard(board);
	}

	private static boolean solveBoard(int[][] board, SudokuCache sudokuCache) {
		for (int row = 0; row < GRID_SIZE; row++) {
			for (int column = 0; column < GRID_SIZE; column++) {
				if (board[row][column] == 0) {
					for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
						if (sudokuCache.isValidPlacement(numberToTry, row, column)) {
							board[row][column] = numberToTry;
							sudokuCache.update(numberToTry, row, column);
							if (solveBoard(board, sudokuCache)) {
								return true;
							} else {
								sudokuCache.remove(numberToTry, row, column);
								board[row][column] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private static void type1() {
		int[][] board = { { 7, 0, 2, 0, 5, 0, 6, 0, 0 }, { 0, 0, 0, 0, 0, 3, 0, 0, 0 }, { 1, 0, 0, 0, 0, 9, 5, 0, 0 },
				{ 8, 0, 0, 0, 0, 0, 0, 9, 0 }, { 0, 4, 3, 0, 0, 0, 7, 5, 0 }, { 0, 9, 0, 0, 0, 0, 0, 0, 8 },
				{ 0, 0, 9, 7, 0, 0, 0, 0, 5 }, { 0, 0, 0, 2, 0, 0, 0, 0, 0 }, { 0, 0, 7, 0, 4, 0, 2, 0, 3 } };
		printBoard(board);
		if (solveBoard(board)) {
			System.out.println("Solved successfully!");
		} else {
			System.out.println("Unsolvable board :(");
		}
		printBoard(board);
	}

	private static boolean solveBoard(int[][] board) {
		for (int row = 0; row < GRID_SIZE; row++) {
			for (int column = 0; column < GRID_SIZE; column++) {
				if (board[row][column] == 0) {
					for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
						if (isValidPlacement(board, numberToTry, row, column)) {
							board[row][column] = numberToTry;
							if (solveBoard(board)) {
								return true;
							} else {
								board[row][column] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isValidPlacement(int[][] board, int number, int row, int column) {
		return !isNumberInRow(board, number, row) && !isNumberInColumn(board, number, column)
				&& !isNumberInBox(board, number, row, column);
	}

	private static boolean isNumberInRow(int[][] board, int number, int row) {
		for (int i = 0; i < GRID_SIZE; i++) {
			if (board[row][i] == number) {
				return true;
			}
		}
		return false;
	}

	private static boolean isNumberInColumn(int[][] board, int number, int column) {
		for (int i = 0; i < GRID_SIZE; i++) {
			if (board[i][column] == number) {
				return true;
			}
		}
		return false;
	}

	private static boolean isNumberInBox(int[][] board, int number, int row, int column) {
		int localBoxRow = row - row % 3;
		int localBoxColumn = column - column % 3;

		for (int i = localBoxRow; i < localBoxRow + 3; i++) {
			for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
				if (board[i][j] == number) {
					return true;
				}
			}
		}
		return false;
	}

	private static void printBoard(int[][] board) {
		for (int row = 0; row < GRID_SIZE; row++) {
			if (row % 3 == 0 && row != 0) {
				System.out.println("-------------------");
			}
			for (int column = 0; column < GRID_SIZE; column++) {
				if (column % 3 == 0 && column != 0) {
					System.out.print("|");
				}
				System.out.print(board[row][column] + " ");
			}
			System.out.println();
		}
	}

}

@SuppressWarnings("rawtypes")
class SudokuCache {
	private static final int GRID_SIZE = 9;
	private Set[] allRowSet = new HashSet[GRID_SIZE];
	private Set[] allColumnSet = new HashSet[GRID_SIZE];
	private Set[] allBoxSet = new HashSet[GRID_SIZE];

	@SuppressWarnings("unchecked")
	public SudokuCache(int[][] board) {
		fill(allRowSet);
		fill(allColumnSet);
		fill(allBoxSet);
		for (int row = 0; row < GRID_SIZE; row++) {
			for (int column = 0; column < GRID_SIZE; column++) {
				if (board[row][column] != 0) {
					allRowSet[row].add(board[row][column]);
					allColumnSet[column].add(board[row][column]);
					allBoxSet[boxNumber(row, column)].add(board[row][column]);
				}
			}
		}
	}

	private void fill(Set[] set) {
		for (int i = 0; i < GRID_SIZE; i++) {
			set[i] = new HashSet<>();
		}
	}

	private int boxNumber(int row, int column) {
		return 3 * ((int) row / 3) + column / 3;
	}

	public boolean isValidPlacement(int number, int row, int column) {
		return !allRowSet[row].contains(number) && !allColumnSet[column].contains(number)
				&& !allBoxSet[boxNumber(row, column)].contains(number);
	}

	@SuppressWarnings("unchecked")
	public void update(int number, int row, int column) {
		allRowSet[row].add(number);
		allColumnSet[column].add(number);
		allBoxSet[boxNumber(row, column)].add(number);
	}

	public void remove(int number, int row, int column) {
		allRowSet[row].remove(number);
		allColumnSet[column].remove(number);
		allBoxSet[boxNumber(row, column)].remove(number);
	}
}
