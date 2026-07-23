# CountNegativeNumbersInSortedMatrix

**Topic:** `binarysearch` | **File:** `com/problems/binarysearch/CountNegativeNumbersInSortedMatrix.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimized approach binary search approach this problem derives inspiration from find element in row wise column wise sorted matrix as the grid is row wise and column sorted we know one that if we go from right to left it will increase we go from top to bottom it will decrease so if we find the first negative element from the top right then we know the right of it and bottom of it will always be negative then we will go diagonally

```java
private static void type2() {
        int[][] grid = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        int n = grid.length;
        int m = grid[0].length;
        int i = 0, j = m - 1;
        int negative = 0;
        while (i < n) {
            while (j >= 0 && grid[i][j] < 0)
                j--;
            negative += m - j - 1;
            i++;
        }
        System.out.println(negative);
    }
```

### Approach 1 — Brute Force

Brute force method

```java
private static void type1() {
        int[][] grid = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        int negative = 0;
        for (int[] row : grid)
            for (int num : row) negative += (num < 0 ? 1 : 0);
        System.out.println(negative);
    }
```
