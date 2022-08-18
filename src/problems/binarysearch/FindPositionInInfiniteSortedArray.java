package problems.binarysearch;

public class FindPositionInInfiniteSortedArray {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		int low = 0;
		int high = 1;
		int key = 13;
		while (arr[high] < key) {
			low = high;
			high = high * 2;
		}
		high = Math.min(arr.length, high);
		int index = search(arr, low, high, key);
		System.out.println(index);

	}

	private static int search(int[] arr, int low, int high, int key) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] < key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

}
