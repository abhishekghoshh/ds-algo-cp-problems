package com.github.ds.dp;

/*
 *
 * problem links :
 * https://leetcode.com/problems/house-robber-ii/
 * https://www.codingninjas.com/studio/problems/house-robber-ii_839733
 *
 * Solution link :
 * https://www.youtube.com/watch?v=3WaxQMELSkw&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=7
 *
 * https://takeuforward.org/data-structure/dynamic-programming-house-robber-dp-6/
 * */
public class HouseRobber2 {
    public static void main(String[] args) {
        type1();
        type2();
    }

    // we can use the same array
    // we can just manipulate the indices rather than creating 2 new array
    private static void type2() {
    }

    // same as house robber 1
    // with a constraint that if we are taking the 0th element
    // then we can not take n-1 th element
    // so can make 2 array one with the 0th element
    // and another n-1 th element
    // and, we can take the max from the both
    private static void type1() {
        int[] nums = {1, 2, 3, 1};
        int n = nums.length;
        int[] nums1 = new int[n - 1], nums2 = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            nums1[i] = nums[i];
            nums2[i] = nums[i + 1];
        }
        int answer = Math.max(rob(nums1), rob(nums2));
        System.out.println(answer);
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int prev2 = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        int current, takeCurrentHome, notTakeCurrentHome;
        for (int i = 2; i < n; i++) {
            takeCurrentHome = nums[i] + prev2;
            notTakeCurrentHome = prev;
            current = Math.max(takeCurrentHome, notTakeCurrentHome);
            prev2 = prev;
            prev = current;
        }
        return prev;
    }
}
