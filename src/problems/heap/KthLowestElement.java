package problems.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Problem link :
 * https://www.interviewbit.com/problems/kth-smallest-element-in-the-array/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=4BfL2Hjvh8g&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=2
 * 
 * */
public class KthLowestElement {
	public static void main(String[] args) {
		type1();
		type2();
	}

	// partition mechanism
	private static void type2() {
		int[] nums = { 1, 4, 6, 2, 8, 5, 3, 7, 0 };
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
			if (nums[l] > pivot && pivot > nums[r]) {
				swap(nums, l, r);
				l++;
				r--;
			}
			if (nums[l] <= pivot) {
				l++;
			}
			if (nums[r] >= pivot) {
				r--;
			}
		}
		swap(nums, low, r);
		// after this all elements before r will be lesser than arr[r] and all elements
		// after r will be greater than arr[r]
		return r;
	}

	private static void swap(int[] nums, int l, int r) {
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
	}

	// using heap
	// we will use max heap
	// and only store the k largest elements in the heap
	// after all the iteration we will return the heap top element
	private static void type1() {
		int[] nums = { 1, 4, 6, 2, 8, 5, 3, 7, 0 };
		int k = 3;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		for (int num : nums) {
			if (maxHeap.size() < k) {
				maxHeap.offer(num);
			} else {
				if (maxHeap.peek() > num) {
					maxHeap.poll();
					maxHeap.offer(num);
				}
			}
		}
		System.out.println(maxHeap.peek());
	}
}
