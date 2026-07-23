# SumBetweenK1thSmallestAndK2thSmallest

**Topic:** `heap`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/sum-of-elements-between-k1th-and-k2th-smallest-elements3133/1)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=3ioQQQrnw4Q&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=10)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/sum-elements-k1th-k2th-smallest-elements/)

## 📝 Problem Statement

Given an array arr[] of positive integers and two integers k1 and k2, find the sum of all array elements whose values lie between the k1-th smallest and the k2-th smallest (both k1th and k2th smallest are not included) of the array.
Examples :
Input:

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

we will only maintain one heap here intuition is coming from the type2 we will maintain a max heap to maintain k2 smallest values we are also excluding the k2'th smallest now we will exclude one by one till there is only k1 elements in the heap

```java
	private static void type3() {
		long k1 = 3;
		long k2 = 6;
		long[] nums = {20, 8, 22, 4, 12, 10, 14};
		// we will maintain a max heap to maintain k2 smallest values
		PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		for (long num : nums) {
			maxHeap.offer(num);
			if (maxHeap.size() > k2) maxHeap.poll();
		}
		// we are also excluding the k2'th smallest
		maxHeap.poll();
		long sum = 0;
		// now we will exclude one by one till there is only k1 elements in the heap
		while (maxHeap.size() > k1) sum += maxHeap.poll();
		System.out.println(sum);
	}
```

### Approach 2

we will maintain two max heap to maintain k1 and k2 smallest values we are also excluding the k2'th smallest from k2-1 th to k1+1 th smallest values are added here

```java
	private static void type2() {
		long k1 = 3;
		long k2 = 6;
		long[] nums = {20, 8, 22, 4, 12, 10, 14};
		// we will maintain two max heap to maintain k1 and k2 smallest values
		PriorityQueue<Long> maxHeap1 = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Long> maxHeap2 = new PriorityQueue<>(Comparator.reverseOrder());
		for (long num : nums) {
			maxHeap1.offer(num);
			if (maxHeap1.size() > k1) maxHeap1.poll();
			maxHeap2.offer(num);
			if (maxHeap2.size() > k2) maxHeap2.poll();
		}
		// we are also excluding the k2'th smallest
		maxHeap2.poll();
		long sum = 0;
		// from k2-1 th to k1+1 th smallest values are added here
		while (maxHeap2.peek() > maxHeap1.peek()) sum += maxHeap2.poll();
		System.out.println(sum);
	}
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
	private static void type1() {
		long k1 = 3;
		long k2 = 6;
		long[] nums = {20, 8, 22, 4, 12, 10, 14};
		Arrays.sort(nums);
		long sum = 0;
		for (long i = k1 + 1; i < k2; i++)
			sum += nums[(int) (i - 1)];
		System.out.println(sum);
	}
}
```
