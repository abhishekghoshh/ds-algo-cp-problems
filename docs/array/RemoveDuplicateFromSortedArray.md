# RemoveDuplicateFromSortedArray

**Topic:** `array` | **File:** `com/problems/array/RemoveDuplicateFromSortedArray.java`

**Tags:** Array, Two pointer

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/1102307)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=37E9ckMDdTk&t=1702s)
- [▶ YouTube](https://www.youtube.com/watch?v=Fm_p9lJ4Z_8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=44)
- [📄 takeUforward](https://takeuforward.org/data-structure/remove-duplicates-in-place-from-sorted-array/)
- [▶ YouTube](https://www.youtube.com/watch?v=DEJAZBq0FDA)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Same two pointers approach time complexity O(n) space complexity O(1)

**Complexity:** Time: o(n) | Space: o(1)

```java
private static void type3() {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4 };
		int ans = removeDuplicates3(nums);
		System.out.println(ans);
	}
	private static int removeDuplicates3(int[] nums) {
		int i = 0, n = nums.length;
		// we are taking from j=1 as nums[0] is already in its place
		for (int j = 1; j < n; j++) {
			// when we find a new element at that time, we are only changing nums[i]
			if (nums[i] != nums[j]) {
				nums[++i] = nums[j];
			}
		}
		return i + 1;
	}
```

### Approach 2

Two pointers approach time complexity O(n) space complexity O(1)

**Complexity:** Time: o(n) | Space: o(1)

```java
private static void type2() {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4 };
		int ans = removeDuplicates2(nums);
		System.out.println("count is " + ans);
	}
	private static int removeDuplicates2(int[] nums) {
		int left = 0, right = 0, n = nums.length;
		while (right < n) {
			// we will increase the right until it found a new element
			// for the last element like 4, right will go till n and stops
			while (right < n && nums[left] == nums[right]) {
				right++;
			}
			left++;
			// left+1 will be the position of the new element
			// for the last element right is n, that's why it terminates,
			// so there is no new element
			if (right < n) {
				nums[left] = nums[right];
			}
		}
		return left;
	}
```

### Approach 1 — Brute Force

Brute force approach time complexity O(n*log(n)+n) space complexity O(n) for adding items a tree set for every element it will check it's next element

**Complexity:** Time: o(n*log(n) | Space: o(n)

```java
private static void type1() {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4 };
		int ans = removeDuplicates1(nums);
		System.out.println(ans);
	}
	private static int removeDuplicates1(int[] nums) {
		Set<Integer> set = new TreeSet<>();
		for (int num : nums)
			set.add(num);
		int i = 0;
		for (int item : set)
			nums[i++] = item;
		return i;
	}
```
