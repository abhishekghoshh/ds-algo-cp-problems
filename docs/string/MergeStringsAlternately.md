# MergeStringsAlternately

**Topic:** `string` | **File:** `com/problems/string/MergeStringsAlternately.java`

**Tags:** String, Array, Merge sort

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/merge-strings-alternately/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=LECWOvTo-Sc)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach using 2 pointers simple 2 pointer problem take 2 pointer on 2 words and a flag and now toggle the flag and take each character from the strings

```java
private static void type2() {
        String word1 = "abcd";
        String word2 = "pq";
        String ans = mergeAlternately2(word1, word2);
        System.out.println(ans);
    }
    public static String mergeAlternately2(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int n1 = word1.length(), n2 = word2.length();
        boolean flag = true;
        int i1 = 0, i2 = 0;
        // taking the characters from the strings
        while (i1 < n1 && i2 < n2) {
            char ch = flag ? word1.charAt(i1++) : word2.charAt(i2++);
            flag = !flag; // toggling the flag
            sb.append(ch);
        }
        // if there are any character remaining in the string1
        if (i1 < n1) sb.append(word1.substring(i1));
        // if there are any character remaining in the string2
        if (i2 < n2) sb.append(word2.substring(i2));

        return sb.toString();
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
    }
```
