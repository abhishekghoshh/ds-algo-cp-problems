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

    // we will use a monotonic increasing stack to find the next greater temperature
    private static void type2() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = dailyTemperatures2(temperatures);
        print(ans);
    }

    // we will use an array and a top variable and use that as stack
    public static int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        if (n == 1) return new int[]{0};
        int[] ans = new int[n];
        // this will be our stack
        int top = -1;
        int[] stack = new int[n];
        // now we will compute from the back
        for (int i = n - 1; i >= 0; i--) {
            // we will pop from the stack (decrease top) if stack contains lesser or equal temperature
            while (top != -1 && temperatures[i] >= temperatures[stack[top]]) top--;
            // checking if there is any element on stack and based on that we will add it to answer
            ans[i] = (top != -1) ? (stack[top] - i) : 0;
            // adding the current element to the stack
            stack[++top] = i;
        }
        return ans;
    }

    // we will brute force approach for this
    private static void type1() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = dailyTemperatures1(temperatures);
        print(ans);
    }

    // for every index we will find its next highest temperature
    public static int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        if (n == 1) return new int[]{0};
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int temp = temperatures[i], next = -1;
            for (int j = i + 1; j < n; j++) {
                if (temp < temperatures[j]) {
                    next = j;
                    break;
                }
            }
            ans[i] = (next != -1) ? (next - i) : 0;
        }
        return ans;
    }
}
