package com.problems.dp;

import java.util.Arrays;

/*
 *
 * problem links :
 * https://leetcode.com/problems/minimum-path-sum/
 * https://www.naukri.com/code360/problems/minimum-path-sum_985349
 *
 * Solution link :
 * https://www.youtube.com/watch?v=_rgTlyky1uQ&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=11
 *
 * https://takeuforward.org/data-structure/minimum-path-sum-in-a-grid-dp-10/
 * */
public class MinimumPathSum {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
        type4();
        type5();
    }

    // we can space optimize by using a single dimensional dp array, but I feel that is unnecessary
    private static void type5() {
    }

    // exactly like the previous type just here we are initializing the 0th row and column
    // so that we do not need to check fot the out of bounds
    private static void type4() {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        // initialization
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) dp[i][0] = grid[i][0] + dp[i - 1][0];
        for (int i = 1; i < m; i++) dp[0][i] = grid[0][i] + dp[0][i - 1];
        // we will go from the 1 to n-1,
        // so we do not have to check for the out of bounds
        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++)
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);

        System.out.println(dp[n - 1][m - 1]);
    }

    // bottom-up approach
    private static void type3() {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int n = grid.length;
        int m = grid[0].length;
        int[][] memo = new int[n][m];
        // we will go from the 0 to n-1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    memo[i][j] = grid[i][j];
                } else {
                    // same as the recursion also checking if i-1 or j-1 is not out of bounds
                    int up = i > 0 ? memo[i - 1][j] : Integer.MAX_VALUE;
                    int left = j > 0 ? memo[i][j - 1] : Integer.MAX_VALUE;
                    memo[i][j] = grid[i][j] + Math.min(up, left);
                }
            }
        }
        System.out.println(memo[n - 1][m - 1]);
    }

    private static void type2() {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int n = grid.length;
        int m = grid[0].length;
        int[][] memo = new int[n][m];
        for (int[] row : memo) Arrays.fill(row, -1);
        int ans = minPathSum(grid, n - 1, m - 1, memo);
        System.out.println(ans);
    }

    private static int minPathSum(int[][] grid, int n, int m, int[][] memo) {
        // n or m is out of bounds
        if (n < 0 || m < 0) return Integer.MAX_VALUE;
        // if we reach to the 0,0 then we will return the answer
        if (n == 0 && m == 0) return grid[n][m];
        // if the cell value is already calculated, then we will return
        if (memo[n][m] != -1) return memo[n][m];
        // else we have 2 choices, to go up or left, and take the minimum among them
        // also store the result
        return memo[n][m] = grid[n][m] + Math.min(
                minPathSum(grid, n - 1, m, memo),
                minPathSum(grid, n, m - 1, memo));
    }

    private static void type1() {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int n = grid.length;
        int m = grid[0].length;
        int ans = minPathSum(grid, n - 1, m - 1);
        System.out.println(ans);
    }

    private static int minPathSum(int[][] grid, int n, int m) {
        // n or m is out of bounds
        if (n < 0 || m < 0) return Integer.MAX_VALUE;
        // if we reach to the 0,0 then we will return the answer
        if (n == 0 && m == 0) return grid[n][m];
        // else we have 2 choices, to go up or left, and take the minimum among them
        return grid[n][m] + Math.min(
                minPathSum(grid, n - 1, m),
                minPathSum(grid, n, m - 1));
    }
}
