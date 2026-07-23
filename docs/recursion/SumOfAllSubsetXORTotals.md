# SumOfAllSubsetXORTotals

**Topic:** `recursion` | **File:** `com/problems/recursion/SumOfAllSubsetXORTotals.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=LI7YR-bwNYY)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Exactly the same as type2 but with slight difference

```java
private static void type3() {
        int[] nums = {5, 1, 6};
        int ans = subsetXORSum3(nums);
        System.out.println(ans);
    }
    private static int subsetXORSum3(int[] nums) {
        return subset3(0, nums, 0);
    }
    private static int subset3(int i, int[] nums, int xor) {
        int n = nums.length;
        if (i == n) return xor;
        return subset3(i + 1, nums, nums[i] ^ xor)
                + subset3(i + 1, nums, xor);
    }
```

### Approach 2

Efficient approach here we will not generate all the subsets rather we will carry a variable called xor and add the xor of the element to the xor variable

```java
private static void type2() {
        int[] nums = {5, 1, 6};
        int ans = subsetXORSum2(nums);
        System.out.println(ans);
    }
    private static int subsetXORSum2(int[] nums) {
        subset2(0, nums, 0);
        return sum2;
    }
    private static void subset2(int i, int[] nums, int xor) {
        int n = nums.length;
        if (i == n) {
            sum2 += xor;
            return;
        }
        // not choosing the element
        subset2(i + 1, nums, xor ^ nums[i]);
        // not choosing the element
        subset2(i + 1, nums, xor);
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
        int[] nums = {5, 1, 6};
        int ans = subsetXORSum1(nums);
        System.out.println(ans);
    }
    public static int subsetXORSum1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // generate all subsets
        subset(0, nums, list, new ArrayList<>());
        int xorSum = 0;
        for (List<Integer> l : list) {
            int s = 0;
            // calculating total xor of each subset
            for (int num : l)
                s = (s ^ num);
            xorSum += s;
        }
        return xorSum;
    }
```
