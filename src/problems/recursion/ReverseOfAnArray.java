package problems.recursion;

public class ReverseOfAnArray {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		reverse(arr, 0, arr.length - 1);
		print(arr);
	}

	private static void reverse(int[] arr, int left, int right) {
		if (left >= right)
			return;
		swap(arr, left, right);
		reverse(arr, left + 1, right - 1);
	}

	private static void type1() {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int left = 0, right = arr.length - 1;
		while (left < right) {
			swap(arr, left++, right--);
		}
		print(arr);
	}

	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	private static void print(int[] arr) {
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

}
