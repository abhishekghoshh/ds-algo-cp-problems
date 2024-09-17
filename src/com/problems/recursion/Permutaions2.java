package com.problems.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem link
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * solution link
 * */
public class Permutaions2 {
    public static void main(String[] args) {
        type1();
    }

    private static void type1() {
        int[] nums = {1, 1, 2};
        List<List<Integer>> ans = permuteUnique(nums);
        System.out.println(ans);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        return ans;
    }
}
