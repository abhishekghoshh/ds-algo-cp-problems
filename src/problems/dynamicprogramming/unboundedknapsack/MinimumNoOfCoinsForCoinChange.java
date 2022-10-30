package problems.dynamicprogramming.unboundedknapsack;

/*
 * Problem link :
 * https://leetcode.com/problems/coin-change/submissions/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=I-l6PBeERuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=16
 * 
 */
public class MinimumNoOfCoinsForCoinChange {

	public static void main(String[] args) {
		type3();
	}

	private static void type3() {
		int coins[] = { 1, 2, 3, 4, 5, 9, 11 };
		int amount = 12;
		int n = coins.length;
		int[][] memo = new int[n + 1][amount + 1];
		for (int i = 1; i <= n; i++) {
			memo[i][0] = 0;
		}
		for (int j = 1; j <= amount; j++) {
			memo[0][j] = Integer.MAX_VALUE - 1;
		}
		memo[0][0] = Integer.MAX_VALUE - 1;
		for (int i = 1; i <= amount; i++) {
			if (i % coins[0] == 0) {
				memo[1][i] = i / coins[0];
			} else {
				memo[1][i] = Integer.MAX_VALUE - 1;
			}
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= amount; j++) {
				if (coins[i - 1] <= j) {
					memo[i][j] = Math.min(1 + memo[i][j - coins[i - 1]], memo[i - 1][j]);
				} else {
					memo[i][j] = memo[i - 1][j];
				}
			}
		}
		int minCount = memo[n][amount];
		System.out.println(minCount);
	}
}
