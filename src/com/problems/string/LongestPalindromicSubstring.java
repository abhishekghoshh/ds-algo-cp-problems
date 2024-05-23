package com.problems.string;

import java.util.Arrays;

/*
 * Problem link:
 * https://leetcode.com/problems/longest-palindromic-substring/
 * https://www.codingninjas.com/codestudio/problems/longest-palindromic-substring_758900
 *
 * Solution link:
 * https://www.youtube.com/watch?v=XYQecbcd6_c -> two pointers
 * https://www.youtube.com/watch?v=ZJUGtWObroc -> two pointers
 * https://www.youtube.com/watch?v=UflHuQj6MVA -> Dynamic Programming
 *
 *
 * https://www.youtube.com/watch?v=06QIlUBLTz4 -> Manachers algorithm
 *
 * https://www.geeksforgeeks.org/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		type2();
		type3();
		type4();
		type5();
	}

	// optimized manacher algorithm
	// time complexity O(2n)
	private static void type5() {
		String s = "babab";
		int n = 2 * s.length() + 3;
		// we will add # in between
		// in the start, we will add @, and in the end we will add &
		// initializing the transformed array
		char[] arr = new char[n];
		arr[0] = '@';
		arr[n - 1] = '&';
		arr[n - 2] = '#';
		for (int i = 0; i < s.length(); i++) {
			arr[2 * i + 1] = '#';
			arr[2 * i + 2] = s.charAt(i);
		}
		// actual array is "babad"
		// transformed array is "@#b#a#b#a#d#&"
		int[] lps = new int[n];

		// center mean the index of the mirror
		// right means the boundary
		int center = 0, right = 0;
		// for every point we will think it is in the center,
		// and we will start calculating the longest palindrome string from that point
		// for very point there are two options to calculate palindrome
		// 1. to take the mirror on point
		// 2. to take the mirror next to the point
		// aba -> if we are at point b
		// then mirror can be at two places -> a|a or ab|a
		// we don't need to calculate for the first two and last two characters
		for (int i = 2; i < n - 2; i++) {
			// giving kickstart by checking it's mirror value
			int reflectionIndex = center - (i - center);
			if (i < right)
				lps[i] = Math.min(lps[reflectionIndex], right - i);
			// brute force approach to expand beyond the kickstart
			while (arr[i + 1 + lps[i]] == arr[i - 1 - lps[i]]) {
				lps[i]++;
			}
			if (i + lps[i] > right) {
				center = i;
				right = i + lps[i];
			}
		}
		int index = -1, count = -1;
		for (int i = 0; i < n; i++) {
			if (lps[i] > count) {
				count = lps[i];
				index = i;
			}
		}
		int start = (index - count - 1) / 2;
		System.out.println(count);
		System.out.println(s.substring(start, start + count));
	}

	// brute force of manacher algorithm
	private static void type4() {
		String s = "babad";
		int n = 2 * s.length() + 3;
		// we will add # in between
		// in the start, we will add @, and in the end we will add &
		// initializing the transformed array
		char[] arr = new char[n];
		arr[0] = '@';
		arr[n - 1] = '&';
		arr[n - 2] = '#';
		for (int i = 0; i < s.length(); i++) {
			arr[2 * i + 1] = '#';
			arr[2 * i + 2] = s.charAt(i);
		}
		// actual array is "babad"
		// transformed array is "@#b#a#b#a#d#&"
		int[] lps = new int[n];
		// for every point we will think it is in the center,
		// and we will start calculating the longest palindrome string from that point
		// for very point there are two options to calculate palindrome
		// 1. to take the mirror on point
		// 2. to take the mirror next to the point
		// aba -> if we are at point b
		// then mirror can be at two places -> a|a or ab|a,
		// we don't need to calculate for the first two and last two characters
		for (int i = 2; i < n - 2; i++) {
			while (arr[i + 1 + lps[i]] == arr[i - 1 - lps[i]])
				lps[i]++;
		}
		int count = Arrays.stream(lps).max().getAsInt();
		System.out.println(count);
	}

	// Using dynamic programming
	// TODO Also the approach of longest palindromic subsequence will not work here
	// we will have to think it like a fresh new problem
	// let's say we have a sub string bcbb inside the string 'abbcbba'
	// to check check bcbb is a palindrome we need to check that first char == last char
	// if it false then no matter what is the inner string, it will not be palindrome.
	// or we can say dp[i][j] = if arr[i]==arr[j] then 2 + dp[i+1][j-1] else 0
	// it will handle all the string but 1 and 2 length string
	// we need to manually do that.
	// in recursion that will be essentially our base cases
	private static void type3() {
		String s = "aacabdkacaa";
		char[] arr = s.toCharArray();
		int n = arr.length;
		int[][] dp = new int[n][n];
		int max = 1, start = 0;

		// this is to handle all single digit characters; they are by default palindrome
		for (int i = 0; i < n; i++) dp[i][i] = 1;
		// now we will handle 2-length substring
		for (int i = 0; i < n - 1; i++) {
			dp[i][i + 1] = (arr[i] == arr[i + 1]) ? 2 : 0;
			// checking for the max simultaneously
			if (dp[i][i + 1] > max) {
				max = dp[i][i + 1];
				start = i;
			}
		}
		// now we will do generalization,
		// we will start from j and j+2.
		// we will check for all j and j+i
		for (int d = 2; d < n; d++) {
			for (int i = 0; i < n - d; i++) {
				int end = i + d;
				// we will check 2 conditions, i.e., last letters are the same or not and inner substring is palindrome
				dp[i][end] = (arr[i] == arr[end] && dp[i + 1][end - 1] != 0) ?
						2 + dp[i + 1][end - 1] :
						0;
				// checking for the max simultaneously
				if (dp[i][end] > max) {
					max = dp[i][end];
					start = i;
				}
			}
		}
		String answer = s.substring(start, start + max);
		System.out.println(answer);
	}


	// optimal approach using 2 pointer
	// time complexity O(n^2)
	// space complexity O(1)
	// if you are using java don't directly operate on string
	// rather create one array of character otherwise it will long time
	private static void type2() {
		String s = "babad";
		char[] arr = s.toCharArray();
		int start = 0, max = 0, len;
		for (int i = 0; i < arr.length; i++) {
			// when we are considering the odd length palindrome, and the center is (i,i)
			int len1 = expand(i, i, arr);
			// when we are considering the even length palindrome, and the center is (i,i+1)
			int len2 = expand(i, i + 1, arr);
			len = Math.max(len1, len2);
			// checking the total string length
			if (len > max) {
				max = len;
				start = i - (len - 1) / 2;
			}
		}
		String answer = s.substring(start, start + max);
		System.out.println(answer);
	}

	static int expand(int l, int r, char[] arr) {
		while (l >= 0 && r < arr.length && arr[l] == arr[r]) {
			l--;
			r++;
		}
		return r - l - 1;
	}

	// brute force approach
	// uses a n^2 loop, and for every (i,j) we will check if the substring is palindrome or not
	// and that palindrome is the largest palindrome or not
	private static void type1() {

	}
}
