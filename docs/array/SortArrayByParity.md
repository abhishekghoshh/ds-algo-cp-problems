# SortArrayByParity

**Topic:** `array` | **File:** `com/problems/array/SortArrayByParity.java`

**Tags:** Two pointer

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/sort-array-by-parity/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=QC4c9fyr8As)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach using two pointer will skipp even nums in the start and odd nums from the end we will swap if there is an

```java
private static void type2() {
        int[] nums = {3, 1, 2, 4};
        int[] ans = sortArrayByParity2(nums);
        print(ans);
    }
    public static int[] sortArrayByParity2(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums;
        int i = 0, j = n - 1;
        while (i < j) {
            // skipping even digits if there are any at start
            while (i < j && isEven(nums[i])) i++;
            // skipping odd digits if there are any at last
            while (i < j && !isEven(nums[j])) j--;
            // if i < j that means there are at least one num in start which is odd
            // and one num at last which is odd, so we will swap them, increment the pointers
            if (i < j) {
                swap(nums, i++, j--);
            }
        }
        return nums;
    }
    private static boolean isEven(int num) {
        return num % 2 == 0;
    }
    private static void swap(int[] nums, int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
```

### Approach 1 — Brute Force

Brute force

```java
private static void type1() {
    }
```
