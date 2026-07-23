# Factorial

**Topic:** `recursion`  

## 📝 Problem Statement

Calculate factorial of a number using recursion.

## 💡 Approaches

This problem can be solved in **4** different ways, each improving upon the previous:

### Approach 4: 🏆 Optimal Solution

using dp with tabulation without using any extra space, we don't need to save anything other than the last factorial

```java
	private static void type4() {
		int n = 10;
		long fact = 1;
		for (int i = 1; i <= n; i++) {
			fact = i * fact;
		}
		System.out.println(fact);
	}
```

### Approach 3

using dp with tabulation with extra spaces

```java
	private static void type3() {
		int n = 10;
		long[] dp = new long[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++)
			dp[i] = i * dp[i - 1];

		System.out.println(dp[n]);
	}
```

### Approach 2

using dp with memoization

```java
	private static void type2() {
		int n = 10;
		long[] dp = new long[n + 1];
		dp[0] = 1;
		System.out.println(fact(n, dp));
	}

	private static long fact(int n, long[] dp) {
		if (dp[n] != 0) return dp[n];
		return dp[n] = n * fact(n - 1);
	}
```

### Approach 1: 🔨 Brute Force

using recursion

```java
	private static void type1() {
		int n = 10;
		System.out.println(fact(n));
	}

	private static long fact(int n) {
		if (n == 0) return 1;
		return n * fact(n - 1);
	}

}
```
