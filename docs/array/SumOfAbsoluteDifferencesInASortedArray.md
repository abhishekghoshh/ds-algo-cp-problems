# SumOfAbsoluteDifferencesInASortedArray

**Topic:** `array` | **File:** `com/problems/array/SumOfAbsoluteDifferencesInASortedArray.java`

**Tags:** Arrays, hashing, prefix sum

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=3nkc-e66JmA)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Exactly like the previous type, but we cannot have this intuition directly

```java
private static void type3() {
        int[] nums = {1, 4, 6, 8, 10};
        int[] ans = getSumAbsoluteDifferences3(nums);
        print(ans);
    }
    private static int[] getSumAbsoluteDifferences3(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int sum = 0;
        // calculating the sum
        for (int num : nums) sum += num;

        int leftSum = 0, rightSum;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            // calculating the right side sum
            rightSum = sum - leftSum - num;
            // calculating the result, for num it will be (num-num) or 0 we are not considering it
            result[i] = ((i * num) - leftSum) + (rightSum - ((n - 1 - i) * num));
            // updating the left side sum
            leftSum += num;
        }
        return result;
    }
```

### Approach 2

Same as previous but here we are trying to do everything in one go todo prefix sum approach we can use a prefix array then use it in our problem but here we will store directly on the array this is a sorted array like 1,2,3,4,5 lets take the example for 3 and simplify this |3-1| + |3-2| + |3-3| + |3-4| + |3-5| => 3-1 + 3-2 + 0 + 4-3 + 5-3 2*3 - (1+2) + 0 + (4+5) - 2*3 (leftSideLength * item) - prefixSum + 0 + suffixSum - (rightSideLength * item) we will use 2 loops for simplicity one for creating the (leftSideLength * item) - (rightSideLength * item) and total in the next iteration we will use the total sum to create the prefixSum and suffixSum

```java
private static void type2() {
        int[] nums = {1, 4, 6, 8, 10};
        int[] ans = getSumAbsoluteDifferences2(nums);
        print(ans);
    }
    public static int[] getSumAbsoluteDifferences2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        // we will calculate for num[i] contribution for ith index
        for (int i = 0; i < n; i++) {
            result[i] = (i * nums[i]) + ((n - 1 - i) * -nums[i]);
        }
        int sum = 0;
        for (int num : nums) sum += num;
        int leftSum = 0, rightSum;
        // here we will calculate the remaining words contribution for ith index
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            // calculating the right side sum
            rightSum = sum - leftSum - num;
            result[i] += (-leftSum) + rightSum;
            // updating the left side sum
            leftSum += num;
        }
        return result;
    }
```

### Approach 1 — Brute Force

We will calculate the result in 2 phases we can also do it in one phase brute force approach calculate absolute sum for all the element

```java
private static void type1() {
    }
```
