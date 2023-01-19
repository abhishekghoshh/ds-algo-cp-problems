package binarysearch;
/*
 * Problem link :
 * https://leetcode.com/problems/binary-search/submissions/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=j7NodO9HIbk&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2
 * 
 * */
public class BinarySearch {
    public static void main(String args[]) {
        type2();
    }

	private static void type2() {
		int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ,10};
		int target = 1;
        int low = 0;
        int high = nums.length - 1;
        int index = search(nums, low, high, target);
        System.out.println(index);
	}

    private static int search(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }
}
