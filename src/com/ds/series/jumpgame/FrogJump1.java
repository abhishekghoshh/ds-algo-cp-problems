package com.ds.series.jumpgame;

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

    private static void type4() {
        int[] stones = getStones();
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        boolean answer = helper(stones, 0, 1, dp);
        System.out.println(answer);
    }

    private static boolean helper(int[] stones, int lastIndex, int currentIndex, boolean[][] dp) {
        if (currentIndex == stones.length - 1)
            return true;
        if (dp[lastIndex][currentIndex])
            return false;
        int lastJump = stones[currentIndex] - stones[lastIndex];
        int nextIndex = currentIndex + 1;
        while (nextIndex < stones.length && stones[nextIndex] <= stones[currentIndex] + lastJump + 1) {
            int nextJump = stones[nextIndex] - stones[currentIndex];
            int jump = nextJump - lastJump;
            if (jump >= -1 && jump <= 1) {
                if (helper(stones, currentIndex, nextIndex, dp))
                    return true;
            }
            nextIndex++;
        }
        dp[lastIndex][currentIndex] = true;
        return false;
    }

    // same as the previous,
    // we are just using
    private static void type3() {
        int[] stones = getStones();
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

    static int count = 0;

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

    private static void type2() {
        int[] stones = getStones();
        Set<Integer> set = new HashSet<>();
        int[] delta = {1, 0, -1};
        Map<Pair, Boolean> memo = new HashMap<>();
        for (int stone : stones)
            set.add(stone);
        boolean answer = canCross(1, 1, set, stones[stones.length - 1], delta, memo);
        System.out.println(answer);
    }

    private static int[] getStones() {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
                18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35,
                36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53,
                54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72,
                73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91,
                92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108,
                109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123,
                124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138,
                139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153,
                154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168};
    }

    private static boolean canCross(int currentHeight, int last, Set<Integer> set, int finalHeight, int[] delta, Map<Pair, Boolean> memo) {
        Pair pair = new Pair(currentHeight, last);
        if (currentHeight == finalHeight)
            return true;
        if (!set.contains(currentHeight))
            return false;
        if (memo.containsKey(pair))
            return memo.get(pair);
        for (int d : delta) {
            if (last + d > 0 && canCross(currentHeight + last + d, last + d, set, finalHeight, delta, memo)) {
                memo.put(pair, true);
                return true;
            }
        }
        memo.put(pair, false);
        return false;
    }

    private static void type1() {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        Set<Integer> set = new HashSet<>();
        int[] delta = {1, 0, -1};
        for (int stone : stones)
            set.add(stone);
        boolean answer = canCross(1, 1, set, stones[stones.length - 1], delta);
        System.out.println(answer);
    }

    private static boolean canCross(int currentHeight, int last, Set<Integer> set, int finalHeight, int[] delta) {
        if (currentHeight == finalHeight)
            return true;
        if (!set.contains(currentHeight))
            return false;
        for (int d : delta)
            if (last + d > 0 && canCross(currentHeight + last + d, last + d, set, finalHeight, delta))
                return true;
        return false;
    }
}
