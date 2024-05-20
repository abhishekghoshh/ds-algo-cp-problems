package com.problems.dp;

/*
 * Problem link :
 * https://leetcode.com/problems/target-sum/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11
 * 
 */
public class CountNumberOfSubsetWithGivenSumDifference {

	public static void main(String[] args) {
		type1();
		type2();
	}


	// TODO works on positive and greater than zero elements, check the target sum problem
	// as per the question target is s1 - s2 = target
	// but we know one thing s1 + s2 = total sum [always]
	// so s1 is (sum+target)/2
	// also (sum+target) must be divisible by 2
	private static void type2() {
		int target = 2;
		int[] nums = { 1, 1, 1, 2, 3 };
		int count = findTargetSumWays2(nums, target);
		System.out.print(count);
	}

	public static int findTargetSumWays2(int[] nums, int target) {
		int n = nums.length;
		int sum = 0;
		for (int num : nums) sum += num;
		// if sum + target is odd, then we cannot make subsets
		if ((sum + target) % 2 != 0) return 0;
		int s1 = (sum + target) / 2;
		// we will take an int 2d array for memo
		int[][] memo = new int[n + 1][s1 + 1];
		// if n is 0 then we will not able to make any kind of subset,
		// so for all n equal to 0 the memo cell value will be 0
		for (int i = 1; i < s1; i++) memo[0][i] = 0;
		// but we can always create a target sum of 0 with the empty subset
		for (int i = 0; i < n; i++) memo[i][0] = 1;
		// lets, fill all the memo cells now
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= s1; j++)
				if (nums[i - 1] <= j)
					memo[i][j] = memo[i - 1][j - nums[i - 1]] + memo[i - 1][j];
				else
					memo[i][j] = memo[i - 1][j];
		return memo[n][s1];
	}

	// TODO complete this with the memoization
	private static void type1() {
	}
}
