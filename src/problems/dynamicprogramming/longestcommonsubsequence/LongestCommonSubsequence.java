package problems.dynamicprogramming.longestcommonsubsequence;

/*
 * Problem link :
 * https://leetcode.com/problems/longest-common-subsequence/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=4dMlCZTONj8&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=18
 * https://www.youtube.com/watch?v=4Urd0a0BNng&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=19
 * https://www.youtube.com/watch?v=g_hIx4yn9zg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=20
 * https://www.youtube.com/watch?v=hR3s9rGlMTU&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=21
 * 
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
		type5();
	}

	// 1D array
	private static void type5() {
		String text1 = "abac";
		String text2 = "cab";
		if (text1.length() < text2.length()) {
			String temp = text1;
			text1 = text2;
			text2 = temp;
		}

		char[] sChars = text1.toCharArray();
		char[] tChars = text2.toCharArray();
		int[] dp = new int[tChars.length + 1];

		for (char sChar : sChars) {
			int[] current = new int[dp.length];
			for (int j = 0; j < tChars.length; j++) {
				current[j + 1] = sChar == tChars[j] ? dp[j] + 1 : Math.max(current[j], dp[j + 1]);
			}
			dp = current;
		}

		int count = dp[dp.length - 1];
		System.out.println(count);
	}

	private static void type4() {
		String text1 = "abac";
		String text2 = "cab";
		char[] arr1 = text1.toCharArray();
		char[] arr2 = text2.toCharArray();
		int n1 = arr1.length;
		int n2 = arr2.length;
		int[][] dp = new int[n1 + 1][n2 + 1];
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (arr1[i - 1] == arr2[j - 1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		int count = dp[n1][n2];
		System.out.println(count);
	}

	private static void type3() {
		String s1 = "abac";
		String s2 = "cab";
		int n1 = s1.length();
		int n2 = s2.length();
		int[][] dp = new int[n1 + 1][n2 + 1];
		for (int i = 0; i <= n1; i++) {
			dp[i][n2] = 0;
		}
		for (int j = 0; j <= n2; j++) {
			dp[n1][j] = 0;
		}
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		int count = dp[n1][n2];
		System.out.println(count);
	}

	private static void type2() {
		String s1 = "xabcmagg";
		String s2 = "abcdamg";
		int n1 = s1.length();
		int n2 = s2.length();
		int[][] memo = new int[n1 + 1][n2 + 1];
		for (int i = 0; i <= n1; i++) {
			for (int j = 0; j <= n2; j++) {
				memo[i][j] = -1;
			}
		}
		int count = lcs(s1, s2, n1, n2, memo);
		System.out.println(count);
	}

	private static int lcs(String s1, String s2, int n1, int n2, int[][] memo) {
		if (memo[n1][n2] != -1) {
			return memo[n1][n2];
		}
		if (n1 == 0 || n2 == 0) {
			return 0;
		}
		if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
			memo[n1][n2] = 1 + lcs(s1, s2, n1 - 1, n2 - 1, memo);
		} else {
			memo[n1][n2] = Math.max(lcs(s1, s2, n1, n2 - 1, memo), lcs(s1, s2, n1 - 1, n2, memo));
		}
		return memo[n1][n2];
	}

	private static void type1() {
		String s1 = "xabcma";
		String s2 = "abcda";
		int n1 = s1.length();
		int n2 = s2.length();
		int count = lcs(s1, s2, n1, n2);
		System.out.println(count);
	}

	private static int lcs(String s1, String s2, int n1, int n2) {
		if (n1 == 0 || n2 == 0) {
			return 0;
		}
		if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
			return 1 + lcs(s1, s2, n1 - 1, n2 - 1);
		} else {
			return Math.max(lcs(s1, s2, n1, n2 - 1), lcs(s1, s2, n1 - 1, n2));
		}
	}
}
