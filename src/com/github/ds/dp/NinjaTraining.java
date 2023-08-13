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
        type4();
        type5();
        type6();
    }

    // same as type5 but without for loop
    private static void type6() {
        int[][] points = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        int n = points.length;
        int[] prev = new int[4];
        prev[0] = max(points[0][1], points[0][2]);
        prev[1] = max(points[0][0], points[0][2]);
        prev[2] = max(points[0][0], points[0][1]);
        prev[3] = max(points[0][1], points[0][1], points[0][2]);
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                int[] current = new int[4];
                int firstTaskTaken = points[day][0] + prev[0];
                int secondTaskTaken = points[day][1] + prev[1];
                int thirdTaskTaken = points[day][2] + prev[2];
                current[0] = max(secondTaskTaken, thirdTaskTaken);
                current[1] = max(firstTaskTaken, thirdTaskTaken);
                current[2] = max(firstTaskTaken, secondTaskTaken);
                current[3] = max(firstTaskTaken, secondTaskTaken, thirdTaskTaken);
                prev = current;
            }
        }
        System.out.println(prev[3]);
    }

    private static void type5() {
        int[][] points = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
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

    // same as type3 but without for loop
    private static void type4() {
        int[][] points = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        int n = points.length;
        int[][] memo = new int[n][4];
        memo[0][0] = max(points[0][1], points[0][2]);
        memo[0][1] = max(points[0][0], points[0][2]);
        memo[0][2] = max(points[0][0], points[0][1]);
        memo[0][3] = max(points[0][1], points[0][1], points[0][2]);
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                int firstTaskTaken = points[day][0] + memo[day - 1][0];
                int secondTaskTaken = points[day][1] + memo[day - 1][1];
                int thirdTaskTaken = points[day][2] + memo[day - 1][2];
                memo[day][0] = max(secondTaskTaken, thirdTaskTaken);
                memo[day][1] = max(firstTaskTaken, thirdTaskTaken);
                memo[day][2] = max(firstTaskTaken, secondTaskTaken);
                memo[day][3] = max(firstTaskTaken, secondTaskTaken, thirdTaskTaken);
            }
        }
        System.out.println(memo[n - 1][3]);

    }


    private static void type3() {
        int[][] points = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        int n = points.length;
        int[][] memo = new int[n][4];
        memo[0][0] = max(points[0][1], points[0][2]);
        memo[0][1] = max(points[0][0], points[0][2]);
        memo[0][2] = max(points[0][0], points[0][1]);
        memo[0][3] = max(points[0][1], points[0][1], points[0][2]);

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                int max = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        max = Math.max(max, points[day][task] + memo[day - 1][task]);
                    }
                }
                memo[day][last] = max;
            }
        }
        System.out.println(memo[n - 1][3]);
    }

    private static int max(int num, int... nums) {
        int max = num;
        for (int nm : nums)
            max = Math.max(max, nm);
        return max;
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
