package com.problems.dp;

/*
 * Problem link :
 * https://leetcode.com/problems/burst-balloons/description/
 * https://www.naukri.com/code360/problems/mining-diamonds_4244494
 *
 * Solution link :
 * https://www.youtube.com/watch?v=Yz4LlDSlkns&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=52
 *
 * https://takeuforward.org/data-structure/burst-balloons-partition-dp-dp-51/
 */
public class BustBalloons {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    private static void type3() {
    }

    private static void type2() {
    }

    // using the recursion
    // todo the intuition is not straight forward
    // what is meant by dynamic programming
    // it is finding the the answer of independent sub problems and storing it
    // which will be used later to find the answer of the bigger sub problem
    // but for this problem if we try to burst a balloon from the middle,
    // then for some balloons on the left side the cost will be depending on some index on the right side
    // same for right side the cost will depend on the left side index
    // so we will change our thought process
    // rather we will pick a balloon and assume that this balloon will be the last balloon to burst
    // so for left side the right boundary will be the current balloon and the right side
    // the left boundary will be current balloon
    private static void type1() {
        int[] nums = {3, 1, 5, 8};
        // If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins.
        // If i - 1 or i + 1 goes out of bounds of the array,
        // then treat it as if there is a balloon with a 1 painted on it.
        // For this reason will add 1 and 1 on both sides
        int n = nums.length;
        int[] nums2 = new int[n + 2];
        // modifying the array
        nums2[0] = nums2[n + 1] = 1;
        for (int i = 0; i < n; i++) nums2[i + 1] = nums2[i];
        int ans = maxCoins1(1, n, nums2);
        System.out.println(ans);
    }

    static int maxCoins1(int i, int j, int[] nums) {
        if (i > j) return 0;
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = nums[i - 1] * nums[k] * nums[j + 1]
                    + maxCoins1(i, k - 1, nums)
                    + maxCoins1(k + 1, j, nums);
            max = Math.max(max, cost);
        }
        return max;
    }
}
