package com.ds.special.meetinthemiddle;

import java.util.Arrays;

/*
 * Problem link :
 * https://leetcode.com/problems/closest-subsequence-sum
 *
 *
 * Solution link :
 * https://www.youtube.com/watch?v=naz_9njI0I0
 *
 */
public class ClosestSubsequenceSum {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    private static int index = 0;

    private static void findAllSums(int i, int end, int sum, int[] nums, int[] subsetSumArray) {
        if (i == end) {
            subsetSumArray[index++] = sum;
            return;
        }
        findAllSums(i + 1, end, sum + nums[i], nums, subsetSumArray);
        findAllSums(i + 1, end, sum, nums, subsetSumArray);
    }

    // same as type2 but here we will generate all the sum using recursion
    private static void type3() {
        int[] nums = {7, -9, 15, -2};
        int goal = -5;
        int n = nums.length;
//        if (n == 1) return Math.min(Math.abs(goal), Math.abs(nums[0] - goal));
        index = 0;
        int n1 = n / 2, n2 = n - n / 2;
        int[] firstHalf = new int[1 << n1];
        findAllSums(0, n / 2, 0, nums, firstHalf);
        index = 0;
        int[] secondHalf = new int[1 << n2];
        findAllSums(n / 2, n, 0, nums, secondHalf);
        Arrays.sort(secondHalf);
        int answer = Integer.MAX_VALUE;
        int closest;
        for (int item : firstHalf) {
            closest = findClosestElement(goal - item, secondHalf);
            answer = Math.min(answer, Math.abs(goal - item - closest));
        }
        System.out.println(answer);
    }

    // time complexity O(2^n)
    private static int[] findAllSums(int[] nums, int start, int end, int offset) {
        int n = end - start + 1;
        int bound = 1 << n;
        int[] res = new int[bound];
        int sum;
        for (int i = 0; i < bound; ++i) {
            sum = 0;
            for (int j = 0; j < n; ++j)
                if ((i & (1 << j)) != 0)
                    sum += nums[j + offset];
            res[i] = sum;
        }
        return res;
    }

    // binary search to find the closest possible number from the array
    private static int findClosestElement(int item, int[] arr) {
        int n = arr.length;
        if (item <= arr[0]) return arr[0];
        if (item >= arr[n - 1]) return arr[n - 1];
        int low = 0, high = n - 1, mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (arr[mid] == item) return item;
            else if (arr[mid] < item) low = mid + 1;
            else high = mid - 1;
        }
        // at this point low exceeds high
        // the sequence is like arr[high], item, arr[low]
        // so we will calculate the difference with low and high places
        int differenceWithLow = arr[low] - item;
        int differenceWithHigh = item - arr[high];
        return differenceWithLow < differenceWithHigh ? arr[low] : arr[high];
    }

    // using meet in the middle approach
    private static void type2() {
        int[] nums = {7, -9, 15, -2};
        int goal = -5;
        int n = nums.length;
//        if (n == 1) return Math.min(Math.abs(goal), Math.abs(nums[0] - goal));
        int[] firstHalf = findAllSums(nums, 0, n / 2 - 1, 0);
        int[] secondHalf = findAllSums(nums, n / 2, n - 1, n / 2);
        Arrays.sort(secondHalf);
        int answer = Integer.MAX_VALUE;
        int closest;
        for (int item : firstHalf) {
            closest = findClosestElement(goal - item, secondHalf);
            answer = Math.min(answer, Math.abs(goal - item - closest));
        }
        System.out.println(answer);
    }

    //brute force approach
    // we will generate all the possible sum
    // and while generating we will try to find the closest subset sum to the goal
    private static void type1() {

    }
}
