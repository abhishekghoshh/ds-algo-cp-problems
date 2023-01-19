package sort;

import heap.MinHeap;

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
		int arr[] = { 10, 9, 8, 7 };
		int i = 0;
		MinHeap.Heap minHeap = new MinHeap.Heap(arr);
		while (!minHeap.isEmpty()) {
			arr[i++] = minHeap.extractMin();
		}
		print(arr);
	}

	private static void print(int[] arr) {
		for (int item : arr) {
			System.out.print(item + " ");
		}
		System.out.println();
	}
}
