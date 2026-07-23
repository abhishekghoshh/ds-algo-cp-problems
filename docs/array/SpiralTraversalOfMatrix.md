# SpiralTraversalOfMatrix

**Topic:** `array`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/spiral-matrix/description/)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/spiral-matrix_6922069)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=3Zv-s9UUrFM&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&t=1s)
- [📄 takeUforward](https://takeuforward.org/data-structure/spiral-traversal-of-matrix/)

## 📝 Problem Statement

Define a resultant list to store the result.

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

Define a resultant list to store the result. Initialize the pointers required for traversal. Loop until all elements are not traversed. For moving left to right For moving top to bottom. For moving right to left. For moving bottom to top.

```java
    private static void type1() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        // Define a resultant list to store the result.
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length; // no. of rows
        int m = matrix[0].length; // no. of columns
        // Initialize the pointers required for traversal.
        int top = 0, left = 0, bottom = n - 1, right = m - 1;
        // Loop until all elements are not traversed.
        while (top <= bottom && left <= right) {
            // For moving left to right
            for (int i = left; i <= right; i++)
                ans.add(matrix[top][i]);
            top++;
            // For moving top to bottom.
            for (int i = top; i <= bottom; i++)
                ans.add(matrix[i][right]);
            right--;
            // For moving right to left.
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    ans.add(matrix[bottom][i]);
                bottom--;
            }
            // For moving bottom to top.
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    ans.add(matrix[i][left]);

                left++;
            }
        }
        System.out.println(ans);
    }
}
```
