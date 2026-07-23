# CountPathsWithTheGivenXORValue

**Topic:** `dp` | **File:** `com/problems/dp/CountPathsWithTheGivenXORValue.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/count-paths-with-the-given-xor-value/description/)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Same as before top-down approach with the same dp table for every cell, we will go to its right and down and calculate new xor. and check if the new xor is already calculated or not if yes then get the count else take 0 and add the count for the previous

```java
private static void type3() {
        int[][] grid = {};
        int k = 11;
        int ans = countPathsWithXorValue3(grid, k);
        System.out.println(ans);
    }
```

### Approach 2

Create a DP table where each cell contains a HashMap for XOR values Initialize the DP table Starting point Fill the DP table Move right Move down The result is the number of paths that reach the bottom-right corner with XOR equal to k same as before, but here we will use dynamic programming before creating and 2D array or map let's see what we need, actually. so there are (m*n) cells, and we can visit any cell in multiple possible ways, and all those ways will generate different xor values for that cell. so even for a single cell, there will be different xor and their total path counts. so in each cell we will create a map

```java
private static void type2() {
        int[][] grid = {{1, 3, 3, 3}, {0, 3, 3, 2}, {3, 0, 1, 1}};
        int k = 2;
        int ans = countPathsWithXorValue2(grid, k);
        System.out.println(ans);
    }
    public static int countPathsWithXorValue2(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        // m*n cells have their individual maps
        Map<Integer, Integer>[][] dp = new Map[m][n];
        return countPathsWithXorValue(m - 1, n - 1, grid, k, 0, dp);
    }
```

### Approach 1 — Brute Force

Calculating the xor value if there is a map for the current cell and xor value is present in that map, then we will return from that if we have reached to (0,0) and the xor value is k, then we will return 1 else 0 else we will go to the left or go up if the cell is not initialized, then we will initialize and then put the current xor and count value brute force approach using normal recursion rather starting from the (0,0) we will start from we will start from the (m-1,n-1) and go till (0,0)

```java
private static void type1() {
        int[][] grid = {{1, 3, 3, 3}, {0, 3, 3, 2}, {3, 0, 1, 1}};
        int k = 2;
        int ans = countPathsWithXorValue1(grid, k);
        System.out.println(ans);
    }
    public static int countPathsWithXorValue1(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        Map<Integer, Integer>[][] dp = new Map[m][n];
        return countPathsWithXorValue(m - 1, n - 1, grid, k, 0);
    }
```
