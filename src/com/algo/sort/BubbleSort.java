package com.algo.sort;

import static com.util.PrintUtl.print;
import static com.util.ArrayUtil.swap;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/bubble-sort/1
 * 
 * Solution link :
 * https://takeuforward.org/data-structure/bubble-sort-algorithm/
 * 
 */
public class BubbleSort {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		int n = arr.length;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
		print(arr);
	}
}
