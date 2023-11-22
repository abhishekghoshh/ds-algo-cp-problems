package com.ds.striver.dp;

import java.util.Arrays;

/*
 *
 * problem links :
 *
 *
 * Solution link :
 *
 *
 *
 * */
public class MinimumPathSum {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    private static void type3() {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int n = grid.length;
        int m = grid[0].length;
        int[][] memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    memo[i][j] = grid[i][j];
                } else {
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
        for (int[] row : memo)
            Arrays.fill(row, -1);
        int ans = minPathSum(grid, n - 1, m - 1, memo);
        System.out.println(ans);
    }

    private static int minPathSum(int[][] grid, int n, int m, int[][] memo) {
        if (n == 0 && m == 0)
            return grid[n][m];
        if (n < 0 || m < 0)
            return Integer.MAX_VALUE;
        if (memo[n][m] != -1)
            return memo[n][m];
        return memo[n][m] = grid[n][m] + Math.min(minPathSum(grid, n - 1, m, memo), minPathSum(grid, n, m - 1, memo));
    }

    private static void type1() {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int n = grid.length;
        int m = grid[0].length;
        int ans = minPathSum(grid, n - 1, m - 1);
        System.out.println(ans);
    }

    private static int minPathSum(int[][] grid, int n, int m) {
        if (n == 0 && m == 0)
            return grid[n][m];
        if (n < 0 || m < 0)
            return Integer.MAX_VALUE;
        return grid[n][m] + Math.min(minPathSum(grid, n - 1, m), minPathSum(grid, n, m - 1));
    }
}
