# ReverseOfAnArray

**Topic:** `recursion` | **File:** `com/problems/recursion/ReverseOfAnArray.java`

## Problem Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/reverse-an-array/0)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=twuC1F6gLI8)
- [📄 takeUforward](https://takeuforward.org/data-structure/reverse-a-given-array/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Using recursive way

```java
private static void type2() {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		print(arr);
		reverse(arr, 0, arr.length - 1);
		print(arr);
	}
	private static void reverse(int[] arr, int start, int end) {
		if (start >= end) return;
		// swap the start and end then cal reverse again with start+1 and end-1
		swap(arr, start, end);
		// call the reverse function again
		reverse(arr, start + 1, end - 1);
	}
```

### Approach 1 — Brute Force

Using iterative way

```java
private static void type1() {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int left = 0, right = arr.length - 1;
		while (left < right) {
			swap(arr, left++, right--);
		}
		print(arr);
	}
	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
```
