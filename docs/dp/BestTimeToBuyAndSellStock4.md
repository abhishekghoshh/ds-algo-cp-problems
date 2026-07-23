# BestTimeToBuyAndSellStock4

**Topic:** `dp` | **File:** `com/problems/dp/BestTimeToBuyAndSellStock4.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/best-time-to-buy-and-sell-stock_1080698)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=IV1dHbk5CDc&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=39)
- [📄 takeUforward](https://takeuforward.org/data-structure/buy-and-sell-stock-iv-dp-38/)

## Approaches

This problem has **6** approaches, progressing from brute force to optimal:

### Approach 6 — Optimal

Optimization from the striver's solution similar to the previous type space optimized version this is very optimized solution

```java
private static void type6() {
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        int n = prices.length;
        int[] next = new int[2 * k + 1];
        int[] curr = new int[2 * k + 1];
        // initialization


        // filling out all the dp cells
        for (int day = n - 1; day >= 0; day--) {

            for (int transaction = 2 * k - 1; transaction >= 0; transaction--) {
                // odd indices for buying and even for selling
                if (transaction % 2 == 0) {
                    curr[transaction] = Math.max(
                            -prices[day] + next[transaction + 1],
                            next[transaction]
                    );
                } else {
                    curr[transaction] = Math.max(
                            prices[day] + next[transaction + 1],
                            next[transaction]
                    );
                }
            }
//            next = curr;
            // assigning the current to the next for future use
            System.arraycopy(curr, 0, next, 0, 2 * k);
        }
        int ans = next[0];
        System.out.println(ans);

    }
```

### Approach 5

Check the solutions from Best time for buy and sell 3 one rows of the dp array will specify buy1, sell1, buy2, sell2,.....buy-k,sell-k if you have done ith transaction then we will find the dp value of next days i+1th transaction. transactions will spread out from 0 to 2k-1 even means you have to buy and odd means to sell

```java
private static void type5() {
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        int n = prices.length;
        int[][] dp = new int[n + 1][2 * k + 1];
        // initialization
        for (int i = 0; i <= 4; i++) dp[n][i] = 0;
        for (int i = 0; i <= n; i++) dp[i][4] = 0;

        for (int day = n - 1; day >= 0; day--) {
            for (int transaction = 2 * k - 1; transaction >= 0; transaction--) {
                // odd indices for buying and even for selling
                if (transaction % 2 == 0) {
                    dp[day][transaction] = Math.max(
                            -prices[day] + dp[day + 1][transaction + 1],
                            dp[day + 1][transaction]
                    );
                } else {
                    dp[day][transaction] = Math.max(
                            prices[day] + dp[day + 1][transaction + 1],
                            dp[day + 1][transaction]
                    );
                }
            }
        }
        int ans = dp[0][0];
        System.out.println(ans);
    }
```

### Approach 4

Top-down approach with tabulation with space optimization

```java
private static void type4() {
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        int n = prices.length;
        // transactions could have 2 values, 0 and 1, -1 means no transactions left
        // we will use 3 loops,
        int[][] next = new int[2][k + 1];

        for (int day = n - 1; day >= 0; day--) {
            int[][] curr = new int[2][k + 1];
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int transaction = 1; transaction <= k; transaction++) {
                    if (canBuy == 0) {
                        // we can either buy or skip for that day
                        curr[canBuy][transaction] = Math.max(
                                -prices[day] + next[1][transaction],
                                next[0][transaction]
                        );
                    } else {
                        // else means we can sell on that day
                        // we can either sell or we can also check for the next day
                        curr[canBuy][transaction] = Math.max(
                                prices[day] + next[0][transaction - 1],
                                next[1][transaction]
                        );
                    }
                }
            }
            next = curr;
        }
        System.out.println(next[0][k]);
    }
```

### Approach 3

Top-down approach with tabulation

```java
private static void type3() {
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        int n = prices.length;
        // transactions could have 2 values, 0 and 1, -1 means no transactions left
        // we will use 3 loops,
        int[][][] dp = new int[n + 1][2][k + 1];
        for (int day = n - 1; day >= 0; day--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++)
                for (int transaction = 1; transaction <= k; transaction++)
                    if (canBuy == 0)
                        // we can either buy or skip for that day
                        dp[day][canBuy][transaction] = Math.max(
                                -prices[day] + dp[day + 1][1][transaction],
                                dp[day + 1][0][transaction]
                        );
                    else
                        // else means we can sell on that day
                        // we can either sell or we can also check for the next day
                        dp[day][canBuy][transaction] = Math.max(
                                prices[day] + dp[day + 1][0][transaction - 1],
                                dp[day + 1][1][transaction]
                        );
        }
        System.out.println(dp[0][0][k]);
    }
```

### Approach 2

Recursion with memoization

```java
private static void type2() {
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        int ans = maxProfit2(k, prices);
        System.out.println(ans);
    }
    public static int maxProfit2(int k, int[] prices) {
        int n = prices.length;
        // transactions could have 2 values, 0 and 1, -1 means no transactions left
        int[][][] dp = new int[n][2][k];
        // initialization
        for (int[][] grid : dp)
            for (int[] row : grid) Arrays.fill(row, -1);
        return maxProfit2(0, 0, k - 1, prices, dp);
    }
```

### Approach 1 — Brute Force

Checking if it is out of bounds or not 0 means we can buy on that day we can either buy or skip for that day else means we can sell on that day we can either sell or we can also check for the next day brute force recursive solution

```java
private static void type1() {
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
    }
```
