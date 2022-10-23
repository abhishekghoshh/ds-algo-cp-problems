package problems.stack;

import java.util.Stack;

/*
 * Problem link :
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * https://www.codingninjas.com/codestudio/problems/1058184?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link :
 * Aditya verma
 * https://www.youtube.com/watch?v=J2X70jj_I1o&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=7
 * 
 * Striver
 * https://www.youtube.com/watch?v=X0X6G-eWgQ8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=82
 * https://www.youtube.com/watch?v=jC_cWLy7jSI&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=83
 * 
 * */
//TODO study https://leetcode.com/submissions/detail/828537886/
public class MaximumAreaOfHistogram {
	// for every index we will check how much the current height can spread out
	// let's take the heights as 1 4 2 6 3 1
	// and we are at 2 so in left will spread till 4 and in right till 3
	public static void main(String args[]) {
		type1();
		type2();
		type3();
		type4();
	}

	private static void type4() {
		int[] histogram = { 1, 3, 2, 4, 3, 5, 3 };
		int n = histogram.length;
		int max = 0, area;
	}

	// time complexity o(4n)
	// space complexity o(4n)
	private static void type3() {
		int[] heights = { 1, 3, 2, 4, 3, 5, 3 };
		int n = heights.length;
		int max = 0, area, right;
		// time complexity o(2n) and space complexity o(2n)
		// to compute left smaller index
		int[] left = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				left[i] = -1;
			} else {
				left[i] = stack.peek();
			}
			stack.add(i);
		}

		// we will find the right smaller vertices and calculate the area
		// in the same loop
		// time complexity o(2n) and space complexity o(2n)
		// to compute right smaller index and are
		stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (stack.size() > 0 && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}
			if (stack.size() == 0) {
				right = n;
			} else {
				right = stack.peek();
			}
			stack.add(i);
			area = (right - left[i] - 1) * heights[i];
			max = Math.max(max, area);
		}
		System.out.println("Max area of histogram is " + max);
	}

	// time complexity o(5n)
	// space complexity o(4n)
	// we will find previous smaller index and
	private static void type2() {
		int[] histogram = { 1, 3, 2, 4, 3, 5, 3 };
		int n = histogram.length, max = 0, area;
		// time complexity o(2n) and space complexity o(2n)
		// to compute left smaller index
		int[] left = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				left[i] = -1;
			} else {
				left[i] = stack.peek();
			}
			stack.add(i);
		}
		// time complexity o(2n) and space complexity o(2n)
		// to compute right smaller index
		int[] right = new int[n];
		stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (stack.size() > 0 && histogram[stack.peek()] >= histogram[i]) {
				stack.pop();
			}
			if (stack.size() == 0) {
				right[i] = n;
			} else {
				right[i] = stack.peek();
			}
			stack.add(i);
		}
		// O(n) to compute this
		for (int i = 0; i < n; i++) {
			area = (right[i] - left[i] - 1) * histogram[i];
			max = Math.max(max, area);
		}
		System.out.println("Max area of histogram is " + max);
	}

	// brute force approach
	private static void type1() {
		int[] histogram = { 1, 3, 2, 4, 3, 5, 3 };
		int length = histogram.length;
		int max = 0, area, left, right;
		for (int i = 0; i < length; i++) {
			left = right = i;
			while (left > 0 && histogram[left - 1] > histogram[i]) {
				left--;
			}
			while (right < length - 1 && histogram[right + 1] > histogram[i]) {
				right++;
			}
			area = (right - left + 1) * histogram[i];
			max = Math.max(max, area);
		}
		System.out.println("Max area of histogram is " + max);
	}
}
