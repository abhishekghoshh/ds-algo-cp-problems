# CherryPickup2

**Topic:** `dp` | **File:** `com/problems/dp/CherryPickup2.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/cherry-pickup-ii/description/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/ninja-and-his-friends_3125885)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/chocolates-pickup/1)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=QGfn7JeXK54&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=14)
- [▶ YouTube](https://www.youtube.com/watch?v=c1stwk2TbNk)
- [📄 takeUforward](https://takeuforward.org/data-structure/3-d-dp-ninja-and-his-friends-dp-13/)

## Approaches

This problem has **4** approaches, progressing from brute force to optimal:

### Approach 4 — Optimal

Do not go for more optimization, waste of effort and time see leetcode submission for better solutions

```java
private static void type4() {
    }
```

### Approach 3

Check it later better go with the recursive solution tabulation or the bottom-up approach

```java
private static void type3() {
        int[][] grid = {
                {2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}
        };
        int r = 3, c = 4;

        int[][][] dp = new int[r][c][c];



        // Initialize the dp array with values from the last row of the grid
        for (int j1 = 0; j1 < c; j1++) {
            for (int j2 = 0; j2 < c; j2++) {
                dp[r - 1][j1][j2] = (j1 == j2) ?
                        grid[r - 1][j1] :
                        (grid[r - 1][j1] + grid[r - 1][j2]);
            }
        }

        // it will be convenient to start loop from the last row,
        // then we can use the same relation as recursion
        // Outer nested loops to traverse the DP array from the second last row to the first row
        for (int i = r - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < c; j1++) {
                for (int j2 = 0; j2 < c; j2++) {
                    int max = Integer.MIN_VALUE;
                    int chocolate = (j1 == j2) ? grid[i][j1] : (grid[i][j1] + grid[i][j2]);
                    // Inner nested loops to try out 9 options
                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {
                            // Check if the indices are valid
                            if ((j1 + d1 < 0 || j1 + d1 >= c) || (j2 + d2 < 0 || j2 + d2 >= c)) continue;
                            // Update maxi with the maximum result
                            max = Math.max(max, dp[i + 1][j1 + d1][j2 + d2]);
                        }
                    }
                    // Store the result in the dp array
                    dp[i][j1][j2] = chocolate + max;
                }
            }
        }

        // The final result is stored at the top row (first row) of the dp array
        int answer = dp[0][0][c - 1];
        System.out.println(answer);
    }
```

### Approach 2

Exactly like the previous type recursion with memoization

```java
private static void type2() {
        int[][] grid = {
                {2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}
        };
        int answer = cherryPickup2(grid);
        System.out.println(answer);
    }
    private static int cherryPickup2(int[][] grid) {
        int r = 3, c = 4;
        // the first bot will start from (0,0), and the second one will start from (0,c-1)
        // but as bot bots are going in the same pace in row wise,
        // so we can just keep one (i) and j1 and j2

        // we could also use Integer[] in place of int[], then we do not need to initialize -1
        // we could just check if it is null or not
        // we will use 3D array for storing results, as we are using i,j1,j2
        int[][][] dp = new int[r][c][c];
        for (int[][] dp1 : dp) for (int[] row : dp1) Arrays.fill(row, -1);

        return maximumChocolates2(0, 0, c - 1, r, c, grid, dp);
    }
    public static int maximumChocolates2(int i, int j1, int j2, int r, int c, int[][] grid, int[][][] dp) {
        // if any bot is out of boundary, then we will return INT_MIN
        if (j1 < 0 || j1 >= c || j2 < 0 || j2 >= c) return Integer.MIN_VALUE;

        // checking if the cell is already calculated or not
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        // we will check if both the bots are in the same cell or not
        // if same then we will just take once else we will take the twice
        int chocolate = (j1 == j2) ? grid[i][j1] : (grid[i][j1] + grid[i][j2]);
        // if it is the last row, then it is the base case
        if (i == r - 1) return chocolate;

        // otherwise, we have 3 options for both, which makes it 3*3 = 9 options all together
        // -1,0,+1 for both,
        // so we will check for all the options and take the max
        int max = Integer.MIN_VALUE;
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int temp = maximumChocolates2(i + 1, j1 + d1, j2 + d2, r, c, grid, dp);
                max = Math.max(max, temp);
            }
        }
        // saving the answer before returning
        return dp[i][j1][j2] = chocolate + max;
    }
```

### Approach 1 — Brute Force

Brute solution with recursion the main thing here is to construct the recurrence relation

```java
private static void type1() {
        int[][] grid = {
                {2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}
        };
        int answer = cherryPickup1(grid);
        System.out.println(answer);
    }
    private static int cherryPickup1(int[][] grid) {
        int r = 3, c = 4;
        // the first bot will start from (0,0), and the second one will start from (0,c-1)
        // but as bot bots are going in the same pace in row wise,
        // so we can just keep one (i) and j1 and j2
        return maximumChocolates1(0, 0, c - 1, r, c, grid);
    }
    public static int maximumChocolates1(int i, int j1, int j2, int r, int c, int[][] grid) {
        // if any bot is out of boundary, then we will return INT_MIN
        if (j1 < 0 || j1 >= c || j2 < 0 || j2 >= c) return Integer.MIN_VALUE;
        // we will check if both the bots are in the same cell or not
        // if same then we will just take once else we will take the twice
        int chocolate = (j1 == j2) ? grid[i][j1] : (grid[i][j1] + grid[i][j2]);
        // if it is the last row, then it is the base case
        if (i == r - 1) return chocolate;

        // otherwise, we have 3 options for both, which makes it 3*3 = 9 options all together
        // -1,0,+1 for both,
        // so we will check for all the options and take the max
        int max = Integer.MIN_VALUE;
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int chocolates = maximumChocolates1(i + 1, j1 + d1, j2 + d2, r, c, grid);
                max = Math.max(max, chocolates);
            }
        }
        return chocolate + max;
    }
```
