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
    // we will just convert the recursion into iteration
    private static void type3() {
        int[] arr = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        int k = 4;
        int n = arr.length;
        int[] dp = new int[n + 1];
        // we will start from last so that we can copy the recurrence relation
        for (int i = n - 1; i >= 0; i--) {
            int sum = 0, max = 0;
            int len = 0;
            // we will take the min of i+k and n, so that do not go out of bounds
            int bound = Math.min(i + k, n);
            for (int j = i; j < bound; j++) {
                // increase the length and calculate the current max of that range
                len++;
                max = Math.max(max, arr[j]);
                // check the partition value of the j+1
                sum = Math.max(
                        sum,
                        len * max + dp[j + 1]
                );
            }
            dp[i] = sum;
        }
        int ans = dp[0];
        System.out.println(ans);
    }

    // recursion with memoization
    // similar to the previous type
    private static void type2() {
        int[] arr = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        int k = 4;
        int ans = partition2(arr, k);
        System.out.println(ans);
    }

    public static int partition2(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return partition2(0, arr, k, dp);
    }

    static int partition2(int i, int[] num, int k, int[] dp) {
        int n = num.length;
        // if we are going out of bounds, then the sum will be 0
        if (i == n) return 0;
        // if cell is computed then we will directly return the answer
        if (dp[i] != -1) return dp[i];
        int len = 0;
        int max = 0, sum = 0;
        // we will take the min of i+k and n, so that do not go out of bounds
        int bound = Math.min(i + k, n);
        // Iterate through the next 'k' elements or remaining elements if less than 'k'.
        for (int j = i; j < bound; j++) {
            // increase the length and calculate the current max of that range
            len++;
            max = Math.max(max, num[j]);
            // start a new partition from j+1
            sum = Math.max(
                    sum,
                    len * max + partition2(j + 1, num, k, dp)
            );
        }
        return dp[i] = sum;
    }

    // using brute force approach with recursion,
    // the intuition is pretty straightforward
    // we will start from i and go to i+k
    // for every j in that range we will check the new partition from j+1
    private static void type1() {
        int[] arr = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        int k = 4;
        int ans = partition1(0, arr, k);
        System.out.println(ans);
    }

    static int partition1(int i, int[] num, int k) {
        int n = num.length;
        // if we are going out of bounds, then the sum will be 0
        if (i == n) return 0;
        // if cell is computed then we will directly return the answer
        int len = 0;
        int max = 0, sum = 0;
        // we will take the min of i+k and n, so that do not go out of bounds
        int bound = Math.min(i + k, n);
        // Iterate through the next 'k' elements or remaining elements if less than 'k'.
        for (int j = i; j < bound; j++) {
            // increase the length and calculate the current max of that range
            len++;
            max = Math.max(max, num[j]);
            // start a new partition from j+1
            sum = Math.max(
                    sum,
                    len * max + partition1(j + 1, num, k)
            );
        }
        return sum;
    }
}
