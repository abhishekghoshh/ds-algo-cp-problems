package problems.binarysearch;

public class FirstOccuranceOfOneInInfiteBinaryArray {

	public static void main(String[] args) {
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
