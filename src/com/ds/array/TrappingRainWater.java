package com.ds.array;

import java.util.Stack;

/*
 * problem link:
 * https://leetcode.com/problems/trapping-rain-water/
 * https://www.codingninjas.com/codestudio/problems/630519
 * https://www.codingninjas.com/studio/problems/trapping-rain-water_630519
 *
 * Solution link :
 * https://www.youtube.com/watch?v=m18Hntz4go8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=43
 * https://www.youtube.com/watch?v=FbGG2qpNp4U&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=10
 * 
 * https://takeuforward.org/data-structure/trapping-rainwater/
 * */
public class TrappingRainWater {

	public static void main(String[] args) {
		type0();
		type1();
		type2();
		type3();
		type4();
	}

	// 2 pointer approach
	// time complexity O(n)
	// space complexity O(1)
	// We need a minimum of leftMax and rightMax.So if we take the case when
	// height[l]<=height[r] we increase l++, so we can surely say that there is a
	// block with a height more than height[l] to the right of l. And for the same
	// reason when height[r]<=height[l] we can surely say that there is a block to
	// the left of r which is at least of height[r]. So by traversing these cases
	// and using two pointers approach, the time complexity can be decreased without
	// using extra space
	// TODO study it one more time
	private static void type4() {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		// int[] height = { 1, 2, 4, 1, 3, 2, 1, 3 };
		int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0, area = 0;
		while (left < right) {
			// find the lower bound among height[left] or height[right]
			// water label will always be equal to the lowest among left and right height
			if (height[left] <= height[right]) {
				// height[left] is lower, so water is trapper on the left side
				// update leftmax or ans
				if (height[left] > leftMax) leftMax = height[left];
					// height[i] is less than leftmax so water can be stored
				else area = area + (leftMax - height[left]);
				left++;
			} else {
				// height[right] is lower, so water is trapper on the right side
				// update rightmax or ans
				if (height[right] > rightMax) rightMax = height[right];
					// height[i] is less than rightmax so water can be stored
				else area = area + (rightMax - height[right]);
				right--;
			}
		}
		System.out.println("water collected " + area);
	}

	// time complexity O(2n)
	// space complexity O(n)
	// exactly similar to the previous solution
	// just for we are not creating any rightMax array
	// instead on that loop we are calculating the are
	private static void type3() {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		// int[] height = { 1, 2, 4, 1, 3, 2, 1, 3 };

		int n = height.length, tempMax, areaSum = 0;
		int[] leftMax = new int[n];
		leftMax[0] = tempMax = height[0];
		for (int i = 1; i < n; i++) {
			leftMax[i] = tempMax;
			tempMax = Math.max(tempMax, height[i]);
		}
		tempMax = height[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (height[i] < leftMax[i] && height[i] < tempMax) {
				int tempArea = (Math.min(leftMax[i], tempMax) - height[i]);
				areaSum = areaSum + tempArea;
			}
			tempMax = Math.max(tempMax, height[i]);
		}
		System.out.println("water collected " + areaSum);
	}

	// prefix and suffix max array
	// time complexity O(3n)
	// space complexity O(2n)
	// on every index we are calculating it left the highest wall and right highest wall
	// the water height on each block will be equal to the minimum of left highest and
	// right highest wall
	// there will be no water on 0th wall and n-1th wall
	private static void type2() {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		// int[] height = { 1, 2, 4, 1, 3, 2, 1, 3 };

		int n = height.length, tempMax, areaSum = 0;
		int[] leftMax = new int[n];
		int[] rightMax = new int[n];

		tempMax = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) leftMax[i] = tempMax = Math.max(tempMax, height[i]);
		tempMax = Integer.MIN_VALUE;
		for (int i = n - 1; i >= 0; i--) rightMax[i] = tempMax = Math.max(tempMax, height[i]);

		int tempArea;
		for (int i = 1; i < n - 1; i++) {
			if (height[i] < leftMax[i] && height[i] < rightMax[i]) {
				tempArea = Math.min(leftMax[i], rightMax[i]) - height[i];
				areaSum = areaSum + tempArea;
			}
		}
		System.out.println("water collected " + areaSum);
	}

	// brute force approach
	// for every wall we are calculating its left max height and right max height
	// O(n^2) time complexity
	// there will be no water on 0th wall and n-1th wall
	private static void type1() {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		// int[] height = { 1, 2, 4, 1, 3, 2, 1, 3 };
		int n = height.length, leftMax, rightMax, areaSum = 0;
		for (int i = 1; i < n - 1; i++) {
			leftMax = rightMax = Integer.MIN_VALUE;
			for (int j = i - 1; j >= 0; j--) {
				if (height[j] > leftMax) {
					leftMax = height[j];
				}
			}
			for (int j = i + 1; j < n; j++) {
				if (height[j] > rightMax) {
					rightMax = height[j];
				}
			}
			if (height[i] < Math.min(leftMax, rightMax)) {
				areaSum = areaSum + Math.min(leftMax, rightMax) - height[i];
			}
		}
		System.out.println("water collected " + areaSum);
	}

	// using stack
	private static void type0() {
		int[] height = {1, 2, 4, 1, 3, 2, 1, 3};
		int ans = 0;
		Stack<Integer> st = new Stack<>();
		for (int right = 0; right < height.length; right++) {
			while (!st.isEmpty() && (height[right] > height[st.peek()])) {
				int top = st.pop();
				int left = (st.isEmpty()) ? -1 : st.peek();
				if (!st.isEmpty())
					ans += (Math.min(height[right], height[st.peek()]) - height[top]) * (right - left - 1);
			}
			st.push(right);
		}
	}
}
