# TwoSum

**Topic:** `array` | **File:** `com/problems/array/TwoSum.java`

**Tags:** Array, Hashing, two-pointer

## Problem Statement

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target. You may assume that each input would have exactly one solution, and you may not use the same element twice.

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/two-sum/description/)
- [📄 NeetCode](https://neetcode.io/problems/two-integer-sum)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/pair-sum_697295)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=UXDSeD9mN-k&t=1s)
- [▶ YouTube](https://www.youtube.com/watch?v=dRUpbt8vHpo&list=PLgUwDviBIf0rVwua0kKYlsS_ik_1lyVK_&index=3)
- [📄 takeUforward](https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-sum-exists-in-array/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimized approach using hashmap we will store the [num, index] to the map and for every num we will check if we can find target-num from the map Time complexity O(n) space complexity O(n)

**Complexity:** Time: o(n) | Space: o(n)

```java
private static void type2() {
		int[] nums = {2, 11, 15, 7};
		int target = 9;
		int[] answer = twoSum2(nums, target);
		System.out.printf("indexes are %d,%d%n", answer[0], answer[1]);
	}
	private static int[] twoSum2(int[] nums, int target) {
		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int num1 = target - nums[i];
			if (map.containsKey(num1)) {
				return new int[]{map.get(num1), i};
			}
			map.put(nums[i], i);
		}
		return new int[2];
	}
```

### Approach 1 — Brute Force

Brute force Time complexity O(n^2) space complexity O(1)

**Complexity:** Time: o(n^2) | Space: o(1)

```java
private static void type1() {
		int[] nums = {2, 11, 15, 7};
		int target = 9;
		int[] answer = twoSum1(nums, target);
		System.out.printf("indexes are %d,%d%n", answer[0], answer[1]);
	}
	private static int[] twoSum1(int[] nums, int target) {
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[]{i, j};
				}
			}
		}
		return new int[2];
	}
```
