# RangeSumQuery2DImmutable

**Topic:** `array` | **File:** `com/problems/array/RangeSumQuery2DImmutable.java`

**Tags:** Arrays, hashing, prefix sum

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/range-sum-query-2d-immutable/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=KE8MQuwE2yA)

## Approaches

Implementation:

### Implementation

Int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of the matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2). you must design an algorithm where sumRegion works on O(1) time complexity. the main problem is to find the region sum in O(1) time a region is nothing but a rectangular box let's think what we can find in O(1) we can find we O(1) we can either row sum, column sum or box sum(from 0,0) in O(1) what is a region if the matrix is (all X has multiple coordinates) X1 X2 . . . X3 X4 . . . . . . . . . then X4 will be a region we can find (0,0) to X4 our answer would be total box minus X1 and X2 and X3 simple technique would be to find X1X3 and X1X2 and subtract from total as X1X3 and X1X2 are rectangular box from (0,0) and we can find their sum in O(1) but we have to add X1 as it is deleted twice again (X1 is from 0,0)

```java
private static void type1() {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }
```
