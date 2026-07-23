# LongestSubarrayWithSumEqualsZero

**Topic:** `array`  
**Tags:** Arrays, hashing, prefix sum

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/920321)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/longest-subarray-with-zero-sum_6783450)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=xmguZ6GbatA&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=24)
- [📄 takeUforward](https://takeuforward.org/data-structure/length-of-the-longest-subarray-with-zero-sum/)

## 📝 Problem Statement

Given an array arr[] containing both positive and negative integers, the task is to find the length of the&nbsp;longest subarray with a sum equals to 0.
Note:&nbsp;A subarray is a contiguous part of an array, formed by selecting one or more consecuti

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

same as type2 prefix sum approach we are checking that the same sum is present previously or not if present then the sum of in between nums are 0 else add the sum in the prefixsum map with the current index, we will not update the index of sum even if we find the same sum again

**Time Complexity:** `O(n)`

```java
	private static void type3() {
		int[] nums = {15, -2, 2, -8, 1, 7, 10, 23};
		int n = nums.length, maxLen = 0, sum = 0;
		Map<Integer, Integer> prefixSum = new HashMap<>();
		prefixSum.put(0, -1);
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			// we are checking that the same sum is present previously or not
			// if present then the sum of in between nums are 0
			if (prefixSum.containsKey(sum)) {
				maxLen = Math.max(maxLen, i - prefixSum.get(sum));
			} else {
				// else add the sum in the prefixsum map with the current index,
				// we will not update the index of sum even if we find the same sum again
				prefixSum.put(sum, i);
			}
		}
		System.out.println("max length is " + maxLen);
	}
```

### Approach 2

prefix sum approach up to this point, if the sum is 0 then, the length will be i+1 we are checking that the same sum is present previously or not if present then the sum of in between nums are 0 else add the sum in the prefixsum map with the current index, we will not update the index of sum even if we find the same sum again

**Time Complexity:** `O(n)`

```java
	private static void type2() {
		int[] nums = { 15, -2, 2, -8, 1, 7, 10, 23 };
		int n = nums.length, maxLength = 0, sum = 0;
		Map<Integer, Integer> prefixSum = new HashMap<>();
		for (int i = 0; i < n; i++) {
			sum = sum + nums[i];
			// up to this point, if the sum is 0 then, the length will be i+1
			if (sum == 0) {
				maxLength = i + 1;
			}
			// we are checking that the same sum is present previously or not
			// if present then the sum of in between nums are 0
			if (prefixSum.containsKey(sum)) {
				maxLength = Math.max(maxLength, i - prefixSum.get(sum));
			} else {
				// else add the sum in the prefixsum map with the current index,
				// we will not update the index of sum even if we find the same sum again
				prefixSum.put(sum, i);
			}
		}
		System.out.println("max length is " + maxLength);
	}
```

### Approach 1: 🔨 Brute Force

brute force

**Time Complexity:** `O(n^2)`
**Space Complexity:** `O(1)`

```java
	private static void type1() {
		int[] nums = { 15, -2, 2, -8, 1, 7, 10, 23 };
		int sum, maxLength = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum = sum + nums[j];
				if (sum == 0)
					maxLength = Math.max((j - i + 1), maxLength);
			}
		}
		System.out.println("max length is " + maxLength);
	}

}
```
