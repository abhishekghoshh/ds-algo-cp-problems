package com.problems.array;

/*
 * Problem links:
 * https://leetcode.com/problems/equal-sum-grid-partition-i/description/
 * Solution link
 *
 * */

public class EqualSumGridPartition1 {
    public static void main(String[] args) {
        type1();
        type2();
    }

    private static void type2() {
    }

    // almost optimized
    // very simple approach
    // calculating row sum and colum sum
    private static void type1() {
        int[][] grid = {
                {1, 4},
                {2, 3}
        };
        boolean ans = canPartitionGrid1(grid);
        System.out.println(ans);
    }

    public static boolean canPartitionGrid1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[] lastColSum = new long[m];
        long[] lastRowSum = new long[n];
        long total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                lastColSum[i] += grid[i][j];
                lastRowSum[j] += grid[i][j];
            }
            total += lastColSum[i];
        }
        if (total % 2 == 1) return false;
        long curr = 0;
        for (long num : lastColSum) {
            curr += num;
            if (curr == total / 2) return true;
        }
        curr = 0;
        for (long num : lastRowSum) {
            curr += num;
            if (curr == total / 2) return true;
        }
        return false;
    }
}
