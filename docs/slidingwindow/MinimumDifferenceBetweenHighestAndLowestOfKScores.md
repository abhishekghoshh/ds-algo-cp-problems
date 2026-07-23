# MinimumDifferenceBetweenHighestAndLowestOfKScores

**Topic:** `slidingwindow`  
**Tags:** array, sliding window, Sorting, Greedy

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=JU5XdBZZtlk)

## 📝 Problem Statement

Minimum difference between max and min among K scores.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

optimal approach using sorting and then sliding window we have to compute the difference so if the numbers are close then only the difference will be less, but again it has to be between the lowest and the highest simple solution is to sort the array, so the similar numbers will come then use 2 pointer on 0 and k-1 index and increment both the pointers then the subarray size will be k, and we will only be taking the lowest on the left and highest on the right side

```java
    private static void type2() {
        int[] nums = {9, 4, 1, 7};
        int k = 2;
        int ans = minimumDifference2(nums, k);
        System.out.println(ans);
    }

    public static int minimumDifference2(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return 0;
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= n - k; i++) {
            int diff = nums[(i + k) - 1] - nums[i];
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
    private static void type1() {
        int[] nums = {9, 4, 1, 7};
        int k = 2;
    }
}
```
