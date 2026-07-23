# FindPositionInInfiniteSortedArray

**Topic:** `binarysearch` | **File:** `com/problems/binarysearch/FindPositionInInfiniteSortedArray.java`

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=FzvK5uuaki8&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=13)
- [📄 LeetCode](https://leetcode.com/discuss/interview-experience/1979273/infinite-sorted-array)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach

```java
private static void type2() {
		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		int target = 13;
		int low = 0, high = 1, n = arr.length;
		// first, we will find the low and high boundary
		while (arr[high] < target) {
			low = high;
			high = high * 2;
		}
		if (high >= n) high = n - 1;
		int index = search(arr, low, high, target);
		System.out.println(index);
	}
	private static int search(int[] arr, int low, int high, int target) {
		int mid;
		while (low <= high) {
			mid = low + ((high - low) >> 1);
			if (arr[mid] == target) return mid;
			else if (arr[mid] < target) low = mid + 1;
			else high = mid - 1;
		}
		return -1;
	}
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {

	}
```
