package com.ds.heap;

import com.util.ArrayUtil;

import java.util.ArrayList;
import java.util.PriorityQueue;
/*
 * Problem link :
 * https://www.geeksforgeeks.org/problems/nearly-sorted-1587115620/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=dYfM6J1y0mU&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=4
 *
 * https://www.geeksforgeeks.org/nearly-sorted-algorithm/
 * */
public class SortKSortedArray {
	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		int[] nums = {6, 5, 3, 2, 8, 10, 9};
		int k = 3;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		ArrayList<Integer> answer = new ArrayList<>();
		for (int num : nums) {
			if (minHeap.size() <= k) {
				minHeap.offer(num);
			} else {
				answer.add(minHeap.poll());
				minHeap.offer(num);
			}
		}
		while (answer.size() < nums.length) answer.add(minHeap.poll());

		ArrayUtil.print(nums);
	}

	// Brute force approach
	public static void type1() {

	}

}
