package problems.string;
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
