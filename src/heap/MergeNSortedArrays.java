package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/merge-k-sorted-arrays_975379?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link : 
 * https://www.youtube.com/watch?v=l8CuET0jlDU
 * */
public class MergeNSortedArrays {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// same as type2
	// just a little more efficient
	// optimized approach using min heap
	// lets say there is k arrays
	// the total size of elements is n
	// worst time complexity will be O(n*log(k))
	// O(n*log(k)) for removal and O(n*log(k)) for inserting next smallest element
	// space complexity is O(k) for min heap
	private static void type3() {
		int[][] arrays = { { 2, 6, 12, 34 }, { 3 }, { 1, 3, 9, 10, 20 }, { 23, 34, 36, 40 }, { 4, 5, 7, 8 } };
		int size = Arrays.stream(arrays).mapToInt(array -> array.length).reduce(0, (a, b) -> Integer.sum(a, b));
		int[] sortedArray = new int[size];
		int index = 0;

		PriorityQueue<ArrayPosition> minHeap = new PriorityQueue<>(
				(first, second) -> Integer.compare(first.value, second.value));

		for (int i = 0; i < arrays.length; i++) {
			minHeap.offer(new ArrayPosition(arrays[i][0], i, 0));
		}
		while (!minHeap.isEmpty()) {
			ArrayPosition top = minHeap.poll();
			int topIndex = top.index;
			int topArrayIndex = top.arrayIndex;
			int topArrayLength = arrays[topArrayIndex].length;
			if (!minHeap.isEmpty()) {
				int currentTopValue = minHeap.peek().value;
				while (topIndex < topArrayLength && arrays[topArrayIndex][topIndex] <= currentTopValue) {
					sortedArray[index++] = arrays[topArrayIndex][topIndex++];
				}
				if (topIndex < topArrayLength) {
					top.value = arrays[topArrayIndex][topIndex];
					top.arrayIndex = topArrayIndex;
					top.index = topIndex;
					minHeap.offer(top);
				}
			} else {
				while (topIndex < topArrayLength) {
					sortedArray[index++] = arrays[topArrayIndex][topIndex++];
				}
			}
		}
		print(sortedArray);
	}

	// optimized approach using min heap
	// lets say there is k arrays
	// the total size of elements is n
	// worst time complexity will be O(n*log(k))
	// O(n*log(k)) for removal and O(n*log(k)) for inserting next smallest element
	// space complexity is O(k) for min heap
	private static void type2() {
		int[][] arrays = { { 2, 6, 12, 34 }, { 3 }, { 1, 3, 9, 10, 20 }, { 23, 34, 36, 40 }, { 4, 5, 7, 8 } };
		int size = Arrays.stream(arrays).mapToInt(array -> array.length).reduce(0, (a, b) -> Integer.sum(a, b));
		int[] sortedArray = new int[size];
		int index = 0;

		PriorityQueue<ArrayPosition> minHeap = new PriorityQueue<>(
				(first, second) -> Integer.compare(first.value, second.value));

		for (int i = 0; i < arrays.length; i++) {
			minHeap.offer(new ArrayPosition(arrays[i][0], i, 0));
		}
		while (!minHeap.isEmpty()) {
			ArrayPosition arrayPosition = minHeap.poll();
			sortedArray[index++] = arrayPosition.value;
			int length = arrays[arrayPosition.arrayIndex].length;
			if (arrayPosition.index < length - 1) {
				arrayPosition.index++;
				arrayPosition.value = arrays[arrayPosition.arrayIndex][arrayPosition.index];
				minHeap.offer(arrayPosition);
			}
		}
		print(sortedArray);
	}

	private static class ArrayPosition {
		int value;
		int arrayIndex;
		int index;

		public ArrayPosition(int value, int arrayPosition, int index) {
			super();
			this.value = value;
			this.arrayIndex = arrayPosition;
			this.index = index;
		}

		@Override
		public String toString() {
			return "ArrayPosition [value=" + value + ", arrayIndex=" + arrayIndex + ", index=" + index + "]";
		}
	}

	// brute force approach
	// time complexity O(size*log(size))
	// space complexity O(size)
	private static void type1() {
		int[][] arrays = { { 2, 6, 12, 34 }, { 3 }, { 1, 3, 9, 10, 20 }, { 23, 34, 36, 40 }, { 4, 5, 7, 8 } };
		int size = Arrays.stream(arrays).mapToInt(array -> array.length).reduce(0, (a, b) -> Integer.sum(a, b));
		int[] sortedArray = new int[size];
		int index = 0;
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[i].length; j++) {
				sortedArray[index++] = arrays[i][j];
			}
		}
		Arrays.sort(sortedArray);
		print(sortedArray);
	}

	private static void print(int[] array) {
		for (int item : array) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

}
