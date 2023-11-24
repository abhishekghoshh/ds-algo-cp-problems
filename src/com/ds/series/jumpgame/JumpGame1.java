package com.ds.series.jumpgame;

/*
 *
 * problem links :
 * https://leetcode.com/problems/jump-game/
 *
 * Solution link :
 * https://www.youtube.com/watch?v=C6AZyfj-Kyw&list=PLJtzaiEpVo2yaP5v5bq0-QJgU0lO3TrEi&index=1
 *
 * https://github.com/Algorithms-Made-Easy/Leetcode-Challenge/blob/main/55.%20Jump%20Game
 *
 * */
public class JumpGame1 {
    public static void main(String[] args) {
        type1();
        type2();
    }


    private static void type2() {
        int[] nums = {2, 3, 1, 1, 4};
        boolean ans = canJump2(nums);
        System.out.println(ans);
    }

    public static boolean canJump2(int[] nums) {
        int curr = nums[0], n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i == curr && nums[i] == 0)
                break;
            curr = Math.max(i + nums[i], curr);
        }
        return curr >= n - 1;
    }

    private static void type1() {
        int[] nums = {2, 3, 1, 1, 4};
        boolean ans = canJump1(nums);
        System.out.println(ans);
    }

    public static boolean canJump1(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        int max = 0;
        for (int index = 0; index < n - 1 && max >= index; index++) {
            if (max < index + nums[index])
                max = index + nums[index];
            if (max >= n - 1)
                return true;
        }
        return false;
    }
}
