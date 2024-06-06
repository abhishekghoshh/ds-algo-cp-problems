package com.problems.array;

import java.util.Arrays;
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


public class MaxSumForNonConsecutiveElements {
	// The problem is very similar to a maximum sum of a non-adjacent element in an array
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
	// it is the same as previous
	// we just need last and 2nd last value to compute the current
	// we can just hold those two values in 2 variable prev and prev2
	private static void type4() {
		int[] nums = {2, 7, 9, 3, 1};
		int n = nums.length;
		int prev2 = nums[0];
		int prev = Math.max(nums[0], nums[1]);
		int curr, takeCurrentHome, notTakeCurrentHome;
		for (int i = 2; i < n; i++) {
			takeCurrentHome = nums[i] + prev2;
			notTakeCurrentHome = prev;
			curr = Math.max(takeCurrentHome, notTakeCurrentHome);
			prev2 = prev;
			prev = curr;
		}
		System.out.println(prev);
	}

	// using tabulation
	// Time complexity O(k*n)
	// space complexity O(n) for array
	private static void type3() {
		int[] nums = {2, 7, 9, 3, 1};
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < n; i++) {
			int takeCurrentHome = nums[i] + dp[i - 2];
			int notTakeCurrentHome = dp[i - 1];
			dp[i] = Math.max(takeCurrentHome, notTakeCurrentHome);
		}
		System.out.println(dp[n - 1]);
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

	private static int houseRobber(int curr, int[] nums, int[] memo) {
		if (curr == 0) return nums[curr];
		if (curr < 0) return 0;
		if (memo[curr] != -1) return memo[curr];
		int takeCurrentHome = nums[curr] + houseRobber(curr - 2, nums, memo);
		int notTakeCurrentHome = houseRobber(curr - 1, nums, memo);
		return memo[curr] = Math.max(takeCurrentHome, notTakeCurrentHome);
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
	// or not to take it, but if we take it then we cannot take its adjacent element.
	// choice 1 => current home + rob (current-2th home)
	// choice 2 => start rob (current-1th home)
	// when i==0 that means it is the last house; we have no other choice other than taking it.
	// when i<0 that means we were in the 1st index, and now it cannot go to the 0th index,
	// so it went to 1-2 => -1 th index
	private static int houseRobber(int curr, int[] nums) {
		if (curr == 0) return nums[curr];
		if (curr < 0) return 0;
		int takeCurrentHome = nums[curr] + houseRobber(curr - 2, nums);
		int notTakeCurrentHome = houseRobber(curr - 1, nums);
		return Math.max(takeCurrentHome, notTakeCurrentHome);
	}

}
