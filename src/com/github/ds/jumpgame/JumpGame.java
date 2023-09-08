package com.github.ds.jumpgame;

import java.util.PriorityQueue;

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
        int[] nums = {};
        int curr = nums[0], n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i == curr && nums[i] == 0) {
                break;
            }
            curr = Math.max(i + nums[i], curr);
        }
        System.out.println(curr + " " + (n - 1));
        boolean ans = curr >= n - 1;
        System.out.println(ans);
    }

    private static void type1() {
        int[] nums = {};
        if (nums[0] == nums.length - 1) {
            System.out.println(true);
            return;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(nums.length);
        heap.add(nums.length - 1);

        for (int i = nums.length - 2; i > 0; --i) {
            if ((i + nums[i]) >= heap.peek()) {
                heap.add(i);
            }
        }

        boolean ans = nums[0] >= heap.peek();
        System.out.println(ans);
    }


}
