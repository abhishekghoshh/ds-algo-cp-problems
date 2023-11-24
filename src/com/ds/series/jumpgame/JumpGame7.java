package com.ds.series.jumpgame;

/*
 *
 * problem links :
 * https://leetcode.com/problems/jump-game-vii/
 *
 * Solution link :
 * https://www.youtube.com/watch?v=bZxWLuiqHes&list=PLJtzaiEpVo2yaP5v5bq0-QJgU0lO3TrEi&index=7
 *
 * https://github.com/Algorithms-Made-Easy/Leetcode-Challenge/blob/main/1871.%20Jump%20Game%20VII
 * */
public class JumpGame7 {
    public static void main(String[] args) {
        type1();
    }

    private static void type1() {
        String s = "011010000011110000";
        int minJump = 4;
        int maxJump = 7;
        boolean result = canReach1(s, minJump, maxJump);
        System.out.println(result);
    }

    public static boolean canReach1(String s, int minJump, int maxJump) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        boolean[] dp = new boolean[n];
        if (ch[0] != '0') return false;
        dp[0] = true;
        int reachable = 0;
        for (int i = 1; i < n; i++) {
            if (i >= minJump)
                reachable += dp[i - minJump] ? 1 : 0;
            if (i > maxJump)
                reachable -= dp[i - maxJump - 1] ? 1 : 0;
            dp[i] = reachable > 0 && ch[i] == '0';
        }
        return dp[n - 1];
    }
}
