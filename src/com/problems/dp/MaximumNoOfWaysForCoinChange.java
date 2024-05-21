package com.problems.dp;

/*
 * Problem link :
 * https://leetcode.com/problems/coin-change-ii/submissions/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=I4UR2T6Ro3w&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=15
 * 
 */
public class MaximumNoOfWaysForCoinChange {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
	}

	// TODO study later
	private static void type4() {
		int[] coins = { 3, 5, 7, 8, 9, 10, 11 };
		int amount = 500;
		int[] dp = new int[amount + 1];
		// to make zero amounts, we always have one option which is to consider the zero subset
		dp[0] = 1;
		for (int coin : coins)
			for (int i = coin; i < amount + 1; i++)
				dp[i] += dp[i - coin];

		int maxTime = dp[amount];
		System.out.println(maxTime);

	}

	private static void type3() {
		int[] coins = { 3, 5, 7, 8, 9, 10, 11 };
		int amount = 500;
		int n = coins.length;
		while (n != 1 && coins[n - 1] > amount) n--;

		int[][] memo = new int[n + 1][amount + 1];
		// for amount 0 there is always one way which is to take no coins
		for (int i = 0; i <= n; i++) memo[i][0] = 1;

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= amount; j++)
				if (coins[i - 1] <= j)
					memo[i][j] = memo[i][j - coins[i - 1]] + memo[i - 1][j];
				else memo[i][j] = memo[i - 1][j];

		int maxTime = memo[n][amount];
		System.out.println(maxTime);
	}

	private static void type2() {
		int[] coins = { 3, 5, 7, 8, 9, 10, 11 };
		int amount = 500;
		int n = coins.length;
		int[][] memo = new int[n + 1][amount + 1];
		for (int i = 0; i <= n; i++) memo[i][0] = 1;

		int maxTime = coinChange(coins, amount, n, memo);
		System.out.println(maxTime);
	}

	private static int coinChange(int[] coins, int amount, int n, int[][] memo) {
		if (n == 0 && amount != 0) return 0;

		if (memo[n][amount] != 0) return memo[n][amount];

		if (coins[n - 1] <= amount)
			memo[n][amount] =
					coinChange(coins, amount - coins[n - 1], n, memo)
					+ coinChange(coins, amount, n - 1, memo);
		else memo[n][amount] = coinChange(coins, amount, n - 1, memo);

		return memo[n][amount];
	}

	private static void type1() {
		int[] coins = { 3, 5, 7, 8, 9, 10, 11 };
		int amount = 50;
		int n = coins.length;
		int maxTime = coinChange(coins, amount, n);
		System.out.println(maxTime);

	}

	private static int coinChange(int[] coins, int amount, int n) {
		if (n == 0 && amount == 0) return 1;

		if (n == 0) return 0;

		if (coins[n - 1] <= amount)
			return coinChange(coins, amount - coins[n - 1], n)
					+ coinChange(coins, amount, n - 1);
		else return coinChange(coins, amount, n - 1);

	}
}
