package problems.stack;

import java.util.Stack;

/*
 * Problem link :
 * https://leetcode.com/problems/next-greater-element-ii
 * Secondary
 * https://leetcode.com/problems/next-greater-element-i/
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=NXOOYYwpbg4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=2
 * https://www.youtube.com/watch?v=Du881K7Jtk8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=75
 * 
 * */
public class NextGreaterElement {
	public static void main(String args[]) {
		type1();
		type2();
		type3();
		type4();
		type5();
		type6();
	}

	// TODO complete the leetcode problems
	// https://leetcode.com/problems/next-greater-element-i/
	private static void type6() {

	}

	// same as previous type4
	// here we are using array as stack instead of in build stack class of java
	private static void type5() {
		int nums[] = { 5, 7, 1, 2, 6, 0 };
		int n = nums.length;
		int answer[] = new int[n];
		int[] stack = new int[2 * n];
		int top = -1;
		// we will start from 2*n -1
		// its like we are copying the same array and append it after the original
		// so i%n will give the index which will be 0 to n-1
		for (int i = 2 * n - 1; i >= 0; i--) {
			while (top != -1 && stack[top] <= nums[i % n]) {
				top--;
			}
			if (i < n) {
				if (top != -1) {
					answer[i] = stack[top];
				} else {
					answer[i] = -1;
				}
			}
			stack[++top] = nums[i % n];
		}
		print(answer);
	}

	// this is also next greater element problem
	// but it will check circular
	// https://takeuforward.org/data-structure/next-greater-element-using-stack/
	private static void type4() {
		int nums[] = { 5, 7, 1, 2, 6, 0 };
		int n = nums.length;
		int answer[] = new int[n];
		Stack<Integer> stack = new Stack<>();
		// we will start from 2*n -1
		// its like we are copying the same array and append it after the original
		// so i%n will give the index which will be 0 to n-1
		for (int i = 2 * n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
				stack.pop();
			}
			if (i < n) {
				if (!stack.isEmpty()) {
					answer[i] = stack.peek();
				} else {
					answer[i] = -1;
				}
			}
			stack.push(nums[i % n]);
		}
		print(answer);
	}

	// same as the previous type2
	// just a little compact
	// we have reduced the unnecessary if checks
	private static void type3() {
		int[] nums = { 1, 3, 2, 4, 3, 3 };
		int n = nums.length;
		int m = n;
		int[] answer = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() <= nums[i]) {
				stack.pop();
			}
			// stack is empty that mean for the current element there is no next greater
			if (stack.isEmpty()) {
				answer[--m] = -1;
			} else {
				answer[--m] = stack.peek();
			}
			stack.add(nums[i]);
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