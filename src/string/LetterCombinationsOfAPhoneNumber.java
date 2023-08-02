package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * Problem link : 
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number
 * 
 * Solution is :
 * 
 * */
public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		System.out.println(letterCombinations2("23"));
	}

	public static List<String> letterCombinations2(String digits) {
		if (digits == null || digits.length() == 0)
			return new ArrayList<>();
		List<String> list = new ArrayList<>();
		backtrack(list, new StringBuilder(), 0, digits);
		return list;

	}

	private static final String[] mapp = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static void backtrack(List<String> list, StringBuilder tempstring, int index, String digits) {
		if (tempstring.length() == digits.length()) {
			list.add(tempstring.toString());
			return;
		}

		String present1 = mapp[digits.charAt(index) - '0'];
		for (char c : present1.toCharArray()) {
			tempstring.append(c);
			backtrack(list, tempstring, index + 1, digits);
			tempstring.deleteCharAt(tempstring.length() - 1);
		}
	}

	private static void type1() {
		System.out.println(letterCombinations1("23"));
	}

	public static List<String> letterCombinations1(String digits) {
		if (digits.isEmpty()) {
			return new ArrayList<>();
		}
		return letterCombinations(0, digits.toCharArray());
	}

	private static final Map<Integer, List<Character>> keys = new HashMap<>();
	static {
		keys.put(2, List.of('a', 'b', 'c'));
		keys.put(3, List.of('d', 'e', 'f'));
		keys.put(4, List.of('g', 'h', 'i'));
		keys.put(5, List.of('j', 'k', 'l'));
		keys.put(6, List.of('m', 'n', 'o'));
		keys.put(7, List.of('p', 'q', 'r', 's'));
		keys.put(8, List.of('t', 'u', 'v'));
		keys.put(9, List.of('w', 'x', 'y', 'z'));
	}

	public static List<String> letterCombinations(int i, char[] digits) {
		List<Character> chars = keys.get(digits[i] - '0');
		List<String> answer = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		if (i == digits.length - 1) {
			for (char ch : chars) {
				sb.append(ch);
				answer.add(sb.toString());
				sb.deleteCharAt(sb.length() - 1);
			}
		} else {
			List<String> remainings = letterCombinations(i + 1, digits);
			for (char ch : chars) {
				sb.append(ch);
				for (String remaining : remainings) {
					sb.append(remaining);
					answer.add(sb.toString());
					sb.delete(sb.length() - remaining.length(), sb.length());
				}
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		return answer;
	}

}
