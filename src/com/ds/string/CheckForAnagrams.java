package com.ds.string;
/*
 * Problem link :
 * https://leetcode.com/problems/valid-anagram/
 * https://www.codingninjas.com/codestudio/problems/1172164
 * https://www.codingninjas.com/studio/problems/anagram-pairs_626517
 *
 * Solution link :
 *
 *
 * https://takeuforward.org/data-structure/check-if-two-strings-are-anagrams-of-each-other/
 */

import java.util.HashMap;
import java.util.Map;

public class CheckForAnagrams {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		String s = "anagram";
		String t = "nagaram";
//		if (s.length() != t.length())  return false;
		char[] arr1 = s.toCharArray();
		char[] arr2 = t.toCharArray();
		int[] freq = new int[26];
		for (int i = 0; i < arr1.length; i++) {
			freq[arr1[i] - 'a']++;
			freq[arr2[i] - 'a']--;
		}
		boolean isAnagram = true;
		for (int count : freq) {
			if (count != 0) {
				isAnagram = false;
				break;
			}
		}
		System.out.println(isAnagram);
	}


	private static void type1() {
		String s = "anagram";
		String t = "nagaram";
		//		if (s.length() != t.length())  return false;
		char[] arr1 = s.toCharArray();
		char[] arr2 = t.toCharArray();
		Map<Character, Integer> freq = new HashMap<>();
		for (char ch : arr1) freq.put(ch, freq.getOrDefault(ch, 0) + 1);
		for (char ch : arr2) freq.put(ch, freq.getOrDefault(ch, 0) - 1);
		boolean isAnagram = true;
		for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
			if (entry.getValue() != 0) {
				isAnagram = false;
				break;
			}
		}
		System.out.println(isAnagram);
	}
}
