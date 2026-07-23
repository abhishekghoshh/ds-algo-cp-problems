# LongestConsecutiveSequence

**Topic:** `array`  
**Tags:** Array, Hashing

## 📝 Problem Statement

Given an unsorted array of integers nums = [100,4,200,1,3,2],
return the length of the longest consecutive elements sequence.
The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/longest-consecutive-sequence/description/)
- [📄 NeetCode](https://neetcode.io/problems/longest-consecutive-sequence)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/759408)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=qgizvmgeyUM)
- [▶ YouTube](https://www.youtube.com/watch?v=oO5uLE7EUlM)
- [▶ YouTube](https://www.youtube.com/watch?v=P6RZZMu_maU)
- [📄 takeUforward](https://takeuforward.org/data-structure/longest-consecutive-sequence-in-an-array/)

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

same as previous type 2 there is a chance of getting memory limit exceeding also playing with indices is tricky sometime in place of set here we will use a boolean array

```java
	private static void type3() {
		int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
		int maxLen = longestConsecutive3(nums);
		System.out.println("max length is " + maxLen);
	}

	// in place of set here we will use a boolean array
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

optimal approach finds the least element method we will check if the item is the lowest item or not that means item-1 not present in the set from that we will check that item+1 present or not item-1 not present it is the lowest element in that series we will check

**Time Complexity:** `O(3n)`
**Space Complexity:** `O(n)`

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

### Approach 1: 🔨 Brute Force

brute force approach sort the array then linearly traverse if the prev is current then we can skip if num is prev+1 then we will update the len and check for max len


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

}
```
