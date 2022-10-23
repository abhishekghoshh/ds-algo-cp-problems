package problems.stack;

import java.util.Stack;

/*
 * Problem link :
 * https://leetcode.com/problems/maximal-rectangle/submissions/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=St0Jf_VmG_g&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=8
 * 
 * */
//TODO study https://leetcode.com/submissions/detail/828547688/
public class MaxRectangularAreaOfBinaryMatrix {
	public static void main(String args[]) {
		type1();
		type2();
	}

	private static void type2() {
		int[][] matrix = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
		int m = matrix.length, n = matrix[0].length;
		int[] histogram = new int[n];
		int maxArea = 0;
		for (int i = 0; i < m; i++) {
			// we will update the histogram on each iteration
			// and add the current row to the histogram
			for (int j = 0; j < n; j++) {
				// if the cell is zero then it has no point of adding previous
				// so we set it to 0
				// else we will add 1 to the height
				histogram[j] = matrix[i][j] == 0 ? 0 : histogram[j] + 1;
			}
			maxArea = Math.max(maxArea, maxAreaOfHistogram(histogram, n));
		}
		System.out.println(maxArea);
	}

	private static int maxAreaOfHistogram(int[] histogram, int n) {
		int max = 0, area, right;
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
		stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (stack.size() > 0 && histogram[stack.peek()] >= histogram[i]) {
				stack.pop();
			}
			if (stack.size() == 0) {
				right = n;
			} else {
				right = stack.peek();
			}
			stack.add(i);
			area = (right - left[i] - 1) * histogram[i];
			max = Math.max(max, area);
		}
		return max;
	}

	// brute force approach
	private static void type1() {

	}

}
