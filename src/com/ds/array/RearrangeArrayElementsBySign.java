package com.ds.array;

import com.util.ArrayUtil;
/*
 *
 * problem links:
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
 * https://www.codingninjas.com/studio/problems/alternate-numbers_6783445
 *
 * Solution link:
 * https://www.youtube.com/watch?v=h4aBagy4Uok
 *
 * https://takeuforward.org/arrays/rearrange-array-elements-by-sign/
 * */
public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        type1();
        type2();
    }

    // time complexity O(n)
    // space complexity O(n)
    private static void type2() {
        int[] nums = {3, 1, -2, -5, 2, -4};
        int[] result = new int[nums.length];
        int pIndex = 0;
        int nIndex = 1;
        for (int num : nums) {
            if (num > 0) {
                result[pIndex] = num;
                pIndex += 2;
            } else {
                result[nIndex] = num;
                nIndex += 2;
            }
        }
        ArrayUtil.print(result);
    }

    // time complexity O(2n)
    // space complexity O(n)
    private static void type1() {
        int[] nums = {3, 1, -2, -5, 2, -4};
        int n = nums.length;
        int[] setP = new int[n / 2];
        int[] setN = new int[n / 2];
        int i1 = 0, i2 = 0;
        for (int i = 0; i < n; i++)
            if (nums[i] > 0) setP[i1++] = nums[i];
            else setN[i2++] = nums[i];
        for (int i = 0; i < n / 2; i++) {
            nums[2 * i] = setP[i];
            nums[2 * i + 1] = setN[i];
        }
        ArrayUtil.print(nums);
    }
}
