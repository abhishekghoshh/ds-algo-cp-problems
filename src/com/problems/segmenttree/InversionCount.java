package com.problems.segmenttree;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
 * https://www.spoj.com/problems/INVCNT/
 * 
 * Solution link :
 * https://www.geeksforgeeks.org/inversion-count-in-array-using-merge-sort/
 * https://www.interviewbit.com/blog/count-inversions-of-an-array/
 * https://www.javatpoint.com/inversion-count
 * 
 */
public class InversionCount {

	// see the last 30 minutes of codebeyond channel segment tree masterclass part 1
	// this problem can also be solved using the merge sort approach.
	// but here we will use the segment tree to solve, but the time complexity will be a little higher.
	// we can also use fenwick tree to solve this
	public static void main(String[] args) {
		type1();
		type2();
	}

	// we will use segment tree for this
	// at first we will take the frequencies of all the elements
	// so our array will be something like 0 1 1 3 1 2
	// We will use a sum segment tree on this and calculate all the range sums
	// now we will iterate on all the number on original array and
	// when we use a particular number we just decrease its frequency at first
	// if the number is 5 then we will search for 0 to 4 in the tree
	// as we are also removing the frequencies we surely know that the current tree only holds
	// the numbers which are right to the current number.
	// and we will take the frequency sums for (0,4) which will be the inversion count for current 5
	private static void type2() {
		int[] nums = {2, 5, 1, 3, 4};
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

	// brute force
	// time complexity O(n^2)
	// space complexity O(1)
	private static void type1() {
		int[] nums = {2, 5, 1, 3, 4};
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) count++;
			}
		}
		System.out.println("Count is " + count);
	}

}
