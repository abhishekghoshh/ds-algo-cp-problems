package com.problems.dp;

/*
 * Problem link :
 * https://leetcode.com/problems/construct-string-with-minimum-cost
 *
 * Solution link :
 *
 */
public class CountSubmatricesWithEqualFrequencyOfXandY {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    private static void type3() {
        char[][] grid = {
                {'X', 'Y', '.' },
                {'Y', '.', '.' }
        };
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        int count = 0;
        int colX = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int leftX = 0, leftY = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'X' && colX > j) colX = j;

                leftX = (grid[i][j] == 'X' ? 1 : 0) + leftX;
                leftY = (grid[i][j] == 'Y' ? 1 : 0) + leftY;

                dp[j] = leftX - leftY + (i > 0 ? dp[j] : 0);

                if (j >= colX && dp[j] == 0) count++;
            }
        }
        System.out.println(count);
    }

    private static void type2() {
        char[][] grid = {
                {'X', 'Y', '.' },
                {'Y', '.', '.' }
        };
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        int count = 0;
        int colX = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int leftX = 0, leftY = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'X') colX = Math.min(colX, j);

                leftX = (grid[i][j] == 'X' ? 1 : 0) + leftX;
                leftY = (grid[i][j] == 'Y' ? 1 : 0) + leftY;

                dp[i][j] = leftX - leftY + (i > 0 ? dp[i - 1][j] : 0);

                if (j >= colX && dp[i][j] == 0) count++;
            }
        }
        System.out.println(count);
    }

    // Using iterative approach
    // Intution is like
    private static void type1() {
        char[][] grid = {
                {'X', 'Y', '.' },
                {'Y', '.', '.' }
        };

        int m = grid.length, n = grid[0].length;
        int[][] dpX = new int[m][n];
        int[][] dpY = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            int leftX = 0, leftY = 0;
            for (int j = 0; j < n; j++) {
                int topX = i > 0 ? dpX[i - 1][j] : 0;
                int topY = i > 0 ? dpY[i - 1][j] : 0;

                leftX = (grid[i][j] == 'X' ? 1 : 0) + leftX;
                leftY = (grid[i][j] == 'Y' ? 1 : 0) + leftY;

                dpX[i][j] = topX + leftX;
                dpY[i][j] = topY + leftY;

                if (dpX[i][j] > 0 && dpX[i][j] == dpY[i][j]) count++;
            }
        }
        System.out.println(count);
    }
}
