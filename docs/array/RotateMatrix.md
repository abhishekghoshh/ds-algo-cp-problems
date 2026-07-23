# RotateMatrix

**Topic:** `array` | **File:** `com/problems/array/RotateMatrix.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/rotate-image/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/981260)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/rotate-the-matrix_6825090)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=Z0R2u6gd3GU)
- [▶ YouTube](https://www.youtube.com/watch?v=Y72QeX0Efxw&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=12)
- [📄 takeUforward](https://takeuforward.org/data-structure/rotate-image-by-90-degree/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Time complexity o(2*m*n) space complexity O(1) by this method we can rotate the matrix as many ways as possible

**Complexity:** Time: o(2*m*n) | Space: o(1)

```java
private static void type2() {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		print2D(matrix);
		int n = matrix.length;
		// to rotate 90' clock wise first transpose it based on the left diagonal
		// then reverse it column wise;

		// transpose of the matrix
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		print2D(matrix);

		// reverse the matrix column wise
		int start, end;
		for (int[] oneRow : matrix) {
			start = 0;
			end = n - 1;
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
```

### Approach 1 — Brute Force

Take another dummy matrix of n*n,and then take the first row of the matrix and put it in the last column of the dummy matrix, take the second row of the matrix, and put it in the second last column of the matrix and so. time complexity O(2*m*n) space complexity O(m*n)

**Complexity:** Time: o(2*m*n) | Space: o(m*n)

```java
private static void type1() {
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		print2D(matrix);
		int n = matrix.length;
		int[][] rotated = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rotated[j][n - i - 1] = matrix[i][j];
			}
		}
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				matrix[i][j] = rotated[i][j];
		print2D(matrix);
	}
```
