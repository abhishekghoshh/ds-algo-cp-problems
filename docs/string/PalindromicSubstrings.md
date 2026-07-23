# PalindromicSubstrings

**Topic:** `string` | **File:** `com/problems/string/PalindromicSubstrings.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/palindromic-substrings/description/)
- [📄 NeetCode](https://neetcode.io/problems/palindromic-substrings)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=4RACzI5-du8)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Most optimized approach using 2 pointer we will not use any extra dp array we will choose one index and start looking for palindrome making that index as center, or we can think that it is an even length palindrome, so we will start from i,i+1 and expand till it is a palindrome

```java
private static void type3() {
        String s = "aaa";
        int ans = countSubstrings3(s);
        System.out.println(ans);
    }
    public static int countSubstrings3(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int count = 0;
        // we will check for all the indices
        // we will check for odd and even length palindromes
        for (int i = 0; i < n; i++) {
            // checking for odd length palindromes and increasing the counter
            int left = i, right = i;
            while (left >= 0 && right < n && arr[left] == arr[right]) {
                count++;
                left--;
                right++;
            }
            // checking for even length palindrome and increasing the counter
            left = i;
            right = i + 1;
            while (left >= 0 && right < n && arr[left] == arr[right]) {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
```

### Approach 2

Optimized approach using dynamic programming first we will calculate 1 length palindrome then 2 then subsequently n generally lets take a substring s[i,j] will be palindrome when s[i] == s[j] and s[i+1][j-1] is also palindrome we will use the same formula

```java
private static void type2() {
        String s = "aaa";
        int ans = countSubstrings2(s);
        System.out.println(ans);
    }
    public static int countSubstrings2(String s) {
        int n = s.length();
        // if length is 1 then we will directly return 1
        if (n == 1) return 1;
        char[] arr = s.toCharArray();
        // we will use a dp array to check if range is palindrome not
        boolean[][] dp = new boolean[n][n];
        // all the single length character is palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // we will initialize the totalCount with 1 as all the single length character is palindrome
        int totalCount = n;
        // now we will check 2 length strings
        for (int i = 0; (i + 1) < n; i++) {
            if (arr[i] == arr[i + 1]) {
                totalCount++;
                dp[i][i + 1] = true;
            }
        }
        // now we can generalize the solution
        // we will start with 3 and go till n
        for (int d = 3; d <= n; d++) {
            for (int i = 0; (i + d - 1) < n; i++) {
                //  s[i]==s[j] and s[i+1][j-1] is also palindrome
                if (arr[i] == arr[i + d - 1] && dp[i + 1][i + d - 2]) {
                    dp[i][i + d - 1] = true;
                    totalCount++;
                }
            }
        }
        return totalCount;
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
    }
```
