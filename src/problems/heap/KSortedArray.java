package problems.heap;

import java.util.PriorityQueue;
/*
 * Problem link :
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=dYfM6J1y0mU&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=4
 * 
 * */
public class KSortedArray {
	public static void main(String[] args) {
		type2();
	}

	private static void type2() {
		int arr[] = { 6, 5, 3, 2, 8, 10, 9 };
		int k = 3;
		sortKSortedArray(arr, k);
		print(arr);
	}

	private static void sortKSortedArray(int[] arr, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int index = 0;
		for (int item : arr) {
			//System.out.println(item + " " + queue);
			if (queue.size() <= k) {
				queue.offer(item);
			} else {
				arr[index++] = queue.poll();
				queue.offer(item);
			}
		}
		while (index < arr.length) {
			arr[index++] = queue.poll();
		}
	}

	private static void print(int[] arr) {
		for (int item : arr) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

}
