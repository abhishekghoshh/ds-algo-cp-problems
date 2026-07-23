# LongestSubarrayWithSumEqualsK_2

**Topic:** `array` | **File:** `com/problems/array/LongestSubarrayWithSumEqualsK_2.java`

**Tags:** Arrays, hashing, prefix sum

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_5713505)
- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=cyu_nuW5utA&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=7)
- [▶ YouTube](https://www.youtube.com/watch?v=TfQPoaRDeMQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=8)
- [▶ YouTube](https://www.youtube.com/watch?v=frf7qxiN2qU&t=2s)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/longest-sub-array-sum-k/)
- [📄 takeUforward](https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k/)
- [📄 takeUforward](https://takeuforward.org/arrays/longest-subarray-with-sum-k-postives-and-negatives/)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Optimal approach

```java
private static void type3() {
		int[] nums = {3, -5, 8, -14, 2, 4, 0, -1, -3, 4, 12};
		int k = 5;
		int maxLen = 0, sum = 0, n = nums.length;
		Map<Integer, Integer> prefixSum = new HashMap<>();
		// -1 index means there are no items added as of now
		// if we add this index we don't have to check if (sum == k) maxLen = i + 1;
		//
		prefixSum.put(0, -1);
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			if (prefixSum.containsKey(sum - k))
				maxLen = Math.max(maxLen, i - prefixSum.get(sum - k));
			if (!prefixSum.containsKey(sum))
				prefixSum.put(sum, i);
		}
		System.out.println("max length is " + maxLen);
	}
```

### Approach 2

Efficient approach works on negative numbers as prefix sum approach Time complexity O(n) space complexity O(n)

**Complexity:** Time: o(n) | Space: o(n)

```java
private static void type2() {
		int[] nums = { 3, -5, 8, -14, 2, 4, 0, -1, -3, 4, 12 };
		int k = 5;
		int maxLen = 0, sum = 0, n = nums.length;
		Map<Integer, Integer> prefixSum = new HashMap<>();
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			// up to that point if the sum is 0
			// then length will be i+1
			if (sum == k)
				maxLen = i + 1;
			// we are checking that the reminder is present previously or not
			// if present then the sum of in between nums are 0
			// if reminder is present means the sum of in between elements are k
			if (prefixSum.containsKey(sum - k))
				maxLen = Math.max(maxLen, i - prefixSum.get(sum - k));
			// if the sum is already present, then we will not update it
			// sum present means the in between numbers sum is zero
			// so we will update the index as we will lose some in between values
			if (!prefixSum.containsKey(sum))
				prefixSum.put(sum, i);
		}
		System.out.println("max length is " + maxLen);
	}
```

### Approach 1 — Brute Force

Brute force time complexity O(n^2) space complexity o(1)

**Complexity:** Time: o(n^2) | Space: o(1)

```java
private static void type1() {
		int[] nums = { 3, -5, 8, -14, 2, 4, 0, -1, -3, 4, 12 };
		int k = 5;
		int length = 0, sum;
		for (int i = 0; i < nums.length; i++) {
			sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum = sum + nums[j];
				if (sum == k) {
					length = Math.max(length, j - i + 1);
				}
			}
		}
		System.out.println("max length is " + length);
	}
```
