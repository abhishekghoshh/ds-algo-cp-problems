# RemoveDuplicateFromSortedArray2

**Topic:** `array` | **File:** `com/problems/array/RemoveDuplicateFromSortedArray2.java`

**Tags:** Array, Two pointer

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=ycAq8iqh0TI)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach using two pointer in place operation we will use i and k pointer i for traversing the array and k for placing the resultant array we will compute the length of the same characters at max we will copy twice if the length is greater than equal to 2

```java
private static void type2() {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int ans = removeDuplicates(nums);
        System.out.println(ans);
    }
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0, k = 0;
        while (i < n) {
            int num = nums[i];
            int start = i;
            // we will increment the pointer and count how many num is present
            while (i < n && num == nums[i]) i++;
            int len = i - start;
            // copy num to k th place
            nums[k++] = num;
            // only if len is greater than 1 then we will add another num
            if (len > 1) {
                nums[k++] = num;
            }
        }
        return k;
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {

    }
```
