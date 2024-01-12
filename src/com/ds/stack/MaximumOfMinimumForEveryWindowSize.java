package com.ds.stack;

import static com.util.ArrayUtil.print;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/maximum-of-minimum-for-every-window-size3453/1
 * https://www.codingninjas.com/codestudio/problems/max-of-min_982935
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=CK8PIAF-m2E
 * https://www.youtube.com/watch?v=3tAB663q-nk
 * https://www.youtube.com/watch?v=yRagSKdQgsc
 * 
 * https://leetcode.com/problems/sliding-window-maximum/discuss/2059348/maximum-of-minimum-for-every-window-size
 * https://leetcode.com/problems/maximum-subarray-min-product/solutions/2705681/similar-to-question-find-maximum-of-minimum-in-each-window-size-c/
 */
public class MaximumOfMinimumForEveryWindowSize {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// TODO study later
	private static void type2() {
		int[] arr = { 10, 20, 30, 50, 10, 70, 30 };
		int n = arr.length;
		// so we will consider each element and check it's span
		// in what range it is minimum
		// to determine we will compute previous smaller element and next smaller
		// element

		// previous smaller element index
		int[] stack = new int[n];
		int top = -1;
		int[] left = new int[n];
		for (int i = 0; i < n; i++) {
			while (top != -1 && arr[stack[top]] >= arr[i])
				top--;
			if (top == -1) {
				left[i] = -1;
			} else {
				left[i] = stack[top];
			}
			stack[++top] = i;
		}
		// next smaller element index
		stack = new int[n];
		top = -1;
		int[] right = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			while (top != -1 && arr[stack[top]] >= arr[i])
				top--;
			if (top == -1) {
				right[i] = n;
			} else {
				right[i] = stack[top];
			}
			stack[++top] = i;
		}
		// find the span
		int[] span = new int[n];
		for (int i = 0; i < n; i++) {
			span[i] = right[i] - left[i] - 1;
		}
		// array -> 10 20 30 50 10 70 30
		// minimum span -> 7 3 2 1 7 1 2
		// so if we look closely then
		// the span of 10 is 7 means it is smallest in the array
		// the span of 70 is 1 means it is largest in the array

		// check geeksforgeeks for this part
		int[] answer = new int[n + 1];
		for (int i = 0; i < n; i++) {
			int len = right[i] - left[i] - 1;
			answer[len] = Math.max(answer[len], arr[i]);
		}

		for (int i = n - 1; i >= 1; i--) {
			answer[i] = Math.max(answer[i], answer[i + 1]);
		}
		print(answer);
	}

	private static void type1() {
		int[] arr = { 10, 20, 30, 50, 10, 70, 30 };
		int n = arr.length;
		int[] answer = new int[n];
		// k is the size of the window
		for (int k = 1; k <= n; k++) {
			int max = Integer.MIN_VALUE;
			// we will compute the maximum of the minimum of all windows of size k
			for (int i = 0; i <= n - k; i++) {
				int windowMin = Integer.MAX_VALUE, start = i;
				// we will compute the minimum of current window
				while (start - i < k) {
					windowMin = Math.min(windowMin, arr[start++]);
				}
				max = Math.max(max, windowMin);
			}
			answer[k - 1] = max;
		}
		print(answer);
	}

}
