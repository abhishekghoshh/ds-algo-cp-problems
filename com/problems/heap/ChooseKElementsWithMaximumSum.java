package com.problems.heap;

import com.util.PrintUtl;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 *
 * problem links :
 * https://leetcode.com/problems/choose-k-elements-with-maximum-sum/description/
 * Solution link :
 *
 * */
public class ChooseKElementsWithMaximumSum {
    public static void main(String[] args) {
        type1();
    }

    // Optimized using priority queue
    // but check it later as well
    // it would be easy to find out the lower elements if we have sorted the nums1 array,
    // so then we will start from the last we will easily obtain the elements which are lesser than that
    // but if we sort we will lose the indices, so we will create an 2D array, [num,index] then sort on that
    // once we find that we will start from the last, but we only need top k elements, so we will use a priority queue
    // once priority queue has more than k then we will poll the lowest element
    // we will also carry a sum variable so that we do not need to compute the sum everytime
    private static void type1() {
        int[] nums1 = {4, 2, 1, 5, 3};
        int[] nums2 = {10, 20, 30, 40, 50};
        int k = 2;
        long[] ans = findMaxSum(nums1, nums2, k);
        PrintUtl.print(ans);
    }

    public static long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long[] sums = new long[n];
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums1[i];
            arr[i][1] = i;
        }
        // sorted in reverse
        Arrays.sort(arr, (a1, a2) -> Integer.compare(a2[0], a1[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        int prev = -1;

        for (int i = n - 1; i >= 0; i--) {
            int nums1Elem = arr[i][0];
            int nums1I = arr[i][1];
            // if the current item is equal to previous item then we will copy the sum for the prev item
            if (prev == nums1Elem) {
                sums[nums1I] = sums[arr[i + 1][1]];
            } else {
                sums[nums1I] = sum;
                prev = nums1Elem;
            }
            // add nums2 ith element to sum and priority queue
            int nums2Elem = nums2[nums1I];
            minHeap.offer(nums2Elem);
            sum += nums2Elem;
            // if size it greater than k then we will poll
            if (minHeap.size() > k) {
                sum -= (minHeap.poll());
            }
        }
        return sums;
    }
}
