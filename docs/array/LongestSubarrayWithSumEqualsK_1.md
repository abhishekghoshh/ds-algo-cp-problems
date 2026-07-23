# LongestSubarrayWithSumEqualsK_1

**Topic:** `array`  
**Tags:** Arrays, hashing, prefix sum

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/longest-subarray-with-sum-k_6682399)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=frf7qxiN2qU&t=3s)
- [📄 takeUforward](https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k/)

## 📝 Problem Statement

Code 360 by Coding Ninjas

## 💡 Approaches

This problem can be solved in **4** different ways, each improving upon the previous:

### Approach 4: 🏆 Optimal Solution

Two pointers approach variable length sliding window technique works on positive numbers only A simple intuition for the optimal approach is that, while forming a subarray if the sum as already greater than k, we can stop there and increase the starting index.

Because, already the sum has reached k, if we are still going to add more elements, it would definitely go up. if sum > k, reduce the subarray from left until sum becomes less or equal to k: Move forward the right pointer:

**Time Complexity:** `O(2 *n)`
**Space Complexity:** `O(1)`
**Space Complexity:** `O(1)`

```java
    private static void type4() {
        int k = 3;
        int[] arr = {1, 2, 3, 1, 1, 1, 1};
        int n = arr.length;
        int left = 0, right = 0; // 2 pointers
        long sum = arr[0];
        int maxLen = 0;
        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            // Move forward the right pointer:
            right++;
            if (right < n) sum += arr[right];
        }
        System.out.println(maxLen);
    }
```

### Approach 3

Same as type2 just with little modification Prefix sum approach Hashing approach where we store all the cumulative sun from the start and each index we check if the (sum -k) exists before or not if exists then in between range has the sum of k

**Time Complexity:** `O(n)`
**Space Complexity:** `O(n)`

```java
    private static void type3() {
        int k = 3;
        int[] arr = {1, 2, 3, 1, 1, 1, 1};
        int n = arr.length;
        Map<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L, -1);
        long sum = 0;
        int len = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (prefixSum.containsKey(sum - k))
                len = Math.max(len, i - prefixSum.get(sum - k));
            if (!prefixSum.containsKey(sum))
                prefixSum.put(sum, i);
        }
        System.out.println(len);
    }
```

### Approach 2

Prefix sum approach Hashing approach where we store all the cumulative sun from the start and each index we check if the (sum -k) exists before or not if exists then in between range has the sum of k

**Time Complexity:** `O(n)`
**Space Complexity:** `O(n)`

```java
    private static void type2() {
        int k = 3;
        int[] arr = {1, 2, 3, 1, 1, 1, 1};
        int n = arr.length;
        Map<Long, Integer> prefixSum = new HashMap<>();
        long sum = 0;
        int len = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == k)
                len = i + 1;
            if (prefixSum.containsKey(sum - k))
                len = Math.max(len, i - prefixSum.get(sum - k));
            if (!prefixSum.containsKey(sum))
                prefixSum.put(sum, i);
        }
        System.out.println(len);
    }
```

### Approach 1: 🔨 Brute Force

brute force approach

**Time Complexity:** `O(n^2)`
**Space Complexity:** `O(1)`

```java
    private static void type1() {
        int k = 3;
        int[] arr = {1, 2, 3, 1, 1, 1, 1};
        int n = arr.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) maxLen = Math.max(j - i + 1, maxLen);
                else if (sum > k) break;
            }
        }
        System.out.println(maxLen);
    }
}
```
