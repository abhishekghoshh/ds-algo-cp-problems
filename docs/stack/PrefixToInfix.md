# PrefixToInfix

**Topic:** `stack`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/prefix-to-infix_1215000)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=MuF5p8-oWc8)

## 📝 Problem Statement

Convert a prefix expression to infix notation.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

```java
    private static void type2() {
        String exp = "/-ab+-cde";
        char[] arr = exp.toCharArray();
        int n = arr.length;
        Stack<String> stack = new Stack<>();
        char ch;
        String first, second, res;
        for (int i = n - 1; i >= 0; i--) {
            ch = arr[i];
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                first = stack.pop();
                second = stack.pop();
                res = "(" + first + ch + second + ")";
                stack.push(res);
            } else stack.push(ch + "");
        }
        String answer = stack.peek();
        System.out.println(answer);
    }
```

### Approach 1: 🔨 Brute Force

same as postfix to infix operation just here we will go from back

```java
    private static void type1() {
        String exp = "/-ab+-cde";
        char[] arr = exp.toCharArray();
        int n = arr.length;
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder first, second, res;
        char ch;
        for (int i = n - 1; i >= 0; i--) {
            ch = arr[i];
            if (Character.isLetterOrDigit(ch)) stack.push(new StringBuilder().append(ch));
            else {
                first = stack.pop();
                second = stack.pop();
                res = new StringBuilder()
                        .append('(')
                        .append(first)
                        .append(ch)
                        .append(second)
                        .append(')');
                stack.push(res);
            }
        }
        String answer = stack.pop().toString();
        System.out.println(answer);
    }
}
```
