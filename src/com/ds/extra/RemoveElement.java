package com.ds.extra;

/*
 *
 * problem links :
 * https://leetcode.com/problems/remove-element
 *
 * Solution link :
 *
 * */
public class RemoveElement {
    public static void main(String[] args) {
        type1();
    }


    private static void type1() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int n = nums.length;
        int start = 0, end = n - 1;
        while (start < end) {
            if (nums[start] == val) {
                while (start < end && nums[end] == val) end--;
                if (start == end) break;
                else swap(nums, start, end);
            }
            start++;
        }
        int count = 0;
        for (int num : nums)
            if (num != val)
                count++;
            else
                break;
        print(count);
    }


    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void print(int... nums) {
        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();
    }
}
