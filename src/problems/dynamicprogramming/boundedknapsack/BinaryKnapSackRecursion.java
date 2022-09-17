package problems.dynamicprogramming.boundedknapsack;

public class BinaryKnapSackRecursion {
	public static void main(String args[]) {
		type1();
	}

	private static void type1() {
		int wt[] = { 1, 3, 4, 5, 9, 12 };
		int val[] = { 1, 4, 5, 7, 12, 10 };
		int n = val.length;
		int w = 10;
		// Long start = System.nanoTime();
		System.out.println(knapsack(val, wt, w, n));
		// Long end = System.nanoTime();
		// System.out.println(end-start);
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
