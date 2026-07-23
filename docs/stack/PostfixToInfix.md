# PostfixToInfix

**Topic:** `stack`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/prefix-to-infix_1215000)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=m7SGekhd1mQ)
- [📄 takeUforward](https://takeuforward.org/data-structure/infix-to-postfix/)

## 📝 Problem Statement

Convert a postfix expression to infix notation.

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

we will go from start, whenever we encounter any operand we will push it to stack if there is any operand then we pop from the stack twice, and we will do the operation, and again we put it to the stack at last we pop the value from the stack and print it

```java
    private static void type1() {
        String postfix = "ab+c+";
        char[] arr = postfix.toCharArray();
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder first, second, res;
        for (char ch : arr) {
            if (Character.isLetterOrDigit(ch)) {
                stack.push(new StringBuilder().append(ch));
            } else {
                second = stack.pop();
                first = stack.pop();
                res = new StringBuilder()
                        .append('(')
                        .append(first)
                        .append(ch)
                        .append(second)
                        .append(')');
                stack.push(res);
            }
        }
        StringBuilder answer = stack.pop();
        System.out.println(answer);
    }
}
```
