package com.problems.dp;

import java.util.Arrays;


/*
 *
 * problem links :
 * https://www.codingninjas.com/studio/problems/ninja%E2%80%99s-training_3621003
 * https://www.geeksforgeeks.org/problems/geeks-training/1
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
        type4();
    }


    private static void type4() {
        int[][] points = {
                {1, 2, 5},
                {3, 1, 1},
                {3, 3, 3}
        };
        int n = points.length;
        int[] prev = new int[4];
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        for (int day = 1; day < n; day++) {
            int[] current = new int[4];
            for (int last = 0; last < 4; last++) {
                current[last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        current[last] = Math.max(current[last], points[day][task] + prev[task]);
                    }
                }
            }
            prev = current;
        }
        System.out.println(prev[3]);
    }


    private static void type3() {
        int[][] points = {
                {1, 2, 5},
                {3, 1, 1},
                {3, 3, 3}
        };
        int n = points.length;
        int[][] dp = new int[n][4];
        dp[0][0] = max(points[0][1], points[0][2]);
        dp[0][1] = max(points[0][0], points[0][2]);
        dp[0][2] = max(points[0][0], points[0][1]);
        dp[0][3] = max(points[0][1], points[0][1], points[0][2]);

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                int max = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[day - 1][task];
                        max = Math.max(max, point);
                    }
                }
                dp[day][last] = max;
            }
        }
        System.out.println(dp[n - 1][3]);
    }

    private static int max(int num, int... nums) {
        int max = num;
        for (int nm : nums)
            max = Math.max(max, nm);
        return max;
    }


    private static void type2() {
        int[][] points = {
                {1, 2, 5},
                {3, 1, 1},
                {3, 3, 3}
        };
        int n = points.length;
        int[][] dp = new int[n][4];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        int answer = ninjaTraining(n - 1, points, 3, dp);
        System.out.println(answer);
    }

    private static int ninjaTraining(int n, int[][] points, int last, int[][] dp) {
        int max = 0;
        if (n == 0) {
            for (int task = 0; task < 3; task++) {
                if (task != last)
                    max = Math.max(max, points[n][task]);
            }
            return dp[n][last] = max;
        }
        if (dp[n][last] != -1) return dp[n][last];

        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[n][task] + ninjaTraining(n - 1, points, task, dp);
                max = Math.max(max, point);
            }
        }
        return dp[n][last] = max;
    }

    private static void type1() {
        int[][] points = {
                {1, 2, 5},
                {3, 1, 1},
                {3, 3, 3}
        };
        int n = points.length;
        int answer = ninjaTraining(n - 1, points, 3);
        System.out.println(answer);
    }

    private static int ninjaTraining(int n, int[][] points, int last) {
        int max = 0;
        // if we are on the last row, then we will return the max out
        if (n == 0) {
            for (int task = 0; task < 3; task++) {
                if (task != last)
                    max = Math.max(max, points[n][task]);
            }
            return max;
        }
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[n][task] + ninjaTraining(n - 1, points, task);
                max = Math.max(max, point);
            }

        }
        return max;
    }
}
