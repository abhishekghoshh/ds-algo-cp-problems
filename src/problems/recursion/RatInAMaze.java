package problems.recursion;

import java.util.ArrayList;

/*
 * Problem link : 
 * https://www.codingninjas.com/codestudio/problems/758966?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
 * 
 * Solution link:
 * https://www.youtube.com/watch?v=bLGZhJlt4y0&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=61
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
	}

	// without visited matrix
	private static void type3() {
		int[][] m = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
		// m = new int[][] { { 1, 1 }, { 1, 1 } };
		int n = m.length;
		if (m[0][0] != 0) {
			ArrayList<String> answer = new ArrayList<>();
			m[0][0] = 0;
			traverse(m, 0, 0, answer, new StringBuilder(), n);
			System.out.println(answer);
		}
	}

	private static void traverse(int[][] m, int x, int y, ArrayList<String> answer, StringBuilder path, int n) {
		if (x == n - 1 && y == n - 1) {
			answer.add(path.toString());
			return;
		}
		if (x >= n || y >= n)
			return;
		// all directions are L R U D
		// if we sort alphabetically then D L R U

		// go down
		if (x + 1 < n && m[x + 1][y] == 1) {
			m[x + 1][y] = 0;
			traverse(m, x + 1, y, answer, path.append("D"), n);
			m[x + 1][y] = 1;
			path.deleteCharAt(path.length() - 1);
		}
		// go left
		if (y > 0 && m[x][y - 1] == 1) {
			m[x][y - 1] = 0;
			traverse(m, x, y - 1, answer, path.append("L"), n);
			m[x][y - 1] = 1;
			path.deleteCharAt(path.length() - 1);
		}
		// go right
		if (y + 1 < n && m[x][y + 1] == 1) {
			m[x][y + 1] = 0;
			traverse(m, x, y + 1, answer, path.append("R"), n);
			m[x][y + 1] = 1;
			path.deleteCharAt(path.length() - 1);
		}

		// go up
		if (x > 0 && m[x - 1][y] == 1) {
			m[x - 1][y] = 0;
			traverse(m, x - 1, y, answer, path.append("U"), n);
			m[x - 1][y] = 1;
			path.deleteCharAt(path.length() - 1);
		}

	}

	// same as type1 just we are creating di and dj array to go to different
	// direction
	private static void type2() {
		int[][] a = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
		int n = 4;
		ArrayList<String> res = findPath(a, n);
		if (res.size() > 0) {
			for (int i = 0; i < res.size(); i++)
				System.out.print(res.get(i) + " ");
			System.out.println();
		} else {
			System.out.println(-1);
		}
	}

	public static ArrayList<String> findPath(int[][] m, int n) {
		int vis[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				vis[i][j] = 0;
			}
		}
		int di[] = { +1, 0, 0, -1 };
		int dj[] = { 0, -1, 1, 0 };
		ArrayList<String> ans = new ArrayList<>();
		if (m[0][0] == 1)
			solve(0, 0, m, n, ans, "", vis, di, dj);
		return ans;
	}

	private static void solve(int i, int j, int a[][], int n, ArrayList<String> ans, String move, int vis[][], int di[],
			int dj[]) {
		if (i == n - 1 && j == n - 1) {
			ans.add(move);
			return;
		}
		String dir = "DLRU";
		for (int ind = 0; ind < 4; ind++) {
			int nexti = i + di[ind];
			int nextj = j + dj[ind];
			if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && vis[nexti][nextj] == 0 && a[nexti][nextj] == 1) {
				vis[i][j] = 1;
				solve(nexti, nextj, a, n, ans, move + dir.charAt(ind), vis, di, dj);
				vis[i][j] = 0;
			}
		}
	}

	// using visited matrix
	private static void type1() {
		int[][] m = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
		// m = new int[][] { { 1, 1 }, { 1, 1 } };
		int n = m.length;
		if (m[0][0] != 0) {
			ArrayList<String> answer = new ArrayList<>();
			boolean[][] visited = new boolean[n][n];
			visited[0][0] = true;
			traverse(m, 0, 0, answer, visited, new StringBuilder(), n);
			System.out.println(answer);
		}
	}

	private static void traverse(int[][] m, int x, int y, ArrayList<String> answer, boolean[][] visited,
			StringBuilder path, int n) {
		if (x == n - 1 && y == n - 1) {
			answer.add(path.toString());
			return;
		}
		if (x >= n || y >= n)
			return;
		// all directions are L R U D
		// if we sort alphabetically then D L R U

		// go down
		if (x + 1 < n && m[x + 1][y] == 1 && !visited[x + 1][y]) {
			visited[x + 1][y] = true;
			traverse(m, x + 1, y, answer, visited, path.append("D"), n);
			visited[x + 1][y] = false;
			path.deleteCharAt(path.length() - 1);
		}
		// go left
		if (y > 0 && m[x][y - 1] == 1 && !visited[x][y - 1]) {
			visited[x][y - 1] = true;
			traverse(m, x, y - 1, answer, visited, path.append("L"), n);
			visited[x][y - 1] = false;
			path.deleteCharAt(path.length() - 1);
		}
		// go right
		if (y + 1 < n && m[x][y + 1] == 1 && !visited[x][y + 1]) {
			visited[x][y + 1] = true;
			traverse(m, x, y + 1, answer, visited, path.append("R"), n);
			visited[x][y + 1] = false;
			path.deleteCharAt(path.length() - 1);
		}

		// go up
		if (x > 0 && m[x - 1][y] == 1 && !visited[x - 1][y]) {
			visited[x - 1][y] = true;
			traverse(m, x - 1, y, answer, visited, path.append("U"), n);
			visited[x - 1][y] = false;
			path.deleteCharAt(path.length() - 1);
		}
	}
}
