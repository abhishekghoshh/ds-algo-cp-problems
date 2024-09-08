package com.problems.special.jumpgame;

import java.util.Arrays;

/*
 *
 * problem links :
 * https://leetcode.com/problems/jump-game-ii/
 * https://www.codingninjas.com/studio/problems/jump-game_893178
 *
 * Solution link :
 * https://www.youtube.com/watch?v=BRnRPLNGWIo&list=PLJtzaiEpVo2yaP5v5bq0-QJgU0lO3TrEi&index=2
 *
 * https://github.com/Algorithms-Made-Easy/Leetcode-Challenge/blob/main/45.%20Jump%20Game%20II
 * */
public class JumpGame2 {

    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        type1();
        type3();
        type4();
    }

    private static void type4() {
        int[] nums = {2, 3, 1, 1, 4};
        int ans = jump(nums, 0, nums.length);
        System.out.println(ans);
    }

    private static int jump(int[] nums, int cur, int n) {
        if (cur >= n - 1) return 0;
        if (cur + nums[cur] >= n - 1) return 1;
        int maxIndex = cur + 1;
        for (int i = cur + 2; i <= cur + nums[cur]; i++)
            if (i + nums[i] > maxIndex + nums[maxIndex])
                maxIndex = i;
        return 1 + jump(nums, maxIndex, n);
    }


    // this is better approach
    // time complexity O(n) and space complexity is O(1)
    // we are calculating the jump per window.
    // lets says we are on 0th index which has value 3,
    // so we can go to any index up to 3
    // so our first window is from [0,3]
    // we will check which is the max index that we can reach from this range
    // and once we reach to the end we will increase the jump
    // let's say from 1 we can go till 5 which is the max
    // so once we reach the end of the range [0,3]
    // we will again set our range to [3,5]
    // and max is 8 which is from 4, ideally the jump sequence is 0->1->4...
    private static void type3() {
        int[] nums = {2, 3, 1, 1, 4};
        int n = nums.length;
        int end = 0, max = 0;
        int jump = 0;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                jump++;
                end = max;
            }
        }
        System.out.println(jump);
    }


    // using dynamic programming
    // using O(n^2)
    private static void type1() {
        int[] nums = {2, 3, 1, 1, 4};
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        // if we are n-1 then a minimum step to go to n-1 will be 0
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int min = INF;
            int boundary = Math.min(n - 1, i + nums[i]);
            for (int j = i + 1; j <= boundary; j++) {
                min = Math.min(min, dp[j]);
            }
            if (min != INF) dp[i] = min + 1;
        }
        System.out.println(dp[0]);
    }

}
