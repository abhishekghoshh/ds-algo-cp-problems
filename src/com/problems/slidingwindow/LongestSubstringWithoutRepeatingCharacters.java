package com.problems.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Problem link:
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * https://www.naukri.com/code360/problems/630418
 *
 *
 * Solution link:
 * https://www.youtube.com/watch?v=-zSxTJkcdAo
 * Striver : https://www.youtube.com/watch?v=qtVh-XEpsJo&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=27
 * Aditya verma : https://www.youtube.com/watch?v=L6cffskouPQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=11
 *
 * https://takeuforward.org/data-structure/length-of-longest-substring-without-any-repeating-character/
 * */

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
		type5();
	}

	// previous approach uses a boolean array for checking if the character exists or not
	// but we can also use an integer as a set/ boolean array,
	// it has 32 bits, and we can use the bits and the bit position as a set
	// if the bit is 1 then the index is set if 0 then it is empty
	// todo complete it
	private static void type5() {

	}

	// best possible solution
	private static void type4() {
		String s = "abcabcbb";
		int n = s.length();
		boolean[] set = new boolean[128];
		char[] arr = s.toCharArray();
		int left = 0;
		int max = 0;
		for (int right = 0; right < n; right++) {
			while (set[arr[right]]) set[arr[left++]] = false;
			set[arr[right]] = true;
			max = Math.max(max, right - left + 1);
		}
		System.out.println("max length is " + max);
	}


	// two pointer approach
	// time complexity O(n)
	// space complexity O(n)
	// here instead of set we are taking map
	// and storing character and its latest position
	// we can also use an int array for storing indices
	// but, then we have to initialize that array with -1
	private static void type3() {
		String s = "abcabcbb";
		int n = s.length();
		Map<Character, Integer> map = new HashMap<>();
		int max = 0;
		char ch;
		int left = 0, right = 0;
		while (right < n) {
			ch = s.charAt(right);
			// if it's a new character then it's we are just adding it to map or
			// if the character is present, but its index is less than the start of the
			// current series
			if (!map.containsKey(ch) || map.get(ch) < left) {
				map.put(ch, right);
				max = Math.max(max, right - left + 1);
				right++;
			} else {
				// when we encounter any duplicate character then
				// we again start the series from that character index + 1
				// suppose series is "cabdac", index of a is 1 and 4
				// when we again found a it 4 then we start the series at 2
				// then on next iteration in map we will found c = 0 but it's less than left
				// so it will treat c as a new character and update it's index
				left = map.get(ch) + 1;
			}
		}
		System.out.println("max length is " + max);
	}

	// two pointer approach
	// time complexity O(2*n)
	// space complexity O(n)
	private static void type2() {
		String s = "abcabcbb";
		int n = s.length();
		char[] arr = s.toCharArray();
		Set<Character> set = new HashSet<>();
		int max = 0;
		char ch;
		int left = 0, right = 0;
		while (right < n) {
			ch = arr[right];
			if (!set.contains(ch)) {
				set.add(ch);
				max = Math.max(max, right - left + 1);
				right++;
			} else {
				// assuming remove function takes O(1) time
				while (set.contains(ch))
					set.remove(arr[left++]);
			}
		}
		System.out.println("max length is " + max);
	}

	// brute force approach
	// time complexity O(n^2)
	// space complexity O(n)
	private static void type1() {
		String s = "abcabcbb";
		int n = s.length();
		char[] arr = s.toCharArray();
		Set<Character> set;
		int max = 0;
		char ch;
		for (int i = 0; i < n; i++) {
			set = new HashSet<>();
			for (int j = i; j < n; j++) {
				ch = arr[j];
				if (set.contains(ch)) break;
				max = Math.max(max, j - i + 1);
				set.add(ch);
			}
		}
		System.out.println("max length is " + max);
	}

}
