package com.ds.striver.dp;

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
        int[][] memo = new int[grid.length][grid.length];
        for (int[] row : memo) Arrays.fill(row, -2);
        int result = Math.max(cherryPickup(grid, 0, 0, memo), 0);
        System.out.println(result);
    }

    public static int cherryPickup(int[][] grid, int i, int j, int[][] memo) {

        int n = grid.length;
        if (i >= n || j >= n || grid[i][j] == -1) return -1;
        if (memo[i][j] != -2) return memo[i][j];
        int cherry = grid[i][j];
        if (cherry == 1) grid[i][j]=-1;
        if (i == n - 1 && j == n - 1) {
            int[][] backMemo = new int[n][n];
            for (int[] row : backMemo) Arrays.fill(row, -2);
            int backCherry = reverseCherryPickup(grid, n - 1, n - 1, backMemo);
            if (cherry == 1) grid[i][j]++;
            System.out.println("backCherry " + backCherry);
            System.out.println("cherry " + cherry);
            return backCherry >= 0 ? cherry + backCherry : -1;
        }
        int result = Math.max(cherryPickup(grid, i, j + 1, memo), cherryPickup(grid, i + 1, j, memo));
        if (cherry == 1) grid[i][j]++;
        memo[i][j] = result >= 0 ? cherry + result : -1;
        System.out.println("i ,j " + i + "," + j + " result " + memo[i][j]);
        return memo[i][j];
    }

    // -2 not computed
    // -1 no path
    private static int reverseCherryPickup(int[][] grid, int i, int j, int[][] memo) {
        if (i < 0 || j < 0 || grid[i][j] == -1) return -1;
        if (memo[i][j] != -2) return memo[i][j];
        int cherry = grid[i][j];
        if (cherry == 1) grid[i][j]--;
        if (i == 0 && j == 0) return cherry;
        int result = Math.max(reverseCherryPickup(grid, i, j - 1, memo), reverseCherryPickup(grid, i - 1, j, memo));
        if (cherry == 1) grid[i][j]++;
        return memo[i][j] = result >= 0 ? cherry + result : -1;
    }

    private static void type1() {
        int[][] grid = {
                {0, 1, -1},
                {1, 0, -1},
                {1, 1, 1}
        };
        int result = Math.max(cherryPickup(grid, 0, 0), 0);
        System.out.println(result);
    }

    public static int cherryPickup(int[][] grid, int i, int j) {
        int n = grid.length;
        if (i >= n || j >= n || grid[i][j] == -1) return -1;
        int cherry = grid[i][j];
        if (cherry == 1) grid[i][j]--;
        if (i == n - 1 && j == n - 1) {
            int backCherry = reverseCherryPickup(grid, n - 1, n - 1);
            return backCherry >= 0 ? cherry + backCherry : -1;
        }
        int result = Math.max(cherryPickup(grid, i, j + 1), cherryPickup(grid, i + 1, j));
        if (cherry == 1) grid[i][j]++;
        return result >= 0 ? cherry + result : -1;
    }

    private static int reverseCherryPickup(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || grid[i][j] == -1) return -1;
        int cherry = grid[i][j];
        if (cherry == 1) grid[i][j]--;
        if (i == 0 && j == 0) return cherry;
        int result = Math.max(reverseCherryPickup(grid, i, j - 1), reverseCherryPickup(grid, i - 1, j));
        if (cherry == 1) grid[i][j]++;
        return result >= 0 ? cherry + result : -1;
    }
}
