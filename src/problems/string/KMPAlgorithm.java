package problems.string;

/*
 * Problem link :
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * https://www.codingninjas.com/codestudio/problems/1112621?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link :
 * 
 * 
 */
public class KMPAlgorithm {

	// 28. Find the Index of the First Occurrence in a String
	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		String haystack = "sadbutsad";
		String needle = "sad";
	}

	private static void type1() {
		String str = "sadbutsad";
		String ptrn = "sad";
		int answer = -1;
		char[] s1 = str.toCharArray();
		char[] s2 = ptrn.toCharArray();
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
					answer = i - s2.length + 1;
					break;
				}
				i++;
				j++;
			} else if (j > 0) {
				j = pattern[j - 1] + 1;
			} else {
				i++;
			}
		}
		System.out.println(answer);
	}

}
