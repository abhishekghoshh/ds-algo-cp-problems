# InversionCount

**Topic:** `segmenttree` | **File:** `com/problems/segmenttree/InversionCount.java`

## Problem Links

- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1)
- [https://www.spoj.com/problems/INVCNT/](https://www.spoj.com/problems/INVCNT/)
- [📄 LeetCode](https://leetcode.com/problems/count-of-smaller-numbers-after-self/)

## Solution Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/inversion-count-in-array-using-merge-sort/)
- [https://www.javatpoint.com/inversion-count](https://www.javatpoint.com/inversion-count)
- [▶ YouTube](https://www.youtube.com/watch?v=NOykDuH1_OY)

## Approaches

This problem has **4** approaches, progressing from brute force to optimal:

### Approach 4 — Optimal

See the last 30 minutes of codebeyond channel segment tree masterclass part 1 this problem can also be solved using the merge sort approach. but here we will use the segment tree to solve, but the time complexity will be a little higher. we can also use fenwick tree to solve this the previous type can be optimized it will also take 0 and negative numbers also check the CountOfSmallerNumbersAfterSelf.type2 todo complete it later

```java
private static void type4() {
	}
```

### Approach 3

The problems which can be done using segment tree could also be using fenwick tree we will use the same technique as the type 2 fenwick tree is a 1 indexed tree, so we have to add for 0 manually we will not use any negative numbers here

```java
private static void type3() {
		int[] nums = {2, 0, 5, 1, 3, 4, 0, 2, 0, 1, 0};
		int n = nums.length;
		int max = 0;
		// first we will be calculating the max number and will create an array for holding all of this
		for (int num : nums) max = Math.max(max, num);
		int[] freq = new int[max + 1];
		for (int num : nums) freq[num]++;
		// now we will use a sum segment tree to calculate the range frequency sums
		int count = 0;
		// creating the fenwick tree
		// there is another approach of doing this, we can clone the num and only add the nums to its immediate parent
		int[] tree = new int[max + 1];
		for (int i = 1; i <= max; i++) {
			int bit = i;
			while (bit <= max) {
				tree[bit] += freq[i];
				bit += (bit & (-bit)); // adding the last set bit
			}
		}
		// now we will compute the range sums
		for (int i = 0; i < n; i++) {
			// first we will decrease the number frequency because we are currently operating on it,
			// and it will not be required for the future calculations
			int num = nums[i];
			freq[num]--;
			// if nums is 0 then we do not need to compute the remaining things here
			if (num == 0) continue;
			// we will update a segment tree with current frequency and query range frequency sum for (0,num-1)
			update(tree, max, num, -1);
			count += query(tree, num - 1);
			// adding the frequency of 0 manually
			count += freq[0];
		}
		System.out.println(count);
	}
```

### Approach 2

We will use segment tree for this at first we will take the frequencies of all the elements so our array will be something like 0 1 1 3 1 2 We will use a sum segment tree on this and calculate all the range sums now we will iterate on all the number on original array and when we use a particular number we just decrease its frequency at first if the number is 5 then we will search for 0 to 4 in the tree as we are also removing the frequencies we surely know that the current tree only holds the numbers which are right to the current number. and we will take the frequency sums for (0,4) which will be the inversion count for current 5

```java
private static void type2() {
		int[] nums = {2, 0, 5, 1, 3, 4, 0, 2, 0, 1, 0};
		int n = nums.length;
		int max = 0;
		// first we will be calculating the max number and will create an array for holding all of this
		for (int num : nums) max = Math.max(max, num);
		int[] freq = new int[max + 1];
		for (int num : nums) freq[num]++;
		// now we will use a sum segment tree to calculate the range frequency sums
		int count = 0;
		SumSegmentTree.SegmentTree segmentTree = new SumSegmentTree.SegmentTree(freq);
		for (int i = 0; i < n; i++) {
			// first we will decrease the number frequency because we are currently operating on it,
			// and it will not be required for the future calculations
			int num = nums[i];
			freq[num]--;
			// we will update a segment tree with current frequency and query range frequency sum for (0,num-1)
			segmentTree.update(num, freq[num]);
			count += segmentTree.sum(0, num - 1);
		}
		System.out.println(count);
	}
```

### Approach 1 — Brute Force

Brute force time complexity O(n^2) space complexity O(1)

**Complexity:** Time: o(n^2) | Space: o(1)

```java
private static void type1() {
		int[] nums = {2, 0, 5, 1, 3, 4, 0, 2, 0, 1, 0};
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) count++;
			}
		}
		System.out.println(count);
	}
```
