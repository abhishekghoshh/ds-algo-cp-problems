package problems.binarysearch;

/*
 * Problem link :
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=uiz0IxPCUeU&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=11
 * 
 * */
public class CeilOfAnItem {
	public static void main(String args[]) {
		type2();
	}

	private static void type2() {
		long[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12 };
		long target = 11;
		int low = 0;
		int high = arr.length - 1;
		int index = ceil(arr, low, high, target);
		long ceil = index != -1 ? arr[index] : Long.MAX_VALUE;
		System.out.println(index);
		System.out.println(ceil);
	}

	private static int ceil(long[] arr, int low, int high, double target) {
		int index = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				low = mid + 1;
			} else {
				index = mid;
				high = mid - 1;
			}
		}
		return index;
	}
}
