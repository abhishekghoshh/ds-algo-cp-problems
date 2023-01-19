package string;
/*
 * Problem link :
 * https://leetcode.com/problems/longest-common-prefix/
 * https://www.codingninjas.com/codestudio/problems/2090383?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=0sWShKIJoo4
 * https://www.youtube.com/watch?v=VTr3Nh7BadI
 * https://www.youtube.com/watch?v=bl8ue-dTxgs
 * https://www.youtube.com/watch?v=fhyIORFDD0k
 * 
 */

public class LongestCommonPrefix {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
		type5();
	}

	// using trie method
	// not best approach
	// it will take same time but will take some extra space
	private static void type5() {
		String[] strs = { "flower", "flow", "flight" };
	}

	private static void type4() {
		String[] strs = { "flower", "flow", "flight" };
		if (strs == null || strs.length == 0) {
			return;
		}
		String pre = strs[0];
		int i = 1;
		while (i < strs.length) {
			while (strs[i].indexOf(pre) != 0)
				pre = pre.substring(0, pre.length() - 1);
			i++;
		}
		System.out.println(pre);
	}

	private static void type3() {
		String[] strs = { "flower", "flow", "flight" };
		StringBuilder prefix = new StringBuilder();
		int i = 0, j = 0;
		String s = strs[0];
		char common = '\0';
		while (j < s.length()) {
			if (i == 0) {
				common = s.charAt(j);
				i++;
			}
			char ch = s.charAt(j);
			if (ch != common) {
				break;
			} else if (i == strs.length) {
				prefix.append(common);
				s = strs[0];
				i = 0;
				j++;
			} else {
				s = strs[i++];
			}
		}
		System.out.println(prefix);
	}

	private static void type2() {
		String[] strs = { "flower", "flow", "flight" };
		StringBuilder sb = new StringBuilder();
		int minLength = Integer.MAX_VALUE;
		String commonPrefix = null;
		for (int i = 0; i < strs.length; i++) {
			minLength = Math.min(minLength, strs[i].length());
		}
		for (int i = 0; i < minLength; i++) {
			char c = strs[0].charAt(i);
			for (int j = 0; j < strs.length; j++) {
				if (strs[j].charAt(i) != c) {
					commonPrefix = sb.toString();
				}
			}
			if (null != commonPrefix) {
				break;
			} else {
				sb.append(c);
			}
		}
		System.out.println(commonPrefix);
	}

	private static void type1() {
		String[] strs = { "flower", "flow", "flight" };
		char ch;
		String commonPrefix = null;
		String pivot = strs[0];
		int n = pivot.length();
		for (int index = 0; index <= n; index++) {
			if (index < n) {
				ch = pivot.charAt(index);
			} else {
				commonPrefix = pivot;
				break;
			}
			for (int i = 1; i < strs.length; i++) {
				if (index == strs[i].length() || ch != strs[i].charAt(index)) {
					commonPrefix = pivot.substring(0, index);
					break;
				}
			}
			if (null != commonPrefix) {
				break;
			}
		}
		System.out.println(commonPrefix);
	}

}
