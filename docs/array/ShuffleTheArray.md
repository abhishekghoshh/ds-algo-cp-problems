# ShuffleTheArray

**Topic:** `array` | **File:** `com/problems/array/ShuffleTheArray.java`

**Tags:** Arrays

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/shuffle-the-array/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=IvIKD_EU8BY)

## Approaches

Implementation:

### Implementation

Brute force approach

```java
private static void type1() {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;
        int[] ans = shuffle(nums, n);
        PrintUtl.print(ans);
    }
    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[i + n];
        }
        return ans;
    }
```
