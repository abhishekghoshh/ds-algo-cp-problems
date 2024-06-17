package com.problems.dp;

import com.util.PrintUtl;

import java.util.Arrays;

/*
 * Problem link:
 * https://leetcode.com/problems/target-sum/ => the intuition is little bit different but the solution is same
 * https://www.naukri.com/code360/problems/partitions-with-given-difference_3751628
 * https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11
 * https://www.youtube.com/watch?v=zoilQD1kYSg&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=19
 *
 * https://takeuforward.org/data-structure/count-partitions-with-given-difference-dp-18/
 */
public class CountNumberOfSubsetWithGivenSumDifference {

	public static void main(String[] args) {
		type1();
		type2();
	}


	// TODO works on positive and greater than zero elements, check the target sum problem
	// as per the question s1 - s2 = target
	// but we know one thing s1 + s2 = total sum [always]
	// so s1 is (sum+target)/2
	// also (sum+target) must be divisible by 2
	private static void type2() {
		int target = 3;
		int[] nums = {1, 1, 1, 1, 1};
		int count = findTargetSumWays2(nums, target);
		System.out.println(count);
	}

	public static int findTargetSumWays2(int[] nums, int target) {
		int n = nums.length;
		int sum = 0;
		for (int num : nums) sum += num;
		// if sum + target is odd, then we cannot make subsets
		if ((sum + target) % 2 != 0) return 0;
		// if the sum is lesser than the target, then we cannot make the target by
		// subtracting one partition to another
		if (sum < Math.abs(target)) return 0;


		int s1 = (sum + target) / 2;
		// we will take an int 2d array for memo
		int[][] dp = new int[n + 1][s1 + 1];
		// if n is 0, then we will not able to make any kind of subset,
		// so for all n equal to 0 the memo cell value will be 0
		for (int i = 1; i < s1; i++) dp[0][i] = 0;
		// but we can always create a target sum of 0 with the empty subset
		for (int i = 0; i < n; i++) dp[i][0] = 1;
		// lets, fill all the memo cells now
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= s1; j++)
				if (nums[i - 1] <= j)
					dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j];
		PrintUtl.print2D(dp);
		return dp[n][s1];
	}

	// TODO complete this with the memoization
	private static void type1() {
		int target = 1;
		int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 1};
		int count = findTargetSumWays1(nums, target);
		System.out.println(count);
	}

	public static int findTargetSumWays1(int[] nums, int target) {
		int n = nums.length;
		int sum = 0;
		for (int num : nums) sum += num;
		// if sum + target is odd, then we cannot make subsets
		if ((sum + target) % 2 != 0) return 0;
		// if the sum is lesser than the target, then we cannot make the target by
		// subtracting one partition to another
		if (sum < Math.abs(target)) return 0;

		int[][] dp = new int[n][2 * sum + 1];
		for (int[] row : dp) Arrays.fill(row, -1);

		return findTargetSumWays1(nums, 0, 0, target, dp, sum);
	}

	static int findTargetSumWays1(int[] nums, int i, int sum, int target, int[][] dp, int offset) {
		if (i == nums.length) return sum == target ? 1 : 0;

		if (dp[i][sum + offset] != -1) return dp[i][sum + offset];

		return dp[i][sum + offset] =
				findTargetSumWays1(nums, i + 1, sum + nums[i], target, dp, offset)
						+ findTargetSumWays1(nums, i + 1, sum - nums[i], target, dp, offset);
	}
}
