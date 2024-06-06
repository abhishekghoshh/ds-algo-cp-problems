package com.problems.dp;

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

    // TODO
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
        int count = cherryPickup2(grid);
        System.out.println(count);
    }

    private static int cherryPickup2(int[][] grid) {
        int n = grid.length;
        if (n == 1) return grid[0][0];
        int[][][][] dp = new int[n][n][n][n];
        for (int[][][] dp1 : dp)
            for (int[][] dp2 : dp1)
                for (int[] dp3 : dp2) Arrays.fill(dp3, -1);
        return Math.max(cherryPickup2(0, 0, 0, 0, n, grid, dp), 0);
    }

    private static int cherryPickup2(int i1, int j1, int i2, int j2, int n, int[][] grid, int[][][][] dp) {
        if (i1 >= n || j1 >= n || i2 >= n || j2 >= n
                || grid[i1][j1] == -1 || grid[i2][j2] == -1)
            return Integer.MIN_VALUE;
        if (dp[i1][j1][i2][j2] != -1) return dp[i1][j1][i2][j2];
        int cherry = (i1 == i2) && (j1 == j2) ?
                grid[i1][j1] :
                (grid[i1][j1] + grid[i2][j2]);
        if (i1 == n - 1 && j1 == n - 1 && j2 == n - 1) return cherry;
        // we have four choices
        int choice1 = cherryPickup2(i1 + 1, j1, i2 + 1, j2, n, grid, dp);
        int choice2 = cherryPickup2(i1 + 1, j1, i2, j2 + 1, n, grid, dp);
        int choice3 = cherryPickup2(i1, j1 + 1, i2 + 1, j2, n, grid, dp);
        int choice4 = cherryPickup2(i1, j1 + 1, i2, j2 + 1, n, grid, dp);
        return dp[i1][j1][i2][j2] = cherry + max(choice1, choice2, choice3, choice4);
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

    private static int cherryPickup(int[][] grid) {
        int n = grid.length;
        if (n == 1) return grid[0][0];
        return Math.max(cherryPickup(0, 0, 0, 0, n, grid), 0);
    }

    private static int cherryPickup(int i1, int j1, int i2, int j2, int n, int[][] grid) {
        if (i1 >= n || j1 >= n || i2 >= n || j2 >= n
                || grid[i1][j1] == -1 || grid[i2][j2] == -1)
            return Integer.MIN_VALUE;
        int cherry = (i1 == i2) && (j1 == j2) ?
                grid[i1][j1] :
                (grid[i1][j1] + grid[i2][j2]);
        if (i1 == n - 1 && j1 == n - 1 && j2 == n - 1) return cherry;
        // we have four choices
        int choice1 = cherryPickup(i1 + 1, j1, i2 + 1, j2, n, grid);
        int choice2 = cherryPickup(i1 + 1, j1, i2, j2 + 1, n, grid);
        int choice3 = cherryPickup(i1, j1 + 1, i2 + 1, j2, n, grid);
        int choice4 = cherryPickup(i1, j1 + 1, i2, j2 + 1, n, grid);
        return cherry + max(choice1, choice2, choice3, choice4);
    }

    private static int max(int... vals) {
        int max = Integer.MIN_VALUE;
        for (int val : vals) if (max < val) max = val;
        return max;
    }
}
