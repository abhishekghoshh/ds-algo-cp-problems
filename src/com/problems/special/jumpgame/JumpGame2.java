package com.problems.special.jumpgame;

import java.util.Arrays;

/*
 *
 * problem links :
 * https://leetcode.com/problems/jump-game-ii/
 * https://www.codingninjas.com/studio/problems/jump-game_893178
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
        type3();
        type4();
    }

    private static void type4() {
        int[] nums = {2, 3, 1, 1, 4};
        int ans = jump(nums, 0, nums.length);
        System.out.println(ans);
    }

    private static int jump(int[] nums, int cur, int n) {
        if (cur >= n - 1) return 0;
        if (cur + nums[cur] >= n - 1) return 1;
        int maxIndex = cur + 1;
        for (int i = cur + 2; i <= cur + nums[cur]; i++)
            if (i + nums[i] > maxIndex + nums[maxIndex]) maxIndex = i;
        return 1 + jump(nums, maxIndex, n);
    }

    //
    private static void type3() {
        int[] nums = {2, 3, 1, 1, 4};
        int n = nums.length;
        int begin = 0, end = 0, farthest = 0;
        int jump = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                jump++;
                end = farthest;
            }
        }
        System.out.println(jump);
    }

    // using dynamic programming
    // using O(n^2)
    private static void type2() {
        int[] nums = {2, 3, 1, 1, 4};
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // if we are n-1 then minimum step to go to n-1 will obviously be 0
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j <= Math.min(n - 1, i + nums[i]); j++)
                min = Math.min(min, dp[j]);
            if (min != Integer.MAX_VALUE)
                dp[i] = min + 1;
        }
        System.out.println(dp[0]);
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
