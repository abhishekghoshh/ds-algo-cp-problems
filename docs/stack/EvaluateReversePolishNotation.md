# EvaluateReversePolishNotation

**Topic:** `stack` | **File:** `com/problems/stack/EvaluateReversePolishNotation.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/evaluate-reverse-polish-notation/description/)
- [📄 NeetCode](https://neetcode.io/problems/evaluate-reverse-polish-notation)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=iu0082c4HDE)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Simple intuition if there is an operator we will pop twice and we will use the operator with the popped elements and we will push the result in the stack else we will push the element in the stack

```java
private static void type2() {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int ans = evalRPN2(tokens);
        System.out.println(ans);
    }
    public static int evalRPN2(String[] tokens) {
        int n = tokens.length;
        int[] stack = new int[n];
        int top = -1;
        for (String token : tokens) {
            if ("+".equals(token)) {
                int num1 = stack[top--], num2 = stack[top--];
                stack[++top] = num2 + num1;
            } else if ("*".equals(token)) {
                int num1 = stack[top--], num2 = stack[top--];
                stack[++top] = num2 * num1;
            } else if ("/".equals(token)) {
                int num1 = stack[top--], num2 = stack[top--];
                stack[++top] = num2 / num1;
            } else if ("-".equals(token)) {
                int num1 = stack[top--], num2 = stack[top--];
                stack[++top] = num2 - num1;
            } else {
                stack[++top] = Integer.parseInt(token);
            }
        }
        return stack[top];
    }
```

### Approach 1 — Brute Force

Simple intuition if there is an operator we will pop twice and we will use the operator with the popped elements and we will push the result in the stack else we will push the element in the stack

```java
private static void type1() {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int ans = evalRPN1(tokens);
        System.out.println(ans);
    }
    public static int evalRPN1(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                int num1 = stack.pop(), num2 = stack.pop();
                stack.push(num2 + num1);
            } else if ("*".equals(token)) {
                int num1 = stack.pop(), num2 = stack.pop();
                stack.push(num2 * num1);
            } else if ("/".equals(token)) {
                int num1 = stack.pop(), num2 = stack.pop();
                stack.push(num2 / num1);
            } else if ("-".equals(token)) {
                int num1 = stack.pop(), num2 = stack.pop();
                stack.push(num2 - num1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
```
