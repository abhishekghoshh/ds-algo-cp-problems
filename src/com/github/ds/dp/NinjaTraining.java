package com.github.ds.dp;

import java.util.Arrays;

/*
 *
 * problem links :
 * https://www.codingninjas.com/studio/problems/ninja%E2%80%99s-training_3621003
 *
 * Solution link :
 * https://www.youtube.com/watch?v=AE39gJYuRog&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=8
 *
 * https://takeuforward.org/data-structure/dynamic-programming-ninjas-training-dp-7/
 * */
public class NinjaTraining {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    private static void type3() {
        int[][] points = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        int n = points.length;
        int[][] memo = new int[n][3];

    }

    private static void type2() {
        int[][] points = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        int n = points.length;
        int[][] memo = new int[n][4];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1);
        int answer = ninjaTraining(n - 1, points, 3, memo);
        System.out.println(answer);
    }

    private static int ninjaTraining(int i, int[][] points, int last, int[][] memo) {
        int max = 0;
        if (i == 0) {
            for (int j = 0; j < 3; j++) {
                if (j != last)
                    max = Math.max(max, points[i][j]);
            }
            return memo[i][last] = max;
        }
        if (memo[i][last] != -1)
            return memo[i][last];
        for (int j = 0; j < 3; j++) {
            if (j != last)
                max = Math.max(max, points[i][j] + ninjaTraining(i - 1, points, j, memo));
        }
        return memo[i][last] = max;
    }

    private static void type1() {
        int[][] points = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        int n = points.length;
        int answer = ninjaTraining(n - 1, points, 3);
        System.out.println(answer);
    }

    private static int ninjaTraining(int i, int[][] points, int last) {
        int max = 0;
        if (i == 0) {
            for (int j = 0; j < 3; j++) {
                if (j != last)
                    max = Math.max(max, points[i][j]);
            }
            return max;
        }
        for (int j = 0; j < 3; j++) {
            if (j != last)
                max = Math.max(max, points[i][j] + ninjaTraining(i - 1, points, j));
        }
        return max;
    }
}
