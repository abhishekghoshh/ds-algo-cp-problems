# FrogJumpWithKDistances

**Topic:** `dp` | **File:** `com/problems/dp/FrogJumpWithKDistances.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/minimal-cost_8180930)
- [https://atcoder.jp/contests/dp/tasks/dp_b](https://atcoder.jp/contests/dp/tasks/dp_b)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=Kmh3rhyEtB8&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=5)
- [📄 takeUforward](https://takeuforward.org/data-structure/dynamic-programming-frog-jump-with-k-distances-dp-4/)

## Approaches

This problem has **4** approaches, progressing from brute force to optimal:

### Approach 4 — Optimal

Space optimization can be done but it will make the code very complex in frog jump example we were taking prev and prev2 to track here we can take an array of o(k) elements but then every time we have to add value and on every iteration we have to update the value so it is not advisable

```java
private static void type4() {
    }
```

### Approach 3

Using tabulation Time complexity O(k*n) space complexity O(n) for array

**Complexity:** Time: o(k*n) | Space: o(n)

```java
private static void type3() {
        int[] height = {10, 40, 50, 20, 60};
        int n = height.length;
        int k = 3;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            // we will start distance 1 and move till k distance stones,
            // but here is a catch, j should be less than i otherwise i-j will be negative
            for (int j = 1; j <= k && j <= i; j++) {
                int energy = Math.abs(height[i] - height[i - j]) + memo[i - j];
                min = Math.min(min, energy);
            }
            memo[i] = min;
        }
        System.out.println(memo[n - 1]);
    }
```

### Approach 2

Using memoization Time complexity O(k*n) space complexity O(2n) for stack space and array

**Complexity:** Time: o(k*n) | Space: o(2n)

```java
private static void type2() {
        int[] height = {10, 40, 50, 20, 60};
        int n = height.length;
        int k = 3;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int answer = frogJumpK(n - 1, k, height, memo);
        System.out.println(answer);
    }
    private static int frogJumpK(int n, int k, int[] height, int[] memo) {
        if (n == 0) return 0;
        if (memo[n] != -1) return memo[n];
        int min = Integer.MAX_VALUE;
        // we will start distance 1 and move till k distance stones,
        // but here is a catch, i should be less than n otherwise n-i will be negative
        for (int i = 1; i <= k && i <= n; i++) {
            int energy = Math.abs(height[n] - height[n - i]) + frogJumpK(n - i, k, height, memo);
            min = Math.min(min, energy);
        }
        return memo[n] = min;
    }
```

### Approach 1 — Brute Force

Using Recursion Time complexity O(k^n) space complexity O(n) for stack space

**Complexity:** Time: o(k^n) | Space: o(n)

```java
private static void type1() {
        int[] height = {10, 40, 50, 20, 60};
        int n = height.length;
        int k = 3;
        int answer = frogJumpK(n - 1, k, height);
        System.out.println(answer);
    }
    private static int frogJumpK(int n, int k, int[] height) {
        if (n == 0) return 0;
        int min = Integer.MAX_VALUE;
        // we will start distance 1 and move till k distance stones,
        // but here is a catch, i should be less than n otherwise n-i will be negative
        for (int i = 1; i <= k && i <= n; i++) {
            int energy = Math.abs(height[n] - height[n - i]) + frogJumpK(n - i, k, height);
            min = Math.min(min, energy);
        }
        return min;
    }
```
