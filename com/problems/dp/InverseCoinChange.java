package com.problems.dp;

/*
 * problem link:
 * https://leetcode.com/problems/inverse-coin-change/description/
 *
 * Solution link :
 *
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InverseCoinChange {
    public static void main(String[] args) {
        type1();
    }

    private static void type1() {
        int[] numWays = {0, 1, 0, 2, 0, 3, 0, 4, 0, 5};
        List<Integer> coins = findCoins(numWays);
        System.out.println(coins);
    }

    // todo this is a hard problem, need to understand the logic
    //  if you have understood the coin change problem, then this is the inverse of that
    //  this is a optimal solution, but it is not easy to understand
    public static List<Integer> findCoins(int[] numWays) {
        List<Integer> list = new ArrayList<>();
        int n = numWays.length;
        int[] dp = new int[n + 1];
        if (numWays[0] == 1) {
            list.add(1);
            Arrays.fill(dp, 1);
            dp[0] = 0;
        }
        for (int i = 1; i < n; i++) {
            int ways = numWays[i];
            int coin = i + 1;
            if (ways == 0) {
                continue;
            }
            // dp of coin means by now the coin can be formed in this many ways
            // if that number + 1 is equal to the number of ways from the numWays array
            // then the coin is also present
            if (dp[coin] + 1 == ways) {
                dp[coin]++;
                list.add(coin);
                // now we need to update the dp array for all the coins that can be formed using this coin
                for (int j = 1; j + coin <= n; j++) {
                    if (dp[j] != 0) dp[j + coin]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dp[i + 1] != numWays[i]) return new ArrayList<>();
        }
        return list;
    }
}