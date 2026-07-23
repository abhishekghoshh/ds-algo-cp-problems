# EqualSumGridPartition1

**Topic:** `array`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/equal-sum-grid-partition-i/description/)

## 📝 Problem Statement

calculating row sum and colum sum

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

```java
    private static void type2() {
    }
```

### Approach 1: 🔨 Brute Force

almost optimized very simple approach calculating row sum and colum sum

```java
    private static void type1() {
        int[][] grid = {
                {1, 4},
                {2, 3}
        };
        boolean ans = canPartitionGrid1(grid);
        System.out.println(ans);
    }

    public static boolean canPartitionGrid1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[] lastColSum = new long[m];
        long[] lastRowSum = new long[n];
        long total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                lastColSum[i] += grid[i][j];
                lastRowSum[j] += grid[i][j];
            }
            total += lastColSum[i];
        }
        if (total % 2 == 1) return false;
        long curr = 0;
        for (long num : lastColSum) {
            curr += num;
            if (curr == total / 2) return true;
        }
        curr = 0;
        for (long num : lastRowSum) {
            curr += num;
            if (curr == total / 2) return true;
        }
        return false;
    }
}
```
