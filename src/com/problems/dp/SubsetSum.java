package com.problems.dp;

/*
 * Problem link :
 * https://www.codingninjas.com/studio/problems/subset-sum_630213
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=_gPcYovP7wc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=7
 * 
 * */
public class SubsetSum {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}


	// similar to knapsack problem
	// here we have to say a subset sum is possible or not
	private static void type3() {
		int[] nums = {1, 3, 4, 5, 9, 12};
		int n = nums.length;
		int k = 25;
		boolean[][] memo = new boolean[n + 1][k + 1];
		// if we have 0 items then it not possible to create any subset sum
		for (int i = 1; i <= k; i++) memo[0][i] = false;
		// if our target sum is zero, it is possible to create that
		// as we can anytime consider the empty set
		// so even with zero elements, we can create target sum 0
		for (int i = 0; i <= n; i++) memo[i][0] = true;

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= k; j++)
				// if we num is less than the j then we will have 2 possibilities
				// either to take it or not
				if (nums[i - 1] <= j)
					memo[i][j] = memo[i - 1][j - nums[i - 1]] || memo[i - 1][j];
				else
					memo[i][j] = memo[i - 1][j];
		boolean isPossible = memo[n][k];
		System.out.println(isPossible);
	}

	// this is the same as the previous type, but here we will use memoization
	private static void type2() {
		int[] nums = {1, 3, 4, 5, 9, 12};
		int n = nums.length;
		int k = 25;
		// we will create a memo array of int
		int[][] memo = new int[n + 1][k + 1];
		// we will consider zero as unmarked and 1 as true and -1 as false
		boolean isPossible = isSubsetPresent2(0, nums, k, memo);
		System.out.println(isPossible);

	}

	public static boolean isSubsetPresent2(int i, int[] nums, int rem, int[][] memo) {
		// if the remaining is 0, that means we are capable of creating the sum
		if (rem == 0) return true;
		// if the rem is negative or index is out of bound, then we will return false
		if (rem < 0 || i == nums.length) return false;
		// check if the recursion call is already made
		if (memo[i][rem] != 0) return (memo[i][rem] == 1);
		// else we have 2 options, either to use the current number or not
		boolean isPresent = isSubsetPresent2(i + 1, nums, rem - nums[i], memo)
				|| isSubsetPresent2(i + 1, nums, rem, memo);
		memo[i][rem] = (isPresent) ? 1 : -1;
		return isPresent;
	}
	// this is a simple recursion
	private static void type1() {
		int[] nums = {1, 3, 4, 5, 9, 12};
		int k = 25;
		boolean isPossible = isSubsetPresent1(0, nums, k);
		System.out.println(isPossible);
	}

	public static boolean isSubsetPresent1(int i, int[] nums, int rem) {
		// if the remaining is 0, that means we are capable of creating the sum
		if (rem == 0) return true;
		// if the rem is negative or the index is out of bound, then we will return false.
		// we could check here if rem is less than 0, or we can check while calling the recursion
		// if we can accommodate the number or not or nums[n-1] < rem
		if (rem < 0 || i == nums.length) return false;
		// else we have 2 options, either to use the current number or not
		return isSubsetPresent1(i + 1, nums, rem - nums[i])
				|| isSubsetPresent1(i + 1, nums, rem);
	}
}
