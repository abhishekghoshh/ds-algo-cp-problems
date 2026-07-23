# DailyTemperatures

**Topic:** `stack` | **File:** `com/problems/stack/DailyTemperatures.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/daily-temperatures/description/)
- [📄 NeetCode](https://neetcode.io/problems/daily-temperatures)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=cTBiBSnjO3c)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimized approach using monotonic increasing stack or we will use a monotonic increasing stack to find the next greater temperature

```java
private static void type2() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = dailyTemperatures2(temperatures);
        print(ans);
    }
    public static int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        if (n == 1) return new int[]{0};
        int[] ans = new int[n];
        // this will be our stack
        int top = -1;
        int[] st = new int[n];
        // now we will compute from the back (n...0)
        for (int i = n - 1; i >= 0; i--) {
            // we will pop from the stack (decrease top) if stack contains lesser or equal temperature
            while (top != -1 && temperatures[i] >= temperatures[st[top]])
                top--; // popping from the stack
            // checking if the stack is empty or not if empty meaning then there is nothing on the right
            // else we will take the difference of the greater temperature day with the current day
            ans[i] = (top != -1) ? (st[top] - i) : 0;
            // adding the current element to the stack
            st[++top] = i;
        }
        return ans;
    }
```

### Approach 1 — Brute Force

We will use an array and a top variable and use that as stack we will brute force approach for this

```java
private static void type1() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = dailyTemperatures1(temperatures);
        print(ans);
    }
    public static int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        if (n == 1) return new int[]{0};
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int temp = temperatures[i], next = -1;
            for (int j = i + 1; j < n; j++) {
                if (temp < temperatures[j]) {
                    next = j;
                    break;
                }
            }
            ans[i] = (next != -1) ? (next - i) : 0;
        }
        return ans;
    }
```
