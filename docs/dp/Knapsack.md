# Knapsack

**Topic:** `dp`  

## 📝 Problem Statement

Given N items, each with a weight and value, determine the maximum total value that can be obtained by selecting a subset of items such that the total weight does not exceed a given capacity W. Each item can be chosen at most once (0/1 Knapsack).

## 🔗 Problem Links

- [📄 InterviewBit](https://www.interviewbit.com/problems/0-1-knapsack/)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/0-1-knapsack_920542)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/1072980)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=nqowUJzG-iM&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go)
- [▶ YouTube](https://www.youtube.com/watch?v=kvyShbFVaY8&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=3)
- [▶ YouTube](https://www.youtube.com/watch?v=fJbIuhs24zQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=4)
- [▶ YouTube](https://www.youtube.com/watch?v=ntCGbPMeqgg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=5)
- [▶ YouTube](https://www.youtube.com/watch?v=iBnWHZmlIyY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=6)
- [▶ YouTube](https://www.youtube.com/watch?v=GqOmJHQZivw&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=20)
- [📄 takeUforward](https://takeuforward.org/data-structure/0-1-knapsack-dp-19/)

## 💡 Approaches

This problem can be solved in **6** different ways, each improving upon the previous:

### Approach 6: 🏆 Optimal Solution

some more space optimized than the previous we will store all the profits in memo initialization isn't needed as the default value is 0 in an int array starting from last, we will go till the current weight, then we will no longer need to use it in the if else

```java
	private static void type6() {
		int[] wt = {1, 3, 4, 5, 9, 12};
		int[] val = {1, 4, 5, 7, 12, 16};
		int n = val.length;
		int W = 13;
		// we will store all the profits in memo
		int[] dp = new int[W + 1];

		// initialization isn't needed as the default value is 0 in an int array

		for (int i = 0; i < n; i++) {
			int cw = wt[i]; // current weight
			int cv = val[i]; // current value
			// starting from last, we will go till the current weight,
			// then we will no longer need to use it in the if else
			for (int w = W; w >= cw; w--)
				dp[w] = Math.max(cv + dp[w - cw], dp[w]);
		}
		int profit = dp[W];
		System.out.println(profit);
	}
```

### Approach 5

further space optimization we will store all the profits in memo we don't need initialization as we are setting everything to 0, the int array default value is already 0 we will do this for all n and all w if we think closely we need prev as we want the previous row value.

and let's say cur[j] = m + prev[j-x] and we are starting from 0...w, but if we use the one array only in the current iteration, j-x value is already changed but still we need prev[j-x] value we will do a small trick we will start from the last then j-x index will not be changed we will start from n...0 starting from last

```java
	private static void type5() {
		int[] wt = {1, 3, 4, 5, 9, 12};
		int[] val = {1, 4, 5, 7, 12, 16};
		int n = val.length;
		int w = 13;
		// we will store all the profits in memo
		int[] dp = new int[w + 1];

		// initialization
		// we don't need initialization as we are setting everything to 0, the int array default value is already 0

		// top-down operation
		// we will do this for all n and all w
		// if we think closely we need prev as we want the previous row value.
		// and let's say cur[j] = m + prev[j-x]
		// and we are starting from 0...w, but if we use the one array only in the current iteration,
		// j-x value is already changed but still we need prev[j-x] value
		// we will do a small trick we will start from the last then j-x index will not be changed
		// we will start from n...0
		for (int i = 1; i <= n; i++)
			// starting from last
			for (int j = w; j >= 1; j--)
				if (wt[i - 1] <= j)
					dp[j] = Math.max(
							val[i - 1] + dp[j - wt[i - 1]],
							dp[j]
					);

		int profit = dp[w];
		System.out.println(profit);
	}
```

### Approach 4

space optimization using 2 1D arrays we will store all the profits in memo we don't need initialization as we are setting everything to 0, the int array default value is already 0 we will do this for all n and all w setting the curr to previous

```java
	private static void type4() {
		int[] wt = {1, 3, 4, 5, 9, 12};
		int[] val = {1, 4, 5, 7, 12, 16};
		int n = val.length;
		int w = 13;
		// we will store all the profits in memo
		int[] prev = new int[w + 1];

		// initialization
		// we don't need initialization as we are setting everything to 0, the int array default value is already 0

		// top-down operation
		// we will do this for all n and all w
		for (int i = 1; i <= n; i++) {
			int[] curr = new int[w + 1];
			for (int j = 1; j <= w; j++)
				if (wt[i - 1] <= j)
					curr[j] = Math.max(
							val[i - 1] + prev[j - wt[i - 1]],
							prev[j]
					);
				else curr[j] = prev[j];

			//setting the curr to previous
			prev = curr;
		}

		int profit = prev[w];
		System.out.println(profit);
	}
```

### Approach 3

Top-down approach we will store all the profits in memo here weight is 0, for weight 0 there will be no item to take, so our profit will be zero same like the previous one here item count is 0, so we have nothing to take, and our profit is 0 we will do this for all n and all w

```java
	private static void type3() {
		int[] wt = {1, 3, 4, 5, 9, 12};
		int[] val = {1, 4, 5, 7, 12, 16};
		int n = val.length;
		int w = 13;
		// we will store all the profits in memo
		int[][] dp = new int[n + 1][w + 1];

		// initialization
		// here weight is 0, for weight 0 there will be no item to take, so our profit will be zero
		for (int i = 0; i <= n; i++) dp[i][0] = 0;

		// same like the previous one
		// here item count is 0, so we have nothing to take, and our profit is 0
		for (int j = 0; j <= w; j++) dp[0][j] = 0;

		// top-down operation
		// we will do this for all n and all w
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= w; j++)
				if (wt[i - 1] <= j)
					dp[i][j] = Math.max(
							val[i - 1] + dp[i - 1][j - wt[i - 1]],
							dp[i - 1][j]
					);
				else
					dp[i][j] = dp[i - 1][j];


		int profit = dp[n][w];
		System.out.println(profit);
	}
```

### Approach 2

initializing with negative value marking all the cells unvisited same as before, but if in any point we see, the recursion is already computed, then we will not call recursion again, rather we will directly return from our memo / this is the base case when no weight and item is remaining if the function is already called, then the cell will have a value now if the weight is lesser than the item, then we will have two choices else one

```java
	private static void type2() {
		int[] wt = {1, 3, 4, 5, 9, 12};
		int[] val = {1, 4, 5, 7, 12, 10};
		int n = val.length;
		int w = 20;
		int[][] dp = new int[n + 1][w + 1];
		// initializing with negative value
		// marking all the cells unvisited
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= w; j++)
				dp[i][j] = -1;


		int profit = knapsack(val, wt, w, n, dp);
		System.out.println(profit);
	}

	// same as before, but if in any point we see, the recursion is already computed,
	// then we will not call recursion again, rather we will directly return from our memo
	public static int knapsack(int[] val, int[] wt, int w, int n, int[][] dp) {
		/// this is the base case when no weight and item is remaining
		if (w == 0 || n == 0) return 0;
		// if the function is already called, then the cell will have a value
		if (dp[n][w] != -1) return dp[n][w];

		// now if the weight is lesser than the item, then we will have two choices else one
		if (wt[n - 1] <= w)
			dp[n][w] = Math.max(
					val[n - 1] + knapsack(val, wt, w - wt[n - 1], n - 1, dp),
					knapsack(val, wt, w, n - 1, dp)
			);
		else
			dp[n][w] = knapsack(val, wt, w, n - 1, dp);

		return dp[n][w];
	}
```

### Approach 1: 🔨 Brute Force

simple recursion this is the base case when no weight and item is remaining if the nth item weight is less than our current capacity, then we have two options, either to choose it or not if it is greater than our current capacity, then we will not include it

```java
	private static void type1() {
		int[] wt = {1, 3, 4, 5, 9, 12};
		int[] val = {1, 4, 5, 7, 12, 10};
		int n = val.length;
		int w = 10;
		int profit = knapsack(val, wt, w, n);
		System.out.println(profit);
	}

	public static int knapsack(int[] val, int[] wt, int w, int n) {
		// this is the base case when no weight and item is remaining
		if (w == 0 || n == 0) return 0;
		// if the nth item weight is less than our current capacity, then we have
		// two options, either to choose it or not
		// if it is greater than our current capacity, then we will not include it
		if (wt[n - 1] <= w)
			return Math.max(
					val[n - 1] + knapsack(val, wt, w - wt[n - 1], n - 1),
					knapsack(val, wt, w, n - 1)
			);
		else
			return knapsack(val, wt, w, n - 1);
	}

}
```
