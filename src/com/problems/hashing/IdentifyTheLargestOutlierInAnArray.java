package com.problems.hashing;

import java.util.*;

/*
 * Problem link :
 * https://leetcode.com/contest/weekly-contest-426/problems/identify-the-largest-outlier-in-an-array/description/
 * Solution link :
 *
 */
public class IdentifyTheLargestOutlierInAnArray {
    public static void main(String[] args) {
        type1();
        type2();
    }

    private static void type2() {
        int[] nums = {-2, -1, -3, -6, 4};
        int ans = getLargestOutlier2(nums);
        System.out.println(ans);
    }

    public static int getLargestOutlier2(int[] nums) {
        int total = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, 1 + freq.getOrDefault(num, 0));
            total += num;
        }
        List<Integer> potentialOutliers = new ArrayList<>();
        for (int outlier : nums) {
            int rem = total - outlier;
            if (rem % 2 != 0) continue;
            int sum = rem / 2;
            if ((sum == outlier && freq.get(sum) >= 2) ||
                    (sum != outlier && freq.containsKey(sum)))
                potentialOutliers.add(outlier);
        }
        return Collections.max(potentialOutliers);
    }

    //
    private static void type1() {

    }
}
