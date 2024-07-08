package com.problems.dp;

import java.util.Arrays;

/*
 * Problem link :
 * https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/
 * https://www.naukri.com/code360/problems/cost-to-cut-a-chocolate_3208460
 *
 * Solution link :
 * https://www.youtube.com/watch?v=xwomavsC86c&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=51
 *
 * https://takeuforward.org/data-structure/minimum-cost-to-cut-the-stick-dp-50/
 */
public class MinimumCostToCutTheStick {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    // we can transform the recursion to iteration
    private static void type3() {
        int n = 7;
        int[] cuts = {1, 3, 4, 5};
        int c = cuts.length;
        int len = c + 2;
        // we will sort the array, so that cuts will be in order
        Arrays.sort(cuts);
        // we will modify the cut array
        int[] nums = new int[len];
        nums[0] = 0;
        nums[c + 1] = n;
        System.arraycopy(cuts, 0, nums, 1, c);
        cuts = nums;
        // create the dp of the same size
        int[][] dp = new int[len][len];

        // we want all ranges possible, so to turn recursion into iteration, we will start
        // left from the last, and we will start right just after left to the last index.
        // so after that we can just copy the recurrence relation from the recursion
        for (int left = len - 1; left >= 0; left--) {
            // we will start right left+2 otherwise there will not be any cut
            // between left and right
            for (int right = left + 2; right < len; right++) {
                int cost = cuts[right] - cuts[left];
                int min = Integer.MAX_VALUE;
                // we will cut everywhere between left+1 to right-1 and split the rod
                // new rod will be left to k and k to right
                for (int k = left + 1; k < right; k++)
                    min = Math.min(
                            min,
                            dp[left][k] + dp[k][right]
                    );
                dp[left][right] = min + cost;
            }
        }
        int ans = dp[0][len - 1];
        System.out.println(ans);
    }

    // recursion with memoization
    private static void type2() {
        int n = 7;
        int[] cuts = {1, 3, 4, 5};
        int c = cuts.length;
        // we will sort the array, so that cuts will be in order
        Arrays.sort(cuts);
        // we will modify the cut array
        int[] nums = new int[c + 2];
        nums[0] = 0;
        nums[c + 1] = n;
        System.arraycopy(cuts, 0, nums, 1, c);
        // create the dp of the same size
        int[][] dp = new int[c + 2][c + 2];
        int ans = minCost2(0, c + 1, nums, dp);
        System.out.println(ans);
    }

    private static int minCost2(int left, int right, int[] cuts, int[][] dp) {
        // if there are no cuts possible in between, then we will return cost as 0
        if (left + 1 == right) return 0;
        // the current cost will be right length - left length
        int cost = cuts[right] - cuts[left];
        // if the call is already made, then we will return the value
        if (dp[left][right] != 0) return dp[left][right];
        int min = Integer.MAX_VALUE;
        // we will cut everywhere between left+1 to right-1 and split the rod
        // new rod will be left to k and k to right
        for (int k = left + 1; k < right; k++)
            min = Math.min(
                    min,
                    minCost2(left, k, cuts, dp) + minCost2(k, right, cuts, dp)
            );
        return dp[left][right] = min + cost;
    }

    // using simple recursion.
    // let's say the rod is having the marker is on 0 to n.
    // we want to cut it in all cuts, so the first thing we could do is, sort the cuts.
    // let's say the first cut is on ith index having value k.
    // then the cost is 7-0, and the current rods will be 0 to k and k to n,
    // so we can also cut the array from first index to i and ith index to last.
    // but we are forgetting one thing we still need to use length 0 and length n for future length,
    // so to simplify things we will add 0 and n to the first and last index in the cuts.
    // so the length will be cuts[left] - cuts[right]
    // if we try to break it at ith index, then new lengths will be
    // cuts[k] - cuts[left] and cuts[right] - cuts[k]

    // todo this slightly different from strivers solution but intuition is from his solution
    private static void type1() {
        int n = 7;
        int[] cuts = {1, 3, 4, 5};
        int c = cuts.length;
        // we will sort the array, so that cuts will be in order
        Arrays.sort(cuts);
        // we will modify the cut array
        int[] nums = new int[c + 2];
        nums[0] = 0;
        nums[c + 1] = n;
        System.arraycopy(cuts, 0, nums, 1, c);

        int ans = minCost1(0, c + 1, nums);
        System.out.println(ans);
    }

    private static int minCost1(int left, int right, int[] cuts) {
        // if there are no cuts possible in between, then we will return cost as 0
        if (left + 1 == right) return 0;
        // the current cost will be right length - left length
        int cost = cuts[right] - cuts[left];
        int min = Integer.MAX_VALUE;
        // we will cut everywhere between left+1 to right-1 and split the rod
        // new rod will be left to k and k to right
        for (int k = left + 1; k < right; k++)
            min = Math.min(
                    min,
                    minCost1(left, k, cuts) + minCost1(k, right, cuts)
            );
        return min + cost;
    }
}
