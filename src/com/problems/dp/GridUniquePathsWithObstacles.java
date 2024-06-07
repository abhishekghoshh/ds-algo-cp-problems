package com.problems.dp;

import java.util.Arrays;

/*
 * problem links :
 * https://leetcode.com/problems/unique-paths-ii/description/
 * https://www.naukri.com/code360/problems/maze-obstacles_977241
 *
 * Solution link :
 * https://www.youtube.com/watch?v=TmhpgXScLyY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=10
 *
 * https://takeuforward.org/data-structure/grid-unique-paths-2-dp-9/
 * */
public class GridUniquePathsWithObstacles {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
        type4();
    }

    // same bottom-up approach with some initialization
    private static void type4() {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        // initialization
        // there is always a way for the first cell as we are standing right there
        dp[0][0] = 1;
        // for the first column
        for (int i = 1; i < n; i++)
            // if there is any obstacle in the cell or if the previous cell is unreachable, then we will set 0,
            // which means the current cell is also unreachable
            if (obstacleGrid[i][0] == 1 || dp[i - 1][0] == 0) dp[i][0] = 0;
            else dp[i][0] = 1;
        // for the first row
        for (int i = 1; i < m; i++)
            // if there is any obstacle in the cell or if the previous cell is unreachable, then we will set 0,
            // which means the current cell is also unreachable
            if (obstacleGrid[0][i] == 1 || dp[0][i - 1] == 0) dp[0][i] = 0;
            else dp[0][i] = 1;
        // let's fill up the remaining places
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // if there is any obstacle then we will not set the value of the dp
                if (obstacleGrid[i][j] == 1) continue;
                // else we will have 2 choices to take
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[n - 1][m - 1]);
    }

    // tabulation or the bottom-up approach
    private static void type3() {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        // as there is no initialization,
        // so we will start from (0,0), and go till (n-1,m-1)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // for the (0,0) cell it is always 1 as it is the base case
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (obstacleGrid[i][j] == 1) {
                    // if there is an obstacle, then we will make dp value as 0
                    dp[i][j] = 0;
                } else {
                    // else we have 2 options either up or left
                    dp[i][j] += i > 0 ? dp[i - 1][j] : 0;
                    dp[i][j] += j > 0 ? dp[i][j - 1] : 0;
                }
            }
        }
        System.out.println(dp[n - 1][m - 1]);
    }

    private static void type2() {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] memo = new int[n][m];
        for (int[] row : memo) Arrays.fill(row, -1);
        int answer = uniquePathsWithObstacles(obstacleGrid, n - 1, m - 1, memo);
        System.out.println(answer);
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid, int n, int m, int[][] memo) {
        // if it is out of bounds or there is an obstacle, then we will return 0
        if (n < 0 || m < 0 || obstacleGrid[n][m] == 1) return 0;
        // if we reached the (0,0) then we will return 1 as this is our base case
        if (n == 0 && m == 0) return 1;
        // checking if the cell is already calculated or not
        if (memo[n][m] != -1) return memo[n][m];
        return memo[n][m] = uniquePathsWithObstacles(obstacleGrid, n - 1, m, memo)
                + uniquePathsWithObstacles(obstacleGrid, n, m - 1, memo);
    }

    private static void type1() {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int answer = uniquePathsWithObstacles(obstacleGrid, n - 1, m - 1);
        System.out.println(answer);
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid, int n, int m) {
        // if it is out of bounds or there is an obstacle, then we will return 0
        if (n < 0 || m < 0 || obstacleGrid[n][m] == 1) return 0;
        // if we reached the (0,0) then we will return 1 as this is our base case
        if (n == 0 && m == 0) return 1;
        // we have 2 choices, either to go left or go up
        return uniquePathsWithObstacles(obstacleGrid, n - 1, m)
                + uniquePathsWithObstacles(obstacleGrid, n, m - 1);
    }
}
