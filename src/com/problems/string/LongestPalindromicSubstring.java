package com.problems.string;

/*
 * Problem link :
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Solution link :
 *
 *
 */
public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
	}

	// TODO complete it
	// same as previous approach
	// we will do some early optimization
	// like if we already see that the max is 8 then we don't need to go the end
	// because if we go to the indices like n-1 or n-2
	// from that indices the max palindromic string can be constructed either 2 or 3
	// not mor than that
	private static void type4() {

	}

	// optimal approach
	// time complexity O(n^2)
	// space complexity O(1)
	private static void type3() {
		String s = "babad";
		char[] arr = s.toCharArray();
		int n = s.length();
		int max = 0, start = 0, end = 0;
		int left, right;
		// if you are using java
		// don't directly operate on string
		// rather create one array of character
		// otherwise it will long time
		for (int i = 0; i < n - 1; i++) {
			// i and i+1 will be the center
			if (arr[i] == arr[i + 1]) {
				left = i;
				right = i + 1;
				while (left >= 0 && right < n && arr[left] == arr[right]) {
					left--;
					right++;
				}
				left++;
				right--;
				if (right - left + 1 > max) {
					max = right - left + 1;
					start = left;
					end = right;
				}
			}
			// i will be the center
			left = i;
			right = i;
			while (left >= 0 && right < n && arr[left] == arr[right]) {
				left--;
				right++;
			}
			left++;
			right--;
			if (right - left + 1 > max) {
				max = right - left + 1;
				start = left;
				end = right;
			}
		}
		s = s.substring(start, end + 1);
		System.out.println(s);
	}


	// This is also done by dp
	// TODO check it later
	public static void type2() {
		String s = "acaabkaaca";
		final int n = s.length();
		int[][] dp = new int[n][n];
		char[] chs = s.toCharArray();

		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}

		for (int c = 1; c < n; c++) {
			for (int y = c; y < n; y++) {
				int x = y - c;
				if (c == 1 && chs[x] == chs[y]) {
					dp[x][y] = 2;
				} else if (chs[x] == chs[y] && x + 1 < n && dp[x + 1][y - 1] != 0) {
					dp[x][y] = y - x + 1;
				}
			}
		}

		int max = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (dp[i][j] > max) {
					max = dp[i][j];
					x = i;
					y = j;
				}
			}
		}

		String palindrome = s.substring(x, y + 1);
		System.out.println(palindrome);
	}

	// TODO it is failing for the following input
	//  do it in a different approach
	public static void type1() {
		String s = "acaabkaaca";
		char[] arr = s.toCharArray();
		int n = arr.length;
		char[] reversed = new char[n];
		for (int i = 0; i < n; i++) reversed[i] = arr[n - 1 - i];

		int max = 0;
		int end = -1;
		int[][] memo = new int[n + 1][n + 1];

		// 0th column and 0th row will be 0
		// so, we don't have to initialize
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i - 1] == reversed[j - 1]) {
					// memo[i][j] is length of string matching
					// arr[i - memo[i][j]] == arr[i - 1] means starting and ending character is same
					memo[i][j] = 1 + memo[i - 1][j - 1];
					if (memo[i][j] > max && arr[i - memo[i][j]] == arr[i - 1]) {
						max = memo[i][j];
						end = i - 1;
					}
				} else {
					memo[i][j] = 0;
				}
			}
		}
		String palindrome = s.substring(end - max + 1, end + 1);
		System.out.println(palindrome);
	}
}
