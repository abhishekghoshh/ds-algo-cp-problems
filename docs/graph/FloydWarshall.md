# FloydWarshall

**Topic:** `graph`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=YbY8cVwWAvw&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=42)
- [📄 takeUforward](https://takeuforward.org/data-structure/floyd-warshall-algorithm-g-42/)

## 📝 Problem Statement

You are given a weighted directed graph, represented by an adjacency matrix, dist[][] of size n x n, where dist[i][j] represents the weight of the edge from node i to node j.&nbsp;If there is no direct edge, dist[i][j] is set to a large value (i.e.,

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

without transforming the array just like the previous type but here, we will not change -1 to INF we will try to relax all the edges, we will try to relax the edge from i to j, and we will check i to k and k to j where k will go from 0 to n-1 if i == k then the equation will be [i][j] => [i][k] + [k][j] [i][j] => [i][i] + [i][j], [i][i] is 0, so we can skip similarly we can skip for j==k and also i==j if one of the edge is -1, then we can skip, as there is no connection established as of now at this point, both [i][k] and [k][j] has proper values we can check if [i][j] is -1 or less than the [i][k] + [k][j]

```java
	private static void type2() {
		int[][] matrix = {
				{0, 1, 43},
				{1, 0, 6},
				{-1, -1, 0}
		};
		floydWarshall2(matrix);
		print(matrix);
	}

	public static void floydWarshall2(int[][] matrix) {
		int n = matrix.length;
		// we will try to relax all the edges,
		// we will try to relax the edge from i to j,
		// and we will check i to k and k to j
		// where k will go from 0 to n-1
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				// if i == k then the equation will be [i][j] => [i][k] + [k][j]
				// [i][j] => [i][i] + [i][j], [i][i] is 0, so we can skip
				if (i == k) continue;
				for (int j = 0; j < n; j++) {
					// similarly we can skip for j==k and also i==j
					if (j == k || i == j) continue;
					// if one of the edge is -1, then we can skip, as there is no connection established as of now
					if (matrix[i][k] == -1 || matrix[k][j] == -1) continue;
					// at this point, both [i][k] and [k][j] has proper values
					// we can check if [i][j] is -1 or less than the [i][k] + [k][j]
					if (matrix[i][j] == -1 || matrix[i][j] > matrix[i][k] + matrix[k][j])
						matrix[i][j] = matrix[i][k] + matrix[k][j];
				}
			}
		}
	}
```

### Approach 1: 🔨 Brute Force

using transformation the array first, we will replace the -1 to INF, then again at last we will replace INF with -1 simple intuition is for every index we will check this [i][j] => [i][k] + [k][j] we will check that if we can go i to j using k we will transform the matrix for our simplicity if matrix[i][j] is -1 then there is no connectivity we will replace it with infinity we will try to relax all the edges, we will try to relax the edge from i to j, and we will check i to k and k to j where k will go from 0 to n-1 if i == k then the equation will be [i][j] => [i][k] + [k][j] [i][j] => [i][i] + [i][j], [i][i] is 0, so we can skip similarly we can skip for j==k and also i==j if one of the edge is the infinity, then we can skip we will relax the edge replace the infinity with -1

```java
	private static void type1() {
		int[][] matrix = {
				{0, 1, 43},
				{1, 0, 6},
				{-1, -1, 0}
		};
		floydWarshall1(matrix);
		print(matrix);
	}

	public static void floydWarshall1(int[][] matrix) {
		int n = matrix.length;

		// we will transform the matrix for our simplicity
		// if matrix[i][j] is -1 then there is no connectivity
		// we will replace it with infinity
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == -1) matrix[i][j] = INF;
				if (i == j) matrix[i][j] = 0;
			}
		}

		// we will try to relax all the edges,
		// we will try to relax the edge from i to j,
		// and we will check i to k and k to j
		// where k will go from 0 to n-1
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				// if i == k then the equation will be [i][j] => [i][k] + [k][j]
				// [i][j] => [i][i] + [i][j], [i][i] is 0, so we can skip
				if (i == k) continue;
				for (int j = 0; j < n; j++) {
					// similarly we can skip for j==k and also i==j
					if (j == k || i == j) continue;
					// if one of the edge is the infinity, then we can skip
					if (matrix[i][k] == INF || matrix[k][j] == INF) continue;
					// we will relax the edge
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
				}
			}
		}

		// replace the infinity with -1
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == INF) matrix[i][j] = -1;
			}
		}
	}

}
```
