package problems.sort;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/bubble-sort/1
 * 
 * Solution link :
 * https://takeuforward.org/data-structure/bubble-sort-algorithm/
 * 
 */
public class BubbleSort {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int arr[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int bound = n - i - 1;
			for (int j = 0; j < bound; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
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
