package graph;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=YbY8cVwWAvw&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=42
 * 
 * https://takeuforward.org/data-structure/floyd-warshall-algorithm-g-42/
 */
public class FloydWarshall {

	// The problem is to find the shortest distances between every pair of vertices
	// in a given edge-weighted directed graph. The graph is represented as an
	// adjacency matrix of size n*n. Matrix[i][j] denotes the weight of the edge
	// from i to j. If Matrix[i][j]=-1, it means there is no edge from i to j.
	// Do it in-place.

	// TODO add the comments
	public static void main(String[] args) {
		type1();
		type2();
	}

	// without transformation the array
	private static void type2() {
		int[][] matrix = { { 0, 1, 43 }, { 1, 0, 6 }, { -1, -1, 0 } };
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				for (int k = 0; k < n; k++) {
					if (j == k)
						continue;
					if (i == j)
						continue;
					if (matrix[j][i] != -1 && matrix[i][k] != -1
							&& (matrix[j][k] == -1 || matrix[j][i] + matrix[i][k] < matrix[j][k])) {
						matrix[j][k] = matrix[j][i] + matrix[i][k];
					}
				}
			}
		}
		print(matrix);
	}

	// using transformation the array
	private static void type1() {
		int[][] matrix = { { 0, 1, 43 }, { 1, 0, 6 }, { -1, -1, 0 } };

		int n = matrix.length;

		// we will transform the matrix for our simplicity
		// if matrix[i][j] is -1 then there is no connectivity
		// we will replace it with infinity
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == -1)
					matrix[i][j] = Integer.MAX_VALUE;
				if (i == j)
					matrix[i][j] = 0;
			}
		}

		// we will try to relax all the edges
		// we will try to relax the edge from i to j
		// and we will check i to k and k to j
		// where k will go from 0 to n-1
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				if (i == k)
					continue;
				for (int j = 0; j < n; j++) {
					if (j == k)
						continue;
					if (i == j)
						continue;
					matrix[i][j] = (int) Math.min(matrix[i][j], (long) matrix[i][k] + (long) matrix[k][j]);
				}
			}
		}

		// replace the infinity with -1
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == Integer.MAX_VALUE)
					matrix[i][j] = -1;
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
	}

}
