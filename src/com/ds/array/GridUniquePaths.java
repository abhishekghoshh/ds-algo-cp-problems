package com.ds.array;

/*
 * Problem link :
 * https://leetcode.com/problems/unique-paths/
 * https://www.codingninjas.com/codestudio/problems/1081470
 * 
 * Solution link
 * https://www.youtube.com/watch?v=t_f0nwwdg5o
 * 
 * https://takeuforward.org/data-structure/grid-unique-paths-count-paths-from-left-top-to-the-right-bottom-of-a-matrix/
 * 
 * */
public class GridUniquePaths {

	public static void main(String[] args) {
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
		long N = m + n - 2;
		long R = m < n ? m - 1 : n - 1;
		long count = 1;
		for (int i = 1; i <= R; i++) {
			count = count * (N - i + 1) / i;
		}
		System.out.println("count is " + count);
	}

	// dynamic programming approach
	// iterative way
	// time complexity O(m*n)
	// space complexity O(m*n) + O(max(m,n))
	private static void type3() {
		int m = 3, n = 2;
		int[][] memo = new int[m + 1][n + 1];
		memo[1][1] = 1;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 1 && j == 1) continue;
				memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
			}
		}
		System.out.println("count is " + memo[m][n]);
	}

	// dynamic programming approach
	// recursive way
	// time complexity
	// space complexity O(m*n) + O(max(m,n))
	private static void type2() {
		int m = 3, n = 2;
		int[][] memo = new int[m + 1][n + 1];
		memo[m][n] = 1;
		int count = findPaths(1, 1, m, n, memo);
		System.out.println("count is " + count);
	}

	private static int findPaths(int i, int j, int m, int n, int[][] memo) {
		if (i > m || j > n) return 0;
		else if (memo[i][j] != 0) return memo[i][j];
		else return memo[i][j] = findPaths(i + 1, j, m, n, memo) + findPaths(i, j + 1, m, n, memo);
	}

	// brute force approach
	// time complexity
	// space complexity
	private static void type1() {
		int m = 3, n = 2;
		int count = findPaths(1, 1, m, n);
		System.out.println("count is " + count);
	}

	private static int findPaths(int i, int j, int m, int n) {
		if (i > m || j > n) return 0;
		else if (i == m && j == n) return 1;
		else return findPaths(i + 1, j, m, n) + findPaths(i, j + 1, m, n);
	}

}
