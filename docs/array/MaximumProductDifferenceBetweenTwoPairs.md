# MaximumProductDifferenceBetweenTwoPairs

**Topic:** `array` | **File:** `com/problems/array/MaximumProductDifferenceBetweenTwoPairs.java`

**Tags:** Array, Sorting

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/maximum-product-difference-between-two-pairs/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=wBPoEm3r3EA)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

This is most optimized here we will use 4 variables min1, min2 and max1 and max2 we will use if else check to find all values

```java
private static void type3() {
        int[] nums = {4, 2, 5, 9, 7, 4, 8};
        int ans = maxProductDifference3(nums);
        System.out.println(ans);
    }
```

### Approach 2

Checking max1 and max2 values checking min1 and min2 values little optimized we will use sorting here so 0th and 1th element will be the lowest and n-1th and n-2th element will be highest

```java
private static void type2() {
        int[] nums = {4, 2, 5, 9, 7, 4, 8};
        int ans = maxProductDifference2(nums);
        System.out.println(ans);
    }
```

### Approach 1 — Brute Force

Brute force approach todo do not discuss this in the interview even

```java
private static void type1() {
        int[] nums = {4, 2, 5, 9, 7, 4, 8};
    }
```
