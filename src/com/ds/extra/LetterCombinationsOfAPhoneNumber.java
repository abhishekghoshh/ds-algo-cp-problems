package com.ds.extra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * Problem link : 
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number
 * 
 * Solution is :
 * https://www.youtube.com/watch?v=0snEunUacZY
 * 
 * */
public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// This is using proper backtracking
	// also the key pad values are stored in 2D char array
	// so, we don't have to make a char array everytime from the string "abc" or "wxyz"
	// we are just creating a String builder and each time we are adding one character and after using that we are just removing that
	private static void type2() {
		String digits = "23";
		List<String> list = new ArrayList<>();
		letterCombinations(list, new StringBuilder(), 0, digits.toCharArray());
		System.out.println(list);
	}

	private static final char[][] keypadValues = {
			{}, {},
			{'a', 'b', 'c'},
			{'d', 'e', 'f'},
			{'g', 'h', 'i'},
			{'j', 'k', 'l'},
			{'m', 'n', 'o'},
			{'p', 'q', 'r', 's'},
			{'t', 'u', 'v'},
			{'w', 'x', 'y', 'z'}
	};

	public static void letterCombinations(List<String> list, StringBuilder sb, int index, char[] digits) {
		if (sb.length() == digits.length) {
			list.add(sb.toString());
			return;
		}
		char[] values = keypadValues[digits[index] - '0'];
		for (char c : values) {
			sb.append(c);
			letterCombinations(list, sb, index + 1, digits);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	// This problem is also using backtracking
	// but this is using extra space
	// also rather than using hashmap of Integer and String or List of Char
	// we can directly use a normal 2D array where of keypad values like {{},{},{a,b,c},{..})
	// 0 and 1 can be kept empty
	// so, we can directly get values[2]
	// otherwise we have to add +2 to index if start from {{a,b,c},{...}}
	private static void type1() {
		String digits = "23";
		List<String> answer = letterCombinations(0, digits.toCharArray());
		System.out.println(answer);
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
		StringBuilder sb = new StringBuilder();
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
