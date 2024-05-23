package com.problems.dp;

/*
 * Problem link :
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=wuOOOATz_IA&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=26
 * https://www.youtube.com/watch?v=6i_T5kkfv4A
 *
 * https://www.youtube.com/watch?v=bUr8cNWI09Q ->different and effective approach
 *
 * https://takeuforward.org/data-structure/longest-palindromic-subsequence-dp-28/
 */
public class LongestPalindromicSubsequence {
	public static void main(String[] args) {
		type2();
		type3();
		type4();
		type5();
		type6();
	}

	private static void type6() {

	}

	private static void type5() {
		String s = "ynabcdbxmn";

		char[] arr = s.toCharArray();
		int n = arr.length;
		// Create two arrays to store the LCS lengths
		int[] prev = new int[n + 1];
		int[] cur = new int[n + 1];

		// Base Case: Initialized to 0, as no characters matched yet.
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++)
				if (arr[i - 1] == arr[n - j])
					cur[j] = 1 + prev[j - 1];
				else
					cur[j] = Math.max(prev[j], cur[j - 1]);
			// Update the prev array to store the current values
			System.arraycopy(cur, 0, prev, 0, n + 1);
		}
		System.out.println(prev[n]);
	}

	// it is more optimized than the previous
	// here we have used the same array,
	private static void type4() {
		String s = "ynabcdbxmn";
		char[] arr = s.toCharArray();
		int n = arr.length;
		int[][] dp = new int[n + 1][n + 1];
		// we should be initializing the 0th cells with 0, but the array is already initialized with 0,
		// so we don't need to do anything
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++)
				if (arr[i - 1] == arr[n - j])
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
		}
		int len = dp[n][n];
		char[] answer = new char[len];

		int n1 = n, n2 = n;
		while (n1 != 0 && n2 != 0) {
			if (arr[n1 - 1] == arr[n - n2]) {
				answer[--len] = arr[n1 - 1];
				n1--;
				n2--;
			} else {
				if (dp[n1 - 1][n2] > dp[n1][n2 - 1]) n1--;
				else n2--;
			}
		}
		System.out.println(new String(answer));
	}

	// same as previous, but here we are using an array instead of string builder.
	// it will become little optimized from the previous
	// to make it more optimized we can make use of the same array instead of creating the reverse array
	private static void type3() {
		String s = "ynabcdbxmn";
		char[] arr = s.toCharArray();
		int n = arr.length;
		char[] reversed = new char[n];
		for (int i = 0; i < n; i++) reversed[i] = arr[n - 1 - i];

		int[][] dp = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i - 1] == reversed[j - 1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		int len = dp[n][n];
		char[] answer = new char[len];

		int n1 = n, n2 = n;
		while (n1 != 0 && n2 != 0) {
			if (arr[n1 - 1] == reversed[n2 - 1]) {
				answer[--len] = arr[n1 - 1];
				n1--;
				n2--;
			} else {
				if (dp[n1 - 1][n2] > dp[n1][n2 - 1]) n1--;
				else n2--;
			}
		}
		System.out.println(new String(answer));
	}

	// if we think closely, then we will see that the common subsequence of
	// the string and its reverse will be largest palindromic subsequence
	private static void type2() {
		String str1 = "ynabcdbxmn";
		String str2 = new StringBuilder().append(str1).reverse().toString();
		int n = str1.length();
		int[][] dp = new int[n + 1][n + 1];
		// now we will fill up the entire dp array
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++)
				if (str1.charAt(i - 1) == str2.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
		}
		int count = dp[n][n];
		int n1 = n, n2 = n;
		System.out.println(count);
		StringBuilder sb = new StringBuilder();
		// we will do the same what we have done for printing the longest common subsequence
		// we will start from n1 and n2 and go backtracking till one of the strings is consumed entirely.
		// as it is a palindromic subsequence, so we do not need to reverse the string
		while (n1 != 0 && n2 != 0) {
			// string is matched so we decrement both n1 and n2
			if (str1.charAt(n1 - 1) == str2.charAt(n2 - 1)) {
				sb.append(str1.charAt(n1 - 1));
				n1--;
				n2--;
			} else {
				// string is not matched, so we will go to n1 or n2
				// based on Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (dp[n1 - 1][n2] > dp[n1][n2 - 1]) n1--;
				else n2--;
			}
		}
		System.out.println(sb);
	}
}
