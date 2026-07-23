# MinimumMultiplicationsToReachEnd

**Topic:** `graph` | **File:** `com/problems/graph/MinimumMultiplicationsToReachEnd.java`

## Problem Links

- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=_BvEJ3VIDWw&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=39)
- [📄 takeUforward](https://takeuforward.org/graph/g-39-minimum-multiplications-to-reach-end/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Given start, end and an array arr of n numbers. At each step, start is multiplied with any number in the array and then mod operation with 100,000 is done to get the new start. Your task is to find the minimum steps in which end can be achieved starting from start. If it is not possible to reach to the end, then return -1. using bfs, we don't have to store the level as we are increasing the level by 1 only

```java
private static void type2() {
		int[] arr = { 2, 5, 7 };
		int start = 3;
		int end = 30;
		int ans = minimumMultiplications2(arr, start, end);
		System.out.println(ans);

	}
```

### Approach 1 — Brute Force

As we know that all the item will range from 0 to pivot, so we can just use an array here we will not store the level in the queue, we will check the current level of the queue then add a new level we will apply Dijkstra here, but we will use queue in place of Priority Queue, as we are going via level wise

```java
private static void type1() {
		int[] arr = { 2, 5, 7 };
		int start = 3;
		int end = 30;
		int ans = minimumMultiplications1(arr, start, end);
		System.out.println(ans);

	}
```
