package com.ds.slidingwindow;
/*
 * problem link:
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * Solution link :
 * 
 * Blog :
 * 
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
	// lets say the heights are 1 5 4 6 1
	// the max water can be stored is
	// 1 to 5 -> 1 unit
	// 5 to 6 -> 10 unit
	// 6 to 1 -> 1 unit
	// but we will only take that continuous water
	// from 5 to 6
	// so we will now take two pointer left and right
	// and we will try to calculate the water in between
	// and then we will shrink the container size
	private static void type1() {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int left = 0;
		int right = height.length - 1;
		int max = Integer.MIN_VALUE;
		while (left < right) {
			if (height[right] > height[left]) {
				max = Math.max(max, (right - left) * height[left]);
				left++;
			} else {
				max = Math.max(max, (right - left) * height[right]);
				right--;
			}
		}
		System.out.println(max);

	}

}
