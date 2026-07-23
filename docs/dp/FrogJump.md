# FrogJump

**Topic:** `dp` | **File:** `com/problems/dp/FrogJump.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/frog-jump_3621012)
- [https://atcoder.jp/contests/dp/tasks/dp_a](https://atcoder.jp/contests/dp/tasks/dp_a)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=EgG3jsGoPvQ&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=4)
- [📄 takeUforward](https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/)

## Approaches

This problem has **5** approaches, progressing from brute force to optimal:

### Approach 5 — Optimal

Using tabulation with memory optimization Time complexity O(n) space complexity O(1) we will compute from 0th to n-1 th height it is the same as previous we just need last and 2nd last value to compute the current we can just hold those two values in 2 variable prev and prev2

**Complexity:** Time: o(n) | Space: o(1)

```java
private static void type5() {
        int[] heights = {7, 4, 4, 2, 6, 6, 3, 4};
        int n = heights.length;
        int prev2 = 0, prev = abs(heights[1] - heights[0]), curr;
        // we will be starting from 2 to n-1
        for (int i = 2; i < n; i++) {
            // first, we will calculate energy from the previous,
            // then we will calculate energy from the previous of previous
            // we will take the minimum
            curr = min(
                    abs(heights[i] - heights[i - 1]) + prev,
                    abs(heights[i] - heights[i - 2]) + prev2
            );
            // we will update those 2 variables
            prev2 = prev;
            prev = curr;
        }
        out.println(prev);
    }
```

### Approach 4

Using tabulation Time complexity O(n) space complexity O(n) for and array we will compute from 0th to n-1 th height memo[0] is 0 because if we are in 0th cell, we don't have to move anywhere

**Complexity:** Time: o(n) | Space: o(n)

```java
private static void type4() {
        int[] heights = {7, 4, 4, 2, 6, 6, 3, 4};
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = abs(heights[1] - heights[0]);
        for (int i = 2; i < n; i++) {
            // first, we are jumping from the previous
            // then we are jumping from the previous of previous
            // then we are taking the minimum from these two values
            dp[i] = min(
                    abs(heights[i] - heights[i - 1]) + dp[i - 1],
                    abs(heights[i] - heights[i - 2]) + dp[i - 2]
            );
        }
        out.println(dp[n - 1]);
    }
```

### Approach 3

Using Memoization Time complexity O(n) space complexity O(2n) for stack space and array

**Complexity:** Time: o(n) | Space: o(2n)

```java
private static void type3() {
        int[] heights = {7, 4, 4, 2, 6, 6, 3, 4};
        int n = heights.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int answer = frogJump(n - 1, heights, memo);
        out.println(answer);
    }
    private static int frogJump(int n, int[] heights, int[] memo) {
        // if it is in 0 then it does not need to jump
        if (n == 0) return 0;
        // if it is in 1st position, then there is only 1 way to go to 0
        if (n == 1) return abs(heights[1] - heights[0]);
        // if the recursion is already made, then we will directly return from the dp array
        if (memo[n] != -1) return memo[n];
        // otherwise it can co either n-1 or n-2, and we will save it to dp
        return memo[n] = min(
                abs(heights[n] - heights[n - 1]) + frogJump(n - 1, heights, memo),
                abs(heights[n] - heights[n - 2]) + frogJump(n - 2, heights, memo)
        );
    }
```

### Approach 2

Same as previous just we are saving 0-ith value in a 1D array using the Recursion same as previous, but here we will do it in a different way

```java
private static void type2() {
        int[] heights = {7, 4, 4, 2, 6, 6, 3, 4};
        int n = heights.length;
        int answer = frogJump2(n - 1, heights);
        out.println(answer);
    }
    private static int frogJump2(int n, int[] heights) {
        // if it is in 0 then it does not need to jump
        if (n == 0) return 0;
        // if it is in 1st position, then there is only 1 way to go to 0
        if (n == 1) return abs(heights[1] - heights[0]);
        // otherwise it can co either n-1 or n-2
        return min(
                abs(heights[n] - heights[n - 1]) + frogJump2(n - 1, heights),
                abs(heights[n] - heights[n - 2]) + frogJump2(n - 2, heights)
        );
    }
```

### Approach 1 — Brute Force

Using Recursion Time complexity O(2^n) space complexity O(n) for stack space

**Complexity:** Time: o(2^n) | Space: o(n)

```java
private static void type1() {
        int[] heights = {7, 4, 4, 2, 6, 6, 3, 4};
        int n = heights.length;
        int answer = frogJump(n - 1, heights);
        out.println(answer);
    }
    private static int frogJump(int n, int[] heights) {
        if (n == 0) return 0;
        int prev = abs(heights[n] - heights[n - 1]) + frogJump(n - 1, heights);
        int prev2 = Integer.MAX_VALUE;
        if (n >= 2)
            prev2 = abs(heights[n] - heights[n - 2]) + frogJump(n - 2, heights);
        return min(prev, prev2);
    }
```
