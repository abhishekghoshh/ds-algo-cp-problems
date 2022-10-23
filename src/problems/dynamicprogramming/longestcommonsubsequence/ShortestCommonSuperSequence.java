package problems.dynamicprogramming.longestcommonsubsequence;

public class ShortestCommonSuperSequence {
	public static void main(String[] args) {
		String str1 = "abcdefg";
		String str2 = "xbcyefmnop";
		int n1 = str1.length();
		int n2 = str2.length();
		int[][] dp = new int[n1 + 1][n2 + 1];
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		int maxSubSequenceLength = dp[n1][n2];
		int shortestCommonSuperSequenceLength = n1 + n2 - maxSubSequenceLength;
		System.out.println(shortestCommonSuperSequenceLength);
	}
}
