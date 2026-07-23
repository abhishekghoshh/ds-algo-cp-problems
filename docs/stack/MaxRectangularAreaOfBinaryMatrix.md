# MaxRectangularAreaOfBinaryMatrix

**Topic:** `stack`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/maximal-rectangle)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/maximum-size-rectangle-sub-matrix-with-all-1's_893017)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=St0Jf_VmG_g&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=8)
- [▶ YouTube](https://www.youtube.com/watch?v=tOylVCugy9k&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=56)
- [📄 takeUforward](https://takeuforward.org/data-structure/maximum-rectangle-area-with-all-1s-dp-on-rectangles-dp-55/)

## 📝 Problem Statement

Given a binary matrix, find the largest rectangle containing only 1s.

## 💡 Approaches

This problem can be solved in **4** different ways, each improving upon the previous:

### Approach 4: 🏆 Optimal Solution

study later update height cache update left cache update right cache

```java
	private static void type4() {
		int[][] matrix = { { 0, 1, 1, 0 }, { 1, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
		int row = matrix.length;
		int col = matrix[0].length;
		int[] left = new int[col];
		int[] right = new int[col];
		int[] height = new int[col];
		Arrays.fill(right, col);

		int max = 0;
		for (int i = 0; i < row; i++) {
			max = Math.max(max, dp(i, col, left, right, height, matrix));
		}
		System.out.println(max);
	}

	private static int dp(int r, int col, int[] left, int[] right, int height[], int[][] matrix) {
		int currentLeft = 0;
		int currentRight = col;

		// update height cache
		for (int i = 0; i < col; i++) {
			if (matrix[r][i] == 1)
				height[i]++;
			else
				height[i] = 0;
		}
		// update left cache
		for (int i = 0; i < col; i++) {
			if (matrix[r][i] == 1)
				left[i] = Math.max(left[i], currentLeft);
			else {
				left[i] = 0;
				currentLeft = i + 1;
			}
		}
		// update right cache
		for (int i = col - 1; i >= 0; i--) {
			if (matrix[r][i] == 1)
				right[i] = Math.min(right[i], currentRight);
			else {
				right[i] = col;
				currentRight = i;
			}
		}
		// update area
		int max = 0;
		for (int i = 0; i < col; i++) {
			max = Math.max(max, (right[i] - left[i]) * height[i]);
		}
		return max;
	}
```

### Approach 3

explain this solution in the interview we will update the histogram on each iteration and add the current row to the histogram if the cell is zero then it has no point of adding previous, so we set it to 0 else we will add 1 to the height

```java
	private static void type3() {
		int[][] matrix = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
		int m = matrix.length, n = matrix[0].length;
		int[] histogram = new int[n];
		int maxArea = 0;
		for (int[] row : matrix) {
			// we will update the histogram on each iteration
			// and add the current row to the histogram
			for (int i = 0; i < n; i++) {
				// if the cell is zero then it has no point of adding previous,
				// so we set it to 0
				// else we will add 1 to the height
				histogram[i] = row[i] == 0 ? 0 : histogram[i] + 1;
			}
			maxArea = Math.max(maxArea, maxAreaOfHistogramOptimized(histogram, n));
		}
		System.out.println(maxArea);
	}

	private static int maxAreaOfHistogramOptimized(int[] histogram, int n) {
		int max = 0;
		int[] stack = new int[n + 1];
		int top = -1, height, width;
		for (int i = 0; i <= n; i++) {
			while (top != -1 && (i == n || histogram[stack[top]] > histogram[i])) {
				height = histogram[stack[top--]];
				width = (top == -1) ? i : i - stack[top] - 1;
				max = Math.max(max, height * width);
			}
			stack[++top] = i;
		}
		return max;
	}
```

### Approach 2

simple solution to explain in the interview we will update the histogram on each iteration and add the current row to the histogram if the cell is zero then it has no point of adding previous, so we set it to 0 else we will add 1 to the height

```java
	private static void type2() {
		int[][] matrix = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
		int m = matrix.length, n = matrix[0].length;
		int[] histogram = new int[n];
		int maxArea = 0;
		for (int[] row : matrix) {
			// we will update the histogram on each iteration
			// and add the current row to the histogram
			for (int i = 0; i < n; i++) {
				// if the cell is zero then it has no point of adding previous,
				// so we set it to 0
				// else we will add 1 to the height
				histogram[i] = row[i] == 0 ? 0 : histogram[i] + 1;
			}
			maxArea = Math.max(maxArea, maxAreaOfHistogram(histogram, n));
		}
		System.out.println(maxArea);
	}

	private static int maxAreaOfHistogram(int[] histogram, int n) {
		int max = 0, area, right;
		int[] left = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[i])
				stack.pop();
			left[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.add(i);
		}
		stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[i])
				stack.pop();
			if (stack.isEmpty()) right = n;
			else right = stack.peek();
			stack.add(i);
			area = (right - left[i] - 1) * histogram[i];
			max = Math.max(max, area);
		}
		return max;
	}
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
	private static void type1() {

	}

}
```
