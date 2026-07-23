# IncreasingTripletSubsequence

**Topic:** `greedy` | **File:** `com/problems/greedy/IncreasingTripletSubsequence.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/increasing-triplet-subsequence)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=-tqUs4Qt9TU)
- [▶ YouTube](https://www.youtube.com/watch?v=yEFlGWOVH8g)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach

```java
private static void type2() {
        int[] nums = {1, 5, 0, 6, 4};
        boolean answer = increasingTriplet(nums);
        System.out.println(answer);
    }
    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int minOne = Integer.MAX_VALUE, minTwo = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= minOne) minOne = num;
            else if (num <= minTwo) minTwo = num;
            else return true;
        }
        return false;
    }
```

### Approach 1 — Brute Force

See the youtube video explain yourself brute force approach

```java
private static void type1() {

    }
```
