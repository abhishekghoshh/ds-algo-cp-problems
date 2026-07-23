# RearrangeArrayElementsBySign

**Topic:** `array` | **File:** `com/problems/array/RearrangeArrayElementsBySign.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/rearrange-array-elements-by-sign/description/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/alternate-numbers_6783445)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=h4aBagy4Uok)
- [▶ YouTube](https://www.youtube.com/watch?v=SoPmcGzz9-E)
- [📄 takeUforward](https://takeuforward.org/arrays/rearrange-array-elements-by-sign/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Time complexity O(n) space complexity O(n)

**Complexity:** Time: o(n) | Space: o(n)

```java
private static void type2() {
        int[] nums = {3, 1, -2, -5, 2, -4};
        int[] result = rearrangeArray2(nums);
        PrintUtl.print(result);
    }
    private static int[] rearrangeArray2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        // we will use 2 pointer one for positive and one for negative
        // positive will start from 0 and negative will start from 1
        // if we find positive then increment pIndex by 2 and for negative we will increment nIndex by 2
        int pIndex = 0;
        int nIndex = 1;
        for (int num : nums) {
            if (num > 0) {
                result[pIndex] = num;
                pIndex += 2;
            } else {
                result[nIndex] = num;
                nIndex += 2;
            }
        }
        return result;
    }
```

### Approach 1 — Brute Force

Time complexity O(2n) space complexity O(n)

**Complexity:** Time: o(2n) | Space: o(n)

```java
private static void type1() {
        int[] nums = {3, 1, -2, -5, 2, -4};
        int[] ans = rearrangeArray1(nums);
        PrintUtl.print(nums);
    }
    private static int[] rearrangeArray1(int[] nums) {
        int n = nums.length;
        int n2 = n / 2;
        // using 2 different array for
        int[] setP = new int[n2];
        int[] setN = new int[n2];
        int i1 = 0, i2 = 0;
        for (int num : nums) {
            if (num > 0)
                setP[i1++] = num;
            else
                setN[i2++] = num;
        }
        for (int i = 0; i < n2; i++) {
            nums[2 * i] = setP[i];
            nums[2 * i + 1] = setN[i];
        }
        return nums;
    }
```
