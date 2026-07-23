# KLargestElementInAnArray

**Topic:** `heap`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/k-largest-elements3736/1)
- [📄 InterviewBit](https://www.interviewbit.com/problems/k-largest-elements/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=3DdP6Ef8YZM&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=3)

## 📝 Problem Statement

Given an array arr[] of positive integers and an integer k, Your task is to return k largest elements in decreasing order.&nbsp;
Examples:
Input: arr[] = [12, 5, 787, 1, 23], k = 2
Output: [787, 23]
Explanation: 1st largest element in the array is 78

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

using priority queue

```java
	private static void type2() {
		int[] nums = { 1, 4, 6, 2, 8, 5, 3, 9, 0, 7 };
		int k = 3;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int item : nums) {
			if (minHeap.size() < k) {
				minHeap.offer(item);
			} else {
				if (minHeap.peek() < item) {
					minHeap.poll();
					minHeap.offer(item);
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		while (!minHeap.isEmpty()) list.add(minHeap.poll());
		System.out.println(list);
	}
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
	private static void type1() {

	}
}
```
