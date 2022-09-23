package problems.slidingwindow;

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

	public static void main(String[] args) {
		type1();
		type2();
		type3();
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

	private static void type1() {
		String s = "ADOBECODEBANC";
		String t = "ABC";

	}

}
