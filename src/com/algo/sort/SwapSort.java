package com.algo.sort;

import static com.util.PrintUtl.print;
import static com.util.ArrayUtil.swap;

public class SwapSort {

	public static void main(String[] args) {
		int[] arr = {7, 3, 9, 4, 8, 5, 1, 6, 2};
		int n = arr.length;
		int i = 0;
		while (i < n) {
			// it means i is i-1 th index
			// and we don't need to change anything
			if (arr[i] == i + 1) {
				i++;
			} else {
				// we will place the arr[i] to its actual position
				// item should be in the item-1 position
				int item = arr[i];
				swap(arr, i, item - 1);
			}
		}
		print(arr);
	}
}
