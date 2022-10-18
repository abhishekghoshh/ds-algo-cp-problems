package problems.string;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem link : 
 * https://leetcode.com/problems/reverse-words-in-a-string
 * 
 * Solution link:
 * 
 * */
public class ReverseWordsInString {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
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

	private static void type1() {
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
