# CountPalindromicSubsequences

**Topic:** `string`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/count-palindromic-subsequences_1062696)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=vlbA8oUxSV0)

## 📝 Problem Statement

Count the number of palindromic subsequences in a string.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

solve this optimized approach using dynamic programming

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

### Approach 1: 🔨 Brute Force

brute force approach

```java
    private static void type1() {
    }
}
```
