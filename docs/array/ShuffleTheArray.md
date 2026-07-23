# ShuffleTheArray

**Topic:** `array`  
**Tags:** Arrays

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/shuffle-the-array/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=IvIKD_EU8BY)

## 📝 Problem Statement

Shuffle the array according to given pattern.

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

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
}
```
