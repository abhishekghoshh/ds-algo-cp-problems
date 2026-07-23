# ConcatenationOfArray

**Topic:** `logicbuilding`  
**Tags:** Array, Logic building

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/concatenation-of-array/description/)

## 📝 Problem Statement

Return the concatenation of an array with itself.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

using library function

```java
    private static void type2() {
        int[] nums = {1, 2, 1};
        int[] ans = getConcatenation2(nums);
        print(ans);
    }

    public static int[] getConcatenation2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        System.arraycopy(nums, 0, ans, 0, n);
        System.arraycopy(nums, 0, ans, n, n);
        return ans;
    }
```

### Approach 1: 🔨 Brute Force

brute force

```java
    private static void type1() {
        int[] nums = {1, 2, 1};
        int[] ans = getConcatenation1(nums);
        print(ans);
    }

    public static int[] getConcatenation1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[i] = ans[i + n] = nums[i];
        }
        return ans;
    }
}
```
