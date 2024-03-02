package com.algo.sort;

import java.util.Stack;

import static com.util.PrintUtl.print;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/merge-sort/1
 * 
 * Solution link :
 * https://takeuforward.org/data-structure/merge-sort-algorithm/
 * https://www.geeksforgeeks.org/merge-sort/
 * 
 */
public class MergeSort {

	public static void main(String[] args) {
//		type1();
		type2();
	}

	// we will try to mimic the recursion using a stack
	private static void type2() {
		int[] arr = {9, 7, 5, 3, 15, 13, 2, 8, 1};
		int n = arr.length;

		Stack<Pair> unsorted = new Stack<>();
		Stack<Pair> sorted = new Stack<>();

		unsorted.push(new Pair(0, n - 1, 0));

		while (!unsorted.isEmpty()) {
			while (unsorted.peek().start < unsorted.peek().end) {
				Pair pair = unsorted.pop();
				int mid = pair.start + ((pair.end - pair.start) >> 1);
				unsorted.push(new Pair(mid + 1, pair.end, pair.level + 1));
				unsorted.push(new Pair(pair.start, mid, pair.level + 1));
			}
			Pair pair = unsorted.pop();
			if (pair.start == pair.end) {
				sorted.push(pair);
			}
			while (sorted.size() > 1) {
				Pair secondPair = sorted.pop();
				Pair firstPair = sorted.pop();
				if (firstPair.level == secondPair.level) {
					merge(arr, firstPair.start, firstPair.end, secondPair.end);
					sorted.push(new Pair(firstPair.start, secondPair.end, firstPair.level - 1));
				} else {
					sorted.push(firstPair);
					sorted.push(secondPair);
					break;
				}
			}
		}
		print(arr);
	}

	static class Pair {
		int start, end;
		int level;

		Pair(int start, int end, int level) {
			this.start = start;
			this.end = end;
			this.level = level;
		}
	}

	// it is using recursion, a very common approach
	private static void type1() {
		int[] arr = { 2, 5, 7, 5, 9, 15, 13, 2, 7, 8 };
		mergeSort(arr, 0, arr.length - 1);
		print(arr);
	}

	static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int mid = l + (r - l) / 2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, r);
			merge(arr, l, mid, r);
		}
	}

	static void merge(int[] arr, int l, int m, int r) {
		int n = r - l + 1;
		int[] copy = new int[n];
		int left = l;
		int right = m + 1;
		int i = 0;
		// first, we will merge two sorted arrays into a copy array
		while (left <= m && right <= r)
			if (arr[left] < arr[right]) copy[i++] = arr[left++];
			else copy[i++] = arr[right++];

		// if there is anything remaining in the left array
		while (left <= m) copy[i++] = arr[left++];
		// if anything left in the right array
		while (right <= r) copy[i++] = arr[right++];

		// we will copy back to the original array
		for (i = 0; i < n; i++) arr[l + i] = copy[i];
	}

}
