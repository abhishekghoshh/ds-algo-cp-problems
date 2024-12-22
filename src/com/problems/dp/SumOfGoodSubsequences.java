package com.problems.dp;

/*
 * Problem link:
 * https://leetcode.com/problems/sum-of-good-subsequences/description/
 * Course Schedule:
 *
 *
 * Solution link :
 *
 *
 *
 */
public class SumOfGoodSubsequences {
    public static void main(String[] args) {
        type1();
    }

    // brute force with recursion
    private static void type1() {
        int[] nums = {1, 2, 1};

    }

    static long sum = 0;
    static int mod = 1000000007;

    public static int sumOfGoodSubsequences1(int[] nums) {
        sumOfGoodSubsequences1(0, -1, 0, nums, nums.length);
        return (int) (sum % mod);
    }

    public static void sumOfGoodSubsequences1(int prevSum, int prev, int curr, int[] nums, int n) {
        if (curr == n) {
            sum += prevSum;
            return;
        }
        if (prev == -1) {
            sumOfGoodSubsequences1(prevSum + nums[curr], curr, curr + 1, nums, n);
            sumOfGoodSubsequences1(prevSum, -1, curr + 1, nums, n);
        } else {
            int d = Math.abs(nums[prev] - nums[curr]);
            if (d == 1) {
                sumOfGoodSubsequences1(prevSum + nums[curr], curr, curr + 1, nums, n);
            }
            sumOfGoodSubsequences1(prevSum, prev, curr + 1, nums, n);
        }
    }
}
