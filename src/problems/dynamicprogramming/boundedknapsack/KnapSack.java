package problems.dynamicprogramming.boundedknapsack;

public class KnapSack {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	private static void type3() {
		int wt[] = { 1, 3, 4, 5, 9, 12 };
		int val[] = { 1, 4, 5, 7, 12, 16 };
		int n = val.length;
		int w = 13;
		int[][] memo = new int[n + 1][w + 1];
		for (int i = 0; i <= n; i++) {
			memo[i][0] = 0;
		}
		for (int j = 0; j <= w; j++) {
			memo[0][j] = 0;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				if (wt[i - 1] <= j) {
					memo[i][j] = Math.max(val[i - 1] + memo[i - 1][j - wt[i - 1]], memo[i - 1][j]);
				} else {
					memo[i][j] = memo[i - 1][j];
				}
			}
		}
		int profit = memo[n][w];
		System.out.println(profit);
	}

	private static void type2() {
		int wt[] = { 1, 3, 4, 5, 9, 12 };
		int val[] = { 1, 4, 5, 7, 12, 10 };
		int n = val.length;
		int w = 20;
		int[][] memo = new int[n + 1][w + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= w; j++) {
				memo[i][j] = -1;
			}
		}
		int profit = knapsack(val, wt, w, n, memo);
		System.out.println(profit);
	}

	public static int knapsack(int[] val, int[] wt, int w, int n, int[][] memo) {
		if (w == 0 || n == 0) {
			return 0;
		}
		if (memo[n][w] != -1) {
			return memo[n][w];
		}
		if (wt[n - 1] <= w) {
			memo[n][w] = Math.max(val[n - 1] + knapsack(val, wt, w - wt[n - 1], n - 1, memo),
					knapsack(val, wt, w, n - 1, memo));
		} else {
			memo[n][w] = knapsack(val, wt, w, n - 1, memo);
		}
		return memo[n][w];
	}

	private static void type1() {
		int wt[] = { 1, 3, 4, 5, 9, 12 };
		int val[] = { 1, 4, 5, 7, 12, 10 };
		int n = val.length;
		int w = 10;
		int profit = knapsack(val, wt, w, n);
		System.out.println(profit);
	}

	public static int knapsack(int[] val, int[] wt, int w, int n) {
		if (w == 0 || n == 0) {
			return 0;
		}
		if (wt[n - 1] <= w) {
			return Math.max(val[n - 1] + knapsack(val, wt, w - wt[n - 1], n - 1), knapsack(val, wt, w, n - 1));
		} else {
			return knapsack(val, wt, w, n - 1);
		}
	}

}
