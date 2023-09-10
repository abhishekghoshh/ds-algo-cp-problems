package com.github.ds.jumpgame;

import java.util.Arrays;

/*
 *
 * problem links :
 * https://leetcode.com/problems/jump-game-ii/
 *
 * Solution link :
 * https://www.youtube.com/watch?v=BRnRPLNGWIo&list=PLJtzaiEpVo2yaP5v5bq0-QJgU0lO3TrEi&index=2
 *
 * https://github.com/Algorithms-Made-Easy/Leetcode-Challenge/blob/main/45.%20Jump%20Game%20II
 * */
public class JumpGame2 {
    public static void main(String[] args) {
        type1();
        type2();

    }

    // using dynamic programming
    private static void type2() {
        int[] nums = {2, 3, 1, 1, 4};
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // if we are n-1 then minimum step to go to n-1 will obviously be 0
        dp[n - 1] = 0;
    }


    // brute force solution
    private static void type1() {
        int[] nums = {2, 3, 1, 1, 4};
        int n = nums.length;
        int[] minPath = new int[n];
        Arrays.fill(minPath, 10000);
        minPath[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int max = nums[i];
            for (int j = max; j > 0; j--) {
                if (i + j < n) {
                    minPath[i] = Math.min(minPath[i], 1 + minPath[i + j]);
                }
            }
        }
        System.out.println(minPath[0]);
    }

}
