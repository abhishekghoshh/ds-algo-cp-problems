package com.problems.dp;

/*
 * Problem link :
 * https://leetcode.com/problems/coin-change-ii
 * https://www.naukri.com/code360/problems/ways-to-make-coin-change_630471
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=I4UR2T6Ro3w&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=15
 *
 * https://www.youtube.com/watch?v=HgyouUi11zk&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=23
 * https://takeuforward.org/data-structure/coin-change-2-dp-22/
 */
public class MaximumNoOfWaysForCoinChange {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
		type5();
		type6();
	}

	// TODO this is similar to the previous optimization
	//  we have not only optimized the previous solution, also we have added a new intuition for supporting the current solution
	// Let's say we have only 1 coin [2]
	// we can only make zero amounts with no coins,
	// and we can make amounts of 2,4,6,8,10,12
	// if we have can 3 then we can make 3,6,9,12
	// we see there might be some overlapping.
	// But if we have 2 coins [2,3], then we can make 2,3,4,5,6,7... and so on
	// ok lets create a dp array of amount+1 items.
	// To create amount of 0, we will always have one option.
	// So dp[0] is always 1, now we will create the recurrence relation
	// if we add 2 with amount 0 then we will have 1 option to create amount 2.
	// DP[2] = dp[2-2] and simultaneously dp[6]=d[[4]=dp[2]=dp[0]
	// but if we have more than 1 coin, coin 3 will also make amount 6
	// so dp[6] is also dp[3], so rather using = we will us += that means we will take contributions
	// dp[6] += dp[6-3] and dp[6] += dp[6-2]
	// we will loop through for all the coins and for all the amount
	private static void type6() {
		int[] coins = { 3, 5, 7, 8, 9, 10, 11 };
		int amount = 500;
		int[] dp = new int[amount + 1];
		// to make zero amounts, we always have one option which is to consider the zero subset
		dp[0] = 1;
		for (int coin : coins)
			// we have to start with coin otherwise i-coin will be less than 0,
			// we will increment till amount
			for (int i = coin; i <= amount; i++)
				dp[i] += dp[i - coin];

		int ways = dp[amount];
		System.out.println(ways);

	}

	// tabulation or top-down approach
	// it is most space optimized where we are only using one 1D array
	private static void type5() {
		int[] coins = {3, 5, 7, 8, 9, 10, 11};
		int amount = 500;
		int n = coins.length;

		int[] dp = new int[amount + 1];
		// for amount 0 there is always one way that is to take no coins
		dp[0] = 1;

		// now we will fill upo the remaining cells
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= amount; j++)
				// we have two choices, to take this coin or not to take it,
				// but if we are taking it then, we can use the same coin again
				if (coins[i - 1] <= j)
					dp[j] += dp[j - coins[i - 1]];

		int ways = dp[amount];
		System.out.println(ways);
	}

	// tabulation or top-down approach
	// but it is more space optimized, we will use 2 array
	private static void type4() {
		int[] coins = {3, 5, 7, 8, 9, 10, 11};
		int amount = 500;
		int n = coins.length;

		int[] prev = new int[amount + 1];
		// for amount 0 there is always one way that is to take no coins
		prev[0] = 1;

		// now we will fill upo the remaining cells
		for (int i = 1; i <= n; i++) {
			int[] curr = new int[amount + 1];
			curr[0] = 1;
			for (int am = 1; am <= amount; am++)
				// we have two choices, to take this coin or not to take it,
				// but if we are taking it then, we can use the same coin again
				if (coins[i - 1] <= am)
					curr[am] = curr[am - coins[i - 1]] + prev[am];
				else
					curr[am] = prev[am];
			// assigning the curr to the prev
			prev = curr;
		}
		int ways = prev[amount];
		System.out.println(ways);
	}

	// tabulation or top-down approach
	private static void type3() {
		int[] coins = { 3, 5, 7, 8, 9, 10, 11 };
		int amount = 500;
		int n = coins.length;

		int[][] dp = new int[n + 1][amount + 1];
		// for amount 0 there is always one way that is to take no coins
		for (int i = 0; i <= n; i++) dp[i][0] = 1;

		// now we will fill upo the remaining cells
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= amount; j++)
				// we have two choices, to take this coin or not to take it,
				// but if we are taking it then, we can use the same coin again
				if (coins[i - 1] <= j)
					dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j];

		int ways = dp[n][amount];
		System.out.println(ways);
	}

	private static void type2() {
		int[] coins = { 3, 5, 7, 8, 9, 10, 11 };
		int amount = 500;
		int n = coins.length;
		int[][] memo = new int[n + 1][amount + 1];
		for (int i = 0; i <= n; i++) memo[i][0] = 1;

		int ways = coinChange(coins, amount, n, memo);
		System.out.println(ways);
	}

	private static int coinChange(int[] coins, int amount, int n, int[][] dp) {
		// if the n is 0, then we have considered all the coins, we have no coin to think about
		// if the amount is 0 then we have a way
		if (n == 0 && amount == 0) return 1;
		// if n is 0 but the amount is not 0 then
		if (n == 0) return 0;

		// if the recursion call is already done, then we will directly return the answer
		if (dp[n][amount] != 0) return dp[n][amount];

		// we have two choices, to take this coin or not to take it,
		// but if we are taking it then, we can use the same coin again
		if (coins[n - 1] <= amount)
			return dp[n][amount] =
					coinChange(coins, amount - coins[n - 1], n, dp)
							+ coinChange(coins, amount, n - 1, dp);
		else
			return dp[n][amount] = coinChange(coins, amount, n - 1, dp);

	}

	private static void type1() {
		int[] coins = { 3, 5, 7, 8, 9, 10, 11 };
		int amount = 50;
		int n = coins.length;
		int ways = coinChange(coins, amount, n);
		System.out.println(ways);

	}

	private static int coinChange(int[] coins, int amount, int n) {
		// if the n is 0, then we have considered all the coins, we have no coin to think about
		// if the amount is 0 then we have a way
		if (n == 0 && amount == 0) return 1;
		// if n is 0 but the amount is not 0 then
		if (n == 0) return 0;

		// we have two choices, to take this coin or not to take it,
		// but if we are taking it then, we can use the same coin again
		if (coins[n - 1] <= amount)
			return coinChange(coins, amount - coins[n - 1], n)
					+ coinChange(coins, amount, n - 1);
		else
			return coinChange(coins, amount, n - 1);

	}
}
