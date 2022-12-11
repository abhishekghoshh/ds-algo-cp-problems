package problems.string;

/*
 * Problem link :
 * https://www.codingninjas.com/codestudio/problems/1112619?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * 
 * Solution link :
 * 
 * 
 */
public class ZFuntion {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {

	}

	// kmp algorithm
	private static void type1() {
		String haystack = "sadbutsad", needle = "sad";
		int count = 0;
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
		i = 0;
		j = 0;
		while (i < s1.length) {
			if (s1[i] == s2[j]) {
				if (j == s2.length - 1) {
					count++;
					// return i - s2.length + 1 ;
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

}
