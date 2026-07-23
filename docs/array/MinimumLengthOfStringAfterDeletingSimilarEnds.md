# MinimumLengthOfStringAfterDeletingSimilarEnds

**Topic:** `array` | **File:** `com/problems/array/MinimumLengthOfStringAfterDeletingSimilarEnds.java`

**Tags:** Array, String, Two pointer

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=318hrWVr_5U)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimized approach classic problem of 2 pointer if the in both end the character are same then we will shrink we will shrink till the characters are same

```java
private static void type2() {
        String s = "aabccabba";
        int ans = minimumLength2(s);
        System.out.println(ans);
    }
    public static int minimumLength2(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0, j = n - 1;
        while (i < j) {
            // if characters are different then we will break
            if (arr[i] != arr[j]) break;
            char ch = arr[i];
            // shrinking the left side
            while (i < j && arr[i] == ch) i++;
            // if (i to j) all characters are same then after left shrinking i wil go till j he answer will be 0 that time
            if (i == j) return 0;
            // shrinking the right side
            while (i < j && arr[j] == ch) j--;
        }
        // length of the string
        return (j - i + 1);
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
    }
```
