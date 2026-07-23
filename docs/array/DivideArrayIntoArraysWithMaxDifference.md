# DivideArrayIntoArraysWithMaxDifference

**Topic:** `array` | **File:** `com/problems/array/DivideArrayIntoArraysWithMaxDifference.java`

**Tags:** Array, Greedy, Sorting

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=XleOio1oJeo)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimized approach using greedy we will first sort the elements if we think closely if we sort the array then only we will get the numbers close to each other only

```java
private static void type2() {
        int[] nums = {1, 3, 4, 8, 7, 9, 3, 5, 1};
        int k = 2;
        int[][] ans = divideArray2(nums, k);
        print(ans);
    }
    public static int[][] divideArray2(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] ans = new int[n / 3][3];
        for (int i = 0; i < n; i += 3) {
            int first = nums[i], second = nums[i + 1], third = nums[i + 2];
            // if the first between first and third is more than k then we will return empty array
            if ((third - first) > k) return new int[0][];
            int idx = i / 3;
            ans[idx][0] = first;
            ans[idx][1] = second;
            ans[idx][2] = third;
        }
        return ans;
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
    }
```
