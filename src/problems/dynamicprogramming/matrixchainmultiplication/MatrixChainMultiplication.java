package problems.dynamicprogramming.matrixchainmultiplication;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		int matrices[] = { 40, 20, 30, 10, 30, 25 };
		int n = matrices.length;
		int[][] memo = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				memo[i][j] = -1;
			}
		}
		int minCost = mcm(matrices, 1, n - 1, memo);
		System.out.println(minCost);
	}

	private static int mcm(int[] matrices, int i, int j, int[][] memo) {
		if (memo[i][j] != -1) {
			return memo[i][j];
		}
		if (i >= j) {
			return 0;
		}
		int minCost = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int tempCost = mcm(matrices, i, k, memo) + mcm(matrices, k + 1, j, memo)
					+ matrices[i - 1] * matrices[k] * matrices[j];
			if (minCost > tempCost) {
				minCost = tempCost;
			}
		}
		memo[i][j] = minCost;
		return minCost;
	}

	private static void type1() {
		int matrices[] = { 40, 20, 30, 10, 30, 25 };
		int length = matrices.length;
		int minCost = mcm(matrices, 1, length - 1);
		System.out.println(minCost);
	}

	private static int mcm(int[] matrices, int i, int j) {
		if (i >= j) {
			return 0;
		}
		int minCost = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int tempCost = mcm(matrices, i, k) + mcm(matrices, k + 1, j) + matrices[i - 1] * matrices[k] * matrices[j];
			if (minCost > tempCost) {
				minCost = tempCost;
			}
		}
		return minCost;
	}
}
