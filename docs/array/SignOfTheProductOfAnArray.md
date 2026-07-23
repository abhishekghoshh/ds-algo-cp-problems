# SignOfTheProductOfAnArray

**Topic:** `array` | **File:** `com/problems/array/SignOfTheProductOfAnArray.java`

**Tags:** Arrays

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/sign-of-the-product-of-an-array/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=ILDLM86jNow)

## Approaches

Implementation:

### Implementation

If num is 0, then the multiple will always be 0 otherwise we will count the number of negatives if the count is odd then the final product will be negative else positive

```java
private static void type1() {
        int[] nums = {-1, -2, -3, -4, 3, 2, 1};
        int ans = arraySign(nums);
        System.out.println(ans);
    }
    public static int arraySign(int[] nums) {
        int ne = 0;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) ne++;
        }
        return (ne % 2 == 1) ? -1 : 1;
    }
```
