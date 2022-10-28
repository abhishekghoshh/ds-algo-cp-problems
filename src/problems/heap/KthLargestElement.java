package problems.heap;

import java.util.PriorityQueue;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/kth-smallest-and-largest-element-of-array_1115488?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link : https://www.youtube.com/watch?v=edXdVwkYHF8
 * 
 * https://takeuforward.org/data-structure/kth-largest-smallest-element-in-an-array/
 * 
 * */
public class KthLargestElement {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	private static void type3() {
		int[] nums = { 1, 4, 6, 2, 8, 5, 3, 9, 0, 7 };
		int k = 3;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int element = -1;
		for (int i = 0; i < nums.length; i++) {
			if (max < nums[i]) {
				max = nums[i];
			}
			if (min > nums[i]) {
				min = nums[i];
			}
		}
		int freq[] = new int[max - min + 1];
		for (int i = 0; i < nums.length; i++)
			freq[nums[i] - min]++;
		int cnt = 0;
		for (int i = max - min; i >= 0; i--) {
			cnt = cnt + freq[i];
			if (cnt >= k) {
				element = i + min;
				break;
			}
		}
		System.out.println(element);
	}

	// partition mechanism
	private static void type2() {
		int[] nums = { 1, 4, 6, 2, 8, 5, 3, 9, 0, 7 };
		int k = 3;
		int low = 0, high = nums.length - 1, kth = -1;
		while (low <= high) {
			// we will use the partition technique used is quick sort
			// after one partition the one item will be placed in it's place
			// and all lesser elements will be placed in it's left and all larger elements
			// will be placed in it's right
			int idx = partition(nums, low, high);
			// if idx == k-1 then we can just return the idx element
			if (idx == k - 1) {
				kth = nums[idx];
				break;
			}
			// else depending upon the idx value we will shrink the array size
			if (idx < k - 1) {
				low = idx + 1;
			} else {
				high = idx - 1;
			}
		}
		System.out.println(kth);
	}

	// quick sort partition mechanism
	private static int partition(int[] nums, int low, int high) {
		int pivot = nums[low];
		int l = low + 1;
		int r = high;
		while (l <= r) {
			if (nums[l] < pivot && pivot < nums[r]) {
				swap(nums, l, r);
				l++;
				r--;
			}
			if (nums[l] >= pivot) {
				l++;
			}
			if (nums[r] <= pivot) {
				r--;
			}
		}
		swap(nums, low, r);
		// after this all elements before r will be greater than arr[r] and all elements
		// after r will be less than arr[r]
		return r;
	}

	private static void swap(int[] nums, int l, int r) {
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
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
			if (minHeap.size() < k) {
				minHeap.offer(num);
			} else {
				if (minHeap.peek() < num) {
					minHeap.poll();
					minHeap.offer(num);
				}
			}
		}
		System.out.println(minHeap.peek());
	}
}
