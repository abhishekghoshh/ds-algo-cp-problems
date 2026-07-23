# CountNumberOfNiceSubarrays

**Topic:** `slidingwindow` | **File:** `com/problems/slidingwindow/CountNumberOfNiceSubarrays.java`

**Tags:** Arrays, Prefix sum, Sliding window

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/count-number-of-nice-subarrays)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/count-distinct-subarrays-with-at-most-k-odd-elements_1069335)

## Solution Links

- Aditya Rajiv : https://www.youtube.com/watch?v=atUJS7ArOY0

## Approaches

This problem has **4** approaches, progressing from brute force to optimal:

### Approach 4 — Optimal

Solve it with sliding window problem

```java
private static void type4() {
    }
```

### Approach 3

Prefix sum approach same as type2

```java
private static void type3() {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 1;
        int count = 0;
        int sum = 0;
        for (int num : nums) {
            sum += (num & 1);
            if (sum >= k) count += prefixSum[sum - k];
            prefixSum[sum]++;
        }
        System.out.println(count);
    }
```

### Approach 2

Prefix sum approach so the trick here is to change all the number such that odds are 1 and even are 0 the array will be 0 0 1 1 0, something like that now finding k odds number is similar to finding subarrays with sum equal to k

```java
private static void type2() {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        int n = nums.length;
        int count = 0;
        int[] bin = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++)
            if (nums[i] % 2 == 1) {
                bin[i] = 1;
                sum++;
            }
        int[] prefixSum = new int[sum + 1];
        prefixSum[0] = 1;
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += bin[i];
            if (sum >= k && prefixSum[sum - k] != 0) {
                count += prefixSum[sum - k];
            }
            prefixSum[sum]++;
        }
        System.out.println(count);
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
    }
```
