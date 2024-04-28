package com.problems.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Problem link : 
 * https://leetcode.com/problems/reverse-words-in-a-string
 * https://www.codingninjas.com/codestudio/problems/696444
 * https://www.codingninjas.com/studio/problems/reverse-words-in-a-string_696444
 * 
 * Solution link:
 * 
 * 
 * https://takeuforward.org/data-structure/reverse-words-in-a-string/
 * 
 * */
public class ReverseWordsInString {

	public static void main(String[] args) {
		// TODO study all the approaches
		type0();
		type1();
		type2();
		type3();
		type4();
		type5();
		type6();
	}

	// most optimized approach
	private static void type6() {
		String s = "a good   example";
		char[] arr = s.toCharArray();
		int n = arr.length;
		char[] result = new char[n];
		int outPos = 0;
		// we will be looping through from last to first
		for (int i = n - 1; i >= 0; i--) {
			// skip all the trailing whitespaces first
			while (i >= 0 && arr[i] == ' ') i--;
			// if i<0 means there is no character found
			if (i < 0) break;
			// now we have found the end of the word
			int endOfWord = i;
			// we will find the start of the word
			while (i > 0 && arr[i - 1] != ' ') i--;
			// now we will add the space after the previous word
			if (outPos > 0) result[outPos++] = ' ';
			// now we will copy word by word
			for (int j = i; j <= endOfWord; j++)
				result[outPos++] = arr[j];
		}
		String answer = String.valueOf(result, 0, outPos);
		System.out.println(answer);
	}

	public static void type5() {
		String s = "a good   example";
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				if (sb.length() > 0)
					sb.append(' ');
				int j = i;
				while (i >= 0 && s.charAt(i) != ' ') {
					i--;
				}
				i++;
				sb.append(s.substring(i, j + 1));
			}
		}
		String answer = sb.toString();
		System.out.println(answer);
	}

	public static void type4() {
		String s = "a good   example";
		int n = s.length();
		StringBuilder ans = new StringBuilder("");
		StringBuilder temp = new StringBuilder("");
		for (int i = n - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			if (ch != ' ')
				temp.append(ch);
			if ((ch == ' ' || i == 0) && temp.length() > 0) {
				if (ans.length() > 0)
					ans.append(" ");
				temp.reverse();
				ans.append(temp);
				temp.setLength(0);
			}
		}
		String answer = ans.toString();
		System.out.println(answer);
	}

	public static void type3() {
		String s = "a good   example";
		Stack<String> st = new Stack<String>();
		for (String a : s.trim().split(" ")) {
			if (!a.isEmpty())
				st.push(a);
		}
		StringBuilder sb = new StringBuilder();
		while (!st.isEmpty()) {
			sb.append(st.pop());
			sb.append(" ");
		}
		String answer = sb.toString().trim();
		System.out.println(answer);
	}

	public static void type2() {
		String s = "a good   example";
		s = s.trim();
		String str[] = s.split("\\s+");
		StringBuilder res = new StringBuilder();
		for (int i = str.length - 1; i >= 0; i--) {
			res.append(str[i]);
			if (i != 0) {
				res.append(" ");
			}
		}
		String answer = res.toString();
		System.out.println(answer);
	}

	@Deprecated
	private static void type1() {
		String s = "a good   example";
		if (null == s || s.length() == 1)
			return;
		List<Point> points = new ArrayList<>();
		boolean wordStarted = false;
		int letterCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				letterCount++;
				if (!wordStarted) {
					wordStarted = true;
					points.add(new Point(i, i));
				} else {
					points.get(points.size() - 1).end = i;
				}
			} else {
				wordStarted = false;
			}
		}
		if (points.size() == 0)
			return;
		// System.out.println(points);
		char[] arr = new char[letterCount + points.size() - 1];
		int index = 0;
		Point point = null;
		for (int i = points.size() - 1; i >= 0; i--) {
			point = points.get(i);
			for (int j = point.start; j <= point.end; j++) {
				arr[index++] = s.charAt(j);
			}
			if (i != 0) {
				arr[index++] = ' ';
			}
		}
		s = new String(arr);
		System.out.println(s);
	}

	private static class Point {
		public int start;
		public int end;

		public Point(int x, int y) {
			this.start = x;
			this.end = y;
		}
	}

	@Deprecated
	private static void type0() {
		String s = "a good   example";
		int left = 0, right = 0;
		s = s.trim();
		StringBuilder str = new StringBuilder();
		while (right <= s.length()) {
			if (right == s.length() || s.charAt(right) == ' ') {
				str = new StringBuilder(s.substring(left, right)).append(" ").append(str);
				while (right < s.length() && s.charAt(right + 1) == ' ') {
					right++;
				}
				left = right + 1;
			}
			right++;
		}
		str.deleteCharAt(str.length() - 1);
		System.out.println(str.toString());
	}

}
