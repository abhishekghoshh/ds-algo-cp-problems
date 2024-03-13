package com.ds.recursion;

import java.util.ArrayList;

/*
 * Problem link :
 * https://www.codingninjas.com/codestudio/problems/758966
 * https://www.codingninjas.com/studio/problems/rat-in-a-maze-_8842357
 * https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
 * 
 * Solution link:
 * https://www.youtube.com/watch?v=bLGZhJlt4y0
 * 
 * https://takeuforward.org/data-structure/rat-in-a-maze/
 * */
public class RatInAMaze {
	// Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to
	// reach the destination at (N - 1, N - 1). Find all possible paths that the rat
	// can take to reach from source to destination. The directions in which the rat
	// can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right)
	// Value 0 at a cell in the matrix represents that it is blocked and rat cannot
	// move to it while value 1 at a cell in the matrix represents that rat can be
	// travel through it.
	// Note: In a path, no cell can be visited more than one time. If the source
	// cell is 0, the rat cannot move to any other cell.
	// print is sorted order
	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
		type5();
	}

	// same as type4
	// without visited matrix
	// if one point is already visited then we remove the set bit from that
	private static void type5() {
		int[][] matrix = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
		// m = new int[][] { { 1, 1 }, { 1, 1 } };
		if (matrix[0][0] == 0) {
			return;
		}
		ArrayList<String> answer = new ArrayList<>();
		traverse_(matrix, 0, 0, answer, new StringBuilder());
		System.out.println(answer);
	}

	private static void traverse_(int[][] matrix, int i, int j, ArrayList<String> answer, StringBuilder bucket) {
		int x = matrix.length;
		int y = matrix[0].length;
		if (i == x - 1 && j == y - 1) {
			answer.add(bucket.toString());
			return;
		}
		// if out of bounds or there is not path or the point is already visited
		if (i == x || i == -1 || j == y || j == -1 || matrix[i][j] == 0)
			return;
		// turning off the point
		matrix[i][j] = 0;
		// all directions are L R U D
		// if we sort alphabetically then D L R U
		// go down
		traverse_(matrix, i + 1, j, answer, bucket.append("D"));
		bucket.deleteCharAt(bucket.length() - 1);
		// go left
		traverse_(matrix, i, j - 1, answer, bucket.append("L"));
		bucket.deleteCharAt(bucket.length() - 1);
		// go right
		traverse_(matrix, i, j + 1, answer, bucket.append("R"));
		bucket.deleteCharAt(bucket.length() - 1);
		// go up
		traverse_(matrix, i - 1, j, answer, bucket.append("U"));
		bucket.deleteCharAt(bucket.length() - 1);
		// turning on the point
		matrix[i][j] = 1;
	}

	// without visited matrix
	// if one point is already visited then we remove the set bit from that
	private static void type4() {
		int[][] matrix = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
		// m = new int[][] { { 1, 1 }, { 1, 1 } };
		if (matrix[0][0] == 0) {
			return;
		}
		ArrayList<String> answer = new ArrayList<>();
		matrix[0][0] = 0;
		traverse(matrix, 0, 0, answer, new StringBuilder());
		matrix[0][0] = 1;
		System.out.println(answer);
	}

	private static void traverse(int[][] matrix, int i, int j, ArrayList<String> answer, StringBuilder bucket) {
		int x = matrix.length;
		int y = matrix[0].length;
		if (i == x - 1 && j == y - 1) {
			answer.add(bucket.toString());
			return;
		}
		if (i >= x || j >= y)
			return;
		// all directions are L R U D
		// if we sort alphabetically then D L R U

		// go down
		if (i + 1 < x && matrix[i + 1][j] == 1) {
			matrix[i + 1][j] = 0;
			traverse(matrix, i + 1, j, answer, bucket.append("D"));
			matrix[i + 1][j] = 1;
			bucket.deleteCharAt(bucket.length() - 1);
		}
		// go left
		if (j > 0 && matrix[i][j - 1] == 1) {
			matrix[i][j - 1] = 0;
			traverse(matrix, i, j - 1, answer, bucket.append("L"));
			matrix[i][j - 1] = 1;
			bucket.deleteCharAt(bucket.length() - 1);
		}
		// go right
		if (j + 1 < y && matrix[i][j + 1] == 1) {
			matrix[i][j + 1] = 0;
			traverse(matrix, i, j + 1, answer, bucket.append("R"));
			matrix[i][j + 1] = 1;
			bucket.deleteCharAt(bucket.length() - 1);
		}
		// go up
		if (i > 0 && matrix[i - 1][j] == 1) {
			matrix[i - 1][j] = 0;
			traverse(matrix, i - 1, j, answer, bucket.append("U"));
			matrix[i - 1][j] = 1;
			bucket.deleteCharAt(bucket.length() - 1);
		}

	}

	// same as type1 just we are creating di and dj array to go to different
	// direction
	private static char[] direction = { 'D', 'L', 'R', 'U' };
	private static int di[] = { +1, 0, 0, -1 };
	private static int dj[] = { 0, -1, 1, 0 };

	private static void type3() {
		int[][] matrix = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
		int x = matrix.length;
		int y = matrix[0].length;
		boolean[][] visited = new boolean[x][y];
		ArrayList<String> answer = new ArrayList<>();
		if (matrix[0][0] == 1)
			solve(0, 0, matrix, answer, new StringBuilder(), visited);
		System.out.println(answer);
	}

	private static void solve(int i, int j, int[][] matrix, ArrayList<String> ans, StringBuilder bucket,
                              boolean[][] visited) {
		int x = matrix.length;
		int y = matrix[0].length;
		if (i == x - 1 && j == y - 1) {
			ans.add(bucket.toString());
			return;
		}
		for (int ind = 0; ind < direction.length; ind++) {
			int nexti = i + di[ind];
			int nextj = j + dj[ind];
			if (nexti >= 0 && nextj >= 0 && nexti < x && nextj < y && !visited[nexti][nextj]
					&& matrix[nexti][nextj] == 1) {
				visited[i][j] = true;
				solve(nexti, nextj, matrix, ans, bucket.append(direction[ind]), visited);
				bucket.deleteCharAt(bucket.length() - 1);
				visited[i][j] = false;
			}
		}
	}

	// using visited matrix
	// same as previous with little refactoring
	private static void type2() {
		int[][] matrix = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
		if (matrix[0][0] == 0) {
			return;
		}
		ArrayList<String> answer = new ArrayList<>();
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		traverse_(matrix, 0, 0, answer, visited, new StringBuilder());
		System.out.println(answer);
	}

	private static void traverse_(int[][] matrix, int i, int j, ArrayList<String> answer, boolean[][] visited,
			StringBuilder bucket) {
		int x = matrix.length;
		int y = matrix[0].length;
		if (i == x - 1 && j == y - 1) {
			answer.add(bucket.toString());
			return;
		}
		// if out of bounds or there is no path or the point is already visited
		if (i == x || i == -1 || j == y || j == -1 || matrix[i][j] == 0 || visited[i][j])
			return;
		visited[i][j] = true;
		// all directions are L R U D
		// if we sort alphabetically then D L R U
		// go down
		traverse_(matrix, i + 1, j, answer, visited, bucket.append("D"));
		bucket.deleteCharAt(bucket.length() - 1);
		// go left
		traverse_(matrix, i, j - 1, answer, visited, bucket.append("L"));
		bucket.deleteCharAt(bucket.length() - 1);
		// go right
		traverse_(matrix, i, j + 1, answer, visited, bucket.append("R"));
		bucket.deleteCharAt(bucket.length() - 1);
		// go up
		traverse_(matrix, i - 1, j, answer, visited, bucket.append("U"));
		bucket.deleteCharAt(bucket.length() - 1);
		visited[i][j] = false;
	}

	// using visited matrix
	private static void type1() {
		int[][] m = {
				{1, 0, 0, 0},
				{1, 1, 0, 1},
				{1, 1, 0, 0},
				{0, 1, 1, 1}
		};
		int n = m.length;
		if (m[0][0] != 0) {
			ArrayList<String> answer = new ArrayList<>();
			boolean[][] visited = new boolean[n][n];
			visited[0][0] = true;
			traverse(m, 0, 0, answer, visited, new StringBuilder(), n);
			System.out.println(answer);

		}
	}

	private static void traverse(int[][] matrix, int i, int j, ArrayList<String> answer, boolean[][] visited,
			StringBuilder bucket, int n) {
		if (i == n - 1 && j == n - 1) {
			answer.add(bucket.toString());
			return;
		}
		if (i >= n || j >= n)
			return;
		// all directions are L R U D
		// if we sort alphabetically then D L R U

		// go down
		if (i + 1 < n && matrix[i + 1][j] == 1 && !visited[i + 1][j]) {
			visited[i + 1][j] = true;
			traverse(matrix, i + 1, j, answer, visited, bucket.append("D"), n);
			visited[i + 1][j] = false;
			bucket.deleteCharAt(bucket.length() - 1);
		}
		// go left
		if (j > 0 && matrix[i][j - 1] == 1 && !visited[i][j - 1]) {
			visited[i][j - 1] = true;
			traverse(matrix, i, j - 1, answer, visited, bucket.append("L"), n);
			visited[i][j - 1] = false;
			bucket.deleteCharAt(bucket.length() - 1);
		}
		// go right
		if (j + 1 < n && matrix[i][j + 1] == 1 && !visited[i][j + 1]) {
			visited[i][j + 1] = true;
			traverse(matrix, i, j + 1, answer, visited, bucket.append("R"), n);
			visited[i][j + 1] = false;
			bucket.deleteCharAt(bucket.length() - 1);
		}

		// go up
		if (i > 0 && matrix[i - 1][j] == 1 && !visited[i - 1][j]) {
			visited[i - 1][j] = true;
			traverse(matrix, i - 1, j, answer, visited, bucket.append("U"), n);
			visited[i - 1][j] = false;
			bucket.deleteCharAt(bucket.length() - 1);
		}
	}
}
