# MaximumAmountOfMoneyRobotCanEarn

**Topic:** `dp` | **File:** `com/problems/dp/MaximumAmountOfMoneyRobotCanEarn.java`

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Try to optimize it

```java
private static void type3() {
    }
```

### Approach 2

Same as brute force but using the dynamic programming approach

```java
private static void type2() {
        int[][] coins = {
                {-7, 12, 12, 13},
                {-6, 19, 19, -6},
                {9, -2, -10, 16},
                {-4, 14, -10, -9}
        };
        int ans = maximumAmount1(coins);
        System.out.println(ans);
    }
    public static int maximumAmount1(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        // The robot has a special ability to neutralize robbers in at most 2 cells on its path,
        // so we will create 3 cells for m * n each
        int[][][] dp = new int[m][n][3];
        // initializing it with the -INF
        for (int[][] g : dp) {
            for (int[] row : g) Arrays.fill(row, Integer.MIN_VALUE);
        }
        // we will start from (0,0)
        return traverse1(0, 0, 2, coins, dp);
    }
```

### Approach 1 — Brute Force

If (i,j) is out of bound then we wil return -INF if cell is already calculated then we will return that current coin on the cell if we have reached the destination then we will return the coin if coin is negative but there are some chances left then will return 0 else we will return whatever coin is there on the cell we will go down and left and find the best answer if the current coin is negative, but we have some chances left then we can skip the current coin ultimately we will return the max of profit1 and profit2 brute force using the recursion

```java
private static void type1() {
    }
```
