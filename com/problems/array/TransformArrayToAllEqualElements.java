package com.problems.array;

/*
 * problem link:
 * https://leetcode.com/contest/weekly-contest-453/problems/transform-array-to-all-equal-elements/description/
 * https://leetcode.com/problems/transform-array-to-all-equal-elements/
 *
 * Solution link :
 *
 * */

// Tags: Arrays, two pointers
public class TransformArrayToAllEqualElements {
    public static void main(String[] args) {
        type1();
    }

    // todo it is very optimized approach
    //  O(2n) or O(3n) based on the number negative and positive elements
    private static void type1() {
        int[] nums = {1, -1, 1, -1, 1};
        int k = 3;
        boolean ans = canMakeEqual1(nums, k);
        System.out.println(ans);
    }

    public static boolean canMakeEqual1(int[] nums, int k) {
        int n = nums.length;
        int neg = 0, pos = 0;
        for (int num : nums) {
            if (num < 0) neg++;
        }
        pos = n - neg;
        if (neg == 0 || pos == 0) return true;
        // both are in odd numbers
        if (neg % 2 == 1 && pos % 2 == 1) {
            return false;
        } else if (neg % 2 == 0 && pos % 2 == 0) {
            // both are even, so we can either make all positive or all negative
            return checkAllEqualPivot(nums, k, 1) || checkAllEqualPivot(nums, k, -1);
        } else if (pos % 2 == 0) {
            // if positive is even, then we can have to those positive numbers to negative
            return checkAllEqualPivot(nums, k, -1);
        } else {
            // if negative is even, then we can have to those negative numbers to positive
            return checkAllEqualPivot(nums, k, 1);
        }
    }

    public static boolean checkAllEqualPivot(int[] nums, int k, int pivot) {
        int n = nums.length;
        int cost = 0;
        int lastIdx = -1;
        for (int i = 0; i < n; i++) {
            // if it is already equal to pivot, then we can skip it
            if (nums[i] == pivot) continue;
            if (lastIdx == -1) {
                lastIdx = i;
            } else {
                int dis = i - lastIdx;
                cost += dis;
                lastIdx = -1;
                if (cost > k) return false;
            }
        }
        return true;
    }
}
