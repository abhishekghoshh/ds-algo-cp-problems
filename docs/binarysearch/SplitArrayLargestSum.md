# SplitArrayLargestSum

**Topic:** `binarysearch` | **File:** `com/problems/binarysearch/SplitArrayLargestSum.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/split-array-largest-sum/description/)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/largest-subarray-sum-minimized_7461751)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=thUd_WJn6wk)
- [📄 takeUforward](https://takeuforward.org/arrays/split-array-largest-sum/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Binary search on answer approach

```java
private static void type2() {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        int max = 0, sum = 0;
        for (int num : nums) {
            if (max < num) max = num;
            sum += num;
        }
        int low = max, high = sum, answer = -1, mid, count;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            count = countForMid(nums, mid, k);
            if (count <= k) {
                answer = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        System.out.println(answer);
    }
    private static int countForMid(int[] nums, int mid, int k) {
        int count = 1, sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > mid) {
                count++;
                sum = num;
            }
        }
        return count;
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {

    }
```
