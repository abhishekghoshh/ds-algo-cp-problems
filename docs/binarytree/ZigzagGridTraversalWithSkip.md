# ZigzagGridTraversalWithSkip

**Topic:** `binarytree` | **File:** `com/problems/binarytree/ZigzagGridTraversalWithSkip.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/zigzag-grid-traversal-with-skip/description/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Using iteration same as previous

```java
private static void type2() {
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> ans = zigzagTraversal2(grid);
        System.out.println(ans);
    }
    private static List<Integer> zigzagTraversal2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < m; i++) {
            int j = start;
            // if it is even row then we will go left to right, if it is red then we will go right to left
            if ((i % 2) == 0) {
                // from left to right
                while (j < n) {
                    ans.add(grid[i][j]);
                    j += 2;
                }
                if (j == n) start = n - 1;
                else start = n - 2;
            } else {
                // from right to left
                while (j >= 0) {
                    ans.add(grid[i][j]);
                    j -= 2;
                }
                if (j == -1) start = 0;
                else start = 1;
            }
        }
        return ans;
    }
```

### Approach 1 — Brute Force

Discuss this in the interview using recursion if it is even row then we will go left to right, if it is red then we will go right to left

```java
private static void type1() {
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> ans = zigzagTraversal1(grid);
        System.out.println(ans);
    }
    public static List<Integer> zigzagTraversal1(int[][] grid) {
        List<Integer> ans = new ArrayList<>();
        traverse(0, 0, grid, ans);
        return ans;
    }
```
