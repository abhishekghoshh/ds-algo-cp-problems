package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Problem link:
 * https://www.codingninjas.com/codestudio/problems/630418?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Solution:
 * Striver : https://www.youtube.com/watch?v=qtVh-XEpsJo&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=27
 * Aditya verma : https://www.youtube.com/watch?v=L6cffskouPQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=11
 * */

// tags : hash table, sliding window, array, string
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// two pointer approach
	// time complexity O(n)
	// space complexity O(n)
	// here instead of set we are taking map
	// and storing character and its latest position
	private static void type3() {
		String s = "abcabcbb";
		Map<Character, Integer> map = new HashMap<>();
		int n = s.length(), length = 0;
		char ch;
		int left = 0, right = 0;
		while (right < n) {
			ch = s.charAt(right);
			// if it's a new character then it's we are just adding it to map or
			// if the character is present but it's index is less than the start of the
			// current series
			if (!map.containsKey(ch) || map.get(ch) < left) {
				map.put(ch, right);
				length = Math.max(length, right - left + 1);
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
		System.out.println("max length is " + length);
	}

	// two pointer approach
	// time complexity O(2*n)
	// space complexity O(n)
	private static void type2() {
		String s = "abcabcbb";
		Set<Character> set = new HashSet<>();
		int n = s.length(), length = 0;
		char ch;
		int left = 0, right = 0;
		while (right < n) {
			ch = s.charAt(right);
			if (!set.contains(ch)) {
				set.add(ch);
				length = Math.max(length, right - left + 1);
				right++;
			} else {
				while (set.contains(ch)) {
					// assuming remove function takes O(1) time
					set.remove(s.charAt(left++));
				}
			}
		}
		System.out.println("max length is " + length);
	}

	// brute force approach
	// time complexity O(n^2)
	// space complexity O(n)
	private static void type1() {
		String s = "abcabcbb";
		Set<Character> set = null;
		int n = s.length(), length = 0;
		char ch;
		for (int i = 0; i < n; i++) {
			set = new HashSet<>();
			for (int j = i; j < n; j++) {
				ch = s.charAt(j);
				if (!set.contains(ch)) {
					length = Math.max(length, j - i + 1);
					set.add(ch);
				} else {
					break;
				}
			}
		}
		System.out.println("max length is " + length);
	}

}
