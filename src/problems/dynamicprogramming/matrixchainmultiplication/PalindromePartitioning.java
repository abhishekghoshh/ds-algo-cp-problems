package problems.dynamicprogramming.matrixchainmultiplication;

public class PalindromePartitioning {
	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		String str = "snitinak";
		int n = str.length();
		int[][] memo = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				memo[i][j] = -1;
			}
		}
		int minCost = minCost(str, 0, n - 1, memo);
		System.out.println(minCost);
	}

	private static int minCost(String str, int i, int j, int[][] memo) {
		if (i >= j) {
			return 0;
		}
		if (memo[i][j] != -1) {
			return memo[i][j];
		}
		if (isPalindrome(str, i, j)) {
			return 0;
		}
		int minCost = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int cost = 1 + minCost(str, i, k, memo) + minCost(str, k + 1, j, memo);
			if (minCost > cost) {
				minCost = cost;
			}
		}
		memo[i][j] = minCost;
		return minCost;
	}

	private static void type1() {
		String str = "xnitinjk";
		int n = str.length();
		int minCost = minCost(str, 0, n - 1);
		System.out.println(minCost);
	}

	private static int minCost(String str, int i, int j) {
		if (i >= j) {
			return 0;
		}
		if (isPalindrome(str, i, j)) {
			return 0;
		}
		int minCost = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int cost = 1 + minCost(str, i, k) + minCost(str, k + 1, j);
			if (minCost > cost) {
				minCost = cost;
			}
		}
		return minCost;
	}

	private static boolean isPalindrome(String str, int i, int j) {
		while (i < j) {
			if (str.charAt(i) == str.charAt(j)) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;
	}
}
