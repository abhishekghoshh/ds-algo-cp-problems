# PostfixToPrefix

**Topic:** `stack`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/postfix-to-prefix_1788455)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=smQ88h1qzQY)

## 📝 Problem Statement

Code 360 by Coding Ninjas

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

```java
    private static void type1() {
        String exp = "ab+cd-*";
        char[] arr = exp.toCharArray();
        Stack<String> stack = new Stack<>();
        String first, second, res;
        for (char ch : arr) {
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                second = stack.pop();
                first = stack.pop();
                res = ch + first + second;
                stack.push(res);
            } else stack.push("" + ch);
        }
        System.out.println(stack.peek());
    }

}
```
