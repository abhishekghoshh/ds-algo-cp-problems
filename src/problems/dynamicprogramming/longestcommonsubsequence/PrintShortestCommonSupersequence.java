package problems.dynamicprogramming.longestcommonsubsequence;

public class PrintShortestCommonSupersequence {
	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		String s1 = "abac";
		String s2 = "cab";
		int n1 = s1.length();
		int n2 = s2.length();
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
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
		int n = n1 + n2 - dp[n1][n2];
		char[] superSeq = new char[n];
		while (n1 != 0 && n2 != 0) {
			if (arr1[n1 - 1] == arr2[n2 - 1]) {
				superSeq[--n] = arr1[n1 - 1];
				n1--;
				n2--;
			} else {
				if (dp[n1 - 1][n2] > dp[n1][n2 - 1]) {
					superSeq[--n] = arr1[--n1];
				} else {
					superSeq[--n] = arr2[--n2];
				}
			}
		}
		while (n1 != 0) {
			superSeq[--n] = arr1[--n1];
		}
		while (n2 != 0) {
			superSeq[--n] = arr2[--n2];
		}
		System.out.println(new String(superSeq));
	}
}
