package stack;

import java.util.Stack;

/*
 * Problem link :
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * Solution link :
 * 
 * 
 * */
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

	// TODO check later
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
			// if the character is an opening parenthesis then we will just add it
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else {
				// at this point the current character is a closing parenthesis
				if (stack.isEmpty()) {
					// if stack is empty that mean there is no opening parenthesis to match this
					// closing parenthesis
					return false;
				}
				// for a proper closing parenthesis there must be one opening parenthesis
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
