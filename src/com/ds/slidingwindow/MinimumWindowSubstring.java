package com.ds.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem link:
 * https://leetcode.com/problems/minimum-window-substring/
 * https://www.codingninjas.com/studio/problems/minimum-window-substring_1215004
 * 
 * Solution:
 * Aditya Verma : https://www.youtube.com/watch?v=iwv1llyN6mo&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=13
 *
 *
 * */
public class MinimumWindowSubstring {
	// Given two strings s and t of lengths m and n respectively, return the minimum
	// window substring of s such that every character in t (including duplicates)
	// is included in the window. If there is no such substring, return the empty
	// string "".
	// The testcases will be generated such that the answer is unique.
	// A substring is a contiguous sequence of characters within the string.
	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	//TODO follow this approach for best solution
	private static void type3() {
		String s = "ADOBECODEBANCABN";
		String t = "ABC";
		int n1 = s.length();
		char[] arr = s.toCharArray();
		int[] freq = new int[128];
		for (char c : t.toCharArray()) freq[c]++;
		int left = 0;
		int start = 0;
		int minLen = Integer.MAX_VALUE;
		int n2 = t.length();
		char ch, itemToRemove;
		for (int right = 0; right < n1; right++) {
			ch = arr[right];
			freq[ch]--;
			if (freq[ch] >= 0) n2--;
			while (n2 == 0) {
				if (minLen > right - left + 1) {
					minLen = right - left + 1;
					start = left;
				}
				itemToRemove = arr[left++];
				freq[itemToRemove]++;
				if (freq[itemToRemove] > 0) n2++;
			}
		}
		String minWindow = minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
		System.out.println(minWindow);
	}


	private static void type2() {
		String s = "ADOBECODEBANCABN";
		String t = "ABC";
		char[] sArr = s.toCharArray();
		int n1 = sArr.length;
		char[] tArr = t.toCharArray();
		int n2 = tArr.length;
		int left = 0;
		int minLen = Integer.MAX_VALUE;
		int start = -1;
		char ch, itemToRemove;
		Map<Character, Integer> map = new HashMap<>();
		for (char c : tArr) map.put(c, map.getOrDefault(c, 0) + 1);
		for (int right = 0; right < n1; right++) {
			ch = sArr[right];
			map.put(ch, map.getOrDefault(ch, 0) - 1);
			if (map.get(ch) >= 0) n2--;
			while (n2 == 0) {
				if (minLen > right - left + 1) {
					minLen = right - left + 1;
					start = left;
				}
				itemToRemove = sArr[left++];
				map.put(itemToRemove, map.get(itemToRemove) + 1);
				if (map.get(itemToRemove) > 0) n2++;
			}
		}
		String min = minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
		System.out.println(min);
	}

	// brute force approach
	private static void type1() {
		String s = "ADOBECODEBANC";
		String t = "ABC";

	}

}
