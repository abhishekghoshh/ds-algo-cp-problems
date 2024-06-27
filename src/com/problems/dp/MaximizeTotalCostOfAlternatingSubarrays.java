package com.problems.dp;

/*
 * Problem link :
 * https://leetcode.com/problems/maximize-total-cost-of-alternating-subarrays/description/
 *
 * Solution link :
 *
 *
 */
public class MaximizeTotalCostOfAlternatingSubarrays {
    public static void main(String[] args) {
        type1();
        type2();
    }

    private static void type2() {
        int[] nums = {1, -2, 3, 4};
        long ans = maximumTotalCost2(nums);
        System.out.println(ans);
    }

    public static long maximumTotalCost2(int[] nums) {
        int n = nums.length;
        Long[][] dp = new Long[n][3];
        return maximumTotalCost2(nums, 0, 1, dp);
    }

    // we will use 3 flags 0,1,2
    // 0 means it is starting of the new subarray
    // 1 means use positive value for the current item
    // 2 means use negative for the current subarray
    public static long maximumTotalCost2(int[] nums, int i, int flag, Long[][] dp) {
        if (i == nums.length) return 0;
        long ch1, ch2;
        // if the cell is already calculated, then we will return the answer
        if (dp[i][flag] != null) return dp[i][flag];
        // for every number, we have two options
        // either to flip the sign or start a new subarray
        // we will take max out of them
        if (flag == 0 || flag == 1) {
            ch1 = nums[i] + maximumTotalCost2(nums, i + 1, 2, dp);
            ch2 = nums[i] + maximumTotalCost2(nums, i + 1, 0, dp);
        } else {
            ch1 = -nums[i] + maximumTotalCost2(nums, i + 1, 1, dp);
            ch2 = -nums[i] + maximumTotalCost2(nums, i + 1, 0, dp);
        }
        return dp[i][flag] = Math.max(ch1, ch2);
    }

    // simple old recursion
    private static void type1() {
        int[] nums = {1, -2, 3, 4};
        long ans = maximumTotalCost1(nums);
        System.out.println(ans);
    }

    public static long maximumTotalCost1(int[] nums) {
        return maximumTotalCost1(nums, 0, 1);
    }

    // we will use 3 flags 0,1,2
    // 0 means it is starting of the new subarray
    // 1 means use positive value for the current item
    // 2 means use negative for the current subarray
    public static long maximumTotalCost1(int[] nums, int i, int flag) {
        if (i == nums.length) return 0;
        long ch1, ch2;
        // for every number, we have two options
        // either to flip the sign or start a new subarray
        // we will take max out of them
        if (flag == 0 || flag == 1) {
            ch1 = nums[i] + maximumTotalCost1(nums, i + 1, 2);
            ch2 = nums[i] + maximumTotalCost1(nums, i + 1, 0);
        } else {
            ch1 = -nums[i] + maximumTotalCost1(nums, i + 1, 1);
            ch2 = -nums[i] + maximumTotalCost1(nums, i + 1, 0);
        }
        return Math.max(ch1, ch2);
    }
}
