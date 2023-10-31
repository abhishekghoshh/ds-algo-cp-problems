package com.ds.sort;

import com.implementations.heap.MinHeap;

import static com.util.ArrayUtil.print;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/heap-sort/1
 * 
 * Solution link :
 * https://www.geeksforgeeks.org/heap-sort/
 * 
 */
public class HeapSort {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int[] arr = {10, 9, 8, 7, 2, 5, 1, -1};
		MinHeap minHeap = new MinHeap(arr);
		for (int i = 0; i < arr.length; i++)
			arr[i++] = minHeap.extractMin();
		print(arr);
	}

}
