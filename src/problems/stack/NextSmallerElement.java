package problems.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
 * Problem link :
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=nc1AYFyvOR4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=5
 * 
 * */
public class NextSmallerElement {
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
		Stack<Integer> stack = new Stack<>();
		int m = n;
		int[] answer = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() >= arr[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				answer[--m] = -1;
			} else {
				answer[--m] = stack.peek();
			}
			stack.add(arr[i]);
		}
		print(arr);
		print(answer);
		
	}

	// same as next greater element
	private static void type2() {
		int[] arr = { 1, 3, 2, 4, 3, 3 };
		int n = arr.length;
		Stack<Integer> stack = new Stack<>();
		int m = n;
		int[] answer = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			if (stack.isEmpty()) {
				answer[--m] = -1;
			} else {
				if (stack.peek() < arr[i]) {
					answer[--m] = stack.peek();
				} else {
					while (!stack.isEmpty() && stack.peek() >= arr[i]) {
						stack.pop();
					}
					if (stack.isEmpty()) {
						answer[--m] = -1;
					} else {
						answer[--m] = stack.peek();
					}
				}
			}
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
