# PaintersPartitionProblem

**Topic:** `binarysearch` | **File:** `com/problems/binarysearch/PaintersPartitionProblem.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/painter-s-partition-problem_1089557)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=thUd_WJn6wk)
- [📄 takeUforward](https://takeuforward.org/arrays/painters-partition-problem/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Binary search on method approach

```java
private static void type2() {
        List<Integer> arr = List.of(2, 1, 5, 6, 2, 3);
        int k = 2;
        int max = 0, sum = 0;
        for (int num : arr) {
            if (num > max) max = num;
            sum += num;
        }
        int low = max, high = sum, answer = -1, mid, count;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            count = countForMid(arr, mid, k);
            if (count <= k) {
                answer = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        System.out.println(answer);
    }
    private static int countForMid(List<Integer> nums, int mid, int k) {
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
