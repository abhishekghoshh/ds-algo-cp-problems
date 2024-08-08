package com.problems.graph;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=_BvEJ3VIDWw&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=39
 * 
 * https://takeuforward.org/graph/g-39-minimum-multiplications-to-reach-end/
 */
public class MinimumMultiplicationsToReachEnd {

	// Given start, end and an array arr of n numbers. At each step, start is
	// multiplied with any number in the array and then mod operation with 100,000 is
	// done to get the new start.

	// Your task is to find the minimum steps in which end can be achieved starting from start.
	// If it is not possible to reach to the end, then return -1.
	public static void main(String[] args) {
		type1();
		type2();
	}

	// using bfs,
	// we don't have to store the level
	// as we are increasing the level by 1 only
	private static void type2() {
		int[] arr = { 2, 5, 7 };
		int start = 3;
		int end = 30;

		int PIVOT = 100000;
		int level = 0;

		// as we know that all the item will range from 0 to pivot
		// so we can just use an array
		boolean[] set = new boolean[PIVOT + 1];
		set[start] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int node = queue.poll();
				if (node == end) {
					System.out.println(level);
					return;
				}
				for (int item : arr) {
					int sum = (node * item) % PIVOT;
					if (!set[sum]) {
						set[sum] = true;
						queue.offer(sum);
					}
				}
			}
			level++;
		}
		System.out.println(-1);
	}

	private static void type1() {
		int[] arr = { 2, 5, 7 };
		int start = 3;
		int end = 30;
		int ans = minimumMultiplications1(arr, start, end);
		System.out.println(ans);

	}

	static int minimumMultiplications1(int[] arr, int start, int end) {
		int PIVOT = 100000;
		// as we know that all the item will range from 0 to pivot, so we can just use an array
		boolean[] set = new boolean[PIVOT + 1];
		set[start] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{start, 0});
		while (!queue.isEmpty()) {
			int[] pair = queue.poll();
			int node = pair[0];
			int lvl = pair[1];
			if (node == end) return lvl;
			for (int item : arr) {
				int sum = (node * item) % PIVOT;
				if (!set[sum]) {
					set[sum] = true;
					queue.offer(new int[]{sum, lvl + 1});
				}
			}
		}
		return -1;
	}
}
