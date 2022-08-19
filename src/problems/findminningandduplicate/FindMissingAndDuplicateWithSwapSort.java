package problems.findminningandduplicate;

public class FindMissingAndDuplicateWithSwapSort {

	public static void main(String[] args) {
		int arr[] = { 7, 3, 4, 5, 5, 6, 3 };
		int n = arr.length;
		int i = 0;
		while (i < n) {
			if (arr[i] == i + 1 || arr[arr[i] - 1] == arr[i]) {
				i++;
			} else {
				int item = arr[i];
				arr[i] = arr[item - 1];
				arr[item - 1] = item;
			}
		}
		print(arr);
		for (i = 0; i < n; i++) {
			if (arr[i] != i + 1) {
				System.out.println("Missing element is " + (i + 1));
				System.out.println("duplicate element is " + arr[i]);
			}
		}
	}

	private static void print(int[] arr) {
		for (int item : arr) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

}
