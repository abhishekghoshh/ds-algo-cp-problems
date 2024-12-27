package com.problems.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Problem link:
 * https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/description/
 *
 * Solution link:
 * https://www.youtube.com/watch?v=Yk9Mor-Y488
 *
 * https://neetcode.io/solutions/find-polygon-with-the-largest-perimeter
 */
// Tags: Arrays, Prefix Sum, Priority Queue, Greedy, Sorting
public class FindPolygonWithTheLargestPerimeter {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    private static void type3() {
        int[] nums = {1, 12, 1, 2, 5, 50, 3};
        long ans = largestPerimeter3(nums);
        System.out.println(ans);
    }

    private static long largestPerimeter3(int[] nums) {
        return largestPerimeter3(nums, nums.length);
    }

    static long largestPerimeter3(int[] nums, int end) {
        int maxIndex = 0;
        long sum = 0;
        for (int i = 0; i < end; i++) {
            sum += nums[i];
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        if ((sum - nums[maxIndex]) > nums[maxIndex])
            return sum;
        else {
            int temp = nums[maxIndex];
            nums[maxIndex] = nums[end - 1];
            nums[end - 1] = temp;
            if (end < 3)
                return -1;
            return largestPerimeter3(nums, end - 1);
        }

    }

    private static void type2() {
        int[] nums = {1, 12, 1, 2, 5, 50, 3};
        long ans = largestPerimeter2(nums);
        System.out.println(ans);
    }

    private static long largestPerimeter2(int[] nums) {
        long sum = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            sum += num;
            heap.offer(num);
        }
        while (heap.size() >= 3) {
            int max = heap.poll();
            long diff = sum - max;
            if (diff > max) {
                return sum;
            }
            sum = diff;
        }
        return -1;
    }

    // todo explain this in the interview
    // this is a greedy approach
    // here we will sort the array first

    private static void type1() {
        int[] nums = {1, 12, 1, 2, 5, 50, 3};
        long ans = largestPerimeter1(nums);
        System.out.println(ans);
    }

    public static long largestPerimeter1(int[] nums) {
        Arrays.sort(nums);
        long perimeter = -1;
        long total = 0;
        for (int num : nums) {
            if (total > num) {
                perimeter = total + num;
            }
            total += num;
        }
        return perimeter;
    }
}
