package dynamicprogramming;

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
		int[][] memo = new int[n1 + 1][n2 + 1];
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (arr1[i - 1] == arr2[j - 1]) {
					memo[i][j] = 1 + memo[i - 1][j - 1];
				} else {
					memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
				}
			}
		}
		int subseqLength = memo[n1][n2];
		char[] largestSubSeq = new char[subseqLength];
		while (n1 != 0 && n2 != 0) {
			if (arr1[n1 - 1] == arr2[n2 - 1]) {
				largestSubSeq[--subseqLength] = arr1[n1 - 1];
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
		String longestSubSeq = new String(largestSubSeq);
		System.out.println(longestSubSeq);
	}
}
