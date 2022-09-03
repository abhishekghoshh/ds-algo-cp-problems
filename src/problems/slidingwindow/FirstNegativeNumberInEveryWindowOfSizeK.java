package problems.slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNumberInEveryWindowOfSizeK {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
		int k = 3;
		int n = arr.length;
		int size = n - k + 1;
		int[] answer = new int[size];
		Queue<Integer> queue = new LinkedList<>();
		int left = 0, right = 0;
		while (right < k) {
			if (arr[right] < 0) {
				queue.offer(arr[right]);
			}
			right++;
		}
		while (left < size) {
			if (!queue.isEmpty()) {
				answer[left] = queue.peek();
				if (queue.peek() == arr[left]) {
					queue.poll();
				}
				left++;
			} else {
				answer[left++] = 0;
			}
			if (left < size && arr[left + k - 1] < 0) {
				queue.offer(arr[left + k - 1]);
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

	private static void type1() {

	}
}
