package com.github.ds.dp;

import java.util.Arrays;

/*
 *
 * problem links :
 * https://leetcode.com/problems/climbing-stairs/
 * https://www.codingninjas.com/studio/problems/count-ways-to-reach-the-n-th-stairs_798650
 *
 * Solution link :
 * https://www.youtube.com/watch?v=tyB0ztf0DNY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=2
 *
 * https://takeuforward.org/data-structure/dynamic-programming-climbing-stairs/
 * */
public class ClimbingStairs {
    // This problem is same as fibonacci series
    public static void main(String[] args) {
        type1();
        type2();
        type3();
        type4();
    }

    // using tabulation with memory optimization
    // Time complexity O(n)
    // space complexity O(1)
    private static void type4() {
        int n = 10;
        int prev2 = 1;
        int prev = 1;
        int current;
        for (int i = 2; i <= n; i++) {
            current = prev + prev2;
            prev2 = prev;
            prev = current;
        }
        System.out.println(prev);
    }

    // using tabulation
    // Time complexity O(n)
    // space complexity O(n) for array
    private static void type3() {
        int n = 10;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        System.out.println(memo[n]);
    }

    // using memoization
    // Time complexity O(n)
    // space complexity O(n) for stack space
    private static void type2() {
        int n = 10;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        int answer = climbStairs(n, memo);
        System.out.println(answer);
    }

    private static int climbStairs(int n, int[] memo) {
        if (n <= 1) {
            return 1;
        } else if (memo[n] != -1) {
            return memo[n];
        } else {
            return memo[n] = climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    // using Recursion
    // Time complexity O(2^n)
    // space complexity O(n) for stack space
    private static void type1() {
        int n = 10;
        int answer = climbStairs(n);
        System.out.println(answer);
    }


    private static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
}
