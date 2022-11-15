package problems.string;
/*
 * Problem link :
 * https://leetcode.com/problems/valid-anagram/
 * https://www.codingninjas.com/codestudio/problems/1172164?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link :
 * 
 * 
 */

public class CountForAnagrams {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		String s = "anagram";
		String t = "nagaram";
		if (s.length() != t.length()) {
			System.out.println(false);
			return;
		}
		char[] arr1 = s.toCharArray();
		char[] arr2 = t.toCharArray();
		int[] freq = new int[26];
		for (int i = 0; i < arr1.length; i++) {
			freq[arr1[i] - 'a']++;
			freq[arr2[i] - 'a']--;
		}
		boolean isAnagram = true;
		for (int i = 0; i < 26; i++) {
			if (freq[i] != 0) {
				break;
			}
		}
		System.out.println(isAnagram);
	}

	private static void type1() {
		String s = "anagram";
		String t = "nagaram";
		if (s.length() != t.length()) {
			System.out.println(false);
			return;
		}
		int n = s.length();
		int[] freq = new int[26];
		for (int i = 0; i < n; i++) {
			freq[s.charAt(i) - 'a']++;
			freq[t.charAt(i) - 'a']--;
		}
		boolean isAnagram = true;
		for (int i = 0; i < 26; i++) {
			if (freq[i] != 0) {
				break;
			}
		}
		System.out.println(isAnagram);
	}

}
