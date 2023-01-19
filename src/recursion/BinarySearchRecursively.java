package recursion;

public class BinarySearchRecursively {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 };
		int key = 5;
		int index = find(arr, key, 0, arr.length - 1);
		System.out.println(index);
	}

	private static int find(int[] arr, int key, int left, int right) {
		if (left > right)
			return -1;
		int mid = left + (right - left) / 2;
		if (arr[mid] == key) {
			return mid;
		} else if (arr[mid] > key) {
			return find(arr, key, left, mid - 1);
		} else {
			return find(arr, key, mid + 1, right);
		}
	}

}
