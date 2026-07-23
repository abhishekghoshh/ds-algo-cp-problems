# FindTheCountOfMonotonicPairs

**Topic:** `array`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/find-the-count-of-monotonic-pairs-i/description/)
- [📄 LeetCode](https://leetcode.com/problems/find-the-count-of-monotonic-pairs-ii/)

## 📝 Problem Statement

Count monotonic pairs in an array.

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

```java
    private static void type1() {
        int[] nums = {2, 3, 2};
        int ans = countOfPairs(nums);
        System.out.println(ans);
    }

    static int mod = 100000007;

    public static int countOfPairs(int[] nums) {
        long ans = 0;
        for (int num = 0; num <= nums[0]; num++) {
            ans += countOfPairs(1, num, nums[0] - num, nums);
            ans = ans % mod;
        }
        return (int) ans;
    }

    public static long countOfPairs(int i, int num1, int num2, int[] nums) {
        if (i == nums.length) return 1;
        long ans = 0;
        for (int num = num1; num <= nums[i]; num++) {
            if (nums[i] - num <= num2) {
                ans += countOfPairs(i + 1, num, nums[i] - num, nums);
                ans = ans % mod;
            }
        }
        return ans;
    }
}
```
