package problems.slidingwindow;

import java.util.LinkedList;

public class FirstNegativeNumberInEveryWindowOfSizeK {

	public static void main(String[] args) {
		int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
		int n = arr.length;
		int k = 3;
		int[] answer = new int[n - k + 1];
		LinkedList<Integer> linkedList = new LinkedList<>();
		for (int i = 0; i < k; i++) {
			if (arr[i] < 0) {
				linkedList.add(arr[i]);
			}
		}
		int index = 0;
		for (int i = 0; i < n - k + 1; i++) {
			if (!linkedList.isEmpty()) {
				answer[index++] = linkedList.getFirst();
				if (arr[i] == linkedList.getFirst()) {
					linkedList.removeFirst();
				}
			} else {
				answer[index++] = 0;
			}
			if (i + k < n && arr[i + k] < 0) {
				linkedList.add(arr[i + k]);
			}
		}
		print(arr);
		print(answer);
	}

	private static void print(int[] arr) {
		System.out.println();
		for (int item : arr) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

}
