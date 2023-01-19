package binarysearch;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=5cx0xerA8XY&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=10
 * 
 * */
public class FloorOfAnItem {
	public static void main(String args[]) {
		type2();
	}

	private static void type2() {
		long[] arr = { 0, 1, 2, 3, 4, 6, 7, 8, 9, 10 };
		long target = -1;
		int low = 0;
		int high = arr.length - 1;
		int index = floor(arr, low, high, target);
		long floor = index != -1 ? arr[index] : Long.MIN_VALUE;
		System.out.println(index);
		System.out.println(floor);
	}

	private static int floor(long[] arr, int low, int high, long target) {
		int index = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				index = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return index;
	}
}
