package problems.binarysearch;

public class FindMaximumInBitonicArray {

	public static void main(String[] args) {
		int arr[] = { 1, 15, 25, 45, 42, 21, 17, 12, 11 };
		int low = 0;
		int high = arr.length - 1;
		int index = findMaximumInBitonicArray(arr, low, high, arr.length);
		System.out.println(String.format("arr[%d] : %d", index, arr[index]));
	}

	private static int findMaximumInBitonicArray(int[] arr, int low, int high, int length) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid > 0 && mid < length - 1) {
				if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
					return mid;
				} else if (arr[mid] > arr[mid - 1]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else if (mid == 0) {
				return arr[0] > arr[1] ? 0 : 1;
			} else {
				return arr[length - 1] > arr[length - 2] ? length - 1 : length - 2;
			}
		}
		return -1;
	}

}
