package problems.dynamicprogramming.longestcommonsubsequence;
/*
 * Problem link :
 * https://leetcode.com/problems/shortest-common-supersequence/submissions/
 * https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=823Grn4_dCQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=24
 * https://www.youtube.com/watch?v=VDhRg-ZJTuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=28
 * 
 */
public class ShortestCommonSuperSequence {
	public static void main(String[] args) {
		type3();
		type4();
	}

	private static void type4() {
		String str1 = "abac";
		String str2 = "cab";

		int n = str1.length(), m = str2.length();
		str1 = " " + str1;
		str2 = " " + str2;
		char[] s1 = str1.toCharArray(), s2 = str2.toCharArray();
		int[][] f = new int[n + 10][m + 10];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1[i] == s2[j])
					f[i][j] = f[i - 1][j - 1] + 1;
				else
					f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
			}
		}
		StringBuilder sb = new StringBuilder();
		int i = n, j = m;
		while (i > 0 || j > 0) {
			if (i == 0)
				sb.append(s2[j--]);
			else if (j == 0)
				sb.append(s1[i--]);
			else {
				if (s1[i] == s2[j]) {
					sb.append(s1[i]);
					i--;
					j--;
				} else if (f[i][j] == f[i - 1][j]) {
					sb.append(s1[i--]);
				} else {
					sb.append(s2[j--]);
				}
			}
		}
		String answer = sb.reverse().toString();
		System.out.println(answer);
	}

	private static void type3() {
		String s1 = "abac";
		String s2 = "cab";

		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
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
		// length of shortest common super sequence is n1 + n2 - dp[n1][n2];
		int n = n1 + n2 - dp[n1][n2];
		System.out.println(n);
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
		String answer = new String(superSeq);
		System.out.println(answer);
	}
}
