# SortKSortedArray

**Topic:** `heap` | **File:** `com/problems/heap/SortKSortedArray.java`

## Problem Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/nearly-sorted-1587115620/1)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=dYfM6J1y0mU&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=4)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/nearly-sorted-algorithm/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Given an array of N elements, where each element is at most K away from its target position, devise an algorithm that sorts in O(N log K) time. time complexity  O(NlogK)

**Complexity:** Time: o(nlogk)

```java
private static void type2() {
		int[] nums = {6, 5, 3, 2, 8, 10, 9};
		int k = 3;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		ArrayList<Integer> answer = new ArrayList<>();
		for (int num : nums) {
			// at means after k+1 times of adding,
			// we will get the item
			// like for the series 6 5 3 2
			// for getting 0th element we have to add k+1
			// element in the heap
			if (minHeap.size() <= k) {
				// the max size of heap can be k+1
				minHeap.offer(num);
			} else {
				answer.add(minHeap.poll());
				minHeap.offer(num);
			}
		}
		// after all the iteration, there should be some elements
		// in the heap; we will add them one by one to the answer
		while (!minHeap.isEmpty()) answer.add(minHeap.poll());

		PrintUtl.print(answer);
	}
```

### Approach 1 — Brute Force

Brute force approach

```java
public static void type1() {
		int[] nums = {6, 5, 3, 2, 8, 10, 9};
		int k = 3;
		ArrayList<Integer> answer = new ArrayList<>();
		for (int num : nums)
			answer.add(num);
		Collections.sort(answer);

		PrintUtl.print(answer);
	}
```
