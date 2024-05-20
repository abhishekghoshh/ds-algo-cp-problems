package com.problems.dp;

import java.util.Arrays;

/*
 * Problem link :
 * https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1 -> this is not accepting the solution
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=F7wqWbqYn9g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9
 * 
 * https://www.codingninjas.com/codestudio/library/count-of-subsets-with-sum-equal-to-x
 */
public class CountOfSubsetSum {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// similar to equal sum partition
	// using top-down approach
	private static void type2() {
		int[] nums = {9, 7, 0, 3, 9, 8, 6, 5, 7, 6};
		int target = 31;
		int n = nums.length;
		int[][] memo = new int[n + 1][target + 1];
		// with n equal to 0, we cannot make any target sum
		for (int i = 1; i <= target; i++) memo[0][i] = 0;

		// but to make target sum equal to 0, we have always one option, that is an empty set
		for (int i = 1; i <= n; i++) memo[i][0] = 1;

		// here the target is 0, and we have 0 numbers to choose, but we can always choose an empty set
		memo[0][0] = 1;

		// we will fill up the spaces one by one
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= target; j++)
				if (nums[i - 1] <= j)
					memo[i][j] = memo[i - 1][j - nums[i - 1]] + memo[i - 1][j];
				else
					memo[i][j] = memo[i - 1][j];

		int count = memo[n][target];
		System.out.println(count);
	}

	// using memoization
	// similar to equal partition sum problem
	private static void type1() {
		int[] nums = {9, 7, 0, 3, 9, 8, 6, 5, 7, 6};
		int target = 31;
		int n = nums.length;
		int[][] memo = new int[n + 1][target + 1];
		// marking all the cells as unvisited
		for (int[] row : memo) Arrays.fill(row, -1);
		int count = countOfSubset1(nums, n, target, memo);
		System.out.println(count);
	}

	private static int countOfSubset1(int[] nums, int n, int target, int[][] memo) {
		if (target == 0) return 1;
		if (n == 0 || target < 0) return 0;
		if (memo[n][target] != -1) return memo[n][target];
		return memo[n][target] =
				countOfSubset1(nums, n - 1, target - nums[n - 1], memo)
						+ countOfSubset1(nums, n - 1, target, memo);
	}

}
