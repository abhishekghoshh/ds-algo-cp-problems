package com.github.ds.dp;

import java.util.Arrays;

import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.System.out;

/*
 *
 * problem links :
 * https://www.codingninjas.com/studio/problems/frog-jump_3621012
 *
 * Solution link :
 * https://www.youtube.com/watch?v=EgG3jsGoPvQ&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=4
 *
 * https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/
 * */
public class FrogJump {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
        type4();
    }

    // using tabulation with memory optimization
    // Time complexity O(n)
    // space complexity O(1)
    // we will compute from 0th to n-1 th height
    // it is same as previous
    // we just need last and 2nd last value in order to compute the current
    // we can just hold those two values in 2 variable prev and prev2
    private static void type4() {
        int[] heights = {7, 4, 4, 2, 6, 6, 3, 4};
        int n = heights.length;
        // from 0 to 0
        int prev2 = 0;
        // from 0 to 1
        int prev = abs(heights[1] - heights[0]);
        // we will be starting from 2 to n-1
        for (int i = 2; i < n; i++) {
            // first we will calculate energy from the previous
            int jumpFromPrev = abs(heights[i] - heights[i - 1]) + prev;
            // then we will calculate energy from the previous of previous
            int jumpFromPrev2 = abs(heights[i] - heights[i - 2]) + prev2;
            // we will take the minimum
            int current = min(jumpFromPrev, jumpFromPrev2);
            // we will update those 2 variables
            prev2 = prev;
            prev = current;
        }
        out.println(prev);
    }

    // using tabulation
    // Time complexity O(n)
    // space complexity O(n) for and array
    // we will compute from 0th to n-1 th height
    // memo[0] is 0 because if we are in 0th cell we don't have to move anywhere
    private static void type3() {
        int[] heights = {7, 4, 4, 2, 6, 6, 3, 4};
        int n = heights.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = abs(heights[1] - heights[0]);
        for (int i = 2; i < n; i++) {
            // first we are jumping from the previous
            int prev = abs(heights[i] - heights[i - 1]) + memo[i - 1];
            // then we are jumping from the previous of previous
            int prev2 = abs(heights[i] - heights[i - 2]) + memo[i - 2];
            // then we are taking the minimum from these two value
            memo[i] = min(prev, prev2);
        }
        out.println(memo[n - 1]);
    }

    // using Memoization
    // Time complexity O(n)
    // space complexity O(2n) for stack space and array
    // memo[0] is 0 because if we are in 0th cell we don't have to move anywhere
    private static void type2() {
        int[] heights = {7, 4, 4, 2, 6, 6, 3, 4};
        int n = heights.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        int answer = frogJump(n - 1, heights, memo);
        out.println(answer);
    }

    // same as previous just we are saving 0-ith value in a 1D array
    private static int frogJump(int i, int[] heights, int[] memo) {
        if (i == 0)
            return 0;
        if (memo[i] != -1)
            return memo[i];
        int fromPrev = abs(heights[i] - heights[i - 1]) + frogJump(i - 1, heights, memo);
        int fromPrev2 = Integer.MAX_VALUE;
        if (i >= 2)
            fromPrev2 = abs(heights[i] - heights[i - 2]) + frogJump(i - 2, heights, memo);
        return memo[i] = min(fromPrev, fromPrev2);
    }

    // using Recursion
    // Time complexity O(2^n)
    // space complexity O(n) for stack space
    private static void type1() {
        int[] heights = {7, 4, 4, 2, 6, 6, 3, 4};
        int n = heights.length;
        int answer = frogJump(n - 1, heights);
        out.println(answer);
    }

    // let's say we are going from n to 0th step
    // the answer will be same
    // so for any n we can either go n-1 th step or n-2 step
    // and recursion will give me answer of the remaining part
    // now I have to check which is smaller and need to return
    // for n-2 we just need to check if  n>=2
    private static int frogJump(int i, int[] heights) {
        if (i == 0)
            return 0;
        int fromPrev = abs(heights[i] - heights[i - 1]) + frogJump(i - 1, heights);
        int fromPrev2 = Integer.MAX_VALUE;
        if (i >= 2)
            fromPrev2 = abs(heights[i] - heights[i - 2]) + frogJump(i - 2, heights);
        return min(fromPrev, fromPrev2);
    }
}
