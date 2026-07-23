# LongestConsecutiveSequence

**Topic:** `array` | **File:** `com/problems/array/LongestConsecutiveSequence.java`

**Tags:** Array, Hashing

## Problem Statement

Given an unsorted array of integers nums = [100,4,200,1,3,2], return the length of the longest consecutive elements sequence. The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/longest-consecutive-sequence/description/)
- [📄 NeetCode](https://neetcode.io/problems/longest-consecutive-sequence)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/759408)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=qgizvmgeyUM)
- [▶ YouTube](https://www.youtube.com/watch?v=oO5uLE7EUlM)
- [▶ YouTube](https://www.youtube.com/watch?v=P6RZZMu_maU)
- [📄 takeUforward](https://takeuforward.org/data-structure/longest-consecutive-sequence-in-an-array/)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Special notice : In leetcode type1 approach is taking the least time same as previous type 2 there is a chance of getting memory limit exceeding also playing with indices is tricky sometime

```java
private static void type3() {
		int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
		int maxLen = longestConsecutive3(nums);
		System.out.println("max length is " + maxLen);
	}
	private static int longestConsecutive3(int[] nums) {
		int len, maxLen = 0, start;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i : nums) {
			if (i < min) min = i;
			if (i > max) max = i;
		}
		int N = max - min + 1, offset = -min;
		boolean[] set = new boolean[N];
		for (int num : nums) set[num + offset] = true;
		for (int num : nums) {
			start = (num - min) - 1;
			if (start < 0 || !set[start]) {
				start = start + 1;
				len = 0;
				while (start <= (max - min) && set[start]) {
					start++;
					len++;
				}
				maxLen = Math.max(maxLen, len);
			}
		}
		return maxLen;
	}
```

### Approach 2

In place of set here we will use a boolean array optimal approach finds the least element method time complexity O(3n) space complexity O(n)

**Complexity:** Time: o(3n) | Space: o(n)

```java
private static void type2() {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		int ans = longestConsecutive2(nums);
		System.out.println("max length is " + ans);
	}
	private static int longestConsecutive2(int[] nums) {
		int maxLen = 0;
		Set<Integer> set = new HashSet<>();
		for (int item : nums) set.add(item);
		// we will check if the item is the lowest item or not
		// that means item-1 not present in the set
		// from that we will check that item+1 present or not
		for (int item : nums) {
			// item-1 not present it is the lowest element in that series
			if (!set.contains(item - 1)) {
				// we will check
				int curr = item;
				int len = 0;
				while (set.contains(curr)) {
					len++;
					curr++;
				}
				maxLen = Math.max(len, maxLen);
			}
		}
		return maxLen;
	}
```

### Approach 1 — Brute Force

Brute force approach sort the array then linearly traverse time complexity o(n*log(n)) space complexity o(n) if we copy the original array

**Complexity:** Time: o(n*log(n) | Space: o(n)

```java
private static void type1() {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		int ans = longestConsecutive1(nums);
		System.out.println(ans);
	}
	public static int longestConsecutive1(int[] nums) {
		if (nums.length == 0) return 0;
		Arrays.sort(nums);
		int prev = nums[0] - 1;
		int len = 0, maxLen = 0;
		for (int num : nums) {
			// if the prev is current then we can skip
			if (num == prev) continue;
			// if num is prev+1 then we will update the len and check for max len
			if (num == prev + 1) {
				len++;
				maxLen = Math.max(len, maxLen);
			} else {
				len = 1;
			}
			prev = num;
		}
		return maxLen;
	}
```
