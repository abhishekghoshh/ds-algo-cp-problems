# SortArrayByIncreasingFrequency

**Topic:** `heap` | **File:** `com/problems/heap/SortArrayByIncreasingFrequency.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/sort-array-by-increasing-frequency/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=hLR5aMzYGGk&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=7)

## Approaches

This problem has **4** approaches, progressing from brute force to optimal:

### Approach 4 — Optimal

Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order. 1 <= nums.length <= 100 -100 <= nums[i] <= 100 so we could use this

```java
private static void type4() {
		int[] nums = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
		int n = nums.length;
		// as the range is given as -100 <= nums[i] <= 100
		int[] freq = new int[201];
		for (int num : nums) freq[num + 100]++;
		for (int i = 0; i < n; i++)
			nums[i] = freq[nums[i] + 100] * 1000 + (100 - nums[i]);
		Arrays.sort(nums);
		for (int i = 0; i < n; i++)
			nums[i] = 100 - nums[i] % 1000;
		print(nums);
	}
```

### Approach 3

Same as previous just we are using array instead of map

```java
private static void type3() {
		int[] nums = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
		int[] freq = new int[201];
		int offset = 100;
		for (int num : nums) freq[num + offset]++;
		PriorityQueue<Integer> heap = new PriorityQueue<>(
				(a, b) -> (freq[a] != freq[b]) ? freq[a] - freq[b] : b - a
		);
		for (int i = 0; i < 201; i++)
			if (freq[i] != 0) heap.offer(i);
		int j = 0;

		while (!heap.isEmpty()) {
			int n = heap.poll();
			for (int i = 0; i < freq[n]; i++)
				nums[j++] = n - offset;
		}
		print(nums);
	}
```

### Approach 2

Same as previous just a little compact

```java
private static void type2() {
		int[] nums = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
		Map<Integer, Integer> freq = new HashMap<>();
		for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);
		PriorityQueue<Integer> heap = new PriorityQueue<>(
				(a, b) -> Objects.equals(freq.get(a), freq.get(b)) ? b - a : freq.get(a) - freq.get(b));
		heap.addAll(freq.keySet());
		int j = 0;
		while (!heap.isEmpty()) {
			int n = heap.poll();
			for (int i = 0; i < freq.get(n); i++)
				nums[j++] = n;
		}
		print(nums);
	}
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
		int[] nums = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
		Map<Integer, Integer> freq = new HashMap<>();
		for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);
		PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2) ->
				(p1[1] != p2[1]) ?
						(p1[1] - p2[1]) : (p2[0] - p1[0])// as decreasing order required
		);
		for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			heap.offer(new int[]{entry.getKey(), entry.getValue()});
		}
		int[] answer = new int[nums.length];
		int j = 0;
		while (!heap.isEmpty()) {
			int[] pair = heap.poll();
			for (int i = 0; i < pair[1]; i++)
				answer[j++] = pair[0];
		}
		print(answer);
	}
```
