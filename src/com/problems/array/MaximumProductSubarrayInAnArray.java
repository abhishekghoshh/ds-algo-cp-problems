package com.problems.array;

/*
 *
 * problem links :
 * https://leetcode.com/problems/maximum-product-subarray/description/
 * https://www.naukri.com/code360/problems/subarray-with-maximum-product_6890008
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
        type3();
        type4();

    }

    private static void type4() {
        int[] nums = {2, 3, -2, 4};
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0, cur = 1; i < n; ++i) {
            cur *= nums[i];
            res = Math.max(res, cur);
            if (cur == 0) {
                cur = 1;
            }
        }
        for (int i = n - 1, cur = 1; i >= 0; --i) {
            cur *= nums[i];
            res = Math.max(res, cur);
            if (cur == 0) {
                cur = 1;
            }
        }
        System.out.println(res);
    }

    // using kadane algorithm
    private static void type3() {
        int[] nums = {2, 3, -2, 4};
        int n = nums.length;
        int prod1 = nums[0], prod2 = nums[0], result = nums[0];
        for (int i = 1; i < n; i++) {
            int temp = Math.max(nums[i], Math.max(prod1 * nums[i], prod2 * nums[i]));
            prod2 = Math.min(nums[i], Math.min(prod1 * nums[i], prod2 * nums[i]));
            prod1 = temp;
            result = Math.max(result, prod1);
        }
        System.out.println(result);
    }


    // TODO explain this approach in any interview
    // We have couple observations here
    // 1. No negative no zeros
    // 2. even number of negatives without zero
    // 3. odd number of negatives without zero
    // 4. with zero

    // for the first two cases we have the whole array as answer
    // lets take with odd number of negatives
    //  [1, 2, 4, -2, 3, -5, 3, -4, 2]
    // the maximum could be [1, 2, 4, -2, 3, -5, 3] or [3, -5, 3, -4, 2]
    // so it is either prefix or suffix
    // we can think of other examples, but it is always the same
    // the reason is every number is an integer,
    // and we are starting from the start or end and make series with even number of negative
    // but what if there is a zero
    // [1, 2, 4, -2, 3, -5, 3, -4, 2 ,0, 1, 2, 4, 9]
    // so if we look close it is actually 2 arrays
    // so, we can do one thing once we encounter a zero we can set the
    // resultant multiplication to 1 to make it a new start
    // so, we can traverse from the start or end in different loop or in the same loop
    // and on every iteration we will pick the max out of it
    private static void type2() {
        int[] nums = {2, 3, -2, 4};
        int n = nums.length;

        int pre = 1, suff = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;
            pre *= nums[i];
            suff *= nums[n - i - 1];
            max = Math.max(max, Math.max(pre, suff));
        }
        System.out.println(max);
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
