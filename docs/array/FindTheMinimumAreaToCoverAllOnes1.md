# FindTheMinimumAreaToCoverAllOnes1

**Topic:** `array`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i/description/)

## 📝 Problem Statement

Minimum rectangular area to cover all 1s in a grid.

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

we will try to squeeze the all 4 sides shrink the top side first shrink the left side then we will change the boundary of (i,j) accordingly shrink the bottom side then we will change the boundary of (i,j) accordingly shrink the right side then we will change the boundary of (i,j) accordingly

```java
    private static void type1() {
        int[][] grid = {{0, 1, 0}, {1, 0, 1}};
        int ans = minimumArea(grid);
        System.out.println(ans);
    }

    // we will try to squeeze the all 4 sides
    public static int minimumArea(int[][] grid) {
        int r = grid.length, c = grid[0].length;

        // shrink the top side first
        boolean flag = false;
        int top = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                if (grid[i][j] == 1) {
                    flag = true;
                    break;
                }
            if (flag) break;
            top++;
        }
        if (top == r) return 0;

        // shrink the left side then we will change the boundary of (i,j) accordingly
        int left = 0;
        flag = false;
        for (int i = 0; i < c; i++) {
            for (int j = top; j < r; j++) {
                if (grid[j][i] == 1) {
                    flag = true;
                    break;
                }
            }
            if (flag) break;
            left++;
        }
        // shrink the bottom side then we will change the boundary of (i,j) accordingly
        flag = false;
        int bottom = r - 1;
        for (int i = r - 1; i > top; i--) {
            for (int j = left; j < c; j++)
                if (grid[i][j] == 1) {
                    flag = true;
                    break;
                }
            if (flag) break;
            bottom--;
        }
        // shrink the right side then we will change the boundary of (i,j) accordingly
        flag = false;
        int right = c - 1;
        for (int i = c - 1; i > left; i--) {
            for (int j = top; j <= bottom; j++) {
                if (grid[j][i] == 1) {
                    flag = true;
                    break;
                }
            }
            if (flag) break;
            right--;
        }
        return (bottom - top + 1) * (right - left + 1);
    }
}
```
