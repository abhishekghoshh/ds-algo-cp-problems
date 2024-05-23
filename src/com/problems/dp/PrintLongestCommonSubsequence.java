package com.problems.dp;

/*
 * Problem link :
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=x5hQvnUcjiM&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=23
 * 
 */
public class PrintLongestCommonSubsequence {
	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		String str1 = "abcfe";
		String str2 = "abcdef";
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		int n1 = arr1.length;
		int n2 = arr2.length;
		int[][] dp = new int[n1 + 1][n2 + 1];

		// now we will fill all the cells of the dp array
		for (int i = 1; i <= n1; i++)
			for (int j = 1; j <= n2; j++)
				if (arr1[i - 1] == arr2[j - 1])
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

		int len = dp[n1][n2];
		char[] arr = new char[len];
		// now we will backtrack from n1,n2 to 0,0 and along the way we will add the letters
		while (n1 != 0 && n2 != 0) {
			// if letters match then we will add that to the answer
			if (arr1[n1 - 1] == arr2[n2 - 1]) {
				arr[--len] = arr1[n1 - 1];
				n1--;
				n2--;
			} else {
				// if characters do not match, then we have to go either to n1-1 direction or n2-1
				// because dp[i][j] came from Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (dp[n1 - 1][n2] > dp[n1][n2 - 1]) n1--;
				else n2--;
			}
		}
		String str = new String(arr);
		System.out.println(str);
	}
}
