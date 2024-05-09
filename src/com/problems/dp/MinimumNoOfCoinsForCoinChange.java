package com.problems.dp;

import java.util.Arrays;

/*
 * Problem link :
 * https://leetcode.com/problems/coin-change
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=I-l6PBeERuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=16
 * https://www.youtube.com/watch?v=rMfOgY07TFs&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=17
 * 
 */
public class MinimumNoOfCoinsForCoinChange {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
	}

	// TODO study later
	private static void type4() {
		int[] coins = {1, 2, 3, 4, 5, 9, 11};
		int amount = 12;
		int[] dp = new int[amount + 1];
		// assigning all values to max possibility
		Arrays.fill(dp, amount + 1);
		// for 0 amount minimum number of coins needed is 0
		dp[0] = 0;
		for (int coin : coins) {
			for (int i = coin; i <= amount; ++i) {
				dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
			}
		}
		int minCount = dp[amount] == amount + 1 ? -1 : dp[amount];
		System.out.println(minCount);
	}

	private static void type3() {
		int[] coins = {1, 2, 3, 4, 5, 9, 11};
		int amount = 12;
		int minCount = coinChange3(coins, amount);
		System.out.println(minCount);
	}

	public static int coinChange3(int[] coins, int amount) {
		int n = coins.length;
		int[][] memo = new int[n + 1][amount + 1];
		//
		for (int i = 1; i <= n; i++) memo[i][0] = 0;
		//
		for (int j = 0; j <= amount; j++) memo[0][j] = Integer.MAX_VALUE - 1;
		//
		for (int i = 1; i <= amount; i++)
			if (i % coins[0] == 0) memo[1][i] = i / coins[0];
			else memo[1][i] = Integer.MAX_VALUE - 1;
		//
		for (int i = 2; i <= n; i++)
			for (int j = 1; j <= amount; j++)
				if (coins[i - 1] <= j)
					memo[i][j] = Math.min(
							1 + memo[i][j - coins[i - 1]],
							memo[i - 1][j]
					);
				else memo[i][j] = memo[i - 1][j];

		return memo[n][amount];
	}

	private static void type2() {
	}

	private static void type1() {
	}

}
