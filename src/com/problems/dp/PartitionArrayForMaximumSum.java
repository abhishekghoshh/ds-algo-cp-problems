package com.problems.dp;

import java.util.Arrays;

/*
 * Problem link :
 * https://leetcode.com/problems/partition-array-for-maximum-sum/
 * https://www.naukri.com/code360/problems/minimum-elements_3843091
 *
 * Solution link :
 * https://www.youtube.com/watch?v=PhWWJmaKfMc&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=55
 *
 * https://takeuforward.org/data-structure/partition-array-for-maximum-sum-front-partition-dp-54/
 */
public class PartitionArrayForMaximumSum {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    // tabulation approach or the bottom-up approach
    private static void type3() {
        int[] arr = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        int k = 4;
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int max = 0, maxNum = 0;
            int len = 0;
            for (int j = i; j < i + k; j++) {
                if (j == n) break;
                len++;
                maxNum = Math.max(maxNum, arr[j]);
                max = Math.max(max, len * maxNum + dp[j + 1]);
            }
            dp[i] = max;
        }
        int ans = dp[0];
        System.out.println(ans);
    }

    // recursion with memoization
    private static void type2() {
        int[] arr = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        int k = 4;
        int ans = maxSumAfterPartitioning2(arr, k);
        System.out.println(ans);
    }

    public static int maxSumAfterPartitioning2(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return maxSumAfterPartitioning2(0, arr, k, dp);
    }

    static int maxSumAfterPartitioning2(int i, int[] num, int k, int[] dp) {
        int n = num.length;
        if (i == n) return 0;
        // if cell is computed then we will directly return the answer
        if (dp[i] != -1) return dp[i];
        int len = 0;
        int maxNum = 0, max = 0;
        // Iterate through the next 'k' elements or remaining elements if less than 'k'.
        for (int j = i; j < i + k; j++) {
            if (j == n) break;
            len++;
            maxNum = Math.max(maxNum, num[j]);
            max = Math.max(max, len * maxNum + maxSumAfterPartitioning2(j + 1, num, k, dp));
        }
        return dp[i] = max;
    }

    // using brute force approach with recursion
    private static void type1() {
        int[] arr = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        int k = 4;
        int ans = maxSumAfterPartitioning1(arr, k);
        System.out.println(ans);
    }

    public static int maxSumAfterPartitioning1(int[] arr, int k) {
        return maxSumAfterPartitioning1(0, arr, k);
    }

    static int maxSumAfterPartitioning1(int i, int[] num, int k) {
        int n = num.length;
        if (i == n) return 0;
        // if cell is computed then we will directly return the answer
        int len = 0;
        int maxNum = 0, max = 0;
        // Iterate through the next 'k' elements or remaining elements if less than 'k'.
        for (int j = i; j < Math.min(i + k, n); j++) {
            len++;
            maxNum = Math.max(maxNum, num[j]);
            max = Math.max(max, len * maxNum + maxSumAfterPartitioning1(j + 1, num, k));
        }
        return max;
    }
}
