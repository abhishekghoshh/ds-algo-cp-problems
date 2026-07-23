# PrefixToPostfix

**Topic:** `stack`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/convert-prefix-to-postfix_8391014)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=jZxII0guwUo)

## 📝 Problem Statement

Code 360 by Coding Ninjas

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

```java
    private static void type1() {
        String s = "-/A+BC*DE";
        char[] arr = s.toCharArray();
        reverse(arr);
        Stack<String> stack = new Stack<>();
        String first, second, res;
        for (char ch : arr) {
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                first = stack.pop();
                second = stack.pop();
                res = first + second + ch;
                stack.push(res);
            } else stack.push("" + ch);
        }
        System.out.println(stack.peek());
    }

    private static void reverse(char[] arr) {
        int i = 0, j = arr.length - 1;
        char ch;
        while (i < j) {
            ch = arr[i];
            arr[i] = arr[j];
            arr[j] = ch;
            i++;
            j--;
        }
    }
}
```
