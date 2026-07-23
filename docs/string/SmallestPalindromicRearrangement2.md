# SmallestPalindromicRearrangement2

**Topic:** `string` | **File:** `com/problems/string/SmallestPalindromicRearrangement2.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/smallest-palindromic-rearrangement-ii)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach

```java
private static void type2() {
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
        String s = "bacab";
        int k = 1;
        String ans = smallestPalindrome1(s, k);
        System.out.println(ans);
    }
    public static String smallestPalindrome1(String s, int k) {
        long f = 1;
        char[] arr = s.toCharArray();
        int[] freq = new int[26];
        for (char ch : arr) {
            freq[ch - 'a']++;
        }

        return null;
    }
```
