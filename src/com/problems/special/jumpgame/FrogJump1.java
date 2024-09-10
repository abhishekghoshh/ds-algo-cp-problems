package com.problems.special.jumpgame;

import java.util.*;

/*
 *
 * problem links :
 * https://leetcode.com/problems/frog-jump/
 *
 * Solution link :
 * https://www.youtube.com/watch?v=3FYCPlIx3YA&list=PLJtzaiEpVo2yaP5v5bq0-QJgU0lO3TrEi&index=8
 *
 * https://github.com/Algorithms-Made-Easy/Leetcode-Challenge/blob/main/403.%20Frog%20Jump
 * */
public class FrogJump1 {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
        type4();
    }

    static int[] delta = {1, 0, -1};

    // here also we are using dynamic programming
    private static void type4() {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        boolean answer = canCross4(1, 0, stones, dp);
        System.out.println(answer);
    }

    private static boolean canCross4(int start, int last, int[] stones, boolean[][] dp) {
        // if we have reached the last index then we can return true
        if (start == stones.length - 1) return true;
        // dp value is true means we have used this pair of (last,start), and it is not helping us to go to the end
        if (dp[last][start]) return false;
        // calculating the last jump that the frog had taken to reach here
        int lastJump = stones[start] - stones[last];
        int nextIndex = start + 1;
        while (nextIndex < stones.length && stones[nextIndex] <= stones[start] + lastJump + 1) {
            int nextJump = stones[nextIndex] - stones[start];
            int jump = nextJump - lastJump;
            if (jump >= -1 && jump <= 1) {
                if (canCross4(nextIndex, start, stones, dp))
                    return true;
            }
            nextIndex++;
        }
        dp[last][start] = true;
        return false;
    }

    // same as the previous,
    // we are just using
    private static void type3() {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        Map<Integer, Set<Integer>> checked = new HashMap<>();
        for (int stone : stones)
            checked.put(stone, new HashSet<>());
        boolean answer = jump(0, 1, stones[stones.length - 1], checked);
        System.out.println(answer);
    }

    private static boolean jump(int current, int k, int last, Map<Integer, Set<Integer>> checked) {
        if (current == last)
            return true;
        // skip if we have checked this k at the current stone
        if (k <= 0 || checked.get(current).contains(k))
            return false;
        int next = current + k;
        if (checked.containsKey(next)) {
            if (jump(next, k + 1, last, checked) || jump(next, k, last, checked) || jump(next, k - 1, last, checked))
                return true;
        }
        checked.get(current).add(k);
        return false;
    }

    // this is exactly like the previous one but here we will use dynamic programming
    private static void type2() {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        Set<Integer> set = new HashSet<>();
        int[] delta = {1, 0, -1};
        Map<Pair, Boolean> dp = new HashMap<>();
        for (int stone : stones) set.add(stone);
        boolean answer = canCross(1, 1, set, stones[stones.length - 1], delta, dp);
        System.out.println(answer);
    }

    // only 2 variables here is the height and the last, so we will use a hash map with the key (height,last)
    private static boolean canCross(int height, int last, Set<Integer> set, int lastHeight, int[] delta, Map<Pair, Boolean> dp) {
        // if we have reached to the final height then we can return true
        if (height == lastHeight) return true;
        // if the current height doest not exist then we will simply return false
        if (!set.contains(height)) return false;
        // checking if the pair is already exist or not
        Pair pair = new Pair(height, last);
        if (dp.containsKey(pair)) return dp.get(pair);
        // otherwise we will simply do k-1,k,k+1 jumps
        for (int d : delta) {
            if (last + d > 0 && canCross(height + last + d, last + d, set, lastHeight, delta, dp)) {
                dp.put(pair, true);
                return true;
            }
        }
        // at this point we know that we can not go to the last height with this pair of height and last
        dp.put(pair, false);
        return false;
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    // this is simple recursive approach
    // we will put all the stones in a set
    // then we will start jumping with 1 then we will do k-1,k,k+1 jumps recursively
    private static void type1() {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        Set<Integer> set = new HashSet<>();
        int[] delta = {1, 0, -1};
        for (int stone : stones) set.add(stone);
        boolean answer = canCross(1, 1, set, stones[stones.length - 1], delta);
        System.out.println(answer);
    }

    private static boolean canCross(int height, int last, Set<Integer> set, int lastHeight, int[] delta) {
        // if we have reached to the final height then we can return true
        if (height == lastHeight) return true;
        // if the current height doest not exist then we will simply return false
        if (!set.contains(height)) return false;
        // otherwise we will simply do k-1,k,k+1 jumps
        for (int d : delta)
            if (last + d > 0 && canCross(height + last + d, last + d, set, lastHeight, delta))
                return true;
        return false;
    }
}
