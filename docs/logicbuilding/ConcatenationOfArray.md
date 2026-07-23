# ConcatenationOfArray

**Topic:** `logicbuilding` | **File:** `com/problems/logicbuilding/ConcatenationOfArray.java`

**Tags:** Array, Logic building

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/concatenation-of-array/description/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Using library function

```java
private static void type2() {
        int[] nums = {1, 2, 1};
        int[] ans = getConcatenation2(nums);
        print(ans);
    }
    public static int[] getConcatenation2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        System.arraycopy(nums, 0, ans, 0, n);
        System.arraycopy(nums, 0, ans, n, n);
        return ans;
    }
```

### Approach 1 — Brute Force

Brute force

```java
private static void type1() {
        int[] nums = {1, 2, 1};
        int[] ans = getConcatenation1(nums);
        print(ans);
    }
    public static int[] getConcatenation1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[i] = ans[i + n] = nums[i];
        }
        return ans;
    }
```
