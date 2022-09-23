package problems.slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem link : 
 * https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=uUXXEgK2Jh8&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=4
 * */
public class FirstNegativeNumberInEveryWindowOfSizeK {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		int arr[] = { -8, 2, 3, -6, 10 };
		int k = 2;
		int n = arr.length;
		// size of the result array
		int size = n - k + 1;
		int[] answer = new int[size];
		Queue<Integer> queue = new LinkedList<>();
		int left = 0, right = 0;
		// we are collecting all the negative numbers from 0 to k-1
		while (right < k) {
			if (arr[right] < 0) {
				queue.offer(arr[right]);
			}
			right++;
		}
		// currently left=0 and right=k
		// we are doing right<=n because we are calculating the answer for previous
		// window
		while (right <= n) {
			// checking the answer for the previous window
			// at the first iteration it is checking the answer for first window
			if (!queue.isEmpty()) {
				answer[left] = queue.peek();
				// is the start first element of queue is start of the window
				if (queue.peek() == arr[left]) {
					queue.poll();
				}
			} else {
				answer[left] = 0;
			}
			// if current right is less than zero or not
			if (right < n && arr[right] < 0) {
				queue.offer(arr[right]);
			}
			// shifting the window
			left++;
			right++;
		}
		print(arr);
		print(answer);
	}

	private static void print(int[] arr) {
		for (int item : arr) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

	private static void type1() {

	}
}
