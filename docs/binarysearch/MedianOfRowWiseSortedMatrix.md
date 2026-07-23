# MedianOfRowWiseSortedMatrix

**Topic:** `binarysearch`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/median-of-a-row-wise-sorted-matrix_1115473)
- [📄 InterviewBit](https://www.interviewbit.com/problems/matrix-median/)
- [📄 Coding Ninjas](https://www.codingninjas.com/codestudio/problems/873378)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=Q9wXgdxJq48)
- [▶ YouTube](https://www.youtube.com/watch?v=63fPPOdIr2c&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=63)
- [▶ YouTube](https://www.youtube.com/watch?v=_4rxBuhyLXw)
- [📄 takeUforward](https://takeuforward.org/data-structure/median-of-row-wise-sorted-matrix/)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/find-median-row-wise-sorted-matrix/)

## 📝 Problem Statement

Matrix Median - Problem Description Given a matrix of integers A of size N x M in which each row is sorted. Find and return the overall median of matrix A. NOTE: No extra memory is allowed. NOTE: Rows are numbered from top to bottom and columns are numbered from left to right. Problem Constraints 1 <= N, M <= 10^5 1 <= N*M <= 10^6 1 <= A[i] <= 10^9 N*M is odd Input Format The first and only argument given is the integer matrix A. Output Format Return the overall median of matrix A. Example Input Input 1: A = [ [1, 3, 5], [2, 6, 9], [3, 6, 9] ] Input 2: A = [ [5, 17, 100] ] Example Output Outpu

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

```java
	private static void type3() {
		int[][] matrix = {{2, 5, 5}, {2, 5, 12}, {3, 5, 15}};
		int answer = findMedian(matrix, matrix.length, matrix[0].length);
		System.out.println(answer);
	}

	public static int findMedian(int[][] matrix, int m, int n) {
		int low = 1;
		int high = Integer.MAX_VALUE;
		while (low <= high) {
			int mid = (low + high) / 2;
			int cnt = 0;
			for (int i = 0; i < m; i++) cnt += findSmallerOrEqualThanMid(matrix[i], mid);
			if (cnt <= (m * n) / 2) low = mid + 1;
			else high = mid - 1;
		}
		return low;
	}

	public static int findSmallerOrEqualThanMid(int[] arr, int mid) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int md = low + ((high - low) >> 1);
			if (arr[md] <= mid) low = md + 1;
			else high = md - 1;
		}
		return low;
	}
```

### Approach 2

https://www.geeksforgeeks.org/find-median-row-wise-sorted-matrix/#:~:text=Simple%20Method%3A%20The%20simplest%20method,O(r*c). study one more time as per the given question r and c will always be odd so r*c will also be odd and there will be element from 0 to r*c-1 element median element index will be (row*column-1)/2 for every mid we will find the position in every row then we will add it to know it's actual position in the combined sorted array if position is greater than median then we know that the mid element can not be the median so we initialize low with mid+1

```java
	private static void type2() {
		int[][] matrix = { { 2, 5, 5 }, { 2, 5, 12 }, { 3, 5, 15 } };
		// as per the given question r and c will always be odd
		// so r*c will also be odd and there will be element from 0 to r*c-1 element
		int r = matrix.length, c = matrix[0].length;
		int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
		for (int[] row : matrix) {
			if (low > row[0]) low = row[0];
			if (high < row[c - 1]) high = row[c - 1];
		}
		// median element index will be (row*column-1)/2
		int medianIndex = (r * c - 1) / 2;
		int mid, position;
		while (low <= high) {
			mid = low + ((high - low) >> 1);
			position = 0;
			// for every mid we will find the position in every row
			// then we will add it
			// to know it's actual position in the combined sorted array
			for (int[] row : matrix) position += upperBoundIndex(row, mid);
			// if position is greater than median
			// then we know that the mid element can not be the median
			// so we initialize low with mid+1
			if (position <= medianIndex) low = mid + 1;
			else high = mid - 1;
		}
		System.out.println(low);
	}

	private static int upperBoundIndex(int[] row, int item) {
		int low = 0, high = row.length - 1, mid;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (row[mid] <= item) low = mid + 1;
			else high = mid - 1;
		}
		return low;
	}
```

### Approach 1: 🔨 Brute Force

brute force approach if r is row and c is column and n=r*c O(n) to put it in list O(n*log(n)) to sort the list

**Space Complexity:** `O(n)`

```java
	private static void type1() {
		int[][] matrix = { { 2, 5, 5 }, { 2, 5, 12 }, { 3, 5, 15 } };
		int n = matrix.length * matrix[0].length;
		int[] list = new int[n];
		int i = 0;
		for (int[] row : matrix) for (int item : row) list[i++] = item;
		Arrays.sort(list);
		int answer = list[(n - 1) / 2];
		System.out.println(answer);
	}
}
```
