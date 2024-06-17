package com.problems.dp;

import java.util.Arrays;

/*
 * Problem link :
 * https://leetcode.com/problems/coin-change
 * https://www.naukri.com/code360/problems/minimum-elements_3843091
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=I-l6PBeERuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=16
 * https://www.youtube.com/watch?v=rMfOgY07TFs&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=17
 *
 * https://www.youtube.com/watch?v=myPeWb3Y68A&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=21
 * https://takeuforward.org/data-structure/minimum-coins-dp-20/
 */
public class MinimumNoOfCoinsForCoinChange {

	// todo check this problem one more time
	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
	}

	// similar to the problem of [no of way possible for creating amount]
	private static void type4() {
		int[] coins = {1, 2, 3, 4, 5, 9, 11};
		int amount = 12;
		int[] dp = new int[amount + 1];
		// assigning all values to max possibility, (theoretically it is not possible)
		// the lowest coin possible is 1 and to create amount k we will k coin only
		Arrays.fill(dp, amount + 1);
		// for amount 0 minimum numbers of coins needed are 0
		dp[0] = 0;
		// we will loop through for all the coins and for all the amount
		for (int coin : coins) {
			for (int i = coin; i <= amount; ++i)
				// we have 2 options either to include the current coin or not
				// if we are using the current coin, then we have to add +1,
				// and we have to take the minimum out of 2 choices
				dp[i] = Math.min(
						dp[i - coin] + 1,
						dp[i]
				);
		}
		// ideally dp[amount] should be less than amount, if it greater than then we cannot create amount
		int minCount = (dp[amount] > amount) ? -1 : dp[amount];
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
		// create amount 0 we will need 0 coins
		for (int i = 1; i <= n; i++) memo[i][0] = 0;

		// with 0 coins, we need infinite coins to make any amount (theoretically it is impossible though)
		for (int j = 0; j <= amount; j++) memo[0][j] = Integer.MAX_VALUE - 1;

		// we will also with 1 coin if we can make any amount or not and how much coin is needed, else will add infinite
		for (int i = 1; i <= amount; i++)
			if (i % coins[0] == 0) memo[1][i] = i / coins[0];
			else memo[1][i] = Integer.MAX_VALUE - 1;

		// now we will fill the remaining cells, starting from the 2nd coin and for all the amount
		for (int i = 2; i <= n; i++)
			for (int j = 1; j <= amount; j++)
				// we have 2 options either to include the current coin or not
				// if we are using the current coin, then we have to add +1,
				// and we have to take the minimum out of 2 choices
				if (coins[i - 1] <= j)
					memo[i][j] = Math.min(
							1 + memo[i][j - coins[i - 1]],
							memo[i - 1][j]
					);
				else
					memo[i][j] = memo[i - 1][j];

		return memo[n][amount];
	}

	private static void type2() {
	}

	private static void type1() {
	}

}
