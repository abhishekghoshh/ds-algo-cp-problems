package binarysearch;
/*
 * Problem link :
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=zr_AoTxzn0Y&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=5
 * https://www.youtube.com/watch?v=Ru_HhBFV3Xo&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=6
 * 
 * */
public class FirstAndLastOccuranceAndCount {
	public static void main(String args[]) {
		type2();
	}

	private static void type2() {
		int[] nums = { 0, 1, 2, 3, 4, 4, 4, 4, 5, 6, 7, 7, 8, 9, 10, 11, 11 };
		int target = 11;
		int low = 0;
		int high = nums.length - 1;
		int first = firstOccurance(nums, low, high, target);
		int last = lastOccurance(nums, low, high, target);
		int count = last - first + 1;
		System.out.println("first : " + first + " last : " + last + " count : " + count);
	}

	private static int firstOccurance(int[] nums, int low, int high, int target) {
		int index = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (target == nums[mid]) {
				index = mid;
				high = mid - 1;
			} else if (target < nums[mid]) {
				high = mid - 1;
			} else if (target > nums[mid]) {
				low = mid + 1;
			}
		}
		return index;
	}

	private static int lastOccurance(int[] nums, int low, int high, int target) {
		int index = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (target == nums[mid]) {
				index = mid;
				low = mid + 1;
			} else if (target < nums[mid]) {
				high = mid - 1;
			} else if (target > nums[mid]) {
				low = mid + 1;
			}
		}
		return index;
	}
}
