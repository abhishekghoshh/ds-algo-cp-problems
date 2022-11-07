package problems.dynamicprogramming;
/*
 * Problem link :
 * https://leetcode.com/problems/edit-distance/
 * 
 * Solution link :
 * 
 * 
 */

public class EditDistance {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	private static void type3() {

	}

	//memoization approach
	private static void type2() {
		String word1 = "abc";
		String word2 = "efg";
		char[] w1 = word1.toCharArray();
		int n1 = w1.length;
		char[] w2 = word2.toCharArray();
		int n2 = word2.length();
		//initialization
		int[][] dp = new int[n1 + 1][n2 + 1];
		for (int i = 0; i <= n1; i++) {
			for (int j = 0; j <= n2; j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else {
					dp[i][j] = -1;
				}
			}
		}
		int editDistance = minDistance(w1, n1, w2, n2, dp);
		System.out.println(editDistance);
	}

	private static int minDistance(char[] word1, int n1, char[] word2, int n2, int[][] dp) {
		if (dp[n1][n2] == -1) {
			if (word1[n1 - 1] == word2[n2 - 1]) {
				dp[n1][n2] = minDistance(word1, n1 - 1, word2, n2 - 1, dp);
			} else {
				int replacedLastChar = minDistance(word1, n1 - 1, word2, n2 - 1, dp);
				int deleteLastCharacterFromFirstString = minDistance(word1, n1, word2, n2 - 1, dp);
				int deleteLastCharacterFromSecondString = minDistance(word1, n1 - 1, word2, n2, dp);
				dp[n1][n2] = 1 + min(replacedLastChar, deleteLastCharacterFromFirstString,
						deleteLastCharacterFromSecondString);
			}
		}
		return dp[n1][n2];
	}

	private static void type1() {
		String word1 = "abc";
		String word2 = "efg";
		char[] w1 = word1.toCharArray();
		int n1 = w1.length;
		char[] w2 = word2.toCharArray();
		int n2 = word2.length();
		int editDistance = minDistance(w1, n1, w2, n2);
		System.out.println(editDistance);
	}

	private static int minDistance(char[] word1, int n1, char[] word2, int n2) {
		if (n1 == 0 || n2 == 0) {
			return n1 == 0 ? n2 : n1;
		} else if (word1[n1 - 1] == word2[n2 - 1]) {
			return minDistance(word1, n1 - 1, word2, n2 - 1);
		} else {
			int replacedLastChar = minDistance(word1, n1 - 1, word2, n2 - 1);
			int deleteLastCharacterFromFirstString = minDistance(word1, n1, word2, n2 - 1);
			int deleteLastCharacterFromSecondString = minDistance(word1, n1 - 1, word2, n2);
			return 1 + min(replacedLastChar, deleteLastCharacterFromFirstString, deleteLastCharacterFromSecondString);
		}
	}

	private static int min(int num, int... nums) {
		for (int item : nums) {
			num = num > item ? item : num;
		}
		return num;
	}
}
