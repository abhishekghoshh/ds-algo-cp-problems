package com.github.ds.dp;

/*
 *
 * problem links :
 * https://leetcode.com/problems/house-robber/
 * https://www.codingninjas.com/studio/problems/maximum-sum-of-non-adjacent-elements_843261
 *
 * Solution link :
 * https://www.youtube.com/watch?v=GrMBfJNk_NY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=6
 *
 * https://takeuforward.org/data-structure/maximum-sum-of-non-adjacent-elements-dp-5/
 * */

import java.util.Arrays;

public class HouseRobber1 {
    // The problem is very similar to maximum sum of non-adjacent element in an array
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
        int[] nums = {2, 7, 9, 3, 1};
        int n = nums.length;
        int prev2 = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        int current, takeCurrentHome, notTakeCurrentHome;
        for (int i = 2; i < n; i++) {
            takeCurrentHome = nums[i] + prev2;
            notTakeCurrentHome = prev;
            current = Math.max(takeCurrentHome, notTakeCurrentHome);
            prev2 = prev;
            prev = current;
        }
        System.out.println(prev);
    }

    // using tabulation
    // Time complexity O(k*n)
    // space complexity O(n) for array
    private static void type3() {
        int[] nums = {2, 7, 9, 3, 1};
        int n = nums.length;
        int[] memo = new int[n];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int takeCurrentHome = nums[i] + memo[i - 2];
            int notTakeCurrentHome = memo[i - 1];
            memo[i] = Math.max(takeCurrentHome, notTakeCurrentHome);
        }
        System.out.println(memo[n - 1]);
    }

    // using memoization
    // Time complexity O(n)
    // space complexity O(2n) for stack space and array
    private static void type2() {
        int[] nums = {2, 7, 9, 3, 1};
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int answer = houseRobber(n - 1, nums, memo);
        System.out.println(answer);
    }

    private static int houseRobber(int i, int[] nums, int[] memo) {
        if (i == 0)
            return nums[i];
        if (i < 0)
            return 0;
        if (memo[i] != -1)
            return memo[i];
        int takeCurrentHome = nums[i] + houseRobber(i - 2, nums, memo);
        int notTakeCurrentHome = houseRobber(i - 1, nums, memo);
        return memo[i] = Math.max(takeCurrentHome, notTakeCurrentHome);
    }

    // using Recursion
    // Time complexity O(2^n)
    // space complexity O(n) for stack space
    private static void type1() {
        int[] nums = {2, 7, 9, 3, 1};
        int n = nums.length;
        int answer = houseRobber(n - 1, nums);
        System.out.println(answer);
    }

    // for every home we have 2 choices, we can either take the home
    // or not to take it, but if we take it then we can not take its adjacent element
    // when i==0 that means it is last house we have no other choice other than taking it
    // when i<0 that means we were in 1th index and now it can not go to the 0th index
    // so it went to 1-2 => -1 th index
    private static int houseRobber(int i, int[] nums) {
        if (i == 0)
            return nums[i];
        if (i < 0)
            return 0;
        int takeCurrentHome = nums[i] + houseRobber(i - 2, nums);
        int notTakeCurrentHome = houseRobber(i - 1, nums);
        return Math.max(takeCurrentHome, notTakeCurrentHome);
    }

}
