# FibonacciNumber

**Topic:** `recursion` | **File:** `com/problems/recursion/FibonacciNumber.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/fibonacci-number/description/)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/find-all-factorial-numbers-less-than-or-equal-to-n3548/0)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=69ZCDFy-OUo)
- [📄 takeUforward](https://takeuforward.org/data-structure/factorial-of-a-number-iterative-and-recursive/)

## Approaches

This problem has **4** approaches, progressing from brute force to optimal:

### Approach 4 — Optimal

This is the same bottom-up approach. However, if we look close, we will know that we do not need all the values from 0 to n-1 we will only need the last 2 values, so if we can store only the last values then our work is done

```java
private static void type4() {
		int n = 10;
		int prev2 = 0;
		int prev = 1;
		int curr = 0;
		for (int i = 2; i <= n; i++) {
			curr = prev + prev2;
			prev2 = prev;
			prev = curr;
		}
		System.out.println(curr);
	}
```

### Approach 3

This is the bottom-up approach

```java
private static void type3() {
		int n = 10;
		int[] dp = new int[n + 1];
		// we will initialize the 0th and 1st index
		dp[0] = 0;
		dp[1] = 1;
		// we will calculate from index 2
		// we will apply the fibonacci function
		for (int i = 2; i <= n; i++)
			dp[i] = dp[i - 1] + dp[i - 2];

		System.out.println(dp[n]);
	}
```

### Approach 2

This is again same but here we have used memoization if we think the equation f(n) = f(n-1) + f(n-2) so for f(n) we are calculating the f(n-1) and f(n-2) again for f(n-1) we are calculating the f(n-2) and f(n-3) so there are multiple duplicate function calls we can store the function returns in one array and when the same function is being called then we will return the value

```java
private static void type2() {
		int n = 10;
		int[] dp = new int[n + 1];
		System.out.println(fib(n, dp));
	}
	private static int fib(int n, int[] dp) {
		if (n <= 1) return n;
		// early return form the memo array
		if (dp[n] != 0) return dp[n];
		return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
	}
```

### Approach 1 — Brute Force

This is a plain recursion we know the equation of the fibonacci sequence f(n) = f(n-1) + f(n-2) we have applied the same logic here

```java
private static void type1() {
		int n = 10;
		System.out.println(fib(n));
	}
	private static int fib(int n) {
		if (n <= 1) return n;
		return fib(n - 1) + fib(n - 2);
	}
```
