package problems.others.sudoku;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class SudokuCache {
	private static final int GRID_SIZE = 9;
	private Set[] rowHas = new HashSet[GRID_SIZE];
	// private Set[] rowHasNot = new HashSet[GRID_SIZE];
	private Set[] columnHas = new HashSet[GRID_SIZE];
	// private Set[] columnHasNot = new HashSet[GRID_SIZE];
	private Set[] boxHas = new HashSet[GRID_SIZE];
	// private Set[] boxHasNot = new HashSet[GRID_SIZE];

	@SuppressWarnings("unchecked")
	public SudokuCache(int[][] board) {
		fill(rowHas);
		fill(columnHas);
		fill(boxHas);
		for (int row = 0; row < GRID_SIZE; row++) {
			for (int column = 0; column < GRID_SIZE; column++) {
				if (board[row][column] != 0) {
					rowHas[row].add(board[row][column]);
					columnHas[column].add(board[row][column]);
					boxHas[boxPosition(row, column)].add(board[row][column]);
				}

			}
		}
	}

	private void fill(Set[] set) {
		for (int i = 0; i < GRID_SIZE; i++) {
			set[i]=new HashSet<>();
		}
	}

	public boolean isValidPlacement(int number, int row, int column) {
		return !rowHas[row].contains(number) && !columnHas[column].contains(number)
				&& !boxHas[boxPosition(row, column)].contains(number);
	}

	@SuppressWarnings("unchecked")
	public void update(int number, int row, int column) {
		rowHas[row].add(number);
		columnHas[column].add(number);
		boxHas[boxPosition(row, column)].add(number);
	}
	public void remove(int number, int row, int column) {
		rowHas[row].remove(number);
		columnHas[column].remove(number);
		boxHas[boxPosition(row, column)].remove(number);
	}
	private int boxPosition(int row, int column) {
		return 3 * ((int) row / 3) + column / 3;
	}

}
