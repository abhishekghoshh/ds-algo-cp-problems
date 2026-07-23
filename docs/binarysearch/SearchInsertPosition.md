# SearchInsertPosition

**Topic:** `binarysearch` | **File:** `com/problems/binarysearch/SearchInsertPosition.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/search-insert-position/description/)
- [📄 Coding Ninjas](https://www.codingninjas.com/codestudio/problems/algorithm-to-find-best-insert-position-in-sorted-array_839813)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=6zhGS79oQ4k&t=1187s)
- [📄 takeUforward](https://takeuforward.org/arrays/search-insert-position/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach

```java
private static void type2() {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int answer = searchInsert(nums, target);
        System.out.println(answer);
    }
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int answer = n;
        int low = 0, high = n - 1, mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (target <= nums[mid]) {
                if (target == nums[mid]) return mid;
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int n = nums.length;
        int answer = n;
        for (int i = 0; i < n; i++) {
            if (target <= nums[i]) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
```
