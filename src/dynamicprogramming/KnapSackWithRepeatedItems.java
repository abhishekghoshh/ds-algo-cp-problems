package dynamicprogramming;
/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=aycn9KO8_Ls&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=13
 * 
 */
public class KnapSackWithRepeatedItems {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	private static void type3() {
		int wt[] = { 2, 3, 4, 5, 9, 12 };
		int val[] = { 3, 5, 7, 8, 15, 20 };
		int n = val.length;
		int w = 13;
		int[][] memo = new int[n + 1][w + 1];
		for (int i = 0; i <= n; i++) {
			memo[i][0] = 0;
		}
		for (int i = 0; i <= w; i++) {
			memo[0][w] = 0;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				if (wt[i - 1] <= j) {
					memo[i][j] = Math.max(val[i - 1] + memo[i][j - wt[i - 1]], memo[i - 1][j]);
				} else {
					memo[i][j] = memo[i - 1][j];
				}
			}
		}
		int profit = memo[n][w];
		System.out.println(profit);
	}

	private static void type2() {
		int wt[] = { 2, 3, 4, 5, 9, 12 };
		int val[] = { 3, 5, 7, 8, 15, 20 };
		int n = val.length;
		int w = 13;
		int[][] memo = new int[n + 1][w + 1];
		for (int i = 0; i <= n; i++) {
			memo[i][0] = 0;
		}
		for (int i = 0; i <= w; i++) {
			memo[0][w] = 0;
		}
		int profit = knapsack(wt, val, n, w, memo);
		System.out.println(profit);
	}

	private static int knapsack(int[] wt, int[] val, int n, int w, int[][] memo) {
		if (n == 0 || w == 0) {
			return 0;
		}
		if (memo[n][w] != 0) {
			return memo[n][w];
		}
		if (wt[n - 1] <= w) {
			memo[n][w] = Math.max(val[n - 1] + knapsack(wt, val, n, w - wt[n - 1]), knapsack(wt, val, n - 1, w));
		} else {
			memo[n][w] = knapsack(wt, val, n - 1, w);
		}
		return memo[n][w];
	}

	private static void type1() {
		int wt[] = { 2, 3, 4, 5, 9, 12 };
		int val[] = { 3, 5, 7, 8, 15, 20 };
		int n = val.length;
		int w = 13;
		int profit = knapsack(wt, val, n, w);
		System.out.println(profit);
	}

	private static int knapsack(int[] wt, int[] val, int n, int w) {
		if (n == 0 || w == 0) {
			return 0;
		}
		if (wt[n - 1] <= w) {
			return Math.max(val[n - 1] + knapsack(wt, val, n, w - wt[n - 1]), knapsack(wt, val, n - 1, w));
		} else {
			return knapsack(wt, val, n - 1, w);
		}
	}
}
