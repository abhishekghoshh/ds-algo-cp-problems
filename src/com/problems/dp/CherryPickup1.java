package com.problems.dp;

import com.util.PrintUtl;

import java.util.Arrays;

/*
 *
 * problem links :
 * https://leetcode.com/problems/cherry-pickup/
 *
 * Solution link :
 *
 * */
public class CherryPickup1 {
    public static void main(String[] args) {
        type1();
        type2();
    }

    private static void type2() {
        int[][] grid = {
                {0, 1, -1},
                {1, 0, -1},
                {1, 1, 1}
        };

    }



    private static void type1() {
        int[][] grid = {
                {0, 1, -1},
                {1, 0, -1},
                {1, 1, 1}
        };
        int count = cherryPickup(grid);
        System.out.println(count);
    }

    public static int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++)
            if (dp[0][i - 1] == Integer.MIN_VALUE || grid[0][i] == -1)
                dp[0][i] = Integer.MIN_VALUE;
            else dp[0][i] = dp[0][i - 1] + grid[0][i];
        for (int i = 1; i < n; i++)
            if (dp[i - 1][0] == Integer.MIN_VALUE || grid[i][0] == -1)
                dp[i][0] = Integer.MIN_VALUE;
            else dp[i][0] = dp[i - 1][0] + grid[i][0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == -1) {
                    dp[i][j] = Integer.MIN_VALUE;
                    continue;
                }
                dp[i][j] = grid[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        if (dp[n - 1][n - 1] < 0) return 0;
        int cherryCount = dp[n - 1][n - 1];

        int x = n - 1, y = n - 1;
        while (x >= 0 && y >= 0) {
            if (grid[x][y] == 1) grid[x][y] = 0;
            int top = (x > 0) ? dp[x - 1][y] : Integer.MIN_VALUE;
            int left = (y > 0) ? dp[x][y - 1] : Integer.MIN_VALUE;
            if (top == left && top == Integer.MIN_VALUE) break;
            if (top > left) x--;
            else y--;
        }
        dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return cherryCount + cherryPickup(0, 0, n, grid, dp);
    }

    private static int cherryPickup(int i, int j, int n, int[][] grid, int[][] dp) {
        if (i >= n || j >= n || grid[i][j] == -1) return Integer.MIN_VALUE;
        if (dp[i][j] != -1) return dp[i][j];
        if (i == n - 1 && j == n - 1) return grid[i][j];
        return dp[i][j] = grid[i][j] + Math.max(
                cherryPickup(i + 1, j, n, grid, dp),
                cherryPickup(i, j + 1, n, grid, dp)
        );
    }


}
