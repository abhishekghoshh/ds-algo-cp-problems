package problems.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

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
		int length = histogram.length;
		int maxArea = 0, area;
	}

	// time complexity o(4n)
	// space complexity o(4n)
	private static void type3() {
		int[] histogram = { 1, 3, 2, 4, 3, 5, 3 };
		int length = histogram.length;
		int maxArea = 0, area, rightSmallestIndex;
		// time complexity o(2n) and space complexity o(2n) to compute this
		List<Integer> leftVertices = leftSmallestVertices(histogram, length);

		// we will find the right smallest vertices and calculate the area
		// in the same loop
		Stack<Integer> stack = new Stack<>();
		for (int i = length - 1; i >= 0; i--) {
			if (stack.size() == 0) {
				rightSmallestIndex = length;
			} else {
				if (histogram[stack.peek()] < histogram[i]) {
					rightSmallestIndex = stack.peek();
				} else {
					while (stack.size() > 0 && histogram[stack.peek()] >= histogram[i]) {
						stack.pop();
					}
					if (stack.size() == 0) {
						rightSmallestIndex = length;
					} else {
						rightSmallestIndex = stack.peek();
					}
				}
			}
			stack.add(i);
			area = (rightSmallestIndex - leftVertices.get(i) - 1) * histogram[i];
			maxArea = Math.max(maxArea, area);
		}
		System.out.println("Max area of histogram is " + maxArea);
	}

	// time complexity o(5n)
	// space complexity o(4n)
	private static void type2() {
		int[] histogram = { 1, 3, 2, 4, 3, 5, 3 };
		int length = histogram.length;
		int maxArea = 0, area;
		// time complexity o(2n) and space complexity o(2n) to compute this
		List<Integer> leftVertices = leftSmallestVertices(histogram, length);
		// time complexity o(2n) and space complexity o(2n) to compute this
		List<Integer> rightVertices = rightSmallestVertices(histogram, length);
		// O(n) to compute this
		for (int i = 0; i < length; i++) {
			area = (rightVertices.get(i) - leftVertices.get(i) - 1) * histogram[i];
			maxArea = Math.max(maxArea, area);
		}
		System.out.println("Max area of histogram is " + maxArea);
	}

	private static List<Integer> rightSmallestVertices(int[] histogram, int length) {
		List<Integer> vertices = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		for (int i = length - 1; i >= 0; i--) {
			if (stack.size() == 0) {
				vertices.add(length);
			} else {
				if (histogram[stack.peek()] < histogram[i]) {
					vertices.add(stack.peek());
				} else {
					while (stack.size() > 0 && histogram[stack.peek()] >= histogram[i]) {
						stack.pop();
					}
					if (stack.size() == 0) {
						vertices.add(length);
					} else {
						vertices.add(stack.peek());
					}
				}
			}
			stack.add(i);
		}
		Collections.reverse(vertices);
		return vertices;
	}

	private static List<Integer> leftSmallestVertices(int[] histogram, int length) {
		List<Integer> vertices = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < length; i++) {
			if (stack.size() == 0) {
				vertices.add(-1);
			} else {
				if (histogram[stack.peek()] < histogram[i]) {
					vertices.add(stack.peek());
				} else {
					while (stack.size() > 0 && histogram[stack.peek()] >= histogram[i]) {
						stack.pop();
					}
					if (stack.size() == 0) {
						vertices.add(-1);
					} else {
						vertices.add(stack.peek());
					}
				}
			}
			stack.add(i);
		}
		return vertices;
	}

	private static void type1() {
		int[] histogram = { 1, 3, 2, 4, 3, 5, 3 };
		int length = histogram.length;
		int maxArea = 0, area, left, right;
		for (int i = 0; i < length; i++) {
			left = right = i;
			while (left > 0 && histogram[left - 1] > histogram[i]) {
				left--;
			}
			while (right < length - 1 && histogram[right + 1] > histogram[i]) {
				right++;
			}
			area = (right - left + 1) * histogram[i];
			maxArea = Math.max(maxArea, area);
		}
		System.out.println("Max area of histogram is " + maxArea);
	}
}
