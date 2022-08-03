package problems.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MaximumAreaOfHistogram {
	public static void main(String args[]) {
		Integer[] histogram = { 1, 3, 2, 4, 3, 5, 3 };
		int length = histogram.length;
		int maxAreaOfHistogram = maxAreaOfHistogram(histogram, length);
		System.out.println(maxAreaOfHistogram);
	}

	public static int maxAreaOfHistogram(Integer[] histogram, int length) {
		System.out.println(Arrays.asList(histogram));
		List<Integer> leftVertices = leftSmallestVertices(histogram, length);
		System.out.println(leftVertices);
		List<Integer> rightVertices = rightSmallestVertices(histogram, length);
		System.out.println(rightVertices);
		List<Integer> areas = areaCalculation(histogram, leftVertices, rightVertices, length);
		System.out.println(areas);
		int maxAreaOfHistogram = max(areas, length);
		return maxAreaOfHistogram;
	}

	private static List<Integer> areaCalculation(Integer[] histogram, List<Integer> leftVertices,
			List<Integer> rightVertices, int length) {
		List<Integer> areas = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			int width = rightVertices.get(i) - leftVertices.get(i) - 1;
			areas.add(width * histogram[i]);
		}
		return areas;
	}

	private static int max(List<Integer> areas, int length) {
		int maxArea = 0;
		for (int i = 0; i < length; i++) {
			if (areas.get(i) > maxArea) {
				maxArea = areas.get(i);
			}
		}
		return maxArea;
	}

	private static List<Integer> rightSmallestVertices(Integer[] histogram, int length) {
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

	private static List<Integer> leftSmallestVertices(Integer[] histogram, int length) {
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
