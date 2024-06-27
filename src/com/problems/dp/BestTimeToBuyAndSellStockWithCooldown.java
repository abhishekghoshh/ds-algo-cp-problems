package com.problems.dp;

import java.util.Arrays;

/*
 * Problem link :
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 * https://www.naukri.com/code360/problems/highway-billboards_3125969
 *
 * Solution link :
 * https://www.youtube.com/watch?v=IGIe46xw3YY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=41
 *
 * https://takeuforward.org/data-structure/buy-and-sell-stocks-with-cooldown-dp-39/
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    // This is exactly like the best time for buy and sell problem 2.
    // However, we have to go for i+2 after a successful sell, as there is a cooldown period
    // that is the only change that we need to do for this problem
    // TODO if you are unable to understand the intuition then check buy and sell problem 2
    public static void main(String[] args) {
        type1();
        type2();
        type3();
        type4();
        // check the leetcode's top solution
    }

    // tabulation or top-down approach
    // without the inner CanBuy loop
    // as we are going to day+2, so it will be a little bit complex to do the space optimization
    private static void type4() {
        int[] prices = {1, 2, 3, 0, 2};
        int n = prices.length;
        // we will add another day as it was a boundary case in recursion
        // as the day can go to day+2, so we are changing the row size to n+2
        int[][] dp = new int[n + 2][2];
        dp[n][0] = dp[n][1] = 0;
        for (int day = n - 1; day >= 0; day--) {
            // we can either buy or skip for that day
            dp[day][0] = Math.max(
                    -prices[day] + dp[day + 1][1],
                    dp[day + 1][0]
            );
            // else means we can sell on that day
            // we can either sell or we can also check for the next day
            dp[day][1] = Math.max(
                    prices[day] + dp[day + 2][0],
                    dp[day + 1][1]
            );
        }
        // the answer is on dp[0][0] for the first day, and the time is to buy
        int ans = dp[0][0];
        System.out.println(ans);
    }

    // tabulation or top-down approach
    private static void type3() {
        int[] prices = {1, 2, 3, 0, 2};
        int n = prices.length;
        // we will add another day as it was a boundary case in recursion
        // as the day can go to day+2, so we are changing the row size to n+2
        int[][] dp = new int[n + 2][2];
        dp[n][0] = dp[n][1] = 0;
        for (int day = n - 1; day >= 0; day--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                if (canBuy == 0) {
                    // we can either buy or skip for that day
                    dp[day][canBuy] = Math.max(
                            -prices[day] + dp[day + 1][1],
                            dp[day + 1][0]
                    );
                } else {
                    // else means we can sell on that day
                    // we can either sell or we can also check for the next day
                    dp[day][canBuy] = Math.max(
                            prices[day] + dp[day + 2][0],
                            dp[day + 1][1]
                    );
                }
            }
        }
        // the answer is on dp[0][0] for the first day, and the time is to buy
        int ans = dp[0][0];
        System.out.println(ans);
    }

    // recursion with memoization
    private static void type2() {
        int[] prices = {1, 2, 3, 0, 2};
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] row : dp) Arrays.fill(row, -1);
        int ans = maxProfit2(0, 0, prices, dp);
        System.out.println(ans);
    }

    public static int maxProfit2(int day, int canBuy, int[] prices, int[][] dp) {
        // checking if it is out of bounds or not
        if (day >= prices.length) return 0;
        if (dp[day][canBuy] != -1) return dp[day][canBuy];
        // true means we can buy on that day
        if (canBuy == 0) {
            // we can either buy or skip for that day
            return dp[day][canBuy] = Math.max(
                    -prices[day] + maxProfit2(day + 1, 1, prices, dp),
                    maxProfit2(day + 1, 0, prices, dp)
            );
        } else {
            // else means we can sell on that day
            // we can either sell or we can also check for the next to next day
            // as there is a cooldown period
            return dp[day][canBuy] = Math.max(
                    prices[day] + maxProfit2(day + 2, 0, prices, dp),
                    maxProfit2(day + 1, 1, prices, dp)
            );
        }
    }

    // recursion with brute force
    private static void type1() {
        int[] prices = {1, 2, 3, 0, 2};
        int ans = maxProfit1(0, true, prices);
        System.out.println(ans);
    }

    public static int maxProfit1(int day, boolean canBuy, int[] prices) {
        // checking if it is out of bounds or not
        // as we are going to day+2 so the index can be n+1, so we are changing it to >=
        if (day >= prices.length) return 0;
        // true means we can buy on that day
        if (canBuy) {
            // we can either buy or skip for that day
            return Math.max(
                    -prices[day] + maxProfit1(day + 1, false, prices),
                    maxProfit1(day + 1, true, prices)
            );
        } else {
            // else means we can sell on that day
            // we can either sell or we can also check for the next to next day
            // as there is a cooldown period
            return Math.max(
                    prices[day] + maxProfit1(day + 2, true, prices),
                    maxProfit1(day + 1, false, prices)
            );
        }
    }
}
