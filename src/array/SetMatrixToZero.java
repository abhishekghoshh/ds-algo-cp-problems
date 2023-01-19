package array;

/*
 * 
 * problem links :
 * https://leetcode.com/problems/set-matrix-zeroes/
 * https://www.codingninjas.com/codestudio/problems/set-matrix-zeros_3846774?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link : https://www.youtube.com/watch?v=M65xBewcqcI&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=8
 * 
 * */
public class SetMatrixToZero {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	//optimized approach without extra space
	private static void type3() {
		int[][] matrix = { 
				{ 1, 1, 2, 2 }, 
				{ 3, 4, 5, 2 }, 
				{ 1, 0, 0, 5 },
				{ 0, 3, 1, 5 }
				};
		
		boolean isFirstColumnZero = false;
		int row = matrix.length;
		int column = matrix[0].length;
		// calculation of first column is done by isFirstColumnZero boolean value 
		//so j is from 1
		for (int i = 0; i < row; i++) {
			if (matrix[i][0] == 0) {
				isFirstColumnZero = true;
			}
			for (int j = 1; j < column; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = matrix[0][j] = 0;
				}
			}
		}
		for (int i = row - 1; i >= 0; i--) {
			for (int j = column - 1; j >= 1; j--) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
			if (isFirstColumnZero) {
				matrix[i][0] = 0;
			}
		}
		print(matrix);
	}
	
	//optimized approach with extra space of O(row)+O(column)
	private static void type2() {
		int[][] matrix = { 
				{ 1, 1, 2, 2 }, 
				{ 3, 4, 5, 2 }, 
				{ 1, 0, 0, 5 },
				{ 0, 3, 1, 5 }
				};
		int[] row = new int[matrix.length];
		int[] column = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = -1;
					column[j] = -1;
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (row[i] == -1 || column[j] == -1) {
					matrix[i][j] = 0;
				}
			}
		}
		print(matrix);
	}
	
	//brute force approach
	private static void type1() {
		int[][] matrix = { 
				{ 1, 1, 2, 2 }, 
				{ 3, 4, 5, 2 }, 
				{ 1, 0, 0, 5 },
				{ 0, 3, 1, 5 }
				};
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					setRowAndColumnToNegativeValue(i, j, matrix);
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == -1) {
					matrix[i][j] = 0;
				}
			}
		}
		print(matrix);
		
	}

	private static void print(int[][] matrix) {
		for (int[] row : matrix) {
			for (int item : row) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void setRowAndColumnToNegativeValue(int row, int column, int[][] matrix) {
		for (int i = 0; i < matrix[row].length; i++) {
			if (matrix[row][i] != 0) {
				matrix[row][i] = -1;
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][column] != 0) {
				matrix[i][column] = -1;
			}
		}
	}

}
