package problems.dynamicprogramming.longestcommonsubsequence;

public class PrintLongestCommonSubsequence {
	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		String str1 = "abcfe";
		String str2 = "abcdef";
		int n1 = str1.length();
		int n2 = str2.length();
		int[][] memo = new int[n1 + 1][n2 + 1];
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					memo[i][j] = 1 + memo[i - 1][j - 1];
				} else {
					memo[i][j] = Math.max(memo[i - 1][j - 1], memo[i - 1][j - 1]);
				}
			}
		}
		String longestSubString = "";
		while (n1 != 0 || n2 != 0) {
			if (str1.charAt(n1 - 1) == str2.charAt(n2 - 1)) {
				longestSubString = str1.charAt(n1 - 1) + longestSubString;
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
		System.out.println(longestSubString);
	}
}
