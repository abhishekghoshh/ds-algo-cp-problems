package problems.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

import util.Pair;

/*
 * Problem link :
 * https://leetcode.com/problems/find-k-closest-elements/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=J8yLD-x7fBI&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=5
 * 
 * */
public class KClosestNumbers {
	public static void main(String[] args) {
		type1();
		type2();
	}

	// using binary search technique
	private static void type2() {
		int k = 4, x = 3;
		int arr[] = { 0, 1, 2, 3, 7 };
		int n = arr.length;
		int ceil = search(5, arr, n);
		System.out.println(ceil);
	}

	private static int search(int x, int[] arr, int n) {
		int low = 0, high = n - 1, mid;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (arr[mid] == x) {
				return mid;
			} else if (arr[mid] < x) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}

	// Using max heap
	private static void type1() {
//		int k = 4, number = 35;
//		int arr[] = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 };
		int k = 4, x = 3;
		int arr[] = { 1, 2, 3, 4, 5 };
		int[] answer = new int[k];
		PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>(
				(pair1, pair2) -> Integer.compare(pair2.first, pair1.first));
		for (int item : arr) {
			int distance = Math.abs(item - x);
			if (maxHeap.size() < k) {
				maxHeap.offer(new Pair<>(distance, item));
			} else {
				if (maxHeap.peek().first > distance) {
					maxHeap.poll();
					maxHeap.offer(new Pair<Integer, Integer>(distance, item));
				}
			}
		}
		int index = 0;
		while (!maxHeap.isEmpty()) {
			answer[index++] = maxHeap.poll().second;
		}
		Arrays.sort(answer);
		print(answer);
	}

	private static void print(int[] answer) {
		for (int num : answer) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
