package recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem links:
 * https://leetcode.com/problems/palindrome-partitioning/
 * https://www.codingninjas.com/codestudio/problems/799931?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link
 * https://www.youtube.com/watch?v=WBgsABoClE0&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=52
 * 
 * */
public class PrintAllPalindromePartitioning {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// TODO check it later
	private static void type2() {
		String s = "aabcb";
		List<List<String>> list = new ArrayList<>();
		boolean[][] isp = new boolean[s.length()][s.length()];

		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (i == j)
					isp[i][j] = true;
				else if (s.charAt(i) == s.charAt(j)) {
					if (i == j - 1)
						isp[i][j] = true;
					else
						isp[i][j] = isp[i + 1][j - 1];
				}
			}
		}
		partition(s, 0, new ArrayList<>(), list, isp);
		System.out.println(list);
	}

	private static void partition(String s, int start, List<String> l, List<List<String>> list, boolean[][] isp) {
		if (start == s.length()) {
			list.add(new ArrayList<>(l));
			return;
		}

		for (int i = start; i < s.length(); i++) {
			if (isp[start][i]) {
				l.add(s.substring(start, i + 1));
				partition(s, i + 1, l, list, isp);
				l.remove(l.size() - 1);
			}
		}

	}

	private static void type1() {
		String s = "aabc";
		List<List<String>> answer = new ArrayList<>();
		List<String> bucket = new ArrayList<>();
		int start = 0, end = s.length() - 1;
		traverse(s, start, end, bucket, answer);
		System.out.println(answer);
	}

	private static void traverse(String s, int start, int end, List<String> bucket, List<List<String>> answer) {
		if (start == s.length()) {
			answer.add(new ArrayList<>(bucket));
			return;
		}
		for (int i = start; i <= end; i++) {
			// we are breaking the string into two parts such that the first part is
			// palindrome, then we are checking with the remaining string
			if (i == start || isPalindrome(s, start, i)) {
				bucket.add(s.substring(start, i + 1));
				traverse(s, i + 1, end, bucket, answer);
				bucket.remove(bucket.size() - 1);
			}
		}
	}

	private static boolean isPalindrome(String s, int left, int right) {
		while (left < right) {
			if (s.charAt(left) != s.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}

}
