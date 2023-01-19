package string;

/*
 * Problem link :
 * https://leetcode.com/problems/string-to-integer-atoi/
 * https://www.codingninjas.com/codestudio/problems/981270?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=FyTpsuWAoc8
 * https://www.youtube.com/watch?v=gLW6DD59ZaM
 * 
 */
public class StringToInteger {

	// TODO revisit this problem
	// check the solutions
	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	private static void type3() {
		String s = "-91283472332";
		int num = atoi2(s);
		System.out.println(num);
	}

	private static int atoi2(String s) {
		int i = 0;
		int sign = 1;
		int result = 0;
		// 0. Check invalid string
		if (s.length() == 0)
			return 0;
		// 1. Read in and ignore any leading whitespace
		while (i < s.length() && s.charAt(i) == ' ')
			++i;
		// 2. Check the sign
		if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
			sign = s.charAt(i) == '-' ? -1 : 1;
			i++;
		}
		// 3. Convert to integer and avoid overflow
		while (i < s.length()) {
			int digit = s.charAt(i) - '0';
			if (digit >= 0 && digit <= 9) {
				if (Integer.MAX_VALUE / 10 < result
						|| (Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < digit)) {
					return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}
				result = result * 10 + digit;
				++i;
			} else {
				break;
			}
		}
		return result * sign;
	}

	private static void type2() {
		String s = "-91283472332";
		int num = atoi(s);
		System.out.println(num);
	}

	private static int atoi(String s) {
		if (null == s)
			return 0;
		s = s.trim();
		if (s == "")
			return 0;
		int start = 0, sign = 1;
		long sum = 0;
		char firstC = s.charAt(start);
		if (firstC == '+') {
			start++;
		} else if (firstC == '-') {
			sign = -1;
			start++;
		}
		for (int i = start; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) {
				return (int) sum * sign;
			}
			sum = sum * 10 + s.charAt(i) - '0';
			if (sign == 1 && sum > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			if (sign == -1 && (-1) * sum < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
		}
		return (int) sum * sign;
	}

	private static void type1() {
		String s = "-91283472332";
		char[] arr = s.toCharArray();
		int n = arr.length;
		int sign = 1, i = 0;
		long answer = 0;
		boolean isNumStarted = false;
		while (i < n) {
			char ch = arr[i++];
			if (isNumStarted || (!isNumStarted && isNumber(ch))) {
				isNumStarted = true;
				if (isNumber(ch)) {
					answer = answer * 10 + (ch - '0');
					if (answer * sign > Integer.MAX_VALUE) {
						answer = Integer.MAX_VALUE;
						break;
					}
					if (answer * sign < Integer.MIN_VALUE) {
						answer = Integer.MIN_VALUE;
						break;
					}
				} else {
					break;
				}
			} else if (ch == '-' || ch == '+') {
				sign = ch == '-' ? -1 : 1;
				isNumStarted = true;
			} else if (ch != ' ') {
				break;
			}
		}
		answer = sign * answer;
		System.out.println(answer);
	}

	private static boolean isNumber(char ch) {
		int diff = ch - '0';
		return diff >= 0 && diff <= 9;
	}

}
