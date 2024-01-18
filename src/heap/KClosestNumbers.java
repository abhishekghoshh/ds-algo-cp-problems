package heap;

import util.Pair;

import java.util.*;

import static com.util.ArrayUtil.print;

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
		type1_();
		type2();
		type3();
	}


	// TODO most optimized solution in leetcode but do not explain it in the interview
	// TODO check it later
	private static void type3() {
		int[] arr = {-2, -1, 1, 2, 3, 4, 5};
		int k = 7;
		int x = 3;
		List<Integer> answer = findClosestElements3(arr, k, x);
		print(answer);
	}

	private static List<Integer> findClosestElements3(int[] nums, int k, int x) {
		final int length = nums.length;
		if (x <= nums[0]) return new IntList(nums, 0, k);
		if (x >= nums[length - 1]) return new IntList(nums, length - k, k);

		int start = 0, end = length - k;

		while (start < end) {
			final int m = start + end >> 1;
			final int c = compare(nums[m + k], nums[m], x);
			if (x - nums[m] > nums[m + k] - x)
				start = m + 1;
			else
				end = m;
		}
		return new IntList(nums, start, k);
	}

	private static int compare(final int a, final int b, final int x) {
		int result = Math.abs(a - x) - Math.abs(b - x);
		if (result != 0) return result;
		return a - b;
	}

	public static final class IntList extends java.util.AbstractList<Integer> {
		private final int offset, size;
		private final int[] data;

		public IntList(final int[] data, final int offset, final int size) {
			this.data = data;
			this.offset = offset;
			this.size = size;
		}

		@Override
		public Integer get(int index) {
			return data[index + offset];
		}

		@Override
		public int size() {
			return size;
		}
	}


	// TODO explain this approach int he interview
	// or explain the heap approach
	// using binary search technique
	// binary search
	// find the start of the list
	// where the partition will be started
	private static void type2() {
		int[] arr = {-2, -1, 1, 2, 3, 4, 5};
		int k = 7;
		int x = 3;
		List<Integer> answer = findClosestElements2(arr, k, x);
		print(answer);
	}

	public static List<Integer> findClosestElements2(int[] arr, int k, int x) {
		int left = 0, right = arr.length - k, mid;
		// Binary search against the criteria described
		while (left < right) {
			mid = left + ((right - left) >> 1);
			if (x - arr[mid] > arr[mid + k] - x)
				left = mid + 1;
			else
				right = mid;
		}
		// Create output in correct format
		List<Integer> result = new ArrayList<>(k);
		for (int i = left; i < left + k; i++)
			result.add(arr[i]);

		return result;
	}

	// same as type1
	private static void type1_() {
		int[] arr = {-2, -1, 1, 2, 3, 4, 5};
		int k = 7;
		int x = 3;
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
				(p1, p2) -> p2[0] - p1[0]
		);
		for (int item : arr) {
			int distance = Math.abs(item - x);
			if (maxHeap.size() < k) {
				maxHeap.offer(new int[]{distance, item});
			} else if (maxHeap.peek()[0] > distance) {
				maxHeap.poll();
				maxHeap.offer(new int[]{distance, item});
			}
		}
		List<Integer> answer = new ArrayList<>();
		while (!maxHeap.isEmpty())
			answer.add(maxHeap.poll()[1]);
		Collections.sort(answer);
		print(answer);
	}
	// Using max heap
	private static void type1() {
		int[] arr = {-2, -1, 1, 2, 3, 4, 5};
		int k = 7;
		int x = 3;
		int[] answer = new int[k];
		PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>(
				(pair1, pair2) -> Integer.compare(pair2.first, pair1.first));
		for (int item : arr) {
			int distance = Math.abs(item - x);
			if (maxHeap.size() < k) {
				maxHeap.offer(new Pair<>(distance, item));
			} else if (maxHeap.peek().first > distance) {
				maxHeap.poll();
				maxHeap.offer(new Pair<>(distance, item));
			}
		}
		int index = 0;
		while (!maxHeap.isEmpty())
			answer[index++] = maxHeap.poll().second;

		Arrays.sort(answer);
		print(answer);
	}

}
