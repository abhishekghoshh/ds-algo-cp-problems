package problems.sort;

/*
 * Problem link :
 * 
 * 
 * Solution link :
 * https://www.geeksforgeeks.org/recursive-bubble-sort/
 * 
 */
public class RecursiveBubbleSort {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int[] arr = { 2, 5, 7, 5, 9, 15, 13, 2, 7, 8 };
		bubbleSort(arr, arr.length);
		print(arr);
	}

	private static void bubbleSort(int[] arr, int n) {
		if (n == 0)
			return;
		// iterative place the highest element in last place
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
		bubbleSort(arr, n - 1);
	}

	private static void print(int[] arr) {
		for (int item : arr) {
			System.out.print(item + " ");
		}
		System.out.println();
	}
}
