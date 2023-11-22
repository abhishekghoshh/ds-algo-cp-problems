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
public class GridUniquePathsWithObstacles {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    private static void type3() {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    memo[i][j] = 1;
                } else if (obstacleGrid[i][j] == 1) {
                    memo[i][j] = 0;
                } else {
                    memo[i][j] += i > 0 ? memo[i - 1][j] : 0;
                    memo[i][j] += j > 0 ? memo[i][j - 1] : 0;
                }
            }
        }
        System.out.println(memo[n - 1][m - 1]);
    }

    private static void type2() {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] memo = new int[n][m];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        int answer = uniquePathsWithObstacles(obstacleGrid, n - 1, m - 1, memo);
        System.out.println(answer);
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid, int n, int m, int[][] memo) {
        if (n == 0 && m == 0)
            return 1;
        if (n < 0 || m < 0 || obstacleGrid[n][m] == 1)
            return 0;
        if (memo[n][m] != -1)
            return memo[n][m];
        return memo[n][m] = uniquePathsWithObstacles(obstacleGrid, n - 1, m, memo) + uniquePathsWithObstacles(obstacleGrid, n, m - 1, memo);
    }

    private static void type1() {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int answer = uniquePathsWithObstacles(obstacleGrid, n - 1, m - 1);
        System.out.println(answer);
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid, int n, int m) {
        if (n == 0 && m == 0)
            return 1;
        if (n < 0 || m < 0 || obstacleGrid[n][m] == 1)
            return 0;
        return uniquePathsWithObstacles(obstacleGrid, n - 1, m) + uniquePathsWithObstacles(obstacleGrid, n, m - 1);
    }
}
