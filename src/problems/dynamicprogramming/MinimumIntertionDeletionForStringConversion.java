package problems.dynamicprogramming;

/*
 * Problem link :
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 * https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1
 * 
 * https://www.codingninjas.com/codestudio/problem-details/can-you-make_4244510
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=-fx6aDxcWyg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=25
 * 
 */
public class MinimumIntertionDeletionForStringConversion {
	public static void main(String[] args) {
		type3();
	}

	private static void type3() {
		String str1 = "abcdef";
		String str2 = "xbcdmn";
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
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
		int delCount = n1 - dp[n1][n2];
		int insertCount = n2 - dp[n1][n2];
		int n = delCount + insertCount;
		System.out.println(n);
	}
}
