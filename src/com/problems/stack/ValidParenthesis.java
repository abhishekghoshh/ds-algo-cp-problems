package com.problems.stack;

import java.util.Stack;

/*
 * Problem link :
 * https://leetcode.com/problems/valid-parentheses/
 * https://www.naukri.com/code360/problems/valid-parentheses_795104
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=xwjS0iZhw4I
 * https://www.youtube.com/watch?v=wkDfsKijrZ8
 *
 * https://takeuforward.org/data-structure/check-for-balanced-parentheses/
 * */
public class ValidParenthesis {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	private static void type3() {
		String s = "()[]{}";
		boolean answer = isValid3(s);
		System.out.println(answer);
	}

	// little different approach
	// here we are saving exactly opposite closing bracket of the opening bracket
	private static boolean isValid3(String s) {
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
				if (head == 0 || stack[--head] != c) return false;
				break;
			}
		}
		return head == 0;
	}

	private static void type2() {
		String s = "()[]{}";
		boolean answer = isValid2(s);
		System.out.println(answer);
	}

	private static boolean isValid2(String s) {
		char[] arr = s.toCharArray();
		int n = arr.length;
		char peek;
		char[] stack = new char[n];
		int top = 0;
		for (char ch : arr) {
			// if the character is an opening parenthesis, then we will just add it
			if (ch == '(' || ch == '{' || ch == '[') {
				stack[top++] = ch;
			} else {
				// at this point, the current character is a closing parenthesis
				// if stack is empty that mean there is no opening parenthesis to match this closing parenthesis
				if (top == 0) return false;
				// for a proper closing parenthesis, there must be one opening parenthesis
				peek = stack[top - 1];
				if ((ch == ')' && peek == '(') || (ch == '}' && peek == '{') || (ch == ']' && peek == '['))
					top--;
				else return false;
			}
		}
		return top == 0;
	}

	private static void type1() {
		String s = "()[]{}";
		boolean answer = isValid(s);
		System.out.println(answer);
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		char[] arr = s.toCharArray();
		char top;
		for (char ch : arr) {
			// if the character is an opening parenthesis, then we will just add it
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else {
				// at this point, the current character is a closing parenthesis
				// if stack is empty that mean there is no opening parenthesis to match this closing parenthesis
				if (stack.isEmpty()) return false;
				// for a proper closing parenthesis, there must be one opening parenthesis
				top = stack.peek();
				if ((ch == ')' && top == '(') || (ch == '}' && top == '{') || (ch == ']' && top == '['))
					stack.pop();
				else return false;
			}
		}
		return stack.isEmpty();
	}

}
