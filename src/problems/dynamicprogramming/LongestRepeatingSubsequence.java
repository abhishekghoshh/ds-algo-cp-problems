package problems.dynamicprogramming;
/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=hbTaCmQGqLg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=29
 * 
 */

public class LongestRepeatingSubsequence {
	public static void main(String[] args) {
		type3();
		type4();
	}

	// same as type3 but little optimized
	private static void type4() {
		String str = "abbccabd";
		char[] arr = str.toCharArray();
		int n = arr.length;
		int[][] memo = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i - 1] == arr[j - 1] && i != j) {
					memo[i][j] = 1 + memo[i - 1][j - 1];
				} else {
					memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
				}
			}
		}
		int count = memo[n][n];
		System.out.println(count);
	}

	private static void type3() {
		String str = "abbccabd";
		char[] arr1 = str.toCharArray();
		int n = arr1.length;
		char[] arr2 = new char[n];
		for (int i = 0; i < n; i++) {
			arr2[i] = arr1[i];
		}
		int[][] memo = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			memo[i][n] = 0;
		}
		for (int j = 0; j <= n; j++) {
			memo[n][j] = 0;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr1[i - 1] == arr2[j - 1] && i != j) {
					memo[i][j] = 1 + memo[i - 1][j - 1];
				} else {
					memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
				}
			}
		}
		int count = memo[n][n];
		System.out.println(count);
	}
}
