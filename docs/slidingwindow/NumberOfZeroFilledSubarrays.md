# NumberOfZeroFilledSubarrays

**Topic:** `slidingwindow`  
**Tags:** array, sliding window

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/number-of-zero-filled-subarrays/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=G-EWVGCcL_w)

## 📝 Problem Statement

Count subarrays filled entirely with zeros.

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

exactly the same as the previous but here we will see this as an array problem once we see any non-zero, we will reset the count, else increase the count this new zero will introduce (count) number of subarrays

```java
    private static void type3() {
        int[] nums = {1, 3, 0, 0, 2, 0, 0, 4};
        long ans = zeroFilledSubarray3(nums);
        System.out.println(ans);
    }

    public static long zeroFilledSubarray3(int[] nums) {
        long ans = 0;
        int count = 0;
        for (int num : nums) {
            // once we see any non-zero, we will reset the count, else increase the count
            if (num != 0) count = 0;
            else count++;
            // this new zero will introduce (count) number of subarrays
            ans += count;
        }
        return ans;
    }
```

### Approach 2

optimized approach using the sliding window now we will add one 0 at a time. let's say the current string is 0 0 0, and if we add another 0. it will create 4 substring which ends with the last 0. which is nothing but the new length of the string (basic substring pre-knowledge) skipping the non zero elements

```java
    private static void type2() {
        int[] nums = {1, 3, 0, 0, 2, 0, 0, 4};
        long ans = zeroFilledSubarray2(nums);
        System.out.println(ans);
    }

    public static long zeroFilledSubarray2(int[] nums) {
        int n = nums.length;
        long count = 0L;
        int i = 0;
        int start = -1;
        while (i < n) {
            // skipping the non zero elements
            while (i < n && nums[i] != 0) i++;
            start = i;
            // now we will add one 0 at a time.
            // let's say the current string is 0 0 0, and if we add another 0.
            // it will create 4 substring which ends with the last 0.
            // which is nothing but the new length of the string (basic substring pre-knowledge)
            while (i < n && nums[i] == 0) {
                count += (i - start + 1);
                i++;
            }
        }
        return count;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach using 2 loops

```java
    private static void type1() {
    }
}
```
