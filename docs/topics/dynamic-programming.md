# Dynamic Programming

## Overview

**58 files** covering DP patterns: Fibonacci-style, 0/1 Knapsack, Unbounded Knapsack, LCS, LIS, DP on Stocks, Matrix Chain Multiplication, DP on squares, and DP on grids.

## Resources

- [Mastering Dynamic Programming - How to solve any interview problem](https://www.youtube.com/watch?v=Hdr64lKQ3e4)
- [Striver's DP Playlist](https://www.youtube.com/playlist?list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY)
- [Aditya Verma DP Playlist](https://www.youtube.com/playlist?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go)
- [NeetCode DP Playlist](https://www.youtube.com/playlist?list=PLot-Xpze53lcvx_tjrr_m2lgD2NsRHlNO)

## DP Identification Framework

The author's framework for recognizing when to use DP:
1. Recursive problems asking for max, min, largest, minimum, or total count
2. Choices are given
3. Overlapping sub-problems exist
4. More than one function call per recursion
5. Same function with same arguments called multiple times

## Implementation Progression Pattern

Every DP solution follows this evolution:

```
type1() → Plain recursion
type2() → Recursion + Memoization (top-down DP)
type3() → Tabulation (bottom-up DP)
type4() → Space optimization with 2 arrays
type5() → Space optimization with 1 array
type6() → Single array with reverse iteration
```

## Core DP Categories

### 1. Fibonacci & 1D DP Problems

| Problem | States |
|---------|--------|
| **Fibonacci / Tribonacci** | `dp[i] = dp[i-1] + dp[i-2]` / `dp[i] = dp[i-1] + dp[i-2] + dp[i-3]` |
| **Climbing Stairs** | `dp[i] = dp[i-1] + dp[i-2]` (steps of 1 or 2) |
| **Min Cost Climbing Stairs** | `dp[i] = cost[i] + min(dp[i-1], dp[i-2])` |
| **Frog Jump** | `dp[i] = min(dp[i-1] + abs(h[i]-h[i-1]), dp[i-2] + abs(h[i]-h[i-2]))` |
| **Frog Jump K Distances** | `dp[i] = min(dp[i-j] + abs(h[i]-h[i-j]))` for j=1..k |
| **House Robber 1** | `dp[i] = max(nums[i] + dp[i-2], dp[i-1])` |
| **House Robber 2** | Circular: do twice (skip first, skip last), take max |
| **Decode Ways** | `dp[i]` = ways to decode first i chars |
| **Ninja Training** | `dp[day][task]` = max points avoiding same task |

### 2. 0/1 Knapsack Pattern

```java
// Core recurrence: dp[i][w] for items 0..i with capacity w
if (wt[i-1] <= w)
    dp[i][w] = max(val[i-1] + dp[i-1][w - wt[i-1]], dp[i-1][w]);
else
    dp[i][w] = dp[i-1][w];

// Space optimized (1D array, reverse iteration):
for (int i = 0; i < n; i++)
    for (int w = W; w >= wt[i]; w--)
        dp[w] = Math.max(val[i] + dp[w - wt[i]], dp[w]);
```

| Problem | Variation |
|---------|-----------|
| **0/1 Knapsack** | Max value with weight constraint |
| **Print Knapsack Items** | Backtrack through dp table |
| **Subset Sum** | `dp[i][sum] = dp[i-1][sum] \|\| dp[i-1][sum - nums[i]]` |
| **Equal Sum Partition** | Subset sum with target = total/2 |
| **Count Subset Sum** | Count ways to achieve target sum |
| **Minimum Subset Sum Difference** | Find `S1-S2` minimized |
| **Target Sum** | Assign +/- to reach target → subset sum |
| **Count Partitions with Given Difference** | Subset sum variant |

### 3. Unbounded Knapsack Pattern

```java
// Each item can be used unlimited times
// Forward iteration (allows reuse):
for (int i = 0; i < n; i++)
    for (int w = wt[i]; w <= W; w++)
        dp[w] = max(val[i] + dp[w - wt[i]], dp[w]);
```

| Problem | Variation |
|---------|-----------|
| **Unbounded Knapsack** | Unlimited items |
| **Rod Cutting** | Cut rod of length n for max profit |
| **Coin Change (Max Ways)** | Count combinations to make amount |
| **Coin Change (Min Coins)** | Min coins to make amount |

### 4. Longest Common Subsequence (LCS) Pattern

```java
// Core recurrence:
if (s1[i-1] == s2[j-1])
    dp[i][j] = 1 + dp[i-1][j-1];
else
    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
```

| Problem | LCS Variation |
|---------|--------------|
| **LCS** | Standard 2-string LCS |
| **Print LCS** | Backtrack dp table |
| **Longest Common Substring** | `dp[i][j] = 1 + dp[i-1][j-1]` only when chars match |
| **Shortest Common Supersequence** | `m+n - LCS` |
| **Min Insertions/Deletions to Convert A→B** | `n+m - 2*LCS` |
| **Longest Palindromic Subsequence** | LCS of s and reverse(s) |
| **Min Deletions for Palindrome** | `n - LPS` |
| **Min Insertions for Palindrome** | `n - LPS` |
| **Longest Repeating Subsequence** | LCS with same string but i ≠ j |
| **Sequence Pattern Matching** | Is A a subsequence of B? |
| **Distinct Subsequences** | Count ways A can form B |
| **Edit Distance** | Min ops (insert/delete/replace) to convert A→B |
| **Wildcard Matching** | Regex-style matching with `?` and `*` |

### 5. DP on Grid / 2D Path Finding

```java
// Grid Unique Paths:
dp[i][j] = dp[i-1][j] + dp[i][j-1]  // right or down

// With obstacles: skip blocked cells
// Minimum Path Sum:
dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])

// Triangle:
dp[i][j] = triangle[i][j] + min(dp[i+1][j], dp[i+1][j+1])  // bottom-up

// Falling Path Sum (variable start/end):
dp[i][j] = grid[i][j] + min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1])

// Cherry Pickup 1: Two passes on grid
// Cherry Pickup 2: Two robots moving simultaneously (3D DP)
```

### 6. Longest Increasing Subsequence (LIS)

```java
// O(n²) DP approach:
dp[i] = 1;
for (int j = 0; j < i; j++)
    if (nums[j] < nums[i])
        dp[i] = max(dp[i], dp[j] + 1);
```

| Problem | Technique |
|---------|-----------|
| **LIS** | O(n²) DP or O(n log n) patience sorting |
| **Print LIS** | Backtrack with parent array |
| **Largest Divisible Subset** | LIS on sorted + divisibility |
| **Longest String Chain** | LIS with predecessor check |
| **Longest Bitonic Subsequence** | LIS from left + LIS from right |
| **Number of LIS** | Track count alongside length |
| **Max Sum Increasing Subsequence** | Sum instead of length |

### 7. DP on Stocks

6 problems covering buying and selling with increasing constraints:

```java
// Best Time to Buy and Sell Stock 1: One transaction
maxProfit = max(0, price[i] - minSoFar)

// Stock 2: Unlimited transactions
profit = sum of all positive differences (price[i] - price[i-1])

// Stock 3: At most 2 transactions
dp[k][i] = max(dp[k][i-1], price[i] + max(dp[k-1][j] - price[j]))

// Stock 4: At most K transactions (generalized Stock 3)

// With Cooldown: Cannot buy day after sell
dp[i][0] = max(dp[i-1][0], dp[i-1][1] + price[i])  // sell
dp[i][1] = max(dp[i-1][1], dp[i-2][0] - price[i])  // buy

// With Transaction Fee: Subtract fee on sell
```

### 8. Matrix Chain Multiplication (MCM)

```java
// Core pattern: Partition DP
for (int len = 2; len <= n; len++)
    for (int i = 0; i + len - 1 < n; i++)
        int j = i + len - 1;
        for (int k = i; k < j; k++)
            dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j] + cost);
```

| Problem | Cost Function |
|---------|--------------|
| **MCM** | `arr[i-1] * arr[k] * arr[j]` |
| **Min Cost to Cut Stick** | `cuts[j+1] - cuts[i-1]` |
| **Burst Balloons** | `nums[i-1] * nums[k] * nums[j+1]` |
| **Palindrome Partitioning** | `0` if palindrome else `1 + dp[i][k] + dp[k+1][j]` |
| **Partition Array for Max Sum** | `maxInPartition * partitionLength + dp[]` |
| **Evaluate Expression to True** | Count ways to parenthesize to true/false |
| **Scrambled String** | Check if one string is scrambled version of another |
| **Egg Dropping** | Min attempts to find critical floor |

### 9. DP on Squares

| Problem | Approach |
|---------|----------|
| **Maximal Rectangle** | Maximum area of histogram per row (uses stack) |
| **Count Square Submatrices with All 1s** | `dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1` |
| **Count Submatrices with Equal X & Y** | 2D prefix sums |

### 10. Other Notable Problems

| Problem | Approach |
|---------|----------|
| **Word Break** | `dp[i]` = can segment prefix of length i |
| **Champagne Tower** | Simulate flow through pascal-like pyramid |
| **Inverse Coin Change** | Unique variant |
| **Count Substrings Divisible by Last Digit** | Modular DP |
| **Longest Palindrome After Substring Concatenation** | Palindrome + substring DP |
| **Sum of Good Subsequences** | DP with inclusion/exclusion |
