package dynamicprogramming;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=HrybPYpOvz0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=22
 * 
 */
public class LongestCommonSubstring {
	public static void main(String[] args) {
		type2();
	}

	private static void type2() {
		String str1 = "abcdefmno";
		String str2 = "mabcxmn";
		int n1 = str1.length();
		int n2 = str2.length();
		int[][] memo = new int[n1 + 1][n2 + 1];
		int maxCount = 0;
		String maxString = null;
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					memo[i][j] = 1 + memo[i - 1][j - 1];
					if (maxCount < memo[i][j]) {
						maxCount = memo[i][j];
						maxString = str1.substring(i - maxCount, i);
					}
				} else {
					memo[i][j] = 0;
				}
			}
		}
		System.out.println(maxCount);
		System.out.println(maxString);
	}
}
