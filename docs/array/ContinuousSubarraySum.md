# ContinuousSubarraySum

**Topic:** `array` | **File:** `com/problems/array/ContinuousSubarraySum.java`

**Tags:** Array, Hashing, Prefix Sum

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/continuous-subarray-sum/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=OKcrLfR-8mE)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimized approach this is a normal prefix sum problem with a trick we have to check if the subarray sum is a kth multiple or not. However, there can be multiple kth multiple. We cannot account for everything, so we will not save the actual sum, we will save the reminder let's say the sums/reminders are like 0 s1 s2 s3 s4 s5 s1 s3. If there is s1 at any place(i1) and there is s1 at a later index(i2), then the in sum[i1+1,i2] has to be multiple of k otherwise it would not produce s1 reminder again

```java
private static void type2() {
        int[] nums = {23, 2, 6, 4, 7};
        int k = 6;
        boolean ans = checkSubarraySum2(nums, k);
        System.out.println(ans);
    }
    public static boolean checkSubarraySum2(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int n = nums.length;
        int sum = 0;
        prefixSum.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum = (sum + nums[i]) % k;
            if (prefixSum.containsKey(sum)) {
                int length = i - prefixSum.get(sum);
                // as per the question
                if (length >= 2) return true;
            } else {
                // we will only save the [rem,index] for the first time
                prefixSum.put(sum, i);
            }
        }
        return false;
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {

    }
```
