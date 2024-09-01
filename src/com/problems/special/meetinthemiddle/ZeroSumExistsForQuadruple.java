package com.problems.special.meetinthemiddle;

import java.util.HashSet;
import java.util.Set;

/*
 * Problem link :
 *
 * Solution link :
 *
 *
 */
public class ZeroSumExistsForQuadruple {

    /**
     * Question:
     * Find if there is any quadruple exists in an array whose sum is zero
     * you can use same number more than once
     * n ⇐ 1000
     * total sum will not cross integer max value
     */
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    // meet in the middle
    // same as previous but little optimize
    private static void type3() {
        int[] nums = {1, 2, -1, 3, 5};
        boolean ans = zeroSumExists3(nums);
        System.out.println(ans);
    }

    private static boolean zeroSumExists3(int[] nums) {
        int n = nums.length;
        Set<Integer> bucket = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums[i] + nums[j];
                bucket.add(sum);
                int rem = -sum;
                if (bucket.contains(rem)) return true;
            }
        }
        return false;
    }

    // brute force
    // meet in the middle
    private static void type2() {
        int[] nums = {1, 2, -1, 3, 5};
        boolean ans = zeroSumExists2(nums);
        System.out.println(ans);
    }

    private static boolean zeroSumExists2(int[] nums) {
        int n = nums.length;
        Set<Integer> bucket = new HashSet<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                bucket.add(nums[i] + nums[j]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums[i] + nums[j];
                int rem = -sum;
                if (bucket.contains(rem)) return true;
            }
        }
        return false;
    }

    // brute force
    private static void type1() {
        int[] nums = {1, 2, -1, 3, 5};
        boolean ans = zeroSumExists1(nums);
        System.out.println(ans);
    }

    // we will use a nested loop for checking all the possible sum and then check if it is 0 or not
    private static boolean zeroSumExists1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    for (int l = 0; l < n; l++)
                        if (nums[i] + nums[j] + nums[j] + nums[l] == 0) return true;
        return false;
    }
}
