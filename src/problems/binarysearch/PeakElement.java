package problems.binarysearch;

/*
 * Problem link :
 * https://leetcode.com/problems/find-peak-element/submissions/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=OINnBJTRrMU&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=17
 * 
 * */
public class PeakElement {

	public static void main(String[] args) {
		type2();
		type3();

	}

	private static void type3() {
		int nums[] = { 5, 25, 20, 15, 2, 23, 90, 67 };
		int index = findPeakElement(nums);
		System.out.println(String.format("arr[%d] : %d", index, nums[index]));
	}

	public static int findPeakElement(int[] nums) {
		int n = nums.length - 1;
		if (n == 0 || nums[0] > nums[1])
			return 0;
		if (nums[n] > nums[n - 1])
			return n;
		int flag = -1;
		int l = 0, r = n;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1])
				flag = mid;
			if (nums[mid + 1] > nums[mid])
				l = mid + 1;
			else
				r = mid - 1;
		}
		return flag;
	}

	// A peak element is an element that is strictly greater than its neighbors.
	// nums = [1,2,1,3,5,6,4] Output: 5
	// Explanation: Your function can return either index number 1 where the peak
	// element is 2, or index number 5 where the peak element is 6.
	private static void type2() {
		int nums[] = { 5, 25, 20, 15, 2, 23, 90, 67 };
		int low = 0;
		int high = nums.length - 1;
		int index = findPeak(nums, low, high, nums.length);
		System.out.println(String.format("arr[%d] : %d", index, nums[index]));
	}

	private static int findPeak(int[] nums, int low, int high, int n) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid > 0 && mid < n - 1) {
				if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
					return mid;
				} else if (nums[mid] > nums[mid - 1]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else if (mid == 0) {
				return nums[0] > nums[1] ? 0 : 1;
			} else {
				return nums[n - 1] > nums[n - 2] ? n - 1 : n - 2;
			}
		}
		return -1;
	}

}
