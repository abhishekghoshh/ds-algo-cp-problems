package problems.dynamicprogramming.matrixchainmultiplication;

import java.util.Arrays;

/*
 * Problem link :
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=szKVpQtBHh8&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=35
 * https://www.youtube.com/watch?v=fOUlNlawdAU&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=36
 * https://www.youtube.com/watch?v=9h10fqkI7Nk&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=37
 * 
 */
//check https://leetcode.com/submissions/detail/834190482/
public class PalindromePartitioning {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type5();
	}

	// TODO check later
	private static void type5() {
		String str = "xnitinjk";
		char[] arr = str.toCharArray();
		int n = arr.length;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = -1;
		int i = 0;
		while (i < n) {
			expandAround(arr, i, i, dp);
			expandAround(arr, i, i + 1, dp);
			i++;
		}
		int count = dp[n];
		System.out.println(count);
	}

	private static void expandAround(char[] arr, int i, int j, int[] dp) {
		while (i >= 0 && j < arr.length && arr[i] == arr[j]) {
			dp[j + 1] = Math.min(dp[j + 1], dp[i] + 1);
			i--;
			j++;
		}
	}

	// We know that in worst case, total cuts=(n-1) i.e. size -1, checking only if
	// 1st part is Palindrome (then it gives zero cuts, else gives k-1 cuts at that
	// particular point), then check for the other part by calling solve function
	private static void type3() {
		String str = "xnitinjk";
		char[] arr = str.toCharArray();
		int n = arr.length;
		if (isPalindrome(arr, 0, n - 1)) {
			System.out.println(0);
			return;
		}
		int[][] memo = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				memo[i][j] = -1;
			}
		}
		int minCost = minCostOptimized(arr, 0, n - 1, memo);
		System.out.println(minCost);
	}

	private static int minCostOptimized(char[] arr, int i, int j, int[][] memo) {
		if (i >= j) {
			return 0;
		}
		if (memo[i][j] != -1) {
			return memo[i][j];
		}
		if (isPalindrome(arr, i, j)) {
			memo[i][j] = 0;
			return 0;
		}
		int minCost = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			if (isPalindrome(arr, i, k)) {
				minCost = Math.min(minCost, 1 + minCostOptimized(arr, k + 1, j, memo));
			}
		}
		memo[i][j] = minCost;
		return minCost;
	}

	// it will throw TLE in leetcode
	// for this input
	// aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
	private static void type2() {
		String str = "xnitinjk";
		char[] arr = str.toCharArray();
		int n = arr.length;
		if (isPalindrome(arr, 0, n - 1)) {
			System.out.println(0);
			return;
		}
		int[][] memo = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				memo[i][j] = -1;
			}
		}
		int minCost = minCost(arr, 0, n - 1, memo);
		System.out.println(minCost);
	}

	private static int minCost(char[] str, int i, int j, int[][] memo) {
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
		char[] arr = str.toCharArray();
		int n = arr.length;
		int minCost = minCost(arr, 0, n - 1);
		System.out.println(minCost);
	}

	private static int minCost(char[] str, int i, int j) {
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

	private static boolean isPalindrome(char[] str, int i, int j) {
		while (i < j) {
			if (str[i++] != str[j--]) {
				return false;
			}
		}
		return true;
	}
}
