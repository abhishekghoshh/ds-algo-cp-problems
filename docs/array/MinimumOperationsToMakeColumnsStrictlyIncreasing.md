# MinimumOperationsToMakeColumnsStrictlyIncreasing

**Topic:** `array` | **File:** `com/problems/array/MinimumOperationsToMakeColumnsStrictlyIncreasing.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/minimum-operations-to-make-columns-strictly-increasing/submissions/1491257200/)

## Approaches

Implementation:

### Implementation

Brute force approach

```java
private static void type1() {
        int[][] grid = {
                {3, 2, 1},
                {2, 1, 0},
                {1, 2, 3}
        };
        int ans = minimumOperations(grid);
        System.out.println(ans);
    }
    public static int minimumOperations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                int prev = (i > 0) ? grid[i - 1][j] : -1;
                int curr = grid[i][j];
                if (prev >= curr) {
                    int diff = prev - curr;
                    int op = diff + 1;
                    total += op;
                    grid[i][j] += op;
                }
            }
        }
        return total;
    }
```
