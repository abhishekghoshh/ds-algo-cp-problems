package com.problems.dp;

/*
 * Problem link :
 * https://www.interviewbit.com/problems/0-1-knapsack/
 * 
 * Solution link :
 * Aditya verma
 * https://www.youtube.com/watch?v=nqowUJzG-iM&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
 * https://www.youtube.com/watch?v=kvyShbFVaY8&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=3
 * https://www.youtube.com/watch?v=fJbIuhs24zQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=4
 * https://www.youtube.com/watch?v=ntCGbPMeqgg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=5
 * https://www.youtube.com/watch?v=iBnWHZmlIyY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=6
 * 
 * */
public class Knapsack {

	/*
	 * Identifying Dynamic programming
	 * 1. Recursive problems where max, min, largest, minimum or total count are asked
	 * 2. Choices are given
	 * 3. Overlapping sub-problems
	 * 4. More than one function is called from a function
	 * 5. Same function with same arguments is called more than one times
	 * */
	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// Top-down approach
	private static void type3() {
		int[] wt = {1, 3, 4, 5, 9, 12};
		int[] val = {1, 4, 5, 7, 12, 16};
		int n = val.length;
		int w = 13;
		// we will store all the profits in memo
		int[][] memo = new int[n + 1][w + 1];

		// initialization
		// here weight is 0, for weight 0 there will be no item to take, so our profit will be zero
		for (int i = 0; i <= n; i++) memo[i][0] = 0;

		// same like the previous one
		// here item count is 0, so we have nothing to take, and our profit is 0
		for (int j = 0; j <= w; j++) memo[0][j] = 0;

		// top-down operation
		// we will do this for all n and all w
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= w; j++)
				if (wt[i - 1] <= j)
					memo[i][j] = Math.max(
							val[i - 1] + memo[i - 1][j - wt[i - 1]],
							memo[i - 1][j]
					);
				else
					memo[i][j] = memo[i - 1][j];


		int profit = memo[n][w];
		System.out.println(profit);
	}

	private static void type2() {
		int[] wt = {1, 3, 4, 5, 9, 12};
		int[] val = {1, 4, 5, 7, 12, 10};
		int n = val.length;
		int w = 20;
		int[][] memo = new int[n + 1][w + 1];
		// initializing with negative value
		// marking all the cells unvisited
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= w; j++)
				memo[i][j] = -1;


		int profit = knapsack(val, wt, w, n, memo);
		System.out.println(profit);
	}

	// same as before, but if in any point we see, the recursion is already computed,
	// then we will not call recursion again, rather we will directly return from our memo
	public static int knapsack(int[] val, int[] wt, int w, int n, int[][] memo) {
		/// this is the base case when no weight and item is remaining
		if (w == 0 || n == 0) return 0;
		// if the function is already called, then the cell will have a value
		if (memo[n][w] != -1) return memo[n][w];

		// now if the weight is lesser than the item, then we will have two choices else one
		if (wt[n - 1] <= w)
			memo[n][w] = Math.max(
					val[n - 1] + knapsack(val, wt, w - wt[n - 1], n - 1, memo),
					knapsack(val, wt, w, n - 1, memo)
			);
		else
			memo[n][w] = knapsack(val, wt, w, n - 1, memo);

		return memo[n][w];
	}

	// simple recursion
	private static void type1() {
		int[] wt = {1, 3, 4, 5, 9, 12};
		int[] val = {1, 4, 5, 7, 12, 10};
		int n = val.length;
		int w = 10;
		int profit = knapsack(val, wt, w, n);
		System.out.println(profit);
	}

	public static int knapsack(int[] val, int[] wt, int w, int n) {
		// this is the base case when no weight and item is remaining
		if (w == 0 || n == 0) return 0;
		// if the nth item weight is less than our current capacity, then we have
		// two options, either to choose it or not
		// if it is greater than our current capacity, then we will not include it
		if (wt[n - 1] <= w)
			return Math.max(
					val[n - 1] + knapsack(val, wt, w - wt[n - 1], n - 1),
					knapsack(val, wt, w, n - 1)
			);
		else
			return knapsack(val, wt, w, n - 1);
	}

}
