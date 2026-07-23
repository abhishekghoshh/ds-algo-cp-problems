# MatrixChainMultiplication

**Topic:** `dp`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/matrix-chain-multiplication_975344)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=D7AFvtnDeMU&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=32)
- [▶ YouTube](https://www.youtube.com/watch?v=kMK148J9qEE&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=33)
- [▶ YouTube](https://www.youtube.com/watch?v=9uUVFNOT3_Y&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=34)
- [▶ YouTube](https://www.youtube.com/watch?v=vRVfmbCFW7Y&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=49)
- [▶ YouTube](https://www.youtube.com/watch?v=pDCXsbAw5Cg&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=50)
- [📄 takeUforward](https://takeuforward.org/dynamic-programming/matrix-chain-multiplication-dp-48/)
- [📄 takeUforward](https://takeuforward.org/data-structure/matrix-chain-multiplication-tabulation-method-dp-49/)

## 📝 Problem Statement

Given a sequence of matrices, find the most efficient way to multiply these

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

using tabulation technique do not try tabulation first, it is little bit complex to understand check striver video for this approach If we want to follow the recursion, then we have to do it from the last so that all the smaller dp[i][j] will be completed before the bigger one to follow the same recurrence relation, we will start the i from n-1 to 1 the j value will be starting just after i, so j will be from i+1 to n-1 then we will follow the same recurrence of the recursion code

```java
	private static void type3() {
		int[] arr = {40, 20, 30, 10, 30, 25};
		int n = arr.length;
		int[][] dp = new int[n][n];

		// If we want to follow the recursion, then we have to do it from the last
		// so that all the smaller dp[i][j] will be completed before the bigger one

		// to follow the same recurrence relation, we will start the i from n-1 to 1
		// the j value will be starting just after i, so j will be from i+1 to n-1
		//
		for (int i = n - 1; i >= 1; i--) {
			for (int j = i + 1; j < n; j++) {
				int min = Integer.MAX_VALUE;
				// then we will follow the same recurrence of the recursion code
				for (int k = i; k <= j - 1; k++) {
					int operations = arr[i - 1] * arr[k] * arr[j]
							+ dp[i][k]
							+ dp[k + 1][j];
					min = Math.min(min, operations);
				}
				dp[i][j] = min;
			}
		}

		int ans = dp[1][n - 1];
		System.out.println(ans);
	}
```

### Approach 2

recursion with memoization initializing the array returning from the cache out of boundary we are doing k<j because we want the partition to end before the last cell so the last iteration it will be mat[i-1] * mat[j-1] * mat[j] total cost of doing matrix multiplication in each i to k and k+1 to j after mcm(i,k) and mcm(k+1,j) we will have two matrices.

now, the multiplication cost for multiplying those two matrices will be mat[i-1] * mat[k] * mat[j], we are using i-1 because ith matrix is (i-1,i) updating the min saving the answer before returning

```java
	private static void type2() {
		int[] matrices = {40, 20, 30, 10, 30, 25};
		int n = matrices.length;
		int[][] dp = new int[n + 1][n + 1];
		// initializing the array
		for (int[] row : dp) Arrays.fill(row, -1);

		int minCost = mcm(matrices, 1, n - 1, dp);
		System.out.println(minCost);
	}

	private static int mcm(int[] matrices, int i, int j, int[][] dp) {
		// returning from the cache
		if (dp[i][j] != -1) return dp[i][j];
		// out of boundary
		if (i >= j) return 0;
		int min = Integer.MAX_VALUE;
		// we are doing k<j because we want the partition to end before the last cell
		// so the last iteration it will be mat[i-1] * mat[j-1] * mat[j]
		for (int k = i; k < j; k++) {
			// total cost of doing matrix multiplication in each i to k and k+1 to j
			// after mcm(i,k) and mcm(k+1,j) we will have two matrices.
			// now, the multiplication cost for multiplying those two matrices will be
			// mat[i-1] * mat[k] * mat[j], we are using i-1 because ith matrix is (i-1,i)
			int cost = matrices[i - 1] * matrices[k] * matrices[j]
					+ mcm(matrices, i, k, dp)
					+ mcm(matrices, k + 1, j, dp);
			// updating the min
			min = Math.min(min, cost);
		}
		// saving the answer before returning
		return dp[i][j] = min;
	}
```

### Approach 1: 🔨 Brute Force

brute force approach lets say the input array is 40, 20, 30, 10, 30, 25 that means we have matrices with (40x20), (20x30), (30x10), (10,30), (30,25) and we have to multiply all the matrices and produce single resultant matrix. it can be done in multiple ways, but we have to do it in a way that has the minimal multiplication cost.

the cost of multiplying 2 matrices would be => (AxB)x(BxC)=> A*B*C since we are taking as (i-1,i) as the matrix, so we cannot start from 0, we have to we are starting from 1 as we are multiplying i-1 out of boundary we are doing k<j because we want the partition to end before the last cell so the last iteration it will be mat[i-1] * mat[j-1] * mat[j] total cost of doing matrix multiplication in each i to k and k+1 to j after mcm(i,k) and mcm(k+1,j) we will have two matrices.

now, the multiplication cost for multiplying those two matrices will be mat[i-1] * mat[k] * mat[j], we are using i-1 because ith matrix is (i-1,i) updating the min

```java
	private static void type1() {
		int[] matrices = {40, 20, 30, 10, 30, 25};
		int n = matrices.length;
		// since we are taking as (i-1,i) as the matrix,
		// so we cannot start from 0, we have to
		int minCost = mcm(matrices, 1, n - 1);
		System.out.println(minCost);
	}

	// we are starting from 1 as we are multiplying i-1
	private static int mcm(int[] matrices, int i, int j) {
		// out of boundary
		if (i >= j) return 0;

		int min = Integer.MAX_VALUE;
		// we are doing k<j because we want the partition to end before the last cell
		// so the last iteration it will be mat[i-1] * mat[j-1] * mat[j]
		for (int k = i; k < j; k++) {
			// total cost of doing matrix multiplication in each i to k and k+1 to j
			// after mcm(i,k) and mcm(k+1,j) we will have two matrices.
			// now, the multiplication cost for multiplying those two matrices will be
			// mat[i-1] * mat[k] * mat[j], we are using i-1 because ith matrix is (i-1,i)
			int cost = matrices[i - 1] * matrices[k] * matrices[j]
					+ mcm(matrices, i, k)
					+ mcm(matrices, k + 1, j);
			// updating the min
			min = Math.min(min, cost);
		}
		return min;
	}
}
```
