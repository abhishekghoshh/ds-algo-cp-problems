package array;

import static com.util.ArrayUtil.print2D;

/*
 * problem link :
 * https://leetcode.com/problems/rotate-image/
 * https://www.codingninjas.com/codestudio/problems/981260
 * 
 * Solution link:
 * https://www.youtube.com/watch?v=Y72QeX0Efxw&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=12
 *
 * */
public class RotateMatrix {

	public static void main(String[] args) {
		type1();
	}

	// time complexity o(m*n)
	private static void type1() {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		print2D(matrix);
		int row = matrix.length;
		int column = matrix[0].length;
		// to rotate 90' clock wise first transpose it based on the left diagonal
		// then reverse it column wise;

		// transpose code
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		print2D(matrix);
		// column wise reverse
		int start, end;
		for (int[] oneRow : matrix) {
			start = 0;
			end = column - 1;
			while (start < end) {
				int temp = oneRow[start];
				oneRow[start] = oneRow[end];
				oneRow[end] = temp;
				start++;
				end--;
			}
		}
		print2D(matrix);
	}
}
