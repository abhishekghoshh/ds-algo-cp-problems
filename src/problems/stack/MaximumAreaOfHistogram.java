package problems.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MaximumAreaOfHistogram {
	public static void main(String args[]) {
		type1();
	}

	private static void type1() {
		int[] histogram = { 1, 3, 2, 4, 3, 5, 3 };
		int length = histogram.length;
		int maxArea = 0, area;
		List<Integer> leftVertices = leftSmallestVertices(histogram, length);
		List<Integer> rightVertices = rightSmallestVertices(histogram, length);
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
}
