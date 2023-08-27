package com.github.ds.jumpgame;
/*
 *
 * problem links :
 * https://leetcode.com/problems/jump-game/
 *
 * Solution link :
 *
 *
 *
 * */
public class JumpGame {
    public static void main(String[] args) {
        type1();
        type2();
    }

    private static void type2() {
        int[] nums = {2, 3, 1, 1, 4};
        boolean[] memo = new boolean[nums.length];
        boolean canJump = canJump(nums, 0, memo);
        System.out.println(canJump);
    }

    private static boolean canJump(int[] nums, int current, boolean[] memo) {
        if (current == nums.length - 1)
            return true;
        if (current >= nums.length || nums[current] == 0)
            return false;
        if (memo[current])
            return true;
        for (int i = nums[current]; i >= 1; i--) {
            int next = current + i;
            boolean isPossible = canJump(nums, next, memo);
            if (isPossible)
                return memo[current] = true;
        }
        return memo[current] = false;
    }

    private static void type1() {
        int[] nums = {2, 3, 1, 1, 4};
        boolean canJump = canJump(nums, 0);
        System.out.println(canJump);
    }

    private static boolean canJump(int[] nums, int current) {
        if (current == nums.length - 1)
            return true;
        if (current >= nums.length || nums[current] == 0)
            return false;
        for (int i = 1; i <= nums[current]; i++) {
            boolean isPossible = canJump(nums, current + i);
            if (isPossible)
                return true;
        }
        return false;
    }
}
