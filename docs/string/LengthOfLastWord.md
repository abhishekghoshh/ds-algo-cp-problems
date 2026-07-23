# LengthOfLastWord

**Topic:** `string` | **File:** `com/problems/string/LengthOfLastWord.java`

**Tags:** Array, String

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/length-of-last-word/description/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimized approach time complexity O(n) we will start from the last and skip till there is a character from that point we will start again and go till there is a space or till the start

**Complexity:** Time: o(n)

```java
private static void type2() {
        String s = "Hello World";
        int ans = lengthOfLastWord2(s);
        System.out.println(ans);
    }
    public static int lengthOfLastWord2(String s) {
        int n = s.length();
        int c = 0, i = n - 1;
        // skip all the trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') i--;
        // going till we encounter a space
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            c++;
        }
        return c;
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
    }
```
