# ValidPalindrome2

**Topic:** `string` | **File:** `com/problems/string/ValidPalindrome2.java`

**Tags:** String, Array, Two pointer

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/valid-palindrome-ii/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=JrxRYBwG6EI)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Given a string s, return true if the s can be palindrome after deleting at most one character from it. very optimal approach we will use 2 pointers start and end we will increase start and decrease end till the characters are equal once we find any equal character we have 2 choices either to delete the starting character or to delete the ending character if either of them is a palindrome then we have found our answer, and we will return true;

```java
private static void type2() {
        String s = "abca";
        boolean ans = validPalindrome(s);
        System.out.println(ans);
    }
    public static boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }
        return true;
    }
```

### Approach 1 — Brute Force

Brute force

```java
private static void type1() {
        String s = "abca";
    }
```
