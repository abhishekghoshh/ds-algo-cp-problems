package com.problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 *
 * problem links :
 * https://leetcode.com/problems/binary-subarrays-with-sum
 * https://www.naukri.com/code360/problems/count-substrings-with-k-ones_3128698
 *
 * Solution link :
 * Leet Corner :
 * https://www.youtube.com/watch?v=-DNN2Xk7Xb8
 *
 *
 * */

// Tags: Arrays, Prefix sum, Sliding window
public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
        type4();
    }

    // Heavily inspired for SubarrayWithExactlyKDifferentIntegers
    private static void type4() {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        int count = getCount(nums, goal) - getCount(nums, goal - 1);
        System.out.println(count);
    }

    private static int getCount(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int start = 0;
        int count = 0;
        for (int end = 0; end < n; end++) {
            sum += nums[end];
            while (start <= end && sum > k)
                sum -= nums[start++];
            if (sum <= k)
                count += end - start + 1;
        }
        return count;
    }

    // optimized approach
    // prefix sum approach
    private static void type3() {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        int ones = 0;
        for (int num : nums) ones += num;
        int[] counts = new int[ones + 1];
        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            if (sum == goal) count++;
            if (sum >= goal && counts[sum - goal] != 0)
                count += counts[sum - goal];
            counts[sum]++;
        }
        System.out.println(count);

    }

    // prefix sum
    // using a hashmap
    private static void type2() {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        Map<Integer, Integer> counts = new HashMap<>();
        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            if (sum == goal) count++;
            if (counts.containsKey(sum - goal))
                count += counts.get(sum - goal);
            counts.put(sum, counts.getOrDefault(sum, 0) + 1);
        }
        System.out.println(count);
    }

    // brute force approach
    private static void type1() {
    }
}
