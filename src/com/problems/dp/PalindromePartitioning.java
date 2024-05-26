package com.problems.dp;

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
public class PalindromePartitioning {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
		type5();
	}

	// same as previous with some modification
	// todo check it later one more time
	private static void type5() {
		String str = "xnitinjk";
		int minCost = minCut5(str);
		System.out.println(minCost);
	}

	private static int minCut5(String s) {
		char[] c = s.toCharArray();
		int n = c.length;
		int[] cut = new int[n];
		boolean[][] pal = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = 0; j <= i; j++) {
				if (c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
					pal[j][i] = true;
					min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
				}
			}
			cut[i] = min;
		}
		return cut[n - 1];
	}

	// let's do it in a different way, but using dp only
	// first we will calculate all the palindromic substring
	// then only we will try to find the cuts needed
	private static void type4() {
		String str = "xnitinjk";
		int minCost = minCut4(str);
		System.out.println(minCost);
	}

	public static int minCut4(String s) {
		int n = s.length();
		boolean[][] palindrome = new boolean[n][n];

		// Fill the palindrome table
		// first all single characters
		for (int i = 0; i < n; i++) palindrome[i][i] = true;

		// then two length characters
		for (int i = 0; i < n - 1; i++)
			palindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));

		// then we will check for all length characters strings from 3
		for (int length = 3; length <= n; length++) {
			for (int i = 0; i <= n - length; i++) {
				int j = i + length - 1;
				palindrome[i][j] = (s.charAt(i) == s.charAt(j)) && palindrome[i + 1][j - 1];
			}
		}

		// Calculate minimum cuts
		// now with O(n^2) loop we will try to find all the cuts possible
		int[] cuts = new int[n];
		for (int i = 0; i < n; i++) {
			int minCut = i;
			for (int j = 0; j <= i; j++) {
				if (palindrome[j][i])
					minCut = (j == 0) ? 0 : Math.min(minCut, cuts[j - 1] + 1);
			}
			cuts[i] = minCut;
		}

		return cuts[n - 1];
	}

	// TODO check it one more time
	// We know that in the worst case, total cuts=(n-1) i.e., size -1,
	// checking only if the 1st part is Palindrome (then it gives zero cuts, else gives k-1 cuts at that
	// particular point), then check for the other part by calling solve function
	private static void type3() {
		String str = "xnitinjk";
		int minCost = minCut3(str);
		System.out.println(minCost);
	}

	public static int minCut3(String str) {
		char[] arr = str.toCharArray();
		int n = arr.length;
		// early optimization
		if (isPalindrome(arr, 0, n - 1)) return 0;
		int[][] memo = new int[n + 1][n + 1];
		for (int[] row : memo) Arrays.fill(row, -1);
		return minCostOptimized(arr, 0, n - 1, memo);
	}

	private static int minCostOptimized(char[] arr, int i, int j, int[][] memo) {
		// if it is a single character, then it is always a palindrome
		if (i >= j) return 0;
		// return if the recursion call is already memoized
		if (memo[i][j] != -1) return memo[i][j];
		// if it is already a palindrome, then we do not need to partition it
		// we will also save if it is a palindrome in the memo
		if (isPalindrome(arr, i, j)) return memo[i][j] = 0;

		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			if (isPalindrome(arr, i, k)) {
				int cost = 1 + minCostOptimized(arr, k + 1, j, memo);
				min = Math.min(min, cost);
			}
		}
		memo[i][j] = min;
		return min;
	}

	// memoized recursion code
	// it will throw TLE in leetcode
	private static void type2() {
		String str = "xnitinjk";
		int minCost = minCut2(str);
		System.out.println(minCost);
	}

	public static int minCut2(String str) {
		char[] arr = str.toCharArray();
		int n = arr.length;
		if (isPalindrome(arr, 0, n - 1)) return 0;
		int[][] memo = new int[n + 1][n + 1];
		for (int[] row : memo) Arrays.fill(row, -1);
		return minCost(arr, 0, n - 1, memo);
	}

	private static int minCost(char[] str, int i, int j, int[][] memo) {
		// if it is a single character, then it is always a palindrome
		if (i >= j) return 0;
		// return if the recursion call is already memoized
		if (memo[i][j] != -1) return memo[i][j];
		// if it is already a palindrome, then we do not need to partition it
		if (isPalindrome(str, i, j)) return memo[i][j] = 0;

		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			// on every character we will try to break the string and find the cost
			int cost = 1 + minCost(str, i, k, memo) + minCost(str, k + 1, j, memo);
			// we will update the min
			if (min > cost) min = cost;
		}
		// before returning the answer, we will also save it
		return memo[i][j] = min;
	}

	private static void type1() {
		String str = "xnitinjk";
		int minCost = minCut1(str);
		System.out.println(minCost);
	}

	public static int minCut1(String s) {
		char[] arr = s.toCharArray();
		int n = arr.length;
		return minCost(arr, 0, n - 1);
	}

	private static int minCost(char[] str, int i, int j) {
		// if it is a single character, then it is always a palindrome
		if (i >= j) return 0;
		// if it is already a palindrome, then we do not need to partition it
		if (isPalindrome(str, i, j)) return 0;

		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			// on every character we will try to break the string and find the cost
			int cost = 1 + minCost(str, i, k) + minCost(str, k + 1, j);
			// we will update the min
			if (min > cost) min = cost;
		}
		return min;
	}

	private static boolean isPalindrome(char[] str, int i, int j) {
		while (i < j) if (str[i++] != str[j--]) return false;
		return true;
	}
}
