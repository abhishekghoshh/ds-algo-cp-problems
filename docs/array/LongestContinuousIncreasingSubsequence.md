# LongestContinuousIncreasingSubsequence

**Topic:** `array` | **File:** `com/problems/array/LongestContinuousIncreasingSubsequence.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/longest-continuous-increasing-subsequence)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Same as type2 method just here we will reduce the line number

```java
private static void type3() {
        int[] nums = {1, 3, 5, 4, 7};
        int max = 0, count = 0;
        int prev = Integer.MIN_VALUE;
        for (int num : nums) {
            if (prev < num) count++;
            else count = 1;
            prev = num;
            if (max < count) max = count;
        }
        System.out.println(max);
    }
```

### Approach 2

Optimized approach

```java
private static void type2() {
        int[] nums = {1, 3, 5, 4, 7};
        int max = 0, count = 0;
        int prev = Integer.MIN_VALUE;
        for (int num : nums) {
            if (prev < num) {
                prev = num;
                count++;
            } else {
                prev = num;
                count = 1;
            }
            if (max < count) max = count;
        }
        System.out.println(max);
    }
```

### Approach 1 — Brute Force

Brute force approach using 2 loops

```java
private static void type1() {
        int[] nums = {1, 3, 5, 4, 7};
    }
```
