# KLargestElementInAnArray

**Topic:** `heap` | **File:** `com/problems/heap/KLargestElementInAnArray.java`

## Problem Links

- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/k-largest-elements3736/1)
- [📄 InterviewBit](https://www.interviewbit.com/problems/k-largest-elements/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=3DdP6Ef8YZM&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=3)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Using priority queue

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

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {

	}
```
