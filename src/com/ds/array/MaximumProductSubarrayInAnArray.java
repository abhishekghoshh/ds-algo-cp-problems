package com.ds.array;

/*
 *
 * problem links :
 * https://leetcode.com/problems/maximum-product-subarray/description/
 * https://www.codingninjas.com/studio/problems/subarray-with-maximum-product_6890008
 *
 *
 * Solution link :
 * https://www.youtube.com/watch?v=hnswaLJvr6g
 *
 * https://takeuforward.org/data-structure/maximum-product-subarray-in-an-array/
 */
public class MaximumProductSubarrayInAnArray {
    public static void main(String[] args) {
        type1();
        type2();

    }

    // using kadane algorithm
    private static void type2() {
        int[] nums = {2, 3, -2, 4};
        int n = nums.length;
        int mul = 1;
        int maxP = Integer.MIN_VALUE;
        int maxN = Integer.MAX_VALUE;
        int i = 0;
        while(i<n){

        }
    }

    // brute force approach
    // time complexity O(n^2)
    // space complexity O(1)
    private static void type1() {
        int[] nums = {2, 3, -2, 4};
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int mul;
        for (int i = 0; i < n; i++) {
            mul = 1;
            for (int j = i; j < n; j++) {
                mul *= nums[j];
                max = Math.max(max, mul);
                if (mul == 0) break;
            }
        }
        System.out.println(max);
    }
}
