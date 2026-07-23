# InfixToPostfix

**Topic:** `stack`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/day-23-:-infix-to-postfix-_1382146)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=m7SGekhd1mQ)
- [📄 takeUforward](https://takeuforward.org/data-structure/infix-to-postfix/)

## 📝 Problem Statement

Convert an infix arithmetic expression to postfix notation using stack.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

same as previous, but here we will use an array as stack do not use array if asked in interview initializing empty String for a result

```java
    private static void type2() {
        String exp = "(p+q)*(m-n)";
        char[] arr = exp.toCharArray();
        int n = arr.length;
        // initializing empty String for a result
        StringBuilder result = new StringBuilder();

        int top = 0;
        char[] stack = new char[n];
        for (char ch : arr) {
            if (Character.isLetterOrDigit(ch))
                result.append(ch);
            else if (ch == '(')
                stack[top++] = ch;
            else if (ch == ')') {
                while (top > 0 && stack[top - 1] != '(')
                    result.append(stack[--top]);
                top--;
            } else {
                while (top > 0 && precedence(ch) <= precedence(stack[top - 1]))
                    result.append(stack[--top]);
                stack[top++] = ch;
            }
        }
        while (top > 0) {
            result.append(stack[top - 1]);
            top--;
        }
        System.out.println(result);
    }
```

### Approach 1: 🔨 Brute Force

we will push all the operands into stack in increasing precedence if there is any lower or same precedence then we will pop If the scanned character is an operand, add it to output. If the scanned character is an '(', push it to the stack. If the scanned character is an ')', pop and output from the stack until an '(' is encountered.

an operator is encountered

```java
    private static void type1() {
        String exp = "(p+q)*(m-n)";

        char[] arr = exp.toCharArray();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char ch : arr) {
            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(ch))
                result.append(ch);
                // If the scanned character is an '(',
                // push it to the stack.
            else if (ch == '(')
                stack.push(ch);
                // If the scanned character is an ')',
                // pop and output from the stack
                // until an '(' is encountered.
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result.append(stack.pop());
                stack.pop();
            } else {
                // an operator is encountered
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek()))
                    result.append(stack.pop());
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) result.append(stack.pop());
        System.out.println(result);
    }

    static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        else if (ch == '*' || ch == '/') return 2;
        else if (ch == '^') return 3;
        return -1;
    }
}
```
