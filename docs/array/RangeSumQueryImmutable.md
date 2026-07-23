# RangeSumQueryImmutable

**Topic:** `array` | **File:** `com/problems/array/RangeSumQueryImmutable.java`

**Tags:** Prefix Sum, Array

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/range-sum-query-immutable/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=2pndAmo_sMA)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Using the prefix sum here we will first calculate the prefix sums at the start then for the sum range method we will return from prefix sum array directly

```java
private static void type2() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray2 numArray = new NumArray2(nums);
        int ans = numArray.sumRange(2, 5);
        System.out.println(ans);
    }
```

### Approach 1 — Brute Force

Calculating the prefix sum brute force approach

```java
private static void type1() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray1 numArray = new NumArray1(nums);
        int ans = numArray.sumRange(2, 5);
        System.out.println(ans);
    }
```
