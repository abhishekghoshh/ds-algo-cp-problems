package com.ds.series.jumpgame;

import java.util.LinkedList;
import java.util.PriorityQueue;

/*
 *
 * problem links :
 * https://leetcode.com/problems/jump-game-vi/
 *
 * Solution link :
 * https://www.youtube.com/watch?v=LiEcBMK5PQs&list=PLJtzaiEpVo2yaP5v5bq0-QJgU0lO3TrEi&index=6
 *
 * https://github.com/Algorithms-Made-Easy/Leetcode-Challenge/blob/main/1696.%20Jump%20Game%20VI
 * */
public class JumpGame6 {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
        type4();
        type5();
    }

    private static void type5() {
        int[] nums = {10, -5, -2, 4, 0, 3};
        int k = 3;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        int maxJ = 0;
        for (int i = 1; i < n; i++) {
            int v = nums[i];
            if (maxJ < Math.max(0, i - k)) {
                max = Integer.MIN_VALUE;
                for (int j = Math.max(0, i - k); j < i; j++) {
                    if (max <= dp[j]) {
                        max = dp[j];
                        maxJ = j;
                    }
                }
            }
            dp[i] = max + v;
            if (dp[i] >= max) {
                max = dp[i];
                maxJ = i;
            }
        }
        System.out.println(dp[n - 1]);
    }

    private static void type4() {
        int[] nums = {10, -5, -2, 4, 0, 3};
        int k = 3;
        int n = nums.length, wStart = 0, wEnd = 0, tmp = wStart;
        int[] idx = new int[n];
        idx[0] = 0;
        for (int i = 1; i < n; i++) {
            nums[i] = nums[i] + nums[wStart];
            while (wEnd >= wStart && nums[i] >= nums[wEnd]) {
                idx[wEnd] = i;
                nums[wEnd--] = nums[i];
            }
            nums[++wEnd] = nums[i];
            idx[wEnd] = i;
            if ((wEnd - wStart + 1) > k || idx[wStart] <= (i - k))
                wStart++;
        }
        System.out.println(nums[wEnd]);
    }

    private static void type3() {
        int[] nums = {10, -5, -2, 4, 0, 3};
        int k = 3;
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0);
        for (int i = 1; i < n; i++) {
            if (linkedList.getFirst() < i - k)
                linkedList.removeFirst();
            sum[i] = nums[i] + sum[linkedList.getFirst()];
            while (!linkedList.isEmpty() && sum[linkedList.getLast()] < sum[i])
                linkedList.removeLast();
            linkedList.add(i);
        }
        System.out.println(sum[n - 1]);
    }

    private static void type2() {
        int[] nums = {10, -5, -2, 4, 0, 3};
        int k = 3;
        int n = nums.length;
        int max = nums[0];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        maxHeap.offer(new int[]{0, nums[0]});
        for (int i = 1; i < n; i++) {
            while (!maxHeap.isEmpty() && i - maxHeap.peek()[0] > k)
                maxHeap.poll();
            if (maxHeap.isEmpty()) return;
            int[] top = maxHeap.peek();
            max = nums[i] + top[1];
            maxHeap.offer(new int[]{i, max});
        }
        System.out.println(max);
    }

    private static void type1() {
        int[] nums = {10, -5, -2, 4, 0, 3};
        int k = 3;
        int n = nums.length;
        int[] memo = new int[n];
        memo[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int border = Math.max(i - k, 0);
            int tempMax = Integer.MIN_VALUE;
            for (int j = i - 1; j >= border; j--)
                tempMax = Math.max(tempMax, memo[j]);
            memo[i] = nums[i] + tempMax;
        }
        System.out.println(memo[n - 1]);
    }

    private static void print(int... nums) {
        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();
    }
}
