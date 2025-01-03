package com.problems.dp;

/*
 * Problem link :
 * https://leetcode.com/problems/unique-paths/
 * https://www.codingninjas.com/studio/problems/1081470
 *
 * Solution link
 * https://www.youtube.com/watch?v=t_f0nwwdg5o
 * https://www.youtube.com/watch?v=sdE0A2Oxofw&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=9
 *
 * https://takeuforward.org/data-structure/grid-unique-paths-dp-on-grids-dp8/
 * https://takeuforward.org/data-structure/grid-unique-paths-count-paths-from-left-top-to-the-right-bottom-of-a-matrix/
 *
 * */

// Tags: Arrays, Dynamic Programming, Combination Approach
public class GridUniquePaths {

	public static void main(String[] args) {
		type0();
		type1();
		type2();
		type3();
		type4();
	}

	// Optimal approach
	// combination approach
	// if m=3 n=2 then sequence can be RRD,RDR,DRR
	// distance traveled is 3
	// if our starting point is 1,1 and ending point is m,n
	// so distance traveled is (m-1 + n-1) => m+n-2 // one step at a time
	// so out of m+n-2 distance it has to go m-1 distance right and n-1 down
	// it has become a problem of combination out of m+n-2 position how many ways
	// (m-1) times R can be placed or how many ways (n-1) times D can be placed
	// which will be (m+n-2) C (m-1)
	// time complexity is O(min(m,n))
	// space complexity is O(1)
	// take either float or double or long
	private static void type4() {
		int m = 19, n = 13;
		int count = uniquePaths5(m, n);
		System.out.println("count is " + count);
	}

	public static int uniquePaths5(int m, int n) {
		long N = m + n - 2;
		long R = m < n ? m - 1 : n - 1;
		long count = 1;
		for (int i = 1; i <= R; i++) {
			count = count * (N - i + 1) / i;
		}
		return (int) count;
	}

	// dynamic programming approach
	// iterative way
	// time complexity O(m*n)
	// space complexity O(m*n) + O(max(m,n))
	private static void type3() {
		int m = 3, n = 2;
		int[][] memo = new int[m][n];
		// initializing the starting cell and first row and the first column
		memo[1][1] = 1;
		for (int i = 1; i < m; i++) memo[i][0] = 1;
		for (int j = 1; j < n; j++) memo[0][j] = 1;
		// filling up the remaining cell
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				memo[i][j] = memo[i - 1][j] + memo[i][j - 1];

		System.out.println("count is " + memo[m][n]);
	}

	// dynamic programming approach
	// recursive way
	// time complexity
	// space complexity O(m*n) + O(max(m,n))
	private static void type2() {
		int m = 3, n = 2;
		int[][] memo = new int[m][n];
		int count = findPaths(0, 0, m, n, memo);
		System.out.println("count is " + count);
	}

	private static int findPaths(int i, int j, int m, int n, int[][] memo) {
		// out of bounds
		if (i >= m || j >= n) return 0;
		// we have reached the destination
		if (i == m - 1 && j == n - 1) return 1;
		// if it is already calculated, then we will directly return the answer
		if (memo[i][j] != 0) return memo[i][j];
		// we will traverse and also store the result
		return memo[i][j] = findPaths(i + 1, j, m, n, memo)
				+ findPaths(i, j + 1, m, n, memo);
	}

	// brute force approach
	// time complexity
	// space complexity
	// same as previous just here the starting and ending are different
	private static void type1() {
		int m = 3, n = 2;
		int count = findPaths(0, 0, m, n);
		System.out.println("count is " + count);
	}

	private static int findPaths(int i, int j, int m, int n) {
		// out of bounds
		if (i >= m || j >= n) return 0;
		// we have reached the destination
		if (i == m - 1 && j == n - 1) return 1;
		// else we have 2 choices
		return findPaths(i + 1, j, m, n) + findPaths(i, j + 1, m, n);
	}

	// brute force approach
	// time complexity
	// space complexity
	private static void type0() {
		int n = 3;
		int m = 2;
		int count = findPaths(n - 1, m - 1);
		System.out.println("count is " + count);
	}

	private static int findPaths(int n, int m) {
		// out of bounds
		if (n < 0 || m < 0) return 0;
		// we have reached the destination
		if (n == 0 && m == 0) return 1;
		// else we have 2 choices
		return findPaths(n - 1, m) + findPaths(n, m - 1);
	}

}
