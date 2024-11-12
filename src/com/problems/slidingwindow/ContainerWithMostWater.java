package com.problems.slidingwindow;
/*
 * problem link:
 * https://leetcode.com/problems/container-with-most-water/description/
 * https://neetcode.io/problems/max-water-container
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=UuiTKBwPgAo
 * https://www.youtube.com/watch?v=B-RAGAcNA24
 * https://www.youtube.com/watch?v=Uj3gJjg6SXc
 * https://www.youtube.com/watch?v=6PrIRPpTI9Q
 *
 * Blog :
 *
 *
 * Tags :
 * Two-Pointers
 * */
public class ContainerWithMostWater {

	
	public static void main(String[] args) {
		type1();
		type2();
	}

	// try to solve it with the greedy approach
	private static void type2() {
	}


	// TODO two pointer approach
	// The idea is to calculate most watered single container
	// we don't meed to find it for using multiple containers with different height
	// lets say the heights are 1 5 4 6 2
	// if we consider start at 1 and end at 1 then max water can be stored is
	// 1 to 5 -> 1 unit, 5 to 6 -> 10 unit, 6 to 2 -> 2 unit
	// but we will only take that continuous water
	// so we will assume from 5 to 6 it it 1 and from 6 to 2 it is also 1
	// we will take the minimum height of the left and right side, and make that as the overall height
	// so we will now take two pointer left and right
	// and we will try to calculate the water in between
	// and then we will shrink the container size
	private static void type1() {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int left = 0, right = height.length - 1;
		int max = Integer.MIN_VALUE;
		int water, h;
		while (left < right) {
			int w = right - left;
			// if the height on the left side is small then we take that height as overall height
			// else we will take from the right, and will shrink the left or side accordingly
			h = (height[left] < height[right]) ? height[left++] : height[right--];
			water = w * h;
			max = Math.max(max, water);
		}
		System.out.println(max);

	}

}
