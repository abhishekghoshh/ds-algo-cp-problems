# BinarySearchOnRotatedArray2

**Topic:** `binarysearch` | **File:** `com/problems/binarysearch/BinarySearchOnRotatedArray2.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/search-in-a-rotated-sorted-array-ii_7449547)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=w2G2W8l__pc&t=1s)
- [📄 takeUforward](https://takeuforward.org/arrays/search-element-in-rotated-sorted-array-ii/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach

```java
private static void type2() {
        int[] nums = {1, 0, 1, 1, 1};
        int target = 0;
        boolean found = rotatedSearch(nums, target);
        System.out.println(found);
    }
    private static boolean rotatedSearch(int[] nums, int target) {
        int n = nums.length; // size of the array.
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            //if mid-points the target
            if (nums[mid] == target) return true;
            //Edge case:
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }
            //if left part is sorted:
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    //element exists:
                    high = mid - 1;
                } else {
                    //element does not exist:
                    low = mid + 1;
                }
            } else { //if right part is sorted:
                if (nums[mid] <= target && target <= nums[high]) {
                    //element exists:
                    low = mid + 1;
                } else {
                    //element does not exist:
                    high = mid - 1;
                }
            }
        }
        return false;
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
    }
```
