# MaximumSumOfDistinctSubarraysWithLengthK

**Topic:** `slidingwindow` | **File:** `com/problems/slidingwindow/MaximumSumOfDistinctSubarraysWithLengthK.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k)

## Approaches

This problem has **4** approaches, progressing from brute force to optimal:

### Approach 4 — Optimal

Best approach like previous one slightly less memory saving as we are using only boolean array

```java
private static void type4() {
        int[] nums = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        boolean[] freq = new boolean[100001]; // 1<=nums[i]<=10^5=100000
        int n = nums.length;
        int left = 0, right = 0;
        long sum = 0, max = 0;
        while (right < n) {
            sum += nums[right];
            while (freq[nums[right]] || right - left + 1 > k) {
                int numberToRemove = nums[left++];
                sum -= numberToRemove;
                freq[numberToRemove] = false;
            }
            if (right - left + 1 == k) max = Math.max(sum, max);
            freq[nums[right]] = true;
            right++;
        }
        System.out.println(max);
    }
```

### Approach 3

Best approach

```java
private static void type3() {
        int[] nums = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        int n = nums.length;
        int[] freq = new int[100001];
        int types = 0;
        int left = 0, right = 0;
        long sum = 0, max = 0;
        while (right < n) {
            int num = nums[right++];
            if (freq[num] == 0) types++;
            freq[num]++;
            sum += num;
            while (left < n && (types > k || freq[num] > 1)) {
                int numberToRemove = nums[left++];
                freq[numberToRemove]--;
                sum -= numberToRemove;
                if (freq[numberToRemove] == 0) types--;
            }
            if (types == k) max = Math.max(max, sum);
        }
        System.out.println(max);
    }
```

### Approach 2

Improved approach

```java
private static void type2() {
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
    }
```
