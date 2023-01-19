package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem link:
 * https://leetcode.com/problems/minimum-window-substring/
 * 
 * Solution:
 * https://www.youtube.com/watch?v=iwv1llyN6mo&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=13
 * */
public class MinimumWindowSubstring {
	// Given two strings s and t of lengths m and n respectively, return the minimum
	// window substring of s such that every character in t (including duplicates)
	// is included in the window. If there is no such substring, return the empty
	// string "".
	// The testcases will be generated such that the answer is unique.
	// A substring is a contiguous sequence of characters within the string.
	// TODO check later https://leetcode.com/submissions/detail/829698608/
	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
		type5();
	}

	private static void type5() {
		String s = "ADOBECODEBANCABN";
		String t = "ABC";
		int[] map = new int[128];
		for (char c : t.toCharArray()) {
			map[c]++;
		}
		int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
		while (end < s.length()) {
			final char c1 = s.charAt(end);
			if (map[c1] > 0)
				counter--;
			map[c1]--;
			end++;
			while (counter == 0) {
				if (minLen > end - start) {
					minLen = end - start;
					minStart = start;
				}
				final char c2 = s.charAt(start);
				map[c2]++;
				if (map[c2] > 0)
					counter++;
				start++;
			}
		}

		String minWindow = minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
		System.out.println(minWindow);
	}

	// TODO check later
	private static void type4() {
		String s = "ADOBECODEBANCABN";
		String t = "ABC";
		int[] map = new int[127];
		for (char c : t.toCharArray()) {
			++map[c];
		}
		int count = t.length();
		char[] sc = s.toCharArray();
		int resLen = Integer.MAX_VALUE;
		int resIndex = 0;
		int start = 0;
		for (int i = 0; i < sc.length; ++i) {
			count -= (--map[sc[i]] >>> 31) ^ 1;
			if (count == 0) {
				while (true) {
					var c = sc[start++];
					if (++map[c] > 0)
						break;
				}
				++count;
				int len = i - start + 2;
				if (len < resLen) {
					resLen = len;
					resIndex = start - 1;
				}
			}
		}
		String minWindow = s.substring(resIndex, resIndex + resLen);
		System.out.println(minWindow);
	}

	// TODO study later
	private static void type3() {
		String s = "ADOBECODEBANCABN";
		String t = "ABC";
//		String s = "cabwefgewcwaefgcf";
//		String t = "cae";
		int tlen = t.length();
		int slen = s.length();
		if (slen == 0 || tlen == 0 || slen < tlen) {
			return;
		}

		int[] matches = new int['z' + 1];
		for (int i = 0; i < tlen; ++i) {
			matches[t.charAt(i)]++;
		}
		int count = tlen;
		int left = 0, right = 0;
		int minLeft = 0, minRight = 0;
		while (right < slen) {
			char currentChar = s.charAt(right);
			if (matches[currentChar] > 0) {
				--count;
			}
			matches[currentChar]--;
			++right;
			while (count == 0) {
				if (minRight == 0 || minRight - minLeft > right - left) {
					minRight = right;
					minLeft = left;
				}
				char frontChar = s.charAt(left);
				if (++matches[frontChar] > 0) {
					++count;
				}
				++left;
			}
		}

		System.out.println(s.substring(minLeft, minRight));

	}

	private static void type2() {
		String s = "ADOBECODEBANCABN";
		String t = "ABC";
//		String s = "cabwefgewcwaefgcf";
//		String t = "cae";
		int left = 0, right = 0, n = s.length();
		char ch;
		String minString = "";
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			ch = t.charAt(i);
			if (!map.containsKey(ch)) {
				map.put(ch, 1);
			} else {
				map.put(ch, map.get(ch) + 1);
			}
		}
		int letterCount = map.keySet().size();
		while (right <= n) {
			if (letterCount > 0) {
				if (right == n)
					break;
				char rch = s.charAt(right++);
				if (map.containsKey(rch)) {
					map.put(rch, map.get(rch) - 1);
					if (map.get(rch) == 0) {
						letterCount--;
					}
				}
			} else {
				minString = minString.isEmpty() || minString.length() > (right - left) ? s.substring(left, right)
						: minString;
				while (left < n && letterCount == 0) {
					char lch = s.charAt(left++);
					if (map.containsKey(lch)) {
						if (map.get(lch) == 0) {
							letterCount++;
						}
						map.put(lch, map.get(lch) + 1);
					}
				}
				minString = minString.isEmpty() || minString.length() > (right - (left - 1))
						? s.substring(left - 1, right)
						: minString;
			}
		}
		System.out.println(minString);
	}

	// brute force approach
	private static void type1() {
		String s = "ADOBECODEBANC";
		String t = "ABC";

	}

}
