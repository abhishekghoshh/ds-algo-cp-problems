package problems.array;

public class SwapSort {

	public static void main(String[] args) {
		int arr[] = { 7, 3, 9, 4, 8, 5, 1, 6, 2 };
		int n = arr.length;
		int i = 0;
		while (i < n) {
			if (arr[i] == i + 1) {
				i++;
			} else {
				int item = arr[i];
				arr[i] = arr[item - 1];
				arr[item - 1] = item;
			}
		}
		print(arr);
	}

	private static void print(int[] arr) {
		for (int item : arr) {
			System.out.print(item + " ");
		}
		System.out.println();
	}
}
