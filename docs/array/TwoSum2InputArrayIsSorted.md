# TwoSum2InputArrayIsSorted

**Topic:** `array` | **File:** `com/problems/array/TwoSum2InputArrayIsSorted.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=cQ1Oz4ckceM)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach if the array is already sorted then we can just use 2 pointer on the start and the end and take the sum of numbers[end] and numbers[start] and then take the difference if the difference is less than 0 that means we have to increase the sum, which can only be achieved by increasing start pointer, if the diff is greater than 0 then we need to decrease the sum if the diff is 0 then we will return the ans

```java
private static void type2() {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] ans = twoSum2(numbers, target);
        print(ans);
    }
    public static int[] twoSum2(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int diff = numbers[end] + numbers[start] - target;

            // If the diff is 0 then we have found the answer, and we will return the ans
            if (diff == 0)
                return new int[]{start + 1, end + 1};

            // if diff is greater than 0 then we need to decrease the sum, which can only be achieved by decreasing end pointer
            // if diff is less than 0 then we need to increase the sum, which can only be achieved by increasing start pointer
            if (diff > 0) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{-1, -1};
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
    }
```
