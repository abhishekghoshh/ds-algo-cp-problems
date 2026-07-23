# PacificAtlanticWaterFlow

**Topic:** `graph`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/pacific-atlantic-water-flow/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=krL3r7MY7Dc)
- [▶ YouTube](https://www.youtube.com/watch?v=s-VkcjHqkGI)
- [https://github.com/Algorithms-Made-Easy/March-Leetcoding-Challenge/blob/main/25.%20Pacific%20Atlantic%20Water%20Flow](https://github.com/Algorithms-Made-Easy/March-Leetcoding-Challenge/blob/main/25.%20Pacific%20Atlantic%20Water%20Flow)

## 📝 Problem Statement

Given an m x n matrix of heights, return cells from which water can flow to both the Pacific and Atlantic oceans.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

we know that on top and left there is one ocean and on the right there is another and the bordering cell can go to the ocean directly, so if we do it separately, check if bordering top and left cell can go to the other ocean and save the cells and similarly from bottom and right if we can go to the other cell and save the cells we can use either, so our common cell will be the answer DFS from last from first and last row dfs from first and last column if both are true, that means we can reach both seas from that point

```java
    private static void type2() {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        List<List<Integer>> ans = pacificAtlantic2(heights);
        System.out.println(ans);
    }

    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static List<List<Integer>> pacificAtlantic2(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        if (m == 1 && n == 1) return List.of(List.of(0, 0));

        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // DFS from last from first and last row
        for (int i = 0; i < n; i++) {
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific);
            dfs(heights, m - 1, i, Integer.MIN_VALUE, atlantic);
        }
        // dfs from first and last column
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, n - 1, Integer.MIN_VALUE, atlantic);
        }
        // if both are true, that means we can reach both seas from that point
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    public static void dfs(int[][] heights, int r, int c, int prevHeight, boolean[][] visited) {
        int m = heights.length, n = heights[0].length;
        if (isOutOfBound(r, c, m, n)) return;
        if (heights[r][c] < prevHeight || visited[r][c]) return;
        visited[r][c] = true;
        for (int[] delta : dir) {
            int x = r + delta[0];
            int y = c + delta[1];
            dfs(heights, x, y, heights[r][c], visited);
        }

    }
```

### Approach 1: 🔨 Brute Force

check why the brute force is failing brute force for all cells in the grid we will start the dfs if the cell can reach both, then we will add that to our ans If both flags are true, add in the result we have reached the atlantic ocean checking if the cell is out of bounds, or visited or greater than the previous height or not then we will return false Call DFS in all 4 Directions unsetting the mark we have reached the pacific ocean checking if the cell is out of bounds, or visited or greater than the previous height or not, marking that the cell is visited

```java
    private static void type1() {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        List<List<Integer>> ans = pacificAtlantic1(heights);
        System.out.println(ans);
    }

    public static List<List<Integer>> pacificAtlantic1(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        if (m == 1 && n == 1) return List.of(List.of(0, 0));
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //If both flags are true, add in the result
                if (reachPacific(i, j, heights, Integer.MAX_VALUE)
                        && reachAtlantic(i, j, heights, Integer.MAX_VALUE)) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    static boolean reachPacific(int r, int c, int[][] heights, int prevHeight) {
        int m = heights.length, n = heights[0].length;
        // we have reached the atlantic ocean
        if (r == 0 || c == 0) return true;
        // checking if the cell is out of bounds, or visited or greater than the previous height or not
        // then we will return false
        if (isOutOfBound(r, c, m, n) || heights[r][c] == -1 || heights[r][c] > prevHeight) return false;
        int height = heights[r][c];
        //Call DFS in all 4 Directions
        heights[r][c] = -1;
        boolean isPossible = reachPacific(r - 1, c, heights, height)
                || reachPacific(r, c - 1, heights, height)
                || reachPacific(r, c + 1, heights, height)
                || reachPacific(r + 1, c, heights, height);
        // unsetting the mark
        heights[r][c] = height;
        return isPossible;
    }


    static boolean reachAtlantic(int r, int c, int[][] heights, int prevHeight) {
        int m = heights.length, n = heights[0].length;
        // we have reached the pacific ocean
        if (r == m - 1 || c == n - 1) return true;
        // checking if the cell is out of bounds, or visited or greater than the previous height or not,
        // then we will return false
        if (isOutOfBound(r, c, m, n) || heights[r][c] == -1 || heights[r][c] > prevHeight) return false;
        int height = heights[r][c];
        // marking that the cell is visited
        heights[r][c] = -1;
        //Call DFS in all 4 Directions
        boolean isPossible = reachAtlantic(r + 1, c, heights, height)
                || reachAtlantic(r, c + 1, heights, height)
                || reachAtlantic(r, c - 1, heights, height)
                || reachAtlantic(r - 1, c, heights, height);
        // unsetting the mark
        heights[r][c] = height;
        return isPossible;
    }

    private static boolean isOutOfBound(int r, int c, int m, int n) {
        return r < 0 || r >= m || c < 0 || c >= n;
    }
}
```
