package com.problems.stack;

import static com.util.PrintUtl.print;

/*
 * Problem link :
 * https://leetcode.com/problems/daily-temperatures/description/
 *
 * Solution link :
 *
 * */
public class DailyTemperatures {
    public static void main(String[] args) {
        type1();
        type2();
    }

    private static void type2() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = dailyTemperatures2(temperatures);
        print(ans);
    }

    public static int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        if (n == 1) return new int[]{0};
        return null;
    }

    // we will brute force approach for this
    private static void type1() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = dailyTemperatures1(temperatures);
        print(ans);
    }

    public static int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        if (n == 1) return new int[]{0};
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int temp = temperatures[i], next = 0;
            for (int j = i + 1; j < n; j++) {
                if (temp < temperatures[j]) {
                    next = j;
                    break;
                }
            }
            ans[i] = next;
        }
        return ans;
    }
}
