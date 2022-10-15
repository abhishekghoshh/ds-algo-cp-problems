package problems.stack;

import java.util.Stack;

public class CheckForBalancedParenthesis {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		String s = "()[]{}";
		boolean answer = isValid2(s);
		System.out.println(answer);
	}

	private static boolean isValid2(String s) {
		char[] stack = new char[s.length()];
		int head = 0;
		for (char c : s.toCharArray()) {
			switch (c) {
			case '(':
				stack[head++] = ')';
				break;
			case '{':
				stack[head++] = '}';
				break;
			case '[':
				stack[head++] = ']';
				break;
			default:
				if (head == 0 || stack[--head] != c)
					return false;
				break;
			}
		}
		return head == 0;
	}

	private static void type1() {
		String s = "()[]{}";
		boolean answer = isValid(s);
		System.out.println(answer);
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else {
				if (stack.size() == 0) {
					return false;
				}
				if ((ch == ')' && stack.peek() == '(') || (ch == '}' && stack.peek() == '{')
						|| (ch == ']' && stack.peek() == '[')) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

}
