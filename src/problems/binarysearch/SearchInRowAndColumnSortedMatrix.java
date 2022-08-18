package problems.binarysearch;

public class SearchInRowAndColumnSortedMatrix {

	public static void main(String[] args) {
		// type1();
		type2();
	}

	public static void type1() {
		int[][] matrix = { 
				{ 10, 20, 30, 40 }, 
				{ 15, 25, 35, 45 }, 
				{ 27, 29, 37, 48 }, 
				{ 32, 33, 39, 50 } 
				};
		int key = 50;
		int row = matrix.length;
		int column = matrix[0].length;
		int r = 0;
		int c = column - 1;
		while (r < row && c > 0) {
			if (matrix[r][c] == key) {
				break;
			} else if (key < matrix[r][c]) {
				c--;
			} else {
				r++;
			}
		}
		System.out.println(String.format("matrix[%d][%d] : %d", r, c, key));
	}

	public static void type2() {
		int[][] matrix = { 
				{ 10, 15, 17, 20 }, 
				{ 22, 23, 25, 27 }, 
				{ 28, 29, 32, 35 }, 
				{ 37, 39, 45, 50 } 
				};
		int key = 50;
		int row = matrix.length;
		int column = matrix[0].length;

		int low = 0;
		int high = row * column - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int item = matrix[getRow(mid, row)][getColumn(mid, row)];
			if (item == key) {
				System.out.println(
						String.format("matrix[%d][%d] : %d", getRow(mid, row), getColumn(mid, row), key));
				break;
			} else if (item < key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
	}

	private static int getColumn(int mid, int row) {
		return mid % row;
	}

	private static int getRow(int mid, int row) {
		return mid / row;
	}
	


}
