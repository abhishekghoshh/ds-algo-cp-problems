package problems.binarysearch;

public class CeilOfAnItem {
	public static void main(String args[]) {
		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12 };
		int low = 0;
		int high = arr.length - 1;
		double key = 10;
		int index = search(arr, low, high, key);
		System.out.println(arr[index]);
	}

	private static int search(int[] arr, int low, int high, double key) {
		int index = high;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] < key) {
				low = mid + 1;
			} else {
				index = mid;
				high = mid - 1;
			}
		}
		return index;
	}
}
