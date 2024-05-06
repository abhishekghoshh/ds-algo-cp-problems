package com.problems.dp;

/*
 * Problem link :
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10
 * 
 */
public class MinimumSubsetSumDifference {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}


	// only works with positive integer
	// We need a better solution
	private static void type3() {
		int[] nums = {2, 2, 2, 2, 2};
		int n = nums.length;
		int sum = 0;
		for (int num : nums) sum += num;

		boolean[][] memo = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= sum; i++) memo[0][i] = false;

		for (int i = 0; i <= n; i++) memo[i][0] = true;

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= sum; j++)
				if (nums[i - 1] <= j)
					memo[i][j] = memo[i - 1][j - nums[i - 1]] || memo[i - 1][j];
				else
					memo[i][j] = memo[i - 1][j];


		int diff = sum;
		for (int s1 = 1; s1 <= (sum / 2); s1++) {
			// there will be two sets s1 and s2, then difference will be abs(s2-s1)
			// s2 can be represented by (sum-s1), so abs(s2-s1) => abs(sum-2*s1)
			if (memo[n][s1])
				diff = Math.min(diff, sum - 2 * s1);
		}
		System.out.println(diff);
	}

	// with memoization
	private static void type2() {
	}

	// with normal recursion
	private static void type1() {
	}
}
