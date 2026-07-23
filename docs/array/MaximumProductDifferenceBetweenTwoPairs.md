# MaximumProductDifferenceBetweenTwoPairs

**Topic:** `array`  
**Tags:** Array, Sorting

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/maximum-product-difference-between-two-pairs/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=wBPoEm3r3EA)

## 📝 Problem Statement

Max product difference between two pairs.

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

this is most optimized here we will use 4 variables min1, min2 and max1 and max2 we will use if else check to find all values checking max1 and max2 values checking min1 and min2 values

```java
    private static void type3() {
        int[] nums = {4, 2, 5, 9, 7, 4, 8};
        int ans = maxProductDifference3(nums);
        System.out.println(ans);
    }

    static int maxProductDifference3(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            // checking max1 and max2 values
            if (num > max2) {
                if (num >= max1) {
                    max2 = max1;
                    max1 = num;
                } else {
                    max2 = num;
                }
            }
            // checking min1 and min2 values
            if (num < min2) {
                if (num <= min1) {
                    min2 = min1;
                    min1 = num;
                } else {
                    min2 = num;
                }
            }
        }
        return (max1 * max2) - (min1 * min2);
    }
```

### Approach 2

little optimized we will use sorting here so 0th and 1th element will be the lowest and n-1th and n-2th element will be highest

```java
    private static void type2() {
        int[] nums = {4, 2, 5, 9, 7, 4, 8};
        int ans = maxProductDifference2(nums);
        System.out.println(ans);
    }

    static int maxProductDifference2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max1 = nums[n - 1], max2 = nums[n - 2];
        int min1 = nums[0], min2 = nums[1];
        return (max1 * max2) - (min1 * min2);
    }
```

### Approach 1: 🔨 Brute Force

brute force approach do not discuss this in the interview even

```java
    private static void type1() {
        int[] nums = {4, 2, 5, 9, 7, 4, 8};
    }
}
```
