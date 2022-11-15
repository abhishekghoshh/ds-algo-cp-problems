package problems.string;
/*
 * Problem link :
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 * 
 * Solution link :
 * 
 * 
 */

public class FindTheIndexOfFirstOccuranceInAString {

	public static void main(String[] args) {
		type1();
		tyoe2();
	}

	// with kmp algorithm
	private static void tyoe2() {
		String haystack = "sadbutsad", needle = "sad";
		char[] s1 = haystack.toCharArray();
		char[] s2 = needle.toCharArray();
		int[] pattern = new int[s2.length];
		int i, j;
		for (i = 0; i < pattern.length; i++) {
			pattern[i] = -1;
		}
		i = 1;
		j = 0;
		while (i < s2.length) {
			if (s2[i] == s2[j]) {
				pattern[i] = j;
				i++;
				j++;
			} else if (j > 0) {
				j = pattern[j - 1] + 1;
			} else {
				i++;
			}
		}
		print(pattern);
		i = 0;
		j = 0;
		while (i < s1.length) {
			if (s1[i] == s2[j]) {
				if (j == s2.length - 1) {
					System.out.println((i - s2.length + 1));
					return;
				}
				i++;
				j++;
			} else if (j > 0) {
				j = pattern[j - 1] + 1;
			} else {
				i++;
			}
		}

	}

	private static void print(int[] nums) {
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	// brute force
	private static void type1() {

	}

}
