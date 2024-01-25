package com.ds.string;

/*
 * Problem link :
 * https://leetcode.com/problems/string-to-integer-atoi/
 * https://www.codingninjas.com/codestudio/problems/981270
 * https://www.codingninjas.com/studio/problems/implement-atoi-function_981270
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=FyTpsuWAoc8
 * https://www.youtube.com/watch?v=gLW6DD59ZaM
 * 
 */
public class StringToInteger {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// TODO check it in the google and leetcode if it is even possible
	private static void type3() {
		String s = "-2147483647";
		int num = atoi3(s);
		System.out.println(num);
	}

	// recursive implementation of atoi function
	private static int atoi3(String s) {
		return 0;
	}


	// TODO explain this in the interview
	private static void type2() {
		String s = "-91283472332";
		int num = atoi2(s);
		System.out.println(num);
	}

	// optimized approach
	private static int atoi2(String s) {
		int n = s.length();
		// 0. Check invalid string
		if (n == 0) return 0;
		char[] arr = s.toCharArray();
		int i = 0;
		int sign = 1;
		int result = 0;
		// 1. Read in and ignore any leading whitespace
		while (i < n && arr[i] == ' ') i++;
		// 2. Check the sign
		if (i < n && (arr[i] == '-' || arr[i] == '+'))
			sign = arr[i++] == '-' ? -1 : 1;
		// 3. Convert to integer and avoid overflow
		while (i < n) {
			int digit = arr[i++] - '0';
			// if the char is not digit then we will break
			if (digit < 0 || digit > 9) break;
			// checking that if by adding this char we are exceeding INT MAX value or not
			if (Integer.MAX_VALUE / 10 < result || (Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < digit))
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			result = result * 10 + digit;
		}
		return result * sign;
	}

	private static void type1() {
		String s = "42";
		int num = atoi(s);
		System.out.println(num);
	}

	private static int atoi(String s) {
		s = s.trim();
		int n = s.length();
		// 0. Check invalid string
		if (n == 0) return 0;
		char[] arr = s.toCharArray();
		int i = 0, sign = 1;
		long sum = 0;
		if (arr[i] == '+' || arr[i] == '-')
			sign = arr[i++] == '-' ? -1 : 1;
		while (i < n) {
			int digit = arr[i++] - '0';
			if (digit < 0 || digit > 9) break;
			sum = sum * 10 + digit;
			if (sign == 1 && sum > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		}
		return (int) sum * sign;
	}

}
