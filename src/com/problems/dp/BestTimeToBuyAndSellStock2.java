package com.problems.dp;

import java.util.Arrays;

/*
 * Problem link :
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * https://www.naukri.com/code360/problems/selling-stock_630282
 *
 * Solution link :
 * https://www.youtube.com/watch?v=nGJmxkUJQGs&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=37
 *
 * https://takeuforward.org/data-structure/buy-and-sell-stock-ii-dp-36/
 */
public class BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        type1();
        type2();
    }

    // TODO this is my own solution
    //  but it is getting memory overflow error
    // it is passing
    private static void type2() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int n = prices.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        int answer = maxProfit2(0, 1, n, prices, dp);
        System.out.println(answer);
    }

    public static int maxProfit2(int prev, int i, int n, int[] prices, int[][] dp) {
        if (prev >= n || i >= n) return 0;
        if (dp[prev][i] != -1) return dp[prev][i];
        int profit;
        if (prices[prev] > prices[i])
            profit = maxProfit2(i, i + 1, n, prices, dp);
        else
            profit = Math.max(
                    prices[i] - prices[prev] + maxProfit2(i + 1, i + 2, n, prices, dp),
                    maxProfit2(prev, i + 1, n, prices, dp)
            );
        return dp[prev][i] = profit;
    }

    // using recursion
    private static void type1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int n = prices.length;
        int answer = maxProfit1(0, 1, n, prices);
        System.out.println(answer);
    }

    public static int maxProfit1(int prev, int i, int n, int[] prices) {
        if (prev >= n || i >= n) return 0;
        if (prices[prev] > prices[i]) return maxProfit1(i, i + 1, n, prices);
        return Math.max(
                prices[i] - prices[prev] + maxProfit1(i + 1, i + 2, n, prices),
                maxProfit1(prev, i + 1, n, prices)
        );
    }
}
