# MakeTheStringGreat

**Topic:** `stack`  
**Tags:** Array, Stack

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/make-the-string-great/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=10tBWNjzvtw)

## 📝 Problem Statement

Given a string, remove adjacent characters that are the same letter but different case.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

using an array almost the same as previous. we will use the same array to store the characters, so we will use a prev variable here in place changing instead of stack, we will use a variable we will use a string builder to store the result

```java
    private static void type2() {
        String s = "leEeetcode";
        String ans = makeGood2(s);
        System.out.println(ans);
    }

    private static String makeGood2(String s) {
        int diff = 'a' - 'A';
        char[] arr = s.toCharArray();
        // instead of stack, we will use a variable
        int prev = -1;
        for (char ch : arr) {
            if (prev != -1 && Math.abs(arr[prev] - ch) == diff)
                prev--;
            else
                arr[++prev] = ch;
        }
        // we will use a string builder to store the result
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= prev; i++) sb.append(arr[i]);
        return sb.toString();
    }
```

### Approach 1: 🔨 Brute Force

brute force using stack we could use an array as stack, though. we will check the last character of stack if the difference is 'a' - 'A' then it is the same letter but different case, so we will pop it

```java
    private static void type1() {
        String s = "leEeetcode";
        String ans = makeGood1(s);
        System.out.println(ans);
    }


    public static String makeGood1(String s) {
        int diff = 'a' - 'A';
        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for (char ch : arr) {
            if (!st.isEmpty() && Math.abs(st.peek() - ch) == diff)
                st.pop();
            else
                st.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.append(st.pop());
        sb.reverse();
        return sb.toString();
    }
}
```
