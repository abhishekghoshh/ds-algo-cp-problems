package com.problems.dp;
/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=aycn9KO8_Ls&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=13
 * 
 */
public class UnboundedKnapsack {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// we could optimize the space by using a 1D array
	private static void type3() {
		int[] wt = {2, 3, 4, 5, 9, 12};
		int[] val = {3, 5, 7, 8, 15, 20};
		int n = val.length;
		int w = 13;
		int[][] memo = new int[n + 1][w + 1];

		// these 2 are for initialization, for both n and w equal to 0, then cell value will be 0
		// though we do not need to do it as the default value in an int array is already 0
		for (int i = 0; i <= n; i++) memo[i][0] = 0;
		for (int i = 0; i <= w; i++) memo[0][w] = 0;

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= w; j++)
				// same like the recursion login, 2 choices
				if (wt[i - 1] <= j)
					memo[i][j] = Math.max(
							val[i - 1] + memo[i][j - wt[i - 1]],
							memo[i - 1][j]
					);
				else
					memo[i][j] = memo[i - 1][j];


		int profit = memo[n][w];
		System.out.println(profit);
	}

	private static void type2() {
		int[] wt = {2, 3, 4, 5, 9, 12};
		int[] val = {3, 5, 7, 8, 15, 20};
		int n = val.length;
		int w = 13;
		int[][] memo = new int[n + 1][w + 1];

		// these 2 are for initialization, for both n and w equal to 0, then cell value will be 0
		// though we do not need to do it as the default value in an int array is already 0
		for (int i = 0; i <= n; i++) memo[i][0] = 0;
		for (int i = 0; i <= w; i++) memo[0][w] = 0;

		int profit = knapsack(wt, val, n, w, memo);
		System.out.println(profit);
	}

	private static int knapsack(int[] wt, int[] val, int n, int w, int[][] memo) {
		if (n == 0 || w == 0) return 0;
		// we are checking if the current recursion call is already made then we will not call it again
		if (memo[n][w] != 0) return memo[n][w];

		if (wt[n - 1] <= w)
			memo[n][w] = Math.max(
					val[n - 1] + knapsack(wt, val, n, w - wt[n - 1]),
					knapsack(wt, val, n - 1, w)
			);
		else
			memo[n][w] = knapsack(wt, val, n - 1, w);

		return memo[n][w];
	}

	private static void type1() {
		int[] wt = {2, 3, 4, 5, 9, 12};
		int[] val = {3, 5, 7, 8, 15, 20};
		int n = val.length;
		int w = 13;
		int profit = knapsack(wt, val, n, w);
		System.out.println(profit);
	}

	private static int knapsack(int[] wt, int[] val, int n, int w) {
		// similar to 0/1 knapsack if n or w is 0, then the answer is 0
		if (n == 0 || w == 0) return 0;
		// if we can incorporate the current weight, then we have 2 choices, either to take it or not.
		// but here is a catch, unlike 0/1 knapsack, we can take a single item as much as possible.
		// that's why we are just decreasing the remaining weight, not the item count (n)
		if (wt[n - 1] <= w)
			return Math.max(
					val[n - 1] + knapsack(wt, val, n, w - wt[n - 1]),
					knapsack(wt, val, n - 1, w)
			);
		else
			return knapsack(wt, val, n - 1, w);

	}
}
