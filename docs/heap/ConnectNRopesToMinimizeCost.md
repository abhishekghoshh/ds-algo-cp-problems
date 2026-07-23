# ConnectNRopesToMinimizeCost

**Topic:** `heap` | **File:** `com/problems/heap/ConnectNRopesToMinimizeCost.java`

## Problem Links

- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/connect-n-ropes-with-minimum-cost_625783)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=_k_c9nqzKN0&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=9)

## Approaches

Implementation:

### Implementation

There are given N ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to sum of their lengths. The task is to connect the ropes with minimum cost. Given N size array arr[] contains the lengths of the ropes. Using Heap the intuition is first connect the lower ropes this way we can minimize the cost

```java
private static void type1() {
		int[] ropes = {4, 3, 2, 6};
		// we will use a min heap get the lowest two ropes,
		// then again we will push that into the heap
		// this process will run until there is only one rope
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int item : ropes) minHeap.offer(item);
		int cost = 0, rod1, rod2, length;
		while (minHeap.size() >= 2) {
			rod1 = minHeap.poll();
			rod2 = minHeap.poll();
			length = rod1 + rod2;
			cost += length;
			minHeap.offer(length);
		}
		System.out.println(cost);
	}
```
