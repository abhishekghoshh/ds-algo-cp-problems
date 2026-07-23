# KthSmallestElement

**Topic:** `heap` | **File:** `com/problems/heap/KthSmallestElement.java`

## Problem Links

- [📄 InterviewBit](https://www.interviewbit.com/problems/kth-smallest-element-in-the-array/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=4BfL2Hjvh8g&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=2)
- [📄 takeUforward](https://takeuforward.org/data-structure/kth-largest-smallest-element-in-an-array/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Partition mechanism

```java
private static void type2() {
		int[] nums = { 1, 4, 6, 2, 8, 5, 3, 7, 0 };
		int k = 3;
		int low = 0, high = nums.length - 1, answer = -1;
		while (low <= high) {
			// we will use the partition technique used is quick sort
			// after one partition the one item will be placed in it's place
			// and all lesser elements will be placed in it's left and all larger elements
			// will be placed in it's right
			int idx = partition(nums, low, high);
			// if idx == k-1 then we can just return the idx element
			if (idx == k - 1) {
				answer = nums[idx];
				break;
			}
			// else depending upon the idx value we will shrink the array size
			if (idx < k - 1) low = idx + 1;
			else high = idx - 1;
		}
		System.out.println(answer);
	}
	private static int partition(int[] nums, int low, int high) {
		int pivot = nums[low];
		int left = low + 1;
		int right = high;
		while (left <= right) {
			if (nums[left] > pivot && pivot > nums[right]) {
				swap(nums, left, right);
				left++;
				right--;
			}
			if (nums[left] <= pivot) left++;
			if (nums[right] >= pivot) right--;
		}
		swap(nums, low, right);
		// after this, all elements before r will be lesser than arr[r] and all elements
		// after r will be greater than arr[r]
		return right;
	}
```

### Approach 1 — Brute Force

Quick sort partition mechanism using heap we will use max heap and only store the k largest elements in the heap after all the iteration we will return the heap top element

```java
private static void type1() {
		int[] nums = { 1, 4, 6, 2, 8, 5, 3, 7, 0 };
		int k = 3;
		// now we will take max heap
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		for (int num : nums) {
			if (maxHeap.size() < k) {
				maxHeap.offer(num);
			} else {
				if (maxHeap.peek() > num) {
					maxHeap.poll();
					maxHeap.offer(num);
				}
			}
		}
		System.out.println(maxHeap.peek());
	}
```
