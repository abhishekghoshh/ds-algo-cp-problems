package binarysearch;

/*
 * Problem link :
 * https://www.interviewbit.com/problems/search-in-bitonic-array/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=IjaP8qt1IYI&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=19
 * 
 * */
public class FindElementInBiotonicArray {

	public static void main(String[] args) {
		type2();
	}

	// first we will find the peak
	// then we will find the in two partition
	// 3 <= N <= 105
	private static void type2() {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11 };
		int target = 12;
		int n = arr.length;
		int max = findMaximum(arr, n);
		if (arr[max] == target) {
			System.out.println(String.format("key %d found in index %d", target, max));
		} else {
			int leftIndex = increasing(arr, 0, max - 1, target);
			int rightIndex = decreasing(arr, max + 1, n - 1, target);
			System.out.println(String.format("key %d found in leftIndex %d", target, leftIndex));
			System.out.println(String.format("key %d found in rightIndex %d", target, rightIndex));
		}
	}

	private static int findMaximum(int[] arr, int n) {
		int low = 1, high = n - 2;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
				return mid;
			} else if (arr[mid - 1] > arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	private static int increasing(int[] arr, int low, int high, int target) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	private static int decreasing(int[] arr, int low, int high, int target) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

}
