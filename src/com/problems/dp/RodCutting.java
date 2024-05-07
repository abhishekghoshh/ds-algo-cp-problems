package com.problems.dp;
/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/rod-cutting0840/1
 * https://www.codingninjas.com/codestudio/problems/rod-cutting-problem_800284?leftPanelTab=1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=SZqAQLjDsag&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=14
 * 
 */

public class RodCutting {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// top-down approach or iterative memoization
	private static void type3() {
		int[] prices = {3, 5, 7, 8, 15, 20};
		int[] lengths = {2, 3, 4, 5, 9, 12};
		int length = 14;
		int n = prices.length;

		// if the length is not given then we will create an array of size n and put there 1..N

		int[][] memo = new int[n + 1][length + 1];
		for (int i = 1; i <= n; i++) memo[i][0] = 0;
		for (int i = 1; i <= length; i++) memo[0][i] = 0;

		memo[0][0] = 0;
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= length; j++)
				if (lengths[i - 1] <= j)
					memo[i][j] = Math.max(
							prices[i - 1] + memo[i][j - lengths[i - 1]],
							memo[i - 1][j]
					);
				else memo[i][j] = memo[i - 1][j];

		int profit = memo[n][length];
		System.out.println(profit);
	}

	// bottom up approach with recursive memoization
	private static void type2() {

	}

	// plain old recursion
	private static void type1() {

	}


}
