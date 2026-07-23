# SortArray

**Topic:** `recursion`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/sort-the-array0055/1)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=AZ4jEY_JAVc&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=6)

## 📝 Problem Statement

Given an unsorted array arr[] of numbers, sort the array in ascending order.
Examples:
Input: arr[] = [1, 5, 3, 2]
Output: [1, 2, 3, 5]
Explanation: After sorting, array will be like [1, 2, 3, 5].
Input: arr[] = [3, 1]
Output: [1, 3]
Explanation: Aft

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

When the size of an array is 1, then we will return as a single element array is already sorted sort n-1 elements now pick the last element that was remaining and place if it's an appropriate place we will shift the item to the right, till we find the perfect place as last < arr[i] will hold no more, so i+1 is the place for that element

```java
	private static void type1() {
		int[] arr = { 5, 2, 7, 1, 6, 9, 8, 3, 4 };
		int n = arr.length;
		print(arr);
		sort(arr, n);
		print(arr);
	}

	private static void sort(int[] arr, int n) {
		// When the size of an array is 1, then we will return
		// as a single element array is already sorted
		if (n == 1) return;
		// sort n-1 elements
		sort(arr, n - 1);
		// now pick the last element that was remaining and place if it's an appropriate place
		int last = arr[n - 1];
		int i = n - 2;
		while (i >= 0 && last < arr[i]) {
			// we will shift the item to the right, till we find the perfect place
			arr[i + 1] = arr[i];
			i--;
		}
		// as last < arr[i] will hold no more, so i+1 is the place for that element
		arr[i + 1] = last;
	}

}
```
