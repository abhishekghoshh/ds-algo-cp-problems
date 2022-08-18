package problems.binarysearch;

public class BinarySearchOnRotatedArray {

	public static void main(String args[]) {
		int[] arr = { 7, 8, 9, 10, 11, 12, 0, 1, 2, 3, 4, 5, 6 };
		int key = 5;
		int length = arr.length;
		int high = arr.length - 1;
		if (arr[0] < arr[arr.length - 1]) {
			System.out.println(search(arr, 0, high, key));
		} else {
			int rotationNumber = rotationNumber(arr, 0, high, length);
			System.out.println("rotation number is " + rotationNumber);
			if (arr[0] < key) {
				System.out.println(search(arr, 0, rotationNumber - 1, key));
			} else {
				System.out.println(search(arr, rotationNumber, high, key));
			}
		}

	}

	private static int rotationNumber(int[] arr, int low, int high, int length) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int prev = (mid - 1 + length) % length;
			int next = (mid + 1) % length;
			if (arr[prev] > arr[mid] && arr[mid] < arr[next]) {
				return mid;
			}
			if (arr[mid] < arr[high]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	private static int search(int[] arr, int low, int high, int key) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == key) {
				return mid;
			}
			if (key < arr[mid]) {
				high = mid - 1;
			} else if (key > arr[mid]) {
				low = mid + 1;
			}
		}
		return -1;
	}
}
