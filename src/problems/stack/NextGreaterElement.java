package problems.stack;

import java.util.Stack;

/*
 * Problem link :
 * 
 * Secondary
 * https://leetcode.com/problems/next-greater-element-i/
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=NXOOYYwpbg4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=2
 * 
 * */
public class NextGreaterElement {
	public static void main(String args[]) {
		type1();
		type2();
		type3();
	}

	// same as the previous type2
	// just a little compact
	// we have reduced the unnecessary if checks
	private static void type3() {
		int[] arr = { 1, 3, 2, 4, 3, 3 };
		int n = arr.length;
		int m = n;
		int[] answer = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() <= arr[i]) {
				stack.pop();
			}
			// stack is empty that mean for the current element there is no next greater
			if (stack.isEmpty()) {
				answer[--m] = -1;
			} else {
				answer[--m] = stack.peek();
			}
			stack.add(arr[i]);
		}
		print(answer);
	}

	private static void type2() {
		int[] arr = { 1, 3, 2, 4, 3, 3 };
		int n = arr.length;
		int m = n;
		int[] answer = new int[n];
		// we will use a stack to store all the previous values
		// we can also use a array an make that use as a stack
		Stack<Integer> stack = new Stack<>();
		// as here we want the next greater element so we will traverse from the last
		for (int i = n - 1; i >= 0; i--) {
			// on the first time there will be no item on stack so
			// for the right most element there will be no next greater
			if (stack.isEmpty()) {
				answer[--m] = -1;
			} else {
				if (stack.peek() > arr[i]) {
					// if the current peek is greater than the current element
					answer[--m] = stack.peek();
				} else {
					// we will pop until there is any greater element found
					while (!stack.isEmpty() && stack.peek() <= arr[i]) {
						stack.pop();
					}
					// stack is empty that mean for the current element there is no next greater
					if (stack.isEmpty()) {
						answer[--m] = -1;
					} else {
						answer[--m] = stack.peek();
					}
				}
			}
			// on each iteration we will store the current element
			stack.add(arr[i]);
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

	// brute force
	private static void type1() {

	}

}