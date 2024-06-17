package com.problems.dp;
/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/rod-cutting0840/1
 * https://www.naukri.com/code360/problems/rod-cutting-problem_800284
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=SZqAQLjDsag&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=14
 *
 * https://www.youtube.com/watch?v=mO8XpGoJwuo&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=25
 * https://takeuforward.org/data-structure/rod-cutting-problem-dp-24/
 */

public class RodCutting {
	// TODO similar to the unbounded knapsack problem
	/*
	 * Given a rod of length N inches and an array of prices, price[].
	 * price[i] denotes the value of a piece of length i.
	 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
	 * */
	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
		type5();
	}

	private static void type5() {

	}


	// using two 1D arrays for storing current and previous row
	private static void type4() {
		int[] prices = {3, 5, 7, 8, 15, 20};
		int[] rodLengths = {2, 3, 4, 5, 9, 12};
		int totalLength = 14;
		int n = prices.length;

		// if the length is not given, then we will create an array of size n and put there 1..N
		int[] prev = new int[totalLength + 1];

		// we do not need any initiation for the problem, because we are setting 0th row and column to be 0
		for (int i = 1; i <= n; i++) {
			int rodLength = rodLengths[i - 1];
			int[] curr = new int[totalLength + 1];
			for (int currentLength = 1; currentLength <= totalLength; currentLength++)
				// if we can accommodate the current length
				if (rodLength <= currentLength)
					curr[currentLength] = Math.max(
							prices[i - 1] + prev[currentLength - rodLength],
							dp[i - 1][currentLength]
					);
				else curr[currentLength] = prev[currentLength];
			prev = curr;
		}
		int profit = dp[n][totalLength];
		System.out.println(profit);
	}

	// top-down approach or iterative memoization
	private static void type3() {
		int[] prices = {3, 5, 7, 8, 15, 20};
		int[] rodLengths = {2, 3, 4, 5, 9, 12};
		int totalLength = 14;
		int n = prices.length;

		// if the length is not given, then we will create an array of size n and put there 1..N

		int[][] dp = new int[n + 1][totalLength + 1];

		// initialization
		dp[0][0] = 0;
		for (int i = 1; i <= n; i++) dp[i][0] = 0;
		for (int i = 1; i <= totalLength; i++) dp[0][i] = 0;

		for (int i = 1; i <= n; i++) {
			int rodLength = rodLengths[i - 1];

			for (int currentLength = 1; currentLength <= totalLength; currentLength++)
				// if we can accommodate the current length
				if (rodLength <= currentLength)
					dp[i][currentLength] = Math.max(
							prices[i - 1] + dp[i][currentLength - rodLength],
							dp[i - 1][currentLength]
					);
				else dp[i][currentLength] = dp[i - 1][currentLength];
		}
		int profit = dp[n][totalLength];
		System.out.println(profit);
	}

	// recursion with memoization
	private static void type2() {
		int[] prices = {3, 5, 7, 8, 15, 20};
		int[] rodLengths = {2, 3, 4, 5, 9, 12};
		int totalLength = 14;
		int n = prices.length;

		// if the length is not given, then we will create an array of size n and put there 1..N

		int[][] dp = new int[n + 1][totalLength + 1];
		int profit = rodCut2(n, prices, rodLengths, totalLength, dp);
		System.out.println(profit);
	}

	private static int rodCut2(int n, int[] prices, int[] rodLengths, int totalLength, int[][] dp) {
		if (n == 0 || totalLength == 0) return 0;
		if (dp[n][totalLength] != 0) return dp[n][totalLength];
		if (rodLengths[n - 1] <= totalLength)
			return dp[n][totalLength] = Math.max(
					prices[n - 1] + rodCut2(n, prices, rodLengths, totalLength - rodLengths[n - 1], dp),
					rodCut2(n - 1, prices, rodLengths, totalLength, dp)
			);
		else
			return dp[n][totalLength] =
					rodCut2(n - 1, prices, rodLengths, totalLength, dp);
	}

	// with recursion
	private static void type1() {

	}


}
