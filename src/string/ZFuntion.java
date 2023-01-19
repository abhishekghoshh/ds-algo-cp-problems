package string;

import java.util.Arrays;

/*
 * Problem link :
 * https://www.codingninjas.com/codestudio/problems/1112619?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=QlwzsWs0oyc -> pepcoding
 * 
 */
public class ZFuntion {

	// TODO study later
	public static void main(String[] args) {
		type1();
		type2();
	}

	// Z array
	private static void type2() {
		String str = "aaxaabcaaaaxaabcaa";
		char[] st = str.toCharArray();
		int[] lps = new int[st.length];
		int i = 1, j = 0;
		while (i < st.length) {
			if (st[i] == st[j]) {
				lps[i] = j + 1;
				i++;
				j++;
			} else if (j > 0) {
				j = lps[j - 1];
			} else {
				i++;
			}
		}
		print(lps);
	}

	// kmp algorithm
	private static void type1() {
		String str = "aaxaabcaaaaxaabcaa";
		String ptrn = "aabcaa";

		char[] st = (ptrn + "&" + str).toCharArray();
		int[] lps = new int[st.length];

		int i = 1, j = 0;
		while (i < st.length) {
			if (st[i] == st[j]) {
				lps[i] = j + 1;
				i++;
				j++;
			} else if (j > 0) {
				j = lps[j - 1];
			} else {
				i++;
			}
		}
		int[] zArray = Arrays.copyOfRange(lps, ptrn.length() + 1, lps.length);
		print(zArray);
	}

	private static void print(int[] nums) {
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

}
