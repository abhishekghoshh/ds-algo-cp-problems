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
 * https://neetcode.io/solutions/container-with-most-water
 * */

// Tags: Array, Two pointer, greedy
public class ContainerWithMostWater {

	
	public static void main(String[] args) {
		type1();
		type2();
	}

	// This is exactly same as the type1, but here we are just simplifying the code a bit
	// so the logic remains the same, we will take two pointers left and right and then we will calculate the water in between,
	// and then we will shrink the container size,
	// on every 2 pointers we will calculate the water, and then we will take the max of that water and the previous max
	// so there is height on left and right pointer both.
	// We will increase the left pointer if the height of left is less than or equal to the height of right, else we will decrease the right pointer
	// because if left is smaller than by shilfting the left pointer we might get a bigger height and hence bigger water,
	// We will move the shorter wall, as the area is limited by the shorter wall, so we need to find a taller wall to increase the area.
	private static void type2() {
		int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
		int max = maxArea2(height);
		System.out.println(max);
	}

	private static int maxArea2(int[] height) {
		int n = height.length;
		int left = 0, right = n - 1;
		int w, h;
		int max = 0;
		while (left < right) {
			w = right - left;
			h = Math.min(height[left], height[right]);
			max = Math.max(max, w * h);
			if (height[left] <= height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return max;
	}

	// TODO two pointer approach
	//  if there is a bar in the left and another one in the right, the resultant height will be lesser height among them
	//  in that way if the left is chosen then we will increment left else we will decrement right
	//  The idea is to calculate most watered single container
	//  we don't meed to find it for using multiple containers with different height
	//  lets say the heights are 1 5 4 6 2
	//  if we consider start at 1 and end at 1 then max water can be stored is
	//  1 to 5 -> 1 unit, 5 to 6 -> 10 unit, 6 to 2 -> 2 unit
	//  but we will only take that continuous water
	//  so we will assume from 5 to 6 it it 1 and from 6 to 2 it is also 1
	//  we will take the minimum height of the left and right side, and make that as the overall height
	//  so we will now take two pointer left and right
	//  and we will try to calculate the water in between and then we will shrink the container size
	private static void type1() {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int max = maxArea1(height);
		System.out.println(max);

	}

	private static int maxArea1(int[] height) {
		int n = height.length;
		int max = 0;
		int left = 0, right = n - 1;
		while (left < right) {
			int width = right - left;
			int waterHeight;
			// if there is a bar in the left and another one in the right, the resultant height will be lesser height among them
			// in that way if the left is chosen then we will increment left else we will decrement right
			if (height[left] <= height[right]) {
				waterHeight = height[left++]; // increment left boundary
			} else {
				waterHeight = height[right--]; // decrement right boundary
			}
			// water in that area would be height * width
			int water = width * waterHeight;
			max = Math.max(max, water);
		}
		return max;
	}

}
