# TribonacciSeries

**Topic:** `dp`  
**Tags:** Recursion, Dynamic programming

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/n-th-tribonacci-number/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=3lpNp5Ojvrw)

## 📝 Problem Statement

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

## 💡 Approaches

This problem can be solved in **4** different ways, each improving upon the previous:

### Approach 4: 🏆 Optimal Solution

same as previous bottom up approach but here we will use 3 prev variable and update on every iteration T0 = 0, T1 = 1, T2 = 1 n is greater than 2 copying prev1,prev2 and prev3 into local variables updating prev1,prev2 and prev3

```java
    private static void type4() {
        int n = 25;
        int ans = tribonacci4(n);
        System.out.println(ans);
    }

    private static int tribonacci4(int n) {
        // T0 = 0, T1 = 1, T2 = 1
        if (n <= 1) return n;
        if (n == 2) return 1;
        // n is greater than 2
        int prev3 = 0, prev2 = 1, prev1 = 1;
        for (int i = 3; i <= n; i++) {
            // copying prev1,prev2 and prev3 into local variables
            int p3 = prev3, p2 = prev2, p1 = prev1;
            // updating prev1,prev2 and prev3
            prev1 = p1 + p2 + p3;
            prev2 = p1;
            prev3 = p2;
        }
        return prev1;
    }
```

### Approach 3

bottom up approach T0 = 0, T1 = 1, T2 = 1 n is greater than 2

```java
    private static void type3() {
        int n = 25;
        int ans = tribonacci3(n);
        System.out.println(ans);
    }

    private static int tribonacci3(int n) {
        // T0 = 0, T1 = 1, T2 = 1
        if (n <= 1) return n;
        if (n == 2) return 1;
        // n is greater than 2
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
```

### Approach 2

same as previous with a memoization T0 = 0, T1 = 1, T2 = 1 returning from the dp table Tn+3 = Tn + Tn+1 + Tn+2

```java
    private static void type2() {
        int n = 25;
        int ans = tribonacci2(n);
        System.out.println(ans);
    }

    private static int tribonacci2(int n) {
        int[] dp = new int[n + 1];
        return tribonacci2(n, dp);
    }

    private static int tribonacci2(int n, int[] dp) {
        // T0 = 0, T1 = 1, T2 = 1
        if (n <= 1) return n;
        if (n == 2) return 1;
        // returning from the dp table
        if (dp[n] != 0) return dp[n];
        // Tn+3 = Tn + Tn+1 + Tn+2
        return dp[n] = tribonacci2(n - 1, dp) + tribonacci2(n - 2, dp) + tribonacci2(n - 3, dp);
    }
```

### Approach 1: 🔨 Brute Force

brute force solution using the recursion T0 = 0, T1 = 1, T2 = 1 Tn+3 = Tn + Tn+1 + Tn+2

```java
    private static void type1() {
        int n = 25;
        int ans = tribonacci1(n);
        System.out.println(ans);
    }

    public static int tribonacci1(int n) {
        // T0 = 0, T1 = 1, T2 = 1
        if (n <= 1) return n;
        if (n == 2) return 1;
        // Tn+3 = Tn + Tn+1 + Tn+2
        return tribonacci1(n - 1) + tribonacci1(n - 2) + tribonacci1(n - 3);
    }
}
```
