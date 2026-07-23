# MaxSumIncreasingSubsequenceOfLengthK

**Topic:** `dp` | **File:** `com/problems/dp/MaxSumIncreasingSubsequenceOfLengthK.java`

## Problem Links

- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/maximum-sum-subsequence_1230547)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Optimal approach

```java
private static void type3() {
    }
```

### Approach 2

This DP solution has some bug, fix it recursion with the dynamic programming

```java
private static void type2() {
        List<Integer> arr = List.of(1, 3, -2, 4, 5);
        int k = 3;
        long ans = maximumSum2(arr, k);
        System.out.println(ans);
    }
    public static long maximumSum2(List<Integer> arr, int k) {
        int n = arr.size();
        Long[][][] dp = new Long[n][n + 1][k + 1];
        long ans = maximumSum2(n - 1, n, k, arr, dp);
        return (ans != Long.MIN_VALUE) ? ans : -1;
    }
    private static long maximumSum2(int i, int prev, int k, List<Integer> arr, Long[][][] dp) {
        int n = arr.size();
        if (k == 0) return 0;
        if (i < 0) return Long.MIN_VALUE;
        if (dp[i][prev][k] != null) return dp[i][prev][k];
        int curr = arr.get(i);
        long sum = maximumSum2(i - 1, prev, k, arr, dp);
        if (prev == n || curr < arr.get(prev)) {
            long sumWithCurr = maximumSum2(i - 1, i, k - 1, arr, dp);
            if (sumWithCurr != Long.MIN_VALUE) sumWithCurr += curr;
            sum = Math.max(sum, sumWithCurr);
        }
        return dp[i][prev][k] = sum;
    }
```

### Approach 1 — Brute Force

This solution has some bug, fix it with recursion

```java
private static void type1() {
        List<Integer> arr = List.of(1, 3, -2, 4, 5);
        int k = 3;
        long ans = maximumSum1(arr, k);
        System.out.println(ans);
    }
    public static long maximumSum1(List<Integer> arr, int k) {
        long ans = maximumSum1(arr.size() - 1, Integer.MAX_VALUE, k, arr);
        return (ans != Long.MIN_VALUE) ? ans : -1;
    }
    private static long maximumSum1(int i, int prev, int k, List<Integer> arr) {
        if (k == 0) return 0;
        if (i < 0) return Long.MIN_VALUE;
        int curr = arr.get(i);
        long sum = maximumSum1(i - 1, prev, k, arr);
        if (curr < prev) {
            long sumWithCurr = maximumSum1(i - 1, curr, k - 1, arr);
            if (sumWithCurr != Long.MIN_VALUE) sumWithCurr += curr;
            sum = Math.max(sum, sumWithCurr);
        }
        return sum;
    }
```
