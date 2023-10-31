package com.ds.sort;

import static com.util.ArrayUtil.print;

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
		type1();
	}

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
		while (left <= m && right <= r)
			if (arr[left] < arr[right])
				copy[i++] = arr[left++];
			else
				copy[i++] = arr[right++];
		while (left <= m)
			copy[i++] = arr[left++];
		while (right <= r)
			copy[i++] = arr[right++];
		for (i = 0; i < n; i++)
			arr[l + i] = copy[i];
	}

}
