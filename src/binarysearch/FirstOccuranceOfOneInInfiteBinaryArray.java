package binarysearch;
/*
 * Problem link :
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=8x6dmO6XW8k&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=14
 * 
 * */
public class FirstOccuranceOfOneInInfiteBinaryArray {

	public static void main(String[] args) {
		type2();
	}

	private static void type2() {
		int[] arr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, };

		int low = 0;
		int high = 1;
		while (arr[high] != 1) {
			low = high;
			high = high * 2;
		}
		int index = searchOne(arr, low, high);
		System.out.println(index);
	}

	private static int searchOne(int[] arr, int low, int high) {
		int index = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == 1) {
				index = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return index;
	}

}
