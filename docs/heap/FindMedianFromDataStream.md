# FindMedianFromDataStream

**Topic:** `heap` | **File:** `com/problems/heap/FindMedianFromDataStream.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/find-median-from-data-stream/description/)
- [📄 NeetCode](https://neetcode.io/problems/find-median-in-a-data-stream)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/running-median_625409)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=itmhHWaHupI)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Most optimized heap we will use 2 heaps, one max heap and another min heap if we have n items and store 1st half in the max heap and 2nd half in the

```java
private static void type3() {
		MedianFinder3 medianFinder = new MedianFinder3();
		medianFinder.addNum(1);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(3);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(2);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(7);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(4);
		System.out.println(medianFinder.findMedian());
	}
```

### Approach 2

It will be a max heap it is a min heap here we are not fixing anything after every add num we are re-balancing the left and right heaps we are first checking the left side if the current num is lesser than the max element of left then the num should be on the left side re-balancing the heaps if left size is more than the right then we will return highest from the left else we will return the min from the right if same then we will take the average

```java
private static void type2() {
		MedianFinder2 medianFinder = new MedianFinder2();
		medianFinder.addNum(1);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(3);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(2);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(7);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(4);
		System.out.println(medianFinder.findMedian());
	}
```

### Approach 1 — Brute Force

The left part will be our max heap the right part will be our min heap this is the left series with max heap property this is the right series min heap property we will apply one policy leftSize<=rightSize right heap Size - left heap Size will be at max 1 at first, we will blindly add num in left heap Now we will check our condition. If left size is greater than right size or the last item which we have just added is greater than the peek of the right side, then we will pop from the left and add it right let say leftHalf.peek() > rightHalf.peek() this criteria held, and we have added to the right side, but in the right there was already one extra element now it has two extra elements so, we have to pop one from the right to make the size difference as 1

```java
private static void type1() {
		MedianFinder1 medianFinder = new MedianFinder1();
		medianFinder.addNum(1);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(3);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(2);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(7);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(4);
		System.out.println(medianFinder.findMedian());
	}
```
