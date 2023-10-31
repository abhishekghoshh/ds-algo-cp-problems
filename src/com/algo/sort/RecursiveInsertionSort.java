package com.algo.sort;

import com.util.ArrayUtil;

/*
 * Problem link :
 *
 *
 * Solution link :
 *
 *
 */
public class RecursiveInsertionSort {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int[] arr = { 24, 18, 38, 43, 14, 40, 1, 54 };
		insertionSort(arr, arr.length);
		ArrayUtil.print(arr);
	}

	// insert all the elements one by one
	static void insertionSort(int[] arr, int n) {
		for (int i = 1; i < n; i++)
			insert(arr, i);
	}

	// it will insert the ith element in the sorted list
	static void insert(int[] arr, int i) {
		int pivot = arr[i];
		int j = i;
		while (j > 0 && pivot < arr[j - 1]) {
			arr[j] = arr[j - 1];
			j--;
		}
		arr[j] = pivot;
	}
}
