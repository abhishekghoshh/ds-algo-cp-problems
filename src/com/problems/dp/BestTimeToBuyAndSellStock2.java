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
        type3();
        type4();
        type5();
        type6();
    }

    // same as previous, we will use 4 variables instead of arrays
    private static void type6() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int n = prices.length;
        // we will add another day as it was a boundary case in recursion
        int nextBuy = 0, nextSell = 0, currBuy, currSell;
        // we do not need to initiate for the nth day, as the default value of the int array is
        for (int day = n - 1; day >= 0; day--) {
            // we can either buy or skip for that day
            currBuy = Math.max(-prices[day] + nextSell, nextBuy);
            // else means we can sell on that day
            // we can either sell or we can also check for the next day
            currSell = Math.max(prices[day] + nextBuy, nextSell);
            // update the variables
            nextBuy = currBuy;
            nextSell = currSell;
        }
        // the answer is on dp[0][0] for the first day, and the time is to buy
        int ans = nextBuy;
        System.out.println(ans);
    }

    // same as previous just here we will not use the inner loop of canBuy
    // we will directly use curr[0] and curr[1]
    // we can also use two variables directly to store current and previous buy and sell
    private static void type5() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int n = prices.length;
        // we will add another day as it was a boundary case in recursion
        int[] next = new int[2];
        // we do not need to initiate for the nth day, as the default value of the int array is
        for (int day = n - 1; day >= 0; day--) {
            int[] curr = new int[2];
            // we can either buy or skip for that day
            curr[0] = Math.max(-prices[day] + next[1], next[0]);
            // else means we can sell on that day
            // we can either sell or we can also check for the next day
            curr[1] = Math.max(prices[day] + next[0], next[1]);
            next = curr;
        }
        // the answer is on dp[0][0] for the first day, and the time is to buy
        int ans = next[0];
        System.out.println(ans);
    }

    // top-down approach
    // or iterative approach with tabulation
    // with space optimization
    // time complexity is O(2n)
    // everytime we are creating the array with 2 cells.
    // we could also use either System.arrayCopy or use 4 variables instead
    // TODO we can skip the internal canBuy loop and just add that two lines one after another
    //  curr[0] = ...... and curr[1] = .....
    private static void type4() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int n = prices.length;
        // we will add another day as it was a boundary case in recursion
        int[] next = new int[2];
        // we do not need to initiate for the nth day, as the default value of the int array is
        for (int day = n - 1; day >= 0; day--) {
            int[] curr = new int[2];
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                if (canBuy == 0) {
                    // we can either buy or skip for that day
                    curr[canBuy] = Math.max(-prices[day] + next[1], next[0]);
                } else {
                    // else means we can sell on that day
                    // we can either sell or we can also check for the next day
                    curr[canBuy] = Math.max(prices[day] + next[0], next[1]);
                }
            }
            next = curr;
        }
        // the answer is on dp[0][0] for the first day, and the time is to buy
        int ans = next[0];
        System.out.println(ans);
    }

    // top-down approach
    // or iterative approach with tabulation
    // TODO we can skip the internal canBuy loop and just add that two lines one after another
    //  dp[day][0] = ...... and dp[day][1] = .....
    private static void type3() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int n = prices.length;
        // we will add another day as it was a boundary case in recursion
        int[][] dp = new int[n + 1][2];
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
                            prices[day] + dp[day + 1][0],
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
    // lets not use a boolean value for canBuy
    // let's use 0,1 values for canBuy
    // 0 for can buy and 1 for can sell
    private static void type1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] row : dp) Arrays.fill(row, -1);
        int ans = maxProfit2(0, 0, prices, dp);
        System.out.println(ans);
    }

    public static int maxProfit2(int day, int canBuy, int[] prices, int[][] dp) {
        // checking if it is out of bounds or not
        if (day == prices.length) return 0;
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
            // we can either sell or we can also check for the next day
            return dp[day][canBuy] = Math.max(
                    prices[day] + maxProfit2(day + 1, 0, prices, dp),
                    maxProfit2(day + 1, 1, prices, dp)
            );
        }
    }

    // recursion brute force
    // we have 2 choices for every index,
    // 1. either to buy or sell on that day
    // 2. skip the current day
    // we will use a boolean variable to check if stock can be bought on that day.
    // if we can buy, then we will subtract the price and if we could sell then we will add the price
    private static void type2() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int ans = maxProfit1(0, true, prices);
        System.out.println(ans);
    }

    public static int maxProfit1(int day, boolean canBuy, int[] prices) {
        // checking if it is out of bounds or not
        if (day == prices.length) return 0;
        // true means we can buy on that day
        if (canBuy) {
            // we can either buy or skip for that day
            return Math.max(
                    -prices[day] + maxProfit1(day + 1, false, prices),
                    maxProfit1(day + 1, true, prices)
            );
        } else {
            // else means we can sell on that day
            // we can either sell or we can also check for the next day
            return Math.max(
                    prices[day] + maxProfit1(day + 1, true, prices),
                    maxProfit1(day + 1, false, prices)
            );
        }
    }
}
