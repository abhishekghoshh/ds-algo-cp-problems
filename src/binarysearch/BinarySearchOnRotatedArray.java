package binarysearch;

/*
 * Problem link : 
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * https://www.codingninjas.com/codestudio/problems/630450?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * 
 * Solution is :
 * https://www.youtube.com/watch?v=r3pMQ8-Ad5s&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=65
 * https://takeuforward.org/data-structure/search-element-in-a-rotated-sorted-array/
 * https://www.youtube.com/watch?v=Id-DdcWb5AU&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=8
 * 
 * */
public class BinarySearchOnRotatedArray {

	public static void main(String args[]) {
		type1();
		type2();
		type3();
	}

	// find in the single search
	private static void type3() {
		int[] nums = { 7, 8, 9, 10, 11, 12, 0, 1, 2, 3, 4, 5, 6 };
		int target = 1;
		int n = nums.length;
		int low = 0, high = n - 1, mid, index = -1;
		while (low <= high) {
			mid = low + (high - low) / 2;
			// arr[low]<arr[mid] means we are in the left side and
			// low to mid all the elements are sorted
			if (nums[low] <= nums[mid]) {
				// now if the key is in low to mid range then we can apply binary search on that
				if (nums[low] <= target && target <= nums[mid]) {
					index = search(nums, low, mid, target);
					break;
				} else {
					// key is not in the range of low to mid
					// so our new range will started from mid+1
					low = mid + 1;
				}
			} else {
				// arr[low]>arr[mid] means we are in the right side and
				// mid to high all the elements are sorted
				// now if the key is in mid to high range then we can apply binary search
				if (nums[mid] <= target && target <= nums[high]) {
					index = search(nums, mid, high, target);
					break;
				} else {
					// key is not in the range of mid to high
					// so our new range will started from mid-1
					high = mid - 1;
				}
			}
		}
		System.out.println(index);
	}

	// binary search
	// first search the rotation time
	// so we will get the first and 2nd half
	// then we can find in the appropriate side
	private static void type2() {
		int[] nums = { 7, 8, 9, 10, 11, 12, 0, 1, 2, 3, 4, 5, 6 };
		int key = 0;
		int length = nums.length;
		int high = nums.length - 1;
		// 0th element is less than n-1th element so the array is not rotated
		if (nums[0] < nums[nums.length - 1]) {
			System.out.println(search(nums, 0, high, key));
		} else {
			// the array is rotated
			// so we will find the rotation index of the starting element
			int rotationIndex = rotationIndex(nums, 0, high, length);
			// System.out.println("rotation number is " + rotationNumber);
			// if the item is in rotationIndex then we will return it
			if (nums[rotationIndex] == key) {
				System.out.println(rotationIndex);
			} else if (nums[0] < key) {
				// if it is in left half then we will apply binary search on the left
				System.out.println(search(nums, 0, rotationIndex - 1, key));
			} else {
				// it is in right half then we will apply binary search on the right
				System.out.println(search(nums, rotationIndex + 1, high, key));
			}
		}
	}

	private static int rotationIndex(int[] nums, int low, int high, int length) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int prev = (mid - 1 + length) % length;
			int next = (mid + 1) % length;
			if (nums[prev] > nums[mid] && nums[mid] < nums[next]) {
				return mid;
			}
			if (nums[mid] < nums[high]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	private static int search(int[] nums, int low, int high, int key) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == key) {
				return mid;
			}
			if (key < nums[mid]) {
				high = mid - 1;
			} else if (key > nums[mid]) {
				low = mid + 1;
			}
		}
		return -1;
	}

	// brute force apprach
	// linearly find the target element
	private static void type1() {

	}
}
