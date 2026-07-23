# MaximumNumberOfVowelsInASubstringOfGivenLength

**Topic:** `slidingwindow` | **File:** `com/problems/slidingwindow/MaximumNumberOfVowelsInASubstringOfGivenLength.java`

**Tags:** Array, Sliding window

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=kEfPSzgL-Ss)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Sliding window approach

```java
private static void type2() {
        String s = "abciiidef";
        int k = 3;
        int ans = maxVowels2(s, k);
        System.out.println(ans);
    }
    public static int maxVowels2(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int v = 0;
        // for the first window
        for (int i = 0; i < k; i++) {
            if (isVowel(arr[i])) v++;
        }
        int max = v;
        // for the remaining window
        for (int i = k; i < n; i++) {
            if (isVowel(arr[i])) v++;
            if (isVowel(arr[i - k])) v--;
            max = Math.max(max, v);
        }
        return max;
    }
```

### Approach 1 — Brute Force

Brute force

```java
private static void type1() {

    }
```
