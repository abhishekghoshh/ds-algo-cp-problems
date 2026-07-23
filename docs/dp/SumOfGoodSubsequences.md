# SumOfGoodSubsequences

**Topic:** `dp`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/sum-of-good-subsequences/description/)

## 📝 Problem Statement

this answer would be valid if the question was

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

this answer would be valid if the question was

```java
    private static void type1() {
        int[] nums = {1, 2, 1};
        int ans = sumOfGoodSubsequences1(nums);
        System.out.println(ans);
    }


    public static int sumOfGoodSubsequences1(int[] nums) {
        int n = nums.length;
        boolean[][] dp = new boolean[n][n];
        int sum = 0;
        int[] prefixSum = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            sum = (sum + nums[i]) % mod;
            prefixSum[i] = sum;
        }
        for (int d = 2; d <= n; d++) {
            for (int i = 0; i + d - 1 < n; i++) {
                if (dp[i][i + d - 2] && Math.abs(nums[i + d - 1] - nums[i + d - 2]) == 1) {
                    dp[i][i + d - 1] = true;
                    int rangeSum = prefixSum[i + d - 1] - ((i > 0) ? prefixSum[i - 1] : 0);
                    sum = (sum + rangeSum) % mod;
                }
            }
        }
        return sum;
    }


}
```
