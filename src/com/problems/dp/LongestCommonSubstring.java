package com.problems.dp;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=HrybPYpOvz0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=22
 * https://www.youtube.com/watch?v=_wP9mWNPL5w
 */
public class LongestCommonSubstring {
	public static void main(String[] args) {
		type2();
	}

	// this problem is almost similar to the longest common subsequence problem,
	// but when the characters don't match at that time, we have to directly set the value to 0
	private static void type2() {
		String str1 = "abcdefxmno";
		String str2 = "mabcxmno";
		int n1 = str1.length();
		int n2 = str2.length();
		int[][] memo = new int[n1 + 1][n2 + 1];
		int len = 0, end = -1;
		String answer = "";
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++)
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					// similar to the longest common subsequence
					memo[i][j] = 1 + memo[i - 1][j - 1];
					// this is the extra stuff that we are doing to store the result
					// unlike LCS the substring can be found anywhere in between the string
					// not the end
					if (len < memo[i][j]) {
						len = memo[i][j];
						end = i - 1;
					}
				} else memo[i][j] = 0; // it will directly be 0, as we cannot add a letter to
		}
		System.out.println(len + " " + end);
		if (end != -1) answer = str1.substring(end - len + 1, end + 1);
		System.out.println(answer);
	}
}
