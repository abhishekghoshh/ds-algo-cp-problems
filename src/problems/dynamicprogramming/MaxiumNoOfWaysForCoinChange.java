package problems.dynamicprogramming;

/*
 * Problem link :
 * https://leetcode.com/problems/coin-change-ii/submissions/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=I4UR2T6Ro3w&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=15
 * 
 */
public class MaxiumNoOfWaysForCoinChange {

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
		// to make zero amount we always have one option which is to consider the zero
		// subset
		dp[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i < amount + 1; i++) {
				dp[i] += dp[i - coin];
			}
		}
		int maxTime = dp[amount];
		System.out.println(maxTime);

	}

	private static void type3() {
//		int coins[] = { 2, 3, 4, 5, 9, 12 };
//		int amount = 12;
		int[] coins = { 3, 5, 7, 8, 9, 10, 11 };
		int amount = 500;
		int n = coins.length;
		while (n != 1 & coins[n - 1] > amount) {
			n--;
		}
		int[][] memo = new int[n + 1][amount + 1];
		// for amount 0 there is always one way
		// which is to take no coins
		for (int i = 0; i <= n; i++) {
			memo[i][0] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= amount; j++) {
				if (coins[i - 1] <= j) {
					memo[i][j] = memo[i][j - coins[i - 1]] + memo[i - 1][j];
				} else {
					memo[i][j] = memo[i - 1][j];
				}
			}
		}
		int maxTime = memo[n][amount];
		System.out.println(maxTime);
	}

	private static void type2() {
		int[] coins = { 3, 5, 7, 8, 9, 10, 11 };
		int amount = 500;
		int n = coins.length;
		int[][] memo = new int[n + 1][amount + 1];
		for (int i = 0; i <= n; i++) {
			memo[i][0] = 1;
		}
		int maxTime = coinChange(coins, amount, n, memo);
		System.out.println(maxTime);
	}

	private static int coinChange(int[] coins, int amount, int n, int[][] memo) {
		if (n == 0 && amount != 0) {
			return 0;
		}
		if (memo[n][amount] != 0) {
			return memo[n][amount];
		}
		if (coins[n - 1] <= amount) {
			memo[n][amount] = coinChange(coins, amount - coins[n - 1], n, memo)
					+ coinChange(coins, amount, n - 1, memo);
		} else {
			memo[n][amount] = coinChange(coins, amount, n - 1, memo);
		}
		return memo[n][amount];
	}

	private static void type1() {
//		int coins[] = { 1 };
//		int amount = 2;
		int[] coins = { 3, 5, 7, 8, 9, 10, 11 };
		int amount = 500;
//		int[] coins = { 200, 217, 234, 251, 268, 285, 302, 319, 336, 353, 370, 387, 404, 421, 438, 455, 472, 489, 506,
//				523, 540, 557, 574, 591, 608, 625, 642, 659, 676, 693, 710, 727, 744, 761, 778, 795, 812, 829, 846, 863,
//				880, 897, 914, 931, 948, 965, 982, 999, 1016, 1033, 1050, 1067, 1084, 1101, 1118, 1135, 1152, 1169,
//				1186, 1203, 1220, 1237, 1254, 1271, 1288, 1305, 1322, 1339, 1356, 1373, 1390, 1407, 1424, 1441, 1458,
//				1475, 1492, 1509, 1526, 1543, 1560, 1577, 1594, 1611, 1628, 1645, 1662, 1679, 1696, 1713, 1730, 1747,
//				1764, 1781, 1798, 1815, 1832, 1849, 1866, 1883, 1900, 1917, 1934, 1951, 1968, 1985, 2002, 2019, 2036,
//				2053, 2070, 2087, 2104, 2121, 2138, 2155, 2172, 2189, 2206, 2223, 2240, 2257, 2274, 2291, 2308, 2325,
//				2342, 2359, 2376, 2393, 2410, 2427, 2444, 2461, 2478, 2495, 2512, 2529, 2546, 2563, 2580, 2597, 2614,
//				2631, 2648, 2665, 2682, 2699, 2716, 2733, 2750, 2767, 2784, 2801, 2818, 2835, 2852, 2869, 2886, 2903,
//				2920, 2937, 2954, 2971, 2988, 3005, 3022, 3039, 3056, 3073, 3090, 3107, 3124, 3141, 3158, 3175, 3192,
//				3209, 3226, 3243, 3260, 3277, 3294, 3311, 3328, 3345, 3362, 3379, 3396, 3413, 3430, 3447, 3464, 3481,
//				3498, 3515, 3532, 3549, 3566, 3583, 3600, 3617, 3634, 3651, 3668, 3685, 3702, 3719, 3736, 3753, 3770,
//				3787, 3804, 3821, 3838, 3855, 3872, 3889, 3906, 3923, 3940, 3957, 3974, 3991, 4008, 4025, 4042, 4059,
//				4076, 4093, 4110, 4127, 4144, 4161, 4178, 4195, 4212, 4229, 4246, 4263, 4280, 4297, 4314, 4331, 4348,
//				4365, 4382, 4399, 4416, 4433, 4450, 4467, 4484, 4501, 4518, 4535, 4552, 4569, 4586, 4603, 4620, 4637,
//				4654, 4671, 4688, 4705, 4722, 4739, 4756, 4773, 4790, 4807, 4824, 4841, 4858, 4875, 4892, 4909, 4926,
//				4943, 4960, 4977, 4994 };
//		int amount = 4000;
		int n = coins.length;
		int maxTime = coinChange(coins, amount, n);
		System.out.println(maxTime);

	}

	private static int coinChange(int[] coins, int amount, int n) {
		if (n == 0 && amount == 0) {
			return 1;
		}
		if (n == 0 && amount != 0) {
			return 0;
		}
		if (coins[n - 1] <= amount) {
			return coinChange(coins, amount - coins[n - 1], n) + coinChange(coins, amount, n - 1);
		} else {
			return coinChange(coins, amount, n - 1);
		}
	}
}
