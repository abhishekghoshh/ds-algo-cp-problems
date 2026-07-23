# CountPalindromicSubsequences

**Topic:** `string` | **File:** `com/problems/string/CountPalindromicSubsequences.java`

## Problem Links

- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/count-palindromic-subsequences_1062696)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=vlbA8oUxSV0)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Solve this optimized approach using dynamic programming

```java
private static void type2() {
        String s = "abcd";
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        int answer = countPalindrome(0, n - 1, arr, dp);
        System.out.println(answer);
    }
    private static int countPalindrome(int i, int j, char[] arr, int[][] dp) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        if (arr[i] == arr[j])
            return dp[i][j] = countPalindrome(i + 1, j, arr, dp) + countPalindrome(i, j - 1, arr, dp);
        return
                dp[i][j] = countPalindrome(i + 1, j, arr, dp)
                        + countPalindrome(i, j - 1, arr, dp) -
                        countPalindrome(i + 1, j - 1, arr, dp);
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
    }
```
