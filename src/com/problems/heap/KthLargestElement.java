package com.problems.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

import static com.util.ArrayUtil.swap;

/*
 * 
 * problem links :
 * https://leetcode.com/problems/kth-largest-element-in-an-array
 * https://www.naukri.com/code360/problems/k-largest-elements_796005
 * https://www.naukri.com/code360/problems/kth-smallest-and-largest-element-of-array_1115488
 *
 * Solution link :
 * https://www.youtube.com/watch?v=XEmy13g1Qxc
 * https://www.youtube.com/watch?v=yAs3tONaf3s
 * https://www.youtube.com/watch?v=aXJ-p3Qa4TY
 * 
 * https://takeuforward.org/data-structure/kth-largest-smallest-element-in-an-array/
 * */
public class KthLargestElement {
	public static void main(String[] args) {
		type0();
		type1();
		type2();
		type3();
		type4();
	}

	// TODO best solution int he leetcode
	// can be used only if we know the range of the arr
	private static void type4() {
		int[] nums = {1, 4, 6, 2, 8, 5, 3, 9, 0, 7};
		int k = 3;
		//because there is a negative number, so you can offset 1,0000
		int max = 10000, min = -10000;
		int range = max - min + 1;
		int offset = -min;
		int[] arr = new int[range];
		int answer = -1;
		for (int n : nums) arr[n + offset]++;
		for (int i = range - 1; i >= 0; i--) {
			if (arr[i] > 0) {
				if (k == 1 || k <= arr[i]) {
					answer = i - 10000;
					break;
				}
				k -= arr[i];
			}
		}
		System.out.println(answer);
	}

	// TODO it will not be accepted by leetcode as it is performing
	// on that array to make it a distinct element
	private static void type3() {
		int[] nums = { 1, 4, 6, 2, 8, 5, 3, 9, 0, 7 };
		int k = 3;
		int answer = -1;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			if (num < min) min = num;
			if (max < num) max = num;
		}
		final int[] distinctNumCount = new int[max - min + 1];
		for (int num : nums) distinctNumCount[num - min]++;
		int numsCount = 0;
		for (int i = distinctNumCount.length - 1; i >= 0; i--) {
			numsCount += distinctNumCount[i];
			if (k <= numsCount) answer = i + min;
		}
		System.out.println(answer);
	}

	// partition mechanism,
	// So in quick sort we partition the array,
	// and on every iteration we place one item to its original position,
	// so after each iteration we will check that if it is a kth element or not
	private static void type2() {
		int[] nums = { 1, 4, 6, 2, 8, 5, 3, 9, 0, 7 };
		int k = 3;
		int low = 0, high = nums.length - 1, answer = -1;
		while (low <= high) {
			// we will use the partition technique used is quick sort
			// after one partition the one item will be placed in its place
			// and all lesser elements will be placed in it's left and all larger elements
			// will be placed in its right
			int idx = partition(nums, low, high);
			// if idx == k-1 then we can just return the idx element
			if (idx == k - 1) {
				answer = nums[idx];
				break;
			}
			// else depending upon the idx value we will shrink the array size
			if (idx < k - 1) low = idx + 1;
			else high = idx - 1;
		}
		System.out.println(answer);
	}

	// quick sort partition mechanism
	private static int partition(int[] nums, int low, int high) {
		int pivot = nums[low];
		int left = low + 1;
		int right = high;
		while (left <= right) {
			if (nums[left] < pivot && pivot < nums[right]) {
				swap(nums, left, right);
				left++;
				right--;
			}
			if (nums[left] >= pivot) left++;
			if (nums[right] <= pivot) right--;
		}
		swap(nums, low, right);
		// after this, all elements before r will be greater than arr[r] and all elements
		// after r will be less than arr[r]
		return right;
	}

	// using min heap
	// we will use min heap
	// and only store the k largest elements in the heap
	// after all the iteration we will return the heap top element
	private static void type1() {
		int[] nums = { 1, 4, 6, 2, 8, 5, 3, 9, 0, 7 };
		int k = 3;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int num : nums) {
			if (minHeap.size() < k)
				minHeap.offer(num);
			else {
				// if the current item is greater than
				if (minHeap.peek() < num) {
					minHeap.poll();
					minHeap.offer(num);
				}
			}
		}
		int answer = minHeap.peek();
		System.out.println(answer);
	}

	// brute force approach
	private static void type0() {
		int[] nums = {1, 4, 6, 2, 8, 5, 3, 9, 0, 7};
		int k = 3;
		Arrays.sort(nums);
		int answer = nums[nums.length - k];
		System.out.println(answer);
	}
}
