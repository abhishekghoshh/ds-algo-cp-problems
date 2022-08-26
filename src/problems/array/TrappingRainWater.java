package problems.array;

import java.util.Stack;

/*
 * problem link:
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * */
public class TrappingRainWater {

	public static void main(String[] args) {
		type1();
		type2();
	}
	//TODO
	private static void type2() {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int n = height.length;
		Stack<Integer> stack = new Stack<>();
		stack.add(-1);
		int leftMax = height[0];
		for (int i = 0; i < n; i++) {
			if (leftMax < height[i]) {
				stack.add(i);
				leftMax = height[i];
			}
		}
		int right = n - 1, left, waterHeight, water = 0;
		while (stack.peek() != -1) {
			left = stack.pop();
			waterHeight = Math.min(height[left], height[right]);
			for (int i = left + 1; i < right; i++) {
				water = water + waterHeight - height[i];
			}
			right = left;
		}
		System.out.println(water);
	}

	private static void type1() {
		// TODO Auto-generated method stub

	}
}
