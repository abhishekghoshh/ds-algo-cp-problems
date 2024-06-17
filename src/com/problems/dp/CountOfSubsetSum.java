package com.problems.dp;

import com.util.PrintUtl;

import java.util.Arrays;

/*
 * Problem link:
 * https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
 * https://www.naukri.com/code360/problems/number-of-subsets_3952532
 *
 * Solution link:
 * https://www.youtube.com/watch?v=F7wqWbqYn9g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9
 * https://www.youtube.com/watch?v=ZHyb-A2Mte4&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=18
 * 
 * https://www.codingninjas.com/codestudio/library/count-of-subsets-with-sum-equal-to-x
 * https://takeuforward.org/data-structure/count-subsets-with-sum-k-dp-17/
 */
public class CountOfSubsetSum {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// the previous two solutions will not be accepted in gfg or coding ninjas
	// as it misses an edge case,
	// let's say nums = [0,1,3], and target is 4
	// we will have 2 solutions 0,1,3 and 1,3.
	// but in recursion, we are going from back to index 0
	// once it reaches target 0 at nums[i]==1
	// it will return from that it will not consider the possibility of having any 0 on the left side,
	// so it misses 0,1,3.
	// one simple trick we can do is, we can move all 0s on the right side,
	// or we can add count the zero elements and create a separate non-zero array
	// then we can compute for the 0 later.
	// for one 0 there would be 2 choices, either to take or not
	// for m number of 0s then the answer will be count * 2^m
	private static void type3() {
		int[] nums = {0, 0, 1, 0, 8, 0, 3, 0, 0};
		int target = 4;
		int n = nums.length;

		// optimization
		int low = 0, high = n - 1;
		while (low <= high) {
			if (nums[low] == 0 && nums[high] != 0) {
				swap(nums, low, high);
				low++;
				high--;
				continue;
			}
			if (nums[low] != 0) low++;
			if (nums[high] == 0) high--;
		}
		PrintUtl.print(nums);
		// if there is a negative number, then that will produce a negative sum
		// so to mitigate that we will add any big offset value


		// we can also do the space optimization from the tabulation approach
	}

	private static void swap(int[] nums, int low, int high) {
		int temp = nums[low];
		nums[low] = nums[high];
		nums[high] = temp;
	}

	// similar to equal sum partition
	// using top-down approach
	private static void type2() {
		int[] nums = {1, 1, 1, 1, 1};
		int target = 3;
		int n = nums.length;
		int[][] dp = new int[n + 1][target + 1];
		// with n equal to 0, we cannot make any target sum
		for (int i = 1; i <= target; i++) dp[0][i] = 0;

		// but to make target sum equal to 0, we have always one option, that is an empty set
		for (int i = 1; i <= n; i++) dp[i][0] = 1;

		// here the target is 0, and we have 0 numbers to choose, but we can always choose an empty set
		dp[0][0] = 1;

		// we will fill up the spaces one by one
		for (int i = 1; i <= n; i++)
			for (int sum = 1; sum <= target; sum++)
				if (nums[i - 1] <= sum)
					dp[i][sum] = dp[i - 1][sum - nums[i - 1]] + dp[i - 1][sum];
				else
					dp[i][sum] = dp[i - 1][sum];

		int count = dp[n][target];
		PrintUtl.print2D(dp);
		System.out.println(count);
	}

	// using memoization
	// similar to equal partition sum problem
	private static void type1() {
		int[] nums = {0, 1, 3};
		int target = 4;
		int n = nums.length;
		int[][] dp = new int[n + 1][target + 1];
		// marking all the cells as unvisited
		for (int[] row : dp) Arrays.fill(row, -1);
		int count = countOfSubset1(nums, n, target, dp);
		System.out.println(count);
	}

	private static int countOfSubset1(int[] nums, int n, int target, int[][] dp) {
		if (target == 0) return 1;

		if (n == 0 || target < 0) return 0;
		if (dp[n][target] != -1) return dp[n][target];

		return dp[n][target] = countOfSubset1(nums, n - 1, target - nums[n - 1], dp)
				+ countOfSubset1(nums, n - 1, target, dp);
	}

}
