package problems.dynamicprogramming.longestcommonsubsequence;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	private static void type3() {
		String s1 = "xabcmagg";
		String s2 = "abcdamg";
		int n1 = s1.length();
		int n2 = s2.length();
		int[][] memo = new int[n1 + 1][n2 + 1];
		for (int i = 0; i <= n1; i++) {
			memo[i][n2] = 0;
		}
		for (int j = 0; j <= n2; j++) {
			memo[n1][j] = 0;
		}
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					memo[i][j] = 1 + memo[i - 1][j - 1];
				} else {
					memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
				}
			}
		}
		int count = memo[n1][n2];
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
