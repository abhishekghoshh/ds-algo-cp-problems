# FindPeakElement

**Topic:** `binarysearch`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/find-peak-element/submissions/)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/find-peak-element_1081482)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=cXxmbemS6XM)
- [▶ YouTube](https://www.youtube.com/watch?v=OINnBJTRrMU&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=17)
- [📄 takeUforward](https://takeuforward.org/data-structure/peak-element-in-array/)

## 📝 Problem Statement

in one array, there can be multiple peaks

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 3

in one array, there can be multiple peaks

```java
	private static void type3() {
		int[] nums = {5, 25, 20, 15, 2, 23, 90, 67};
		int index = findPeakElement(nums);
		System.out.printf("arr[%d] : %d%n", index, nums[index]);
	}

	// in one array, there can be multiple peaks
	public static int findPeakElement(int[] nums) {
		int n = nums.length;
		if (n == 1 || nums[0] > nums[1]) return 0;
		if (nums[n - 1] > nums[n - 2]) return n - 1;
		int low = 0, high = n - 1, mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) return mid;
			if (nums[mid + 1] > nums[mid]) low = mid + 1;
			else high = mid - 1;
		}
		return -1;
	}
```

### Approach 2: 🏆 Optimal Solution

A peak element is an element that is strictly greater than its neighbors. nums = [1,2,1,3,5,6,4] Output: 5 Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

```java
	private static void type2() {
		int nums[] = { 5, 25, 20, 15, 2, 23, 90, 67 };
		int low = 0;
		int high = nums.length - 1;
		int index = findPeak(nums, low, high, nums.length);
		System.out.printf("arr[%d] : %d%n", index, nums[index]);
	}

	private static int findPeak(int[] nums, int low, int high, int n) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid > 0 && mid < n - 1) {
				if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
					return mid;
				} else if (nums[mid] > nums[mid - 1]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else if (mid == 0) {
				return nums[0] > nums[1] ? 0 : 1;
			} else {
				return nums[n - 1] > nums[n - 2] ? n - 1 : n - 2;
			}
		}
		return -1;
	}

}
```
