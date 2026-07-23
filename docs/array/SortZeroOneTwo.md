# SortZeroOneTwo

**Topic:** `array`  
**Tags:** Arrays, sorting, hashing, Dutch national flag algorithm 3 pointer

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/sort-colors/description/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/sort-an-array-of-0s-1s-and-2s_892977)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/631055)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=tp8JIuCXBaU)
- [▶ YouTube](https://www.youtube.com/watch?v=oaVa-9wmpns&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=2)
- [▶ YouTube](https://www.youtube.com/watch?v=4xbWSRZHqac)
- [📄 takeUforward](https://takeuforward.org/data-structure/sort-an-array-of-0s-1s-and-2s/)
- [https://www.hellointerview.com/learn/code/two-pointers/sort-colors](https://www.hellointerview.com/learn/code/two-pointers/sort-colors)

## 📝 Problem Statement

Given an array with only 0s, 1s, and 2s, sort it in-place without using any sorting algorithm (Dutch National Flag).

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

in place ordering using three pointer NOTE Dutch national flag algorithm 3 pointer NOTE this solution is failing for some test cases in leetcode

```java
	private static void type3() {
		int[] arr = { 2, 0, 2, 1, 1, 0, 0, 2, 1, 0, 2, 1, 0 };
		sortColors3(arr);
		print(arr);
	}

	private static void sortColors3(int[] arr) {
		int n = arr.length;
		int low = 0, mid = 0, high = n - 1;
		while (mid <= high) {
			if (arr[mid] == 0) {
				swap(arr, low, mid);
				low++;
				mid++;
			} else if (arr[mid] == 1) {
				mid++;
			} else {
				while (mid <= high && arr[high] == 2) {
					high--;
				}
				swap(arr, mid, high);
				high--;
			}
		}
	}
```

### Approach 2

counting sort count the occurrence of 0,1,2 it will solve in o(n) but the loop will run twice explain this approach in the interview

```java
	private static void type2() {
		int[] arr = { 2, 0, 2, 1, 1, 0, 0, 2, 1, 0, 2, 1, 0 };
		sortColors2(arr);
		print(arr);
	}

	private static void sortColors2(int[] arr) {
		int n = arr.length;
		int[] freq = {0, 0, 0};
		for (int item : arr) freq[item]++;
		int i = 0;
		int num = 0;
		while (i < n) {
			if (freq[num] == 0) {
				num++;
			} else {
				arr[i++] = num;
				freq[num]--;
			}
		}
	}
```

### Approach 1: 🔨 Brute Force

brute force approaches sort the array with o(NLogN) complexity

```java
	private static void type1() {
		int[] arr = { 2, 0, 2, 1, 1, 0, 0, 2, 1, 0, 2, 1, 0 };
		sortColors1(arr);
		print(arr);
	}

	private static void sortColors1(int[] arr) {
		Arrays.sort(arr);
	}

}
```
