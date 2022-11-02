package problems.dynamicprogramming;

/*
 * Problem link :
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=wuOOOATz_IA&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=26
 * 
 */
public class LongestPalindromicSubsequence {
	public static void main(String[] args) {
		type2();
		type3();
		type4();
		type5();
	}

	// TODO check it later
	private static void type5() {
		String s = "ynabcdbxmn";
		char[] c = s.toCharArray();
		int[] dp = new int[c.length];
		for (int j = 0; j < dp.length; j++) {
			dp[j] = 1;
			int topRight = 0;
			for (int i = j - 1; i >= 0; i--) {
				int temp = dp[i];
				dp[i] = c[i] == c[j] ? 2 + topRight : Math.max(dp[i], dp[i + 1]);
				topRight = temp;
			}
		}
		int max = dp[0];
		System.out.println(max);
	}

	// TODO check it later
	private static void type4() {
		String s = "ynabcdbxmn";
		char[] c = s.toCharArray();
		int n = c.length, max = 0;
		int[] dp = new int[n];
		for (int j = 0; j < n; j++) {
			dp[j] = 1;
			max = 0;
			for (int i = j - 1; i >= 0; i--) {
				int len = dp[i];
				if (c[i] == c[j]) {
					dp[i] = 2 + max;
				}
				max = Math.max(max, len);
			}
		}
		for (int len : dp)
			max = Math.max(max, len);
		System.out.println(max);
	}

	private static void type3() {
		String s = "ynabcdbxmn";

		char[] arr = s.toCharArray();
		int n = arr.length;
		char[] reversed = new char[n];
		for (int i = 0; i < n; i++) {
			reversed[i] = arr[n - 1 - i];
		}
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
		int count = dp[n][n];
		char[] palindromicSubSeq = new char[count];

		int n1 = n, n2 = n;
		while (n1 != 0 && n2 != 0) {
			if (arr[n1 - 1] == reversed[n2 - 1]) {
				palindromicSubSeq[--count] = arr[n1 - 1];
				n1--;
				n2--;
			} else {
				if (dp[n1 - 1][n2] > dp[n1][n2 - 1]) {
					n1--;
				} else {
					n2--;
				}
			}
		}
		System.out.println(new String(palindromicSubSeq));
	}

	private static void type2() {
		String string = "ynabcdbxmn";
		String reverse = new StringBuilder().append(string).reverse().toString();
		int n = string.length();
		int[][] memo = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (string.charAt(i - 1) == reverse.charAt(j - 1)) {
					memo[i][j] = 1 + memo[i - 1][j - 1];
				} else {
					memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
				}
			}
		}
		int count = memo[n][n];
		int n1 = n, n2 = n;
		System.out.println(count);
		StringBuilder palindromicSubseq = new StringBuilder();
		while (n1 != 0 && n2 != 0) {
			if (string.charAt(n1 - 1) == reverse.charAt(n2 - 1)) {
				palindromicSubseq.append(string.charAt(n1 - 1));
				n1--;
				n2--;
			} else {
				if (memo[n1 - 1][n2] > memo[n1][n2 - 1]) {
					n1--;
				} else {
					n2--;
				}
			}
		}
		// as this is a palidrome we dont need to reverse
		// in case of normal subsequence we had to reverse
		// palindromicSubseq.reverse();
		System.out.println(palindromicSubseq);
	}
}
