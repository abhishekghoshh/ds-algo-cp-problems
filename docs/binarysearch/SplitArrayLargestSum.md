# SplitArrayLargestSum

**Topic:** `binarysearch`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/split-array-largest-sum/description/)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/largest-subarray-sum-minimized_7461751)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=thUd_WJn6wk)
- [📄 takeUforward](https://takeuforward.org/arrays/split-array-largest-sum/)

## 📝 Problem Statement

Given an array nums and an integer k, split the array into k non-empty subarrays to minimize the largest sum among them.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

binary search on answer approach

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

### Approach 1: 🔨 Brute Force

brute force approach

```java
    private static void type1() {

    }

}
```
