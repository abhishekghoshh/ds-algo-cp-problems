package com.problems.string;

import java.util.Arrays;

/*
 * Problem link : 
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * https://www.codingninjas.com/codestudio/problems/longest-palindromic-substring_758900
 * 
 * Solution link:
 * https://www.youtube.com/watch?v=06QIlUBLTz4
 * 
 * 
 * 
 * */
public class LongestPalindrome {

	// TODO study later
	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
		type5();
	}

	// TODO study one more time later
	// optimized manacher algorithm
	// time complexity O(2n)
	private static void type5() {
		String s = "babab";
		int n = 2 * s.length() + 3;
		// we will add # in between
		// in the start we will add @ and in the end we will add &
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
		// for every point we will think it is in the center
		// and we will start calculating the longest palindrome string from that point
		// for very point there is two option to calculate palidrome
		// 1. to take the mirror on the point
		// 2. to take the mirror next to the point
		// aba -> if we are at point b
		// then mirror can be at two place -> a|a or ab|a
		// we don't need to calculate for the first two and last two character
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
		// in the start we will add @ and in the end we will add &
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
		// for every point we will think it is in the center
		// and we will start calculating the longest palindrome string from that point
		// for very point there is two option to calculate palidrome
		// 1. to take the mirror on the point
		// 2. to take the mirror next to the point
		// aba -> if we are at point b
		// then mirror can be at two place -> a|a or ab|a
		// we don't need to calculate for the first two and last two character
		for (int i = 2; i < n - 2; i++) {
			while (arr[i + 1 + lps[i]] == arr[i - 1 - lps[i]]) {
				lps[i]++;
			}
		}
		int count = Arrays.stream(lps).max().getAsInt();
		System.out.println(count);
	}

	private static void type3() {
		String s = "babad";
		int maxSize = 0, start = 0, end = 0, left, right, n = s.length();
		char[] arr = s.toCharArray();
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				left = i;
				right = i + 1;
				while (left >= 0 && right < n && arr[left] == arr[right]) {
					left--;
					right++;
				}
				left++;
				right--;
				if (right - left + 1 > maxSize) {
					maxSize = right - left + 1;
					start = left;
					end = right;
				}
			}
			left = i;
			right = i;
			while (left >= 0 && right < n && arr[left] == arr[right]) {
				left--;
				right++;
			}
			left++;
			right--;
			if (right - left + 1 > maxSize) {
				maxSize = right - left + 1;
				start = left;
				end = right;
			}
		}
		String answer = s.substring(start, end + 1);
		System.out.println(answer);
	}

	private static void type2() {
		String s = "babad";
		char[] chars = s.toCharArray();
		int start = 0;
		int end = 0;
		for (int i = 0; i < chars.length; i++) {
			int len1 = expand(i, i, chars);
			int len2 = expand(i, i + 1, chars);
			int length = Math.max(len1, len2);
			if (length > end - start) {
				start = i - (length - 1) / 2;
				end = start + length - 1;
			}
		}
		String answer = s.substring(start, end + 1);
		System.out.println(answer);
	}

	static int expand(int l, int r, char[] chars) {
		while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
			l--;
			r++;
		}
		return r - l - 1;
	}

	private static void type1() {
		String s = "babad";
		int st = 0, en = 0;
		for (int i = 0; i < s.length(); i++) {
			int l1 = check(s, i, i + 1);
			int l2 = check(s, i, i);
			int l = Math.max(l1, l2);
			if (en - st < l) {
				st = i - (l - 1) / 2;
				en = i + (l / 2);
			}
		}
		String answer = s.substring(st, en + 1);
		System.out.println(answer);
	}

	static int check(String s, int i, int j) {
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
		}
		return j - i - 1;
	}

}
