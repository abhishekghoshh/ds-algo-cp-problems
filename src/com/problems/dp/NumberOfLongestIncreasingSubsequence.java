package com.problems.dp;

/*
 * Problem link :
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 * https://www.naukri.com/code360/problems/number-of-longest-increasing-subsequence_3751627
 *
 * Solution link :
 * https://www.youtube.com/watch?v=cKVl1TFdNXg&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=48
 *
 * https://takeuforward.org/dynamic-programming/striver-dp-series-dynamic-programming-problems/
 */
public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    // todo check the leetcode top submissions
    private static void type3() {
    }

    // We took the intuition from the longest increasing subsequence,
    // but here along with dp array we will also use another array
    // todo check the striver video is you do not understand the solution
    private static void type2() {
        int[] nums = {50, 3, 90, 60, 80};
        int n = nums.length;

        int[] dp = new int[n];
        int[] counts = new int[n];

        int max = 1;

        for (int i = 0; i < n; i++) {
            // we will initialize everything with 1, as this will be the default value
            // if in any case in the inner loop does not execute or (nums[prev] < nums[i]) do not hold
            dp[i] = counts[i] = 1;
            for (int prev = 0; prev <= i - 1; prev++) {
                // The intuition is the same as LIS. However, here we will use some extra computations
                if (nums[prev] < nums[i]) {
                    // if the current is greater than previous, and dp[prev]+1 is also greater than the dp[i],
                    // so it is the time that we have found a new longer LIS, so we will update the dp[i].
                    if (dp[i] < dp[prev] + 1) {
                        // we will update the dp[i]
                        dp[i] = dp[prev] + 1;
                        // but now we will assign the count value with the count value of longest prev subsequence
                        counts[i] = counts[prev];
                    } else if (dp[prev] + 1 == dp[i]) {
                        // if the dp[prev]+1 is the same as dp[i], then we have found another LIS,
                        // so we will add that count value in the current counts[i]
                        // only when we find any new longer subsequence, we will add assign the counts[i] with counts[prev]
                        counts[i] = counts[i] + counts[prev];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }

        // max is the longest increasing subsequence length
        // we will loop through the array and take the index for which dp[i]=max,
        // and we will take their count[i] value
        int count = 0;
        for (int i = 0; i <= n - 1; i++)
            if (dp[i] == max) count += counts[i];

        System.out.println(count);
    }

    private static void type1() {

    }
}
