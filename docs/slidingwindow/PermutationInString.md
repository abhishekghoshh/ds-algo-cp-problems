# PermutationInString

**Topic:** `slidingwindow` | **File:** `com/problems/slidingwindow/PermutationInString.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/permutation-in-string/description/)
- [📄 NeetCode](https://neetcode.io/problems/permutation-string)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=UbyhOgBN834)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimized approach using the sliding window now we have added all the characters of string1 to the freq array we will decrement the characters of the string 2 from the freq array so at any point if the freq array is all 0 then we will return 0

```java
private static void type2() {
        String s1 = "ab", s2 = "eidbaooo";
        boolean ans = checkInclusion2(s1, s2);
        System.out.println(ans);
    }
    public static boolean checkInclusion2(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int n1 = arr1.length, n2 = arr2.length;
        if (n1 > n2) return false;
        int[] freq = new int[26];
        // now we have added all the characters of string1 to the freq array
        for (char ch : arr1) {
            freq[ch - 'a']++;
        }
        // now we will use sliding window for all the n1 size window in the str2,
        // but first we will start for the first window
        for (int i = 0; i < n1; i++) {
            int pos = arr2[i] - 'a';
            freq[pos]--;
        }
        if (isAllZero(freq)) return true;
        // for the remaining window
        for (int i = n1; i < n2; i++) {
            // computing for the current char
            int pos = arr2[i] - 'a';
            freq[pos]--;
            // computing for the left char
            int leftPos = arr2[i - n1] - 'a';
            freq[leftPos]++;
            // now we have calculated for the current window
            // if all 0 then we will return true
            if (isAllZero(freq)) return true;
        }
        return false;
    }
    private static boolean isAllZero(int[] freq) {
        System.out.println(concat(freq));
        for (int f : freq) {
            if (f != 0) return false;
        }
        return true;
    }
    private static String concat(int[] freq) {
        StringBuilder sb = new StringBuilder();
        for (int f : freq) sb.append(f).append(" ");
        return sb.toString();
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {

    }
```
