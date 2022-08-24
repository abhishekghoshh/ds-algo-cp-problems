package problems.array;

public class SearchIn2DMatrix {

	public static void main(String[] args) {
		type1();
		type2();
		type3();

	}

	// When integers are sorted row wise and column
	// but that does not mean a[i][size-1]<a[i+1][0]
	// start element of a row is greater than last element of previous row
	// from there we will go either left side or bottom side
	// time complexity is o(log(n*m))
	private static void type3() {
		// int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int[][] matrix = { { 1, 1 } };
		int target = 6;
		int row = matrix.length;
		int column = matrix[0].length;
		int low = 0;
		int high = row * column - 1;
		int mid, i = 0, j = 0;
		boolean found = false;
		while (low <= high) {
			mid = low + (high - low) / 2;
			i = mid / column;
			j = mid % column;
			if (matrix[i][j] == target) {
				found = true;
				break;
			} else if (matrix[i][j] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		if (found) {
			System.out.println(String.format("arr[%d][%d] = %d", i, j, matrix[i][j]));
		} else {
			System.out.println(target + " not found");
		}
	}

	// When integers are sorted row wise and column
	// but that does not mean a[i][size-1]<a[i+1][0]
	// start element of a row may or may not be greater than last element of
	// previous row
	// we will start from [0,last]
	// from there we will go either left side or bottom side
	// time complexity is o(n+m)
	private static void type2() {
		int[][] matrix = { { 1, 3, 5, 12 }, { 10, 11, 16, 20 }, { 17, 18, 19, 23 } };
		int target = 18;
		int row = matrix.length;
		int column = matrix[0].length;
		int r = 0;
		int c = column - 1;
		boolean found = false;
		while (r <= row - 1 && c >= 0) {
			if (matrix[r][c] > target) {
				c--;
			} else if (matrix[r][c] < target) {
				r++;
			} else {
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println(String.format("arr[%d][%d] = %d", r, c, matrix[r][c]));
		} else {
			System.out.println(target + " not found");
		}
	}

	// search all items
	// complexity o(n*m)
	private static void type1() {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int target = 3;
		int row = matrix.length;
		int column = matrix[0].length;
		int x = -1, y = -1;
		boolean found = false;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (matrix[i][j] == target) {
					x = i;
					y = j;
					found = true;
					break;
				}
			}
			if (found) {
				break;
			}
		}
		if (found) {
			System.out.println(String.format("arr[%d][%d] = %d", x, y, matrix[x][y]));
		} else {
			System.out.println(target + " not found");
		}

	}

}
