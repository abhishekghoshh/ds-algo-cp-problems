# ValidParenthesis

**Topic:** `stack` | **File:** `com/problems/stack/ValidParenthesis.java`

**Tags:** Stack, String

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/valid-parentheses/description/)
- [📄 NeetCode](https://neetcode.io/problems/validate-parentheses)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/valid-parentheses_795104)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=xwjS0iZhw4I)
- [▶ YouTube](https://www.youtube.com/watch?v=wkDfsKijrZ8)
- [📄 takeUforward](https://takeuforward.org/data-structure/check-for-balanced-parentheses/)

## Approaches

Implementation:

### Implementation

Exactly like the previous, but here we are using a normal array as stack

```java
private static void type2() {
		String s = "()[]{}";
		boolean answer = isValid2(s);
		System.out.println(answer);
	}
	private static boolean isValid2(String s) {
		char[] arr = s.toCharArray();
		int n = arr.length;
		char topCh;
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
				topCh = stack[top - 1];
				if ((ch == ')' && topCh == '(')
						|| (ch == '}' && topCh == '{')
						|| (ch == ']' && topCh == '[')) {
					// popping from the stack
					top--;
				} else return false;
			}
		}
		// checking if the stack is empty or not
		return (top == 0);
	}

	private static void type1() {
		String s = "()[]{}";
		boolean answer = isValid1(s);
		System.out.println(answer);
	}

	public static boolean isValid1(String s) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			// if the character is an opening parenthesis, then we will just add it
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else {
				// at this point, the current character is a closing parenthesis
				// if stack is empty that mean there is no opening parenthesis to match this closing parenthesis
				if (stack.isEmpty()) return false;
				// for a proper closing parenthesis, there must be one opening parenthesis
				char topCh = stack.peek();
				if ((ch == ')' && topCh == '(')
						|| (ch == '}' && topCh == '{')
						|| (ch == ']' && topCh == '['))
					stack.pop();
				else
					return false;
			}
		}
		// checking if the stack is empty or not
		return stack.isEmpty();
	}

}
```
